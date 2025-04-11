// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2UppaalTransformation//SystemVerilog2Uppaal.g4 by ANTLR 4.13.1

package SystemVerilog2UppaalTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystemVerilog2UppaalParser}.
 */
public interface SystemVerilog2UppaalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SystemVerilog2UppaalParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SystemVerilog2UppaalParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(SystemVerilog2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(SystemVerilog2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(SystemVerilog2UppaalParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(SystemVerilog2UppaalParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void enterInitialBlock(SystemVerilog2UppaalParser.InitialBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void exitInitialBlock(SystemVerilog2UppaalParser.InitialBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(SystemVerilog2UppaalParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(SystemVerilog2UppaalParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(SystemVerilog2UppaalParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(SystemVerilog2UppaalParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SystemVerilog2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SystemVerilog2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(SystemVerilog2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(SystemVerilog2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SystemVerilog2UppaalParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SystemVerilog2UppaalParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SystemVerilog2UppaalParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SystemVerilog2UppaalParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SystemVerilog2UppaalParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SystemVerilog2UppaalParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SystemVerilog2UppaalParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SystemVerilog2UppaalParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SystemVerilog2UppaalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SystemVerilog2UppaalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(SystemVerilog2UppaalParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(SystemVerilog2UppaalParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SystemVerilog2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SystemVerilog2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SystemVerilog2UppaalParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SystemVerilog2UppaalParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(SystemVerilog2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(SystemVerilog2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(SystemVerilog2UppaalParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(SystemVerilog2UppaalParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SystemVerilog2UppaalParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SystemVerilog2UppaalParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(SystemVerilog2UppaalParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(SystemVerilog2UppaalParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SystemVerilog2UppaalParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SystemVerilog2UppaalParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(SystemVerilog2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(SystemVerilog2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(SystemVerilog2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(SystemVerilog2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void enterBitsArgument(SystemVerilog2UppaalParser.BitsArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void exitBitsArgument(SystemVerilog2UppaalParser.BitsArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(SystemVerilog2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(SystemVerilog2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SystemVerilog2UppaalParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SystemVerilog2UppaalParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(SystemVerilog2UppaalParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(SystemVerilog2UppaalParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SystemVerilog2UppaalParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SystemVerilog2UppaalParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SystemVerilog2UppaalParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SystemVerilog2UppaalParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(SystemVerilog2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(SystemVerilog2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(SystemVerilog2UppaalParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(SystemVerilog2UppaalParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(SystemVerilog2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(SystemVerilog2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SystemVerilog2UppaalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SystemVerilog2UppaalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SystemVerilog2UppaalParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SystemVerilog2UppaalParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SystemVerilog2UppaalParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SystemVerilog2UppaalParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(SystemVerilog2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(SystemVerilog2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void enterDisplayStatement(SystemVerilog2UppaalParser.DisplayStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void exitDisplayStatement(SystemVerilog2UppaalParser.DisplayStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SystemVerilog2UppaalParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SystemVerilog2UppaalParser.CommentContext ctx);
}