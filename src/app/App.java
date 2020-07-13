package app;

import org.antlr.v4.runtime.tree.ParseTree;

import threeAddressCode.ThreeAddressCodeVisitor;

// import symbolsTable.ErrorsListener;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class App {
    public static void main(String[] args) throws Exception {
        // ANTLRErrorListener errorsListener = new ErrorsListener();

        // create a CharStream that reads from file
        CharStream input = CharStreams.fromFileName("src/app/ejemplo.txt");

        // create a lexer that feeds off of input CharStream
        reglasLexer lexer = new reglasLexer(input);
        
        
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        reglasParser parser = new reglasParser(tokens);

        // ErrorsListener errorsListener = new ErrorsListener(true);
        //parser.removeErrorListeners();
        // parser.addErrorListener(errorsListener);

        System.out.println("\n");
        
        reglasBaseListener listener = new MyListener();
        parser.addParseListener(listener);
        

        ParseTree tree = parser.prog();
        //parser.prog();

        ThreeAddressCodeVisitor visitor = new ThreeAddressCodeVisitor();
        visitor.visit(tree);
        visitor.getResult();
        visitor.generateCode();

        // MyVisitor visitor = new MyVisitor();
        // visitor.visit(tree);

        // System.out.println(escucha);

        // System.out.println(tree.toStringTree(parser));
                
    }
}