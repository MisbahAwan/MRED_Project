// Generated from Uppaal2C.g4 by ANTLR 4.13.1

package Uppaal2CTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Uppaal2CParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Uppaal2CVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(Uppaal2CParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#ntaSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaSection(Uppaal2CParser.NtaSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#ntaItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaItem(Uppaal2CParser.NtaItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Uppaal2CParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#declarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationItem(Uppaal2CParser.DeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#declarationVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationVar(Uppaal2CParser.DeclarationVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#declarationFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFunc(Uppaal2CParser.DeclarationFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(Uppaal2CParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Uppaal2CParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(Uppaal2CParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#templateParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateParameter(Uppaal2CParser.TemplateParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#nameSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameSection(Uppaal2CParser.NameSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Uppaal2CParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#queries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueries(Uppaal2CParser.QueriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(Uppaal2CParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#inItLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInItLocation(Uppaal2CParser.InItLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(Uppaal2CParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(Uppaal2CParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Uppaal2CParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Uppaal2CParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(Uppaal2CParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(Uppaal2CParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(Uppaal2CParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2CParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Uppaal2CParser.CommentContext ctx);
}