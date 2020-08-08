package symbolsTable;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import errors.CustomErrors;

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
