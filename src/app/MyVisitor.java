package app;

import java.util.LinkedList;

import org.antlr.v4.runtime.tree.ParseTree;

import app.reglasParser.DeclarationContext;
import app.reglasParser.InstructionContext;
import errors.SyntaxErrors;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MyVisitor extends reglasBaseVisitor<String> {
    LinkedList<SyntaxErrors> errores;

    public MyVisitor(){
        errores = new LinkedList<SyntaxErrors>();
    }

    public void visitAllHijos(RuleContext ctx) {
        for (int hijo = 0; hijo < ctx.getChildCount(); hijo++) {
            visit(ctx.getChild(hijo));
        }
    }


    @Override
    public String visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        System.out.println(ctx.getParent() instanceof InstructionContext);

        

        System.out.println(ctx.getParent().getStop().getText());

        if(!ctx.getStop().getText().equals(";")){
            System.out.println("No esta el ;");
        }
        visitAllHijos(ctx.getRuleContext());

        return "";
    }

    @Override
    public String visitErrorNode(ErrorNode node){
        
        System.out.println(node.getText());

        // SyntaxErrors error = new SyntaxErrors(
        //     node.getSymbol().getLine(),
        //     node.getSymbol().getCharPositionInLine(),
        //     node.getSymbol().getStopIndex()
        // );
        // errores.add(error);
        return "";
    }  

    public void getErrorNodes () {
        for (SyntaxErrors e : errores) {
            System.out.println(e);            
        }
    }
    
}