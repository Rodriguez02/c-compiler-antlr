package threeAddressCode;

import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.Trees;

import app.reglasBaseVisitor;
import app.reglasParser;
import app.reglasParser.*;
import java.util.ArrayList;
import java.util.List;

public class ThreeAddressCodeVisitor extends reglasBaseVisitor<String> {
    private String IFN;
    private String LBL;
    private String JMP;
    private int countLbl;
    private int countTmp;
    private String result;
    private String previousTemp;
    private String currentTemp;

    public ThreeAddressCodeVisitor() {
        this.IFN = "ifnot";
        this.LBL = "label";
        this.JMP = "jmp";
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
            // result += ctx.ID().getText() + " = ";
            processConjunctions(ctx.asign().operation().opal());
        }

        return "";
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        if (ctx.asign() != null) {
            result += ctx.ID().getText() + " = " + "\n";
            processConjunctions(ctx.asign().operation().opal());
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
            result += "jmp L" + countLbl + "\n";
            result += "label L" + aux + "\n";

            // bloque else
            visitBlock((BlockContext) ctx.getChild(6));

        }
        result += "label L" + countLbl + "\n";
        result += "\n";

        return "";
    }

    @Override
    public String visitCyclewhile(CyclewhileContext ctx) {
        countLbl++;

        int aux = countLbl;
        result += "label L" + countLbl + "\n";
        countLbl++;
        result += "ifnot " + ctx.operation().getText() + ", jmp L" + countLbl + "\n";
        visitChildren(ctx);
        result += "jmp L" + aux + "\n";
        result += "label L" + countLbl + "\n";

        result += "\n";

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
        result += "label L" + countLbl + "\n";
        countLbl++;
        result += "ifnot " + ctx.operation().getText() + ", jmp L" + countLbl + "\n";
        visitBlock(ctx.instruction().block());

        result += ctx.ID().getText() + " " + ctx.asign().getText() + "\n";

        result += "jmp L" + aux + "\n";
        result += "label L" + countLbl + "\n";

        result += "\n";

        return "";
    }

    public void getResult() {
        System.out.println(result);
    }

    // Esta funcion concate los temporales anteriores y actuales pasandole la
    // operacion entre medio
    private void concatTemps(String operation) {
        result += String.format("t%d = %s %s %s \n", countTmp, previousTemp, operation, currentTemp);
        currentTemp = "t" + countTmp;
        countTmp++;
    }

    public void findRuleNodesWithoutOpal(ParseTree t, int index, List<ParseTree> nodes) {
        if (t instanceof ParserRuleContext) {
            ParserRuleContext ctx = (ParserRuleContext) t;
            if (ctx.getRuleIndex() == index) {
                nodes.add(t);
            }
        }
        // check children
        for (int i = 0; i < t.getChildCount(); i++) {
            if (!(t.getChild(i) instanceof OpalContext)) {
                findRuleNodesWithoutOpal(t.getChild(i), index, nodes);
            }
        }
    }

    private Collection<ParseTree> findOpalWithoutTerms(ParseTree ctx) {
        Collection<ParseTree> terms = Trees.findAllRuleNodes(ctx, reglasParser.RULE_term);
        // System.out.println("Term Size: "+terms.size());
        Collection<ParseTree> opals = Trees.findAllRuleNodes(ctx, reglasParser.RULE_opal);

        // opals.remove(opals.toArray()[0]);

        // System.out.println("Opal size: " + opals.size() );
        Collection<ParseTree> termsInOpal;
        for (ParseTree o : opals) {
            if (((OpalContext) o).getParent() instanceof FactorContext) {
                termsInOpal = Trees.findAllRuleNodes(o, reglasParser.RULE_term);
                terms.removeAll(termsInOpal);
            }
        }
        return terms;
    }

    private Collection<ParseTree> findOpalWithoutFactors(ParseTree ctx) {
        Collection<ParseTree> factors = Trees.findAllRuleNodes(ctx, reglasParser.RULE_factor);
        // System.out.println("Term Size: "+terms.size());
        Collection<ParseTree> opals = Trees.findAllRuleNodes(ctx, reglasParser.RULE_opal);

        // opals.remove(opals.toArray()[0]);

        // System.out.println("Opal size: " + opals.size() );
        Collection<ParseTree> factorsInOpal;
        for (ParseTree o : opals) {
            if (((OpalContext) o).getParent() instanceof FactorContext) {
                factorsInOpal = Trees.findAllRuleNodes(o, reglasParser.RULE_factor);
                factors.removeAll(factorsInOpal);
            }
        }
        return factors;
    }

    private void processConjunctions(OpalContext ctx) {
        List<ParseTree> conjunctions = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_conjunction, conjunctions);
        String temp;
        for (int i = 0; i < conjunctions.size(); i++) {
            temp = currentTemp;
            processComparisons((ConjunctionContext) conjunctions.get(i));
            previousTemp = temp;
            // currentTemp = temp;
            if (i > 0) {
                concatTemps(conjunctions.get(i).getParent().getChild(0).getText());
            }
        }

    }

    private void processComparisons(ConjunctionContext ctx) {
        List<ParseTree> comparisons = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_comparison, comparisons);
        String temp;
        for (int i = 0; i < comparisons.size(); i++) {
            temp = currentTemp;
            processExpressions((ComparisonContext) comparisons.get(i));
            previousTemp = temp;
            // currentTemp = temp;
            if (i > 0) {
                concatTemps(comparisons.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void processExpressions(ComparisonContext ctx) {
        List<ParseTree> exps = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_expression, exps);
        String temp;
        boolean isOneExp = exps.size() == 1 ? true : false;
        for (int i = 0; i < exps.size(); i++) {
            temp = currentTemp;
            processTerms((ExpressionContext) exps.get(i), isOneExp);
            previousTemp = temp;
            // currentTemp = temp;
            if (i > 0) {
                concatTemps(exps.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void generateTempsInTerm(Collection<ParseTree> factors) {
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;

        for (int i = 0; i < factorsLocal.size(); i++) {

            // si es opal guardar el ultimo termporal
            if (((FactorContext) factorsLocal.get(i)).opal() != null) {
                temp = currentTemp;
                processConjunctions(((FactorContext) factorsLocal.get(i)).opal());
                previousTemp = temp;
                // currentTemp = "t" + (countTmp - 1);
            } else {
                // sino guardar el valor
                previousTemp = currentTemp;
                currentTemp = factorsLocal.get(i).getText();
            }
            if (i > 0) {
                concatTemps(factorsLocal.get(i).getParent().getChild(0).getText());
            }
        }
    }

    private void processTerms(ExpressionContext ctx, boolean isOneExp) {
        List<ParseTree> ruleTerms = new ArrayList<ParseTree>();
        findRuleNodesWithoutOpal(ctx, reglasParser.RULE_term, ruleTerms);
        String temp;

        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        for (int i = 0; i < terms.size(); i++) {
            // Lista de factores de ese termino 'i' 9 * 8 / 2 -> [9,8,2]
            List<ParseTree> factors = new ArrayList<ParseTree>();
            findRuleNodesWithoutOpal(terms.get(i), reglasParser.RULE_factor, factors);

            // Si tiene mas de un factor -> 9 * 8 / 2
            if (factors.size() > 1) {
                temp = currentTemp;
                generateTempsInTerm(factors); // Genero los temporales
                // t0 = 9 * 8
                // t1 = t0 / 2

                previousTemp = temp; // almaceno en un auxiliar el temporal actual

                currentTemp = "t" + (countTmp - 1);
            } else {
                previousTemp = currentTemp; // almaceno en un auxiliar el temporal actual
                if (((TermContext) terms.get(i)).factor().opal() == null) {
                    currentTemp = factors.get(0).getText(); // el actual es el primero de la lista 9 -> 9 + 1
                    if (terms.size() == 1 && isOneExp) { // cuando hay un termino y un factor, ej --> y = 9;
                        result += currentTemp + "\n";
                    }
                } else {
                    temp = currentTemp;
                    processConjunctions(((TermContext) terms.get(i)).factor().opal());
                    previousTemp = temp;
                }
            }
            if (i > 0) { // si no es el primer termino
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }
}

/*
 * - cuando los terminos son mayores o iguales que 3 - agregar temporales (ok) -
 * propiedad distributiva no se hace bien - (9 * 8) * 4 --> No imprime el 4 - 4
 * * (9 * 8) --> No imprime bien el termino (Sugerencia Joseniana es el
 * generarTemps())
 * 
 * - asignacion - if - while - for - funciones
 * 
 * - cuando el opal es el unico termino x = ( 9 + 1 ) x = 4 + ( 9 * 2) + 5 no
 * esta contemplado el proceso de un unico termino
 * 
 * - el igual no hace falta imprimirlo viene con la regla - guardar en un
 * archivo
 * 
 * int main(){ int x; int y = 0; --> y = 0 int z = 1; --> z = 1
 * 
 * x = y + z; --> x = y + z
 * 
 * if (x < 0){ --> ifnot x < 0, jmp L1 x = x + 1; --> x = x + 1 --> jmp L2 }
 * else{ --> label L1 x = x + 2; --> x = x + 2 } --> label L2
 * 
 * --> label L3 while(x < 0){ --> ifnot x < 0, jmp L4 x = x + 1; --> x = x + 1
 * --> jmp L3 } --> label L4
 * 
 * int i;
 * 
 * for(i=0; i<10 ; i=i+1){ --> i = 0 --> label L5 --> ifnot i<10, jmp L6 x = x +
 * 1; --> x = x + 1 --> i = i + 1 } --> jmp L5 --> label L6
 * 
 * y = (10 + x) + 19 * y + z * 7 --> t2 = 10 + x --> t3 = 19 * y --> t4 = z * 7
 * --> t5 = t2 + t3 --> y = t5 + t4 }
 */