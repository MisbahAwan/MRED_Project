package Uppaal2SystemVerilogTransformations;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import C2SystemVerilogTransformations.C2SystemVerilogParser.DataTypeContext;
import C2SystemVerilogTransformations.C2SystemVerilogParser.ParameterListContext;

public class UppaalToSystemVerilogVisitor extends Uppaal2SystemVerilogBaseVisitor<String> {
    
	StringBuilder output;
	boolean GuardOn=false;
	boolean switchStatement=false;
    String switchCondition="";
	
	boolean ForLoopOpen=false;
	boolean closeIfAndElse=false;
	
	int IfStatementsCount=0; 
	boolean moreThanOneStatements=false;
	boolean caseBeginAndEndTag=false;
	
	int LabelsCountInLoopTransition=0;
	
    @Override
    public String visitFile(Uppaal2SystemVerilogParser.FileContext ctx) {//System.out.println("I am 1");
        output = new StringBuilder();
        output.append(visit(ctx.ntaSection()));
        String originalString = output.toString();
        //System.out.println(originalString);
        
        if(originalString.contains(": begin\n	begin\n")) // this is made because the when case immediately get statements>0 then it appends two begins and ends in cs2
        originalString = originalString.replaceAll(": begin\n	begin\n", ": begin\n").replaceAll("end\n   end\n", "end\n");
        
        return originalString;//output.toString();
    }

    @Override
    public String visitNtaSection(Uppaal2SystemVerilogParser.NtaSectionContext ctx) {//System.out.println("I am 2");
        StringBuilder output = new StringBuilder();
    	output.append("module VerilogSimulation;\n\n");
        for (Uppaal2SystemVerilogParser.NtaItemContext item : ctx.ntaItem()) {
            output.append(visit(item));
        }
    	output.append("\nendmodule");
        return output.toString();
    }

    @Override
    public String visitNtaItem(Uppaal2SystemVerilogParser.NtaItemContext ctx) {//System.out.println("I am 3");
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(Uppaal2SystemVerilogParser.DeclarationContext ctx) { //System.out.println("I am 4");
        StringBuilder output = new StringBuilder();
        for (Uppaal2SystemVerilogParser.DeclarationItemContext item : ctx.declarationItem()) {
            output.append(visit(item));
        }
        return output.toString();
    }

    @Override
    public String visitTemplate(Uppaal2SystemVerilogParser.TemplateContext ctx) {//System.out.println("I am 8");
        StringBuilder output = new StringBuilder();
        String parameters="";
        
        String returnType=null;
    	if(ctx.comment(0)!=null)
    		returnType=visitComment(ctx.comment(0)); 
    		//returnType=returnType.substring(0, returnType.length() - 7);
    	
    	if (ctx.templateParameter() != null) {
    		parameters=visit(ctx.templateParameter());
        }
        output.append("function "+returnType+" ").append(ctx.nameSection().ID().getText()).append("("+parameters+"); \n");
        
        //output.append(visitChildren(ctx));  // Visit children for locations, transitions, etc.
        
        // Loop through all the children of the template in the order they appear in the source
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof Uppaal2SystemVerilogParser.LocationContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the location
            } else if (ctx.getChild(i) instanceof Uppaal2SystemVerilogParser.TransitionContext) {
                output.append(visit(ctx.getChild(i)));  // Visit the transition
            } else if (ctx.getChild(i) instanceof Uppaal2SystemVerilogParser.CommentContext) {
            	if (i!=1) // comment at 0 is captured above
            	output.append(visit(ctx.getChild(i)));  // Visit the comment
            } else {
                // Handle other potential child types if needed
                output.append("");
            }
        }
        
        output.append("\nendfunction\n");
        return output.toString();
    }

    @Override
    public String visitSystem(Uppaal2SystemVerilogParser.SystemContext ctx) {
        return "";// "system " + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitQueries(Uppaal2SystemVerilogParser.QueriesContext ctx) {//System.out.println("I am 10");
        /*StringBuilder output = new StringBuilder();
        for (Uppaal2SystemVerilogParser.QueryContext query : ctx.query()) {
            output.append(visit(query));
        }*/
        return "";//output.toString();
    }

    @Override
    public String visitDeclarationItem(Uppaal2SystemVerilogParser.DeclarationItemContext ctx) {//System.out.println("I am 5");
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
    public String visitDeclarationVar(Uppaal2SystemVerilogParser.DeclarationVarContext ctx) { //System.out.println("I am 6");
    	//declarationVar: DATATYPE ID (LBRACK INT RBRACK)? SEMICOLON; // Variable declaration
    	
    	StringBuilder output = new StringBuilder();
    	String dataType="";
    	if (ctx.CONST()!=null) dataType=" const ";
    	dataType = dataType+visitDataType(ctx.DATATYPE().getText());
        output.append(dataType).append(" ").append(ctx.ID(0).getText());
        if (ctx.LBRACK() != null && ctx.ARRAY_SV()!=null) {
            output.append(ctx.LBRACK().getText()+ctx.INT(0).getText()+ctx.ARRAY_SV().getText()+ctx.RBRACK().getText());
        }
        
        if (ctx.LBRACK() != null &&  ctx.ARRAY_SV()==null) {
            //result.append("[").append(ctx.INT(0).getText()).append("]");
        	int arraySize = (Integer.parseInt(ctx.INT(0).getText()) - 1);
        	output.append("[").append(arraySize).append(":0]");
        }
        
        if(ctx.initValue!=null)
       	 output.append("="+ctx.initValue.getText());
       // else if(ctx.INT(1)!=null)
       // 	 output.append("="+ctx.INT(1).getText());
       //result.append(";\n");
        
        
        output.append(";\n");
        return output.toString();
    }

    @Override
    public String visitDeclarationFunc(Uppaal2SystemVerilogParser.DeclarationFuncContext ctx) {//System.out.println("I am 7");
    	
    	//declarationFunc: DATATYPE ID LPAREN RPAREN LBRACE RBRACE; // Function declaration
    	StringBuilder output = new StringBuilder();
    	String parameters="";
    	if (ctx.parameterList() != null) {
    		parameters=visit(ctx.parameterList());
        }
    	
        
        output.append("function ");
        if(ctx.DATATYPE()!=null)
        	output.append(visitDataType(ctx.DATATYPE().getText())).append(" ").append(ctx.ID().getText()).append("("+parameters+")");
        else if(ctx.VOID()!=null)
            output.append(ctx.VOID().getText()).append(" ").append(ctx.ID().getText()).append("("+parameters+")");
        
        if(ctx.expression()!=null)
    		output.append("{"+ctx.expression().getText().replace("return", "return ")+";}\n");
    	else    		
            output.append(";\n");
        
        output.append("");
        output.append("endfunction\n");
        return output.toString();
    }

    @Override
    public String visitLocation(Uppaal2SystemVerilogParser.LocationContext ctx) {//System.out.println("I am 8.1");
        return "";//"location ";// + ctx.ID().getText() + ";\n";
    }

    @Override
    public String visitTransition(Uppaal2SystemVerilogParser.TransitionContext ctx) {//System.out.println("I am 8.2");
        StringBuilder output = new StringBuilder();
        //output.append("transition ");
        //output.append(visit(ctx.source()));
        //output.append(" -> ");
        //output.append(visit(ctx.target()));
        //output.append(";\n");
        
        //StringBuilder output = new StringBuilder();
        for (Uppaal2SystemVerilogParser.LabelContext label : ctx.label()) {
        	
            output.append(visit(label));
        }
        //return output.toString();
        
        return output.toString();
    }

    @Override
    public String visitLabel(Uppaal2SystemVerilogParser.LabelContext ctx) {
    	
    	StringBuilder output = new StringBuilder();
    	String expression = ctx.expression().getText();
    	
    	if(ctx.STRING().getText().contains("guard"))//.equals("\"guard\""))
    	{
    		/*if(ctx.expression().getText().equals("else!=null"))
    			output.append("	else begin\n");
    		else*/ 
    		if(ctx.expression().getText().contains("switch"))
    		{
    			switchStatement=true;
    			output.append("case(").append(expression.substring("switch==".length())).append(")\n ");
    			switchCondition=expression.substring("switch==".length())+"==";
    		}
    		/*else if(ctx.expression().getText().contains("case"))
    			output.append(" case ").append(expression.substring("case".length())).append(":\n   begin\n");
    		else if(ctx.expression().getText().contains("default"))
    			output.append(expression).append(":\n   begin		break; end\n");*/
    		else if(switchStatement && !expression.contains("def") && expression.contains(switchCondition))
    		{
    			if(ctx.expression().getText().contains(expression.substring("switch==".length())))//if contains switch condition(switch case preserved in uppaal in this way)
    			output.append(expression.substring(switchCondition.length())).append(": begin\n");
    			caseBeginAndEndTag=true;
    		}
    		else if(ctx.expression().getText().contains("def==1"))
    			output.append(" default:   begin\n");
    		else if (ForLoopOpen)
    		{
    			output.append(expression.replace("&amp;&amp;", " && ").replace("&lt;", " < ").replace("&gt;", " >")).append(";");
            	LabelsCountInLoopTransition=LabelsCountInLoopTransition+1;
    			ForLoopOpen=false;
    			
    			//output.append("	for (");//++"  {\n");
    			//output.deleteCharAt(output.length() - 1); 
            	//output.append(expression.replace("&amp;&amp;", " && ").replace("&lt;", " < ").replace("&gt;", " >")).append(";");
            	//output.append(expression.charAt(0)+"++;) {\n");
            	//output.append(") begin\n");
    			//ForLoopOpen=false;
    		}
    		else
    		{
    			//closeIfAndElse = true;
    			if(ctx.expression().getText().length()>0)
    				output.append("	if (").append(ctx.expression().getText().replace("&amp;&amp;", " && ").replace("&lt;", " < ").replace("&gt;", " >")).append(") ");
    			//else
    				//output.append("	else ");
    		}
    		//output.append("	if (").append(ctx.expression().getText()).append(") begin\n");
    		
    		GuardOn=true;
    	}
    	else if(ctx.STRING().getText().equals("\"assignment\""))
    	{
    		IfStatementsCount=0;
    		//moreThanOneStatements=false;
    		
    		if(ForLoopOpen)
            	output.append("	for(int ");
    		
    		String input = ctx.expression().getText();
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
            
           // if(IfStatementsCount>0)
            //	caseBeginAndEndTag=false;
            
            if((IfStatementsCount>0) && !ForLoopOpen)// && (caseBeginAndEndTag==false))
            {
            	result.append("begin\n");
            	moreThanOneStatements=true;
            }
            else if(!ForLoopOpen && LabelsCountInLoopTransition!=1)
            	result.append("\n");
            
            result.append("  "+innerLoop_result.toString());
            
            if(LabelsCountInLoopTransition!=1)
            {
            	result.append(currentSegment.toString().trim()).append(";");
        		output.append("	"+result.toString().replace("return=", "return ").replace(";", ";\n  "));//.replace("'", "\"").replaceAll("\"([a-zA-Z0-9.=])\"", "'$1'"));
            }
            else
            {
            	result.append("  "+innerLoop_result.toString()+currentSegment+"; )\n   begin\n");
        		output.append("	"+result.toString().replace("return=", "return "));//.replaceAll("\"([a-zA-Z0-9.=])\"", "'$1'"));

            	LabelsCountInLoopTransition=0;
            }
            
            

    		if(GuardOn)
    		{
    			//if (switchStatement)
    				//output.append(" break;\n");
    			//output.append("  end\n\n");
    			GuardOn=false;
    		}
    		
    		if(moreThanOneStatements  && !ForLoopOpen) // && caseBeginAndEndTag==false )//closeIfAndElse)
    		{
    			output.append("   end\n");
    			moreThanOneStatements=false;
    			//closeIfAndElse=false;
    		} 
    		else if(!ForLoopOpen  && LabelsCountInLoopTransition!=1)
    			output.append("\n");
    		
    		if(ForLoopOpen)
            	output.deleteCharAt(output.length() - 3);     //making for loop in one line
    	
    	}//System.out.println(output.toString());
    	
    	String newstr=output.toString().replace("-->", "-->\n\t");
    	newstr=newstr.replace("-->", "*/");
    	newstr=newstr.replace("<!--", "/*");
        return newstr;
    	
        //return output.toString().replace("-->", "-->\n\t");// + ctx.TEXT().getText() + ";\n";
    }

    @Override
    public String visitSource(Uppaal2SystemVerilogParser.SourceContext ctx) {
        return "";//ctx.STRING().getText(); // Return the source reference
    }

    @Override
    public String visitTarget(Uppaal2SystemVerilogParser.TargetContext ctx) {
        return "";//ctx.STRING().getText(); // Return the target reference
    }

    @Override
    public String visitQuery(Uppaal2SystemVerilogParser.QueryContext ctx) {
        return "";//query: " + visit(ctx.OPEN_FORMULA()) + ";\n"; // Adjust as needed for actual query handling
    }

    @Override
    public String visitComment(Uppaal2SystemVerilogParser.CommentContext ctx) {//System.out.println("I am COMMENT");
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
            	returnComment= "	"+getString.replace( "printf", "$display")+"\n";
            else returnComment="// "+getString+"\n";
        }
        
        else if (ctx.UPPAAL_COMMENT()!=null)
        {
        	Uppaalcomment=ctx.UPPAAL_COMMENT().getText(); 
        	
        	if(Uppaalcomment.contains("Posting Declarations from all templates here:"))
            	returnComment="";
        	else if(Uppaalcomment.contains("printf") || Uppaalcomment.contains("$display" ) )
            	returnComment= "	"+Uppaalcomment.replace("printf","$display")+";\n";
            else if(Uppaalcomment.contains("#include"))
            	returnComment=Uppaalcomment+"\n";//.substring(2).replace("&lt;", "<").replace("&gt;", ">").replace("const int", "#define");
            else if(Uppaalcomment.contains("FOR_LOOP_OPEN"))
            	ForLoopOpen=true;//closing for loop
            else if(Uppaalcomment.contains("FOR_LOOP_CLOSE"))
            	returnComment="	end\n";//closing for loop  
            else if(Uppaalcomment.contains("SWITCH_STATEMENT_CLOSED"))
            	returnComment="  endcase\n";//closing for loop 
            else if(Uppaalcomment.contains("BREAK_STATEMENT"))
            	returnComment="   end\n";//closing for loop 
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
    public String visitParameterList(Uppaal2SystemVerilogParser.ParameterListContext ctx) {
        StringBuilder result = new StringBuilder();
        /*for (int i = 0; i < ctx.parameter().size(); i++) {
            result.append(visit(ctx.parameter(i)));
            if (i < ctx.parameter().size() - 1) {
                //result.append(", ");
                result.append(" ");
            }*/
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
    public String visitTemplateParameter(Uppaal2SystemVerilogParser.TemplateParameterContext ctx) {
    	
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
	                return type;//"int"; // Default to int for unsupported types
	        }
	    } 
    // You can add more specific handling for other rules as needed    
   /* public String getcCode() {
        
        return output.toString();
    }*/
}
