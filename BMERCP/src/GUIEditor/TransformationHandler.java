package GUIEditor;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;

import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import C2SystemVerilogTransformations.CParserAppSystemVerilog;
import C2TreeTransformations.CParserAppTree;
import C2UppaalTransformations.CParserAppUppaal;
import SystemVerilog2CTransformation.SystemVerilogParserAppC;
import SystemVerilog2TreeTransformation.SystemVerilogParserAppTree;
import SystemVerilog2UppaalTransformation.SystemVerilogParserAppUppaal;
import Tree2CTransformation.TreeParserAppC;
import Tree2SystemVerilogTransformation.TreeParserAppSystemVerilog;
import Tree2UppaalTransformation.TreeParserAppUppaal;
/*import TreeTransformations.AcceleoLauncher;
import Uppaal2CTransformation.*;
import C2SystemVerilogTransformation.*;
import C2TreeTransformation.CToTree;
import Uppaal2TreeEditorTransformation.*;
import Uppaal2VerilogTransformation.Uppaal2VerilogTransformer;
*/
import Uppaal2CTransformations.UppaalParserAppC;
import Uppaal2SystemVerilogTransformations.UppaalParserAppSystemVerilog;
import Uppaal2TreeTransformations.UppaalParserAppTree;

public class TransformationHandler {
	

	
	
	public TransformationHandler()
	{	
	}
	
	public boolean saveWorkspace(String ChangeLanguageFlag, String CText, String UppaalText, String SystemVerilogText, String CFilePath, String UppaalFilePath, String SystemVerilogFilePath, String TreeEditorFilePath)
	{
		System.out.println("ChangeLanguageFlag: "+ChangeLanguageFlag);
		SystemVerilogFilePath=SystemVerilogFilePath.substring(1);
		CFilePath=CFilePath.substring(1);
		UppaalFilePath=UppaalFilePath.substring(1);
		TreeEditorFilePath=TreeEditorFilePath.substring(1);
		try
		{		
			if (ChangeLanguageFlag=="C")
			{
				//C Transformations
				//Save C as it is and save Uppaal after running C->Uppaal transformation
				
				System.out.println("C transformations");
				BufferedWriter bwC=new BufferedWriter(new FileWriter(CFilePath));
				bwC.write(CText);
				bwC.close();
			
				/*String[] strFileC2TA = {CFilePath, UppaalFilePath};
				CParser.main(strFileC2TA);
				System.out.println("CTOTA DONE");*/  //JavaCC Implementation
				
				String[] strFileC2TA = {CFilePath, UppaalFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				CParserAppUppaal.main(strFileC2TA);			
				System.out.println("CTOTA DONE");
				
				/*String[] strFileC2SV = {CFilePath, SystemVerilogFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				CToSystemVerilog.main(strFileC2SV);
				System.out.println("CTOSV DONE");*/
				
				String[] strFileC2SV = {CFilePath, SystemVerilogFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				CParserAppSystemVerilog.main(strFileC2SV);
				System.out.println("CTOSV DONE");
				
				/*String[] strFileC2Tree = {CFilePath, TreeEditorFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				CToTree.main(strFileC2Tree);*/
				String[] strFileC2Tree = {CFilePath, TreeEditorFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				CParserAppTree.main(strFileC2Tree);	
				System.out.println("CTOTREE DONE");
		
				//*/
			}
			else if (ChangeLanguageFlag=="SV")
			{
				System.out.println("SV transformations");
				//SystemVerilog Transformations
				//Save C as it is and save Uppaal after running C->SystemVerilog transformation
				BufferedWriter bwC=new BufferedWriter(new FileWriter(SystemVerilogFilePath));
				bwC.write(SystemVerilogText);
				bwC.close();
				System.out.println("SV-SAVED");
				
				//System.out.println("SystemVerilogFilePath: "+SystemVerilogFilePath);
				//System.out.println("CFilePath: "+CFilePath);
				String[] strFileSV2C = {SystemVerilogFilePath, CFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				SystemVerilogParserAppC.main(strFileSV2C);
				System.out.println("SV2C-DONE");
				String[] strFileSV2TA = {SystemVerilogFilePath, UppaalFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				SystemVerilogParserAppUppaal.main(strFileSV2TA);
				System.out.println("SV2U-DONE");
				String[] strFileSV2Tree = {SystemVerilogFilePath, TreeEditorFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				SystemVerilogParserAppTree.main(strFileSV2Tree);
				System.out.println("SV2T-DONE");
				//*/
			}
			else if (ChangeLanguageFlag=="TA")
			{
				System.out.println("TA transformations");
				//Uppaal Transformations
				//Save Uppaal as it is and save C after running Uppaal->C transformation
				
				BufferedWriter bwU=new BufferedWriter(new FileWriter(UppaalFilePath));
				bwU.write(UppaalText);
				bwU.close();
				
				//Uppaal2CTransformer.transformUppaal2C(CFilePath, UppaalFilePath);	System.out.println("U2C-DONE");
				//Uppaal2TreeEditorTransformer.transformUppaal2TreeEditor(TreeEditorFilePath, UppaalFilePath);	System.out.println("U2T-DONE");
				//Uppaal2VerilogTransformer.transformUppaal2Verilog(SystemVerilogFilePath, UppaalFilePath); System.out.println("U2SV-DONE");
				
				
				String[] strFileSV2C = {UppaalFilePath, CFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				UppaalParserAppC.main(strFileSV2C);
				System.out.println("U2C-DONE");
				String[] strFileSV2TA = {UppaalFilePath, SystemVerilogFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				UppaalParserAppSystemVerilog.main(strFileSV2TA);
				System.out.println("U2SV-DONE");
				String[] strFileSV2Tree = {UppaalFilePath, TreeEditorFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				UppaalParserAppTree.main(strFileSV2Tree);
				System.out.println("U2T-DONE");
	
			}
			if (ChangeLanguageFlag=="TREE")
			{
				System.out.println("TREE transformations");
				//TreeEditor Transformations
				//Save Tree Editor as it is and save C after running TreeEditor->C transformation
				
				/*Bundle bundle = Platform.getBundle("BMERCP");
			    String TApath = "resources/input";
			    URL TAfileURL = bundle.getEntry(TApath);
			    System.out.println("TAfileURL: "+TAfileURL);
				String TreeTransformationOutputPath=FileLocator.toFileURL(TAfileURL).getPath();
				
				System.out.println("TreeEditorFilePath : "+TreeEditorFilePath);
				System.out.println("TreeTransformationOutputPath : "+TreeTransformationOutputPath);
				*/
				//String[] strFileTreeTransformations = {TreeEditorFilePath, TreeTransformationOutputPath};
				//"E:\\EclipseWorkspaces\\GUIProjectWorkSpace\\BlendedModellingEnvironment\\"}; 
				// second argument is the path where transformed files will be saved
				//AcceleoLauncher.main(strFileTreeTransformations);
				String[] strFileSV2C = {TreeEditorFilePath, CFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				TreeParserAppC.main(strFileSV2C);
				System.out.println("TREE2C-DONE");
				String[] strFileSV2TA = {TreeEditorFilePath, SystemVerilogFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				TreeParserAppSystemVerilog.main(strFileSV2TA);
				System.out.println("TREE2SV-DONE");
				String[] strFileSV2Tree = {TreeEditorFilePath, UppaalFilePath}; // verilog output file where code is generated "VerilogCode.txt"
				TreeParserAppUppaal.main(strFileSV2Tree);
				System.out.println("TREE2UPPAAL-DONE");
				
			}
		}
		catch(Exception e)
		{System.out.println(e);}	
		
		return true;
		
	}

}
