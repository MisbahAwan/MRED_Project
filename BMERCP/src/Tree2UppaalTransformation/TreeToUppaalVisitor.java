package Tree2UppaalTransformation;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import C2UppaalTransformations.C2UppaalParser;
//import Tree2CTransformation.Tree2CParser;

public class TreeToUppaalVisitor extends Tree2UppaalBaseVisitor<String> {
	
	boolean OneTimeDeclarationOpen=true;
    boolean OneTimeDeclarationClose=true;
    //Tree2UppaalParser.ModuleDeclContext ctxNew;
    boolean runAllCodeTwice= true; // this will run visitModuleDecl twice. one time it will get otal count of locations and 2nd time remove all code and generate code based on locations count.
    boolean cameFromIfStatement=false;
    boolean makeCloseTransitionTag=true;
    boolean nestedIfModeOn=false;
    
    boolean cameFromCaseStatement=false;
    boolean cameFromForLoop=false;
    boolean cameFromDeclaration=false;
    
    boolean labelIsOn=false;
    boolean doubleTransitionTagCheckInCaseToIf=true;
    int locationIdCounterSource=0;
    int locationIdCounterTarget=1;
    
    String lastStatement=null; // this is to increment transition when last transition is not if
    
    String switchCondition="";
    
    String idSource="id0";
    String idTarget="id0";
    
    boolean elseModeStringAppend=false;
    String elseString="";
    
    String systemDeclarations="system ";
    
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

	
	    @Override
	    public String visitSystem(Tree2UppaalParser.SystemContext ctx) {
	    	StringBuilder sb = new StringBuilder();
	    	//System.out.println("1");
	    	
	    	
	    	
	    	OneTimeDeclarationOpen=true;
	        OneTimeDeclarationClose=true;
	        
	        elseModeStringAppend=false;
	        elseString="";
	    	
	        totalTemplatesCountPrint=0;
	        
	        systemDeclarations="system ";
	        
	    	// below copied from constructor
	    	sb = new StringBuilder();
	        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
	        sb.append("<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'flat-1_2.dtd'>\n");
	        sb.append("<nta>\n");
	        locationIdCounterSource = 0;
	        locationIdCounterTarget = 1;
	        
	        ifTransitions = new String[10];
            ifTransitionsCount=-1;
            
	        if(OneTimeDeclarationOpen) {sb.append("   <declaration>\n");OneTimeDeclarationOpen=false; cameFromDeclaration=true;}
	        
	        
	        idSource="id0";
	        idTarget="id0";
	        //System.out.println("6");
	        // Defining Locations
	        //locations= new String[totalLocations];
	        locations= new String[totalLocationsSum];
	        int j=10;
	        for (int i = 0; i < locations.length; i++) {
	            locations[i]="<location id=\"id"+i+"\" x=\""+(i+10)*150+"\" y=\""+j+"\">\n"+"   	   <name>Loc"+i+"</name>\n"+"      </location>";
	            if (i % 2 == 0)
	            	j=250;
	            else
	            	j=10;
	        }
	    	
	    	
	    	
	        // Visit declarations and components
	        /*for (Tree2UppaalParser.DeclarationContext declaration : ctx.declaration())
	        	sb.append(visit(declaration));//System.out.println("2");
	        
	        for (Tree2UppaalParser.ComponentContext component : ctx.component())
	           sb.append(visit(component));*/
	        for (ParseTree child : ctx.children) 
	        {
	            if (child instanceof Tree2UppaalParser.PreprocessorDirectiveContext) {
	            	// Visit preprocessor directive
	            	sb.append(visitPreprocessorDirective((Tree2UppaalParser.PreprocessorDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.IncludeDirectiveContext) {
	            	// Visit include directive
	            	sb.append(visitIncludeDirective((Tree2UppaalParser.IncludeDirectiveContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.CommentContext) {
	            	// Visit module declaration
	            	sb.append(visitComment((Tree2UppaalParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
	            	// Visit module declaration
	            	sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.ComponentContext) {
	            	// Visit module declaration
	            	sb.append(visitComponent((Tree2UppaalParser.ComponentContext) child));
	            }
	            else if (child instanceof Tree2UppaalParser.PrintContext) {
	            	// Visit module declaration
	            	sb.append(visitPrint((Tree2UppaalParser.PrintContext) child));
	            }   
	        }
	        //System.out.println("3");
	    	if(runAllCodeTwice)
	        {//System.out.println("4");
	    		//cameFromDeclaration=true;
	    		countTemplates=false;
	        	totalLocations=locationIdCounterTarget;
	        	
	        	for (int i=0;i<TemplatesWiseLocationsCount.length;i++)
	        		totalLocationsSum=totalLocationsSum+TemplatesWiseLocationsCount[i];
	        	
	    		
	        	sb = new StringBuilder();
	        	//sb = new StringBuilder();
		         //sb.append("\n---------------------------------------------2nd iteration started----------***************************************************-\n");
		         //System.out.println("5");
		    	
	        	//ctxNew=ctx;
	            	
	    	    	OneTimeDeclarationOpen=true;
	    	        OneTimeDeclarationClose=true;
	    	        
	    	        elseModeStringAppend=false;
	    	        elseString="";
	    	    	
	    	        totalTemplatesCountPrint=0;
	    	        
	    	        systemDeclarations="system ";
	    	        
	    	    	// below copied from constructor
	    	    	sb = new StringBuilder();
	    	        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
	    	        sb.append("<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'flat-1_2.dtd'>\n");
	    	        sb.append("<nta>\n");
	    	        locationIdCounterSource = 0;
	    	        locationIdCounterTarget = 1;
	    	        
	    	        ifTransitions = new String[10];
	                ifTransitionsCount=-1;
	                
	    	        if(OneTimeDeclarationOpen) {sb.append("   <declaration>\n");OneTimeDeclarationOpen=false; cameFromDeclaration=true;}
	    	        
	    	        
	    	        idSource="id0";
	    	        idTarget="id0";
	    	        //System.out.println("6");
	    	        // Defining Locations
	    	        locations= new String[totalLocations];
	    	        //locations= new String[totalLocationsSum];
	    	        j=10;
	    	        for (int i = 0; i < locations.length; i++) {
	    	            locations[i]="<location id=\"id"+i+"\" x=\""+(i+10)*150+"\" y=\""+j+"\">\n"+"   	   <name>Loc"+i+"</name>\n"+"      </location>";
	    	            if (i % 2 == 0)
	    	            	j=250;
	    	            else
	    	            	j=10;
	    	            
	    	            //System.out.println(locations[i]);
	    	        }
	    	    	
	    	        for (ParseTree child : ctx.children) 
	    	        {
	    	            if (child instanceof Tree2UppaalParser.PreprocessorDirectiveContext) {
	    	            	// Visit preprocessor directive
	    	            	sb.append(visitPreprocessorDirective((Tree2UppaalParser.PreprocessorDirectiveContext) child));
	    	            } 
	    	            else if (child instanceof Tree2UppaalParser.IncludeDirectiveContext) {
	    	            	// Visit include directive
	    	            	sb.append(visitIncludeDirective((Tree2UppaalParser.IncludeDirectiveContext) child));
	    	            } 
	    	            else if (child instanceof Tree2UppaalParser.CommentContext) {
	    	            	// Visit module declaration
	    	            	sb.append(visitComment((Tree2UppaalParser.CommentContext) child));
	    	            } 
	    	            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
	    	            	// Visit module declaration
	    	            	sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
	    	            } 
	    	            else if (child instanceof Tree2UppaalParser.ComponentContext) {
	    	            	// Visit module declaration
	    	            	sb.append(visitComponent((Tree2UppaalParser.ComponentContext) child));
	    	            }
	    	            else if (child instanceof Tree2UppaalParser.PrintContext) {
	    	            	// Visit module declaration
	    	            	sb.append(visitPrint((Tree2UppaalParser.PrintContext) child));
	    	            }    
		        //System.out.println("8");
	            runAllCodeTwice=false;
	         //sb.append("\n-----------------------------------------2nd iteration ended-----------************************************************---\n");
	        }
	      }
	    	 systemDeclarations = systemDeclarations.substring(0, systemDeclarations.length() - 1)+';';

		        sb.append("<system>"+systemDeclarations+"</system>\n");
		    	sb.append("<queries>\n");
		    	sb.append(" <query>\n");
		    	sb.append("	  <formula></formula>\n");
		    	sb.append("	  <comment></comment>\n");
		    	sb.append(" </query>\n");
		    	sb.append("</queries>\n");
		        sb.append("</nta>\n");
		        
	      return sb.toString();
	    }
	    
	    @Override
	    public String visitPreprocessorDirective(Tree2UppaalParser.PreprocessorDirectiveContext ctx) {
	    	StringBuilder result = new StringBuilder();
	        String id = ctx.ID().getText();
	        String value = ctx.NUMBER().getText();
	        result.append(  "    const int " + id + " = " + value+";");
	        return result.toString();
	    }

	    @Override
	    public String visitIncludeDirective(Tree2UppaalParser.IncludeDirectiveContext ctx) {
	    	
	    	return  visit(ctx.systemInclude() != null ? ctx.systemInclude() : ctx.localInclude());
	    	 
	    }

	    @Override
	    public String visitSystemInclude(Tree2UppaalParser.SystemIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText();
	    	//result.append( "#include <" + header + ">").append(" \n");
	    	result.append("    // ").append( "#include &lt;" + header + "&gt;").append(" \n");
	        
	        return result.toString();
	    }

	    @Override
	    public String visitLocalInclude(Tree2UppaalParser.LocalIncludeContext ctx) {
	    	StringBuilder result = new StringBuilder();
	    	String header = ctx.ID().getText().replace("&lt;", "<");
	    	//result.append( "#include \"" + header + "\"").append(" \n");
	    	result.append("    // ").append( "#include \"" + header + "\"").append(" \n");

	        return result.toString();
	    }
		
	    @Override
	    public String visitEnumDecl(Tree2UppaalParser.EnumDeclContext ctx) {
	        
	    	StringBuilder result = new StringBuilder();
	    	/*String typedef = "typedef";
	        String enumType = "enum";
	        String enumName = ctx.ID().getText();
	        
	        result.append(""+typedef + " " + enumType + " {  \n ");
			*/
	        result.append(visitEnumList(ctx.enumList()));
	        
	        //result.append(" } " + enumName + ";\n");
	       
	        return result.toString();

	    }

	    @Override
	    public String visitEnumList(Tree2UppaalParser.EnumListContext ctx) {
	    	int a=0;    	
	        StringBuilder enums = new StringBuilder();
	        for (TerminalNode id : ctx.ID()) {
	            enums.append(" 	const int "+id.getText()).append(" = "+a+";\n ");
	            a=a+1;
	        }
	        /*if (enums.length() >= 2) {
	        // Remove last comma and \n
	        enums.delete(enums.length() - 3, enums.length());
	        }*/
	        //enums.append("\n");
	        return enums.toString();
	    }


	    @Override
	    public String visitDeclaration(Tree2UppaalParser.DeclarationContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        //System.out.println("9");
	      //  sb.append(" <declaration>\n");
	        
	        cameFromDeclaration=true;
	        // Visit attributes and function prototypes
	        /*for (Tree2UppaalParser.AttributeContext attribute : ctx.attribute()) {
	            sb.append(visit(attribute)).append("\n");
	        }
	        for (Tree2UppaalParser.FunctionprototypeContext functionPrototype : ctx.functionprototype()) {
	            sb.append(visit(functionPrototype)).append("\n");
	        }*/
	     // Loop through each child node in the file rule
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2UppaalParser.AttributeContext) {
	            	sb.append(visitAttribute((Tree2UppaalParser.AttributeContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.FunctionprototypeContext) {
	            	sb.append(visitFunctionprototype((Tree2UppaalParser.FunctionprototypeContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.CommentContext) {
	            	sb.append(visitComment((Tree2UppaalParser.CommentContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.EnumDeclContext) {
	            	sb.append(visitEnumDecl((Tree2UppaalParser.EnumDeclContext) child));
	            }         
	        }
	        
	        //sb.append(" </declaration>\n");
	        
	        return sb.toString();
	    }

	    @Override
	    public String visitAttribute(Tree2UppaalParser.AttributeContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
	        String extern="", size="", initialValue="", datatype="", attribute="";

	        if(ctx.EXTERN()!=null) 
	        	extern=ctx.EXTERN().getText();
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
	        
	     // Step 1: Trim spaces from the end
	        initialValue = initialValue.replaceAll("\\s+$", "");
	        if (initialValue.endsWith("=")) {
	            // Trim the last character
	        	initialValue = initialValue.substring(0, initialValue.length() - 1);
	        }
	        
	        if (!size.isEmpty()) {
	        	if (size.contains("[") && size.contains(":")) {
	        		// Find the index of '[' and ':'
	                int startIndex = size.indexOf('[') + 1;
	                int endIndex = size.indexOf(':');
	                
	                // Extract the substring between '[' and ':'
	                String extractedValue = size.substring(startIndex, endIndex);
	                
	                // Convert the extracted string to an integer (if needed)
	                int arraySize = Integer.parseInt(extractedValue);
	            	size="["+arraySize+"]";
	            }
	        }
	        if (lastStatement!="declaration")
	        	sb.append(" "+datatype+" "+attribute+size+initialValue+";\n");
	        else 
	        	Declarations[++countDeclarations]= " "+datatype+" "+attribute+size+initialValue+";";
	        	
	        
	        	
	        	
	        return sb.toString();
	    }

	    @Override
	    public String visitFunctionprototype(Tree2UppaalParser.FunctionprototypeContext ctx) {
	        StringBuilder sb = new StringBuilder();
	        
	        String returntype="", functionname="";
	        StringBuilder parameters= new StringBuilder();
	        
	        returntype=visitDataTypes(ctx.dataTypes());
	        functionname=ctx.ID().getText().replace("\"", "");
	        sb.append(returntype+" "+functionname+"( ");
	        
	        
	        for (Tree2UppaalParser.ParameterContext parameter : ctx.parameter()) {
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
	        
	        sb.append(") {");
	        
	        if(!returntype.equals("void"))
	        	sb.append(" return 0; ");
	        
	        //sb.append(" }");
	        	// Additional function logic can be added here
	        sb.append("}\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitComponent(Tree2UppaalParser.ComponentContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
            String componentName="", returnType="";
            
            if(OneTimeDeclarationClose) 
	        {
	        	sb.append("\n\n// Posting Declarations from all templates here:\n\n");
		        for (int i = 0; i < Declarations.length; i++)
		        	if(Declarations[i]!=null)
		        	sb.append("   "+Declarations[i]+"\n");
	        	
	        	sb.append("   </declaration>\n");
	        	OneTimeDeclarationClose=false; cameFromDeclaration=false;
	        }
            
            sb.append(" <template>\n");
	        
            returnType=visitDataTypes(ctx.dataTypes());
	        componentName=ctx.ID().getText().replace("\"", "");
	        //sb.append(returnType+" "+componentName+"( ");
	        
	        systemDeclarations = systemDeclarations+componentName+',';
	        sb.append("//TEMPLATE_RETURN_TYPE:"+returnType+"\n");
	        sb.append("    <name>").append(componentName).append("</name>\n");
	        sb.append("    <parameter>");
	        
	        
	        for (Tree2UppaalParser.ParameterContext parameter : ctx.parameter()) {
	            sb.append(visit(parameter)).append(", ");
	        }
	        if (ctx.parameter().size() > 0) {
	            sb.setLength(sb.length() - 2); // Remove last comma and space
	        }
	        //sb.append(") \n{\n");
	        sb.append("</parameter>\n");
	        
	        if (ctx.children.size()>0)
	        {	//System.out.println("here: "+totalTemplatesCountPrint);
		        /*for (int i = 0; i < locations.length; i++) {
		        	sb.append("  "+ locations[i]+"\n");
		        }*/
	        	for (int i = 0; i < TemplatesWiseLocationsCount[totalTemplatesCountPrint]; i++) {
		        	sb.append("      "+ locations[i]+"\n");
		        }
		        
		        sb.append("     <init ref=\"id0\"/>\n");
	        }
	        else
	        {
	        	sb.append("      <location id=\"id0\" x=\"50\" y=\"50\"> </location>\n");
	        	sb.append("      <init ref=\"id0\"/>\n");
	        	sb.append("      <transition>\n");
	        	sb.append("          <source ref=\"id0\"/>\n");
	        	sb.append("          <target ref=\"id0\"/>\n");
	        	sb.append("      </transition>\n");
	        }
	        
	        idSource="id0";
	        idTarget="id0";
	        		
	        locationIdCounterSource = 0;
	        locationIdCounterTarget = 1;
	        
	        // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {//System.out.println("inside");
	        	 if (child instanceof Tree2UppaalParser.CommentContext) {//System.out.println("its a comment");
		                // Process the comment
		                sb.append(visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
		            } else if (child instanceof Tree2UppaalParser.StatementContext) {
		                // Process the statement
		            	
		                sb.append(visitStatement((Tree2UppaalParser.StatementContext) child)).append("\n");
		            } else if (child instanceof Tree2UppaalParser.DeclarationContext) {
		                // Process declarations, if any (optional)
		            	lastStatement="declaration";
		                sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child)).append("\n");
		            } else if (child instanceof Tree2UppaalParser.ReturnContext) {
		                // Process declarations, if any (optional)
		                sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child)).append("\n");
		            } else if (child instanceof Tree2UppaalParser.PrintContext) {
		            	// Visit module declaration
		            	sb.append(visitPrint((Tree2UppaalParser.PrintContext) child));
		            } else if (child instanceof Tree2UppaalParser.LoopContext) {
		            	// Visit module declaration
		            	
		            	sb.append(visitLoop((Tree2UppaalParser.LoopContext) child));
		            }
	        }
	        //sb.append("\n}");
	        
	        sb.append(" </template>\n");
	        
	        if (countTemplates)
	        {
	        	TemplatesWiseLocationsCount[totalTemplatesCount]=locationIdCounterTarget;
	        	totalTemplatesCount=totalTemplatesCount+1;
	        }
	        totalTemplatesCountPrint=totalTemplatesCountPrint+1;
	        
	       
	        
	        
	        return sb.toString();
	    }

	    @Override
	    public String visitParameter(Tree2UppaalParser.ParameterContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	        String pointer="", qualifier="", datatype="", attribute="";
	        
	        if(ctx.ID(0)!=null) 
	        	attribute=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.dataTypes()!=null && !(ctx.dataTypes().getText().contains("void"))) 
	        	datatype=visitDataTypes(ctx.dataTypes());
	        if(ctx.ID(1)!=null) 
	        	qualifier= ctx.ID(1).getText().replace("\"", "");
	        if(ctx.STAR()!=null) 
	        	pointer= "int ";//ctx.STAR().getText().replace("\"", "");
	        
	        datatype=datatype+" ";
	        qualifier=qualifier+" ";
	        pointer=pointer+" ";
	        
	        sb.append(datatype+qualifier+pointer+attribute);
	        	        
	        return sb.toString();
	    }

	    @Override
	    public String visitStatement(Tree2UppaalParser.StatementContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
			    	
			    if ( /*(nestedIfModeOn == false) && */(ctx.assignment() != null || ctx.ifstatement() != null || ctx.functioncall() != null) )          
		    	   idSource = idTarget;
		    		
		    	if (ctx.assignment() != null) {
		    		sb.append(visitAssignment(ctx.assignment())).append("\n");
		            lastStatement = "assignment";
		        } else if (ctx.ifstatement() != null) 
		        {
		        	
				    //outputBuilder.append("    <transition>\n");
				    if (cameFromIfStatement) 
				    {
					    sb.append("    </transition>\n"); // close transition as its nested if
					    nestedIfModeOn=true;
				    }else if(cameFromCaseStatement)
				    {//if((sb.length() > 0) && (!sb.substring(sb.length() - 30).contains("</transition>") ))
				    	//if (!(sb.toString().contains("</transition>")))
				    	//if (doubleTransitionTagCheckInCaseToIf)
				    	{
				    		String checkLabel=sb.toString();
			            	checkLabel=checkLabel.trim();
			            	if(!checkLabel.endsWith("</transition>"))
			        		//if (!(sb.toString().endsWith("</transition> \n")))
			        		{
			        		sb.append("    </transition>\n"); // close transition as its nested if
			        		doubleTransitionTagCheckInCaseToIf=true;
			        		}
			        		else
			             		 sb.append("\n");
			        	}
				    	/*{
		            	   sb.append("    </transition>\n"); // close transition as its nested if
		            	   doubleTransitionTagCheckInCaseToIf=true;
				    	}*/
		            	   //else if(sb.length() <= 0)	sb.append("    F2</transition>\n");
				    }
				   sb.append(visitIfstatement(ctx.ifstatement())).append("\n");
				   cameFromIfStatement=false;
				   lastStatement = "if";
				   //if(nestedIfModeOn || ctx.ifStatement().ELSE()!=null)  
				   {
				     //making extra if transition
				    } 
	               //outputBuilder.append("    </transition>\n");
		        }else if (ctx.loop() != null) {
		        	sb.append(visitLoop(ctx.loop()));
		            lastStatement = "loop";
		        }else if (ctx.comment() != null) {
		        	sb.append(visitComment(ctx.comment())).append("\n");
		            lastStatement="comment";
		        } else if (ctx.functioncall() != null) {
		        	sb.append(visitFunctioncall(ctx.functioncall())).append("\n");
		            lastStatement="functionCall";
		        } else if (ctx.switch_() != null) {
		        	sb.append(visitSwitch(ctx.switch_())).append("\n");
		            lastStatement="switch";
		        } else if (ctx.declaration() != null) {
		        	lastStatement="declaration";
		        	sb.append(visitDeclaration(ctx.declaration())).append("\n");   
		        } else if (ctx.print() != null) {
		        	sb.append(visitPrint(ctx.print())).append("\n");
		            lastStatement="print";
		        } else if (ctx.return_() != null) {
		        	sb.append(visitReturn(ctx.return_())).append("\n");
		            lastStatement="return";
		        }
		    	
    
	    	return sb.toString();
	    }
	    
	    @Override
	    public String visitIfstatement(Tree2UppaalParser.IfstatementContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        String keyword = ctx.getChild(0).getText();
	        
	        String guard = "";//ctx.expression().getText();
	        cameFromIfStatement=true;
	        //idSource = "id" + locationIdCounterSource++;
	        idTarget = "id" + locationIdCounterTarget++;
	        
	        String ifVar="", elseVar="", operator="", value="", variable="";
	        
	        if(ctx.IF()!=null) 
	        	ifVar=ctx.IF().getText().replace("\"", "");
	        if(ctx.ELSE()!=null) 
	        	elseVar=ctx.ELSE().getText().replace("\"", "");
	        if(ctx.ID(0)!=null) 
	        	variable=ctx.ID(0).getText().replace("\"", "");
	        if(ctx.operator()!=null) 
	        	operator= ctx.operator().getText().replace("\"", "");
	        
	        if(ctx.STRING()!=null) 
	        	value=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID(1)!=null) 
	        	value=ctx.ID(1).getText().replace("\"", "");
	        else if(ctx.NUMBER()!=null) 
	        	value=ctx.NUMBER().getText().replace("\"", "");
	        
	        guard=(variable+operator+value).replace("<", " &lt;").replace(">", " &gt;").replace("&&", " &amp;&amp; ");
	        
	        //if (!nestedIfModeOn || ctx.ELSE()!=null)
	        {
	          //creating an additional transition when if ends
	          ifTransitionsCount=ifTransitionsCount+1;
	          ifTransitions[ifTransitionsCount]=idSource;
	        }
	        if(ctx.ELSE()!=null)
	        	sb.append("//ELSE\n");
	     // Create transition
	        sb.append("    <transition>\n");
	        sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
	        sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	        sb.append("        <label kind=\"guard\">").append(guard).append("</label>\n");

	     // Visit if body
	        boolean switchAssignmentTag=true;
	        int statementsSize=(ctx.statement().size())+(ctx.ifstatement().size())+(ctx.assignment().size())+(ctx.functioncall().size())+(ctx.comment().size())+(ctx.declaration().size())+(ctx.print().size())+ctx.switch_().size()+ctx.return_().size()+ctx.loop().size();
	        int countIterationForEndLabelTag=0;
	        //sb.append("\n------------------------"+statementsSize+"--------------------------1 \n");
	        for (ParseTree child : ctx.children) {
	        	//sb.append("\n...."+child.getText()+"....\n");
	        	countIterationForEndLabelTag=countIterationForEndLabelTag+1;
	        	//System.out.println(ctx.statement().size()+" ... "+countIterationForEndLabelTag);

	        	if (((child instanceof Tree2UppaalParser.AssignmentContext) || (child instanceof Tree2UppaalParser.FunctioncallContext)) && (switchAssignmentTag))
	        	{
	        		sb.append("        <label kind=\"assignment\">");
	        		switchAssignmentTag=false;
	        		labelIsOn=true;
	        	}
	        	if (child instanceof Tree2UppaalParser.IfstatementContext) 
	        	{
	        		sb.deleteCharAt(sb.length() - 1); // remove /n appended at the end
	        		sb.deleteCharAt(sb.length() - 1); // remove extra comma
	            	sb.append("---------------------------------------------</label>\n");
	        	}
	        	
	        	if (child instanceof Tree2UppaalParser.CommentContext) {
	                // Process the comment
	                //sb.append(visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2UppaalParser.AssignmentContext) {
	                // Process the assignment
	                sb.append(visitAssignment((Tree2UppaalParser.AssignmentContext) child));
	                
	            } 
	            else if (child instanceof Tree2UppaalParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	                sb.append(visitFunctioncall((Tree2UppaalParser.FunctioncallContext) child));
	            } 
	            else if (child instanceof Tree2UppaalParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	            	//sb.append("Z</label>\n");
	            	
	                sb.append(visitIfstatement((Tree2UppaalParser.IfstatementContext) child));
	                
	            }
	            else if (child instanceof Tree2UppaalParser.ReturnContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child));
	            }
	            else if (child instanceof Tree2UppaalParser.StatementContext) {//sb.append("hello...");
	                // Process if statement, if any (optional)
	            	String checkLabel=sb.toString();
	            	checkLabel=checkLabel.trim();
	            	if(!checkLabel.endsWith("</label>"))
	            	{
	            		sb.deleteCharAt(sb.length() - 2); 
	            	   sb.append("      </label>\n");
	            	}
	            	
	                sb.append(visitStatement((Tree2UppaalParser.StatementContext) child));
	                
	            }
	            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	            	lastStatement="declaration";
	                sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
	            }
	            else if (child instanceof Tree2UppaalParser.PrintContext) {
	                // Process if statement, if any (optional)
	                //sb.append(visitPrint((Tree2UppaalParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.SwitchContext) {
	                // Process if statement, if any (optional)
	                sb.append(visitSwitch((Tree2UppaalParser.SwitchContext) child));
	            } 
	        	
	            //System.out.println("NOW I WILL CHECK EXIT LABEL ");
	        	//sb.append(statementsSize+"-"+countIterationForEndLabelTag);
	            //if(statementsSize==countIterationForEndLabelTag && (!(child instanceof Tree2UppaalParser.IfstatementContext)) )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
	        	if(child.getText().contains("</if>") && labelIsOn)
	        	{
	        		String checkLabel=sb.toString();
	            	checkLabel=checkLabel.trim();
	            	if(!checkLabel.endsWith("</label>"))
	        		//if (!(sb.toString().endsWith("</label>")))
	            	{
		            	 
		            	sb.deleteCharAt(sb.length() - 1); 
		            	sb.deleteCharAt(sb.length() - 1); 
		            	sb.append("  </label>\n");
		            	labelIsOn=false;
	            	}	
	        	} 
	        }//end loop
	        
	        if ((!nestedIfModeOn || ctx.ELSE()!=null) && !cameFromCaseStatement)
	        {
	        		sb.append("    </transition>\n");
	        		doubleTransitionTagCheckInCaseToIf=false;
	          
			  		if(elseModeStringAppend)
			  		{
			  			sb.append(elseString);
			  			elseModeStringAppend=false;
			  		}
			          
	         
	        } 
	       /* if (ctx.ELSEIF() != null) {
	        	for (Tree2UppaalParser.IfstatementContext IfstmtCtx : ctx.ifstatement()) {
	        		
	        		sb.append(visitIfstatement(IfstmtCtx)).append("\n");
	        	}
	        	
	        }*/
	        
	       /* if (ctx.ELSE() != null) {
	        	
	        	 
	        	idTarget = "id" + locationIdCounterTarget++;
	        	boolean declareAssignmentOnce=true;
	        	
	        	sb.append("    123<transition>\n");
	            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
	            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	            //sb.append("        <label kind=\"guard\">else!=null</label>\n");
	            
	            for (ParseTree child : ctx.children) {
	            	boolean switchAssignmentTagstatementTwo=true;
		            int countIterationForEndLabelTagstatementTwo=0; //System.out.println("***************************************************");
		            
	            	countIterationForEndLabelTagstatementTwo=countIterationForEndLabelTagstatementTwo+1;
	            	//System.out.println(ctx.statementTwo().size()+" ... "+countIterationForEndLabelTagstatementTwo);
	            	if(((child instanceof Tree2UppaalParser.AssignmentContext) || (child instanceof Tree2UppaalParser.FunctioncallContext)) && (switchAssignmentTagstatementTwo) && (declareAssignmentOnce))
	            	{
	            		sb.append("        <label kind=\"assignment\">");
	            		switchAssignmentTagstatementTwo=false;
	            		declareAssignmentOnce=false;
	            	}
	            	
	            	if ((child instanceof Tree2UppaalParser.IfstatementContext))
	            	{
	            		sb.deleteCharAt(sb.length() - 1); 
	            		sb.deleteCharAt(sb.length() - 1); 
	                	sb.append("C</label> \n");
	            	}
	            	cameFromIfStatement=true;
	            	//sb.append(visitStatement(stmtCtx));
	            	if (child instanceof Tree2UppaalParser.CommentContext) {
		                // Process the comment
		                //sb.append(visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
		            } 
		            else if (child instanceof Tree2UppaalParser.AssignmentContext) {
		                // Process the assignment
		                sb.append(visitAssignment((Tree2UppaalParser.AssignmentContext) child));
		            } 
		            else if (child instanceof Tree2UppaalParser.FunctioncallContext) {
		                // Process function call, if any (optional)
		                sb.append(visitFunctioncall((Tree2UppaalParser.FunctioncallContext) child));
		            } 
		            else if (child instanceof Tree2UppaalParser.IfstatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitIfstatement((Tree2UppaalParser.IfstatementContext) child));
		            }
		            else if (child instanceof Tree2UppaalParser.ReturnContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child));
		            }
		            else if (child instanceof Tree2UppaalParser.StatementContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitStatement((Tree2UppaalParser.StatementContext) child));
		            }
		            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
		                // Process if statement, if any (optional)
		            	lastStatement="declaration";
		                sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
		            }
		            else if (child instanceof Tree2UppaalParser.PrintContext) {
		                // Process if statement, if any (optional)
		                //sb.append(visitPrint((Tree2UppaalParser.PrintContext) child)).append("\n");
		            }
		            else if (child instanceof Tree2UppaalParser.SwitchContext) {
		                // Process if statement, if any (optional)
		                sb.append(visitSwitch((Tree2UppaalParser.SwitchContext) child));
		            } 
	                
	                //if(ctx.statement().size()==countIterationForEndLabelTagstatementTwo && (!(child instanceof Tree2UppaalParser.IfstatementContext)))// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
	            	if(child.getText().contains("</if>"))
	            	{
	                	
	                	//sb.deleteCharAt(sb.length() - 1); 
	                	sb.deleteCharAt(sb.length() - 1);
	                	sb.append("D</label> \n");
	                	sb.append("    B</transition> \n");
	            	}
	                //visitStatementTwo(stmtCtx);
	            }
	            
	            //making extra if transition
	            
	            //elseString="";
	           
	        }*/
	        elseModeStringAppend=true;
	    
	        nestedIfModeOn=false;
	        ifTransitionsCount=ifTransitionsCount-1;
    
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch(Tree2UppaalParser.SwitchContext ctx) {
	    	
	        StringBuilder sb = new StringBuilder();
	        /*sb.append("switch (").append(ctx.ID().getText().replace("\"", "")).append(") \n{\n");
	        
	        for (Tree2UppaalParser.Switch_caseContext switchCase : ctx.switch_case()) {
	            sb.append(visit(switchCase));
	        }
	        sb.append("}\n");
	        */
	        
	        
	        switchCondition = ctx.ID().getText().replace("\"", "").replace("<", "&lt;").replace(">", "&gt;");  // Condition for the switch// Condition for the switch

            // Generate the UPPAAL transition for the switch condition
            idTarget = "id" + locationIdCounterTarget++;
            sb.append("    <transition>\n");
            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            sb.append("        <label kind=\"guard\">").append("switch== "+switchCondition).append("</label>\n");
            sb.append("    </transition>\n");

            // Handle each case block and default block
            for (Tree2UppaalParser.Switch_caseContext switchCase : ctx.switch_case()) {
	            sb.append(visit(switchCase));
	            
            }
            sb.append("//SWITCH_STATEMENT_CLOSED\n");
	        return sb.toString();
	    }

	    @Override
	    public String visitSwitch_case(Tree2UppaalParser.Switch_caseContext ctx) {
	    	
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
	        	String caseValue = value;  // Value of the case
	            cameFromCaseStatement=true;
	            // Create transition for each case value
	            idSource = idTarget;
	            idTarget = "id" + locationIdCounterTarget++;
	            sb.append("    <transition>\n");
	            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
	            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	            sb.append("        <label kind=\"guard\">").append(/*"case "*/switchCondition+"=="+caseValue).append("</label>\n");
	            
	            boolean caseAssignmentTagOpen=true;
	            boolean caseAssignmentTagClose=false;
	            int countIterationForEndLabelTag=0;
	            // Visit statements within the case block
	         
	            // Iterate over all children (which can be comments, statements, or declarations)
		        for (ParseTree child : ctx.children) {	
	            	countIterationForEndLabelTag=countIterationForEndLabelTag+1;

	            	if(((child instanceof Tree2UppaalParser.AssignmentContext) || (child instanceof Tree2UppaalParser.FunctioncallContext)) && (caseAssignmentTagOpen) )
	            	{
	            		sb.append("        <label kind=\"assignment\">");
	            		caseAssignmentTagOpen=false;
	            		caseAssignmentTagClose=true;
	            	}
	  
	                //visitStatement(stmtCtx);
	            	
			            if (child instanceof Tree2UppaalParser.CommentContext) {
			                // Process the comment
			                //......sb.append("        "+visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
			            } 
			            else if (child instanceof Tree2UppaalParser.AssignmentContext) {
			                // Process the assignment
			            	//if(((Tree2UppaalParser.AssignmentContext) child).getText().contains("break")) caseAssignmentTagClose=true;
			            	//else
			                sb.append("        "+visitAssignment((Tree2UppaalParser.AssignmentContext) child));
			            } 
			            else if (child instanceof Tree2UppaalParser.FunctioncallContext) {
			                // Process function call, if any (optional)
			                sb.append("        "+visitFunctioncall((Tree2UppaalParser.FunctioncallContext) child));
			            } 
			            else if (child instanceof Tree2UppaalParser.IfstatementContext) {
			                // Process if statement, if any (optional)
			                sb.append("        "+visitIfstatement((Tree2UppaalParser.IfstatementContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.ReturnContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.StatementContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitStatement((Tree2UppaalParser.StatementContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
			                // Process if statement, if any (optional)
			            	lastStatement="declaration";
			                sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.PrintContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitPrint((Tree2UppaalParser.PrintContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.SwitchContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitSwitch((Tree2UppaalParser.SwitchContext) child));
			            }    
	            }
		        if(caseAssignmentTagClose)//ctx.statement().size()==countIterationForEndLabelTag /*&& stmtCtx.ifStatement()==null*/ )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
            	{
                	//sb.deleteCharAt(sb.length() - 1); 
                	sb.deleteCharAt(sb.length() - 1); 
                	sb.deleteCharAt(sb.length() - 1);
                	
                	sb.append("</label>\n");
                	caseAssignmentTagClose=false;
            	} 
		        //sb.deleteCharAt(sb.length() - 2); 
		        //sb.deleteCharAt(sb.length() - 2);
		        //sb.append("**"+sb.substring(sb.length() - 30)+"**");
		        //System.out.println("**"+sb.substring(sb.length() - 30)+"**");
		        //if (!(sb.toString().endsWith("</transition>\n")) || !(sb.toString().endsWith("</transition>")))
	            //if(!sb.substring(sb.length() - 15).contains("</transition>"))  
		        if(doubleTransitionTagCheckInCaseToIf)
		        {
		        	sb.append("    </transition>\n");
		        	doubleTransitionTagCheckInCaseToIf=true;
		        }
		        else
           		 sb.append("\n");
		        
	            cameFromCaseStatement=false;
	            sb.append("//BREAK_STATEMENT\n");
 
	        }
	        else if(switchdefault.contains("default"))
	        {
	        	cameFromCaseStatement=true;
	            // Create transition for each case value
	            idSource = idTarget;
	            idTarget = "id" + locationIdCounterTarget++;
	            sb.append("    <transition>\n");
	            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
	            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	            sb.append("        <label kind=\"guard\">").append("def==1").append("</label>\n");
	            
	            boolean caseAssignmentTagOpen=true;
	            boolean caseAssignmentTagClose=false;
	            int countIterationForEndLabelTag=0;
	            // Visit statements within the case block
	         
	            // Iterate over all children (which can be comments, statements, or declarations)
		        for (ParseTree child : ctx.children) {	
	            	countIterationForEndLabelTag=countIterationForEndLabelTag+1;

	            	if(((child instanceof Tree2UppaalParser.AssignmentContext) || (child instanceof Tree2UppaalParser.FunctioncallContext)) && (caseAssignmentTagOpen))
	            	{
	            		sb.append("        <label kind=\"assignment\">");
	            		caseAssignmentTagOpen=false;
	            		caseAssignmentTagClose=true;
	            	}
	  
	                //visitStatement(stmtCtx);
	            	
			            if (child instanceof Tree2UppaalParser.CommentContext) {
			                // Process the comment
			                //sb.append("        "+visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
			            } 
			            else if (child instanceof Tree2UppaalParser.AssignmentContext) {
			                // Process the assignment
			            	//if(((Tree2UppaalParser.AssignmentContext) child).getText().contains("break")) caseAssignmentTagClose=true;
			            	
			                sb.append("        "+visitAssignment((Tree2UppaalParser.AssignmentContext) child));
			            } 
			            else if (child instanceof Tree2UppaalParser.FunctioncallContext) {
			                // Process function call, if any (optional)
			                sb.append("        "+visitFunctioncall((Tree2UppaalParser.FunctioncallContext) child)+",");
			            } 
			            else if (child instanceof Tree2UppaalParser.IfstatementContext) {
			                // Process if statement, if any (optional)
			                sb.append("        "+visitIfstatement((Tree2UppaalParser.IfstatementContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.ReturnContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.StatementContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitStatement((Tree2UppaalParser.StatementContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
			                // Process if statement, if any (optional)
			            	lastStatement="declaration";
			                sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.PrintContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitPrint((Tree2UppaalParser.PrintContext) child));
			            }
			            else if (child instanceof Tree2UppaalParser.SwitchContext) {
			                // Process if statement, if any (optional)
			                sb.append(visitSwitch((Tree2UppaalParser.SwitchContext) child));
			            } 
			        
			        
	               
	            }
		        if(caseAssignmentTagClose)//ctx.statement().size()==countIterationForEndLabelTag /*&& stmtCtx.ifStatement()==null*/ )// (stmtCtx.assignment()!=null || stmtCtx.functionCall()!=null) && (switchAssignmentTag))
            	{
                	//sb.deleteCharAt(sb.length() - 1); 
                	sb.deleteCharAt(sb.length() - 1); 
                	sb.deleteCharAt(sb.length() - 1);
                	
                	sb.append("</label>\n");
                	caseAssignmentTagClose=false;
            	} 
	            sb.append("    </transition>\n");
	            cameFromCaseStatement=false;
	        


	        	//sb.append("default "+value+":\n	{");
	        	//sb.append("	break; }\n");
	            
	            sb.append("//BREAK_STATEMENT\n");
	        }
	      
	        return sb.toString();
	    }

	    @Override
	    public String visitAssignment(Tree2UppaalParser.AssignmentContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	        String leftAttribute="", operator="", AssignedSide="";

	    	// Handle left-hand side
	        if (ctx.leftAttribute().ID() != null) {
	        	leftAttribute="	"+ctx.leftAttribute().ID().getText().replace("\"", "");
	        } else if (ctx.leftAttribute().STRING() != null) {
	        	leftAttribute="	"+ctx.leftAttribute().STRING().getText().replace("\"", "");
	        }

	        // Handle operator (or empty string)
	        if (ctx.operatorOrEmpty().operator() != null) {
	        	operator="	"+ctx.operatorOrEmpty().operator().getText().replace("\"", "");
	        } 

	        // Handle right-hand side
	        if (ctx.assignedSide().ID() != null) {
	        	AssignedSide="	"+ctx.assignedSide().ID().getText().replace("\"", "").replace("0x0001", "1").replace("'", "\"").replace("16'h0001", "1");
	        } else if (ctx.assignedSide().STRING() != null) {
	        	AssignedSide="	"+ctx.assignedSide().STRING().getText().replace("\"", "").replace("0x0001", "1").replace("'", "\"").replace("16'h0001", "1");
	        } else if (ctx.assignedSide().operator() != null) {
	        	AssignedSide="	"+ctx.assignedSide().operator().getText().replace("\"", "").replace("0x0001", "1").replace("'", "\"").replace("16'h0001", "1");
	        } else {
	        	AssignedSide=""; // Default empty assignment
	        }
	        String assignment = leftAttribute+operator+AssignedSide;
	        //sb.append(";");
	        if(cameFromIfStatement || cameFromCaseStatement)
	        {
	        	//sb.append("        <label kind=\"assignment\">").append(assignment).append("</label>\n");
	            sb.append("  "+assignment+",\n"); 
	        }
	        else
	        {
	        	//idSource = "id" + locationIdCounterSource++;
	            idTarget = "id" + locationIdCounterTarget++;
	            
	            sb.append("    <transition>\n");
		        sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
		        sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
		        sb.append("        <label kind=\"assignment\">").append(assignment).append("</label>\n");
		        sb.append("    </transition>\n");
	        }
	        return sb.toString();
	    }

	    @Override
	    public String visitFunctioncall(Tree2UppaalParser.FunctioncallContext ctx) {
	        
	    	StringBuilder sb = new StringBuilder();
	    	String functionName="", parameterString="";

	        if(ctx.ID(0)!=null) 
	        	functionName=ctx.ID(0).getText().replace("\"", "");
	        
	        if(ctx.STRING()!=null) 
	        	parameterString=ctx.STRING().getText().replace("\"", "");
	        else if(ctx.ID(1)!=null) 
	        	parameterString=ctx.ID(1).getText().replace("\"", "");
	        
	        //sb.append("	"+functionName+" ("+parameterString+" );");
	        
	        //String funcAsAssign = "		"+ctx.ID().getText()+"(";
	        
	        if(cameFromIfStatement || cameFromCaseStatement)
	        {
	        	sb.append("    "+functionName+" ("+parameterString+" ),\n");		        
	        }
	        else
	        {
	            idTarget = "id" + locationIdCounterTarget++;
	            
	            sb.append("    <transition>\n");
		        sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
		        sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
		        sb.append("        <label kind=\"assignment\">").append("	"+functionName+" ("+parameterString+" )");
		        
		        // Visit and concatenate  parameter list if present
		        /*if (ctx.argumentList() != null) {
		            visitArgumentList(ctx.argumentList());
		        }
		        sb.append(")");*/
		        sb.append("</label>\n");
		        sb.append("    </transition>\n");
	        }

	        return sb.toString();
	    }
	    
	    @Override
	    public String visitReturn(Tree2UppaalParser.ReturnContext ctx) {
	    	idTarget = "id" + locationIdCounterTarget++;
	    	
	    	StringBuilder result = new StringBuilder();
	    	String expression="";
	    	if (ctx.ID() != null) expression=ctx.ID().getText();
	    	else if (ctx.NUMBER() != null) expression=ctx.NUMBER().getText();
	    	
	    	result.append("    <transition>\n");
	    	result.append("        <source ref=\"").append(idSource).append("\"/>\n");
	    	result.append("        <target ref=\"").append(idTarget).append("\"/>\n");
	    	result.append("        <label kind=\"assignment\">");
	    	result.append("return=");
	        //outputBuilder.append(" = ");
	        //visit(ctx.expression());
	        result.append(expression);
	        //visit(expression);
	        result.append("</label>\n");
	        result.append("    </transition>\n");
	       
	        //result.append("  return "+expression+";");
	           
	        return result.toString();
	    }
	    
	    @Override
	    public String visitLoop(Tree2UppaalParser.LoopContext ctx) {
	    	
	    	StringBuilder sb = new StringBuilder();
	    	
	    	String loopType="";//ctx.FOR().getText();
	    	if (ctx.FOR() != null) 
	    		loopType=ctx.FOR().getText();
	    	else if (ctx.FOR_VOLATILE() != null) 
	    		loopType=ctx.FOR_VOLATILE().getText();
	    	else if (ctx.WHILE() != null) 
	    		loopType=ctx.WHILE().getText();
	    	
	    	loopType=loopType.replace("\"", "");
	    	//System.out.println("inside loop");
	    	cameFromForLoop=true;
	        String init = ctx.expression(0).getText();  // Initialization part of the loop
	        String condition = ctx.expression(1).getText().replace("<", "&lt;").replace(">", "&gt;");  // Condition part of the loop // Condition part of the loop
	        String increment = "";
	        
	        if(ctx.expression(2)!=null)
	        	increment=ctx.expression(2).getText();  // Increment part of the loop
	        
	        //condition=condition.replace("&lt;", "<");

	        // Create transition for loop initialization
	        // Create transition for loop initialization
            idTarget = "id" + locationIdCounterTarget++;
            String guardSourceTarget=idTarget;
            sb.append("//FOR_LOOP_OPEN\n");
            // For loop initialization assignment
            
            sb.append("    <transition>\n");
            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            sb.append("        <label kind=\"assignment\">").append(init).append("</label>\n");
            sb.append("    </transition>\n");
            
            idTarget = "id" + locationIdCounterTarget++;
            sb.append("    <transition>\n");
            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
            sb.append("        <label kind=\"guard\">").append(condition).append("</label>\n");
            sb.append("        <label kind=\"assignment\">").append(increment).append("</label>\n");
            sb.append("    </transition>\n");
            
            
	        /*if(loopType.equals("for"))
	        	result.append("  "+loopType+" (").append(visitDataTypes(ctx.dataTypes())+" "+init+"; ");
	        else if(loopType.equals("for volatile"))
	        	result.append("  for (volatile ").append(visitDataTypes(ctx.dataTypes())+" "+init+"; ");
				*/
	        //result.delete(result.length() - 1, result.length()); // remove '\n' from the end
	        //...result.append(condition+"; ");
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        //.........result.append(increment);
	        //result.delete(result.length() - 2, result.length()); // remove '\n' from the end
	        //........result.append(") {\n");
	        //result.append(visit(ctx.statement())).append("\n");
	        
	        
	        // Loop condition and body transitions
	      

	        // Visit the loop body
            idSource = idTarget;  // Update source for loop body
	     // Iterate over all children (which can be comments, statements, or declarations)
	        for (ParseTree child : ctx.children) {
	            if (child instanceof Tree2UppaalParser.CommentContext) {
	                // Process the comment
	            	sb.append(visitComment((Tree2UppaalParser.CommentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2UppaalParser.AssignmentContext) {
	                // Process the assignment
	            	
	            	sb.append(visitAssignment((Tree2UppaalParser.AssignmentContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2UppaalParser.FunctioncallContext) {
	                // Process function call, if any (optional)
	            	sb.append(visitFunctioncall((Tree2UppaalParser.FunctioncallContext) child)).append("\n");
	            } 
	            else if (child instanceof Tree2UppaalParser.IfstatementContext) {
	                // Process if statement, if any (optional)
	            	sb.append(visitIfstatement((Tree2UppaalParser.IfstatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.ReturnContext) {
	                // Process if statement, if any (optional)
	            	sb.append(visitReturn((Tree2UppaalParser.ReturnContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.StatementContext) {
	                // Process if statement, if any (optional)
	            	sb.append(visitStatement((Tree2UppaalParser.StatementContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.DeclarationContext) {
	                // Process if statement, if any (optional)
	            	lastStatement="declaration";
	            	sb.append(visitDeclaration((Tree2UppaalParser.DeclarationContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.PrintContext) {
	                // Process if statement, if any (optional)
	            	sb.append(visitPrint((Tree2UppaalParser.PrintContext) child)).append("\n");
	            }
	            else if (child instanceof Tree2UppaalParser.SwitchContext) {
	                // Process if statement, if any (optional)
	            	sb.append(visitSwitch((Tree2UppaalParser.SwitchContext) child)).append("\n");
	            }
	        }
	        
	        /*if(increment!=null)
            {
			     // Loop increment and closing transitions
		            idTarget = "id" + locationIdCounterTarget++;
		            sb.append("    <transition>\n");
		            sb.append("        <source ref=\"").append(idSource).append("\"/>\n");
		            sb.append("        <target ref=\"").append(idTarget).append("\"/>\n");
		            sb.append("        <label kind=\"assignment\">").append(increment).append("</label>\n");
		            sb.append("    </transition>\n");
            }*/
            
         // Loop getting back to check guard transition
            sb.append("    <transition>\n");
            sb.append("        <source ref=\"").append(idTarget).append("\"/>\n");
            sb.append("        <target ref=\"").append(guardSourceTarget).append("\"/>\n");
            sb.append("    </transition>\n");
            
            sb.append("//FOR_LOOP_CLOSE\n");
            
            cameFromForLoop=false;
	 
	        return sb.toString();
	    }

	    @Override
	    public String visitExpression(Tree2UppaalParser.ExpressionContext ctx) {
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
	    public String visitComment(Tree2UppaalParser.CommentContext ctx) {
	    	//System.out.println("comment found");
	    	StringBuilder sb = new StringBuilder();
	    	
	    	// Get the text of the comment
            String commentText = ctx.STRING().getText().replace("\"", "");

            // Check if it's a single-line or multi-line comment
            if (cameFromDeclaration)
            {
	            if (commentText.startsWith("//")) {
	                // Single-line comment
	                sb.append("    // ").append(commentText.substring(2).trim()).append(" ");
	            } else if (commentText.startsWith("/*")) {
	                // Multi-line comment
	                sb.append("    // ").append(commentText.substring(2, commentText.length() - 2).trim()).append(" \n");
	            }
            }
            else
            {
	            if (commentText.startsWith("//")) {
	                // Single-line comment
	                sb.append("    <!-- ").append(commentText.substring(2).trim()).append(" --> ");
	            } else if (commentText.startsWith("/*")) {
	                // Multi-line comment
	                sb.append("    <!-- ").append(commentText.substring(2, commentText.length() - 2).trim()).append("--> \n");
	            }
            }
            
	        return sb.toString()+"\n";// "	// " + ctx.STRING().getText().replace("\"", "") ; // Convert comment to C-style comment
	    }

	    @Override
	    public String visitPrint(Tree2UppaalParser.PrintContext ctx) {
	    	StringBuilder sb = new StringBuilder();
	    	String printStatement=ctx.STRING().getText().replace("*", "\"");
	    	printStatement=printStatement.substring(1, printStatement.length()-1);
	    	
	    	if (printStatement.startsWith("$display"))
	    		printStatement=printStatement.replace("$display", "printf");
	    	//System.out.println(sb.toString());
	    	//if (!(sb.toString().endsWith(",")))
        		//sb.deleteCharAt(sb.length() - 1);
        		
        	//if (ctx.argument()!=null)
        		//sb.append(ctx.argument());
        	
        	
        	if (cameFromDeclaration)
        	sb.append("    // "+printStatement);
        	else
        	sb.append("    <!-- "+printStatement);

            //if (ctx.argumentList() != null) {
            //    visitArgumentList(ctx.argumentList());
            //}

            if (cameFromDeclaration)
            sb.append(" \n");
            else
            sb.append(" --> \n");
            
	        return sb.toString(); // Example placeholder for print statements
	   
	    }

	    @Override
	    public String visitDataTypes(Tree2UppaalParser.DataTypesContext ctx) {
	    	StringBuilder sb = new StringBuilder();
	    	switch (ctx.getText().replace("\"", "")) {
		    	case "int":
	            	sb.append( "int"); break;
	            case "uint8_t":
	            	sb.append( "int");break;
	            case "uint32_t":
	            	sb.append( "int");break;
	            case "TickType_t":
	            	sb.append( "int");break;
	            case "osThreadId":
	            	sb.append( "int");	break;
	            case "float":
	            	sb.append( "double"); break;   
	            case "double":
	            	sb.append( "double"); break;
	            case "char":
	            	sb.append( "int");break;
	            case "osEvent":
	            	sb.append( "int");	break;
	            case "void":
	            	sb.append( "void");	break;
	            default:
	            	sb.append( "int"); break; // Default to int for unsupported types
		    	}   
	        return sb.toString(); // Return data type as is
	    }

	    @Override
	    public String visitOperator(Tree2UppaalParser.OperatorContext ctx) {
	        return ctx.getText(); // Return operator as is
	    }


}