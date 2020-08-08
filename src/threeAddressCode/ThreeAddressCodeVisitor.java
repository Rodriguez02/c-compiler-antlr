package threeAddressCode;

import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.Trees;

import app.reglasBaseVisitor;
import app.reglasParser;
import app.reglasParser.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es un visitor que luego de que el arbol queda parseado recorrera
 * el mismo para poder escribir un codigo de 3 direcciones
 */
public class ThreeAddressCodeVisitor extends reglasBaseVisitor<String> {
    // Contador de labels
    private int countLbl;
    // Contador de temporales
    private int countTmp;
    // Concatena el resultado final
    private String result;
    // Almacena el temporal anterior
    private String previousTemp;
    // Almacena el temporal actual
    private String currentTemp;

    public ThreeAddressCodeVisitor() {
        this.countLbl = 0;
        this.countTmp = 0;
        this.result = "";
        this.previousTemp = "";
        this.currentTemp = "";
    }

    @Override
    public String visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public String visitAssignment(AssignmentContext ctx) {
        if (ctx.asign() != null) {
            List<ParseTree> ruleFactors = findRuleNodes(ctx, reglasParser.RULE_factor);
            List<ParseTree> funcs = findRuleNodes(ctx, reglasParser.RULE_callfunction);
            if (ruleFactors.size() < 3 && funcs.size() == 0) {
                result += ctx.ID().getText() + " = ";
                lessThanTWo(ruleFactors);
            } else {
                processConjunctions(ctx.asign().operation().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }

        }
        return "";
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        if (ctx.asign() != null) {
            List<ParseTree> ruleFactors = findRuleNodes(ctx, reglasParser.RULE_factor);
            if (ruleFactors.size() < 3) {
                result += ctx.ID().getText() + " = ";
                lessThanTWo(ruleFactors);
            } else {
                processConjunctions(ctx.asign().operation().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }
        }
        return "";
    }

    @Override
    public String visitCondif(CondifContext ctx) {
        countLbl++;
        processConjunctions(ctx.operation().opal());
        result += "ifnot " + currentTemp + ", jmp L" + countLbl + "\n";
        if (ctx.ELSE() == null) {
            visitChildren(ctx);
        } else {
            // bloque if
            visitBlock((BlockContext) ctx.getChild(4));

            int aux = countLbl;
            countLbl++;
            result += String.format("jmp L%s\n", countLbl);
            result += String.format("label L%s\n", aux);

            // bloque else
            visitBlock((BlockContext) ctx.getChild(6));
        }
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitCyclewhile(CyclewhileContext ctx) {
        countLbl++;
        int aux = countLbl;
        processConjunctions(ctx.operation().opal());

        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", currentTemp, countLbl);

        visitChildren(ctx);

        result += String.format("jmp L%s\n", aux);
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitBlock(BlockContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCyclefor(CycleforContext ctx) {
        countLbl++;

        visitAssignment(ctx.assignment());

        int aux = countLbl;

        processConjunctions(ctx.operation().opal());
        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", currentTemp, countLbl);
        visitBlock(ctx.instruction().block());

        result += String.format("%s %s\n", ctx.ID().getText(), ctx.asign().getText());
        result += String.format("jmp L%s\n", aux);
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    @Override
    public String visitFunction(FunctionContext ctx) {
        result += String.format("func begin %s\n", ctx.ID().getText());
        visitBlock(ctx.block());
        result += String.format("%s end\n", ctx.ID().getText());
        return "";
    }

    @Override
    public String visitRetorno(RetornoContext ctx) {
        processConjunctions(ctx.opal());
        result += String.format("return %s\n", currentTemp);
        return "";
    }

    @Override
    public String visitCallfunction(CallfunctionContext ctx) {
        if (ctx.arguments().operation().opal().getChildCount() > 0) {
            List<ParseTree> args = findRuleNodes(ctx, reglasParser.RULE_operation);
            for (ParseTree a : args) {
                processConjunctions(((OperationContext) a).opal());
                result += String.format("param %s\n", currentTemp);
            }
            result += String.format("t%d = call %s, %d\n", countTmp, ctx.ID().getText(), args.size());
        } else {
            result += String.format("t%d = call %s\n", countTmp, ctx.ID().getText());
        }
        countTmp++;
        return "";
    }

    /**
     * Obtengo un subarbol en formato ArrayList segun la regla que especifiquemos
     */
    private List<ParseTree> findRuleNodes(ParseTree ctx, int ruleIndex) {
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }

    /**
     * Muestro el codigo de tres direcciones por pantalla
     */
    public void getResult() {
        System.out.println(result);
    }

    /**
     * Concatena los temporales anteriores y actuales pasandole la operacion que hay
     * en el medio
     */
    private void concatTemps(String operation) {
        result += String.format("t%d = %s %s %s \n", countTmp, previousTemp, operation, currentTemp);
        currentTemp = "t" + countTmp;
        countTmp++;
    }

    /**
     * Obtengo todas las reglas sin tener en cuanta las que son opal
     */
    public void findRuleNodesWithoutOpal(ParseTree t, int index, List<ParseTree> nodes) {
        if (t instanceof ParserRuleContext) {
            ParserRuleContext ctx = (ParserRuleContext) t;
            if (ctx.getRuleIndex() == index) {
                nodes.add(t);
            }
        }
        for (int i = 0; i < t.getChildCount(); i++) {
            if (!(t.getChild(i) instanceof OpalContext)) {
                findRuleNodesWithoutOpal(t.getChild(i), index, nodes);
            }
        }
    }

    /**
     * Usa el String con el resultado concatenado para almacenarlo en un archivo
     */
    public void generateCode() {
        try {
            PrintWriter out;
            out = new PrintWriter("intermediate-code.txt");
            out.println(this.result);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Si los terminos son menos que dos y los mismos son sumple entonces
     * solo se imprime ya que el codigo de tres direcciones admite 
     * una asignacion o declaracion de esta forma: y = 7 + x, entonces no tenemos
     * la necesidad de analizar todos los terminos
     */
    private void lessThanTWo(List<ParseTree> ruleFactors){
        for (ParseTree parseTree : ruleFactors) {
            FactorContext fc = ((FactorContext)parseTree);
            if(fc.getParent().getParent() instanceof ExpContext){
                result += fc.getParent().getParent().getChild(0).getText() + " " + fc.getParent().getChild(0).getText() + "\n";
            } else if(fc.getParent() instanceof TerContext){
                result += fc.getParent().getChild(0).getText() + " " + fc.getText() + "\n";   
            } else {
                result += fc.getParent().getChild(0).getText() + (ruleFactors.size() == 1 ? "\n" : " ");
            }
        }
    }

    /**
     * Esta funcion es llamada recursivamente para procesar las conjunciones
     * y de esta forma ir agregando los temporales al codigo intermedio de acuerdo
     * a la operacion que involucra 
     */
    private void processConjunctions(OpalContext ctx) {
        List<ParseTree> conjunctions = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_conjunction, conjunctions);
        String temp;
        for (int i = 0; i < conjunctions.size(); i++) {
            temp = currentTemp;
            processComparisons((ConjunctionContext) conjunctions.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(conjunctions.get(i).getParent().getChild(0).getText());
            }
        }
    }

    /**
     * Esta funcion es llamada recursivamente para procesar las comparaciones
     * y de esta forma ir agregando los temporales al codigo intermedio de acuerdo
     * a la operacion que involucra 
     */
    private void processComparisons(ConjunctionContext ctx) {
        List<ParseTree> comparisons = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_comparison, comparisons);
        String temp;
        for (int i = 0; i < comparisons.size(); i++) {
            temp = currentTemp;
            processExpressions((ComparisonContext) comparisons.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(comparisons.get(i).getParent().getChild(0).getText());
            }
        }
    }

    /**
     * Esta funcion es llamada recursivamente para procesar las expresiones
     * y de esta forma ir agregando los temporales al codigo intermedio de acuerdo
     * a la operacion que involucra 
     */
    private void processExpressions(ComparisonContext ctx) {
        List<ParseTree> exps = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_expression, exps);
        String temp;
        for (int i = 0; i < exps.size(); i++) {
            temp = currentTemp;
            processTerms((ExpressionContext) exps.get(i));
            previousTemp = temp;
            if (i > 0) {
                concatTemps(exps.get(i).getParent().getChild(0).getText());
            }
        }
    }

    /**
     * Esta funcion genera los temporales en cada termino, verifica que foma
     * tiene el termino (si son id, conjuciones o una funcion) y apartir de alli
     * mueve los temporales previos y actuales
     */
    private void generateTempsInTerm(Collection<ParseTree> factors) {
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;
        for(int i=0; i < factorsLocal.size(); i++){
            if(((FactorContext)factorsLocal.get(i)).opal() != null){
                temp = currentTemp;
                processConjunctions(((FactorContext) factorsLocal.get(i)).opal());
                previousTemp = temp;
            } else if(((FactorContext)factorsLocal.get(i)).callfunction() != null){
                temp = currentTemp;
                visitCallfunction(((FactorContext)factorsLocal.get(i)).callfunction());
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1);
            } else {
                previousTemp = currentTemp;
                currentTemp = factorsLocal.get(i).getText();
            }
            if (i > 0) {
                concatTemps(factorsLocal.get(i).getParent().getChild(0).getText());
            }
        }
    }

    /**
     * Procesa cada uno de los terminos verificando el tamaño de cada uno y concatenando
     * los temporales y llamando a la funcion que genera los mismo generateTempsInTerm()
     */
    private void processTerms(ExpressionContext ctx) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_term, ruleTerms);
        String temp;

        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        for (int i = 0; i < terms.size(); i++) {
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodesWithoutOpal(terms.get(i), reglasParser.RULE_factor, factors);

            if (factors.size() > 1) {
                temp = currentTemp;
                generateTempsInTerm(factors);
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1);
            } else {
                previousTemp = currentTemp; 
                if (((TermContext) terms.get(i)).factor().opal() != null) {
                    temp = currentTemp;
                    processConjunctions(((TermContext) terms.get(i)).factor().opal());
                    previousTemp = temp;
                }else if(((TermContext)terms.get(i)).factor().callfunction() != null){
                    temp = currentTemp;
                    visitCallfunction(((TermContext) terms.get(i)).factor().callfunction());
                    previousTemp = temp;
                    currentTemp = "t" + (countTmp - 1);
                }
                else {
                    currentTemp = factors.get(0).getText();
                }
            }
            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }
}