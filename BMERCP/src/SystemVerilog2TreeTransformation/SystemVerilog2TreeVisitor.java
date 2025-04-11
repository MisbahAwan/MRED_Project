// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2TreeTransformation//SystemVerilog2Tree.g4 by ANTLR 4.13.1

package SystemVerilog2TreeTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SystemVerilog2TreeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SystemVerilog2TreeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SystemVerilog2TreeParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(SystemVerilog2TreeParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(SystemVerilog2TreeParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#initialBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialBlock(SystemVerilog2TreeParser.InitialBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(SystemVerilog2TreeParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(SystemVerilog2TreeParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SystemVerilog2TreeParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(SystemVerilog2TreeParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SystemVerilog2TreeParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SystemVerilog2TreeParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifier(SystemVerilog2TreeParser.QualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SystemVerilog2TreeParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SystemVerilog2TreeParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SystemVerilog2TreeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(SystemVerilog2TreeParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SystemVerilog2TreeParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SystemVerilog2TreeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(SystemVerilog2TreeParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(SystemVerilog2TreeParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SystemVerilog2TreeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(SystemVerilog2TreeParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(SystemVerilog2TreeParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(SystemVerilog2TreeParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(SystemVerilog2TreeParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#bitsArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitsArgument(SystemVerilog2TreeParser.BitsArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(SystemVerilog2TreeParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SystemVerilog2TreeParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(SystemVerilog2TreeParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SystemVerilog2TreeParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SystemVerilog2TreeParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(SystemVerilog2TreeParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(SystemVerilog2TreeParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(SystemVerilog2TreeParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SystemVerilog2TreeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SystemVerilog2TreeParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(SystemVerilog2TreeParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(SystemVerilog2TreeParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#displayStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayStatement(SystemVerilog2TreeParser.DisplayStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2TreeParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(SystemVerilog2TreeParser.CommentContext ctx);
}