// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2UppaalTransformation//Tree2Uppaal.g4 by ANTLR 4.13.1

package Tree2UppaalTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Tree2UppaalParser}.
 */
public interface Tree2UppaalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Tree2UppaalParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Tree2UppaalParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(Tree2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(Tree2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(Tree2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(Tree2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(Tree2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(Tree2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(Tree2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(Tree2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Tree2UppaalParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Tree2UppaalParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(Tree2UppaalParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(Tree2UppaalParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(Tree2UppaalParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(Tree2UppaalParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(Tree2UppaalParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(Tree2UppaalParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void enterFunctionprototype(Tree2UppaalParser.FunctionprototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void exitFunctionprototype(Tree2UppaalParser.FunctionprototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(Tree2UppaalParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(Tree2UppaalParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Tree2UppaalParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Tree2UppaalParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Tree2UppaalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Tree2UppaalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(Tree2UppaalParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(Tree2UppaalParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(Tree2UppaalParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(Tree2UppaalParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#switch}.
	 * @param ctx the parse tree
	 */
	void enterSwitch(Tree2UppaalParser.SwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#switch}.
	 * @param ctx the parse tree
	 */
	void exitSwitch(Tree2UppaalParser.SwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_case(Tree2UppaalParser.Switch_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_case(Tree2UppaalParser.Switch_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(Tree2UppaalParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(Tree2UppaalParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Tree2UppaalParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Tree2UppaalParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void enterLeftAttribute(Tree2UppaalParser.LeftAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void exitLeftAttribute(Tree2UppaalParser.LeftAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void enterOperatorOrEmpty(Tree2UppaalParser.OperatorOrEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void exitOperatorOrEmpty(Tree2UppaalParser.OperatorOrEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void enterAssignedSide(Tree2UppaalParser.AssignedSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void exitAssignedSide(Tree2UppaalParser.AssignedSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(Tree2UppaalParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(Tree2UppaalParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Tree2UppaalParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Tree2UppaalParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(Tree2UppaalParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(Tree2UppaalParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void enterDataTypes(Tree2UppaalParser.DataTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void exitDataTypes(Tree2UppaalParser.DataTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Tree2UppaalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Tree2UppaalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Tree2UppaalParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Tree2UppaalParser.OperatorContext ctx);
}