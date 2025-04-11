// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2TreeTransformations//C2Tree.g4 by ANTLR 4.13.1

package C2TreeTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C2TreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C2TreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(C2TreeParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(C2TreeParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(C2TreeParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(C2TreeParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(C2TreeParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(C2TreeParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(C2TreeParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(C2TreeParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(C2TreeParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(C2TreeParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(C2TreeParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(C2TreeParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifier(C2TreeParser.QualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(C2TreeParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(C2TreeParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(C2TreeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(C2TreeParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(C2TreeParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(C2TreeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(C2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(C2TreeParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(C2TreeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(C2TreeParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(C2TreeParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(C2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(C2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#functionCallArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgument(C2TreeParser.FunctionCallArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(C2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(C2TreeParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(C2TreeParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(C2TreeParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(C2TreeParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(C2TreeParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(C2TreeParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(C2TreeParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(C2TreeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(C2TreeParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(C2TreeParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(C2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(C2TreeParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2TreeParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(C2TreeParser.CommentContext ctx);
}