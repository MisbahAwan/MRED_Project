package GUIEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;

public class Project_Manager {

	
	public Project_Manager()
	{	
	}
	
		
	
	
	 public String open_file(String file_path)
	 {
		 String filelines="ERROR:\n\tEither no file has been selected \tOR \n\tThe selected file contains unsupported content\n\n\tPlease select ERROR FREE correct file.";
		 
		 try
		{
			FileReader input=new FileReader(file_path);
			BufferedReader bufRead=new BufferedReader(input);
			String line;
			int count=0;
			line=bufRead.readLine();		
			count++;
			filelines="";
			
			while(line!=null)
			{  				
				
				filelines+=line+"\n";
				line=bufRead.readLine();
				count++;
			
			}//end while
			
			
			bufRead.close();
		}//end try
   	
		catch(ArrayIndexOutOfBoundsException eb)
		{
			System.out.println(eb);
			
		}//end catch
		
		catch(IOException ee)
		{
			System.out.println(ee);
		}//end catch
		
		return filelines;
		
	 }//end read_project_file method

	 
	 
	 public File create_new_project(String project_name)
	 { 
	 
		File bme=new File("c:\\BME");
		File fp=new File(bme+"\\"+project_name);
		File xmiUppaal=new File(fp+"\\Uppaal");
		File c=new File(fp+"\\C Code");
		File tree=new File(fp+"\\Tree");
		File verilog=new File(fp+"\\Verilog");
		bme.mkdir();
		fp.mkdir();
		xmiUppaal.mkdir();
		c.mkdir();
		tree.mkdir();
		verilog.mkdir();
		
		
		File xmiUppaal_file=new File("c:\\BME\\"+project_name+"\\Uppaal");
		File c_code_file=new File("c:\\BME\\"+project_name+"\\C Code");
		File tree_file=new File("c:\\BME\\"+project_name+"\\Tree");
		File verilog_file=new File("c:\\BME\\"+project_name+"\\Verilog");
		
		try
		{
		  
			BufferedWriter bw1=new BufferedWriter(new FileWriter(xmiUppaal_file+"\\BME File_8956_Uppaal"));
			bw1.write("This is an @uto-generated Uppaal file by BME application _ 8956");
			bw1.close();
			
			BufferedWriter bw3=new BufferedWriter(new FileWriter(c_code_file+"\\BME File_3332_C"));
			bw3.write("This is an @uto-generated C Code file by BME application _ 3332");
			bw3.close();
			
			BufferedWriter bw4=new BufferedWriter(new FileWriter(tree_file+"\\BME File_1100_Tree"));
			bw4.write("This is an @uto-generated Tree file by BME application _ 1100");
			bw4.close();
			
			BufferedWriter bw2=new BufferedWriter(new FileWriter(verilog_file+"\\BME File_1100_Verilog"));
			bw2.write("This is an @uto-generated Verilog file by BME application _ 1100");
			bw2.close();
			
		}
		catch(Exception e)
		{System.out.println(e);}

		return fp;
		
	 }
		
	 
	 
	 
	 public boolean delete_project(File project_path)
	 {
		 
		 if(project_path.isDirectory())
		 {
			 String[] children=project_path.list();
			 for(int i=0;i<children.length;i++)
			 {
				 boolean success=delete_project(new File(project_path,children[i]));
				 if(!success)
				 return false;
			 }//end for
		 }//end if
		 return project_path.delete();
	 }//end delete_project method
	
	
}