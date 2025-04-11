// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2UppaalTransformation//Tree2Uppaal.g4 by ANTLR 4.13.1

package Tree2UppaalTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Tree2UppaalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Tree2UppaalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Tree2UppaalParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(Tree2UppaalParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(Tree2UppaalParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(Tree2UppaalParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(Tree2UppaalParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Tree2UppaalParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(Tree2UppaalParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(Tree2UppaalParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(Tree2UppaalParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#functionprototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionprototype(Tree2UppaalParser.FunctionprototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(Tree2UppaalParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Tree2UppaalParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Tree2UppaalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(Tree2UppaalParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(Tree2UppaalParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#switch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch(Tree2UppaalParser.SwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_case(Tree2UppaalParser.Switch_caseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(Tree2UppaalParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Tree2UppaalParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#leftAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftAttribute(Tree2UppaalParser.LeftAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorOrEmpty(Tree2UppaalParser.OperatorOrEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#assignedSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignedSide(Tree2UppaalParser.AssignedSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(Tree2UppaalParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Tree2UppaalParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(Tree2UppaalParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#dataTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypes(Tree2UppaalParser.DataTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Tree2UppaalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2UppaalParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Tree2UppaalParser.OperatorContext ctx);
}