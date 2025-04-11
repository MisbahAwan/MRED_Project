// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2SystemVerilogTransformation//Tree2SystemVerilog.g4 by ANTLR 4.13.1

package Tree2SystemVerilogTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Tree2SystemVerilogParser}.
 */
public interface Tree2SystemVerilogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(Tree2SystemVerilogParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(Tree2SystemVerilogParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(Tree2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(Tree2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(Tree2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(Tree2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(Tree2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(Tree2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(Tree2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(Tree2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(Tree2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(Tree2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(Tree2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(Tree2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(Tree2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(Tree2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(Tree2SystemVerilogParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(Tree2SystemVerilogParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void enterFunctionprototype(Tree2SystemVerilogParser.FunctionprototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#functionprototype}.
	 * @param ctx the parse tree
	 */
	void exitFunctionprototype(Tree2SystemVerilogParser.FunctionprototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(Tree2SystemVerilogParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(Tree2SystemVerilogParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Tree2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Tree2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Tree2SystemVerilogParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Tree2SystemVerilogParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(Tree2SystemVerilogParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(Tree2SystemVerilogParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(Tree2SystemVerilogParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(Tree2SystemVerilogParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#switch}.
	 * @param ctx the parse tree
	 */
	void enterSwitch(Tree2SystemVerilogParser.SwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#switch}.
	 * @param ctx the parse tree
	 */
	void exitSwitch(Tree2SystemVerilogParser.SwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_case(Tree2SystemVerilogParser.Switch_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_case(Tree2SystemVerilogParser.Switch_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(Tree2SystemVerilogParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(Tree2SystemVerilogParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Tree2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Tree2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void enterLeftAttribute(Tree2SystemVerilogParser.LeftAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#leftAttribute}.
	 * @param ctx the parse tree
	 */
	void exitLeftAttribute(Tree2SystemVerilogParser.LeftAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void enterOperatorOrEmpty(Tree2SystemVerilogParser.OperatorOrEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 */
	void exitOperatorOrEmpty(Tree2SystemVerilogParser.OperatorOrEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void enterAssignedSide(Tree2SystemVerilogParser.AssignedSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#assignedSide}.
	 * @param ctx the parse tree
	 */
	void exitAssignedSide(Tree2SystemVerilogParser.AssignedSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(Tree2SystemVerilogParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(Tree2SystemVerilogParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Tree2SystemVerilogParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Tree2SystemVerilogParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(Tree2SystemVerilogParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(Tree2SystemVerilogParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void enterDataTypes(Tree2SystemVerilogParser.DataTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#dataTypes}.
	 * @param ctx the parse tree
	 */
	void exitDataTypes(Tree2SystemVerilogParser.DataTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Tree2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Tree2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Tree2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Tree2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Tree2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Tree2SystemVerilogParser.OperatorContext ctx);
}