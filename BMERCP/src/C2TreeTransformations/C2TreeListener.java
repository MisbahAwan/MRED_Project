// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2TreeTransformations//C2Tree.g4 by ANTLR 4.13.1

package C2TreeTransformations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C2TreeParser}.
 */
public interface C2TreeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(C2TreeParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(C2TreeParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(C2TreeParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(C2TreeParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(C2TreeParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(C2TreeParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void enterSystemInclude(C2TreeParser.SystemIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#systemInclude}.
	 * @param ctx the parse tree
	 */
	void exitSystemInclude(C2TreeParser.SystemIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void enterLocalInclude(C2TreeParser.LocalIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#localInclude}.
	 * @param ctx the parse tree
	 */
	void exitLocalInclude(C2TreeParser.LocalIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void enterModuleDecl(C2TreeParser.ModuleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 */
	void exitModuleDecl(C2TreeParser.ModuleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void enterModuleItem(C2TreeParser.ModuleItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 */
	void exitModuleItem(C2TreeParser.ModuleItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(C2TreeParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(C2TreeParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void enterEnumList(C2TreeParser.EnumListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#enumList}.
	 * @param ctx the parse tree
	 */
	void exitEnumList(C2TreeParser.EnumListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(C2TreeParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(C2TreeParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(C2TreeParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(C2TreeParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(C2TreeParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(C2TreeParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifier(C2TreeParser.QualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifier(C2TreeParser.QualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(C2TreeParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(C2TreeParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(C2TreeParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(C2TreeParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C2TreeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C2TreeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void enterStatementTwo(C2TreeParser.StatementTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 */
	void exitStatementTwo(C2TreeParser.StatementTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(C2TreeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(C2TreeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(C2TreeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(C2TreeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentType(C2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentType(C2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void enterIndexedID(C2TreeParser.IndexedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 */
	void exitIndexedID(C2TreeParser.IndexedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(C2TreeParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(C2TreeParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(C2TreeParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(C2TreeParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(C2TreeParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(C2TreeParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void enterTransformedArgument(C2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 */
	void exitTransformedArgument(C2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void enterDataCastArgument(C2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 */
	void exitDataCastArgument(C2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgument(C2TreeParser.FunctionCallArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#functionCallArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgument(C2TreeParser.FunctionCallArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallID(C2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallID(C2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(C2TreeParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(C2TreeParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(C2TreeParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(C2TreeParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(C2TreeParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(C2TreeParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(C2TreeParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(C2TreeParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(C2TreeParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(C2TreeParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(C2TreeParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(C2TreeParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(C2TreeParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(C2TreeParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C2TreeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C2TreeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(C2TreeParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(C2TreeParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(C2TreeParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(C2TreeParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterCastFunctionCall(C2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitCastFunctionCall(C2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(C2TreeParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(C2TreeParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(C2TreeParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2TreeParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(C2TreeParser.CommentContext ctx);
}