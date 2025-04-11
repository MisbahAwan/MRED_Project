// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//C2SystemVerilogTransformations//C2SystemVerilog.g4 by ANTLR 4.13.1

package C2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C2SystemVerilogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C2SystemVerilogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(C2SystemVerilogParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(C2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(C2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(C2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(C2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(C2SystemVerilogParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(C2SystemVerilogParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(C2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(C2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(C2SystemVerilogParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(C2SystemVerilogParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(C2SystemVerilogParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(C2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(C2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(C2SystemVerilogParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(C2SystemVerilogParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(C2SystemVerilogParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(C2SystemVerilogParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(C2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(C2SystemVerilogParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(C2SystemVerilogParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(C2SystemVerilogParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(C2SystemVerilogParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(C2SystemVerilogParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(C2SystemVerilogParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(C2SystemVerilogParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#functionCallArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgument(C2SystemVerilogParser.FunctionCallArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(C2SystemVerilogParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(C2SystemVerilogParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(C2SystemVerilogParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(C2SystemVerilogParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(C2SystemVerilogParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(C2SystemVerilogParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(C2SystemVerilogParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(C2SystemVerilogParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(C2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(C2SystemVerilogParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(C2SystemVerilogParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(C2SystemVerilogParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(C2SystemVerilogParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(C2SystemVerilogParser.CommentContext ctx);
}