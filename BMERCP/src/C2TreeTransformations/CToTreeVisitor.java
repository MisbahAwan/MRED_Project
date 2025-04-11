package C2TreeTransformations;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import C2SystemVerilogTransformations.C2SystemVerilogParser;
import C2SystemVerilogTransformations.C2SystemVerilogParser.ModuleDeclContext;
import C2SystemVerilogTransformations.C2SystemVerilogParser.ParameterListContext;
import C2TreeTransformations.C2TreeBaseVisitor;
import C2TreeTransformations.C2TreeParser;
import C2TreeTransformations.C2TreeParser.*;

public class CToTreeVisitor extends C2TreeBaseVisitor<String> {
		
		boolean flagToGetOpenBracesOnce=true;
		boolean flagToGetCloseBracesOnce=true;
		boolean flagElseBrace=false;
		
		boolean openDeclarationTag=true;
		boolean closeDeclarationTag=true;
		boolean GuardOn=false;
		boolean IfOrElseIf=false;
	    
	    @Override
	    public String visitFile(C2TreeParser.FileContext ctx) {
	    	
	    	StringBuilder output = new StringBuilder();
	    	
	    	output.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	    	output.append("<dSML:System\n");
	    	output.append("    xmi:version=\"2.0\"\n");
	    	output.append("    xmlns:xmi=\"http://www.omg.org/XMI\"\n");
	    	output.append("    xmlns:dSML=\"http://www.example.org/dSML\">\n");
	    	
	    	// Loop through each child node in the file rule
	        for (ParseTree child : ctx.children) {
	            if (child instanceof C2TreeParser.PreprocessorDirectiveContext) {
	            	// Visit preprocessor directive
	            	output.append(visitPreprocessorDirective((C2TreeParser.PreprocessorDirectiveContext) child));
	            } 
	            else if (child instanceof C2TreeParser.IncludeDirectiveContext) {
	            	// Visit include directive
	            	output.append(visitIncludeDirective((C2TreeParser.IncludeDirectiveContext) child));
	            } 
	            else if (child instanceof C2TreeParser.CommentContext) {
	            	// Visit module declaration
	            	output.append(visitComment((C2TreeParser.CommentContext) child));
	            } 
	            else if (child instanceof C2TreeParser.ModuleDeclContext) {
	            	// Visit module declaration
	            	output.append(visitModuleDecl((C2TreeParser.ModuleDeclContext) child));
	            } 
	            else if (child instanceof C2TreeParser.ModuleItemContext) {
	            	// Visit module declaration
	            	output.append(visitModuleItem((C2TreeParser.ModuleItemContext) child));
	            }
	        }
	    	output.append("\n</dSML:System>");
	        return output.toString();

	    }
	    
	    @Override
	    public String visitPreprocessorDirective(C2TreeParser.PreprocessorDirectiveContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String define = ctx.DEFINE().getText();
	        String id = ctx.ID().getText();
	        String value = ctx.INT().getText();
	        
	        result.append("    <preprocessordirective\n        keyword=\""+define.trim()+"\"\n");
        	result.append("        name=\""+id.trim()+"\"\n");
        	result.append("        value=\""+value.trim()+"\"/>\n");
	       
	        return result.toString();
	    }

	    @Override
	    public String visitIncludeDirective(C2TreeParser.IncludeDirectiveContext ctx) {
	    	
	    	return  visit(ctx.systemInclude() != null ? ctx.systemInclude() : ctx.localInclude());
	    	 
	    }

	    @Override
	    public String visitSystemInclude(C2TreeParser.SystemIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	
	    	result.append("  <includedirective\n        keyword=\"#include\"\n");
        	result.append("        name=\"&lt;"+header.trim()+">\"/>\n");
        	
	    	//result.append("// ").append( "#include <" + header + ">").append(" \n");
	        
	        return result.toString();
	    }

	    @Override
	    public String visitLocalInclude(C2TreeParser.LocalIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	
	    	result.append("  <includedirective\n        keyword=\"#include\"\n");
        	result.append("        name=\""+header.trim()+"\"/>\n");
        		        
	        return result.toString();
	    }
		
	    @Override
	    public String visitEnumDecl(C2TreeParser.EnumDeclContext ctx) {
	        
	    	StringBuilder result = new StringBuilder();
	    	String typedef = ctx.TYPEDEF().getText();
	        String enumType = ctx.ENUM().getText();
	        String enumName = ctx.ID().getText();
	        
	        if(openDeclarationTag==true)
	        	result.append("  <declaration>\n");
	        
	        result.append("    <enum  enumID=\""+enumName+"\">\n");
	        
	        result.append(visitEnumList(ctx.enumList()));
	        
	        result.append("    </enum>\n");
	        
	        if(openDeclarationTag==true)
	        	result.append("  </declaration>\n");
	       
	        return result.toString();

	    }

	    @Override
	    public String visitEnumList(C2TreeParser.EnumListContext ctx) {
	    	    	
	        StringBuilder enums = new StringBuilder();
	        for (TerminalNode id : ctx.ID()) {
	        	enums.append("        <enumlist  enumItem=\""+id.getText().trim()+"\"/>\n");
	            //enums.append("  "+id.getText()).append(",\n ");
	        }
	        /*if (enums.length() >= 2) {
	        // Remove last comma and \n
	        enums.delete(enums.length() - 3, enums.length());
	        }
	        enums.append("\n");*/
	        return enums.toString();
	    }   
	    
	    @Override
	    public String visitModuleDecl(C2TreeParser.ModuleDeclContext ctx) {
	        StringBuilder result = new StringBuilder();
	        //result.append("");

	        result.append(visitModuleItem(ctx.moduleItem()));
	        
	        return result.toString();
	    }

	    @Override
	    public String visitModuleItem(ModuleItemContext ctx) {
	    	//System.out.println("I am here");
	        StringBuilder result = new StringBuilder();
	        result.append("");
	        if(openDeclarationTag)
	        {
	        	result.append("  <declaration>\n");
	        	openDeclarationTag=false;
	        }
	        var item=ctx;//.moduleItem();
	        //for (var item : ctx.moduleItem()) {

	        	// Check if the module item is a declaration
	            if (item.declaration() != null) {
	            	
	                result.append(visit(item.declaration())).append("\n");
	                
	            }
	            // Check if the module item is a function declaration
	            else if (item.functionDecl() != null) {
	            	if(item.functionDecl().statement(0)!=null)
	            	{
		            	if(closeDeclarationTag)
		            	{
		            		result.append("  </declaration>\n");
		            		closeDeclarationTag=false;
		            	}
		            		String functionName=item.functionDecl().ID().getText();
		            		String returnType=item.functionDecl().returnType().getText();
		            		
		            		result.append("  <component\n");
		            		result.append("      name=\""+functionName+"\"\n");
		            		result.append("      type=\""+returnType+"\">\n");
		                	
		            		if (item.functionDecl().parameterList() != null) {
		                       // result.append(visit(ctx.functionDecl().parameterList()));
		            			//for (var stmt : item.functionDecl().parameterList().) 
		            			result.append(visit(item.functionDecl().parameterList()));
		            	        
		                    }
		            		
		            		
		        	        for (var stmt : item.functionDecl().statement()) {

		        	            result.append(visit(stmt)); 
		        	        }
		        	        result.append("  </component>\n");
	            	}  
	            	else
	            		result.append(visitFunctionDecl(item.functionDecl())).append("\n");
	            		//System.out.println("function has statements..."+item.functionDecl().statement());
	            	} else if (item.enumDecl() != null) {
	            		result.append(visit(item.enumDecl())).append("\n");
	                }
	            	//else if (item.functionDecl() != null) { //System.out.println("function has NO statements...");
	            	//	result.append(visit(item.functionDecl())).append("\n");
	            //}
	            // Check if the module item is a statement
	            else if (item.statement() != null) {
	            	
	               result.append(visit(item.statement())).append("\n");
	            }
	       // }
	        return result.toString();
	    }
	    
	 /*   @Override
	    public String visitInitialBlock(InitialBlockContext ctx) {
	    	return "";
	    }*/
	    
	    @Override
	    public String visitFunctionDecl(FunctionDeclContext ctx) {
	    	
	    	StringBuilder output = new StringBuilder();
	    	String dataType ="", functionName="";
	    	
	    	String parameters="";
	    	if (ctx.parameterList() != null) {
	    		parameters=visit(ctx.parameterList());
	        }
	    	
	    	if(ctx.returnType()!=null)
	    		dataType= ctx.returnType().getText();
	    	
	    	functionName = ctx.ID().getText();
	    	
	    	output.append("    <functionprototype\n");
	    	output.append("        returnType=\""+dataType+"\"\n");
	    	output.append("        functionName=\""+functionName+"\">\n");
	    	output.append("      <parameter name=\""+parameters+"\"/>\n");
	    	
	        output.append("    </functionprototype>\n");
	        return output.toString();
	     }


	    @Override
	    public String visitParameterList(C2TreeParser.ParameterListContext ctx) {
	    	
	    	//parameterList: parameter qualifier? STAR? ID? (COMMA? parameter)* ; 
	    	//void const * argument 
	        StringBuilder result = new StringBuilder();
	        String name="", parameterDataType="", qualifier="", pointer="";
	        
	        for (int i = 0; i < ctx.ID().size(); i++)
		    {
	        
		        parameterDataType=ctx.dataType(i).getText()+" ";
		        
		        if(ctx.qualifier(i)!=null)
		        	qualifier=ctx.qualifier(i).getText()+" ";
	        	if(ctx.STAR(i)!=null)
	        		pointer=ctx.STAR(i).getText()+" ";
	        	if(ctx.ID(i)!=null)
	        		name=ctx.ID(i).getText()+" ";
	        	
	        	result.append("    <parameter\n        name=\""+name.trim()+"\"\n");
	        	result.append("        dataType=\""+parameterDataType.trim()+"\"\n");
	        	result.append("        qualifier=\""+qualifier.trim()+"\"\n");
	        	result.append("        pointer=\""+pointer.trim()+"\"/>\n");
		    }
            
	       
	        return result.toString();
	    }
/*
	    @Override
	    public String visitParameter(ParameterContext ctx) {
	        return ctx.getText(); // Translate SystemVerilog parameter to C parameter if needed
	    }
*/
	    @Override
	    public String visitDeclaration(DeclarationContext ctx) {//System.out.println("im declaration");

	    	StringBuilder output = new StringBuilder();
	    	String extern="";
	    	
	    	if(ctx.EXTERN()!=null)
	    	extern=ctx.EXTERN().getText();
	    	
	    	output.append("    <attribute\n");
	    	output.append("        isGlobal=\""+extern+"\"\n");

	        output.append("        dataType=");
	        output.append("\""+ctx.dataType().getText()+"\"\n");
	        
	        output.append("        name=");
	        output.append("\""+ctx.ID().getText()+"\"\n");
	        
	        output.append("        size=\"");
	        
	        if (ctx.LBRACK() != null) 
	            output.append(ctx.LBRACK().getText()+ctx.INT().getText()+ctx.RBRACK().getText());
	        
	        output.append("\"\n");
	        
	        //initial value
	        output.append("        initialValue=");
	        if(ctx.primary()!=null)
	       	  output.append("\""+ctx.primary().getText()+"\"");
	        else
	        	output.append("\"\"");
	        
	        output.append("/>\n");
	        return output.toString();
	        
	    }

	    @Override
	    public String visitStatement(StatementContext ctx) {
	        if (ctx.assignment() != null) {
	            return visit(ctx.assignment()) ;
	        } else if (ctx.declaration() != null) {
	            return "  <declaration>\n"+visit(ctx.declaration())+"  </declaration>\n" ;
	        } else if (ctx.functionCall() != null) {
	            return visit(ctx.functionCall()) ;
	        } else if (ctx.ifStatement() != null) {
	        	GuardOn=true;
	            return visit(ctx.ifStatement());
	        //} else if (ctx.elseStatement() != null) {
	          //  return visit(ctx.elseStatement());
	        } else if (ctx.loopStatement() != null) {
	            return visit(ctx.loopStatement());
	        } else if (ctx.switchStatement() != null) {
	        	GuardOn=true;
	            return visit(ctx.switchStatement());
	        } else if (ctx.printStatement() != null) {
	            return visit(ctx.printStatement());
	        } else if (ctx.comment() != null) {
	            return visit(ctx.comment());
	        } else if (ctx.returnStatement() != null) {
	            return visit(ctx.returnStatement());
	        }
	        
	        return "456";
	        //return "123";
	    }
	    
	    @Override
	    public String visitStatementTwo(C2TreeParser.StatementTwoContext ctx) {
	    	if (ctx.assignment() != null) {
	            return visit(ctx.assignment()) ;
	        } else if (ctx.declaration() != null) {
	            return "  <declaration>\n"+visit(ctx.declaration())+"  </declaration>\n" ;
	        } else if (ctx.functionCall() != null) {
	            return visit(ctx.functionCall()) ;
	        } else if (ctx.ifStatement() != null) {
	        	GuardOn=true;
	            return visit(ctx.ifStatement());
	        //} else if (ctx.elseStatement() != null) {
	          //  return visit(ctx.elseStatement());
	        } else if (ctx.loopStatement() != null) {
	            return visit(ctx.loopStatement());
	        } else if (ctx.switchStatement() != null) {
	        	GuardOn=true;
	            return visit(ctx.switchStatement());
	        } else if (ctx.printStatement() != null) {
	            return visit(ctx.printStatement());
	        } else if (ctx.comment() != null) {
	            return visit(ctx.comment());
	        } else if (ctx.returnStatement() != null) {
	            return visit(ctx.returnStatement());
	        }
	        
	        return "123";
	        //return "123";
	    }
	    
	    @Override
	    public String visitReturnStatement(C2TreeParser.ReturnStatementContext ctx) {
	    	StringBuilder result = new StringBuilder();
	        if (ctx.expression() != null) {
	            // If there's an expression in the return statement, visit it
	            //Object expressionValue = visit(ctx.expression());
	            
	        	//result.append("  return "+visit(ctx.expression())+";\n");
	        	result.append("    <statement name=\"return\" value=\""+visit(ctx.expression())+"\"/>\n");
	            
	           // System.out.println("Returning with expression: " + expressionValue);
	            //return expressionValue;
	        } else {
	            // If there's no expression, just handle it as a simple return
	            System.out.println("Returning without expression");
	            result.append("    <statement name=\"return\" value=\"\"/>\n");
	            
	            //result.append("return;\n"); // or another appropriate return value for your case
	        }//System.out.println(result);
	        return result.toString();
	        
	    }

	    @Override
	    public String visitAssignment(AssignmentContext ctx) {
	    	
	    	//assignment: indexedID ((EQUAL expression) | PLUSPLUS | MINUSMINUS) ;
	    	StringBuilder result = new StringBuilder();
	    	
	    	//int SignIndex;
    	    String leftAttribute = "";
    	    String operator = "";
    	    String AssignedSide = "";
    	    
    		//if (part.contains("="))
    		//{
        	    //SignIndex = ctx.indexedID().getText();//.indexOf("=");
    	    leftAttribute = ctx.indexedID().getText();
    	    if(ctx.EQUAL()!=null)
    	    {
    	    	operator = ctx.EQUAL().getText();
    	    	AssignedSide = ctx.expression().getText();
    	    }
    	    else
            {
    	    	operator = ctx.assignmentType().getText();//"++";
            }
    	    /*else if (ctx.PLUSPLUS()!=null)
    	    	operator = ctx.PLUSPLUS().getText();
    	    else if (ctx.MINUSMINUS()!=null)
    	    	operator = ctx.MINUSMINUS().getText();*/
    	    operator=operator.replace("&&", "&amp;&amp;");
    	    if(ctx.ID()!=null)
    	    	AssignedSide = ctx.ID().getText();
            else if(ctx.INT()!=null)
            	AssignedSide = ctx.INT().getText();
    		
    		if(!GuardOn)
    			result.append("    <statement>\n");
    		result.append("      <assignment\n");
    		result.append("          leftAttribute=\""+leftAttribute+"\"\n");
    		result.append("          operator=\""+operator+"\"\n");
    		result.append("          AssignedSide=\""+AssignedSide+"\"/>\n");
    		if(!GuardOn)
    			result.append("    </statement>\n");
    		
	        return result.toString();
	    }
	    


	    @Override
	    public String visitIndexedID(C2TreeParser.IndexedIDContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(ctx.ID().getText());
	        for (C2TreeParser.ExpressionContext expr : ctx.expression()) {
	            sb.append("[").append(visit(expr)).append("]");
	        }
	        return sb.toString();
	    }

	    @Override
	    public String visitFunctionCall(FunctionCallContext ctx) {
	    	
	        StringBuilder result = new StringBuilder();

    	    String functionName = ctx.ID().getText();
    	    String functionParameters = "";
    	    
    	    if (ctx.argumentList() != null) {
    	    	functionParameters = visit(ctx.argumentList());
	        }
    	        	    
    	    if(!GuardOn)
    	       result.append("    <statement>\n");
    	    result.append("      <functioncall\n");
    	    result.append("          functionName=\""+functionName+"\"\n");
    	    result.append("          parameterString=\""+functionParameters+"\"/>\n");
    		if(!GuardOn)
    			result.append("    </statement>\n");

	        return result.toString();
	    }

	    @Override
	    public String visitArgumentList(C2TreeParser.ArgumentListContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        for (C2TreeParser.ArgumentContext arg : ctx.argument()) {
	            sb.append(visit(arg)).append(", ");
	        }
	        if (sb.length() > 0) sb.setLength(sb.length() - 2); // Remove trailing comma and space
	        return sb.toString();
	    }

	    @Override
	    public String visitArgument(C2TreeParser.ArgumentContext ctx) {
	        if (ctx.expression() != null) {
	            return visit(ctx.expression());
	        } else {
	            return visit(ctx.transformedArgument());
	        }
	    }

	   /* @Override
	    public String visitDataCastArgument(C2TreeParser.DataCastArgumentContext ctx) {
	        return "("+ctx.dataType().getText()+")" + ctx.ID().getText();
	    }

	    @Override
	    public String visitBitsArgument(C2TreeParser.BitsArgumentContext ctx) {
	        return "sizeof(" + ctx.ID().getText() + ")";
	    }*/
	    
	    @Override
	    public String visitTransformedArgument(C2TreeParser.TransformedArgumentContext ctx) {
	        if (ctx.dataCastArgument() != null) {
	           return visit(ctx.dataCastArgument());
	        } else if (ctx.functionCallArgument() != null) {
	           return visit(ctx.functionCallArgument());
	        }
	        return null;
	    }

	    @Override
	    public String visitDataCastArgument(C2TreeParser.DataCastArgumentContext ctx) {
	       /* outputBuilder.append(ctx.dataType().getText())
	                     .append(" \"")
	                     .append(ctx.ID().getText())
	                     .append("\"");
	                     */
	        return visitDataType(ctx.dataType())+"' "+ctx.ID().getText();
	        //return null;
	    }

	    @Override
	    public String visitFunctionCallArgument(C2TreeParser.FunctionCallArgumentContext ctx) {
	        return ctx.ID(0).getText()+"("+ctx.ID(1).getText()+")";
	        //return null;
	    }

	    
	    @Override
	    public String visitCastFunctionCall(C2TreeParser.CastFunctionCallContext ctx) {
	        return visitDataType(ctx.dataType())+"' " + ctx.ID().getText()+"()";//+ctx.LPAREN()+ctx.RPAREN();

	    } 
	    
	    @Override
	    public String visitIfStatement(IfStatementContext ctx) 
	    {
	    	StringBuilder output = new StringBuilder();
	    	String expression = ctx.expression().getText();
	    	
	    	//ifStatement: IF LPAREN expression RPAREN ((LBRACE statement+ RBRACE) | statement) comment? (ELSE (ifStatement| (LBRACE statementTwo+ RBRACE) | statementTwo))? ;

	        
	        String leftSide="", rightSide="", operator="";
	    	
	    	if(ctx.expression().primary(0)!=null)
	    	leftSide = ctx.expression().primary(0).getText();
	    	if(ctx.expression().operator(0)!=null)
	    	operator= ctx.expression().operator(0).getText().replace("<", "&lt;").replace("&&", "&amp;&amp;");
	    	if(ctx.expression().primary(1)!=null)
	    	rightSide= ctx.expression().primary(1).getText();
	        
	        output.append("    <statement>\n");
	    	if(IfOrElseIf)
	    	{
		    	output.append("      <if\n");
				output.append("          keyword=\"else if\"\n");
				IfOrElseIf=false;
	    	}
	    	else
	    	{
				output.append("      <if\n");
				output.append("          keyword=\"if\"\n");
	    	}
			
			output.append("          variable=\""+leftSide+"\"\n");
			output.append("          operator=\""+operator.replace("<", "&lt;")+"\"\n");
			output.append("          value=\""+rightSide+"\">\n");

	        //result.append("  if (").append(visit(ctx.expression())).append(") ");
	        //result.append("begin\n");
	        
	        for (var stmt : ctx.statement()) {
	        	output.append(visit(stmt)+"\n");//.append("************ \n"); 
	        	GuardOn=true;
	        }
	        
	        output.append("      </if>\n");
			output.append("    </statement>\n");
			
			if(ctx.comment()!=null) output.append(" "+visitComment(ctx.comment()));
	       
			if (ctx.ELSE() != null) {
	        	
	        	//output.append("    <statement>\n");
    			//output.append("      <if\n");
    			//output.append("          keyword=\"else");//\">\n");
    			
    			if(ctx.ifStatement()!=null )// || ctx.statement().if
            	{
    				//output.append(" if\">\n");
    				IfOrElseIf=true;
            		output.append(" 	"+visitIfStatement(ctx.ifStatement()));
            		//GuardOn=true;
            		
            	}
    			else
    			{
	    				//output.append("\">\n");
    				output.append("    <statement>\n");
    				output.append("      <if\n");
        			output.append("          keyword=\"else\">\n");
	    			//}
	    			//else
	    			//{
			        	//result.append("\n  else begin\n");
			            for (C2TreeParser.StatementTwoContext stmtCtx : ctx.statementTwo()) {
			            	//result.append(ctx.statementTwo().size());
			            	output.append(visitStatementTwo(stmtCtx)+"\n");
			            }
	    			//}
		            
		            output.append("      </if>\n");
		            output.append("    </statement>\n");
    			} 
				//output.append("    </statement>\n");
	         }
	        
	            GuardOn=false;
	        	return output.toString();
	        	
	    }
	  /*  
	    @Override
	    public String visitElseStatement(ElseStatementContext ctx) 
	    {
	        StringBuilder result = new StringBuilder();
	        result.append("  else {\n  ");
	        
	        for (var stmt : ctx.statement()) {
	            result.append(visit(stmt)+"\n");//.append("************ \n");    
	        }
	        
	        result.append("  }\n");

	        return result.toString();
	        	
	    } */

	    @Override
	    public String visitLoopStatement(C2TreeParser.LoopStatementContext ctx) {
	        // Handle different types of loops (for, while, etc.)
	        if (ctx.forLoop() != null) {
	            return visitForLoop(ctx.forLoop());
	        } 
	        else if (ctx.whileLoop() != null) {
	            return visitWhileLoop(ctx.whileLoop());
	        }
	        else
	        	return null;
	    }
	    
	    @Override
	    public String visitForLoop(C2TreeParser.ForLoopContext ctx) {
	    	
	    	StringBuilder result = new StringBuilder();
	    	
	        String init = ctx.assignment(0).getText();  // Initialization part of the loop
	        String condition = ctx.expression().getText();  // Condition part of the loop
	        //String increment = ctx.assignment(1).getText();  // Increment part of the loop
	        String volatileVar="";
	        if(ctx.VOLATILE()!=null) volatileVar=" "+ctx.VOLATILE().getText();
	        
	        String increment="";
            
            if(ctx.assignment(1)!=null)
               increment = ctx.assignment(1).getText();  // Increment part of the loop

	        // Create transition for loop initialization
	        result.append("    <statement>\n      <loop\n          type=\"for"+volatileVar+"\"\n          initial=\"").append(ctx.dataType().getText()+" "+init+"\"\n");
	        //result.delete(result.length() - 1, result.length()); // remove '\n' from the end
	        result.append("          condition=\""+condition.replace("<", " &lt; ")+"\"\n");
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        result.append("          increment=\""+increment+"\">\n");
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        //result.append(") begin\n");
	        //result.append(visit(ctx.statement())).append("\n");
	        
	        
	        // Loop condition and body transitions
	      

	        // Visit the loop body
	        for (C2TreeParser.StatementContext stmtCtx : ctx.statement()) {
	            result.append(" 	"+visitStatement(stmtCtx));
	        }
	        
	        result.append("      </loop>\n    </statement>\n");
	 
	        return result.toString();
	    }

	    @Override
	    public String visitWhileLoop(C2TreeParser.WhileLoopContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	//String condition = ctx.expression().getText();  // Condition part of the while loop

	        // Create transition for the loop condition
	        result.append("while (").append(visit(ctx.expression())).append(") begin\n");
	        //result.append(visit(ctx.statement())).append("\n");
	        
	        // Visit the loop body
	        for (C2TreeParser.StatementContext stmtCtx : ctx.statement()) {
	        	result.append(" 	"+visitStatement(stmtCtx));
	        }
	        result.append("end\n");
	        // Close loop with a back transition to the condition

	        return result.toString();
	    }
	    @Override
	    public String visitExpression(ExpressionContext ctx) {
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < ctx.primary().size(); i++) {
	            result.append(visit(ctx.primary(i)));
	            if (ctx.LPAREN()!=null) {
	                result.append("("); 
	            }
	            if (ctx.argumentList() != null) {
	                result.append(visit(ctx.argumentList()));
	            }
	            
	            if (ctx.RPAREN()!=null) {
	                result.append(")"); 
	            }
	            
	            if (i < ctx.operator().size()) {
	                result.append(" ").append(ctx.operator(i).getText()).append(" ");
	            }
	        }
	        return result.toString();
	    }

	    @Override
	    public String visitPrimary(PrimaryContext ctx) {
	        if (ctx.ID() != null) {
	            return ctx.ID().getText();
	        } else if (ctx.INT() != null) {
	            return ctx.INT().getText();
	        } else if (ctx.STRING() != null) {
	            return ctx.STRING().getText();
	        } else if (ctx.CHAR() != null) {
	            return ctx.CHAR().getText();
	        } else if (ctx.HEX_INT() != null) {
	            return ctx.HEX_INT().getText();
	        } else if (ctx.castFunctionCall() != null) {
	            return visit(ctx.castFunctionCall());
	        } else if (ctx.dataType() != null) {
	            return ("("+ctx.dataType().getText()+")");
	        } else if (ctx.LPAREN() != null) {
	            return "(" + visit(ctx.expression()) + ")";
	        }
	         
	        return "";
	    }
	    
	    @Override
	    public String visitSwitchStatement(C2TreeParser.SwitchStatementContext ctx) {
	    	
	    	StringBuilder output = new StringBuilder();
	    	
	    	output.append(" <statement>\n");
			output.append("  <switch\n");
			output.append("      keyword=\"switch\"\n");
			output.append("      value=\""+ctx.expression().getText()+"\">\n");

	    	
	        //String switchStatement = "case ("+ctx.expression().getText()+")\n";  // Condition for the switch

	        // Handle each case block
	        for (C2TreeParser.CaseBlockContext caseCtx : ctx.caseBlock())
	        	output.append(visitCaseBlock(caseCtx));
	        
	        // Handle default block
	        if(ctx.defaultBlock()!=null)
	        output.append(visitDefaultBlock(ctx.defaultBlock()));
	        
	        output.append("   </switch>\n");
    		output.append("   </statement>\n");
	        GuardOn=false;
	        return output.toString();
	    }

	    @Override
	    public String visitCaseBlock(C2TreeParser.CaseBlockContext ctx) {
	    	
	    	StringBuilder output = new StringBuilder();
	    	
	    	output.append("  <switchcase\n");
			output.append("    keyword=\"case\"\n");
			output.append("    value=\""+ctx.expression().getText()+"\">\n"); 
	    	
	        //String caseValue = "	"+ctx.expression().getText()+": begin \n";  // Value of the case
	        // Visit statements within the case block
	        for (C2TreeParser.StatementContext stmtCtx : ctx.statement()) 
	        	output.append(visitStatement(stmtCtx)+"\n");
	        	
	        //caseValue=caseValue+"\n	end\n";
	        
	       /* output.append("      <assignment\n");
    		output.append("          leftAttribute=\"break\"\n");
    		output.append("          operator=\"\"\n");
    		output.append("          AssignedSide=\"\"/>\n");*/
    		output.append("      </switchcase>\n");
	        
	        return output.toString();
	    }
	    
	    @Override
	    public String visitDefaultBlock(C2TreeParser.DefaultBlockContext ctx) {
	    	
	    	StringBuilder output = new StringBuilder();
	    	
	    	output.append("  <switchcase\n");
			output.append("    keyword=\"default\">\n");
			
    		
    		
	    	//String defaultStatement;
	    	//if(ctx.statement().size()==0)
	    	  //  defaultStatement = "	default: break;";
	    	//else
	    	//	defaultStatement = "	default: ";
	        // Visit statements within the case block
			if (ctx.statement()!=null)
			{
	        for (C2TreeParser.StatementContext stmtCtx : ctx.statement())	
	        	output.append(visitStatement(stmtCtx));
			}

	        /*output.append("      	<assignment\n");
    		output.append("          leftAttribute=\"break\"\n");
    		output.append("          operator=\"\"\n");
    		output.append("          AssignedSide=\"\"/>\n");*/
    		output.append("      </switchcase>\n\n");

	    	return output.toString();
	    }
	    
	    
	    @Override
	    public String visitPrintStatement(C2TreeParser.PrintStatementContext ctx) {
	    	
	    	//printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;
	    	StringBuilder result = new StringBuilder();	
	    	
	    	String printStatement=ctx.PRINTF().getText()+ctx.LPAREN().getText()+ctx.STRING().getText();
	    	
	    	if (ctx.argument()!=null)
	    		printStatement=printStatement+", "+ctx.argument().getText();
	    
	        if (ctx.argumentList() != null)
	        	printStatement=printStatement+", "+visitArgumentList(ctx.argumentList());

	        printStatement=printStatement+ctx.RPAREN().getText();
	        
	        //printStatement=printStatement.trim();
	        printStatement=printStatement.replace("\"", "*");
	        
	        //result.append("    <comment\n");
		    result.append("    <print  printText=\""+printStatement+";\"/>\n");
		    
		    return result.toString();

	    }
	    
	    
	    @Override
	    public String visitComment(C2TreeParser.CommentContext ctx) {
	    	
	    	StringBuilder result = new StringBuilder();	
	    	String Ccomment="";
	    	if(ctx.SINGLE_LINE_COMMENT()!=null)
	    		Ccomment=ctx.SINGLE_LINE_COMMENT().getText();
	    	else if(ctx.MULTI_LINE_COMMENT()!=null)
	    		Ccomment=ctx.MULTI_LINE_COMMENT().getText();

	    	Ccomment=Ccomment.trim();
	    	Ccomment=Ccomment.replace("\"", "").replace("<", "&lt;");
		    //result.append("    <comment\n");
		    result.append("    <comment  commentText=\""+Ccomment+"\"/>\n");
		    
		    return result.toString();
	    }

	}
