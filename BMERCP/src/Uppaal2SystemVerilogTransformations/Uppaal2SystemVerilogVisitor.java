// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Uppaal2SystemVerilogTransformations//Uppaal2SystemVerilog.g4 by ANTLR 4.13.1

package Uppaal2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Uppaal2SystemVerilogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Uppaal2SystemVerilogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(Uppaal2SystemVerilogParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaSection(Uppaal2SystemVerilogParser.NtaSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNtaItem(Uppaal2SystemVerilogParser.NtaItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Uppaal2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationItem(Uppaal2SystemVerilogParser.DeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationVar(Uppaal2SystemVerilogParser.DeclarationVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationFunc(Uppaal2SystemVerilogParser.DeclarationFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(Uppaal2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Uppaal2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(Uppaal2SystemVerilogParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#templateParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateParameter(Uppaal2SystemVerilogParser.TemplateParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#nameSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameSection(Uppaal2SystemVerilogParser.NameSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Uppaal2SystemVerilogParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#queries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueries(Uppaal2SystemVerilogParser.QueriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(Uppaal2SystemVerilogParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#inItLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInItLocation(Uppaal2SystemVerilogParser.InItLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(Uppaal2SystemVerilogParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(Uppaal2SystemVerilogParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Uppaal2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Uppaal2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(Uppaal2SystemVerilogParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(Uppaal2SystemVerilogParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(Uppaal2SystemVerilogParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Uppaal2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Uppaal2SystemVerilogParser.CommentContext ctx);
}