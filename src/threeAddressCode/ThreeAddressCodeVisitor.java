package threeAddressCode;

import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import app.reglasBaseVisitor;
import app.reglasLexer;
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
    public String visitAssignment(AssignmentContext ctx){
        if (ctx.asign() != null){
            //result += ctx.ID().getText() + " = ";
            processFactors(ctx.asign().operation().opal());
        }

        return "";
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx){
        if (ctx.asign() != null){
            result += ctx.ID().getText() + " = " + "\n";
            processFactors(ctx.asign().operation().opal());
        }

        return "";
    }

    @Override
    public String visitCondif(CondifContext ctx){
        countLbl++;
        
        result += "ifnot " + ctx.operation().getText() + ", jmp L" + countLbl + "\n";
        if(ctx.ELSE() == null){
            visitChildren(ctx);
        } else{

            // bloque if
            visitBlock((BlockContext)ctx.getChild(4));

            int aux = countLbl;
            countLbl++;
            result += "jmp L" + countLbl + "\n";
            result += "label L" + aux + "\n";
            
            // bloque else
            visitBlock((BlockContext)ctx.getChild(6));
            
        }
        result += "label L" + countLbl + "\n";
        result += "\n"; 
        
        return "";        
    }

    @Override
    public String visitCyclewhile(CyclewhileContext ctx){
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
    public String visitBlock(BlockContext ctx){
        visitChildren(ctx);    
        return "";
    }


    @Override
    public String visitCyclefor(CycleforContext ctx){
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
    
    public void getResult () {
        System.out.println(result);            
    }

    private Collection<ParseTree> findFactors(TermContext ctx){
        return Trees.findAllRuleNodes(ctx, reglasParser.RULE_factor);
    }

    private void generateTemps(Collection<ParseTree> factors){
        List<ParseTree> factorsLocal = new ArrayList<ParseTree>(factors);
        for(int i=1; i < factorsLocal.size(); i++){
            if(i == 1){ // primer factor
                result += 	"t" + countTmp + " = " + factorsLocal.get(i-1).getText() + " " +
                    factorsLocal.get(i).getParent().getChild(0).getText() + " " +
                    factorsLocal.get(i).getText() + "\n";
                countTmp++;	
            }else{
                result += 	"t" + countTmp + " = " + "t" + (countTmp - 1) + " " +
                factorsLocal.get(i).getParent().getChild(0).getText() + " " +
                factorsLocal.get(i).getText() + "\n";
                countTmp++;
            }	
        }
    }

    private Collection<ParseTree> findOpalWithoutTerms(ParseTree ctx){
        Collection<ParseTree> terms = Trees.findAllRuleNodes(ctx, reglasParser.RULE_term);
        //System.out.println("Term Size: "+terms.size());
        Collection<ParseTree> opals = Trees.findAllRuleNodes(ctx, reglasParser.RULE_opal);

        opals.remove(opals.toArray()[0]);
   
        //System.out.println("Opal size: " + opals.size() );
        Collection<ParseTree> termsInOpal;
        for (ParseTree o : opals) {
            if(((OpalContext)o).getParent() instanceof FactorContext){
                termsInOpal = Trees.findAllRuleNodes(o, reglasParser.RULE_term);
                terms.removeAll(termsInOpal);
            }
        }
        return terms;
    }

    private void processFactors(OpalContext ctx) {
        Collection<ParseTree> ruleTerms = findOpalWithoutTerms(ctx);


        //System.out.println(ruleTerms.size());

        // Collection<ParseTree> ruleFactor = Trees.findAllRuleNodes(ctx, reglasParser.RULE_factor);
        // if (ruleTerms.size() < 3){
        //     TermContext tc;
            
        //     for (ParseTree parseTree : ruleTerms) {
        //         tc = ((TermContext)parseTree);
        //         if(tc.getParent() instanceof ExpContext){
        //             result += tc.getParent().getChild(0).getText() + " " + tc.getChild(0).getText() + "\n";
        //         } else{
        //             result += tc.getChild(0).getText() + (ruleTerms.size() == 1 ? "\n" : " ");
        //         }
        //     }
        // }else{
            List<ParseTree> terms = new ArrayList<ParseTree>(ruleTerms);
           
            for (int i=0; i < terms.size(); i++){

                if(((TermContext)terms.get(i)).factor().opal() != null){

                    String tempcualq = currentTemp;
                    processFactors(((TermContext)terms.get(i)).factor().opal());
                    if(!tempcualq.equals("")){
                        result += "t" + countTmp + " = " + tempcualq + " " + ((TermContext)terms.get(i)).getParent().getChild(0) + " " + currentTemp + "\n";
                        countTmp++;
                        currentTemp = "t" + (countTmp-1); 
                    }
                } else{
                    Collection<ParseTree> factors = findFactors((TermContext)terms.get(i));
                    List<ParseTree> listFactors = new ArrayList<ParseTree>(factors);
                    if (factors.size() > 1){
                        generateTemps(factors);
                        previousTemp = currentTemp;
                        currentTemp = "t" + (countTmp - 1);
                    }else{
                        previousTemp = currentTemp;
                        currentTemp = listFactors.get(0).getText();
                        if(terms.size() == 1){ // cuando hay un termino y un factor, ej --> y = 9;
                            result += 	currentTemp + "\n";
                        }
                    }
                    if(i > 0){
                        result += 	"t" + countTmp + " = " + previousTemp + " " +
                                    terms.get(i).getParent().getChild(0).getText() + " " +
                                    currentTemp + "\n";
                        currentTemp = 	"t" + countTmp;
                        countTmp++;
                    }
                }
                
            }
        //}
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


    - el igual no hace falta imprimirlo viene con la regla
*/

/*
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