package SystemVerilog2TreeTransformation;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import SystemVerilog2CTransformation.SystemVerilog2CParser;
import SystemVerilog2CTransformation.SystemVerilog2CParser.FileContext;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import SystemVerilog2TreeTransformation.SystemVerilog2TreeParser.*;
import java.util.*;


public class SystemVerilogToTreeVisitor extends SystemVerilog2TreeBaseVisitor<String> {
			
			boolean flagToGetOpenBracesOnce=true;
			boolean flagToGetCloseBracesOnce=true;
			boolean flagElseBrace=false;
			
			boolean closeDeclarationTag=true;
			boolean GuardOn=false;
		    
		   @Override
		    public String visitFile(SystemVerilog2TreeParser.FileContext ctx) {
		    	
		    	StringBuilder output = new StringBuilder();
		    	
		    	output.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		    	output.append("<dSML:System\n");
		    	output.append("    xmi:version=\"2.0\"\n");
		    	output.append("    xmlns:xmi=\"http://www.omg.org/XMI\"\n");
		    	output.append("    xmlns:dSML=\"http://www.example.org/dSML\">\n");
		    	
		    	output.append(visitModuleDecl(ctx.moduleDecl()));
		    	
		    	output.append("\n</dSML:System>");
		        return output.toString();
		    }


		    @Override
		    public String visitModuleDecl(SystemVerilog2TreeParser.ModuleDeclContext ctx) {
		        StringBuilder result = new StringBuilder();
		        result.append("");
		        result.append("  <declaration>\n");
		        for (var item : ctx.moduleItem()) {
		        	flagToGetOpenBracesOnce=true;
		        	flagToGetCloseBracesOnce=true;
		        	flagElseBrace=false;

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
			                	
			        	        
			            		String name="", parameterDataType="", qualifier="", pointer="";
			                	
			            		if(item.functionDecl().parameterList()!=null)
			            		{
					            	if(item.functionDecl().parameterList().parameter(0)!=null)	
			            			parameterDataType = item.functionDecl().parameterList().parameter(0).getText()+" ";
					        	        
					        	        if(item.functionDecl().parameterList().qualifier()!=null)
					        	        	qualifier=item.functionDecl().parameterList().qualifier().getText()+" ";
					                	if(item.functionDecl().parameterList().STARR()!=null)
					                		pointer=item.functionDecl().parameterList().STARR().getText()+" ";
					                	if(item.functionDecl().parameterList().ID()!=null)
					                		name=item.functionDecl().parameterList().ID().getText()+" ";
					            		
					                	result.append("    <parameter\n        name=\""+name.trim()+"\"\n");
					            		
					                	result.append("        dataType=\""+parameterDataType.trim()+"\"\n");
					            		
					                	result.append("        qualifier=\""+qualifier.trim()+"\"\n");
					            		
					                	result.append("        pointer=\""+pointer.trim()+"\"/>\n");       	        
					            	result.append(visitParameterList(item.functionDecl().parameterList()));
			            		}
			            		
			        	        for (var stmt : item.functionDecl().statement()) {
			        	        	
			        	            result.append(visit(stmt)); 
			        	        }
			        	        result.append("  </component>\n");
			        	        
		            	}
		            	else //System.out.println("function has NO statements...");
		            		result.append(visit(item.functionDecl())).append("\n");
		            }
		            // Check if the module item is a statement
		            else if (item.statement() != null) {
		            	
		               result.append(visit(item.statement())).append("\n");
		            }
		           else if (item.enumDecl() != null) {
		            	
			               result.append(visit(item.enumDecl())).append("\n");
			            }
		        }
		        return result.toString();
		    }
		    
		 /*   @Override
		    public String visitInitialBlock(InitialBlockContext ctx) {
		    	return "";
		    }*/
		    
		    @Override
		    public String visitEnumDecl(SystemVerilog2TreeParser.EnumDeclContext ctx) {
		        
		    	StringBuilder result = new StringBuilder();
		    	//String typedef = ctx.TYPEDEF().getText();
		        //String enumType = ctx.ENUM().getText();
		        String enumName = ctx.ID().getText();
		        
		        result.append("    <enum enumID=\""+enumName+"\">\n");
		        result.append(visitEnumList(ctx.enumList()));
                result.append("    </enum>\n");
		   
		        return result.toString();

		    }
		    @Override
		    public String visitEnumList(SystemVerilog2TreeParser.EnumListContext ctx) {
		    	    	
		        StringBuilder enums = new StringBuilder();
		        for (TerminalNode id : ctx.ID()) {
		            enums.append("    <enumlist enumItem=\""+id.getText()+"\"/>\n");
		        }
		       
		        return enums.toString();
		    }

		    @Override
		    public String visitFunctionDecl(SystemVerilog2TreeParser.FunctionDeclContext ctx) {
		    	
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
		    public String visitParameterList(SystemVerilog2TreeParser.ParameterListContext ctx) {
		    	
		    	//parameterList: parameter qualifier? STAR? ID? (COMMA? parameter)* ; 
		    	
	        	StringBuilder result = new StringBuilder();
		        String name="", parameterDataType="", qualifier="", pointer="";
		        boolean flag=false;
		        
		        for (int i = 0; i < ctx.parameter().size(); i++)
			    {
		        	if(flag)
		        	{
		        
			        	if(ctx.dataType(i)!=null)
			        		parameterDataType=ctx.dataType(i).getText();
				        
				        if(ctx.parameter(i)!=null)
				        	name=ctx.parameter(i).getText();
			        	
			        	
			        	result.append("    <parameter\n        name=\""+name.trim()+"\"\n");
			        	result.append("        dataType=\""+parameterDataType.trim()+"\"\n");
			        	result.append("        qualifier=\""+qualifier.trim()+"\"\n");
			        	result.append("        pointer=\""+pointer.trim()+"\"/>\n");
		        	}
		        	flag=true;
			    }
		      
	        	
		        return result.toString();
		    }

		    @Override
		    public String visitParameter(SystemVerilog2TreeParser.ParameterContext ctx) {
		        return ctx.getText(); // Translate SystemVerilog parameter to C parameter if needed
		    }

		    @Override
		    public String visitDeclaration(SystemVerilog2TreeParser.DeclarationContext ctx) {//System.out.println("im declaration");

		    	StringBuilder output = new StringBuilder();
		    	
		    	output.append("    <attribute\n");
		    	output.append("        isGlobal=\"extern\"\n");

		        output.append("        dataType=");
		        output.append("\""+ctx.dataType().getText()+"\"\n");
		        
		        output.append("        name=");
		        output.append("\""+ctx.ID().getText()+"\"\n");
		        
		        output.append("        size=\"");
		        
		        if (ctx.LBRACK() != null) 
		            output.append(ctx.LBRACK().getText()+ctx.INT(0).getText()+ctx.COLON().getText()+ctx.INT(1).getText()+ctx.RBRACK().getText());
		        
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
		    public String visitStatement(SystemVerilog2TreeParser.StatementContext ctx) {
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
		        } else if (ctx.displayStatement() != null) {
		            return visit(ctx.displayStatement());
		        } else if (ctx.comment() != null) {
		            return visit(ctx.comment());
		        } else if (ctx.returnStatement() != null) {
		            return visitReturnStatement(ctx.returnStatement());
		        }
		        
		        return "";
		        //return "123";
		    }
		    
		    @Override
		    public String visitStatementTwo(SystemVerilog2TreeParser.StatementTwoContext ctx) {
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
		        } else if (ctx.displayStatement() != null) {
		            return visit(ctx.displayStatement());
		        } else if (ctx.comment() != null) {
		            return visit(ctx.comment());
		        } else if (ctx.returnStatement() != null) {
		            return visitReturnStatement(ctx.returnStatement());
		        }
		        
		        return "";
		        //return "123";
		    }
		    
		    @Override
		    public String visitReturnStatement(SystemVerilog2TreeParser.ReturnStatementContext ctx) {
		    	StringBuilder result = new StringBuilder();
		        if (ctx.expression() != null) 
		            // If there's an expression in the return statement, visit it
		            
		        	result.append("    <statement name=\"return\" value=\""+visit(ctx.expression())+"\" />\n");
		            
		        return result.toString();
		        
		    }

		    @Override
		    public String visitAssignment(AssignmentContext ctx) {
		    	
		    	//assignment: indexedID ((EQUAL expression) | PLUSPLUS | MINUSMINUS) ;
		    	StringBuilder result = new StringBuilder();
		    	
	    	    String leftAttribute = "";
	    	    String operator = "";
	    	    String AssignedSide = "";
	    	    
	    	    leftAttribute = ctx.indexedID().getText();
	    	    if(ctx.EQUAL()!=null)
	    	    {
	    	    	operator = ctx.EQUAL().getText().replace("<", "&lt;").replace("&&", "&amp;&amp;");
	    	    	AssignedSide = ctx.expression().getText().replace("\"", "");
	    	    }
	    	    else
	            {
	    	    	operator = ctx.assignmentType().getText().replace("<", "&lt;").replace("&&", "&amp;&amp;");
	                if(ctx.ID()!=null)
	                	AssignedSide = ctx.ID().getText().replace("\"", "");
	                else if(ctx.INT()!=null)
	                	AssignedSide = ctx.INT().getText().replace("\"", "");
	              }
	    		
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
		    public String visitIndexedID(SystemVerilog2TreeParser.IndexedIDContext ctx) {
		        StringBuilder sb = new StringBuilder();
		        sb.append(ctx.ID().getText());
		        for (SystemVerilog2TreeParser.ExpressionContext expr : ctx.expression()) {
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
		    public String visitArgumentList(SystemVerilog2TreeParser.ArgumentListContext ctx) {
		        StringBuilder sb = new StringBuilder();
		        for (SystemVerilog2TreeParser.ArgumentContext arg : ctx.argument()) {
		            sb.append(visit(arg)).append(", ");
		        }
		        if (sb.length() > 0) sb.setLength(sb.length() - 2); // Remove trailing comma and space
		        return sb.toString();
		    }

		    @Override
		    public String visitArgument(SystemVerilog2TreeParser.ArgumentContext ctx) {
		        if (ctx.expression() != null) {
		            return visit(ctx.expression());
		        } else {
		            return visit(ctx.transformedArgument());
		        }
		    }

		    @Override
		    public String visitDataCastArgument(SystemVerilog2TreeParser.DataCastArgumentContext ctx) {
		        return "("+ctx.dataType().getText()+")" + ctx.ID().getText();
		    }

		    @Override
		    public String visitBitsArgument(SystemVerilog2TreeParser.BitsArgumentContext ctx) {
		        return "sizeof(" + ctx.ID().getText() + ")";
		    }
		    
		    @Override
		    public String visitCastFunctionCall(SystemVerilog2TreeParser.CastFunctionCallContext ctx) {
		        return "("+ctx.dataType().getText()+")" + ctx.ID().getText()+ctx.LPAREN()+ctx.RPAREN();

		    }
		   
		    
		    @Override
		    public String visitIfStatement(IfStatementContext ctx) 
		    {
		    	StringBuilder output = new StringBuilder();
		    	String expression = ctx.expression().getText();
		    	
		    	
		        
		        String leftSide="", rightSide="", operator="";
		    	
		    	if(ctx.expression().primary(0)!=null)
		    	leftSide = ctx.expression().primary(0).getText();
		    	if(ctx.expression().operator(0)!=null)
		    	operator= ctx.expression().operator(0).getText().replace("<", "&lt;").replace("&&", "&amp;&amp;");
		    	if(ctx.expression().primary(1)!=null)
		    	rightSide= ctx.expression().primary(1).getText();
		        
		        output.append("    <statement>\n");
				output.append("      <if\n");
				output.append("          keyword=\"if\"\n");
				output.append("          variable=\""+leftSide+"\"\n");
				output.append("          operator=\""+operator+"\"\n");
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
		        	
		        	output.append("    <statement>\n");
	    			output.append("      <if\n");
	    			output.append("          keyword=\"else\">\n");
	    			
	    			if(ctx.ifStatement()!=null)
	            	{
	            		output.append(visitIfStatement(ctx.ifStatement()));
	            		
	            	}
	            	else
	            	{
			            for (SystemVerilog2TreeParser.StatementTwoContext stmtCtx : ctx.statementTwo()) {
			            	//result.append(ctx.statementTwo().size());
			            	output.append(visitStatementTwo(stmtCtx)+"\n");
			            }
	            	}
		            output.append("      </if>\n");
					output.append("    </statement>\n");
		         }
		        
		            GuardOn=false;
		        	return output.toString();
		        	
		    }
		  
		    @Override
		    public String visitLoopStatement(SystemVerilog2TreeParser.LoopStatementContext ctx) {
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
		    public String visitForLoop(SystemVerilog2TreeParser.ForLoopContext ctx) {
		    	
		    	StringBuilder result = new StringBuilder();
		    	
		        String init = ctx.assignment(0).getText();  // Initialization part of the loop
		        String condition = ctx.expression().getText().replace("<", "&lt;");  // Condition part of the loop
		        String increment="";
	            
	            if(ctx.assignment(1)!=null)
	               increment = ctx.assignment(1).getText();  // Increment part of the loop
	            
		        // Create transition for loop initialization
		        result.append("    <statement>\n      <loop\n          type=\"for\"\n");
		        
		        result.append("          initial=\"").append(ctx.dataType().getText()+" "+init+"\"\n ");
		        result.append("          condition=\""+condition+"\"\n");
		        result.append("          increment=\""+increment+"\">\n");
		        
		        // Loop condition and body transitions
		     
		        // Visit the loop body
		        for (SystemVerilog2TreeParser.StatementContext stmtCtx : ctx.statement()) {
		            result.append(" 	"+visitStatement(stmtCtx)+"\n");
		        }
		        
		        result.append("    </loop>\n    </statement>\n");
		 
		        return result.toString();
		    }

		    @Override
		    public String visitWhileLoop(SystemVerilog2TreeParser.WhileLoopContext ctx) {
		    	StringBuilder result = new StringBuilder();
		    	//String condition = ctx.expression().getText();  // Condition part of the while loop

		        // Create transition for the loop condition
		        //result.append("while (").append(visit(ctx.expression())).append(") {\n");
		        //result.append(visit(ctx.statement())).append("\n");
		        
		        // Visit the loop body
		        //for (SystemVerilog2TreeParser.StatementContext stmtCtx : ctx.statement()) {
		        //	result.append(" 	"+visitStatement(stmtCtx));
		        //}
		        //result.append("}\n");
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
		                result.append(" ").append(ctx.operator(i).getText().replace("<", "&lt;").replace("&&", "&amp;&amp;")).append(" ");
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
		    public String visitSwitchStatement(SystemVerilog2TreeParser.SwitchStatementContext ctx) {
		    	
		    	StringBuilder output = new StringBuilder();
		    	
		    	output.append("  <statement>\n");
				output.append("    <switch\n");
				output.append("      keyword=\"switch\"\n");
				output.append("      value=\""+ctx.expression().getText()+"\">\n");

		        // Handle each case block
		        for (SystemVerilog2TreeParser.CaseBlockContext caseCtx : ctx.caseBlock())
		        	output.append(visitCaseBlock(caseCtx));
		        
		        // Handle each default block
		        if(ctx.defaultBlock()!=null)
		        output.append(visitDefaultBlock(ctx.defaultBlock()));
		        
		        output.append("   </switch>\n");
	    		output.append("   </statement>\n");
		        GuardOn=false;
		        return output.toString();
		    }

		    @Override
		    public String visitCaseBlock(SystemVerilog2TreeParser.CaseBlockContext ctx) {
		    	
		    	StringBuilder output = new StringBuilder();
		    	
		    	output.append("  <switchcase\n");
				output.append("    keyword=\"case\"\n");
				output.append("    value=\""+ctx.expression().getText()+"\">\n"); 
		    	
		        //String caseValue = "	"+ctx.expression().getText()+": begin \n";  // Value of the case
		        // Visit statements within the case block
		        for (SystemVerilog2TreeParser.StatementContext stmtCtx : ctx.statement()) 
		        	output.append(visitStatement(stmtCtx)+"\n");
		        	
		        //caseValue=caseValue+"\n	end\n";
		        
		        output.append("      <assignment\n");
	    		output.append("          leftAttribute=\"break\"\n");
	    		output.append("          operator=\"\"\n");
	    		output.append("          AssignedSide=\"\"/>\n");
	    		output.append("      </switchcase>\n");
		        
		        return output.toString();
		    }
		    
		    @Override
		    public String visitDefaultBlock(SystemVerilog2TreeParser.DefaultBlockContext ctx) {
		    	
		    	StringBuilder output = new StringBuilder();
		    	
		    	output.append("  <switchcase\n");
				output.append("    keyword=\"default\">\n");
				
		        for (SystemVerilog2TreeParser.StatementContext stmtCtx : ctx.statement())	
		        	output.append(visitStatement(stmtCtx));

		        output.append("      	<assignment\n");
	    		output.append("          leftAttribute=\"break\"\n");
	    		output.append("          operator=\"\"\n");
	    		output.append("          AssignedSide=\"\"/>\n");
	    		output.append("      </switchcase>\n\n");

		    	return output.toString();
		    }
		    
		    
		    @Override
		    public String visitDisplayStatement(SystemVerilog2TreeParser.DisplayStatementContext ctx) {
		    	
		    	//printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;
		    	StringBuilder result = new StringBuilder();	
		    	
		    	String printStatement=ctx.DISPLAY().getText()+ctx.LPAREN().getText()+ctx.STRING().getText();
		    	
		    	if (ctx.argument()!=null)
		    		printStatement=printStatement+", "+ctx.argument().getText();
		    
		        if (ctx.argumentList() != null)
		        	printStatement=printStatement+", "+visitArgumentList(ctx.argumentList());

		        printStatement=printStatement+ctx.RPAREN().getText();
		        
		        printStatement=printStatement.trim();
		        printStatement=printStatement.replace("\"", "*");
		        
		        result.append("    <print\n");
			    result.append("        printText=\""+printStatement+";\"/>\n");
			    
			    return result.toString();

		    }
		    
		    
		    @Override
		    public String visitComment(SystemVerilog2TreeParser.CommentContext ctx) {
		    	
		    	StringBuilder result = new StringBuilder();	
		    	String Ccomment="";
		    	if(ctx.SINGLE_LINE_COMMENT()!=null)
		    		Ccomment=ctx.SINGLE_LINE_COMMENT().getText();
		    	else if(ctx.MULTI_LINE_COMMENT()!=null)
		    		Ccomment=ctx.MULTI_LINE_COMMENT().getText();

		    	Ccomment=Ccomment.trim();
		    	Ccomment=Ccomment.replace("\"", "").replace("<", "&lt;");
			    result.append("    <comment");
			    result.append("    commentText=\""+Ccomment+"\"/>\n");
			    
			    return result.toString();
		    }

		}
