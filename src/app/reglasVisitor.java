// Generated from /home/jose/TC/Version/version-1/ProyectSimbols/src/app/reglas.g4 by ANTLR 4.7.1

package app;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link reglasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface reglasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link reglasParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(reglasParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(reglasParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(reglasParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(reglasParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(reglasParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(reglasParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#asign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsign(reglasParser.AsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatype(reglasParser.DatatypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(reglasParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#cyclefor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCyclefor(reglasParser.CycleforContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#cyclewhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCyclewhile(reglasParser.CyclewhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#condif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondif(reglasParser.CondifContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#prototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototype(reglasParser.PrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(reglasParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(reglasParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(reglasParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#callfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallfunction(reglasParser.CallfunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(reglasParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(reglasParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(reglasParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#opal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpal(reglasParser.OpalContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(reglasParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#disy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisy(reglasParser.DisyContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(reglasParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#conj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConj(reglasParser.ConjContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(reglasParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(reglasParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#opcomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcomp(reglasParser.OpcompContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(reglasParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(reglasParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(reglasParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#ter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTer(reglasParser.TerContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(reglasParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link reglasParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(reglasParser.FContext ctx);
}