// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Uppaal2SystemVerilogTransformations//Uppaal2SystemVerilog.g4 by ANTLR 4.13.1

package Uppaal2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Uppaal2SystemVerilogParser}.
 */
public interface Uppaal2SystemVerilogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(Uppaal2SystemVerilogParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(Uppaal2SystemVerilogParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void enterNtaSection(Uppaal2SystemVerilogParser.NtaSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void exitNtaSection(Uppaal2SystemVerilogParser.NtaSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void enterNtaItem(Uppaal2SystemVerilogParser.NtaItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void exitNtaItem(Uppaal2SystemVerilogParser.NtaItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Uppaal2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Uppaal2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationItem(Uppaal2SystemVerilogParser.DeclarationItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationItem(Uppaal2SystemVerilogParser.DeclarationItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationVar(Uppaal2SystemVerilogParser.DeclarationVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationVar(Uppaal2SystemVerilogParser.DeclarationVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationFunc(Uppaal2SystemVerilogParser.DeclarationFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationFunc(Uppaal2SystemVerilogParser.DeclarationFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(Uppaal2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(Uppaal2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Uppaal2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Uppaal2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(Uppaal2SystemVerilogParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(Uppaal2SystemVerilogParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateParameter(Uppaal2SystemVerilogParser.TemplateParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateParameter(Uppaal2SystemVerilogParser.TemplateParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void enterNameSection(Uppaal2SystemVerilogParser.NameSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void exitNameSection(Uppaal2SystemVerilogParser.NameSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Uppaal2SystemVerilogParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Uppaal2SystemVerilogParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#queries}.
	 * @param ctx the parse tree
	 */
	void enterQueries(Uppaal2SystemVerilogParser.QueriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#queries}.
	 * @param ctx the parse tree
	 */
	void exitQueries(Uppaal2SystemVerilogParser.QueriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(Uppaal2SystemVerilogParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(Uppaal2SystemVerilogParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void enterInItLocation(Uppaal2SystemVerilogParser.InItLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void exitInItLocation(Uppaal2SystemVerilogParser.InItLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(Uppaal2SystemVerilogParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(Uppaal2SystemVerilogParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(Uppaal2SystemVerilogParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(Uppaal2SystemVerilogParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Uppaal2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Uppaal2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Uppaal2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Uppaal2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(Uppaal2SystemVerilogParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(Uppaal2SystemVerilogParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(Uppaal2SystemVerilogParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(Uppaal2SystemVerilogParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(Uppaal2SystemVerilogParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(Uppaal2SystemVerilogParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Uppaal2SystemVerilogParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Uppaal2SystemVerilogParser.CommentContext ctx);
}