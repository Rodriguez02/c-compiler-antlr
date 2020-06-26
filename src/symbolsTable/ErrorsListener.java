package symbolsTable;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorsListener extends BaseErrorListener{

    private String syntaxErrors;

    public ErrorsListener(){
        this.syntaxErrors = "";
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
    
    //        String sourceName = recognizer.getInputStream().getSourceName();
    //        if (!sourceName.isEmpty()) {
    //            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
    //        }
    
            System.err.println("CUSTOM:  "  + "line " + line + ":" + charPositionInLine + " " + offendingSymbol.toString());
            
            syntaxErrors = msg;
        }
    
        /**
         * @return the syntaxErrors
         */
        public String getSyntaxErrors() {
            return syntaxErrors;
        }
    
}