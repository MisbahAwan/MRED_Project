// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2CTransformation//Tree2C.g4 by ANTLR 4.13.1

package Tree2CTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Tree2CParser}.
 */
public interface Tree2CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Tree2CParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Tree2CParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(Tree2CParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(Tree2CParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(Tree2CParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(Tree2CParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(Tree2CParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(Tree2CParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(Tree2CParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(Tree2CParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Tree2CParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Tree2CParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(Tree2CParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(Tree2CParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(Tree2CParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(Tree2CParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(Tree2CParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(Tree2CParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void enterFunctionprototype(Tree2CParser.FunctionprototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void exitFunctionprototype(Tree2CParser.FunctionprototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(Tree2CParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(Tree2CParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Tree2CParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Tree2CParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Tree2CParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Tree2CParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(Tree2CParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(Tree2CParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(Tree2CParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(Tree2CParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#switch}.
	 * @param ctx the parse tree
	 */
	void enterSwitch(Tree2CParser.SwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#switch}.
	 * @param ctx the parse tree
	 */
	void exitSwitch(Tree2CParser.SwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_case(Tree2CParser.Switch_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_case(Tree2CParser.Switch_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(Tree2CParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(Tree2CParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Tree2CParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Tree2CParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void enterLeftAttribute(Tree2CParser.LeftAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void exitLeftAttribute(Tree2CParser.LeftAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void enterOperatorOrEmpty(Tree2CParser.OperatorOrEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void exitOperatorOrEmpty(Tree2CParser.OperatorOrEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void enterAssignedSide(Tree2CParser.AssignedSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void exitAssignedSide(Tree2CParser.AssignedSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(Tree2CParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(Tree2CParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Tree2CParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Tree2CParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(Tree2CParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(Tree2CParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void enterDataTypes(Tree2CParser.DataTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void exitDataTypes(Tree2CParser.DataTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Tree2CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Tree2CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Tree2CParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Tree2CParser.OperatorContext ctx);
}