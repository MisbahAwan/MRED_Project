package Uppaal2TreeTransformations;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import C2SystemVerilogTransformations.C2SystemVerilogParser.DataTypeContext;
import C2SystemVerilogTransformations.C2SystemVerilogParser.ParameterListContext;

public class UppaalToTreeVisitor extends Uppaal2TreeBaseVisitor<String> {
    
	StringBuilder output;
	boolean GuardOn=false;
	boolean switchStatement=false;
	boolean caseStatement=false;
	boolean defaultStatement=false;
	boolean ifStatement=false;
	boolean elseStatement=false;
	
	boolean ElseIf=false;
    String switchCondition="";
	
	boolean ForLoopOpen=false;
	boolean closeIfAndElse=false;
	
	int IfStatementsCount=0; 
	boolean moreThanOneStatements=false;
	
	int LabelsCountInLoopTransition=0;
	
    @Override
    public String visitFile(Uppaal2TreeParser.FileContext ctx) {
        output = new StringBuilder();
        //System.out.println("output1:......................................................."+output);
        output.append(visit(ctx.ntaSection()));
        //System.out.println("output2:........................................................"+output);
        return output.toString();
    }

    @Override
    public String visitNtaSection(Uppaal2TreeParser.NtaSectionContext ctx) {
        StringBuilder output = new StringBuilder();
    	
    	output.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    	output.append("<dSML:System\n");
    	output.append("    xmi:version=\"2.0\"\n");
    	output.append("    xmlns:xmi=\"http://www.omg.org/XMI\"\n");
    	output.append("    xmlns:dSML=\"http://www.example.org/dSML\">\n");
    	
    	
    	
        for (Uppaal2TreeParser.NtaItemContext item : ctx.ntaItem()) {
            output.append(visit(item));
        }
    	output.append("\n</dSML:System>");
        return output.toString();
    }

    @Override
    public String visitNtaItem(Uppaal2TreeParser.NtaItemContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(Uppaal2TreeParser.DeclarationContext ctx) { 
        StringBuilder output = new StringBuilder();
        output.append("  <declaration>\n");
        for (Uppaal2TreeParser.DeclarationItemContext item : ctx.declarationItem()) {
            output.append(visit(item));
        }
        output.append("  </declaration>\n");
        return output.toString();
    }

    @Override
    public String visitTemplate(Uppaal2TreeParser.TemplateContext ctx) {
    	
    	StringBuilder output = new StringBuilder();
    	String dataType ="", functionName="", returnType="";
    	String parameters="";
    	
    	//String returnType=null;
    	if(ctx.comment(0)!=null)
    	{
    		returnType=visitComment(ctx.comment(0)); 
    		//System.out.println(returnType);
    		//returnType=returnType.substring(0, returnType.length() - 7);
    	}
    	
    	functionName = ctx.nameSection().ID().getText();
    	//returnType = "void";
    	
    	output.append("  <component\n");
    	output.append("      name=\""+functionName+"\"\n");
    	output.append("      type=\""+returnType+"\">\n");
    	
    	if (ctx.templateParameter() != null)
    		output.append(visit(ctx.templateParameter()));
    	        
        // Loop through all the children of the template in the order they appear in the source
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof Uppaal2TreeParser.LocationContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the location
            } else if (ctx.getChild(i) instanceof Uppaal2TreeParser.TransitionContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the transition
            } else if (ctx.getChild(i) instanceof Uppaal2TreeParser.CommentContext) {
            	if (i!=1) // comment at 0 is captured above
            	output.append(visit(ctx.getChild(i)));  // Visit the comment
            } else {
                // Handle other potential child types if needed
                output.append("");
            }
        }
        output.append("  </component>\n");
        return output.toString();
    }

    @Override
    public String visitSystem(Uppaal2TreeParser.SystemContext ctx) {
        return "";// "system " + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitQueries(Uppaal2TreeParser.QueriesContext ctx) {
      
        return "";//output.toString();
    }

    @Override
    public String visitDeclarationItem(Uppaal2TreeParser.DeclarationItemContext ctx) {
    	
    		String output = "";
            if (ctx.declarationVar() != null) {
            	output= visitDeclarationVar(ctx.declarationVar());
            } else if (ctx.declarationFunc() != null) {
            	output= visitDeclarationFunc(ctx.declarationFunc());
            } else if (ctx.comment() != null) {
            	output= visitComment(ctx.comment());
            }
            return output;
     }


    @Override
    public String visitDeclarationVar(Uppaal2TreeParser.DeclarationVarContext ctx) { 
    	//declarationVar: DATATYPE ID (LBRACK INT RBRACK)? SEMICOLON; // Variable declaration
    	
    	StringBuilder output = new StringBuilder();
    	
    	String dataType="";
    	if(ctx.CONST()!=null)
    		dataType=ctx.CONST().getText()+" ";
    	if (ctx.DATATYPE()!=null)
    		dataType=dataType+ctx.DATATYPE().getText();
    	
    	output.append("    <attribute\n");
    	output.append("        isGlobal=\"extern\"\n");

        output.append("        dataType=");
        output.append("\""+dataType+"\"\n");
        
        output.append("        name=");
        output.append("\""+ctx.ID(0).getText()+"\"\n");
        
        output.append("        size=\"");
        
        if (ctx.LBRACK() != null && ctx.ARRAY_SV()!=null) 
            output.append(ctx.LBRACK().getText()+ctx.INT(0).getText()+ctx.ARRAY_SV().getText()+ctx.RBRACK().getText());
        else if (ctx.LBRACK() != null && ctx.ARRAY_SV()==null) 
        	 output.append(ctx.LBRACK().getText()+ctx.INT(0).getText()+ctx.RBRACK().getText());
        
        output.append("\"\n");
        
        //initial value
        output.append("        initialValue=");
        if(ctx.initValue!=null)
       	  output.append("\""+ctx.initValue.getText()+"\"");
        //else if(ctx.INT(1)!=null)
          //output.append("\""+ctx.INT(1).getText()+"\"");
        else
          output.append("\"\"");
        
        output.append("/>\n");
        return output.toString();
    }

    @Override
    public String visitDeclarationFunc(Uppaal2TreeParser.DeclarationFuncContext ctx) {//System.out.println("I am 7");
    	
    	//declarationFunc: DATATYPE ID LPAREN RPAREN LBRACE RBRACE; // Function declaration
    	StringBuilder output = new StringBuilder();
    	String dataType ="", functionName="";
    	
    	String parameters="";
    	if (ctx.parameterList() != null) {
    		parameters=visit(ctx.parameterList());
        }
    	
    	if(ctx.DATATYPE()!=null)
    		dataType= ctx.DATATYPE().getText();
        else if(ctx.VOID()!=null)
        	dataType=ctx.VOID().getText();
    	
    	functionName = ctx.ID().getText();
    	
    	output.append("    <functionprototype\n");
    	output.append("        returnType=\""+dataType+"\"\n");
    	output.append("        functionName=\""+functionName+"\">\n");
    	output.append("      <parameter name=\""+parameters+"\"/>\n");
    	
        output.append("    </functionprototype>\n");
        return output.toString();
    }

    @Override
    public String visitLocation(Uppaal2TreeParser.LocationContext ctx) {
        return "";//"location ";// + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitTransition(Uppaal2TreeParser.TransitionContext ctx) {
        StringBuilder output = new StringBuilder();

        for (Uppaal2TreeParser.LabelContext label : ctx.label())
            output.append(visit(label));
          
        return output.toString();
    }

    @Override
    public String visitLabel(Uppaal2TreeParser.LabelContext ctx) {
    	
    	StringBuilder output = new StringBuilder();
    	String expression = ctx.expression().getText().replace("&gt;", ">");
    	
    	String leftSide="", rightSide="", operator="";
    	
    	if(ctx.expression().ID(0)!=null)
    		leftSide = ctx.expression().ID(0).getText();
    	if(ctx.expression().op(0)!=null)
    		operator= ctx.expression().op(0).getText();
    	if(ctx.expression().rightSide(0)!=null)
    	{
    		rightSide= ctx.expression().rightSide(0).getText();
    		if(operator.equals("&amp;&amp;"))
    			rightSide="currentSpeed";//ctx.expression().rightSide(0).complex().ID(0).getText();
    	}
    	if(ctx.STRING().getText().contains("guard"))
    	{
    		/*if(ctx.expression().getText().equals("else!=null"))
    		{
    			output.append("    <statement>\n");
    			output.append("      <if\n");
    			output.append("          keyword=\"else\">\n");
    			elseStatement=true;
    		}
    		else*/ 
    		if(ctx.expression().getText().contains("switch"))
    		{
    			output.append("    <statement>\n");
    			output.append("      <switch\n");
    			output.append("          keyword=\"switch\"\n");
    			output.append("          value=\""+expression.substring("switch==".length())+"\">\n");

    			switchStatement=true;
    			switchCondition=expression.substring("switch==".length())+"==";
    			//output.append("switch(").append(expression.substring("switch:".length())).append(")\n begin\n");
    		}
    		/*else if(ctx.expression().getText().contains("case"))
    		{
    			output.append("        <switchcase\n");
    			output.append("            keyword=\"case\"\n");
    			output.append("            value=\""+expression.substring("case".length())+"\">\n"); 
    			caseStatement=true;
    			//output.append(" case ").append(expression.substring("case".length())).append(":\n   begin\n");
    		}*/
    		else if(switchStatement && !expression.contains("def") && expression.contains(switchCondition))
    		{
    			if(ctx.expression().getText().contains(expression.substring("switch==".length())))//if contains switch condition(switch case preserved in uppaal in this way)
    			{
    			output.append("    <switchcase\n");
    			output.append("            keyword=\"case\"\n");
    			output.append("            value=\""+expression.substring(switchCondition.length())+"\">\n"); 
    			caseStatement=true;
    			}
    		}
    		else if(ctx.expression().getText().contains("def==1"))
    		{
    			output.append("      <switchcase\n");
    			output.append("            keyword=\"default\">\n");
    			output.append("      	<assignment\n");
        		output.append("          leftAttribute=\"break\"\n");
        		output.append("          operator=\"\"\n");
        		output.append("          AssignedSide=\"\"/>\n");
        		//output.append("      </switchcase>\n\n");
        		//output.append("   </switch>\n");
        		//output.append("   </statement>\n");
    			//output.append(expression).append(":\n   begin		break; end\n");
    			defaultStatement=true;
    		}
    		else if (ForLoopOpen)
    		{
    			
    			output.append("\"\n");
    			if(LabelsCountInLoopTransition==0)
    				output.append("          condition=\""+ctx.expression().getText()+"\"\n");
    			
    			LabelsCountInLoopTransition=LabelsCountInLoopTransition+1;
  			
    		}
    		
    		else
    		{
    			if(ctx.expression().getText().length()>0)
    			{
    				if(ElseIf)
    				{
		    			output.append("    <statement>\n");
		    			output.append("      <if\n");
		    			output.append("          keyword=\"else if\"\n");
		    			output.append("          variable=\""+leftSide+"\"\n");
		    			output.append("          operator=\""+operator+"\"\n");
		    			output.append("          value=\""+rightSide+"\">\n");
    				}
    				else
    				{
		    			output.append("    <statement>\n");
		    			output.append("      <if\n");
		    			output.append("          keyword=\"if\"\n");
		    			output.append("          variable=\""+leftSide+"\"\n");
		    			output.append("          operator=\""+operator+"\"\n");
		    			output.append("          value=\""+rightSide+"\">\n");
    				}
    				ElseIf=false;
    			}
    			else
    			{
    				output.append("    <statement>\n");
        			output.append("      <if\n");
        			output.append("          keyword=\"else\">\n");
        			elseStatement=true;
    				
    			}
    			ifStatement=true;
    		    //output.append("	if (").append(ctx.expression().getText()).append(") begin\n");
    		}
    	//}
    		
    		GuardOn=true;
    	}
    	else if(ctx.STRING().getText().equals("\"assignment\""))
    	{
    		IfStatementsCount=0;
    		//moreThanOneStatements=false;
    		
    		
            	
    		
    		String input = ctx.expression().getText(); //System.out.println("input: "+input);
    		StringBuilder innerLoop_result = new StringBuilder();
    		StringBuilder result = new StringBuilder();
            StringBuilder currentSegment = new StringBuilder();
            int parenthesesDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                
                if (ch == '(') {
                    parenthesesDepth++;  // We're inside a function call
                } else if (ch == ')') {
                    parenthesesDepth--;  // We're closing a function call
                }
                
                if (ch == ',' && parenthesesDepth == 0) {
                    // Split only if we're not inside a function call
                	innerLoop_result.append(currentSegment.toString().trim()).append(";	");
                    currentSegment.setLength(0); // Reset current segment
                    IfStatementsCount=IfStatementsCount+1;
                } else {
                    currentSegment.append(ch);
                }
            }
            
           /* if(IfStatementsCount>0)
            {
            	// commented .. result.append("{\n");
            	moreThanOneStatements=true;
            }
            else
            	result.append("\n");
            	*/
            result.append("    "+innerLoop_result.toString());
            
            // Append the last segment
            result.append(currentSegment.toString().trim()).append(";"); // System.out.println("result.tostring: "+result.toString());
           
            String[] parts = result.toString().split(";"); 
            
            // Print the parts
            for (String part : parts) {
            /* if(ForLoopOpen)
             {	
            	 output.append(part);
             }*/ 
             if(ForLoopOpen && LabelsCountInLoopTransition==0)
     		{
     	        // Create transition for loop initialization
     	        output.append("    <statement>\n      <loop\n          type=\"for"+"\"\n          initial=\"int ");
     	       output.append(part);
     	        
     		}
     		else if(ForLoopOpen && LabelsCountInLoopTransition==1)
     		{
     	        output.append("          increment=\""+ctx.expression().getText()+"\">\n");
     	        LabelsCountInLoopTransition=0;
 				ForLoopOpen=false;
     		}
             else
             { 
            	if(part.contains("-="))
            	{
            		int SignIndex;
            	    String beforeEqual = "";
            	    String Sign = "";
            	    String afterEqual = "";
            		
	            	    SignIndex = part.indexOf("-=");
	            	    beforeEqual = part.substring(0, SignIndex).trim();
	            	    Sign = part.substring(SignIndex, SignIndex + 2);
	            	    afterEqual = part.substring(SignIndex + 2).trim().replace("\"", "'");
            		
            		
            		if(!GuardOn)
            			output.append("    <statement>\n");
	        		output.append("      <assignment\n");
	        		output.append("          leftAttribute=\""+beforeEqual+"\"\n");
	        		output.append("          operator=\""+Sign+"\"\n");
	        		output.append("          AssignedSide=\""+afterEqual+"\"/>\n");
	        		if(!GuardOn)
	        			output.append("    </statement>\n");
            	}
            	else if(part.contains("+="))
            	{
            		int SignIndex;
            	    String beforeEqual = "";
            	    String Sign = "";
            	    String afterEqual = "";
            		
	            	    SignIndex = part.indexOf("+=");
	            	    beforeEqual = part.substring(0, SignIndex).trim();
	            	    Sign = part.substring(SignIndex, SignIndex + 2);
	            	    afterEqual = part.substring(SignIndex + 2).trim().replace("\"", "'");
            		
            		
            		if(!GuardOn)
            			output.append("    <statement>\n");
	        		output.append("      <assignment\n");
	        		output.append("          leftAttribute=\""+beforeEqual+"\"\n");
	        		output.append("          operator=\""+Sign+"\"\n");
	        		output.append("          AssignedSide=\""+afterEqual+"\"/>\n");
	        		if(!GuardOn)
	        			output.append("    </statement>\n");
            	}
            	else if(part.contains("="))
            	{
            		int SignIndex;
            	    String beforeEqual = "";
            	    String Sign = "";
            	    String afterEqual = "";
            		
	            	    SignIndex = part.indexOf("=");
	            	    beforeEqual = part.substring(0, SignIndex).trim();
	            	    Sign = part.substring(SignIndex, SignIndex + 1);
	            	    afterEqual = part.substring(SignIndex + 1).trim().replace("\"", "'");
            		
            		
            		if(!GuardOn)
            			output.append("    <statement>\n");
	        		output.append("      <assignment\n");
	        		output.append("          leftAttribute=\""+beforeEqual+"\"\n");
	        		output.append("          operator=\""+Sign+"\"\n");
	        		output.append("          AssignedSide=\""+afterEqual+"\"/>\n");
	        		if(!GuardOn)
	        			output.append("    </statement>\n");
            	}
            	else if(part.contains("++"))
            	{
            		int SignIndex;
            	    String beforeEqual = "";
            	    String Sign = "";
            	    String afterEqual = "";
            	    
	            	    SignIndex = part.indexOf("+");
	            	    beforeEqual = part.substring(0, SignIndex).trim();
	            	    Sign = "++";//part.substring(equalSignIndex, equalSignIndex + 1);
	            	    afterEqual = "";//part.substring(equalSignIndex + 1).trim();
            		
            		if(!GuardOn)
            			output.append("    <statement>\n");
	        		output.append("      <assignment\n");
	        		output.append("          leftAttribute=\""+beforeEqual+"\"\n");
	        		output.append("          operator=\""+Sign+"\"\n");
	        		output.append("          AssignedSide=\""+afterEqual+"\"/>\n");
	        		if(!GuardOn)
	        			output.append("    </statement>\n");
            		
            	}
            	else if(part.contains("("))
            	{
            		// Find the position of the first '(' character
            	    int firstParenIndex = part.indexOf('(');

            	    // Get the part before the '('
            	    String leftPart = part.substring(0, firstParenIndex).trim();

            	    // Get the part after the '(' and trim the last ')'
            	    String rightPart = part.substring(firstParenIndex + 1).trim();
            	    rightPart = rightPart.replaceAll("\\)$", "").trim(); // Remove the last closing ')'
            	    
            	    if(!GuardOn)
            		output.append("    <statement>\n");
            		output.append("      <functioncall\n");
            		output.append("          functionName=\""+leftPart+"\"\n");
            		output.append("          parameterString=\""+rightPart+"\"/>\n");
            		if(!GuardOn)
            		output.append("    </statement>\n");
            	}
              }
            }
            
    		//output.append("	"+result.toString().replace(";", ";\n  "));

    		if(GuardOn)
    		{
    			/*if (switchStatement)
    			{
    				//output.append(" break;\n");
    				switchStatement=false;
    			}*/
    			if (ifStatement || elseStatement)
    			{
    				output.append("      </if>\n");
    				output.append("    </statement>\n");
    				ifStatement=false;
    				elseStatement=false;
    			}
    			if (caseStatement)
    			{
    				//output.append("      <assignment\n");
	        		//output.append("          leftAttribute=\"break\"\n");
	        		//output.append("          operator=\"\"\n");
	        		//output.append("          AssignedSide=\"\"/>\n");
	        		//output.append("      </switchcase>\n");
	        		caseStatement=false;
    			}
    			/*if (defaultStatement)
    			{
    				output.append("      <assignment\n");
	        		output.append("          leftAttribute=\"break\"\n");
	        		output.append("          operator=\"\"\n");
	        		output.append("          AssignedSide=\"\"/>\n");
	        		output.append("      </switchcase>\n\n");
	        		output.append("   </switch>\n");
	        		defaultStatement=false;
    			}*/
    			GuardOn=false;
    			if(moreThanOneStatements)//closeIfAndElse)
        		{
        			// commented ... output.append("   end\n");
        			moreThanOneStatements=false;
        			//closeIfAndElse=false;
        		} 
        		else 
        			output.append("\n");
    		}
    	}
    	
        return output.toString().replace("-->", "-->\n\t");
    }

    @Override
    public String visitSource(Uppaal2TreeParser.SourceContext ctx) {
        return "";//ctx.STRING().getText(); // Return the source reference
    }

    @Override
    public String visitTarget(Uppaal2TreeParser.TargetContext ctx) {
        return "";//ctx.STRING().getText(); // Return the target reference
    }

    @Override
    public String visitQuery(Uppaal2TreeParser.QueryContext ctx) {
        return "";//query: " + visit(ctx.OPEN_FORMULA()) + ";\n"; // Adjust as needed for actual query handling
    }

    @Override
    public String visitComment(Uppaal2TreeParser.CommentContext ctx) {
       
	    String Uppaalcomment="";//ctx.UPPAAL_COMMENT_WITH_TEXT().getText();
        String getString = "";//Uppaalcomment.substring(4, Uppaalcomment.length() - 3);
        String returnComment="";
        
        if(ctx.UPPAAL_COMMENT_WITH_TEXT()!=null)
        {
        	Uppaalcomment=ctx.UPPAAL_COMMENT_WITH_TEXT().getText();
            getString = Uppaalcomment.substring(4, Uppaalcomment.length() - 3);
            if(getString.contains("printf") || getString.contains("$display" ) )
            	returnComment="    <print  printText=\""+getString.replace("\"", "*")+";\"/>\n";
            else 
            	{
            	  getString=getString.trim();
            	  returnComment="    <comment"+"   commentText=\""+getString+"\"/>\n";   
            	  //returnComment="// "+getString+"\n";
            	}
        }
        
        else if (ctx.UPPAAL_COMMENT()!=null)
        {
        	Uppaalcomment=ctx.UPPAAL_COMMENT().getText(); 
        	
        	if(Uppaalcomment.contains("Posting Declarations from all templates here:"))
            	returnComment="";
        	else if(Uppaalcomment.contains("printf") || Uppaalcomment.contains("$display" ) )
            	returnComment="    <print  printText=\""+Uppaalcomment.replace("\"", "*")+";\"/>\n";
            	//returnComment= "	"+Uppaalcomment.replace("printf","$display")+";\n";
            else if(Uppaalcomment.contains("#include"))
        	{
        		returnComment="  </declaration> \n <includedirective\n        keyword=\"#include\"\n";
        		returnComment=returnComment+"        name=\""+Uppaalcomment.substring(2).replace("#include", "").replace("&gt;", ">").trim()+"\"/>\n    <declaration>\n";
        	}
            else if(Uppaalcomment.contains("FOR_LOOP_OPEN"))
            	ForLoopOpen=true;//closing for loop
            else if(Uppaalcomment.contains("FOR_LOOP_CLOSE"))
            	returnComment= "    </loop>\n   </statement>";//closing for loop  
            else if(Uppaalcomment.contains("SWITCH_STATEMENT_CLOSED"))
            	returnComment="   </switch>\n   </statement>";//closing for loop 
            else if(Uppaalcomment.contains("BREAK_STATEMENT"))
            {
            	returnComment="      <assignment\n";
            	returnComment=returnComment+"          leftAttribute=\"break\"\n";
            	returnComment=returnComment+"          operator=\"\"\n";
            	returnComment=returnComment+"          AssignedSide=\"\"/>\n";
            	returnComment=returnComment+"      </switchcase>\n";
            	//closing for loop 
            }
            else if(Uppaalcomment.contains("TEMPLATE_RETURN_TYPE"))
            	returnComment=Uppaalcomment.substring(23);//closing for loop 
            else if(Uppaalcomment.contains("ELSE"))
            	 ElseIf=true;////closing for loop 
            else
            {
            	returnComment="    <comment"+"   commentText=\""+Uppaalcomment+"\"/>\n";
            }
            	
            
        }
	     
	    
	    return returnComment;//result.toString();
    }
    
    @Override
    public String visitParameterList(Uppaal2TreeParser.ParameterListContext ctx) {
    	
        StringBuilder result = new StringBuilder();

        // Visit each parameter in the list
        for (int i = 0; i < ctx.parameter().size(); i++) {
            // Visit the parameter and append it to the parameters list
        	result.append(ctx.parameter(i).getText()+", ");
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
        return result.toString();
    }
    
    @Override
    public String visitTemplateParameter(Uppaal2TreeParser.TemplateParameterContext ctx) {
    	
    	// templateParameter : OPEN_PARAMETER (DATATYPE | VOID)? qualifier? pointer? ID? CLOSE_PARAMETER ;
        StringBuilder result = new StringBuilder();
        String constVar="", dataType="", voidVar="", name="";
        
        for (int i = 0; i < ctx.ID().size(); i++)
	    {
	        if (ctx.CONST(i)!= null) 
	        	constVar=ctx.CONST(i).getText()+" ";
	        if(ctx.DATATYPE(i)!=null) 
	        	dataType=ctx.DATATYPE(i).getText()+" ";
	        else if(ctx.VOID(i)!=null) 
	        	voidVar=ctx.VOID(i).getText()+" ";
	        if (ctx.ID(i) != null) 
	        	  name=ctx.ID(i).getText()+" ";
	          
	        result.append("    <parameter\n        name=\""+name.trim()+"\"\n");
	        result.append("        dataType=\""+dataType.trim()+"\"\n");
	        result.append("        qualifier=\""+voidVar.trim()+"\"\n");
	        result.append("        pointer=\""+constVar.trim()+"\"/>\n");
           
	     // Check if the last character is a comma and remove it
	       // if (result.charAt(result.length() - 2) == ',') {
	        //	result.setLength(result.length() - 2); // Remove last ", "
	        //}
        }
        return result.toString();
    }
	   
	    public String visitDataType(String type) {
	       /* switch (type) {
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
	                return "int"; // Default to int for unsupported types
	        }*/
	    	return type;
	    } 
    // You can add more specific handling for other rules as needed    
   /* public String getcCode() {
        
        return output.toString();
    }*/
}
