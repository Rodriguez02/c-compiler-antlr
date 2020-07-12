package threeAddressCode;

import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import app.reglasBaseVisitor;
import app.reglasParser;
import app.reglasParser.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreeAddressCodeVisitor extends reglasBaseVisitor<String> {
    private int countLbl;
    private int countTmp;
    private String result;
    private String previousTemp;
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
            List<ParseTree> ruleTerms = findRuleNodes(ctx, reglasParser.RULE_term);
            if (ruleTerms.size()<3) {
                result += ctx.ID().getText() + " = ";
                moreThanTwo(ruleTerms);
            } else{
                processFactors(ctx.asign().operation().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }
        }
        return "";
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        if (ctx.asign() != null) {
            List<ParseTree> ruleTerms = findRuleNodes(ctx, reglasParser.RULE_term);
            if (ruleTerms.size()<3) {
                result += ctx.ID().getText() + " = ";
                moreThanTwo(ruleTerms);
            } else{
                processFactors(ctx.asign().operation().opal());
                result += ctx.ID().getText() + " = t" + (countTmp - 1) + "\n";
            }
        }
        return "";
    }

    @Override
    public String visitCondif(CondifContext ctx) {
        countLbl++;

        result += String.format("ifnot %s, jmp L%s\n", ctx.operation().getText(), countLbl);

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

        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", ctx.operation().getText(), countLbl);

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
        result += String.format("label L%s\n", countLbl);
        countLbl++;
        result += String.format("ifnot %s, jmp L%s\n", ctx.operation().getText(), countLbl);
        visitBlock(ctx.instruction().block());

        result += String.format("%s %s\n", ctx.ID().getText(), ctx.asign().getText());
        result += String.format("jmp L%s\n", aux);
        result += String.format("label L%s\n", countLbl);

        return "";
    }

    public void getResult() {
        System.out.println(result);
    }

    public void generateCode() {
        try {
            FileWriter fileWriter = new FileWriter("intermediate-code.txt");
            for(int i=0;i<result.length();i++){
                fileWriter.write(result.charAt(i));
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<ParseTree> findRuleNodes(ParseTree ctx, int ruleIndex){
        return new ArrayList<ParseTree>(Trees.findAllRuleNodes(ctx, ruleIndex));
    }
    
    private void moreThanTwo(List<ParseTree> ruleTerms){
        for (ParseTree parseTree : ruleTerms) {
            TermContext tc = ((TermContext)parseTree);
            if(tc.getParent() instanceof ExpContext){
                result += tc.getParent().getChild(0).getText() + " " + tc.getChild(0).getText() + "\n";
            } else{
                result += tc.getChild(0).getText() + (ruleTerms.size() == 1 ? "\n" : " ");
            }
        }
    }

    // Esta funcion concatena los temporales anteriores y actuales pasandole la operacion entre medio
    private void concatTemps(String operation){
        result += String.format("t%d = %s %s %s \n", countTmp, previousTemp, operation, currentTemp);
        currentTemp = "t" + countTmp;
        countTmp++;
    }

    /**
     * Elimina todos los terminos o factores que se encuentren dentro
     * de opal para evitar que se alteren el contador de temporal
     */
    private List<ParseTree> removeTermsOrFactors(ParseTree ctx){
        int ruleIndex;
        List<ParseTree> termsOrFactors;
        List<ParseTree> termsOrFactorsInOpal;
        List<ParseTree> opals = findRuleNodes(ctx, reglasParser.RULE_opal);
        if(ctx instanceof OpalContext){
            ruleIndex = reglasParser.RULE_term;
            termsOrFactors = findRuleNodes(ctx, ruleIndex);
            opals.remove(0); 
        } else{
            ruleIndex = reglasParser.RULE_factor;
            termsOrFactors = findRuleNodes(ctx, ruleIndex);
        }
        for (ParseTree o : opals) {
            if(((OpalContext)o).getParent() instanceof FactorContext){
                termsOrFactorsInOpal = findRuleNodes(o, ruleIndex);
                termsOrFactors.removeAll(termsOrFactorsInOpal);
            }
        }
        return termsOrFactors;
    }


    private void generateTemps(Collection<ParseTree> factors){
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        String temp;

        for(int i=0; i < factorsLocal.size(); i++){
            if(((FactorContext)factorsLocal.get(i)).opal() != null){
                temp = currentTemp;
                processFactors(((FactorContext)factorsLocal.get(i)).opal());
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1);
            }else{
                // sino guardar el valor
                previousTemp = currentTemp;
                currentTemp =  factorsLocal.get(i).getText();
            }
            if(i > 0){
                concatTemps(factorsLocal.get(i).getParent().getChild(0).getText());
            }    	          
        }
    }

    private void processFactors(OpalContext ctx) {
        List<ParseTree> ruleTerms = removeTermsOrFactors(ctx);
        String temp;

        List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
        for (int i=0; i < terms.size(); i++){
            List<ParseTree> factors = removeTermsOrFactors((TermContext)terms.get(i));
            List<ParseTree> listFactors = new ArrayList<ParseTree>(factors);

            if (factors.size() > 1){
                temp = currentTemp;
                generateTemps(factors);
                previousTemp = temp;
                currentTemp = "t" + (countTmp - 1); 
            }else{    
                previousTemp = currentTemp; 
                if(((TermContext)terms.get(i)).factor().opal() == null){
                    currentTemp = listFactors.get(0).getText();
                    if(terms.size() == 1){ 
                        result += currentTemp + "\n";
                    }
                } else {
                    temp = currentTemp; 
                    processFactors(((TermContext)terms.get(i)).factor().opal());
                    previousTemp = temp;
                }
            }
            if(i > 0){ 
                concatTemps(terms.get(i).getParent().getChild(0).getText());
            }
        }
    }
}

/*
    - cuando los terminos son mayores o iguales que 3
        - agregar temporales (ok)
        - propiedad distributiva no se hace bien
            - (9 * 8) * 4  --> No imprime el 4
            - 4 * (9 * 8)  --> No imprime bien el termino
            (Sugerencia Joseniana es el generarTemps())

    - asignacion
    - if
    - while
    - for
    - funciones

        - cuando el opal es el unico termino x = ( 9 + 1 )
                                             x = 4 + ( 9 * 2) + 5
          no esta contemplado el proceso de un unico termino

    - el igual no hace falta imprimirlo viene con la regla
    - guardar en un archivo

    int main(){     
        int x;                              
        int y = 0;                          --> y = 0
        int z = 1;                          --> z = 1

        x = y + z;                          --> x = y + z

        if (x < 0){                         --> ifnot x < 0, jmp L1
            x = x + 1;                      --> x = x + 1
                                            --> jmp L2
        } else{                             --> label L1
            x = x + 2;                      --> x = x + 2
        }                                   --> label L2 
        
                                            --> label L3
        while(x < 0){                       --> ifnot x < 0, jmp L4
            x = x + 1;                      --> x = x + 1          
                                            --> jmp L3
        }                                   --> label L4

        int i;                              

        for(i=0; i<10 ; i=i+1){             --> i = 0
                                            --> label L5
                                            --> ifnot i<10, jmp L6
            x = x + 1;                      --> x = x + 1                        
                                            --> i = i + 1 
        }                                   --> jmp L5
                                            --> label L6

        y = (10 + x) + 19 * y + z * 7       --> t2 = 10 + x
                                            --> t3 = 19 * y
                                            --> t4 = z * 7
                                            --> t5 = t2 + t3
                                            --> y = t5 + t4 
    }
*/