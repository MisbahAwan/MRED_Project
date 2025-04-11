// Generated from Uppaal2C.g4 by ANTLR 4.13.1

package Uppaal2CTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Uppaal2CParser}.
 */
public interface Uppaal2CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(Uppaal2CParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(Uppaal2CParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void enterNtaSection(Uppaal2CParser.NtaSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void exitNtaSection(Uppaal2CParser.NtaSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void enterNtaItem(Uppaal2CParser.NtaItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void exitNtaItem(Uppaal2CParser.NtaItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Uppaal2CParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Uppaal2CParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationItem(Uppaal2CParser.DeclarationItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationItem(Uppaal2CParser.DeclarationItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationVar(Uppaal2CParser.DeclarationVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationVar(Uppaal2CParser.DeclarationVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationFunc(Uppaal2CParser.DeclarationFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationFunc(Uppaal2CParser.DeclarationFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(Uppaal2CParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(Uppaal2CParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Uppaal2CParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Uppaal2CParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(Uppaal2CParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(Uppaal2CParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateParameter(Uppaal2CParser.TemplateParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateParameter(Uppaal2CParser.TemplateParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void enterNameSection(Uppaal2CParser.NameSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void exitNameSection(Uppaal2CParser.NameSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Uppaal2CParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Uppaal2CParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#queries}.
	 * @param ctx the parse tree
	 */
	void enterQueries(Uppaal2CParser.QueriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#queries}.
	 * @param ctx the parse tree
	 */
	void exitQueries(Uppaal2CParser.QueriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(Uppaal2CParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(Uppaal2CParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void enterInItLocation(Uppaal2CParser.InItLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void exitInItLocation(Uppaal2CParser.InItLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(Uppaal2CParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(Uppaal2CParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(Uppaal2CParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(Uppaal2CParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Uppaal2CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Uppaal2CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Uppaal2CParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Uppaal2CParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(Uppaal2CParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(Uppaal2CParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(Uppaal2CParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(Uppaal2CParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(Uppaal2CParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(Uppaal2CParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Uppaal2CParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Uppaal2CParser.CommentContext ctx);
}