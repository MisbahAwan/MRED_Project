package Tree2CTransformation;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class TreeToCVisitor extends Tree2CBaseVisitor<String> {

	//StringBuilder sb;
	
	    @Override
	    public String visitSystem(Tree2CParser.SystemContext ctx) {
	    	StringBuilder sb = new StringBuilder();
	    	for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2CParser.PreprocessorDirectiveContext) {
	            	// Visit preprocessor directive
	            	sb.append(visitPreprocessorDirective((Tree2CParser.PreprocessorDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2CParser.IncludeDirectiveContext) {
	            	// Visit include directive
	            	sb.append(visitIncludeDirective((Tree2CParser.IncludeDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2CParser.CommentContext) {
	            	// Visit module declaration
	            	sb.append(visitComment((Tree2CParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2CParser.DeclarationContext) {
	            	// Visit module declaration
	            	sb.append(visitDeclaration((Tree2CParser.DeclarationContext) child));
	            } 
	            else if (child instanceof Tree2CParser.ComponentContext) {
	            	// Visit module declaration
	            	sb.append(visitComponent((Tree2CParser.ComponentContext) child));
	            }
	            else if (child instanceof Tree2CParser.PrintContext) {
	            	// Visit module declaration
	            	sb.append(visitPrint((Tree2CParser.PrintContext) child));
	            }
	            
	        }
	        return sb.toString();
	    }
	    
	    @Override
	    public String visitPreprocessorDirective(Tree2CParser.PreprocessorDirectiveContext ctx) {
	    	StringBuilder result = new StringBuilder();
	        String id = ctx.ID().getText();
	        String value = ctx.NUMBER().getText();
	        result.append( "#define " + id +" "+ value+"\n");
	        return result.toString();
	    }

	    @Override
	    public String visitIncludeDirective(Tree2CParser.IncludeDirectiveContext ctx) {
	    	
	    	return  visit(ctx.systemInclude() != null ? ctx.systemInclude() : ctx.localInclude());
	    	 
	    }

	    @Override
	    public String visitSystemInclude(Tree2CParser.SystemIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	result.append( "#include <" + header + ">").append(" \n");
	        
	        return result.toString();
	    }

	    @Override
	    public String visitLocalInclude(Tree2CParser.LocalIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText().replace("&lt;", "<");
	    	result.append( "#include \"" + header + "\"").append(" \n");
	        
	        return result.toString();
	    }
		
	    @Override
	    public String visitEnumDecl(Tree2CParser.EnumDeclContext ctx) {
	        
	    	StringBuilder result = new StringBuilder();
	    	String typedef = "typedef";
	        String enumType = "enum";
	        String enumName = ctx.ID().getText();
	        
	        result.append(""+typedef + " " + enumType + " {  \n ");

	        result.append(visitEnumList(ctx.enumList()));
	        
	        result.append(" } " + enumName + ";\n");
	       
	        return result.toString();

	    }

	    @Override
	    public String visitEnumList(Tree2CParser.EnumListContext ctx) {
	    	    	
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
	    public String visitDeclaration(Tree2CParser.DeclarationContext ctx) {
	        StringBuilder sb = new StringBuilder();

	     // Loop through each child node in the file rule
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2CParser.AttributeContext) {
	            	sb.append(visitAttribute((Tree2CParser.AttributeContext) child));
	            } 
	            else if (child instanceof Tree2CParser.FunctionprototypeContext) {
	            	sb.append(visitFunctionprototype((Tree2CParser.FunctionprototypeContext) child));
	            } 
	            else if (child instanceof Tree2CParser.CommentContext) {
	            	sb.append(visitComment((Tree2CParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2CParser.EnumDeclContext) {
	            	sb.append(visitEnumDecl((Tree2CParser.EnumDeclContext) child));
	            }         
	        }
	        return sb.toString();
	    }

	    @Override
	    public String visitAttribute(Tree2CParser.AttributeContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String extern="", size="", initialValue="", datatype="", attribute="";

	        if(ctx.EXTERN()!=null) 
	        	extern=ctx.EXTERN().getText();
	       /* if(ctx.STRING(0)!=null) 
	        	size=ctx.STRING(0).getText();
	        if(ctx.STRING(1)!=null) 
	        	initialValue= " = "+ctx.STRING(1).getText();*/
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
	        
	        extern=extern.replace("\"", "");
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
	            //result.append("[").append(ctx.INT(0).getText()).append("]");
	        	if (size.contains("[") && size.contains(":")) {
	                //result.append("[").append(ctx.INT(0).getText()).append("]");
	        		// Find the index of '[' and ':'
	                int startIndex = size.indexOf('[') + 1;
	                int endIndex = size.indexOf(':');
	                
	                // Extract the substring between '[' and ':'
	                String extractedValue = size.substring(startIndex, endIndex);
	                
	                // Convert the extracted string to an integer (if needed)
	                int arraySize = Integer.parseInt(extractedValue);
	            	//int arraySize = Integer.parseInt(ctx.INT(0).getText()) + 1;
	            	size="["+arraySize+"]";
	            }
	        	//else
	        		//sb.append(size);
	        	/*size=size.substring(1); // Trim first character
	        	size=size.substring(0, size.length() - 1); // Return the string excluding the last character
	        	int arraySize = Integer.parseInt(size) - 1;
	        	size="["+arraySize+":0]";*/
	        }
	        
	        //sb.append(datatype+" "+attribute+size+initialValue+";\n");

	       /*
	        extern=extern.replace("\"", "");
	        size=size.replace("\"", "");
	        initialValue=initialValue.replace("\"", "");
	        datatype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        attribute=ctx.ID(0).getText().replace("\"", ""); */
	        
	        sb.append(extern+" "+datatype+" "+attribute+size+initialValue+";\n");

	        return sb.toString();
	    }

	    @Override
	    public String visitFunctionprototype(Tree2CParser.FunctionprototypeContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        
	        String returntype="", functionname="";
	        StringBuilder parameters= new StringBuilder();
	        
	        returntype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        functionname=ctx.ID().getText().replace("\"", "");
	        sb.append(returntype+" "+functionname+"( ");
	        
	        
	        for (Tree2CParser.ParameterContext parameter : ctx.parameter()) {
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
	        
	        sb.append(");\n");
	        	// Additional function logic can be added here
	        //sb.append("}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitComponent(Tree2CParser.ComponentContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
            String componentName="", returnType="";
	        
            returnType=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        componentName=ctx.ID().getText().replace("\"", "");
	        sb.append(returnType+" "+componentName+"( ");
	        
	        for (Tree2CParser.ParameterContext parameter : ctx.parameter()) {
	            sb.append(visit(parameter)).append(", ");
	        }
	        if (ctx.parameter().size() > 0) {
	            sb.setLength(sb.length() - 2); // Remove last comma and space
	        }
	        sb.append(") \n{\n");
	        
	        // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	        	 if (child instanceof Tree2CParser.CommentContext) {
		                // Process the comment
		                sb.append(visitComment((Tree2CParser.CommentContext) child)).append("\n");
		            } else if (child instanceof Tree2CParser.StatementContext) {
		                // Process the statement
		                sb.append(visitStatement((Tree2CParser.StatementContext) child)).append("\n");
		            } else if (child instanceof Tree2CParser.DeclarationContext) {
		                // Process declarations, if any (optional)
		                sb.append(visitDeclaration((Tree2CParser.DeclarationContext) child)).append("\n");
		            } else if (child instanceof Tree2CParser.ReturnContext) {
		                // Process declarations, if any (optional)
		                sb.append(visitReturn((Tree2CParser.ReturnContext) child)).append("\n");
		            } else if (child instanceof Tree2CParser.PrintContext) {
		            	// Visit module declaration
		            	sb.append(visitPrint((Tree2CParser.PrintContext) child));
		            } else if (child instanceof Tree2CParser.LoopContext) {
		            	// Visit module declaration
		            	sb.append(visitLoop((Tree2CParser.LoopContext) child));
		            }
	        }
	        sb.append("\n}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitParameter(Tree2CParser.ParameterContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	        String pointer="", qualifier="", datatype="", attribute="";
	        
	        if(ctx.ID(0)!=null) 
	        	attribute=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.dataTypes()!=null) 
	        	datatype=visitDataTypes(ctx.dataTypes()).replace("\"", "");
	        if(ctx.ID(1)!=null) 
	        	qualifier= ctx.ID(1).getText().replace("\"", "");
	        if(ctx.STAR()!=null | ctx.STARR()!=null) 
	        	pointer= ctx.STAR().getText().replace("\"", "");
	        
	        datatype=datatype+" ";
	        qualifier=qualifier+" ";
	        pointer=pointer+" ";
	        
	        sb.append(datatype+qualifier+pointer+attribute);
	        	        
	        return sb.toString();
	    }

	    @Override
	    public String visitStatement(Tree2CParser.StatementContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2CParser.CommentContext) {
	                // Process the comment
	                sb.append(visitComment((Tree2CParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.AssignmentContext) {
	                // Process the assignment
	                sb.append(visitAssignment((Tree2CParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	                sb.append(visitFunctioncall((Tree2CParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitIfstatement((Tree2CParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.SwitchContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitSwitch((Tree2CParser.SwitchContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.ReturnContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitReturn((Tree2CParser.ReturnContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.LoopContext) {
	            	// Visit module declaration
	            	sb.append(visitLoop((Tree2CParser.LoopContext) child));
	            }
	        }
	    	
	    	return sb.toString();//visitChildren(ctx); // Let children handle their own visits
	    }

	    @Override
	    public String visitIfstatement(Tree2CParser.IfstatementContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String keyword = ctx.getChild(0).getText();
	        
	        String ifVar="", elseVar="", operator="", value="", variable="";
	        
	        if(ctx.IF()!=null) 
	        	ifVar=ctx.IF().getText().replace("\"", "");
	        else if(ctx.ELSE()!=null) 
	        	ifVar=ctx.ELSE().getText().replace("\"", "");
	        else if(ctx.ELSEIF()!=null) 
	        	ifVar=ctx.ELSEIF().getText().replace("\"", "");
	        
	        if(ctx.ID(0)!=null) 
	        	variable=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.operator()!=null) 
	        	operator= ctx.operator().getText().replace("\"", "").replace("&lt;", "<").replace("&amp;", "&");
	        
	        if(ctx.STRING()!=null) 
	        	value=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID(1)!=null) 
	        	value=ctx.ID(1).getText().replace("\"", "");
	        else if(ctx.NUMBER()!=null) 
	        	value=ctx.NUMBER().getText().replace("\"", "");

	        if(ifVar.equals("keyword=if"))
	        {
	        	sb.append("	if ("+variable+" "+operator+" "+value+")\n	{\n");
	        }
	        else if(ifVar.equals("keyword=else"))
	        {
	        	sb.append("	else \n	{\n");
	        }
	        else if(ifVar.equals("keyword=else if"))
	        {
	        	sb.append("	else if ("+variable+" "+operator+" "+value+")	{\n");
	        }
	       
	       // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2CParser.CommentContext) {
	                // Process the comment
	                sb.append(visitComment((Tree2CParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.AssignmentContext) {
	                // Process the assignment
	                sb.append(visitAssignment((Tree2CParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	                sb.append(visitFunctioncall((Tree2CParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitIfstatement((Tree2CParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.ReturnContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitReturn((Tree2CParser.ReturnContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.StatementContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitStatement((Tree2CParser.StatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitDeclaration((Tree2CParser.DeclarationContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.PrintContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitPrint((Tree2CParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.SwitchContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitSwitch((Tree2CParser.SwitchContext) child)).append("\n");
	            } 
	        }
	        
	        sb.append("	}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch(Tree2CParser.SwitchContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        sb.append("switch (").append(ctx.ID().getText().replace("\"", "")).append(") \n{\n");
	        
	        for (Tree2CParser.Switch_caseContext switchCase : ctx.switch_case()) {
	            sb.append(visit(switchCase));
	        }
	        sb.append("}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch_case(Tree2CParser.Switch_caseContext ctx) {
	    	
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
	        	sb.append("case "+value+":\n");
	        	
	        	// Iterate over all children (which can be comments, statements, or declarations)
		        for (ParseTree child : ctx.children) {
		            if (child instanceof Tree2CParser.CommentContext) {
		                // Process the comment
		                sb.append(visitComment((Tree2CParser.CommentContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2CParser.AssignmentContext) {
		                // Process the assignment
		                sb.append(visitAssignment((Tree2CParser.AssignmentContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2CParser.FunctioncallContext) {
		                // Process function call, if any (optional)
		                sb.append(visitFunctioncall((Tree2CParser.FunctioncallContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2CParser.IfstatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitIfstatement((Tree2CParser.IfstatementContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2CParser.ReturnContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitReturn((Tree2CParser.ReturnContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2CParser.StatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitStatement((Tree2CParser.StatementContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2CParser.DeclarationContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitDeclaration((Tree2CParser.DeclarationContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2CParser.PrintContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitPrint((Tree2CParser.PrintContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2CParser.SwitchContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitSwitch((Tree2CParser.SwitchContext) child)).append("\n");
		            } 
		        }
		        sb.append("	\n");  
	        }
	        else if(switchdefault.contains("default"))
	        {
	        	sb.append("default "+value+":\n	{");
	        	sb.append("	break; }\n");
	        }
	      
	        return sb.toString();
	    }

	    @Override
	    public String visitAssignment(Tree2CParser.AssignmentContext ctx) {
	        
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
	        	/*if(stringText.contains("0x") | stringText.contains("0X")) stringText=stringText.replace("0x", "16'h").replace("0X", "16'h");
	        	else */if(stringText.contains("16'h")) stringText=stringText.replace("16'h", "0x");
	        	
	            sb.append("	"+stringText);
	        } else if (ctx.assignedSide().operator() != null) {
	            sb.append("	"+ctx.assignedSide().operator().getText().replace("\"", "").replace("&lt;", "<").replace("&amp;", "&")+" ");
	        } else {
	            sb.append(""); // Default empty assignment
	        }

	        sb.append(";");
	        
	        return sb.toString();
	    }

	    @Override
	    public String visitFunctioncall(Tree2CParser.FunctioncallContext ctx) {
	        
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
	    public String visitReturn(Tree2CParser.ReturnContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String expression="";
	    	if (ctx.ID() != null) expression=ctx.ID().getText();
	    	else if (ctx.NUMBER() != null) expression=ctx.NUMBER().getText();
	       
	        result.append("  return "+expression+";");
	           
	        return result.toString();
	    }
	    
	    @Override
	    public String visitLoop(Tree2CParser.LoopContext ctx) {
	    	
	    	StringBuilder result = new StringBuilder();
	    	
	    	String loopType="";//ctx.FOR().getText();
	    	if (ctx.FOR() != null) 
	    		loopType=ctx.FOR().getText();
	    	else if (ctx.FOR_VOLATILE() != null) 
	    		loopType=ctx.FOR_VOLATILE().getText();
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
	        if(loopType.equals("for"))
	        	result.append("  "+loopType+" (").append(visitDataTypes(ctx.dataTypes())+" "+init+"; ");
	        else if(loopType.equals("for volatile"))
	        	result.append("  for (volatile ").append(visitDataTypes(ctx.dataTypes())+" "+init+"; ");

	        //result.delete(result.length() - 1, result.length()); // remove '\n' from the end
	        result.append(condition+"; ");
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        result.append(increment);
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        result.append(") {\n");
	        //result.append(visit(ctx.statement())).append("\n");
	        
	        
	        // Loop condition and body transitions
	      

	        // Visit the loop body
	     // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2CParser.CommentContext) {
	                // Process the comment
	            	result.append(visitComment((Tree2CParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.AssignmentContext) {
	                // Process the assignment
	            	
	            	result.append(visitAssignment((Tree2CParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	            	result.append(visitFunctioncall((Tree2CParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2CParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitIfstatement((Tree2CParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.ReturnContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitReturn((Tree2CParser.ReturnContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.StatementContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitStatement((Tree2CParser.StatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitDeclaration((Tree2CParser.DeclarationContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.PrintContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitPrint((Tree2CParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2CParser.SwitchContext) {
	                // Process if statement, if any (optional)
	            	result.append(visitSwitch((Tree2CParser.SwitchContext) child)).append("\n");
	            }
	        }
	        
	        result.append("  }\n");
	 
	        return result.toString();
	    }

	    @Override
	    public String visitExpression(Tree2CParser.ExpressionContext ctx) {
	        StringBuilder result = new StringBuilder();
	       
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
	    public String visitComment(Tree2CParser.CommentContext ctx) {
	    	return "  " + ctx.STRING().getText().replace("\"", "")+"\n";// Convert comment to C-style comment
		    }

	    @Override
	    public String visitPrint(Tree2CParser.PrintContext ctx) {
	    	String printStatement=ctx.STRING().getText().replace("*", "\"");
	    	printStatement=printStatement.substring(1, printStatement.length()-1);
	    	if (printStatement.startsWith("$display"))
	    		printStatement=printStatement.replace("$display", "printf");
	    	
	    	
	        return "   "+printStatement; // Example placeholder for print statements
	   }

	    @Override
	    public String visitDataTypes(Tree2CParser.DataTypesContext ctx) {
	    	//System.out.println(ctx.getText().replace("\"", ""));
	    	switch (ctx.getText().replace("\"", "")) {
	        //case "int":
	          //  return "int";
	        //case "uint8_t":
	          //  return "int";
	        //case "uint32_t":
	        	//return "int";
	        //case "TickType_t":
	        	//return "int";
	        //case "longint":
	        	//return "osThreadId";	
	        case "real":
	            return "float";    
	        //case "char":
	          //  return "char"; 
	        case "byte":
	        	return "char";
	        case "logic":
	        	return "int";
	        //case "void":
	        	//return "void";	
	        default:
	            return "int";//ctx.getText().replace("\"", ""); // Default to int for unsupported types
	    	}  
	        //return ctx.getText(); // Return data type as is
	    }

	    @Override
	    public String visitOperator(Tree2CParser.OperatorContext ctx) {
	        return ctx.getText(); // Return operator as is
	    }
	    
        //You can add more specific handling for other rules as needed    
        
	    public String getcCode() {
    
          return null;//sb.toString();
}

}