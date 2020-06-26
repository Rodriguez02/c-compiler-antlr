// Generated from /home/jose/TC/Version/version-1/ProyectSimbols/src/app/reglas.g4 by ANTLR 4.7.1

package app;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link reglasParser}.
 */
public interface reglasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link reglasParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(reglasParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(reglasParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(reglasParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(reglasParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(reglasParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(reglasParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(reglasParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(reglasParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(reglasParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(reglasParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(reglasParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(reglasParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(reglasParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(reglasParser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(reglasParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(reglasParser.DatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(reglasParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(reglasParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#cyclefor}.
	 * @param ctx the parse tree
	 */
	void enterCyclefor(reglasParser.CycleforContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#cyclefor}.
	 * @param ctx the parse tree
	 */
	void exitCyclefor(reglasParser.CycleforContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#cyclewhile}.
	 * @param ctx the parse tree
	 */
	void enterCyclewhile(reglasParser.CyclewhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#cyclewhile}.
	 * @param ctx the parse tree
	 */
	void exitCyclewhile(reglasParser.CyclewhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#condif}.
	 * @param ctx the parse tree
	 */
	void enterCondif(reglasParser.CondifContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#condif}.
	 * @param ctx the parse tree
	 */
	void exitCondif(reglasParser.CondifContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#prototype}.
	 * @param ctx the parse tree
	 */
	void enterPrototype(reglasParser.PrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#prototype}.
	 * @param ctx the parse tree
	 */
	void exitPrototype(reglasParser.PrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(reglasParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(reglasParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(reglasParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(reglasParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(reglasParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(reglasParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#callfunction}.
	 * @param ctx the parse tree
	 */
	void enterCallfunction(reglasParser.CallfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#callfunction}.
	 * @param ctx the parse tree
	 */
	void exitCallfunction(reglasParser.CallfunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(reglasParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(reglasParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(reglasParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(reglasParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(reglasParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(reglasParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#opal}.
	 * @param ctx the parse tree
	 */
	void enterOpal(reglasParser.OpalContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#opal}.
	 * @param ctx the parse tree
	 */
	void exitOpal(reglasParser.OpalContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(reglasParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(reglasParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#disy}.
	 * @param ctx the parse tree
	 */
	void enterDisy(reglasParser.DisyContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#disy}.
	 * @param ctx the parse tree
	 */
	void exitDisy(reglasParser.DisyContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(reglasParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(reglasParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#conj}.
	 * @param ctx the parse tree
	 */
	void enterConj(reglasParser.ConjContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#conj}.
	 * @param ctx the parse tree
	 */
	void exitConj(reglasParser.ConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(reglasParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(reglasParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(reglasParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(reglasParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#opcomp}.
	 * @param ctx the parse tree
	 */
	void enterOpcomp(reglasParser.OpcompContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#opcomp}.
	 * @param ctx the parse tree
	 */
	void exitOpcomp(reglasParser.OpcompContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(reglasParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(reglasParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(reglasParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(reglasParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(reglasParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(reglasParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#ter}.
	 * @param ctx the parse tree
	 */
	void enterTer(reglasParser.TerContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#ter}.
	 * @param ctx the parse tree
	 */
	void exitTer(reglasParser.TerContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(reglasParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(reglasParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link reglasParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(reglasParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link reglasParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(reglasParser.FContext ctx);
}