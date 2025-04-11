package GUIEditor;


import java.io.*;



public class BME {
	
	private static BME me=new BME();
	
	private Project_Manager pm=new Project_Manager();
	
	private TransformationHandler th=new TransformationHandler();
	
	
	
	public static BME getInstance()
	{
	   if ( me == null )
	      me = new BME();
	   
	   return me;
	}

	
	public boolean saveWorkspace(String ChangeLanguageFlag, String CText, String UppaalText, String SystemVerilogText, String CFilePath, String UppaalFilePath, String SystemVerilogFilePath, String TreeEditorFilePath)
	{
		return th.saveWorkspace(ChangeLanguageFlag, CText, UppaalText, SystemVerilogText, CFilePath, UppaalFilePath, SystemVerilogFilePath, TreeEditorFilePath);
	}
	
	
	public String open_file(String file_path)
	{
		return pm.open_file(file_path);
	}
	
	
	
	
	
	public File create_new_project(String project_name)
	{
		return pm.create_new_project(project_name);
	}
	
	
	
	
	
	public String import_xmi_file(String file_path)
	 {
		String str = pm.open_file(file_path);
		System.out.println("File Imported");
		
		/* try
		 {	
			 ClassDiagramParser cp = new ClassDiagramParser(file_path);
			 cp.parse();
		
			 System.out.println("Class Diagram Parsing Complete");
		
			 SMParser sm = new SMParser(file_path, 2);
			 sm.populateStateMachineDiagram();
			 
			 System.out.println("State Machine Parsing Complete");
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
			 return e.toString();
		 }*/
		 
		 return str;
		
	 }
	

	
	
	
	
	 public boolean delete_project(File project_path)
	 {
		 return pm.delete_project(project_path);
	 }
	 
	 	 
	
	 
	 
	 
	 
	 
	/* public void generateCode(String path)
	 {
		 
		StateMachineClass sm = SMParser.getParsedStateMachine();
		SMCompiler smcompiler= new SMCompiler();
		
		String pack = smcompiler.getPackage(sm);
		
		ClassCompiler ccompiler = new ClassCompiler();
		ccompiler.compile(ClassDiagramParser.v, path, pack);
		 
		smcompiler.generateCode(sm, path); 
		System.out.println("\n\n*** CODE GENERATED ***");
	 }
	 
	 */
	 
	 
	 
	 
	 
	 
		public void execute(String last_path, String code_package, String code_path, String s_main)
		{
			Executor ex = new Executor();
			ex.execute(last_path, code_package, code_path, s_main);
		}

}
