package symbolsTable;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import errors.CustomErrors;

/**
 * Personalizamos los errores de ANTLR para poder hacer un 
 * "pretty printer" de los mismo e indicar que son Sintacticos y en 
 * que posicion se encuentra
 */
public class ErrorsListener extends BaseErrorListener {

    private CustomErrors customErrors;

    public ErrorsListener() {
        this.customErrors = new CustomErrors();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        String position = "[" + line + ":" + charPositionInLine + "]";
        customErrors.syntacticError(position, msg);
    }
}
