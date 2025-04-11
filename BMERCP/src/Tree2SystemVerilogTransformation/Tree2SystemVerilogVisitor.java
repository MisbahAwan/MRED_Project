// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2SystemVerilogTransformation//Tree2SystemVerilog.g4 by ANTLR 4.13.1

package Tree2SystemVerilogTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Tree2SystemVerilogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Tree2SystemVerilogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Tree2SystemVerilogParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(Tree2SystemVerilogParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(Tree2SystemVerilogParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(Tree2SystemVerilogParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(Tree2SystemVerilogParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Tree2SystemVerilogParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(Tree2SystemVerilogParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(Tree2SystemVerilogParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(Tree2SystemVerilogParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#functionprototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionprototype(Tree2SystemVerilogParser.FunctionprototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(Tree2SystemVerilogParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Tree2SystemVerilogParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Tree2SystemVerilogParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(Tree2SystemVerilogParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(Tree2SystemVerilogParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#switch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch(Tree2SystemVerilogParser.SwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_case(Tree2SystemVerilogParser.Switch_caseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(Tree2SystemVerilogParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Tree2SystemVerilogParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#leftAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftAttribute(Tree2SystemVerilogParser.LeftAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorOrEmpty(Tree2SystemVerilogParser.OperatorOrEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#assignedSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignedSide(Tree2SystemVerilogParser.AssignedSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(Tree2SystemVerilogParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Tree2SystemVerilogParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(Tree2SystemVerilogParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#dataTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypes(Tree2SystemVerilogParser.DataTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Tree2SystemVerilogParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2SystemVerilogParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Tree2SystemVerilogParser.OperatorContext ctx);
}