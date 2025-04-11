package GUIEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Executor {
	
	
	public Executor()
	{
	}
	
	
	public void execute(String last_path, String code_package, String code_path, String s_main)
	{
		
		String selected_main = s_main;
		selected_main=selected_main.substring(0, (selected_main.length()-5));
		
		
		//Runtime runtime=Runtime.getRuntime();
		
		try
		{			
			//file writing for batch file	
			
			File executables=new File(last_path+"\\Executables");
			BufferedWriter bw=new BufferedWriter(new FileWriter(executables+"\\exe.bat"));
			
			String str="set CLASSPATH="+last_path+"\\Java Code";
			bw.write(str);
			bw.newLine();
			
			str="set PATH=C:\\JBuilder2007\\jre\\bin";
			bw.write(str);
			bw.newLine();
			
			str="cd "+code_path;
			bw.write(str);
			bw.newLine();
			
			
			
			
			str="javac "+selected_main+".java";
			bw.write(str);
			bw.newLine();
			
			
			str="java "+code_package+"."+selected_main+">"+executables+"\\LOG";
			bw.write(str);
			bw.newLine();
			
			str="exit";
			bw.write(str);
			bw.newLine();
			
			
			bw.close();
			
			//runtime.exec("cmd /c start /MIN "+executables+"\\exe.bat");
			
			
			for(int i=0; i<50000; i++)
			{
				String file_path=last_path+"\\Java Code\\"+selected_main;
				
					 try
					{
						FileReader input=new FileReader(file_path);
						BufferedReader bufRead=new BufferedReader(input);
						String line;
						int count=0;
						line=bufRead.readLine();		
						count++;
						String filelines="";
						
						while(line!=null)
						{  				
							
							filelines+="   "+line+"\n";
							line=bufRead.readLine();
							count++;
						
						}//end while
						
						
						bufRead.close();
					}//end try
			   	
					catch(ArrayIndexOutOfBoundsException eb)
					{
					//	System.out.println(eb);
						
					}//end catch
					
					catch(IOException ee)
					{
						//System.out.println(ee);
					}//end catch

			}
			
			String log_path=executables+"\\LOG";
			String my_file=BME.getInstance().open_file(log_path);
			GUI_Handler.getInstance().setText(my_file);
		}
		
		
		catch(Exception ee)
		{
			System.out.println(ee);
		}


	}


}
