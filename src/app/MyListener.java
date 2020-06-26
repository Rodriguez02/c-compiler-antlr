package app;

import symbolsTable.Funcion;
import symbolsTable.Id;
import symbolsTable.TablaSimbolos;
import symbolsTable.Variable;
import org.antlr.v4.runtime.tree.Trees;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import app.reglasParser.*;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import errors.CustomErrors;

/**
 * MyListener
 */
public class MyListener extends reglasBaseListener {

    private TablaSimbolos simbolos = new TablaSimbolos();
    private CustomErrors errors = new CustomErrors();

    /*****************************************************************
     *************************Private Methods*************************
     *****************************************************************/

    private String positionToken(Token token){
        return "[" + token.getLine() + ":" + token.getCharPositionInLine() + "]";
    }

    private boolean isSameDataType(String dataType, String dataTypeFactor) {
        if (dataType.equals(dataTypeFactor))
            return true;
        else
            return false;
    }

    private String getStringType(int type) {
        switch (type) {
            case reglasLexer.INTEGER:
                return "int";
            case reglasLexer.DECIMAL:
                return "double";
            case reglasLexer.CHARACTER:
                return "char";
            default:
                return null;
        }
    }

    private Id getID(String id) { return simbolos.lookup(id); }

    private Id getIDLocal(String id){ return simbolos.lookupLocal(id); }

    private boolean isFunction(Id id){ return id instanceof Funcion; }

    /* Buscar factores, ecxepto argumentos de la funcion */
    private Collection<ParseTree> findFactorsWithoutArguments(ParseTree ctx){
        Collection<ParseTree> factors = Trees.findAllRuleNodes(ctx, reglasParser.RULE_factor);
        Collection<ParseTree> callsFunction = Trees.findAllRuleNodes(ctx, reglasParser.RULE_callfunction);
        Collection<ParseTree> factorsCallFunction;
        for (ParseTree parseTree : callsFunction) {
            factorsCallFunction = Trees.findAllRuleNodes(parseTree, reglasParser.RULE_factor);
            factors.removeAll(factorsCallFunction);
        }
        return factors;
    }
    
    /* Verificar que no existan parametros iguales en la definicion o declaracion de una funcion */
    private boolean containsParameter(List<Variable> parameters, String nameVar){
        return parameters.stream()
                         .filter(param -> param.getTokenNombre().equals(nameVar))
                         .findFirst()
                         .isPresent();
    }

    /* Obtener parametros de una funcion */
    private List<Variable> getParameters(ParametersContext ctx){
        List<Variable> params = new ArrayList<Variable>();
        Collection<ParseTree> parameters = Trees.findAllRuleNodes(ctx, reglasParser.RULE_declaration);
        for (ParseTree parseTree : parameters) {
            DeclarationContext decl = (DeclarationContext)parseTree;
            if(containsParameter(params, decl.ID().getText())){
                errors.idRedefined(positionToken(ctx.getStart()), decl.ID().getText());
                return null;
            }
            Variable var = new Variable(true, false, decl.datatype().getText(), decl.ID().getText());
            params.add(var);
        }
        return params;
    }

    /* Analizar cada factor de una operacion */
    private boolean processFactors(Id caller, String dataType, Collection<ParseTree> factors) {
        FactorContext fc;
        boolean error = true;
        for (ParseTree parseTree : factors) {
            fc = (FactorContext) parseTree;
            
            if (fc.ID() != null){
                String idFactor = fc.ID().getText();
                Id id = getID(idFactor);
                if (id == null){
                    errors.idNotDeclared(positionToken(fc.getStart()), idFactor);
                    error = false;
                }else if(!id.isInicializado()){
                    errors.idNotInitialized(positionToken(fc.getStart()), idFactor);
                    error = false;
                }else{
                    id.setUtilizado(true);
                    if (dataType != null  && !isSameDataType(dataType, id.getTipoDato())){
                        if(isFunction(caller))
                            errors.idDifferentsTypesParamArgs(positionToken(fc.getStart()), id.getTipoDato(), dataType, id.getTokenNombre());
                        else
                            errors.idDifferentsTypes(positionToken(fc.getStart()), id.getTipoDato(), dataType);
                    }
                }
            } else if(fc.callfunction() != null){
                processCallfunction(dataType, fc.callfunction());
            } else if (fc.INTEGER() != null || fc.DECIMAL() != null || fc.CHARACTER() != null) {
                if (dataType != null  && !isSameDataType(dataType, getStringType(fc.getStop().getType()))){
                    if(isFunction(caller))
                        errors.idDifferentsTypesParamArgs(positionToken(fc.getStart()), getStringType(fc.getStop().getType()), dataType, fc.getText());
                    else
                        errors.idDifferentsTypes(positionToken(fc.getStart()), getStringType(fc.getStop().getType()), dataType);
                }
            }
        }
        return error;
    }

    /* Procesar instruccion asignacion */
    private void processAssignment(AssignmentContext ctx) {
        Id id = getID(ctx.ID().getText());
        if (id != null) {
            Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
            if(processFactors(null, id.getTipoDato(), factors))
                id.setInicializado(true);
        } else
            errors.idNotDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
    }

    /* Procesar instruccion declaracion */
    private void processDeclaration(DeclarationContext ctx) {
        Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
        if (getIDLocal(ctx.ID().getText()) == null) {
            Id id = new Variable(false, false, ctx.datatype().getText(), ctx.ID().getText());
            simbolos.insert(ctx.ID().getText(), id);
            if (ctx.asign() != null) {
                if(processFactors(null, ctx.datatype().getText(), factors))
                    id.setInicializado(true);
            }
        } else{
            processFactors(null, ctx.datatype().getText(), factors);
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }
    }

    /* Procesar declaracion de funcion */
    private Id processFunction(FunctionContext ctx){
        Id id = getIDLocal(ctx.ID().getText());
        if(id == null){
            List<Variable> parameters = getParameters(ctx.parameters());
            if(parameters != null){
                Id idFunction = new Funcion(true, false, ctx.datatype().getText(), ctx.ID().getText(), parameters);
                simbolos.insert(ctx.ID().getText(), idFunction);
                return idFunction;
            }
        }else if(!isFunction(id)){
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }else if(isFunction(id) && id.isInicializado()){
            errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        }else if(isFunction(id) && !id.isInicializado()){
            if(!((Funcion)id).areParametersEquals(getParameters(ctx.parameters())))
                errors.orderPrototype(positionToken(ctx.getStart()));
            else
                id.setInicializado(true);
                return id;
        }
        return null;
    }

    /* Procesar llamada a funcion */
    private void processCallfunction(String dataType, CallfunctionContext ctx){
        Id id = getID(ctx.ID().getText());
        Collection<ParseTree> operations = Trees.findAllRuleNodes(ctx, reglasParser.RULE_operation);
        Object[] oper = operations.toArray();
        Collection<ParseTree> factorCountFirstOperation = Trees.findAllRuleNodes((ParseTree)oper[0], reglasParser.RULE_factor);

        if(id == null)
            errors.idNotDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
        else if(isFunction(id) && id.isInicializado()){
            List<Variable> parameters = ((Funcion)id).getParametros();
            Collection<ParseTree> factors;

            if(dataType != null && id.getTipoDato().equals("void"))
                errors.functionVoid(positionToken(ctx.getStart()), id.getTokenNombre());
            else if(factorCountFirstOperation.size() > 0 && ((Funcion)id).getParametros().size() != operations.size()){
                errors.numberParamsArgs(positionToken(ctx.getStart()));
            }
            else if(dataType != null && !isSameDataType(dataType, id.getTipoDato()))
                errors.idDifferentsTypes(positionToken(ctx.getStart()), id.getTipoDato(), dataType);
            
            id.setUtilizado(true);
            for(int i=0; i < parameters.size();  i++){
                if(i > (operations.size() - 1)) { break; }
                factors = Trees.findAllRuleNodes((ParseTree)oper[i], reglasParser.RULE_factor);
                processFactors(id, parameters.get(i).getTipoDato(), factors);
            }
        }else if(isFunction(id) && !id.isInicializado()){
            errors.functionNotDeclared(positionToken(ctx.getStart()), id.getTokenNombre());
        }else if(!isFunction(id))
            errors.declaredAsVariable(positionToken(ctx.getStart()), id.getTokenNombre());
    }

    /* Procesar instruccion return o validar su omision */
    private void processReturn(FunctionContext ctx){
        Collection<ParseTree> returns = Trees.findAllRuleNodes(ctx, reglasParser.RULE_retorno);
        if(ctx.datatype().getText().equals("void") && returns.size() != 0)
            errors.returnVoidFunction(positionToken(((RetornoContext)(returns.toArray()[0])).getStart()));
        else if(!ctx.datatype().getText().equals("void") && !ctx.ID().getText().equals("main") && returns.size() == 0)
            errors.notReturn(positionToken(ctx.getStart()));
        else if(!ctx.datatype().getText().equals("void") && returns.size() > 0){
            ParseTree ret = (ParseTree)(returns.toArray()[0]);
            Collection<ParseTree> factors = findFactorsWithoutArguments(ret);
            processFactors(null, ctx.datatype().getText(), factors);
        }
    }

    /*****************************************************************
     ************************Override Methods*************************
     *****************************************************************/

    @Override
    public void enterProg(reglasParser.ProgContext ctx) {
        simbolos.enterContext();
    }

    @Override
    public void exitProg(reglasParser.ProgContext ctx) {
        errors.idNotUsed(simbolos.unusedIDs());
        simbolos.exitContext();
    }

    @Override
    public void exitAssignment(AssignmentContext ctx) {
        processAssignment(ctx);
    }

    @Override 
    public void exitOperation(OperationContext ctx) { 
        if( !(ctx.getParent() instanceof AsignContext) &&
                !(ctx.getParent() instanceof ArgumentsContext) &&
                !(ctx.getParent() instanceof ArgContext)){
            Collection<ParseTree> factors = findFactorsWithoutArguments(ctx);
            processFactors(null, null, factors);
        }
    }

    @Override 
    public void exitPrototype(PrototypeContext ctx) { 
        if(simbolos.getTablaSimbolos().size() == 1){
            Id id = getID(ctx.ID().getText()); 
            if(id == null){
                List<Variable> parameters = getParameters(ctx.parameters());
                if(parameters != null){
                    Id prototype = new Funcion(false, false, ctx.datatype().getText(), ctx.ID().getText(), parameters);
                    simbolos.insert(ctx.ID().getText(), prototype);
                }
            }else{
                errors.idDeclared(positionToken(ctx.getStart()), ctx.ID().getText());
            }
        }else{
            errors.prototypeCtxGlobal(positionToken(ctx.getStart()));
        }
    }

    @Override 
    public void enterBlock(BlockContext ctx) { 
        if(ctx.getParent() instanceof FunctionContext){
            FunctionContext funcionContext = (FunctionContext)ctx.getParent();
            Id id = processFunction(funcionContext);
            simbolos.enterContext();
            if(id != null)
                ((Funcion)id).getParametros().stream().forEach(param -> simbolos.insert(param.getTokenNombre(), param));
            else
                getParameters(funcionContext.parameters()).stream().forEach(param -> simbolos.insert(param.getTokenNombre(), param));
        }else
            simbolos.enterContext();
    }

    @Override 
    public void exitBlock(BlockContext ctx) {
        if(ctx.getParent() instanceof FunctionContext)
            processReturn((FunctionContext)ctx.getParent());
        errors.idNotUsed(simbolos.unusedIDs());
        simbolos.exitContext();
    }

    @Override 
    public void exitCallfunction(CallfunctionContext ctx) {
        if(ctx.getParent() instanceof InstructionContext){
            getID(ctx.ID().getText()).setUtilizado(true);
            processCallfunction(null, ctx);
        }
    }

    @Override 
    public void exitInstruction(InstructionContext ctx) { 
        if(ctx.declaration() != null)
            processDeclaration(ctx.declaration());
        //System.out.println(simbolos);
    } 
}