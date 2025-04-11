// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2UppaalTransformations//C2Uppaal.g4 by ANTLR 4.13.1

package C2UppaalTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C2UppaalParser}.
 */
public interface C2UppaalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(C2UppaalParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(C2UppaalParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(C2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(C2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(C2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(C2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(C2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(C2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(C2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(C2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(C2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(C2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(C2UppaalParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(C2UppaalParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(C2UppaalParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(C2UppaalParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(C2UppaalParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(C2UppaalParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(C2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(C2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(C2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(C2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(C2UppaalParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(C2UppaalParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(C2UppaalParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(C2UppaalParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(C2UppaalParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(C2UppaalParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C2UppaalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C2UppaalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(C2UppaalParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(C2UppaalParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(C2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(C2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(C2UppaalParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(C2UppaalParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(C2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(C2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(C2UppaalParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(C2UppaalParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(C2UppaalParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(C2UppaalParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(C2UppaalParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(C2UppaalParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(C2UppaalParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(C2UppaalParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(C2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(C2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(C2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(C2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgument(C2UppaalParser.FunctionCallArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgument(C2UppaalParser.FunctionCallArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(C2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(C2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(C2UppaalParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(C2UppaalParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(C2UppaalParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(C2UppaalParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(C2UppaalParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(C2UppaalParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(C2UppaalParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(C2UppaalParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(C2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(C2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(C2UppaalParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(C2UppaalParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(C2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(C2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C2UppaalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C2UppaalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(C2UppaalParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(C2UppaalParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(C2UppaalParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(C2UppaalParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(C2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(C2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(C2UppaalParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(C2UppaalParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(C2UppaalParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2UppaalParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(C2UppaalParser.CommentContext ctx);
}