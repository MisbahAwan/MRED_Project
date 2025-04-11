package Tree2SystemVerilogTransformation;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import C2SystemVerilogTransformations.C2SystemVerilogParser;
import C2SystemVerilogTransformations.C2SystemVerilogParser.ExpressionContext;
import C2TreeTransformations.C2TreeParser;

public class TreeToSystemVerilogVisitor extends Tree2SystemVerilogBaseVisitor<String> {

	//StringBuilder sb;
	
	    @Override
	    public String visitSystem(Tree2SystemVerilogParser.SystemContext ctx) {
	    	StringBuilder sb = new StringBuilder();
	    	
	    	sb.append("module VerilogSimulation;\n\n");
	        // Visit declarations and components
	    	// Loop through each child node in the file rule
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.PreprocessorDirectiveContext) {
	            	// Visit preprocessor directive
	            	sb.append(visitPreprocessorDirective((Tree2SystemVerilogParser.PreprocessorDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.IncludeDirectiveContext) {
	            	// Visit include directive
	            	sb.append(visitIncludeDirective((Tree2SystemVerilogParser.IncludeDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	            	// Visit module declaration
	            	sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.DeclarationContext) {
	            	// Visit module declaration
	            	sb.append(visitDeclaration((Tree2SystemVerilogParser.DeclarationContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.ComponentContext) {
	            	// Visit module declaration
	            	sb.append(visitComponent((Tree2SystemVerilogParser.ComponentContext) child));
	            }
	            else if (child instanceof Tree2SystemVerilogParser.PrintContext) {
	            	// Visit module declaration
	            	sb.append(visitPrint((Tree2SystemVerilogParser.PrintContext) child));
	            }
	            
	        }

	       /* for (Tree2SystemVerilogParser.ComponentContext component : ctx.component()) {
	           sb.append(visit(component));
	        }*/
	        sb.append("endmodule");
	        return sb.toString();
	    }
	    
	    @Override
	    public String visitPreprocessorDirective(Tree2SystemVerilogParser.PreprocessorDirectiveContext ctx) {
	    	StringBuilder result = new StringBuilder();
	        String id = ctx.ID().getText();
	        String value = ctx.NUMBER().getText();
	        result.append( "const int " + id + " = " + value+";\n");
	        return result.toString();
	    }

	    @Override
	    public String visitIncludeDirective(Tree2SystemVerilogParser.IncludeDirectiveContext ctx) {
	    	
	    	return  visit(ctx.systemInclude() != null ? ctx.systemInclude() : ctx.localInclude());
	    	 
	    }

	    @Override
	    public String visitSystemInclude(Tree2SystemVerilogParser.SystemIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	result.append("// ").append( "#include <" + header + ">").append(" \n");
	        
	        return result.toString();
	    }

	    @Override
	    public String visitLocalInclude(Tree2SystemVerilogParser.LocalIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	result.append("// ").append( "#include \"" + header + "\"").append(" \n");
	        
	        return result.toString();
	    }
		
	    @Override
	    public String visitEnumDecl(Tree2SystemVerilogParser.EnumDeclContext ctx) {
	        
	    	StringBuilder result = new StringBuilder();
	    	String typedef = "typedef";
	        String enumType = "enum";
	        String enumName = ctx.ID().getText();
	        
	        result.append(""+typedef + " " + enumType + " logic[1:0] {  \n ");

	        result.append(visitEnumList(ctx.enumList()));
	        
	        result.append(" } " + enumName + ";\n");
	       
	        return result.toString();

	    }

	    @Override
	    public String visitEnumList(Tree2SystemVerilogParser.EnumListContext ctx) {
	    	    	
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
	    public String visitDeclaration(Tree2SystemVerilogParser.DeclarationContext ctx) {
	        StringBuilder sb = new StringBuilder();

	     // Loop through each child node in the file rule
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.AttributeContext) {
	            	sb.append(visitAttribute((Tree2SystemVerilogParser.AttributeContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.FunctionprototypeContext) {
	            	sb.append(visitFunctionprototype((Tree2SystemVerilogParser.FunctionprototypeContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	            	sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.EnumDeclContext) {
	            	sb.append(visitEnumDecl((Tree2SystemVerilogParser.EnumDeclContext) child));
	            }         
	        }
	        return sb.toString();
	    }

	    @Override
	    public String visitAttribute(Tree2SystemVerilogParser.AttributeContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String extern="", size="", initialValue="", datatype="", attribute="";

	        //if(ctx.EXTERN()!=null) 
	        	//extern=ctx.EXTERN().getText();
	      
	     // Check all tokens ANTLR has for this node
	      //  for (int i = 0; i < ctx.getChildCount(); i++) {
	        //    System.out.println("Token " + i + ": " + ctx.getChild(i).getText());
	        //}
	        
	        // ** Extract values manually to avoid shifting issues **
	        boolean sizeFound = false;
	        boolean initialValueFound = false;

	        for (int i = 0; i < ctx.getChildCount(); i++) {
	            String token = ctx.getChild(i).getText();

	            if (token.equals("size")) {
	                sizeFound = true;
	                continue;
	            } else if (token.equals("initialValue")) {
	                initialValueFound = true;
	                continue;
	            }

	            if (sizeFound && token.equals("=")) continue;  // Skip the '='
	            if (initialValueFound && token.equals("=")) continue;  // Skip the '='

	            if (sizeFound && !initialValueFound) {
	                size = token;
	                sizeFound = false;  // Reset flag after assignment
	            } else if (initialValueFound) {
	                initialValue = " = "+token;
	                initialValueFound = false;  // Reset flag after assignment
	            }
	        }

	        // ** Fix incorrectly extracted size **
	        if (size.equals("\"\"")) 
	            size = "";  // Ensure empty size is assigned correctly
	        
	        //extern=extern.replace("\"", "");
	        size=size.replace("\"", "");
	        initialValue=initialValue.replace("\"", "");
	        datatype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        attribute=ctx.ID(0).getText().replace("\"", "");
	        
	        //System.out.println(initialValue);
	     // Step 1: Trim spaces from the end
	        initialValue = initialValue.replaceAll("\\s+$", "");
	        if (initialValue.endsWith("=")) {
	            // Trim the last character
	        	initialValue = initialValue.substring(0, initialValue.length() - 1);
	        }
	        //System.out.println(attribute+"..."+size+"..."+initialValue);
	        if (!size.isEmpty()) {
	        	if (size.contains("[") && size.contains(":")) 
	        		size=size;
	        	else
	        	{
		            //result.append("[").append(ctx.INT(0).getText()).append("]");
		        	size=size.substring(1); // Trim first character
		        	size=size.substring(0, size.length() - 1); // Return the string excluding the last character
		        	int arraySize = Integer.parseInt(size) - 1;
		        	size="["+arraySize+":0]";
	        	}
	        }
	        
	        sb.append(extern+" "+datatype+" "+attribute+size+initialValue+";\n");

	        return sb.toString();
	    }

	    @Override
	    public String visitFunctionprototype(Tree2SystemVerilogParser.FunctionprototypeContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        //System.out.println("i am here");
	        String returntype="", functionname="";
	        StringBuilder parameters= new StringBuilder();
	        
	        returntype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        functionname=ctx.ID().getText().replace("\"", "");
	        sb.append("function "+returntype+" "+functionname+"( ");
	        
	        
	        for (Tree2SystemVerilogParser.ParameterContext parameter : ctx.parameter()) {
	        	parameters.append(visit(parameter)).append(", ");
	            //sb.append(visit(parameter)).append(", ");
	        }
	        if (ctx.parameter().size() > 0) {
	        	parameters.setLength(parameters.length() - 2); // Remove last comma and space
	            //sb.setLength(sb.length() - 2); // Remove last comma and space
	        }
	        String trimmed = parameters.toString().trim();
	        //sb.setLength(0);  // Clear the StringBuilder
	        sb.append(trimmed);  // Append the trimmed string
	        
	        sb.append("); endfunction\n");
	        	// Additional function logic can be added here
	        //sb.append("}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitComponent(Tree2SystemVerilogParser.ComponentContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
            String componentName="", returnType="";
	        
            returnType=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        componentName=ctx.ID().getText().replace("\"", "");
	        sb.append("function "+returnType+" "+componentName+"( ");
	        
	        for (Tree2SystemVerilogParser.ParameterContext parameter : ctx.parameter()) {
	            sb.append(visit(parameter)).append(", ");
	        }
	        if (ctx.parameter().size() > 0) {
	            sb.setLength(sb.length() - 2); // Remove last comma and space
	        }
	        sb.append("); \n");
	        
	        // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	                // Process the comment
	                sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child)).append("\n");
	            } else if (child instanceof Tree2SystemVerilogParser.StatementContext) {
	                // Process the statement
	                sb.append(visitStatement((Tree2SystemVerilogParser.StatementContext) child)).append("\n");
	            } else if (child instanceof Tree2SystemVerilogParser.DeclarationContext) {
	                // Process declarations, if any (optional)
	                sb.append(visitDeclaration((Tree2SystemVerilogParser.DeclarationContext) child)).append("\n");
	            } else if (child instanceof Tree2SystemVerilogParser.ReturnContext) {
	                // Process declarations, if any (optional)
	                sb.append(visitReturn((Tree2SystemVerilogParser.ReturnContext) child)).append("\n");
	            } else if (child instanceof Tree2SystemVerilogParser.PrintContext) {
	            	// Visit module declaration
	            	sb.append(visitPrint((Tree2SystemVerilogParser.PrintContext) child));
	            } else if (child instanceof Tree2SystemVerilogParser.LoopContext) {
	            	// Visit module declaration
	            	sb.append(visitLoop((Tree2SystemVerilogParser.LoopContext) child));
	            }
	        }
	        sb.append("\nendfunction\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitParameter(Tree2SystemVerilogParser.ParameterContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	        String pointer="", qualifier="", datatype="", attribute="";
	        
	        if(ctx.ID(0)!=null) 
	        	attribute=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.dataTypes()!=null) 
	        	datatype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        //if(ctx.ID(1)!=null) 
	        //	qualifier= ctx.ID(1).getText().replace("\"", "");
	        if(ctx.STAR()!=null | ctx.STARR()!=null) 
	        	pointer= "logic[31:0]";//ctx.STAR().getText().replace("\"", "");
	        
	        if (datatype.equals("void")) datatype=""; // do not add void as a parameter
	        
	        datatype=datatype+" ";
	        qualifier=qualifier+" ";
	        pointer=pointer+" ";
	        
	        sb.append(datatype+qualifier+pointer+attribute);
	        	        
	        return sb.toString();
	    }

	    @Override
	    public String visitStatement(Tree2SystemVerilogParser.StatementContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	                // Process the comment
	                sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.AssignmentContext) {
	                // Process the assignment
	                sb.append(visitAssignment((Tree2SystemVerilogParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	                sb.append(visitFunctioncall((Tree2SystemVerilogParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitIfstatement((Tree2SystemVerilogParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.SwitchContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitSwitch((Tree2SystemVerilogParser.SwitchContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.ReturnContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitReturn((Tree2SystemVerilogParser.ReturnContext) child)).append("\n");
	            } else if (child instanceof Tree2SystemVerilogParser.LoopContext) {
	            	// Visit module declaration
	            	sb.append(visitLoop((Tree2SystemVerilogParser.LoopContext) child));
	            }
	            
	        }
	    	
	    	return sb.toString();//visitChildren(ctx); // Let children handle their own visits
	    }

	    @Override
	    public String visitIfstatement(Tree2SystemVerilogParser.IfstatementContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String keyword = ctx.getChild(0).getText();
	        
	        String ifVar="";
	        //String elseVar="";
	        String operator="", value="", variable="";
	        
	        if(ctx.IF()!=null) 
	        	ifVar=ctx.IF().getText().replace("\"", "");
	        else if(ctx.ELSE()!=null) 
	        	ifVar=ctx.ELSE().getText().replace("\"", "");
	        else if(ctx.ELSEIF()!=null) 
	        	ifVar=ctx.ELSEIF().getText().replace("\"", "");
	        
	        if(ctx.ID(0)!=null) 
	        	variable=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.operator()!=null) 
	        	operator= " "+ctx.operator().getText().replace("\"", "").replace("&lt;", "<").replace("&amp;", "&")+" ";
	        
	        if(ctx.STRING()!=null) 
	        	value=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID(1)!=null) 
	        	value=ctx.ID(1).getText().replace("\"", "");
	        else if(ctx.NUMBER()!=null) 
	        	value=ctx.NUMBER().getText().replace("\"", "");

	        if(ifVar.equals("keyword=if"))
	        {
	        	sb.append("	if ("+variable+operator+value+")	begin\n");
	        }
	        else if(ifVar.equals("keyword=else"))
	        {
	        	sb.append("	else  begin\n");
	        }
	        else if(ifVar.equals("keyword=else if"))
	        {
	        	sb.append("	else if ("+variable+operator+value+")	begin\n");
	        }
	       
	     // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	                // Process the comment
	                sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.AssignmentContext) {
	                // Process the assignment
	            	
	            	sb.append(visitAssignment((Tree2SystemVerilogParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	                sb.append(visitFunctioncall((Tree2SystemVerilogParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitIfstatement((Tree2SystemVerilogParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.ReturnContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitReturn((Tree2SystemVerilogParser.ReturnContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.StatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitStatement((Tree2SystemVerilogParser.StatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitDeclaration((Tree2SystemVerilogParser.DeclarationContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.PrintContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitPrint((Tree2SystemVerilogParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.SwitchContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitSwitch((Tree2SystemVerilogParser.SwitchContext) child)).append("\n");
	            }
	        }
	        
	        sb.append("	end\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch(Tree2SystemVerilogParser.SwitchContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        
	        
	        sb.append("case (").append(ctx.ID().getText().replace("\"", "")).append(")\n");
	        
	        for (Tree2SystemVerilogParser.Switch_caseContext switchCase : ctx.switch_case()) {
	        	sb.append(visit(switchCase));
	        }
	        sb.append("endcase\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch_case(Tree2SystemVerilogParser.Switch_caseContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String switchcase="", switchdefault="", value="";
	        
	        if(ctx.SWITCH_CASE()!=null) 
	        	switchcase=ctx.SWITCH_CASE().getText().replace("\"", "");
	        if(ctx.SWITCH_DEFAULT()!=null) 
	        	switchdefault=ctx.SWITCH_DEFAULT().getText().replace("\"", "");
	        
	        if(ctx.STRING()!=null) 
	        	value=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID()!=null) 
	        	value=ctx.ID().getText().replace("\"", "");
	        else if(ctx.NUMBER()!=null) 
	        	value=ctx.NUMBER().getText().replace("\"", "");

	        
	        if(switchcase.contains("case"))
	        {
	        	sb.append("  "+value+": begin\n");
	        	
	        	// Iterate over all children (which can be comments, statements, or declarations)
		        for (ParseTree child : ctx.children) {
		            if (child instanceof Tree2SystemVerilogParser.CommentContext) {
		                // Process the comment
		                sb.append(visitComment((Tree2SystemVerilogParser.CommentContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2SystemVerilogParser.AssignmentContext) {
		                // Process the assignment
		            	
		            	sb.append(visitAssignment((Tree2SystemVerilogParser.AssignmentContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2SystemVerilogParser.FunctioncallContext) {
		                // Process function call, if any (optional)
		                sb.append(visitFunctioncall((Tree2SystemVerilogParser.FunctioncallContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2SystemVerilogParser.IfstatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitIfstatement((Tree2SystemVerilogParser.IfstatementContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2SystemVerilogParser.ReturnContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitReturn((Tree2SystemVerilogParser.ReturnContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2SystemVerilogParser.StatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitStatement((Tree2SystemVerilogParser.StatementContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2SystemVerilogParser.DeclarationContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitDeclaration((Tree2SystemVerilogParser.DeclarationContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2SystemVerilogParser.PrintContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitPrint((Tree2SystemVerilogParser.PrintContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2SystemVerilogParser.SwitchContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitSwitch((Tree2SystemVerilogParser.SwitchContext) child)).append("\n");
		            }
		        }
		        sb.append("	end\n");  
	        }
	        else if(switchdefault.contains("default"))
	        {
	        	sb.append("default "+value+": begin\n	");
	        	sb.append("	end \n");
	        }
	      
	        return sb.toString();
	    }

	    @Override
	    public String visitAssignment(Tree2SystemVerilogParser.AssignmentContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	        //String leftAttribute="", operator="", AssignedSide="";

	    	// Handle left-hand side
	        if (ctx.leftAttribute().ID() != null) {
	            sb.append("	"+ctx.leftAttribute().ID().getText().replace("\"", ""));
	        } else if (ctx.leftAttribute().STRING() != null) {
	            sb.append("	"+ctx.leftAttribute().STRING().getText().replace("\"", ""));
	        }

	        // Handle operator (or empty string)
	        if (ctx.operatorOrEmpty().operator() != null) {
	            sb.append("	"+ctx.operatorOrEmpty().operator().getText().replace("\"", "").replace("&lt;", "<").replace("&amp;", "&")+" ");
	        } 

	        // Handle right-hand side
	        if (ctx.assignedSide().ID() != null) {
	            sb.append("	"+ctx.assignedSide().ID().getText().replace("\"", ""));
	        } else if (ctx.assignedSide().STRING() != null) {
	        	String stringText=ctx.assignedSide().STRING().getText().replace("\"", "");
	        	if(stringText.contains("0x") | stringText.contains("0X")) stringText=stringText.replace("0x", "16'h").replace("0X", "16'h");
	        	//else if(stringText.contains("16'h")) stringText=stringText.replace("16'h", "0x");
	        	
	            sb.append("	"+stringText);
	        } else if (ctx.assignedSide().operator() != null) {
	            sb.append("	"+ctx.assignedSide().operator().getText().replace("\"", "").replace("&lt;", "<").replace("&amp;", "&")+" ");
	        } else {
	            sb.append(""); // Default empty assignment
	        }
	        
	        sb.append(";");
	        
	        String st=sb.toString();

	        if(st.contains("break")) // just a workaround to remove break when call "assignment" came from switch case statement
	        	return "";
	        else
	        return sb.toString().replace("'", "\"").replace("16\"h", "16'h");
	    }

	    @Override
	    public String visitFunctioncall(Tree2SystemVerilogParser.FunctioncallContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	    	String functionName="", parameterString="";

	        if(ctx.ID(0)!=null) 
	        	functionName=ctx.ID(0).getText().replace("\"", "");
	        
	        if(ctx.STRING()!=null) 
	        	parameterString=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID(1)!=null) 
	        	parameterString=ctx.ID(1).getText().replace("\"", "");
	        
	        sb.append("	"+functionName+" ("+parameterString+" );");

	        return sb.toString();
	    }
	    
	    @Override
	    public String visitReturn(Tree2SystemVerilogParser.ReturnContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String expression="";
	    	if (ctx.ID() != null) expression=ctx.ID().getText();
	    	else if (ctx.NUMBER() != null) expression=ctx.NUMBER().getText();
	       
	        result.append("  return "+expression+";");
	           
	        return result.toString();
	    }
	    
	    @Override
	    public String visitLoop(Tree2SystemVerilogParser.LoopContext ctx) {
	    	
	    	StringBuilder result = new StringBuilder();
	    	
	    	String loopType="";//ctx.FOR().getText();
	    	if (ctx.FOR() != null) 
	    		loopType=ctx.FOR().getText();
	    	else if (ctx.FOR_VOLATILE() != null) 
	    		loopType="for";
	    	else if (ctx.WHILE() != null) 
	    		loopType=ctx.WHILE().getText();
	    	
	    	loopType=loopType.replace("\"", "");
	    	
	    	
	        String init = ctx.expression(0).getText();  // Initialization part of the loop
	        String condition = ctx.expression(1).getText();  // Condition part of the loop
            String increment = "";
	        
	        if(ctx.expression(2)!=null)
	        ctx.expression(2).getText();  // Increment part of the loop
	        
	        condition=condition.replace("&lt;", "<");

	        // Create transition for loop initialization
	        result.append("  "+loopType+" (").append(visitDataTypes(ctx.dataTypes())+" "+init+"; ");
	        //result.delete(result.length() - 1, result.length()); // remove '\n' from the end
	        result.append(condition+"; ");
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        result.append(increment);
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        result.append(") begin\n");
	        //result.append(visit(ctx.statement())).append("\n");
	        
	        
	        // Loop condition and body transitions
	      

	        // Visit the loop body
	     // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2SystemVerilogParser.CommentContext) {
	                // Process the comment
	            	result.append(visitComment((Tree2SystemVerilogParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.AssignmentContext) {
	                // Process the assignment
	            	
	            	result.append(visitAssignment((Tree2SystemVerilogParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	            	result.append(visitFunctioncall((Tree2SystemVerilogParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2SystemVerilogParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitIfstatement((Tree2SystemVerilogParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.ReturnContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitReturn((Tree2SystemVerilogParser.ReturnContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.StatementContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitStatement((Tree2SystemVerilogParser.StatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitDeclaration((Tree2SystemVerilogParser.DeclarationContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.PrintContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitPrint((Tree2SystemVerilogParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2SystemVerilogParser.SwitchContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitSwitch((Tree2SystemVerilogParser.SwitchContext) child)).append("\n");
	            }
	        }
	        
	        result.append("  end\n");
	 
	        return result.toString();
	    }



	    @Override
	    public String visitExpression(Tree2SystemVerilogParser.ExpressionContext ctx) {
	        StringBuilder result = new StringBuilder();
	       // for (int i = 0; i < ctx.primary().size(); i++) {
	         //   result.append(visit(ctx.primary(i)));
	            if (ctx.ID(0)!=null) {
	                result.append(ctx.ID(0).getText()); 
	            }
	            if (ctx.ID(1)!=null) {
	                result.append(ctx.ID(1).getText()); 
	            }
	            if (ctx.NUMBER()!=null) {
	                result.append(ctx.NUMBER().getText()); 
	            }
	        
	        return result.toString();
	    }


	    @Override
	    public String visitComment(Tree2SystemVerilogParser.CommentContext ctx) {
	    	//System.out.println("im in comment");
	        return "  " + ctx.STRING().getText().replace("\"", "")+"\n";// Convert comment to C-style comment
	    }

	    @Override
	    public String visitPrint(Tree2SystemVerilogParser.PrintContext ctx) {
	    	
	    	String printStatement=ctx.STRING().getText().replace("*", "\"");
	    	printStatement=printStatement.substring(1, printStatement.length()-1);
	    	if (printStatement.startsWith("printf"))
	    		printStatement=printStatement.replace("printf", "$display");
	    	
	    	
	        return "   "+printStatement; // Example placeholder for print statements
	    }

	    @Override
	    public String visitDataTypes(Tree2SystemVerilogParser.DataTypesContext ctx) {
	        
	    	switch (ctx.getText().replace("\"", "")) {
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
	            return "int";//ctx.getText().replace("\"", ""); // Default to int for unsupported types
	    	}      
	    	//return ctx.getText(); // Return data type as is
	    }

	    @Override
	    public String visitOperator(Tree2SystemVerilogParser.OperatorContext ctx) {
	        return ctx.getText(); // Return operator as is
	    }
	    
        //You can add more specific handling for other rules as needed    
        
	    public String getcCode() {
    
          return null;//sb.toString();
}

}