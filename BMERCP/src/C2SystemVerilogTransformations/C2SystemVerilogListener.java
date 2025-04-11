// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2SystemVerilogTransformations//C2SystemVerilog.g4 by ANTLR 4.13.1

package C2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C2SystemVerilogParser}.
 */
public interface C2SystemVerilogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(C2SystemVerilogParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(C2SystemVerilogParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(C2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(C2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(C2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(C2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(C2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(C2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(C2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(C2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(C2SystemVerilogParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(C2SystemVerilogParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(C2SystemVerilogParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(C2SystemVerilogParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(C2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(C2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(C2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(C2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(C2SystemVerilogParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(C2SystemVerilogParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(C2SystemVerilogParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(C2SystemVerilogParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(C2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(C2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(C2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(C2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(C2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(C2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(C2SystemVerilogParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(C2SystemVerilogParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C2SystemVerilogParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C2SystemVerilogParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(C2SystemVerilogParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(C2SystemVerilogParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(C2SystemVerilogParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(C2SystemVerilogParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(C2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(C2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(C2SystemVerilogParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(C2SystemVerilogParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(C2SystemVerilogParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(C2SystemVerilogParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(C2SystemVerilogParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(C2SystemVerilogParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(C2SystemVerilogParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(C2SystemVerilogParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(C2SystemVerilogParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(C2SystemVerilogParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(C2SystemVerilogParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(C2SystemVerilogParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(C2SystemVerilogParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(C2SystemVerilogParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgument(C2SystemVerilogParser.FunctionCallArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgument(C2SystemVerilogParser.FunctionCallArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(C2SystemVerilogParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(C2SystemVerilogParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(C2SystemVerilogParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(C2SystemVerilogParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(C2SystemVerilogParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(C2SystemVerilogParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(C2SystemVerilogParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(C2SystemVerilogParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(C2SystemVerilogParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(C2SystemVerilogParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(C2SystemVerilogParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(C2SystemVerilogParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(C2SystemVerilogParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(C2SystemVerilogParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(C2SystemVerilogParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(C2SystemVerilogParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(C2SystemVerilogParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(C2SystemVerilogParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(C2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(C2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(C2SystemVerilogParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(C2SystemVerilogParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(C2SystemVerilogParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(C2SystemVerilogParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(C2SystemVerilogParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(C2SystemVerilogParser.CommentContext ctx);
}