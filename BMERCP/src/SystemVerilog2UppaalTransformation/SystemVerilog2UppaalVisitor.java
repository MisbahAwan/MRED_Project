// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2UppaalTransformation//SystemVerilog2Uppaal.g4 by ANTLR 4.13.1

package SystemVerilog2UppaalTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SystemVerilog2UppaalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SystemVerilog2UppaalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SystemVerilog2UppaalParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(SystemVerilog2UppaalParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(SystemVerilog2UppaalParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#initialBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialBlock(SystemVerilog2UppaalParser.InitialBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(SystemVerilog2UppaalParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(SystemVerilog2UppaalParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SystemVerilog2UppaalParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(SystemVerilog2UppaalParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SystemVerilog2UppaalParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SystemVerilog2UppaalParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SystemVerilog2UppaalParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SystemVerilog2UppaalParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SystemVerilog2UppaalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(SystemVerilog2UppaalParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SystemVerilog2UppaalParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SystemVerilog2UppaalParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(SystemVerilog2UppaalParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(SystemVerilog2UppaalParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SystemVerilog2UppaalParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(SystemVerilog2UppaalParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(SystemVerilog2UppaalParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(SystemVerilog2UppaalParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(SystemVerilog2UppaalParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#bitsArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitsArgument(SystemVerilog2UppaalParser.BitsArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(SystemVerilog2UppaalParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SystemVerilog2UppaalParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(SystemVerilog2UppaalParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SystemVerilog2UppaalParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SystemVerilog2UppaalParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(SystemVerilog2UppaalParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(SystemVerilog2UppaalParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(SystemVerilog2UppaalParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SystemVerilog2UppaalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SystemVerilog2UppaalParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(SystemVerilog2UppaalParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(SystemVerilog2UppaalParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#displayStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayStatement(SystemVerilog2UppaalParser.DisplayStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2UppaalParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(SystemVerilog2UppaalParser.CommentContext ctx);
}