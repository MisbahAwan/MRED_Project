// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//SystemVerilog2CTransformation//SystemVerilog2C.g4 by ANTLR 4.13.1

package SystemVerilog2CTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SystemVerilog2CParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SystemVerilog2CVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SystemVerilog2CParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#moduleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDecl(SystemVerilog2CParser.ModuleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#moduleItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItem(SystemVerilog2CParser.ModuleItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#initialBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialBlock(SystemVerilog2CParser.InitialBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(SystemVerilog2CParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(SystemVerilog2CParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SystemVerilog2CParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(SystemVerilog2CParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SystemVerilog2CParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SystemVerilog2CParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SystemVerilog2CParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SystemVerilog2CParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SystemVerilog2CParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#statementTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTwo(SystemVerilog2CParser.StatementTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SystemVerilog2CParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SystemVerilog2CParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(SystemVerilog2CParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#indexedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedID(SystemVerilog2CParser.IndexedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SystemVerilog2CParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(SystemVerilog2CParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(SystemVerilog2CParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#transformedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformedArgument(SystemVerilog2CParser.TransformedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#dataCastArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataCastArgument(SystemVerilog2CParser.DataCastArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#bitsArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitsArgument(SystemVerilog2CParser.BitsArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#functionCallID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallID(SystemVerilog2CParser.FunctionCallIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SystemVerilog2CParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(SystemVerilog2CParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SystemVerilog2CParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SystemVerilog2CParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(SystemVerilog2CParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(SystemVerilog2CParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#defaultBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBlock(SystemVerilog2CParser.DefaultBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SystemVerilog2CParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SystemVerilog2CParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(SystemVerilog2CParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#castFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionCall(SystemVerilog2CParser.CastFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#displayStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplayStatement(SystemVerilog2CParser.DisplayStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemVerilog2CParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(SystemVerilog2CParser.CommentContext ctx);
}