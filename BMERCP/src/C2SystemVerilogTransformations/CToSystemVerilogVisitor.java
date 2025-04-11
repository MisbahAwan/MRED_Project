package C2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import C2SystemVerilogTransformations.C2SystemVerilogBaseVisitor;
import C2SystemVerilogTransformations.C2SystemVerilogParser.*;
import C2TreeTransformations.C2TreeParser;
import C2UppaalTransformations.C2UppaalParser;

public class CToSystemVerilogVisitor extends C2SystemVerilogBaseVisitor<String> {
	
	boolean flagToGetOpenBracesOnce=true;
	boolean flagToGetCloseBracesOnce=true;
	boolean flagElseBrace=false;
    
    @Override
    public String visitFile(C2SystemVerilogParser.FileContext ctx) {
    	StringBuilder module = new StringBuilder();
    	module.append("module VerilogSimulation;\n\n");

    	// Loop through each child node in the file rule
        for (ParseTree child : ctx.children) {
            if (child instanceof C2SystemVerilogParser.PreprocessorDirectiveContext) {
                // Visit preprocessor directive
            	module.append(visitPreprocessorDirective((C2SystemVerilogParser.PreprocessorDirectiveContext) child));
            } else if (child instanceof C2SystemVerilogParser.IncludeDirectiveContext) {
                // Visit include directive
            	module.append(visitIncludeDirective((C2SystemVerilogParser.IncludeDirectiveContext) child));
            } else if (child instanceof C2SystemVerilogParser.ModuleDeclContext) {
                // Visit module declaration
            	module.append(visitModuleDecl((C2SystemVerilogParser.ModuleDeclContext) child));
            }
        }
        module.delete(module.length() - 3, module.length()); // remove '\n' from the end
        module.append("\n\nendmodule");
    	
    	return module.toString();
    	    	

    }

    @Override
    public String visitModuleDecl(ModuleDeclContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("");

        result.append(visitModuleItem(ctx.moduleItem()));
        
        return result.toString();
    }
    
    @Override
    public String visitModuleItem(C2SystemVerilogParser.ModuleItemContext ctx) {
        if (ctx.declaration() != null) {
            return visit(ctx.declaration());
        } else if (ctx.functionDecl() != null) {
            return visit(ctx.functionDecl());
        } else if (ctx.statement() != null) {
            return visit(ctx.statement());
        } else if (ctx.enumDecl() != null) {
            return visit(ctx.enumDecl());
        } else {
            return "Unknown module item!";
        }
    }
    
    @Override
    public String visitPreprocessorDirective(C2SystemVerilogParser.PreprocessorDirectiveContext ctx) {
    	StringBuilder result = new StringBuilder();
        String id = ctx.ID().getText();
        String value = ctx.INT().getText();
        result.append( "const int " + id + " = " + value+";\n");
        return result.toString();
    }

    @Override
    public String visitIncludeDirective(C2SystemVerilogParser.IncludeDirectiveContext ctx) {
    	
    	return  visit(ctx.systemInclude() != null ? ctx.systemInclude() : ctx.localInclude());
    	 
    }

    @Override
    public String visitSystemInclude(C2SystemVerilogParser.SystemIncludeContext ctx) {
    	StringBuilder result = new StringBuilder();
    	String header = ctx.ID().getText();
    	result.append("// ").append( "#include <" + header + ">").append(" \n");
        
        return result.toString();
    }

    @Override
    public String visitLocalInclude(C2SystemVerilogParser.LocalIncludeContext ctx) {
    	StringBuilder result = new StringBuilder();
    	String header = ctx.ID().getText();
    	result.append("// ").append( "#include \"" + header + "\"").append(" \n");
        
        return result.toString();
    }
	
    @Override
    public String visitEnumDecl(C2SystemVerilogParser.EnumDeclContext ctx) {
        
    	StringBuilder result = new StringBuilder();
    	String typedef = ctx.TYPEDEF().getText();
        String enumType = ctx.ENUM().getText();
        String enumName = ctx.ID().getText();
        
        result.append(""+typedef + " " + enumType + " logic[1:0] {  \n ");// + enumName + " { " + enums + " } " + finalName + ";");

        result.append(visitEnumList(ctx.enumList()));
        
        result.append(" } " + enumName + ";\n");
       
        return result.toString();

    }

    @Override
    public String visitEnumList(C2SystemVerilogParser.EnumListContext ctx) {
    	    	
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


    
 /*   @Override
    public String visitInitialBlock(InitialBlockContext ctx) {
    	return "";
    }*/

    @Override
    public String visitFunctionDecl(FunctionDeclContext ctx) {
        StringBuilder result = new StringBuilder();
        result.append("\nfunction ");
        result.append(visit(ctx.returnType())).append(" ");
        result.append(ctx.ID().getText()).append("(");
        
        if (ctx.parameterList() != null) {
            result.append(visit(ctx.parameterList()));
        }
        
        // below if is to not append semicolon ; after function definition and only append when there is function declaration
        result.append(");\n");
        for (var stmt : ctx.statement()) {
            result.append("  "+visit(stmt)); 
        }
        result.append("endfunction \n\n");
        return result.toString();
    }

    @Override
    public String visitReturnType(ReturnTypeContext ctx) {
        
        switch (ctx.getText()) {
        case "int":
            return "int";
        case "uint8_t":
            return "int";
        case "uint32_t":
        	return "int";
        case "TickType_t":
        	return "int";
        case "osThreadId":
        	return "longint";	
        case "float":
            return "real";    
        case "double":
            return "real"; 
        case "char":
        	return "byte";
        case "osEvent":
        	return "logic";
        case "void":
        	return "void";	
        default:
            return ctx.getText();//"int"; // Default to int for unsupported types
    }
    }

    @Override
    public String visitParameterList(ParameterListContext ctx) {
        StringBuilder result = new StringBuilder();
      
     // Visit each parameter in the list
        for (int i = 0; i < ctx.parameter().size(); i++) {
            // Visit the parameter and append it to the parameters list
        	if(!(ctx.parameter(i).getText().contains("void")))
        		if(!(ctx.parameter(i).getText().contains("const")))
        		result.append(ctx.parameter(i).getText()+" ");
        	
        	 if (ctx.parameter(i).ID()!=null)
             	result.append(", ");
        }   
            

            // If there's a STAR symbol, append it
            if (ctx.STAR() != null) {
            	result.append("logic[31:0] ");
            	
            	// If there's an ID following the STAR, append it
                if (ctx.ID() != null) {
                	result.append(ctx.ID().getText());
                }
            } 
        
     // Check if the last character is a comma and remove it
       if (result.length()>0) 
        if (result.charAt(result.length() - 2) == ',') 
        	result.setLength(result.length() - 2); // Remove last ", "
        
        
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
        
        if (ctx.CONST()!=null) 
        	result.append(ctx.CONST().getText()+" ");

        
        if(ctx.EQUAL()!=null)
        {
        	initialValue="="+ctx.primary().getText();
        }
        
        result.append(visit(ctx.dataType())).append(" ").append(ctx.ID().getText());
        if (ctx.LBRACK() != null) {
        	int arraySize = Integer.parseInt(ctx.INT().getText()) - 1;
        	result.append("[").append(arraySize).append(":0]");
        }
        result.append(initialValue+";\n"); 
        return result.toString();
    }

    @Override
    public String visitDataType(DataTypeContext ctx) {
        switch (ctx.getText()) {
            case "int":
                return "int";
            case "uint8_t":
                return "int";
            case "uint32_t":
            	return "int";
            case "TickType_t":
            	return "int";
            case "osThreadId":
            	return "longint";	
            case "float":
                return "real";    
            case "double":
                return "real"; 
            case "char":
            	return "byte";
            case "osEvent":
            	return "logic";	
            case "void":
            	return "void";	
            default:
                return ctx.getText();//"void"; // Default to int for unsupported types
        }
    } 

    @Override
    public String visitStatement(StatementContext ctx) {
        if (ctx.assignment() != null) {//System.out.println(ctx.assignment().getText()+"=============");
            return visit(ctx.assignment()) ;
        } else if (ctx.declaration() != null) {
            return visit(ctx.declaration());
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall()) ;
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement());
        } else if (ctx.switchStatement() != null) {
            return visit(ctx.switchStatement());
        } else if (ctx.printStatement() != null) {
            return visit(ctx.printStatement());
        } else if (ctx.comment() != null) {
            return visit(ctx.comment());
        } else if (ctx.returnStatement() != null) {
            return visit(ctx.returnStatement());
        }
        
        //return "456\n";
        return "\n";
      
    }
    
    @Override
    public String visitStatementTwo(C2SystemVerilogParser.StatementTwoContext ctx) {//System.out.println("====MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM=========");
    	if (ctx.assignment() != null) {//System.out.println(ctx.assignment().getText()+"=============");
            return visit(ctx.assignment());
        } else if (ctx.declaration() != null) {
            return visit(ctx.declaration());
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall()) ;
        } else if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement());
        } else if (ctx.switchStatement() != null) {
            return visit(ctx.switchStatement());
        } else if (ctx.printStatement() != null) {
            return visit(ctx.printStatement());
        } else if (ctx.comment() != null) {
            return visit(ctx.comment());
        } else if (ctx.returnStatement() != null) {
            return visitReturnStatement(ctx.returnStatement());
        }
        
        //return "123\n";
        return "\n";
    }

    @Override
    public String visitAssignment(AssignmentContext ctx) {
        String assignment =ctx.indexedID().getText();
        String expression = "";
        
        if(ctx.expression()!=null)
        {	
            expression = ctx.expression().getText().replace("'", "\""); // this transformation -> txx[0] = "p";
        	if (expression.contains("0x") || expression.contains("0X")) 
        	    {
        		 expression = expression.replace("0x", "16'h"); // Convert "0x0001" → "16'h0001"	
        		 expression = expression.replace("0X", "16'h"); // Convert "0X0001" → "16'h0001"
        		 assignment = expression;
        		} 
        	else 
        		assignment = assignment+" = "+expression;
        }	
        else
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
    public String visitIndexedID(C2SystemVerilogParser.IndexedIDContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.ID().getText());
        for (C2SystemVerilogParser.ExpressionContext expr : ctx.expression()) {
            sb.append("[").append(visit(expr)).append("]");
        }
        return sb.toString();
    }

    @Override
    public String visitFunctionCall(FunctionCallContext ctx) {
        StringBuilder result = new StringBuilder();
        
        result.append("  "+ctx.ID().getText()).append("(");
        
        if (ctx.argumentList() != null) {
            result.append(visit(ctx.argumentList()));
        }
        result.append(");\n");
        return result.toString();
    }

    @Override
    public String visitArgumentList(C2SystemVerilogParser.ArgumentListContext ctx) {
        StringBuilder sb = new StringBuilder();
        String argument="";
        
        for (C2SystemVerilogParser.ArgumentContext arg : ctx.argument()) {
        	argument=visit(arg); 
        	 if (argument.startsWith("0x") || argument.startsWith("0X")) {
    		 argument = "16'h" + argument.substring(2); // Convert "0x0001" → "16'h0001"
    	    }
            sb.append(argument).append(", ");
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 2); // Remove trailing comma and space
        return sb.toString();
    }

    @Override
    public String visitArgument(C2SystemVerilogParser.ArgumentContext ctx) {
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else {
            return visit(ctx.transformedArgument());
        }
    }

   /* @Override
    public String visitDataCastArgument(C2SystemVerilogParser.DataCastArgumentContext ctx) {
        return "("+ctx.dataType().getText()+")" + ctx.ID().getText();
    }

    @Override
    public String visitBitsArgument(C2SystemVerilogParser.BitsArgumentContext ctx) {
        return "sizeof(" + ctx.ID().getText() + ")";
    }*/
    
    @Override
    public String visitTransformedArgument(C2SystemVerilogParser.TransformedArgumentContext ctx) {
        if (ctx.dataCastArgument() != null) {
           return visit(ctx.dataCastArgument());
        } else if (ctx.functionCallArgument() != null) {
           return visit(ctx.functionCallArgument());
        }
        return null;
    }

    @Override
    public String visitDataCastArgument(C2SystemVerilogParser.DataCastArgumentContext ctx) {
       /* outputBuilder.append(ctx.dataType().getText())
                     .append(" \"")
                     .append(ctx.ID().getText())
                     .append("\"");
                     */
        return visitDataType(ctx.dataType())+"' "+ctx.ID().getText();
        //return null;
    }

    @Override
    public String visitFunctionCallArgument(C2SystemVerilogParser.FunctionCallArgumentContext ctx) {
        return ctx.ID(0).getText()+"("+ctx.ID(1).getText()+")";
        //return null;
    }

    
    @Override
    public String visitCastFunctionCall(C2SystemVerilogParser.CastFunctionCallContext ctx) {
        return visitDataType(ctx.dataType())+"' " + ctx.ID().getText()+"()";//+ctx.LPAREN()+ctx.RPAREN();

    } 
    
    @Override
    public String visitIfStatement(IfStatementContext ctx) 
    {
        StringBuilder result = new StringBuilder();

        result.append("if (").append(visit(ctx.expression())).append(") ");
        result.append("begin\n");

	        for (var stmt : ctx.statement()) {
	            result.append(" 		"+visit(stmt));//.append("************ \n");    
	        }

        result.append("   end\n");
        
        if(ctx.comment()!=null) result.append(" "+visitComment(ctx.comment()));
        
        if (ctx.ELSE() != null) {
        	result.append("\n  else ");
        	if(ctx.ifStatement()!=null)
        	{
        		result.append(visitIfStatement(ctx.ifStatement()));
        		
        	}
        	else
        	{
        		result.append("  begin\n");
        		
	            for (C2SystemVerilogParser.StatementTwoContext stmtCtx : ctx.statementTwo()) {
	            	result.append(" 		"+visitStatementTwo(stmtCtx));
	            }
           
            result.append("   end\n");
           }
         }

        	return result.toString();
        	
    }
 
    @Override
    public String visitReturnStatement(C2SystemVerilogParser.ReturnStatementContext ctx) {
    	StringBuilder result = new StringBuilder();
        if (ctx.expression() != null) {
            // If there's an expression in the return statement, visit it
            //Object expressionValue = visit(ctx.expression());
            
        	result.append("  return "+visit(ctx.expression())+";\n");
            
            
           // System.out.println("Returning with expression: " + expressionValue);
            //return expressionValue;
        } else {
            // If there's no expression, just handle it as a simple return
            System.out.println("Returning without expression");
            result.append("return;\n"); // or another appropriate return value for your case
        }//System.out.println(result);
        return result.toString();
        
    }
    
    @Override
    public String visitLoopStatement(C2SystemVerilogParser.LoopStatementContext ctx) {
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
    public String visitForLoop(C2SystemVerilogParser.ForLoopContext ctx) {
    	
    	StringBuilder result = new StringBuilder();
    	
        String init = ctx.assignment(0).getText();  // Initialization part of the loop
        String condition = ctx.expression().getText();  // Condition part of the loop
        String increment="";
        
        if(ctx.assignment(1)!=null)
           increment = ctx.assignment(1).getText();  // Increment part of the loop
        
        // Create transition for loop initialization
        result.append("for (").append(visitDataType(ctx.dataType())+" "+visit(ctx.assignment(0)));
        result.delete(result.length() - 1, result.length()); // remove '\n' from the end
        result.append(visit(ctx.expression())+";");
        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
        result.append(visit(ctx.assignment(1)));
        result.delete(result.length() - 2, result.length()); // remove '\n' from the end
        result.append(") begin\n");
        //result.append(visit(ctx.statement())).append("\n");
        
        
        // Loop condition and body transitions
      

        // Visit the loop body
        for (C2SystemVerilogParser.StatementContext stmtCtx : ctx.statement()) {
            result.append(" 	"+visitStatement(stmtCtx));
        }
        
        result.append("  end\n");
 
        return result.toString();
    }

    @Override
    public String visitWhileLoop(C2SystemVerilogParser.WhileLoopContext ctx) {
    	StringBuilder result = new StringBuilder();
    	//String condition = ctx.expression().getText();  // Condition part of the while loop

        // Create transition for the loop condition
        result.append("while (").append(visit(ctx.expression())).append(") begin\n");
        //result.append(visit(ctx.statement())).append("\n");
        
        // Visit the loop body
        for (C2SystemVerilogParser.StatementContext stmtCtx : ctx.statement()) {
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
    public String visitSwitchStatement(C2SystemVerilogParser.SwitchStatementContext ctx) {
    	
    	//switchStatement: SWITCH LPAREN expression RPAREN LBRACE caseBlock+ (defaultBlock)? RBRACE;
    	//caseBlock: CASE expression COLON LBRACE statement* BREAK SEMICOLON? RBRACE;
    	//defaultBlock: DEFAULT COLON (statement*)? BREAK SEMICOLON?; 
    	
    	/*
    	 * case (<expression>)
			 case_item1: begin statements* end
			 case_item2: begin statements* end
			 default: statements*
		   endcase
    	 */
    	
        String switchStatement = "case ("+ctx.expression().getText()+")\n";  // Condition for the switch

        // Handle each case block
        for (C2SystemVerilogParser.CaseBlockContext caseCtx : ctx.caseBlock())
        	switchStatement=switchStatement+visitCaseBlock(caseCtx);
        
        // Handle each case block
        if(ctx.defaultBlock()!=null)
        	switchStatement=switchStatement+visitDefaultBlock(ctx.defaultBlock());
        else
        	switchStatement=switchStatement+"\n endcase\n";

        return switchStatement;
    }

    @Override
    public String visitCaseBlock(C2SystemVerilogParser.CaseBlockContext ctx) {
    	
        String caseValue = "	"+ctx.expression().getText()+": begin \n";  // Value of the case
        // Visit statements within the case block
        for (C2SystemVerilogParser.StatementContext stmtCtx : ctx.statement()) 
        	caseValue=caseValue+" 	"+visitStatement(stmtCtx);
        	
        caseValue=caseValue+"	end\n";
        return caseValue;
    }
    
    @Override
    public String visitDefaultBlock(C2SystemVerilogParser.DefaultBlockContext ctx) {
    	String defaultStatement;
    	if(ctx.statement().size()==0)
    	    defaultStatement = "	default: begin";
    	else
    		defaultStatement = "	default: begin";
        // Visit statements within the case block
        for (C2SystemVerilogParser.StatementContext stmtCtx : ctx.statement())	
        	defaultStatement=defaultStatement+" 	"+visitStatement(stmtCtx);

        defaultStatement=defaultStatement+"\n	   end\n endcase\n";

    	return defaultStatement;
    }
    
    
    @Override
    public String visitPrintStatement(C2SystemVerilogParser.PrintStatementContext ctx) {
    	
    	//printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;

    	String printStatement="$display"+ctx.LPAREN().getText()+ctx.STRING().getText();
    	
    	if (ctx.argument()!=null)
    		printStatement=printStatement+", "+ctx.argument().getText();
    
        if (ctx.argumentList() != null)
        	printStatement=printStatement+", "+visitArgumentList(ctx.argumentList());

        printStatement=printStatement+ctx.RPAREN().getText()+";\n";

        return printStatement; 
    }
    
    
    @Override
    public String visitComment(C2SystemVerilogParser.CommentContext ctx) {
        return ctx.getText()+"\n";
    }
}
