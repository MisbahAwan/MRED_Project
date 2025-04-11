package SystemVerilog2CTransformation;

import org.antlr.v4.runtime.tree.TerminalNode;

import C2SystemVerilogTransformations.C2SystemVerilogParser;
import SystemVerilog2CTransformation.SystemVerilog2CBaseVisitor;
import SystemVerilog2CTransformation.SystemVerilog2CParser.*;

public class SystemVerilogToCVisitor extends SystemVerilog2CBaseVisitor<String> {
	
	boolean flagToGetOpenBracesOnce=true;
	boolean flagToGetCloseBracesOnce=true;
	boolean flagElseBrace=false;

    @Override
    public String visitFile(FileContext ctx) {
        StringBuilder result = new StringBuilder();
        for (var item : ctx.moduleDecl()) {
            result.append(visit(item)).append("\n");
        }
        for (var item : ctx.functionDecl()) {
            result.append(visit(item)).append("\n");
        }
        for (var item : ctx.declaration()) {
            result.append(visit(item)).append("\n");
        }
        for (var item : ctx.statement()) {
            result.append(visit(item)).append("\n");
        }
        return result.toString();
    }

    @Override
    public String visitModuleDecl(ModuleDeclContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("");
        //result.append("// Module: ").append(ctx.ID().getText()).append("\n");
        for (var item : ctx.moduleItem()) {
            result.append(visit(item)).append("\n");
            flagToGetOpenBracesOnce=true;
        	flagToGetCloseBracesOnce=true;
        	flagElseBrace=false;
        }
        //result.append("// End of module ").append(ctx.ID().getText()).append("\n");
        return result.toString();
    }
    
    @Override
    public String visitInitialBlock(InitialBlockContext ctx) {
    	return "";
    }
    
    @Override
    public String visitEnumDecl(SystemVerilog2CParser.EnumDeclContext ctx) {
        
    	StringBuilder result = new StringBuilder();
    	String typedef = ctx.TYPEDEF().getText();
        String enumType = ctx.ENUM().getText();
        String enumName = ctx.ID().getText();
        
        result.append(""+typedef + " " + enumType + "{  \n ");// + enumName + " { " + enums + " } " + finalName + ";");

        result.append(visitEnumList(ctx.enumList()));
        
        result.append(" } " + enumName + ";\n");
        return result.toString();

    }
    @Override
    public String visitEnumList(SystemVerilog2CParser.EnumListContext ctx) {
    	    	
        StringBuilder enums = new StringBuilder();
        for (TerminalNode id : ctx.ID()) {
            enums.append("  "+id.getText()).append(",\n ");
        }
        if (enums.length() >= 2) {
        // Remove last comma and \n
        enums.delete(enums.length() - 3, enums.length());
        }
        enums.append("\n");
        return enums.toString();
    }

    @Override
    public String visitFunctionDecl(FunctionDeclContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append(visit(ctx.returnType())).append(" ");
        result.append(ctx.ID().getText()).append("(");
        if (ctx.parameterList() != null) {
            result.append(visit(ctx.parameterList()));
        }
        
        // below if is to not append semicolon ; after function definition and only append when there is function declaration
        if(ctx.statement().size()>0)
        	result.append(")");
        else
        	result.append(");");
        
        
          for (var stmt : ctx.statement()) {
        	//result.deleteCharAt(result.length() - 1);
        	result.append("\n");
        	if (flagToGetOpenBracesOnce)
        	result.append("{\n");
        	flagToGetOpenBracesOnce=false;
            result.append(visit(stmt)); 
        }
        if (flagToGetOpenBracesOnce==false && flagToGetCloseBracesOnce==true)
        {
         result.append("\n}\n");
         flagToGetCloseBracesOnce=false;
        }  
        return result.toString();
    }

    @Override
    public String visitReturnType(ReturnTypeContext ctx) {
        
    	//return ctx.getText(); // Translate SystemVerilog types to C types if needed
        
        switch (ctx.getText()) {
        case "int":
            return "int";
        case "longint":
            return "int";
        case "real":
            return "double";    
        case "logic":
        	return "int";
        case "byte":
        	return "char";
        default:
            return  ctx.getText();//"int"; // Default to int for unsupported types
    }
    }

    @Override
    public String visitParameterList(ParameterListContext ctx) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ctx.parameter().size(); i++) {
            // Visit the parameter and append it to the parameters list
        	//System.out.println(ctx.parameter(i).getText());
        	result.append(ctx.parameter(i).getText()+" ");
        	if (i%2!=0)
        		result.append(", ");
        }   
            
            // If there's a STAR symbol, append it
            if (ctx.STARR() != null) {
            	result.append("void * ");
            	
            	// If there's an ID following the STAR, append it
                if (ctx.ID() != null) {
                	result.append(ctx.ID().getText());
                }
            }
        for (int i = 0; i < ctx.parameter().size(); i++) {
            // Add a comma after each parameter, except the last one
            if (i < ctx.parameter().size() - 1) {
            	result.append(", ");
            }
     // Check if the last character is a comma and remove it
        if (result.charAt(result.length() - 2) == ',') {
        	result.setLength(result.length() - 2); // Remove last ", "
        }
        }
        //return result.toString();
        return result.toString();
    }

    @Override
    public String visitParameter(ParameterContext ctx) {
        return ctx.getText(); // Translate SystemVerilog parameter to C parameter if needed
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        StringBuilder result = new StringBuilder();
        String initialValue = "";
        
        if (ctx.CONST()!=null) result.append(ctx.CONST().getText()+" ");
        
        if(ctx.EQUAL()!=null)
        {
        	initialValue="="+ctx.primary().getText();
        }
        
        result.append(visit(ctx.dataType())).append(" ").append(ctx.ID().getText());
        if (ctx.LBRACK() != null) {
            //result.append("[").append(ctx.INT(0).getText()).append("]");
        	int arraySize = Integer.parseInt(ctx.INT(0).getText()) + 1;
        	result.append("[").append(arraySize).append("]");
        }
        //result.append(";\n");
        result.append(initialValue+";");
        return result.toString();
    }

    @Override
    public String visitDataType(DataTypeContext ctx) {
        switch (ctx.getText()) {
            case "int":
                return " int";
            case "longint":
                return " int";
            case "real":
                return " float";    
            case "logic":
            	return " int";
            case "byte":
            	return " char";
            default:
                return " "+ctx.getText(); // Default to int for unsupported types
        }
    } 

    @Override
    public String visitStatement(StatementContext ctx) {
        if (ctx.assignment() != null) {//System.out.println(ctx.assignment().getText()+"=============");
            return visit(ctx.assignment()) ;
        } else if (ctx.declaration() != null) {
            return visit(ctx.declaration()) ;
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall()) + ";";
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement());
        } else if (ctx.switchStatement() != null) {
            return visitSwitchStatement(ctx.switchStatement());
        } else if (ctx.displayStatement() != null) {
            return visit(ctx.displayStatement());
        } else if (ctx.comment() != null) {
            return visit(ctx.comment())+"\n";
        } else if (ctx.returnStatement() != null) {
            return visitReturnStatement(ctx.returnStatement());
        }
        
        return "";
        //return "123";
    }
    
    @Override
    public String visitStatementTwo(SystemVerilog2CParser.StatementTwoContext ctx) {//System.out.println("====MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM=========");
    	if (ctx.assignment() != null) {//System.out.println(ctx.assignment().getText()+"=============");
            return visit(ctx.assignment());
        } else if (ctx.declaration() != null) {
            return visit(ctx.declaration()) ;
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall()) + ";";
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement());
        } else if (ctx.switchStatement() != null) {
            return visit(ctx.switchStatement());
        } else if (ctx.displayStatement() != null) {
            return visit(ctx.displayStatement());
        } else if (ctx.comment() != null) {
            return visit(ctx.comment());
        } else if (ctx.returnStatement() != null) {
            return visitReturnStatement(ctx.returnStatement());
        }
        
        //return "123\n";
        return "";
    }

    @Override
    public String visitAssignment(AssignmentContext ctx) {
    	StringBuilder result = new StringBuilder();
    	String expression="";
    	String assignment ="  "+ctx.indexedID().getText();
        //result.append("  "+ctx.indexedID().getText()); 
        
       if (ctx.EQUAL() != null) {
    	   //result.append(" = ");
	       expression = ctx.expression().getText().replace("\"", "'"); // this transformation -> txx[0] = 'p';
	       	if (expression.contains("16'h")) 
	       	    {
	       		 expression = expression.replace("16'h", "0x"); // Convert "16'h0001" -> "0x0001"
	       		assignment = expression;
	       		} 
	       	else 
	       		assignment = assignment+" = "+expression;//assignment = assignment+" = "+expression;
            //result.append(expression);
        } else
        {
            assignment = assignment+ctx.assignmentType().getText();//"++";
            if(ctx.ID()!=null)
          	  assignment = assignment+ctx.ID().getText();
            else if(ctx.INT()!=null)
          	  assignment = assignment+ctx.INT().getText();
          }
      
          return assignment+";\n";
    }
    
    @Override
    public String visitIndexedID(SystemVerilog2CParser.IndexedIDContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.ID().getText());
        for (SystemVerilog2CParser.ExpressionContext expr : ctx.expression()) {
            sb.append("[").append(visit(expr)).append("]");
        }
        return sb.toString();
    }

    @Override
    public String visitFunctionCall(FunctionCallContext ctx) {
        StringBuilder result = new StringBuilder();
        
        //if (ctx.ID() != null) 
        result.append("  "+ctx.ID().getText()).append("(");
        
        if (ctx.argumentList() != null) {
            result.append(visit(ctx.argumentList()));
        }
        result.append(")");
        //System.out.println("FunctionCall: "+result.toString());
        return result.toString();
    }

    @Override
    public String visitArgumentList(SystemVerilog2CParser.ArgumentListContext ctx) {
        StringBuilder sb = new StringBuilder();
        String argument="";
        for (SystemVerilog2CParser.ArgumentContext arg : ctx.argument()) 
        {
	        argument=visit(arg); 
	       	if (argument.startsWith("16'h")) {
	   		argument = "0x" + argument.substring(4); // Convert "16'h0001" -> "0x0001" 
	   	    }
	           sb.append(argument).append(", ");
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 2); // Remove trailing comma and space
        return sb.toString();
    }

    @Override
    public String visitArgument(SystemVerilog2CParser.ArgumentContext ctx) {
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else {
            return visit(ctx.transformedArgument());
        }
    }

    @Override
    public String visitDataCastArgument(SystemVerilog2CParser.DataCastArgumentContext ctx) {
        return "("+ctx.dataType().getText()+")" + ctx.ID().getText();
    }

    @Override
    public String visitBitsArgument(SystemVerilog2CParser.BitsArgumentContext ctx) {
        return "sizeof(" + ctx.ID().getText() + ")";
    }
    
    @Override
    public String visitCastFunctionCall(SystemVerilog2CParser.CastFunctionCallContext ctx) {
        return "("+ctx.dataType().getText()+")" + ctx.ID().getText()+ctx.LPAREN()+ctx.RPAREN();

    }
    
    @Override
    public String visitIfStatement(IfStatementContext ctx) 
    {
        StringBuilder result = new StringBuilder();

        result.append("  if (").append(visit(ctx.expression())).append(") ");
        result.append("{\n");
        
        for (var stmt : ctx.statement()) {
            result.append(visit(stmt)+"\n");//.append("************ \n");    
        }
        
        result.append("  }\n");
        
        if(ctx.comment()!=null) result.append(" "+visitComment(ctx.comment()));
        
        if (ctx.ELSE() != null) {
        	result.append("\n  else ");
        	if(ctx.ifStatement()!=null)
        	{
        		result.append(visitIfStatement(ctx.ifStatement()));
        		
        	}
        	else
        	{
        		result.append("  {\n");
        		
	            for (SystemVerilog2CParser.StatementTwoContext stmtCtx : ctx.statementTwo()) {
	            	result.append(" 		"+visitStatementTwo(stmtCtx)+"\n");
	            }
           
            result.append("   }\n");
           }
         }

        	return result.toString();
        	
    }
    
    @Override
    public String visitLoopStatement(SystemVerilog2CParser.LoopStatementContext ctx) {
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
    public String visitForLoop(SystemVerilog2CParser.ForLoopContext ctx) {
    	
    	StringBuilder result = new StringBuilder();
    	
        String init = ctx.assignment(0).getText();  // Initialization part of the loop
        String condition = ctx.expression().getText();  // Condition part of the loop
        String increment="";
        
        if(ctx.assignment(1)!=null)
           increment = ctx.assignment(1).getText();  // Increment part of the loop
        
        // Create transition for loop initialization
        result.append("  for (").append(visitDataType(ctx.dataType())+" "+init+"; ");
        result.append(condition+"; ");
        result.append(increment);
        result.append(") {\n");
      
        
        // Loop condition and body transitions
      

        // Visit the loop body
        for (SystemVerilog2CParser.StatementContext stmtCtx : ctx.statement()) {
            result.append(" 	"+visitStatement(stmtCtx)+"\n");
        }
        
        result.append("  }\n");
 
        return result.toString();
    }

    @Override
    public String visitWhileLoop(SystemVerilog2CParser.WhileLoopContext ctx) {
    	StringBuilder result = new StringBuilder();
    	//String condition = ctx.expression().getText();  // Condition part of the while loop

        // Create transition for the loop condition
        result.append("while (").append(visit(ctx.expression())).append(") {\n");
        //result.append(visit(ctx.statement())).append("\n");
        
        // Visit the loop body
        for (SystemVerilog2CParser.StatementContext stmtCtx : ctx.statement()) {
        	result.append(" 	"+visitStatement(stmtCtx));
        }
        result.append("}\n");
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
        } else if (ctx.dataType() != null) {
            return ("("+ctx.dataType().getText()+")");
        } else if (ctx.LPAREN() != null) {
            return "(" + visit(ctx.expression()) + ")";
        }
        else if (ctx.castFunctionCall() != null) {
            return visit(ctx.castFunctionCall());
        } 
        return "";
        
               
    }
    
    
    @Override
    public String visitSwitchStatement(SystemVerilog2CParser.SwitchStatementContext ctx) {
    	
    	//switchStatement: SWITCH LPAREN expression RPAREN LBRACE caseBlock+ (defaultBlock)? RBRACE;
    	//caseBlock: CASE expression COLON LBRACE statement* BREAK SEMICOLON? RBRACE;
    	//defaultBlock: DEFAULT COLON (statement*)? BREAK SEMICOLON?; 
		  /* 
		   switchStatement: CASE LPAREN expression RPAREN caseBlock+ (defaultBlock)? ENDCASE;
			caseBlock: expression COLON BEGIN? statement* END? SEMICOLON?;
			defaultBlock: DEFAULT COLON (statement*)? SEMICOLON?;
    	 */
    	
        String switchStatement = "switch ("+ctx.expression().getText()+")\n{\n";  // Condition for the switch

        // Handle each case block
        for (SystemVerilog2CParser.CaseBlockContext caseCtx : ctx.caseBlock())
        	switchStatement=switchStatement+visitCaseBlock(caseCtx);
        
        // Handle default block
        if(ctx.defaultBlock()!=null)
        switchStatement=switchStatement+visitDefaultBlock(ctx.defaultBlock())+"\n}\n";
        else
        	switchStatement=switchStatement+"\n }\n";
        
        return switchStatement;
    }

    @Override
    public String visitCaseBlock(SystemVerilog2CParser.CaseBlockContext ctx) {
    	
        String caseValue = "  case "+ctx.expression().getText()+":  \n";  // Value of the case
        // Visit statements within the case block
        for (SystemVerilog2CParser.StatementContext stmtCtx : ctx.statement()) 
        	caseValue=caseValue+""+visitStatement(stmtCtx)+"    ";
        	
        caseValue=caseValue+"  break;\n";
        return caseValue;
    }
    
    @Override
    public String visitDefaultBlock(SystemVerilog2CParser.DefaultBlockContext ctx) {
    	
    	String defaultStatement = "	default: ";
        // Visit statements within the case block
        for (SystemVerilog2CParser.StatementContext stmtCtx : ctx.statement())	
        	defaultStatement=defaultStatement+visitStatement(stmtCtx);

        defaultStatement=defaultStatement+"\n  break;\n";

    	return defaultStatement;
    }
    
    @Override
    public String visitReturnStatement(SystemVerilog2CParser.ReturnStatementContext ctx) {
    	StringBuilder result = new StringBuilder();
        if (ctx.expression() != null) {
            // If there's an expression in the return statement, visit it
            //Object expressionValue = visit(ctx.expression());
            
        	result.append("  return "+visit(ctx.expression())+";");
            
            
           // System.out.println("Returning with expression: " + expressionValue);
            //return expressionValue;
        } else {
            // If there's no expression, just handle it as a simple return
           // System.out.println("Returning without expression");
            result.append("return;"); // or another appropriate return value for your case
        }//System.out.println(result);
        return result.toString();
        
    }
    
    @Override
    public String visitDisplayStatement(SystemVerilog2CParser.DisplayStatementContext ctx) {
    	
    	//printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;

    	String printStatement="  printf"+ctx.LPAREN().getText()+ctx.STRING().getText();
    	
    	if (ctx.argument()!=null)
    		printStatement=printStatement+", "+ctx.argument().getText();
    	
    
        if (ctx.argumentList() != null)
        	printStatement=printStatement+", "+visitArgumentList(ctx.argumentList());

        printStatement=printStatement+ctx.RPAREN().getText()+";\n";
        
        return printStatement; 
    }
    
    @Override
    public String visitComment(SystemVerilog2CParser.CommentContext ctx) {
    	String comment= ctx.getText();
    	
    	if(comment.contains("#include"))
    		comment=comment.replace("//", "").replace("&lt;", "<").replace("&gt;", ">");
    	
        return "  "+comment+ "";
    }
}
