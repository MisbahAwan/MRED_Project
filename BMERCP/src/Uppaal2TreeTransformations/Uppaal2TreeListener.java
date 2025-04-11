// Generated from Uppaal2Tree.g4 by ANTLR 4.13.1

package Uppaal2TreeTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Uppaal2TreeParser}.
 */
public interface Uppaal2TreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(Uppaal2TreeParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(Uppaal2TreeParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void enterNtaSection(Uppaal2TreeParser.NtaSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#ntaSection}.
	 * @param ctx the parse tree
	 */
	void exitNtaSection(Uppaal2TreeParser.NtaSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void enterNtaItem(Uppaal2TreeParser.NtaItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#ntaItem}.
	 * @param ctx the parse tree
	 */
	void exitNtaItem(Uppaal2TreeParser.NtaItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Uppaal2TreeParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Uppaal2TreeParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationItem(Uppaal2TreeParser.DeclarationItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#declarationItem}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationItem(Uppaal2TreeParser.DeclarationItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationVar(Uppaal2TreeParser.DeclarationVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationVar(Uppaal2TreeParser.DeclarationVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationFunc(Uppaal2TreeParser.DeclarationFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#declarationFunc}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationFunc(Uppaal2TreeParser.DeclarationFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(Uppaal2TreeParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(Uppaal2TreeParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Uppaal2TreeParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Uppaal2TreeParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(Uppaal2TreeParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(Uppaal2TreeParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateParameter(Uppaal2TreeParser.TemplateParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateParameter(Uppaal2TreeParser.TemplateParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void enterNameSection(Uppaal2TreeParser.NameSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#nameSection}.
	 * @param ctx the parse tree
	 */
	void exitNameSection(Uppaal2TreeParser.NameSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Uppaal2TreeParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Uppaal2TreeParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#queries}.
	 * @param ctx the parse tree
	 */
	void enterQueries(Uppaal2TreeParser.QueriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#queries}.
	 * @param ctx the parse tree
	 */
	void exitQueries(Uppaal2TreeParser.QueriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(Uppaal2TreeParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(Uppaal2TreeParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void enterInItLocation(Uppaal2TreeParser.InItLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#inItLocation}.
	 * @param ctx the parse tree
	 */
	void exitInItLocation(Uppaal2TreeParser.InItLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(Uppaal2TreeParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(Uppaal2TreeParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(Uppaal2TreeParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(Uppaal2TreeParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Uppaal2TreeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Uppaal2TreeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(Uppaal2TreeParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(Uppaal2TreeParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#rightSide}.
	 * @param ctx the parse tree
	 */
	void enterRightSide(Uppaal2TreeParser.RightSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#rightSide}.
	 * @param ctx the parse tree
	 */
	void exitRightSide(Uppaal2TreeParser.RightSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Uppaal2TreeParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Uppaal2TreeParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#complex}.
	 * @param ctx the parse tree
	 */
	void enterComplex(Uppaal2TreeParser.ComplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#complex}.
	 * @param ctx the parse tree
	 */
	void exitComplex(Uppaal2TreeParser.ComplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(Uppaal2TreeParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(Uppaal2TreeParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(Uppaal2TreeParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(Uppaal2TreeParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(Uppaal2TreeParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(Uppaal2TreeParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Uppaal2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Uppaal2TreeParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Uppaal2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Uppaal2TreeParser.CommentContext ctx);
}