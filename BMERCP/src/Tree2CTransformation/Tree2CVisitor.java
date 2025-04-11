// Generated from E://EclipseWorkspaces//GUIProjectWorkSpace//BMERCP//src//Tree2CTransformation//Tree2C.g4 by ANTLR 4.13.1

package Tree2CTransformation;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Tree2CParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Tree2CVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(Tree2CParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(Tree2CParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(Tree2CParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#systemInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemInclude(Tree2CParser.SystemIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#localInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalInclude(Tree2CParser.LocalIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Tree2CParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(Tree2CParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#enumList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumList(Tree2CParser.EnumListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(Tree2CParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#functionprototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionprototype(Tree2CParser.FunctionprototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(Tree2CParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Tree2CParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Tree2CParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(Tree2CParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(Tree2CParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#switch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch(Tree2CParser.SwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_case(Tree2CParser.Switch_caseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(Tree2CParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Tree2CParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#leftAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftAttribute(Tree2CParser.LeftAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#operatorOrEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorOrEmpty(Tree2CParser.OperatorOrEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#assignedSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignedSide(Tree2CParser.AssignedSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(Tree2CParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Tree2CParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(Tree2CParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#dataTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypes(Tree2CParser.DataTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Tree2CParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Tree2CParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Tree2CParser.OperatorContext ctx);
}