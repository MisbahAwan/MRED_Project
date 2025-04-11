package Uppaal2CTransformations;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import Uppaal2SystemVerilogTransformations.Uppaal2SystemVerilogParser;

public class UppaalToCVisitor extends Uppaal2CBaseVisitor<String> {
    
	
	boolean GuardOn=false;
	boolean switchStatement=false;
	String switchCondition="";
	
	boolean ForLoopOpen=false;
	boolean closeIfAndElse=false;
	
	int IfStatementsCount=0; 
	boolean moreThanOneStatements=false;
	
	int LabelsCountInLoopTransition=0;
	
    @Override
    public String visitFile(Uppaal2CParser.FileContext ctx) {//System.out.println("I am 1");
    StringBuilder output = new StringBuilder();
        output.append(visit(ctx.ntaSection()));
        return output.toString();
    }

    @Override
    public String visitNtaSection(Uppaal2CParser.NtaSectionContext ctx) {//System.out.println("I am 2");
        StringBuilder output = new StringBuilder();
        for (Uppaal2CParser.NtaItemContext item : ctx.ntaItem()) {
            output.append(visit(item));
        }
        return output.toString();
    }

    @Override
    public String visitNtaItem(Uppaal2CParser.NtaItemContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(Uppaal2CParser.DeclarationContext ctx) { 
        StringBuilder output = new StringBuilder();//System.out.println("size:"+ ctx.declarationItem().size());
        for (Uppaal2CParser.DeclarationItemContext item : ctx.declarationItem()) {
            output.append(visit(item));
        }
        return output.toString();
    }

    @Override
    public String visitTemplate(Uppaal2CParser.TemplateContext ctx) {
        StringBuilder output = new StringBuilder();
        String parameters="";
        
        String returnType=null;
    	if(ctx.comment(0)!=null)
    		returnType=visitComment(ctx.comment(0)); 
    		//returnType=returnType.substring(0, returnType.length() - 7);
    	
        
    	if (ctx.templateParameter() != null) {
    		parameters=visit(ctx.templateParameter());
        }
    	output.append(returnType+" ").append(ctx.nameSection().ID().getText()).append("("+parameters+") \n{\n");
        
        
        //output.append(visitChildren(ctx));  // Visit children for locations, transitions, etc.
        

        // Loop through all the children of the template in the order they appear in the source
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof Uppaal2CParser.LocationContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the location
            } else if (ctx.getChild(i) instanceof Uppaal2CParser.TransitionContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the transition
            } else if (ctx.getChild(i) instanceof Uppaal2CParser.CommentContext) {
            	if (i!=1) // comment at 0 is captured above
                output.append(visit(ctx.getChild(i)));  // Visit the comment
            } else {
                // Handle other potential child types if needed
                output.append("");
            }
        }
       
        output.append("\n}\n");
        
        return output.toString();
    }

    @Override
    public String visitSystem(Uppaal2CParser.SystemContext ctx) {
        return "";// "system " + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitQueries(Uppaal2CParser.QueriesContext ctx) {
        /*StringBuilder output = new StringBuilder();
        for (Uppaal2CParser.QueryContext query : ctx.query()) {
            output.append(visit(query));
        }*/
        return "";//output.toString();
    }

    @Override
    public String visitDeclarationItem(Uppaal2CParser.DeclarationItemContext ctx) {
            if (ctx.declarationVar() != null) {
                return visitDeclarationVar(ctx.declarationVar());
            } else if (ctx.declarationFunc() != null) {
                return visitDeclarationFunc(ctx.declarationFunc());
            } else if (ctx.comment() != null) {
                return visitComment(ctx.comment());
            }
            return "";
     }


    @Override
    public String visitDeclarationVar(Uppaal2CParser.DeclarationVarContext ctx) { 
    	//declarationVar: DATATYPE ID (LBRACK INT RBRACK)? SEMICOLON; // Variable declaration
    	StringBuilder output = new StringBuilder();
    	String dataType="";
    	if (ctx.CONST()!=null) dataType=" const ";
    	dataType = dataType+visitDataType(ctx.DATATYPE().getText());
        //output.append(dataType).append(" ").append(ctx.ID(0).getText());
        
    	 output.append("extern "+dataType).append(" ").append(ctx.ID(0).getText());
        if (ctx.LBRACK() != null && ctx.ARRAY_SV()==null) {
             output.append(ctx.LBRACK().getText()+ctx.INT(0).getText()+ctx.RBRACK().getText());
         }
         
         if (ctx.LBRACK() != null &&  ctx.ARRAY_SV()!=null) {
             //result.append("[").append(ctx.INT(0).getText()).append("]");
         	int arraySize = (Integer.parseInt(ctx.INT(0).getText()) + 1);
         	output.append("[").append(arraySize).append("]");
         }
         
         if(ctx.ID(1)!=null)
        	 output.append("="+ctx.ID(1).getText());
         else if(ctx.INT(1)!=null)
        	 output.append("="+ctx.INT(1).getText());
         
        output.append(";\n");
        return output.toString();
    }

    @Override
    public String visitDeclarationFunc(Uppaal2CParser.DeclarationFuncContext ctx) {
    	
    	//declarationFunc: DATATYPE ID LPAREN RPAREN LBRACE RBRACE; // Function declaration
    	StringBuilder output = new StringBuilder();
    	
    	String parameters="";
    	if (ctx.parameterList() != null) {
    		parameters=visit(ctx.parameterList());
        }
    	
    	if(ctx.DATATYPE()!=null)
            output.append(ctx.DATATYPE().getText()).append(" ").append(ctx.ID().getText()).append("("+parameters+")");
        else if(ctx.VOID()!=null)
            output.append(ctx.VOID().getText()).append(" ").append(ctx.ID().getText()).append("("+parameters+")");
            
    	if(ctx.expression()!=null)
    		output.append("		"+ctx.expression().getText().replace("return", "return ")+";	\n");
    	else    		
            output.append(";\n");
    	
        return output.toString();
    }

    @Override
    public String visitLocation(Uppaal2CParser.LocationContext ctx) {//System.out.println("I am 8.1");
        return "";//"location ";// + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitTransition(Uppaal2CParser.TransitionContext ctx) { //System.out.println("I am in Transition");
        StringBuilder output = new StringBuilder();

        for (Uppaal2CParser.LabelContext label : ctx.label()) {    
            output.append(visit(label));
        }

        return output.toString();
    }

    @Override
    public String visitLabel(Uppaal2CParser.LabelContext ctx) {//System.out.println("I am in Label");
    	
    	StringBuilder output = new StringBuilder();
    	String expression = ctx.expression().getText();
    	//System.out.println(expression+"***"+ForLoopOpen);
    	if(ctx.STRING().getText().contains("guard"))//.equals("\"guard\""))
    	{
    		/*if(ctx.expression().getText().equals("else!=null"))
    			output.append("	else {\n");
    		else */
    		if(ctx.expression().getText().contains("switch"))
    		{
    			switchStatement=true;
    			output.append("switch(").append(expression.substring("switch==".length())).append(")\n {\n");
    			switchCondition=expression.substring("switch==".length())+"==";
    		}
    		else if(switchStatement && !expression.contains("def") && expression.contains(switchCondition))
    		{
    			if(ctx.expression().getText().contains(expression.substring("switch==".length())))//if contains switch condition(switch case preserved in uppaal in this way)
    			output.append(" case ").append(expression.substring(switchCondition.length())).append(":\n");
    		}
    		else if(ctx.expression().getText().contains("def==1"))
    			output.append(" default:   \n");
    		else if (ForLoopOpen)
    		{
            	output.append(expression.replace("&amp;&amp;", " && ").replace("&lt;", " < ").replace("&gt;", " >")).append(";");
            	LabelsCountInLoopTransition=LabelsCountInLoopTransition+1;
    			ForLoopOpen=false;
    		}
    		else
    		{
    			//closeIfAndElse = true;
    			if(ctx.expression().getText().length()>0)
    				output.append("	if (").append(ctx.expression().getText().replace("&amp;&amp;", " && ").replace("&lt;", " < ").replace("&gt;", " >")).append(") ");
    			//else
    				//output.append("	else  ");
    		}
    		GuardOn=true;
    	}
    	else if(ctx.STRING().getText().equals("\"assignment\""))
    	{
    		IfStatementsCount=0;
    		//moreThanOneStatements=false;
    		
    		if(ForLoopOpen)
            	output.append("	for(int");
    		
    		//onlyBreakWhenCaseEnds=false;
    		String input = ctx.expression().getText();
    		StringBuilder innerLoop_result = new StringBuilder();
    		StringBuilder result = new StringBuilder();
            StringBuilder currentSegment = new StringBuilder();
            int parenthesesDepth = 0;
            //System.out.println(input);
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
            //System.out.println("-"+innerLoop_result+"-"+currentSegment);
             }
            //System.out.println(IfStatementsCount);
            if((IfStatementsCount>0) && !ForLoopOpen)
            {
            	result.append("{\n");
            	moreThanOneStatements=true;
            }
            else if (!ForLoopOpen && LabelsCountInLoopTransition!=1)
            	result.append("\n");
            
            if(LabelsCountInLoopTransition!=1)
            {
            result.append("  "+innerLoop_result.toString()+currentSegment+";");
    		output.append("	"+result.toString().replace("return=", "return ").replace(";", ";\n  ").replaceAll("\"([a-zA-Z0-9.=])\"", "'$1'"));
            }
            else
            {
            	result.append("  "+innerLoop_result.toString()+currentSegment+"; )\n   {\n");
        		output.append("	"+result.toString().replace("return=", "return ").replaceAll("\"([a-zA-Z0-9.=])\"", "'$1'"));

            	LabelsCountInLoopTransition=0;
            }
    		
    		if(GuardOn)
    		{
    			//if (switchStatement)
    				//output.append(" break**********;\n");
    			//output.append("  }.......\n\n");
    			GuardOn=false;
    		}
    		if(moreThanOneStatements  && !ForLoopOpen)//closeIfAndElse)
    		{
    			output.append("   }\n");
    			moreThanOneStatements=false;
    			//closeIfAndElse=false;
    		} 
    		else  if (!ForLoopOpen && LabelsCountInLoopTransition!=1)
    			output.append("\n");
    		
    		if(ForLoopOpen)
            	output.deleteCharAt(output.length() - 3);     //making for loop in one line
    		
    		
    			
    	}//System.out.println(output.toString());
    	String newstr=output.toString().replace("-->", "-->\n\t");
    	newstr=newstr.replace("-->", "*/");
    	newstr=newstr.replace("<!--", "/*");
        return newstr;
    }

    @Override
    public String visitSource(Uppaal2CParser.SourceContext ctx) {
        return "";//ctx.STRING().getText(); // Return the source reference
    }

    @Override
    public String visitTarget(Uppaal2CParser.TargetContext ctx) {
        return "";//ctx.STRING().getText(); // Return the target reference
    }

    @Override
    public String visitQuery(Uppaal2CParser.QueryContext ctx) {
        return "";//query: " + visit(ctx.OPEN_FORMULA()) + ";\n"; // Adjust as needed for actual query handling
    }

    @Override
    public String visitComment(Uppaal2CParser.CommentContext ctx) {//System.out.println("I am COMMENT");
    
    String Uppaalcomment="";//ctx.UPPAAL_COMMENT_WITH_TEXT().getText();
    String getString = "";//Uppaalcomment.substring(4, Uppaalcomment.length() - 3);
    String returnComment="";
    
    if(ctx.UPPAAL_COMMENT_WITH_TEXT()!=null)
    {
    	Uppaalcomment=ctx.UPPAAL_COMMENT_WITH_TEXT().getText();
        getString = Uppaalcomment.substring(4, Uppaalcomment.length() - 3);
        if(getString.contains("Posting Declarations from all templates here:"))
        	returnComment="";
        else if(getString.contains("printf") || getString.contains("$display" ) )
        	returnComment= "	"+getString.replace("$display", "printf")+"\n";
        else returnComment="// "+getString+"\n";
    }
    
    else if (ctx.UPPAAL_COMMENT()!=null)
    {
    	Uppaalcomment=ctx.UPPAAL_COMMENT().getText(); 
    	//System.out.println(Uppaalcomment+"......");
        //getString = Uppaalcomment.substring(0, Uppaalcomment.length());
    	if(Uppaalcomment.contains("Posting Declarations from all templates here:"))
        	returnComment="";
    	else if(Uppaalcomment.contains("printf") || Uppaalcomment.contains("$display" ) )
        	returnComment= "	"+Uppaalcomment.replace("$display", "printf")+";\n";
        else if(Uppaalcomment.contains("#include"))
        	returnComment=Uppaalcomment.substring(2).replace("&lt;", "<").replace("&gt;", ">").replace("const int", "#define");
        else if(Uppaalcomment.contains("FOR_LOOP_OPEN"))
        	ForLoopOpen=true;//closing for loop
        else if(Uppaalcomment.contains("FOR_LOOP_CLOSE"))
        	returnComment="	}\n";//closing for loop  
        else if(Uppaalcomment.contains("SWITCH_STATEMENT_CLOSED"))
        	returnComment="    }\n";//closing for loop 
        else if(Uppaalcomment.contains("BREAK_STATEMENT"))
        	returnComment="";//"   break;\n";//closing for loop 
        else if(Uppaalcomment.contains("TEMPLATE_RETURN_TYPE"))
        	returnComment=Uppaalcomment.substring(23);//closing for loop 
        else if(Uppaalcomment.contains("ELSE"))
        	returnComment="	else ";//closing for loop 
        else
        	returnComment=" "+Uppaalcomment+"\n";
        
    }
    //if(getString.contains("printf") || getString.contains("$display" ) )
	//	return "	"+getString.replace("$display", "printf")+";\n";
    //else
	return returnComment;// "	// " + getString + "\n";
    
    //return "// " + Uppaalcomment + "\n";
    }
    
    @Override
    public String visitParameterList(Uppaal2CParser.ParameterListContext ctx) {
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
        	result.setLength(result.length() - 2); 
        }
        }
        return result.toString();
    }
    
    @Override
    public String visitTemplateParameter(Uppaal2CParser.TemplateParameterContext ctx) {
    	
    	// templateParameter : OPEN_PARAMETER (DATATYPE | VOID)? qualifier? pointer? ID? CLOSE_PARAMETER ;
        StringBuilder result = new StringBuilder();
         
        if (ctx.CONST(0)!= null) 
        	result.append(ctx.CONST(0).getText()+" ");
       
     
        if(ctx.DATATYPE(0)!=null) 
        	    result.append(visitDataType(ctx.DATATYPE(0).getText())+" ");
          else if(ctx.VOID(0)!=null) 
        	    result.append(ctx.VOID(0).getText()+" ");

          if (ctx.ID(0) != null) 
                	result.append(ctx.ID(0).getText()+" ");
                
            
        for (int i = 1; i <= ctx.COMMA().size(); i++) {
            // Add a comma after each parameter, except the last one
         //if (ctx.COMMA(i)!= null) 
            	result.append(", ");	
        	
         if (ctx.CONST(i)!= null) 
            	result.append(ctx.CONST(i).getText()+" ");
           
         if(ctx.DATATYPE(i)!=null) 
        	    result.append(visitDataType(ctx.DATATYPE(i).getText())+" ");
          else if(ctx.VOID()!=null) 
        	    result.append(ctx.VOID(i).getText()+" ");

          if (ctx.ID(i) != null) 
                	result.append(ctx.ID(i).getText()+" ");
        	
        	
           // if (i < ctx.COMMA().size() - 1) {
           // 	result.append(", ");
            //}
        
     // Check if the last character is a comma and remove it
        if (result.charAt(result.length() - 2) == ',') {
        	result.setLength(result.length() - 2); // Remove last ", "
        }
        }
        return result.toString();
    }
	   
	    public String visitDataType(String type) {
	        switch (type) {
	        case "int":
                return "int";
            case "longint":
                return "int";
            case "real":
                return "float";    
            case "logic":
            	return "int";
            case "byte":
            	return "char";	
            case "clock":
            	return "uint32_t";	
            default:
	            return type; // Default to int for unsupported types
	        }
	    } 


    // You can add more specific handling for other rules as needed    
  /*  public String getcCode() {
        
        return output.toString();
    }*/
}
