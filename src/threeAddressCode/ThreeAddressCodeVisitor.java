package threeAddressCode;

import java.util.Collection;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import app.reglasBaseVisitor;
import app.reglasLexer;
import app.reglasParser;
import app.reglasParser.*;

public class ThreeAddressCodeVisitor extends reglasBaseVisitor<String> {
    private String IFN;
    private String LBL;
    private String JMP;
    private int countLbl;
    private int countTmp;
    private String result;

    public ThreeAddressCodeVisitor() {
        this.IFN = "ifnot";
        this.LBL = "label";
        this.JMP = "jmp";
        this.countLbl = 0;
        this.countTmp = 0;
        this.result = "";
    }

    @Override
    public String visit(ParseTree tree) {
        return super.visit(tree);
    }
    
    @Override
    public String visitAssignment(AssignmentContext ctx){
        if (ctx.asign() != null){
            result += ctx.ID().getText() + " = ";
            processFactors(ctx.asign().operation());
        }

        return "";
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx){
        if (ctx.asign() != null){
            result += ctx.ID().getText() + " = ";
            processFactors(ctx.asign().operation());
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

    private void processFactors(OperationContext ctx) {
        Collection<ParseTree> ruleTerms = Trees.findAllRuleNodes(ctx, reglasParser.RULE_term);
        // Collection<ParseTree> ruleFactor = Trees.findAllRuleNodes(ctx, reglasParser.RULE_factor);

        if (ruleTerms.size() < 3){
            TermContext tc;
            
            for (ParseTree parseTree : ruleTerms) {
                tc = ((TermContext)parseTree);
                if(tc.getParent() instanceof ExpContext){
                    result += tc.getParent().getChild(0).getText() + " " + tc.getChild(0).getText() + "\n";
                } else{
                    result += tc.getChild(0).getText() + (ruleTerms.size() == 1 ? "\n" : " ");
                }
            }
        }
    }
}

/*
    - cuando los terminos son mayores o iguales que 3
        - agregar temporales
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