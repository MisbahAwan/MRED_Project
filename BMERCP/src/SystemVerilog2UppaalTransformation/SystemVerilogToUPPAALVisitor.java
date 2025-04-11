package SystemVerilog2UppaalTransformation;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import C2UppaalTransformations.C2UppaalParser;
import SystemVerilog2CTransformation.SystemVerilog2CParser;
import SystemVerilog2CTransformation.SystemVerilog2CParser.ParameterContext;

//import SVC2UppaalTransformations.CParser;

import java.io.*;

public class SystemVerilogToUPPAALVisitor extends SystemVerilog2UppaalBaseVisitor<Void> {

    private StringBuilder outputBuilder;

    boolean OneTimeDeclarationOpen=true;
    boolean OneTimeDeclarationClose=true;
    SystemVerilog2UppaalParser.ModuleDeclContext ctxNew;
    boolean runAllCodeTwice= true; // this will run visitModuleDecl twice. one time it will get total count of locations and 2nd time remove all code and generate code based on locations count.
    boolean cameFromIfStatement=false;
    boolean makeCloseTransitionTag=true;
    boolean nestedIfModeOn=false;
    
    boolean cameFromCaseStatement=false; 
    boolean cameFromForLoop=false;
    boolean cameFromDeclaration=false;
    
    int locationIdCounterSource=0;
    int locationIdCounterTarget=1;
    
    String lastStatement=null; // this is to increment location when last location is not if
    
    String switchCondition="";
    
    String idSource="id0";
    String idTarget="id0";
    
    boolean elseModeStringAppend=false;
    String elseString="";
    
    String systemDeclarations=null;
    
    // Declare an array for location
    String[] locations;// = new String[50];
    int totalLocations=0;
    int totalLocationsSum=0;
    
    int[] TemplatesWiseLocationsCount = new int[4];
    int totalTemplatesCount=0;
    int totalTemplatesCountPrint=0;
    boolean countTemplates=true;
    
    String[] ifTransitions;// = new String[100];
    int ifTransitionsCount=-1;
    
    String[] Declarations = new String[100];
    int countDeclarations=-1;

    public SystemVerilogToUPPAALVisitor() {
    	
    }

    @Override
    public Void visitModuleDecl(SystemVerilog2UppaalParser.ModuleDeclContext ctx) {
    	
       // String moduleName = ctx.ID().getText();
        OneTimeDeclarationOpen=true;
        OneTimeDeclarationClose=true;
        
        elseModeStringAppend=false;
        elseString="";
        
      //String idSourceforIfTransition="";
        ifTransitions = new String[10];
        ifTransitionsCount=-1;
        
        totalTemplatesCountPrint=0;
        
        systemDeclarations="system ";
        
    	// below copied from constructor
	    	outputBuilder = new StringBuilder();
	        outputBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
	        outputBuilder.append("<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'flat-1_2.dtd'>\n");
	        outputBuilder.append("<nta>\n");
	        
	        if(OneTimeDeclarationOpen) {outputBuilder.append("   <declaration>\n");OneTimeDeclarationOpen=false; cameFromDeclaration=true;}

	        
	        locationIdCounterSource = 0;
	        locationIdCounterTarget = 1;
	        idSource="id0";
	        idTarget="id0";
	
	        // Defining Locations
	        locations= new String[totalLocationsSum];
	        int j=10;
	        for (int i = 0; i < locations.length; i++) {
	            locations[i]="<location id=\"id"+i+"\" x=\""+(i+10)*150+"\" y=\""+j+"\">\n"+"      <name>Loc"+i+"</name>\n"+"      </location>";
	            if (i % 2 == 0)
	            	j=250;
	            else
	            	j=10;
	        }
	        ctxNew=ctx;
        //above copied from constructor
        
        //outputBuilder.append("<template>\n");
        //outputBuilder.append("<name>").append(moduleName).append("</name>\n");
        // Visit module items (declarations, functions, statements, initial block)
        for (SystemVerilog2UppaalParser.ModuleItemContext itemCtx : ctx.moduleItem()) {
            visitModuleItem(itemCtx);
        }

        return null;
    }
    
	
    @Override
    public Void visitEnumDecl(SystemVerilog2UppaalParser.EnumDeclContext ctx) {
        
       
        visitEnumList(ctx.enumList());
        
        
        return null;
    }

    @Override
    public Void visitEnumList(SystemVerilog2UppaalParser.EnumListContext ctx) {
    	int a=0;
        StringBuilder enums = new StringBuilder();
        for (TerminalNode id : ctx.ID()) {
            enums.append(" 	const int "+id.getText()).append(" = "+a+";\n ");
            a=a+1;
        }
        
        outputBuilder.append( enums.toString());
        return null;
    }

    @Override
    public Void visitDeclaration(SystemVerilog2UppaalParser.DeclarationContext ctx) {
        //String dataType = ctx.dataType().getText();
        String variableName = ctx.ID().getText();
        String initialValue = "";
        //if(OneTimeDeclarationOpen) {outputBuilder.append("   <declaration>\n");OneTimeDeclarationOpen=false;}
        // Handle arrays if present
        if (ctx.LBRACK() != null) { 
            int arraySize = Integer.parseInt(ctx.INT(0).getText()); // Assuming only single dimension arrays
            if(ctx.EQUAL()!=null)
            {
            	initialValue="="+ctx.primary().getText();
            }
            //outputBuilder.append("<declaration>\n");
              if (lastStatement!="declaration") 
                outputBuilder.append("      "+"int").append(" ").append(variableName).append("[").append(arraySize).append("]"+initialValue+";\n");
              else
            	 Declarations[++countDeclarations]="		int "+variableName+arraySize+initialValue+";";
                //outputBuilder.append("         <declaration>"+"int").append(" ").append(variableName).append("[").append(arraySize).append("]"+initialValue+";   </declaration>\n");
                //outputBuilder.append("      "+dataType).append(" ").append(variableName).append("[").append(arraySize).append("];\n");            
                //outputBuilder.append("</declaration>\n");
            } else {
                //outputBuilder.append("<declaration>\n");
            	if(ctx.EQUAL()!=null)
                {
                	initialValue="="+ctx.primary().getText();
                }
            	if (lastStatement!="declaration")
                    outputBuilder.append("      "+"int").append(" ").append(variableName).append(initialValue+";\n");
            	else
            		Declarations[++countDeclarations]="		int "+variableName+initialValue+";";
            	//outputBuilder.append("      <declaration>"+"int").append(" ").append(variableName).append(initialValue+";   </declaration>\n");	
                //outputBuilder.append("      "+dataType).append(" ").append(variableName).append(";\n");            
            //outputBuilder.append("</declaration>\n");
        }
        return null;
    }

    @Override
    public Void visitFunctionDecl(SystemVerilog2UppaalParser.FunctionDeclContext ctx) {
    	
    	if(ctx.statement(0) == null)
    	{
    		outputBuilder.append("      void "+ctx.ID().getText()+" "+ctx.LPAREN().getText()+ctx.RPAREN().getText()+"{}\n");
    	}
    	else
		    	{
		        if(OneTimeDeclarationClose) 
		        {
		        	outputBuilder.append("\n\n// Posting Declarations from all templates here:\n\n");
			        for (int i = 0; i < Declarations.length; i++)
			        	if(Declarations[i]!=null)
			        	outputBuilder.append("   "+Declarations[i]+"\n");
			        
		        	outputBuilder.append("   </declaration>\n");
		        	OneTimeDeclarationClose=false;
		        	 cameFromDeclaration=false;
		        }
		
		        //String returnType = ctx.returnType().getText();
		        String functionName = ctx.ID().getText();
		        
		        systemDeclarations = systemDeclarations+functionName+',';
		        
		        outputBuilder.append("   <template>\n");
		        outputBuilder.append("//TEMPLATE_RETURN_TYPE:"+ctx.returnType().getText()+"\n");
		        outputBuilder.append("    <name>").append(functionName).append("</name>\n");
		        outputBuilder.append("      <parameter>");
		        
		        // Visit parameter list if present
		        if (ctx.parameterList() != null) {
		            visitParameterList(ctx.parameterList());
		        }
		        outputBuilder.append("</parameter>\n");
		        
		        if (ctx.statement(0)!=null)
		        {	
			       /* for (int i = 0; i < locations.length; i++) {
			        	outputBuilder.append("  "+ locations[i]+"\n");
			        }*/
			        for (int i = 0; i < TemplatesWiseLocationsCount[totalTemplatesCountPrint]; i++) {
			        	outputBuilder.append("      "+ locations[i]+"\n");
			        }
			        
			        outputBuilder.append("    <init ref=\"id0\"/>\n");
		        }
		        else
		        {
		        	outputBuilder.append("	  <location id=\"id0\" x=\"50\" y=\"50\"> </location>\n");
		        	outputBuilder.append("      <init ref=\"id0\"/>\n");
		        	outputBuilder.append("		<transition>\n");
		        	outputBuilder.append("			<source ref=\"id0\"/>\n");
		        	outputBuilder.append("			<target ref=\"id0\"/>\n");
		        	outputBuilder.append("		</transition>\n");
		        }	
		        idSource="id0";
		        idTarget="id0";
		        
		        locationIdCounterSource = 0;
		        locationIdCounterTarget = 1;
		        
		       /* // Visit parameter list if present
		        if (ctx.parameterList() != null) {
		            visitParameterList(ctx.parameterList());
		        }*/
		        // Visit function statements
		        for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) {
		            visitStatement(stmtCtx);
		        }
		        outputBuilder.append("   </template>\n");
		        
		        if (countTemplates)
		        {
		        	TemplatesWiseLocationsCount[totalTemplatesCount]=locationIdCounterTarget;
		        	totalTemplatesCount=totalTemplatesCount+1;
		        }
		        totalTemplatesCountPrint=totalTemplatesCountPrint+1;
		        
		  }
		  return null;
    }

    @Override
    public Void visitStatement(SystemVerilog2UppaalParser.StatementContext ctx) {
    	
    	//if ( (lastStatement != "if") && (ctx.assignment() != null || ctx.ifStatement() != null || ctx.functionCall() != null) && (cameFromIfStatement==false || ( cameFromIfStatement==true && ctx.ifStatement() != null)))
    	if (/* (nestedIfModeOn == false) &&*/ (ctx.assignment() != null || ctx.ifStatement() != null || ctx.functionCall() != null) )          
    	   idSource = idTarget;//"id" + locationIdCounterSource++;
    	//else 
    		
    		
    	if (ctx.assignment() != null) {
            visitAssignment(ctx.assignment());
            lastStatement = "assignment";
            outputBuilder.append("\n");
        } else if (ctx.ifStatement() != null) {
        	//outputBuilder.append("    <transition>\n");
        	if (cameFromIfStatement) 
        		{
        		outputBuilder.append("    </transition>\n"); // close transition as its nested if
        		nestedIfModeOn=true;
        		}
        	else if(cameFromCaseStatement)
        	{

        		String checkLabel=outputBuilder.toString();
	            checkLabel=checkLabel.trim();
	            if(!checkLabel.endsWith("</transition>"))
	            
	            //if (!(outputBuilder.toString().endsWith("</transition> \n")))             	
        		outputBuilder.append("    </transition>\n"); // close transition as its nested if
        		else
             		 outputBuilder.append("\n");
        	}
            visitIfStatement(ctx.ifStatement());
            cameFromIfStatement=false;
            lastStatement = "if";
            
          //making extra if transition
            //outputBuilder.append("    <transition>\n");

            //outputBuilder.append("    </transition>\n");
        } else if (ctx.loopStatement() != null) {
            visitLoopStatement(ctx.loopStatement());
            lastStatement = "loop";
        } else if (ctx.comment() != null) {
            visitComment(ctx.comment());
            lastStatement="comment";
        } else if (ctx.functionCall() != null) {
            visitFunctionCall(ctx.functionCall());
            lastStatement="functionCall";
        } else if (ctx.switchStatement() != null) {
            visitSwitchStatement(ctx.switchStatement());
            lastStatement="switch";
        } else if (ctx.loopStatement() != null) {
            visitLoopStatement(ctx.loopStatement());
            lastStatement="loop";
        } else if (ctx.returnStatement() != null) {
            visitReturnStatement(ctx.returnStatement());
            lastStatement="returnStatement";
        } else if (ctx.declaration() != null) {
        	lastStatement="declaration";
            visitDeclaration(ctx.declaration());
            
        } else if (ctx.displayStatement() != null) {
        	visitDisplayStatement(ctx.displayStatement());
            lastStatement="print";
        } 
        return null;
    }
    
    @Override
    public Void visitReturnStatement(SystemVerilog2UppaalParser.ReturnStatementContext ctx) {
    	
    	idTarget = "id" + locationIdCounterTarget++;
    	
        if (ctx.expression() != null) {
            // If there's an expression in the return statement, visit it
            //Object expressionValue = visit(ctx.expression());
            
            outputBuilder.append("    <transition>\n");
	        outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
	        outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	        outputBuilder.append("        <label kind=\"assignment\">");
	        outputBuilder.append("return=");
	        //outputBuilder.append(" = ");
	        visit(ctx.expression());
	        outputBuilder.append("</label>\n");
	        outputBuilder.append("    </transition>\n");
            
            
           // System.out.println("Returning with expression: " + expressionValue);
            //return expressionValue;
        }
        return null;
        
    }
    
    @Override
    public Void visitStatementTwo(SystemVerilog2UppaalParser.StatementTwoContext ctx) {
    	
    	if (/* (nestedIfModeOn == false) &&*/ (ctx.assignment() != null || ctx.ifStatement() != null || ctx.functionCall() != null) )
            idSource = idTarget;//"id" + locationIdCounterSource++;
    	//else 
    		//locationIdCounterSource = locationIdCounterSource+1;
    		
    	if (ctx.assignment() != null) {
            visitAssignment(ctx.assignment());
            lastStatement = "assignment";
            outputBuilder.append("\n");
        } else if (ctx.ifStatement() != null) {
        	//outputBuilder.append("    <transition>\n");
        	if (cameFromIfStatement) 
        		{
        		outputBuilder.append("    </transition>\n"); // close transition as its nested if
        		nestedIfModeOn=true;
        		}
        	else if(cameFromCaseStatement)
        	{
        		String checkLabel=outputBuilder.toString();
	            checkLabel=checkLabel.trim();
	            if(!checkLabel.endsWith("</transition>"))
	            
	            //if (!(outputBuilder.toString().endsWith("</transition> \n")))             	
        		outputBuilder.append("    </transition>\n"); // close transition as its nested if
        		else
             		 outputBuilder.append("\n");
        	}
            visitIfStatement(ctx.ifStatement());
            cameFromIfStatement=false;
            lastStatement = "if";
            
          //making extra if transition

          
            //outputBuilder.append("    </transition>\n");
        } else if (ctx.loopStatement() != null) {
            visitLoopStatement(ctx.loopStatement());
            lastStatement = "loop";
        } else if (ctx.comment() != null) {
            visitComment(ctx.comment());
            lastStatement="comment";
        } else if (ctx.functionCall() != null) {
            visitFunctionCall(ctx.functionCall());
            lastStatement="functionCall";
        } else if (ctx.switchStatement() != null) {
            visitSwitchStatement(ctx.switchStatement());
            lastStatement="switch";
        } else if (ctx.loopStatement() != null) {
            visitLoopStatement(ctx.loopStatement());
            lastStatement="loop";
        } else if (ctx.declaration() != null) {
        	lastStatement="declaration";
            visitDeclaration(ctx.declaration());
            
        } else if (ctx.displayStatement() != null) {
        	visitDisplayStatement(ctx.displayStatement());
            lastStatement="print";
        } else if (ctx.returnStatement() != null) {
            visitReturnStatement(ctx.returnStatement());
            lastStatement="returnStatement";
        } 
        return null;
    }

    @Override
    public Void visitIfStatement(SystemVerilog2UppaalParser.IfStatementContext ctx) {

        String guard = ctx.expression().getText().replace("<", " &lt;").replace(">", " &gt;").replace("&&", " &amp;&amp; ");
        cameFromIfStatement=true;
        //idSource = "id" + locationIdCounterSource++;
        idTarget = "id" + locationIdCounterTarget++;
        
        //if (!nestedIfModeOn || ctx.ELSE()!=null)
        {
          //creating an additional transition when if ends
          ifTransitionsCount=ifTransitionsCount+1;
          ifTransitions[ifTransitionsCount]=idSource;
        }
        
        // Create transition
        outputBuilder.append("    <transition>\n");
        outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
        outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
        outputBuilder.append("        <label kind=\"guard\">").append(guard).append("</label>\n");
           
        // Visit if body
        boolean switchAssignmentTag=true;
        int statementsSize=ctx.statement().size();
        int countIterationForEndLabelTag=0;
        for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) {
        	
        	countIterationForEndLabelTag=countIterationForEndLabelTag+1;
        	//System.out.println(ctx.statement().size()+" ... "+countIterationForEndLabelTag);

        	if((stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
        	{
        		outputBuilder.append("        <label kind=\"assignment\">");
        		switchAssignmentTag=false;
        	}
        	if (stmtCtx.ifStatement()!=null)
        	{
        		outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
        		outputBuilder.deleteCharAt(outputBuilder.length() - 1);
            	outputBuilder.append("</label>\n");
        	}
        	
        	if(stmtCtx.displayStatement()==null && stmtCtx.comment()==null)
            visitStatement(stmtCtx);
            //System.out.println("NOW I WILL CHECK EXIT LABEL ");
            if(statementsSize==countIterationForEndLabelTag && stmtCtx.ifStatement()==null )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
        	{//System.out.println(" I am inside exit label ");
            	// Trim trailing whitespace
            	/*while (outputBuilder.length() > 0 && Character.isWhitespace(outputBuilder.charAt(outputBuilder.length() - 1))) {
            		outputBuilder.deleteCharAt(outputBuilder.length() - 1);  // Remove last character if it's whitespace
            	}*/
            	String checkLabel=outputBuilder.toString();
	            checkLabel=checkLabel.trim();
	            if(!checkLabel.endsWith("</label>"))
	            	
            	//if (!(outputBuilder.toString().endsWith("</label>")))
            	{
	            	outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
	            	outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
	            	outputBuilder.append("\n		</label>");
            	}
        	} 
        }
        
        if (!nestedIfModeOn || ctx.ELSE()!=null)
        {
    		outputBuilder.append("    </transition> \n");
      
	  		if(elseModeStringAppend)
	  		{
	  			outputBuilder.append(elseString);
	  			elseModeStringAppend=false;
	  		}
	          
     
    } 
        
        if (ctx.ELSE() != null) {
        	outputBuilder.append("//ELSE\n");
        	if(ctx.ifStatement()!=null)
        	{
        		
        		visitIfStatement(ctx.ifStatement());	
        	}
        	else 
        	{ 
        	
        	idTarget = "id" + locationIdCounterTarget++;
        	boolean declareAssignmentOnce=true;
        	
        	outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            outputBuilder.append("        <label kind=\"guard\">").append("</label>\n");
            
            for (SystemVerilog2UppaalParser.StatementTwoContext stmtCtx : ctx.statementTwo()) 
            {
            
            boolean switchAssignmentTagstatementTwo=true;
            int countIterationForEndLabelTagstatementTwo=0;
        	countIterationForEndLabelTagstatementTwo=countIterationForEndLabelTagstatementTwo+1;

            //for (SystemVerilog2UppaalParser.StatementTwoContext stmtCtx : ctx.statementTwo()) {
            	
            	//countIterationForEndLabelTagstatementTwo=countIterationForEndLabelTagstatementTwo+1;
            	//System.out.println(ctx.statementTwo().size()+" ... "+countIterationForEndLabelTagstatementTwo);
        	if((stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTagstatementTwo) && (declareAssignmentOnce))
            	{
            		outputBuilder.append("        <label kind=\"assignment\">");
            		switchAssignmentTagstatementTwo=false;
            		declareAssignmentOnce=false;
            	}
            	
            	if (stmtCtx.ifStatement()!=null)
            	{
            		outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
            		outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                	outputBuilder.append("</label> \n");
            	}
            	cameFromIfStatement=true;
            	visitStatementTwo(stmtCtx);
                
                if(ctx.statementTwo().size()==countIterationForEndLabelTagstatementTwo && stmtCtx.ifStatement()==null)// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
            	{
                	// Trim trailing whitespace
                	/*while (outputBuilder.length() > 0 && Character.isWhitespace(outputBuilder.charAt(outputBuilder.length() - 1))) {
                		outputBuilder.deleteCharAt(outputBuilder.length() - 1);  // Remove last character if it's whitespace
                	}*/
                	
                	//outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                	outputBuilder.deleteCharAt(outputBuilder.length() - 2); 
                	outputBuilder.append("</label> \n");
                	outputBuilder.append("    </transition> \n");
            	}
            }
        	}
            //outputBuilder.append("    </transition>\n");
           /* elseString="    <transition> \n";
            elseString=elseString+"        <source ref=\""+ifTransitions[ifTransitionsCount]+"\"/>\n";
            elseString=elseString+"        <target ref=\""+idSource+"\"/>\n";
            elseString=elseString+"    </transition>\n";  
            ifTransitionsCount=ifTransitionsCount-1;*/
            elseModeStringAppend=true;
        }
        nestedIfModeOn=false;
        
        ifTransitionsCount=ifTransitionsCount-1;
        return null;
    }
    @Override
    public Void visitFunctionCall(SystemVerilog2UppaalParser.FunctionCallContext ctx) {
    	
        String funcAsAssign = "		"+ctx.ID().getText()+"(";
        
        //functionCall: ID LPAREN (argumentList)? RPAREN ;
        if(cameFromIfStatement || cameFromCaseStatement)
        {
        	
        	//outputBuilder.append("        <label kind=\"assignment\">").append(funcAsAssign);
        	outputBuilder.append(funcAsAssign);
        
	        // Visit and concatenate  parameter list if present
	        if (ctx.argumentList() != null) {
	            visitArgumentList(ctx.argumentList());
	        }
	        outputBuilder.append("), ");
	        
	        //outputBuilder.append("</label>\n");
        }
        else
        {
        	//idSource = "id" + locationIdCounterSource++;
            idTarget = "id" + locationIdCounterTarget++;
            
            outputBuilder.append("    <transition>\n");
	        outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
	        outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	        outputBuilder.append("        <label kind=\"assignment\">").append(funcAsAssign);
	        
	        // Visit and concatenate  parameter list if present
	        if (ctx.argumentList() != null) {
	            visitArgumentList(ctx.argumentList());
	        }
	        outputBuilder.append(")");
	        outputBuilder.append("</label>\n");
	        outputBuilder.append("    </transition>\n");
        }
		return null;
    }
    
    @Override
    public Void visitAssignment(SystemVerilog2UppaalParser.AssignmentContext ctx) {
         String assignment = "		"+ctx.indexedID().getText();
        
        if(ctx.expression()!=null)
          assignment = assignment+" = "+ctx.expression().getText().replace("16'h0001", "1").replace("'", "\"");
        else
        {
        	assignment = assignment+ctx.assignmentType().getText();//"++";
            if(ctx.ID()!=null)
          	  assignment = assignment+ctx.ID().getText();
            else if(ctx.INT()!=null)
          	  assignment = assignment+ctx.INT().getText();
        }
         // assignment = assignment+"++";	
        //assignment: indexedID ((EQUAL expression) | ('++') | ('--')) ;
        if(cameFromIfStatement || cameFromCaseStatement)
        {
        	//outputBuilder.append("        <label kind=\"assignment\">").append(assignment).append("</label>\n");
            outputBuilder.append(assignment+","); 
        }
        else
        {
        	//idSource = "id" + locationIdCounterSource++;
            idTarget = "id" + locationIdCounterTarget++;
            
            outputBuilder.append("    <transition>\n");
	        outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
	        outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	        outputBuilder.append("        <label kind=\"assignment\">").append(assignment).append("</label>\n");
	        outputBuilder.append("    </transition>\n");
        }
        return null;
    }
    
        @Override
        public Void visitArgumentList(SystemVerilog2UppaalParser.ArgumentListContext ctx) {
           for (int i = 0; i < ctx.argument().size(); i++) {
                visit(ctx.argument(i));
                if (i < ctx.argument().size() - 1) {
                    outputBuilder.append(", ");
                }
            }
            return null;
        }

        @Override
        public Void visitArgument(SystemVerilog2UppaalParser.ArgumentContext ctx) {
            if (ctx.expression() != null) {
                visit(ctx.expression());
            } else if (ctx.transformedArgument() != null) {
                visit(ctx.transformedArgument());
            }
            return null;
        }

        @Override
        public Void visitTransformedArgument(SystemVerilog2UppaalParser.TransformedArgumentContext ctx) {
            if (ctx.dataCastArgument() != null) {
                visit(ctx.dataCastArgument());
            } else if (ctx.bitsArgument() != null) {
                visit(ctx.bitsArgument());
            }
            return null;
        }

        @Override
        public Void visitDataCastArgument(SystemVerilog2UppaalParser.DataCastArgumentContext ctx) {
        	//dataCastArgument: LPAREN dataType STAR? RPAREN ID ;
        	String castArgument="("+ctx.dataType().getText();
        	//if (ctx.STAR().getText()!=null)
        	//	castArgument=castArgument+ctx.STAR().getText();
        	
        	castArgument=castArgument+")"+ctx.ID().getText();
        	
            outputBuilder.append(castArgument);
            return null;
        }

        @Override
        public Void visitBitsArgument(SystemVerilog2UppaalParser.BitsArgumentContext ctx) {
            outputBuilder.append("$bits(")
                         .append(ctx.ID().getText())
                         .append(")");
            return null;
        }

        @Override
        public Void visitExpression(SystemVerilog2UppaalParser.ExpressionContext ctx) {
            visit(ctx.primary(0)); // Visit the first primary expression

            if (ctx.argumentList() != null) {
                outputBuilder.append("(");
                visit(ctx.argumentList());
                outputBuilder.append(")");
            }

            for (int i = 1; i < ctx.primary().size(); i++) {
                outputBuilder.append(" ")
                             .append(ctx.operator(i - 1).getText()) // Operator
                             .append(" ");
                visit(ctx.primary(i)); // Next primary expression
            }

            return null;
        }

        @Override
        public Void visitPrimary(SystemVerilog2UppaalParser.PrimaryContext ctx) {
            if (ctx.ID() != null) {
                outputBuilder.append(ctx.ID().getText());
            } else if (ctx.HEX_INT() != null) {
                outputBuilder.append("1");
            } else if (ctx.INT() != null) {
                outputBuilder.append(ctx.INT().getText());
            } else if (ctx.STRING() != null) {
                outputBuilder.append(ctx.STRING().getText());
            } else if (ctx.CHAR() != null) {
                outputBuilder.append(ctx.CHAR().getText());
            } else if (ctx.dataType() != null) {
                outputBuilder.append(ctx.dataType().getText());
            } else if (ctx.castFunctionCall() != null) {
                visit(ctx.castFunctionCall());
            } else if (ctx.expression() != null) {
                outputBuilder.append("(");
                visit(ctx.expression());
                outputBuilder.append(")");
            }
            return null;
        }
        
        @Override
        public Void visitParameterList(SystemVerilog2UppaalParser.ParameterListContext ctx) {
           // StringBuilder parameters = new StringBuilder();

            // Visit each parameter in the list
            for (int i = 0; i < ctx.parameter().size(); i++) {
                // Visit the parameter and append it to the parameters list
            	outputBuilder.append(ctx.parameter(i).getText()+" ");
            	if (i%2!=0)
            		outputBuilder.append(", ");
            }   
                

                // If there's a STAR symbol, append it
                if (ctx.STARR() != null) {
                	outputBuilder.append("int ");
                	
                	// If there's an ID following the STAR, append it
                    if (ctx.ID() != null) {
                    	outputBuilder.append(ctx.ID().getText());
                    }
                }
            /*for (int i = 0; i < ctx.parameter().size(); i++) {
                // Add a comma after each parameter, except the last one
                if (i < ctx.parameter().size() - 1) {
                	outputBuilder.append(", ");
                }
            }*/
         // Check if the last character is a comma and remove it
            if (outputBuilder.charAt(outputBuilder.length() - 2) == ',') {
            	outputBuilder.setLength(outputBuilder.length() - 2); // Remove last ", "
            }
            return null;//parameters.toString();
        }

        @Override
        public Void visitParameter(SystemVerilog2UppaalParser.ParameterContext ctx) {
             outputBuilder.append(ctx.getText()); // Translate SystemVerilog parameter to C parameter if needed
             return null;
        }
        
        @Override
        public Void visitLoopStatement(SystemVerilog2UppaalParser.LoopStatementContext ctx) {
            // Handle different types of loops (for, while, etc.)
            if (ctx.forLoop() != null) {
                visitForLoop(ctx.forLoop());
            } else if (ctx.whileLoop() != null) {
                visitWhileLoop(ctx.whileLoop());
            }
            return null;
        }

        @Override
        public Void visitForLoop(SystemVerilog2UppaalParser.ForLoopContext ctx) {
        	cameFromForLoop=true;
        	
            String init = ctx.assignment(0).getText();  // Initialization part of the loop
            String condition = ctx.expression().getText().replace("<", "&lt;").replace(">", "&gt;");  // Condition part of the loop
            
            String increment="";
            
            if(ctx.assignment(1)!=null)
               increment = ctx.assignment(1).getText();  // Increment part of the loop

            // Create transition for loop initialization
            idTarget = "id" + locationIdCounterTarget++;
            String guardSourceTarget=idTarget;
            outputBuilder.append("//FOR_LOOP_OPEN\n");

            // For loop initialization assignment
               
               outputBuilder.append("    <transition>\n");
               outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
               outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
               outputBuilder.append("        <label kind=\"assignment\">").append(init).append("</label>\n");
               outputBuilder.append("    </transition>\n");
               
               idTarget = "id" + locationIdCounterTarget++;
               outputBuilder.append("    <transition>\n");
               outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
               outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
               outputBuilder.append("        <label kind=\"guard\">").append(condition).append("</label>\n");
               outputBuilder.append("        <label kind=\"assignment\">").append(increment).append("</label>\n");
               outputBuilder.append("    </transition>\n");
               
            // Loop condition and body transitions
           /* idSource = idTarget;  // Update source
            idTarget = "id" + locationIdCounterTarget++;
            outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            outputBuilder.append("        <label kind=\"guard\">").append(condition).append("</label>\n");
            outputBuilder.append("    </transition>\n");
            */
            // Visit the loop body
            idSource = idTarget;  // Update source for loop body
            for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) {
                visitStatement(stmtCtx);
            }
            
          
            
         // Loop getting back to check guard transition
            outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idTarget).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append(guardSourceTarget).append("\"/>\n");
            outputBuilder.append("    </transition>\n");
            
            outputBuilder.append("//FOR_LOOP_CLOSE\n");
            
            cameFromForLoop=false;
            
            return null;
        }

        @Override
        public Void visitWhileLoop(SystemVerilog2UppaalParser.WhileLoopContext ctx) {
            String condition = ctx.expression().getText().replace("<", "&lt;").replace(">", "&gt;");  // Condition part of the while loop

            // Create transition for the loop condition
            idTarget = "id" + locationIdCounterTarget++;
            outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            outputBuilder.append("        <label kind=\"guard\">").append(condition).append("</label>\n");
            outputBuilder.append("    </transition>\n");

            // Visit the loop body
            idSource = idTarget;  // Update source for loop body
            for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) {
                visitStatement(stmtCtx);
            }

            // Close loop with a back transition to the condition
            outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append("id").append(locationIdCounterSource).append("\"/>\n");
            outputBuilder.append("    </transition>\n");
            
            return null;
        }

        @Override
        public Void visitSwitchStatement(SystemVerilog2UppaalParser.SwitchStatementContext ctx) {
            switchCondition = ctx.expression().getText().replace("<", "&lt;").replace(">", "&gt;");  // Condition for the switch
        	//String condition = ctx.expression().getText();  // Condition for the switch

            // Generate the UPPAAL transition for the switch condition
            idTarget = "id" + locationIdCounterTarget++;
            outputBuilder.append("    <transition>\n");
            outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
            outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            outputBuilder.append("        <label kind=\"guard\">").append("switch== "+switchCondition).append("</label>\n");
            outputBuilder.append("    </transition>\n");

            // Handle each case block
            for (SystemVerilog2UppaalParser.CaseBlockContext caseCtx : ctx.caseBlock()) {
                visitCaseBlock(caseCtx);
                outputBuilder.append("//BREAK_STATEMENT\n");
            }

            // Handle default block
            if(ctx.defaultBlock()!=null)
            {
                visitDefaultBlock(ctx.defaultBlock());
                outputBuilder.append("//BREAK_STATEMENT\n");
            }
            
            outputBuilder.append("//SWITCH_STATEMENT_CLOSED\n");
            return null;
        }

        @Override
        public Void visitCaseBlock(SystemVerilog2UppaalParser.CaseBlockContext ctx) {
            String caseValue = ctx.expression().getText().replace("<", "&lt;").replace(">", "&gt;");  // Value of the case
             cameFromCaseStatement=true;
             // Create transition for each case value
             idSource = idTarget;
             idTarget = "id" + locationIdCounterTarget++;
             outputBuilder.append("    <transition>\n");
             outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
             outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
             outputBuilder.append("        <label kind=\"guard\">").append(/*"case "*/switchCondition+"=="+caseValue).append("</label>\n");
             
             boolean caseAssignmentTag=true;
             int countIterationForEndLabelTag=0;
             // Visit statements within the case block
             for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) { 
             	
             	countIterationForEndLabelTag=countIterationForEndLabelTag+1;
             	//System.out.println(ctx.statement().size()+" ... "+countIterationForEndLabelTag);

             	if((stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (caseAssignmentTag))
             	{
             		outputBuilder.append("        <label kind=\"assignment\">");
             		caseAssignmentTag=false;
             	}
             	/*if (stmtCtx.ifStatement()!=null)
             	{
             		outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                 	outputBuilder.append("</label>\n");
             	}*/
             	if(stmtCtx.comment()==null)
                 visitStatement(stmtCtx);
                 //System.out.println("NOW I WILL CHECK EXIT LABEL ");
                 if(ctx.statement().size()==countIterationForEndLabelTag /*&& stmtCtx.ifStatement()==null*/ )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
             	{//System.out.println(" I am inside exit label ");
                 	// Trim trailing whitespace
                 	/*while (outputBuilder.length() > 0 && Character.isWhitespace(outputBuilder.charAt(outputBuilder.length() - 1))) {
                 		outputBuilder.deleteCharAt(outputBuilder.length() - 1);  // Remove last character if it's whitespace
                 	}*/
                 	
                 	outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                 	outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                 	

                 	String checkLabel=outputBuilder.toString();
	            	checkLabel=checkLabel.trim();
	            	if(!checkLabel.endsWith("</transition>"))
	            		
                 	//if (!(outputBuilder.toString().endsWith("</transition>")))
                  	   outputBuilder.append("</label>\n    </transition>\n");
                  	else
                  		 outputBuilder.append("\n");
             	} 
             
             	
             //    visitStatement(stmtCtx);
             }
            // outputBuilder.append("    </transition>\n");
             cameFromCaseStatement=false;
             return null;
         }
         
         @Override
         public Void visitDefaultBlock(SystemVerilog2UppaalParser.DefaultBlockContext ctx) {
         	
             //defaultBlock: DEFAULT COLON (statement*)? BREAK SEMICOLON?;  
         	
         	cameFromCaseStatement=true;
             // Create transition for each case value
             idSource = idTarget;
             idTarget = "id" + locationIdCounterTarget++;
             outputBuilder.append("    <transition>\n");
             outputBuilder.append("        <source ref=\"").append(idSource).append("\"/>\n");
             outputBuilder.append("        <target ref=\"").append(idTarget).append("\"/>\n");
             outputBuilder.append("        <label kind=\"guard\">").append("def==1").append("</label>\n");
             
             boolean caseAssignmentTag=true;
             int countIterationForEndLabelTag=0;
             // Visit statements within the case block
             for (SystemVerilog2UppaalParser.StatementContext stmtCtx : ctx.statement()) { 
             	
             	countIterationForEndLabelTag=countIterationForEndLabelTag+1;
             	//System.out.println(ctx.statement().size()+" ... "+countIterationForEndLabelTag);

             	if((stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (caseAssignmentTag))
             	{
             		outputBuilder.append("        <label kind=\"assignment\">");
             		caseAssignmentTag=false;
             	}
             	/*if (stmtCtx.ifStatement()!=null)
             	{
             		outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                 	outputBuilder.append("</label>\n");
             	}*/
                 visitStatement(stmtCtx);
                 //System.out.println("NOW I WILL CHECK EXIT LABEL ");
                 if(ctx.statement().size()==countIterationForEndLabelTag /*&& stmtCtx.ifStatement()==null*/ )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
             	{//System.out.println(" I am inside exit label ");
                 	// Trim trailing whitespace
                 	/*while (outputBuilder.length() > 0 && Character.isWhitespace(outputBuilder.charAt(outputBuilder.length() - 1))) {
                 		outputBuilder.deleteCharAt(outputBuilder.length() - 1);  // Remove last character if it's whitespace
                 	}*/
                 	
                 	outputBuilder.deleteCharAt(outputBuilder.length() - 1); 
                 	outputBuilder.append("</label>\n");
             	} 
             
             	
             //    visitStatement(stmtCtx);
             }
             outputBuilder.append("    </transition>\n");
             cameFromCaseStatement=false;
         

         	return null;
         }
         
        
        
        @Override
        public Void visitDisplayStatement(SystemVerilog2UppaalParser.DisplayStatementContext ctx) {
        	
        	//printStatement: PRINTF LPAREN STRING? argument? (COMMA argumentList)? RPAREN;

        	String printStatement=ctx.DISPLAY().getText()+ctx.LPAREN().getText()+ctx.STRING().getText();
        	if (!(outputBuilder.toString().endsWith(",")))
        		outputBuilder.deleteCharAt(outputBuilder.length() - 1);
        	
        	if (ctx.argument()!=null)
        		printStatement=printStatement+", "+ctx.argument().getText();
        	
        	if (cameFromDeclaration)
            	outputBuilder.append("    // "+printStatement);
            else
            	outputBuilder.append("    <!-- "+printStatement);
        	
        	//outputBuilder.append("    <!-- "+printStatement);

            if (ctx.argumentList() != null) {
                visitArgumentList(ctx.argumentList());
            }
            
            if (cameFromDeclaration)
                outputBuilder.append(ctx.RPAREN().getText()+"; \n");
            else
                outputBuilder.append(ctx.RPAREN().getText()+"; --> \n");

            //outputBuilder.append(ctx.RPAREN().getText()+"; -->\n");
            
            return null; 
        }

        @Override
        public Void visitComment(SystemVerilog2UppaalParser.CommentContext ctx) {
            // Get the text of the comment
            String commentText = ctx.getText().replace("<", " &lt;").replace(">", " &gt;").replace("&&", " &amp;&amp; ");

            // Check if it's a single-line or multi-line comment
            
            /*
	            if (commentText.startsWith("//")) {
	                // Single-line comment
	                outputBuilder.append("    <!-- ").append(commentText.substring(2).trim()).append(" -->\n");
	            } else if (commentText.startsWith("/*")) {
	                // Multi-line comment
	                outputBuilder.append("    <!-- ").append(commentText.substring(2, commentText.length() - 2).trim()).append(" -->\n");
	            */
            if (cameFromDeclaration)
            {
	            if (commentText.startsWith("//")) {
	                // Single-line comment
	                outputBuilder.append("    // ").append(commentText.substring(2).trim()).append(" \n");
	            } else if (commentText.startsWith("/*")) {
	                // Multi-line comment
	                outputBuilder.append("    // ").append(commentText.substring(2, commentText.length() - 2).trim()).append(" \n");
	            }
            }
            else
            {
	            if (commentText.startsWith("//")) {
	                // Single-line comment
	                outputBuilder.append("    <!-- ").append(commentText.substring(2).trim()).append(" --> \n");
	            } else if (commentText.startsWith("/*")) {
	                // Multi-line comment
	                outputBuilder.append("    <!-- ").append(commentText.substring(2, commentText.length() - 2).trim()).append("--> \n");
	            }
            }

            return null;
        }
   
        @Override
        public Void visitDataType(SystemVerilog2UppaalParser.DataTypeContext ctx) {
            switch (ctx.getText()) {
                case "int":
                	outputBuilder.append( "int");
                case "uint8_t":
                	outputBuilder.append( "int");
                case "uint32_t":
                	outputBuilder.append( "int");
                case "TickType_t":
                	outputBuilder.append( "int");
                case "osThreadId":
                	outputBuilder.append( "int");	
                case "float":
                	outputBuilder.append( "double");    
                case "double":
                	outputBuilder.append( "double"); 
                case "char":
                	outputBuilder.append( "int");
                case "osEvent":
                	outputBuilder.append( "int");	
                case "void":
                	outputBuilder.append( "void");	
                default:
                	outputBuilder.append( "int"); // Default to int for unsupported types
            }
            return null;
        } 
        
        
        @Override
        public Void visitReturnType(SystemVerilog2UppaalParser.ReturnTypeContext ctx) {
            switch (ctx.getText()) {
            case "int":
            	outputBuilder.append( "int");
            case "uint8_t":
            	outputBuilder.append( "int");
            case "uint32_t":
            	outputBuilder.append( "int");
            case "TickType_t":
            	outputBuilder.append( "int");
            case "osThreadId":
            	outputBuilder.append( "int");	
            case "float":
            	outputBuilder.append( "double");    
            case "double":
            	outputBuilder.append( "double"); 
            case "char":
            	outputBuilder.append( "int");
            case "osEvent":
            	outputBuilder.append( "int");	
            case "void":
            	outputBuilder.append( "void");	
            default:
            	outputBuilder.append( "int"); // Default to int for unsupported types
            }
            return null;
        } 


    public String getUPPAALXML() {
    	
        
        if(runAllCodeTwice)
        {
         //outputBuilder.append("\n---------------------------------------------before----------***************************************************-\n");
            countTemplates=false;
        	
        	totalLocations=locationIdCounterTarget;
        	
        	//System.out.println("TemplatesWiseLocationsCount: "+ TemplatesWiseLocationsCount.length);
        	for (int i=0;i<TemplatesWiseLocationsCount.length;i++)
        		totalLocationsSum=totalLocationsSum+TemplatesWiseLocationsCount[i];
        	
        	//visitFile(ctxNew);
        	//totalLocations=locationIdCounterTarget;
            visitModuleDecl(ctxNew);
            runAllCodeTwice=false;
         //outputBuilder.append("\n-----------------------------------------after-----------************************************************---\n");
        }
        
        systemDeclarations = systemDeclarations.substring(0, systemDeclarations.length() - 1)+';';

        outputBuilder.append("<system>"+systemDeclarations+"</system>\n");
    	outputBuilder.append("<queries>\n");
    	outputBuilder.append("	<query>\n");
    	outputBuilder.append("		<formula></formula>\n");
    	outputBuilder.append("		<comment></comment>\n");
    	outputBuilder.append("	</query>\n");
    	outputBuilder.append("</queries>\n");
        outputBuilder.append("</nta>\n");
        
        return outputBuilder.toString();
    }
}
