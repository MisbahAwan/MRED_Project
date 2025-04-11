// Generated from Uppaal2Tree.g4 by ANTLR 4.13.1

package Uppaal2TreeTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Uppaal2TreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Uppaal2TreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(Uppaal2TreeParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#ntaSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaSection(Uppaal2TreeParser.NtaSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#ntaItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaItem(Uppaal2TreeParser.NtaItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Uppaal2TreeParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#declarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationItem(Uppaal2TreeParser.DeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#declarationVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationVar(Uppaal2TreeParser.DeclarationVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#declarationFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFunc(Uppaal2TreeParser.DeclarationFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(Uppaal2TreeParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Uppaal2TreeParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(Uppaal2TreeParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#templateParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateParameter(Uppaal2TreeParser.TemplateParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#nameSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameSection(Uppaal2TreeParser.NameSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Uppaal2TreeParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#queries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueries(Uppaal2TreeParser.QueriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(Uppaal2TreeParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#inItLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInItLocation(Uppaal2TreeParser.InItLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(Uppaal2TreeParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(Uppaal2TreeParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Uppaal2TreeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(Uppaal2TreeParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#rightSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightSide(Uppaal2TreeParser.RightSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Uppaal2TreeParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#complex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex(Uppaal2TreeParser.ComplexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(Uppaal2TreeParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(Uppaal2TreeParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(Uppaal2TreeParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2TreeParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Uppaal2TreeParser.CommentContext ctx);
}