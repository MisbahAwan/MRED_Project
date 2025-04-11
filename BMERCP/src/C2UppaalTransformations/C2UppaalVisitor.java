// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2UppaalTransformations//C2Uppaal.g4 by ANTLR 4.13.1

package C2UppaalTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C2UppaalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C2UppaalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(C2UppaalParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(C2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(C2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(C2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(C2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(C2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(C2UppaalParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(C2UppaalParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(C2UppaalParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(C2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(C2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(C2UppaalParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(C2UppaalParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(C2UppaalParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(C2UppaalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(C2UppaalParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(C2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(C2UppaalParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(C2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(C2UppaalParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(C2UppaalParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(C2UppaalParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(C2UppaalParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(C2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(C2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#functionCallArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgument(C2UppaalParser.FunctionCallArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(C2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(C2UppaalParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(C2UppaalParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(C2UppaalParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(C2UppaalParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(C2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(C2UppaalParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(C2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(C2UppaalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(C2UppaalParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(C2UppaalParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(C2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(C2UppaalParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2UppaalParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(C2UppaalParser.CommentContext ctx);
}