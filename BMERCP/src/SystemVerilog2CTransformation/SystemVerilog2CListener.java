// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2CTransformation//SystemVerilog2C.g4 by ANTLR 4.13.1

package SystemVerilog2CTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystemVerilog2CParser}.
 */
public interface SystemVerilog2CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SystemVerilog2CParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SystemVerilog2CParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(SystemVerilog2CParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(SystemVerilog2CParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(SystemVerilog2CParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(SystemVerilog2CParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void enterInitialBlock(SystemVerilog2CParser.InitialBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void exitInitialBlock(SystemVerilog2CParser.InitialBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(SystemVerilog2CParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(SystemVerilog2CParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(SystemVerilog2CParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(SystemVerilog2CParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SystemVerilog2CParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SystemVerilog2CParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(SystemVerilog2CParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(SystemVerilog2CParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SystemVerilog2CParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SystemVerilog2CParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SystemVerilog2CParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SystemVerilog2CParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SystemVerilog2CParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SystemVerilog2CParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SystemVerilog2CParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SystemVerilog2CParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SystemVerilog2CParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SystemVerilog2CParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(SystemVerilog2CParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(SystemVerilog2CParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SystemVerilog2CParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SystemVerilog2CParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SystemVerilog2CParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SystemVerilog2CParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(SystemVerilog2CParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(SystemVerilog2CParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(SystemVerilog2CParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(SystemVerilog2CParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SystemVerilog2CParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SystemVerilog2CParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(SystemVerilog2CParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(SystemVerilog2CParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SystemVerilog2CParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SystemVerilog2CParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(SystemVerilog2CParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(SystemVerilog2CParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(SystemVerilog2CParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(SystemVerilog2CParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void enterBitsArgument(SystemVerilog2CParser.BitsArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void exitBitsArgument(SystemVerilog2CParser.BitsArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(SystemVerilog2CParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(SystemVerilog2CParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SystemVerilog2CParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SystemVerilog2CParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(SystemVerilog2CParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(SystemVerilog2CParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SystemVerilog2CParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SystemVerilog2CParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SystemVerilog2CParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SystemVerilog2CParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(SystemVerilog2CParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(SystemVerilog2CParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(SystemVerilog2CParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(SystemVerilog2CParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(SystemVerilog2CParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(SystemVerilog2CParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SystemVerilog2CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SystemVerilog2CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SystemVerilog2CParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SystemVerilog2CParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SystemVerilog2CParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SystemVerilog2CParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(SystemVerilog2CParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(SystemVerilog2CParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void enterDisplayStatement(SystemVerilog2CParser.DisplayStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void exitDisplayStatement(SystemVerilog2CParser.DisplayStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SystemVerilog2CParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2CParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SystemVerilog2CParser.CommentContext ctx);
}