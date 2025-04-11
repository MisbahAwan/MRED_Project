// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2TreeTransformation//SystemVerilog2Tree.g4 by ANTLR 4.13.1

package SystemVerilog2TreeTransformation;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystemVerilog2TreeParser}.
 */
public interface SystemVerilog2TreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SystemVerilog2TreeParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SystemVerilog2TreeParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(SystemVerilog2TreeParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(SystemVerilog2TreeParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(SystemVerilog2TreeParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(SystemVerilog2TreeParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void enterInitialBlock(SystemVerilog2TreeParser.InitialBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#initialBlock}.
	 * @param ctx the parse tree
	 */
	void exitInitialBlock(SystemVerilog2TreeParser.InitialBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(SystemVerilog2TreeParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(SystemVerilog2TreeParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(SystemVerilog2TreeParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(SystemVerilog2TreeParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SystemVerilog2TreeParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SystemVerilog2TreeParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(SystemVerilog2TreeParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(SystemVerilog2TreeParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SystemVerilog2TreeParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SystemVerilog2TreeParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SystemVerilog2TreeParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SystemVerilog2TreeParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifier(SystemVerilog2TreeParser.QualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifier(SystemVerilog2TreeParser.QualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SystemVerilog2TreeParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SystemVerilog2TreeParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SystemVerilog2TreeParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SystemVerilog2TreeParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SystemVerilog2TreeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SystemVerilog2TreeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(SystemVerilog2TreeParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(SystemVerilog2TreeParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SystemVerilog2TreeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SystemVerilog2TreeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SystemVerilog2TreeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SystemVerilog2TreeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(SystemVerilog2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(SystemVerilog2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(SystemVerilog2TreeParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(SystemVerilog2TreeParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SystemVerilog2TreeParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SystemVerilog2TreeParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(SystemVerilog2TreeParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(SystemVerilog2TreeParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SystemVerilog2TreeParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SystemVerilog2TreeParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(SystemVerilog2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(SystemVerilog2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(SystemVerilog2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(SystemVerilog2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void enterBitsArgument(SystemVerilog2TreeParser.BitsArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#bitsArgument}.
	 * @param ctx the parse tree
	 */
	void exitBitsArgument(SystemVerilog2TreeParser.BitsArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(SystemVerilog2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(SystemVerilog2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SystemVerilog2TreeParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SystemVerilog2TreeParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(SystemVerilog2TreeParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(SystemVerilog2TreeParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SystemVerilog2TreeParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SystemVerilog2TreeParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SystemVerilog2TreeParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SystemVerilog2TreeParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(SystemVerilog2TreeParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(SystemVerilog2TreeParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(SystemVerilog2TreeParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(SystemVerilog2TreeParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(SystemVerilog2TreeParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(SystemVerilog2TreeParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SystemVerilog2TreeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SystemVerilog2TreeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SystemVerilog2TreeParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SystemVerilog2TreeParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SystemVerilog2TreeParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SystemVerilog2TreeParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(SystemVerilog2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(SystemVerilog2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void enterDisplayStatement(SystemVerilog2TreeParser.DisplayStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#displayStatement}.
	 * @param ctx the parse tree
	 */
	void exitDisplayStatement(SystemVerilog2TreeParser.DisplayStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemVerilog2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SystemVerilog2TreeParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemVerilog2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SystemVerilog2TreeParser.CommentContext ctx);
}