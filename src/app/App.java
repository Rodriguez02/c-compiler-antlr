package app;

import org.antlr.v4.runtime.tree.ParseTree;

import threeAddressCode.ThreeAddressCodeVisitor;

import symbolsTable.ErrorsListener;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class App {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from file
        CharStream input = CharStreams.fromFileName("src/app/ejemplo.txt");

        // create a lexer that feeds off of input CharStream
        reglasLexer lexer = new reglasLexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        reglasParser parser = new reglasParser(tokens);

        // Removemos el error listener que tiene por defecto ANTRL 
        // y creamos el propio
        ErrorsListener errorsListener = new ErrorsListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errorsListener);

        System.out.println("\n");
        
        // Creamos nuestro propio Listener
        reglasBaseListener listener = new MyListener();
        parser.addParseListener(listener);
        
        ParseTree tree = parser.prog();

        // Creamos un Visitor para poder generar el codigo de tres direcciones
        ThreeAddressCodeVisitor visitor = new ThreeAddressCodeVisitor();
        visitor.visit(tree);
        visitor.getResult();
        visitor.generateCode();
    }
}