package errors;

import java.util.ArrayList;

/*
    Esta clase nos permite visualizar todos los errores y advertencias necesarias
    si alguna regla sintactica no se cumple o mas bien hay un error semantico
*/
public class CustomErrors {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_RESET = "\u001B[0m";

    private String msgError;
    private String msgWarning;
    private String msgLine;
    private String msgSemantic;
    private String msgSyntactic;

    public CustomErrors() {
        msgError = ANSI_RED + "Error: " + ANSI_RESET;
        msgWarning = ANSI_YELLOW + "Warning: " + ANSI_RESET;
        msgLine = "line: ";
        msgSemantic = " " + ANSI_BLUE + "(Semantic Error)" + ANSI_RESET;
        msgSyntactic = " " + ANSI_GREEN + "(Syntactic Error)" + ANSI_RESET;
    }

    public void idRedefined(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' has been redefined" + msgSemantic);
    }

    public void idDeclared(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' has been declared in this context" + msgSemantic);
    }

    public void idNotDeclared(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' hasn't been declared" + msgSemantic);
    }

    public void idDifferentsTypes(String position, String type1, String type2){
        System.out.println(msgWarning + msgLine + position + "; You're trying to link an '" + type1 + "' type id to a '" + type2 + "' type" + msgSemantic);
    }

    public void syntacticError(String position, String msg){
        System.out.println(msgError + msgLine + position + "; " + msg + msgSyntactic);
    }

    public void idNotInitialized(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' hasn't been initialized" + msgSemantic);
    }

    public void returnVoidFunction(String position){
        System.out.println(msgError + msgLine + position + "; Type function is void, no return" + msgSemantic);
    }

    public void numberParamsArgs(String position){
        System.out.println(msgError + msgLine + position + "; Number of parameters is not the same as number of arguments" + msgSemantic);
    }

    public void returnDifferentTypes(String position){
        System.out.println(msgWarning + msgLine + position + "; You're returned a different type" + msgSemantic);
    }

    public void orderPrototype(String position){
        System.out.println(msgError + msgLine + position + "; The type or order doesn't match with prototype" + msgSemantic);
    }

    public void idNotUsed(ArrayList<String> notUsed){
        for (String id : notUsed) {
            System.out.println(msgWarning + "'" + id + "' has been declared but not used" + msgSemantic);
        }
    }

    public void prototypeCtxGlobal(String position){
        System.out.println(msgError + msgLine + position + "; The prototype must be in the global context" + msgSemantic);
    }

    public void incorrectNumberParams(String position){
        System.out.println(msgError + msgLine + position + "; Incorrect number of parameters" + msgSemantic);
    }

    public void notReturn(String position){
        System.out.println(msgError + msgLine + position + "; This function needs a return" + msgSemantic);
    }

    public void declaredAsVariable(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' has been declared as variable" + msgSemantic);
    }

    public void functionVoid(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' is return void" + msgSemantic);
    }

    public void functionNotDeclared(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' has been defined, but not declared" + msgSemantic);
    }

    public void idDifferentTypeReturn(String position, String id){
        System.out.println(msgError + msgLine + position + "; '" + id + "' is different from the return type" + msgSemantic);
    }

    public void idDifferentsTypesParamArgs(String position, String type1, String type2, String id){
        System.out.println(msgWarning + msgLine + position + "; The type '" + type1 + "' of the argument '" + id + "' does not match the type '" + type2 + "' of the parameter" + msgSemantic);
    }

}