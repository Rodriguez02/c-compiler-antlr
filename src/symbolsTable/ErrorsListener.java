package symbolsTable;

// import org.antlr.v4.runtime.CommonToken;
// import org.antlr.v4.runtime.BaseErrorListener;
// import org.antlr.v4.runtime.RecognitionException;
// import org.antlr.v4.runtime.Recognizer;

// import errors.CustomErrors;

// public class ErrorsListener extends BaseErrorListener {

//     private String syntaxErrors;
//     private CustomErrors customErrors;

//     public ErrorsListener() {
//         this.syntaxErrors = "";
//         this.customErrors = new CustomErrors();
//     }

//     @Override
//     public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
//             String msg, RecognitionException e) {

//         CommonToken token = (CommonToken) offendingSymbol;

//         String position = "[" + line + ":" + charPositionInLine + "]";
//         String symbol = token.getText();

//         //System.out.println(token);

//         System.out.println(offendingSymbol.toString());
//         System.out.println(msg);
//         System.out.println(line);

//         // switch (token.getText()) {
//         //     case "(":
//         //     case "[":
//         //     case "{":
//         //         customErrors.missingOpenSymbol(position, symbol);
//         //         break;
//         //     case ")":
//         //     case "]":
//         //     case "}":
//         //         customErrors.missingCloseSymbol(position, symbol);
//         //         break;
//         //     case ";":
//         //         customErrors.missingPYC(position);
//         //         break;
//         //     default:
//         //         break;
//         // }

//     }

//     /**
//      * @return the syntaxErrors
//      */
//     public String getSyntaxErrors() {
//         return syntaxErrors;
//     }

// }
