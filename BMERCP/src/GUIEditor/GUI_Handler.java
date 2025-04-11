package GUIEditor;
//import C2Uppaal.C2UppaalTransformation.CParser;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax .swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.awt.Frame;
import java .awt.FileDialog;
import java.awt.FlowLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class GUI_Handler extends JFrame {
	
	/*String UppaalFilePath="Start_VCVmode_.xml";
	String CFilePath="Start_VCVmode.txt";
	String VerilogFilePath="VerilogCode.txt";
	String  DSMLTreeFile="TreeEditor.dsml";*/ 
	///BMERCP/resources/input/ta.txt
    //java.net.URL imgURL = getClass().getResource(path);
	
	 // Locate the file in the bundle
    Bundle bundle = Platform.getBundle("BMERCP");
    String TApath = "resources/input/ta.txt";
    URL TAfileURL = bundle.getEntry(TApath); 
	String UppaalFilePath=FileLocator.toFileURL(TAfileURL).getPath();
	
	String Cpath = "resources/input/c.txt";
    URL CfileURL = bundle.getEntry(Cpath);
	String CFilePath=FileLocator.toFileURL(CfileURL).getPath();
	
	String SVpath = "resources/input/sv.txt";
    URL SVfileURL = bundle.getEntry(SVpath);
	String VerilogFilePath=FileLocator.toFileURL(SVfileURL).getPath();
	
	String Treepath = "resources/input/tree.txt";
    URL TreefileURL = bundle.getEntry(Treepath);
	String DSMLTreeFile=FileLocator.toFileURL(TreefileURL).getPath();
	
	
	
	//String VerilogFilePath="\\input\\sv.txt";
	//String  DSMLTreeFile="/input/tree.txt";
	
	/*String UppaalFilePath="E:\\\\EclipseWorkspaces\\\\GUIProjectWorkSpace\\\\BMERCP\\\\resources\\\\input\\\\ta.txt";
	String CFilePath="E:\\\\EclipseWorkspaces\\\\GUIProjectWorkSpace\\\\BMERCP\\\\resources\\\\input\\\\c.txt";
	String VerilogFilePath="E:\\\\EclipseWorkspaces\\\\GUIProjectWorkSpace\\\\BMERCP\\\\resources\\\\input\\\\sv.txt";*/
	//String  DSMLTreeFile="E:\\EclipseWorkspaces\\GUIProjectWorkSpace\\BMERCP\\resources\\input\\tree.txt";
	
	//E:\EclipseWorkspaces\GUIProjectWorkSpace\BMERCP\resources\input\tree.txt
	
	String ChangeLanguageFlag=""; // {TA, C, SV, TREE}
	
	JSeparator jsp_new=new JSeparator();
	JSeparator jsp_open=new JSeparator();
	
	JSeparator jsp_import=new JSeparator();
	JSeparator jsp_generate=new JSeparator();
	
	JSeparator jsp_ME=new JSeparator();
	
	Border border=new LineBorder(new Color(0,0,255));  
	
	static String last_path=null;  //  @jve:decl-index=0:
	String[] opened_files= new String[30];
	int file_count=0;
	
	ImageIcon me_icon = loadIcon("/resources/icons/bme.jpg");//new ImageIcon("icons/bme.jpg");  //  @jve:decl-index=0:
	String filelines="";  //  @jve:decl-index=0:
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu_File = null;
	private JSplitPane jSplitPane_Vertical = null;
	private JPanel jPanel_Middle = null;
	private JSplitPane jSplitPane_Left = null;

	private JSplitPane jSplitPane_Right = null;
	private JSplitPane jSplitPane_Center = null;
	private JSplitPane jSplitPane_Tree = null;
	private JSplitPane jSplitPane_C = null;
	private JSplitPane jSplitPane_Uppaal = null;
	private JSplitPane jSplitPane_VerticalTreeAndProperties = null;
	

	private JTabbedPane jTabbedPane_South = null;
	private JScrollPane jScrollPane_South = null;
	private JTextArea jTextArea_South = null;
	private JTabbedPane jTabbedPane_West = null;
	private JScrollPane jScrollPane_West = null;

	private JTree jTree_West = null;
	private JTabbedPane jTabbedPane_East = null;
	private JScrollPane jScrollPane_East = null;
	private JTree jTree_East = null;
	private JTabbedPane jTabbedPane_Project = null;
	private JScrollPane jScrollPane_Project = null;
	private JTree jTree_Project = null;

	private JTabbedPane jTabbedPane_Center = null;
	private JTabbedPane jTabbedPane_Tree = null;
	private JTabbedPane jTabbedPane_C = null;
	private JTabbedPane jTabbedPane_Uppaal = null;
	private JTabbedPane jTabbedPane_Verilog = null;

	private JScrollPane jScrollPane_Center = null;
	private JScrollPane jScrollPane_Tree = null;
	private JScrollPane jScrollPane_Uppaal = null;
	private JScrollPane jScrollPane_C = null;
	private JScrollPane jScrollPane_Verilog = null;

	private JTextArea jTextArea_Center = null;
	private JTextArea jTextArea_Tree = null;
	private JTextArea jTextArea_C = null;
	private JTextArea jTextArea_Uppaal = null;
	private JTextArea jTextArea_Verilog = null;

	private JToolBar jJToolBar = null;
	private JButton jB_New = null;
	private JButton jB_Open = null;
	private JButton jB_Close = null;
	private JButton jB_Delete = null;
	private JButton jB_Import = null;
	private JButton jB_Generate = null;
	private JButton jB_Execute = null;
	private JButton jB_Help = null;
	private JButton jB_Save = null;

	private JMenuItem jMI_New = null;
	private JMenuItem jMI_Open = null;
	private JMenuItem jMI_Close = null;
	private JMenuItem jMI_Delete = null;
	private JMenuItem jMI_Exit = null;

	private JMenu jMenu_Edit = null;
	private JMenuItem jMI_Import = null;
	private JMenuItem jMI_Generate = null;
	private JMenuItem jMI_Execute = null;

	private JMenu jMenu_Help = null;
	private JMenuItem jMI_ME = null;
	private JMenuItem jMI_Us = null;
	private JMenuItem jMI_CloseFile = null;
	private JButton jB_CloseFile = null;
	private JButton jB_AboutUs = null;
	
	private static GUI_Handler thisClass;
	JTree XMLTree=null;
	
	private JTree treeRepresentation;
	private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private JPanel propertiesPanel;
    private Document xmlDocument;
    private File xmlFile;
    private JTextField[] propertyFields = new JTextField[10];
    private JTextField[] valueFields = new JTextField[10];
    private DefaultMutableTreeNode currentNode;
    private boolean isUpdatingProperties = false;
    private Map<JTextField, DocumentListener> listenersMap = new HashMap<>();
    private JScrollPane propertiesScrollPane;
    private JPanel buttonPanel;
    private JLabel propertyLabel;  
    private JLabel valueLabel;
	
	public static GUI_Handler getInstance() throws Exception
	{
		if(thisClass==null)
			thisClass = new GUI_Handler();
		
		
		
		return thisClass;
	}
		
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	public JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu_File());
			jJMenuBar.add(getJMenu_Edit());
			jJMenuBar.add(getJMenu_Help());
			jJMenuBar.setBorder(new LineBorder(new Color(192, 192, 192)));
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu_File	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_File() {
		if (jMenu_File == null) {
			jMenu_File = new JMenu();
			
			jMenu_File.setText("File");
			jMenu_File.setMnemonic('F');
			jMenu_File.add(getJMI_New());
			jMenu_File.add(getJMI_Close());
			jMenu_File.add(getJMI_Delete());
			jMenu_File.add(jsp_new);
			
			jMenu_File.add(getJMI_Open());
			jMenu_File.add(getJMI_CloseFile());
			jMenu_File.add(jsp_open);
					
			jMenu_File.add(getJMI_Exit());
			
		}
		return jMenu_File;
	}

	/**
	 * This method initializes jSplitPane_Vertical	
	 * 	
	 * @return javax.swing.JSplitPane	
	 * @throws Exception 
	 */
	private JSplitPane getJSplitPane_Vertical() throws Exception {
		if (jSplitPane_Vertical == null) {
			jSplitPane_Vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			jSplitPane_Vertical.setTopComponent(getJPanel_Middle());
			jSplitPane_Vertical.setBottomComponent(getJTabbedPane_South());
			
		}
		return jSplitPane_Vertical;
	}

	/**
	 * This method initializes jPanel_Middle	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws Exception 
	 */
	private JPanel getJPanel_Middle() throws Exception {
		if (jPanel_Middle == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.weightx = 1.0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.weightx = 1.0;
			jPanel_Middle = new JPanel();
			jPanel_Middle.setLayout(new GridBagLayout());
			jPanel_Middle.add(getJSplitPane_Right(), gridBagConstraints);
			jPanel_Middle.add(getJTabbedPane_South(), gridBagConstraints1);
		}
		return jPanel_Middle;
	}
	


	/**
	 * This method initializes jSplitPane_Left	
	 * 	
	 * @return javax.swing.JSplitPane	
	 * @throws Exception 
	 */
	private JSplitPane getJSplitPane_Left() throws Exception {
		if (jSplitPane_Left == null) {
			jSplitPane_Left = new JSplitPane();
			jSplitPane_Left.setLeftComponent(getJSplitPane_Right());
			//jSplitPane_Left.setRightComponent(getJTabbedPane_East());
			//jSplitPane_Left.setRightComponent(getJTabbedPane_East());
		}
		return jSplitPane_Left;
	}
	

	/**
	 * This method initializes jSplitPane_Right	
	 * 	
	 * @return javax.swing.JSplitPane	
	 * @throws Exception 
	 */
	private JSplitPane getJSplitPane_Right() throws Exception {
		if (jSplitPane_Right == null) {
			jSplitPane_Right = new JSplitPane();
			//jSplitPane_Right.setLeftComponent(getJTabbedPane_West());
			jSplitPane_Right.setLeftComponent(null);
			jSplitPane_Right.setRightComponent(getJSplitPane_Tree());
///			jSplitPane_Right.setRightComponent(getJTabbedPane_Center());

		}
		return jSplitPane_Right;
	}
	/*private JSplitPane getJSplitPane_Center() throws Exception {
		if (jSplitPane_Center == null) {
			jSplitPane_Center = new JSplitPane();
			jSplitPane_Center.setLeftComponent(getJTabbedPane_Center());
			jSplitPane_Center.setRightComponent(getJSplitPane_Tree());
		}
		return jSplitPane_Center;
	}*/
	private JSplitPane getJSplitPane_VerticalTreeAndProperties() throws Exception {
		if (jSplitPane_VerticalTreeAndProperties == null) {
			jSplitPane_VerticalTreeAndProperties = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			jSplitPane_VerticalTreeAndProperties.setTopComponent(getJTabbedPane_Tree());
			jSplitPane_VerticalTreeAndProperties.setBottomComponent(getJTabbedPane_East());
			
		}
		return jSplitPane_VerticalTreeAndProperties;
	}
	private JSplitPane getJSplitPane_Tree() throws Exception {
		if (jSplitPane_Tree == null) {
			jSplitPane_Tree = new JSplitPane();
			//jSplitPane_Tree.setLeftComponent(getJTabbedPane_Tree());
			jSplitPane_Tree.setLeftComponent(getJSplitPane_VerticalTreeAndProperties());
			jSplitPane_Tree.setRightComponent(getJSplitPane_Uppaal());
		}
		return jSplitPane_Tree;
	}
	private JSplitPane getJSplitPane_Uppaal() {
		if (jSplitPane_Uppaal == null) {
			jSplitPane_Uppaal = new JSplitPane();
			jSplitPane_Uppaal.setLeftComponent(getJTabbedPane_Uppaal());
			jSplitPane_Uppaal.setRightComponent(getJSplitPane_C());
		}
		return jSplitPane_Uppaal;
	}
	private JSplitPane getJSplitPane_C() {
		if (jSplitPane_C == null) {
			jSplitPane_C = new JSplitPane();
			jSplitPane_C.setLeftComponent(getJTabbedPane_C());
			jSplitPane_C.setRightComponent(getJTabbedPane_Verilog());
		}
		return jSplitPane_C;
	}

	/**
	 * This method initializes jTabbedPane_South	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_South() {
		if (jTabbedPane_South == null) {
			jTabbedPane_South = new JTabbedPane();
			jTabbedPane_South.setBorder(border);
			jTabbedPane_South.addTab("CONSOLE", me_icon , getJScrollPane_South(), "Console for displaying output");
			
		}
		return jTabbedPane_South;
	}

	/**
	 * This method initializes jScrollPane_South	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_South() {
		if (jScrollPane_South == null) {
			jScrollPane_South = new JScrollPane();
			jScrollPane_South.setViewportView(getJTextArea_South());
		}
		return jScrollPane_South;
	}

	/**
	 * This method initializes jTextArea_South	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_South() {
		if (jTextArea_South == null) {
			jTextArea_South = new JTextArea();
			jTextArea_South.setEditable(false);
			jTextArea_South.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_South.setForeground(Color.BLUE);
		}
		return jTextArea_South;
	}

	private JTabbedPane getJTabbedPane_Project() {
		if (jTabbedPane_Project == null) {
			jTabbedPane_Project = new JTabbedPane();
			jTabbedPane_Project.setBorder(border);
			jTabbedPane_Project.addTab("Current Project", me_icon, getJScrollPane_Project(), "Project currently opened");
		}
		return jTabbedPane_Project;
	}

	private JScrollPane getJScrollPane_Project() {
		if (jScrollPane_Project == null) {
			jScrollPane_Project = new JScrollPane();
			jScrollPane_Project.setViewportView(getJTree_Project(new File("c:\\BME")));
		}
		return jScrollPane_Project;

	}
	
	private JTree getJTree_Project(File dir){

		if (jTree_Project == null) 
		{
			jTree_Project = new JTree(addNodes(null, dir));	
			   
			ImageIcon closeicon=loadIcon("/resources/icons/closeicon.gif");//new ImageIcon("icons/closeicon.gif");
			ImageIcon openicon=loadIcon("/resources/icons/openicon.gif");//new ImageIcon("icons/openicon.gif");
			ImageIcon file=loadIcon("/resources/icons/file.gif");//new ImageIcon("icons/file.gif");
			    
			DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)jTree_Project.getCellRenderer();
			renderer.setLeafIcon(file);
			renderer.setClosedIcon(closeicon);
			renderer.setOpenIcon(openicon);
			    
			UIManager.put("Tree.leafIcon", file);
			UIManager.put("Tree.openIcon", openicon);
			UIManager.put("Tree.closedIcon", closeicon);
			//UIManager.put("Tree.expandedIcon",  new ImageIcon("icons/treeMinus.gif"));
			//UIManager.put("Tree.collapsedIcon", new ImageIcon("icons/treePlus.gif"));
			UIManager.put("Tree.expandedIcon",  loadIcon("/resources/icons/treeMinus.gif"));
			UIManager.put("Tree.collapsedIcon", loadIcon("/resources/icons/treePlus.gif"));

			jTree_Project = new JTree(addNodes(null, dir));
		}
		
		jTree_Project.addTreeSelectionListener(new TreeSelectionListener() 
	    {
	        String parent="";
	        public void valueChanged(TreeSelectionEvent e) 
	        {
	        	DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
	        	String parentpath=node.getParent().toString();
	        	String file_path=parentpath+"\\"+node.toString();
	        	int w;
	        	if(node.isLeaf())
	        	{
	        	jB_Import.setEnabled(true);
	        	jMI_Import.setEnabled(true);
	        	jB_Generate.setEnabled(false);
	        	jMI_Generate.setEnabled(false);
	        	jB_Execute.setEnabled(false);
	        	jMI_Execute.setEnabled(false);
	        	
	        	jB_Close.setEnabled(true);
	        	jMI_Close.setEnabled(true);
	        	jB_Delete.setEnabled(true);
	        	jMI_Delete.setEnabled(true);
	        	
	        	int parent_flag=0;
        		parent=node.getParent().toString();
        		
        		for(w=0;w<parent.length();w++)
        		{
        			if(parent.charAt(w)=='\\')
        			{
        				parent_flag++;
        				if(parent_flag==3)
        					break;
        				
        			}//end if
        		}//end for
        		parent=parent.substring(0, w);    	
	        	
        		if(last_path==null)
	        	{
        			
        			last_path=parent;
        		
        			jB_CloseFile.setEnabled(true);
	        		jMI_CloseFile.setEnabled(true);	
        			
        			filelines=BME.getInstance().open_file(file_path);
        			display_project_file(node);
	        		jScrollPane_Project.setViewportView(getJTree_Project(new File(parent)));
	        		
	        		
	        	//String full_path=node.getParent().toString();
	        	}// end if
        		else
        		{
        			/*if(last_path.equals(parent))
        			{
        				
        				String already_opened="The selected project is already opened.";
    	        		javax.swing.JOptionPane.showMessageDialog(null, already_opened);
        			}//end if
        			else
        			{
        				
        				String msg="Another project is already opened.If you proceed, the currently opened project will be closed. Do you wish to proceed?";
        	        	int mm = javax.swing.JOptionPane.showConfirmDialog(null,msg , "Confirm", 1);
        	        	
        	        	if(mm==0)
        	        	{
        	        		last_path=parent;
        	        		for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
        			    	{
        			    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
        			    		{
        			    			jTabbedPane_Center.remove(i);
        			    			i--;
        			    		}		
        			    	}//end for
        	
        	        		filelines=BME.getInstance().open_file(file_path);
        	        		display_project_file(node);
        	        		jB_CloseFile.setEnabled(true);
        	        		jMI_CloseFile.setEnabled(true);
        	        		
        	        		jScrollPane_Project.setViewportView(getJTree_Project(new File(parent)));
        	        	
        	        		
        	        	}//end if
        	        	
        				
        			}//end else
        		*/
        		}
	        	
	        	
	        }
	       
	        	
	        /*	if(last_path!=null){
	        	 String code_path=last_path+"\\C Code";
	 			File cpath=new File(code_path);
	 			
	 			String code_package[]=cpath.list();
	 			
	 					
	 			
	 			if(code_package.length>1)
	 					{
	 						jB_Execute.setEnabled(true);
	 						jMI_Execute.setEnabled(true);
	 					}              
	        	}*/
	     }//end if
	        
	    }
	);
		
		
		return jTree_Project;
	
	}
	
	
	/**
	 * This method initializes jTabbedPane_West	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_West() {
		if (jTabbedPane_West == null) {
			jTabbedPane_West = new JTabbedPane();
			jTabbedPane_West.setBorder(border);
			jTabbedPane_West.addTab("Current Project", me_icon, getJScrollPane_West(), "Project currently opened");
		}
		return jTabbedPane_West;
	}

	/**
	 * This method initializes jScrollPane_West	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_West() {
		if (jScrollPane_West == null) {
			jScrollPane_West = new JScrollPane();
		}
		return jScrollPane_West;
	}

	/**
	 * This method initializes jTree_West	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree_West(File dir)
	{
		
		   jTree_West = new JTree(addNodes(null, dir));
		
		   ImageIcon closeicon=loadIcon("/resources/icons/closeicon.gif");//new ImageIcon("icons/closeicon.gif");
		   ImageIcon openicon=loadIcon("/resources/icons/openicon.gif");//new ImageIcon("icons/openicon.gif");
		   ImageIcon file=loadIcon("/resources/icons/file.gif");//new ImageIcon("icons/file.gif");
		    
		   DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)jTree_West.getCellRenderer();
		   renderer.setLeafIcon(file);
		   renderer.setClosedIcon(closeicon);
		   renderer.setOpenIcon(openicon);
		    
		   UIManager.put("Tree.leafIcon", file);
		   UIManager.put("Tree.openIcon", openicon);
		   UIManager.put("Tree.closedIcon", closeicon);
		    
		   //UIManager.put("Tree.expandedIcon",  new ImageIcon("icons/treeMinus.gif"));
		   //UIManager.put("Tree.collapsedIcon", new ImageIcon("icons/treePlus.gif"));
		   
		   UIManager.put("Tree.expandedIcon",  loadIcon("/resources/icons/treeMinus.gif"));
		   UIManager.put("Tree.collapsedIcon", loadIcon("/resources/icons/treePlus.gif"));

		   jTree_West = new JTree(addNodes(null, dir));
		   
		   
	
		   jTree_West.addTreeSelectionListener(new TreeSelectionListener() 
		   {
			   public void valueChanged(TreeSelectionEvent e) 
			   {
				   
				   
				   
				   DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
				   String parentpath=node.getParent().toString();
				   String file_path=parentpath+"\\"+node.toString();
     
				   if(node.isLeaf())
				   {
					  // open_file(file_path,node);
					   //TODO Auto-generated method stub
				   //}     	
			   
			   
			
			   filelines=BME.getInstance().open_file(file_path);
			   display_project_file(node);
			   
		        jB_CloseFile.setEnabled(true);
		        jMI_CloseFile.setEnabled(true);
		       
			  }
			   
		   }
		  }
		   );
		   
		   
		return jTree_West;
	
	}//end method

	/**
	 * This method initializes jTabbedPane_East	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_East() {
		if (jTabbedPane_East == null) {
			jTabbedPane_East = new JTabbedPane();
			jTabbedPane_East.setBorder(border);
			//jTabbedPane_East.addTab("Tree Properties", me_icon, getJScrollPane_East(), "Tree properties");
			jTabbedPane_East.addTab("Tree Properties", me_icon, propertiesScrollPane, "Tree properties");
		}
		return jTabbedPane_East;
	}

	/**
	 * This method initializes jScrollPane_East	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_East() {
		if (jScrollPane_East == null) {
			jScrollPane_East = new JScrollPane();
			//jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
		}
		return jScrollPane_East;
	}

	/**
	 * This method initializes jTree_East	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree_East(File dir)
	{
		if (jTree_East == null) 
		{
			jTree_East = new JTree(addNodes(null, dir));	
			   
			ImageIcon closeicon=loadIcon("/resources/icons/closeicon.gif");
			ImageIcon openicon=loadIcon("/resources/icons/openicon.gif");
			ImageIcon file=loadIcon("/resources/icons/file.gif");
			    
			DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)jTree_East.getCellRenderer();
			renderer.setLeafIcon(file);
			renderer.setClosedIcon(closeicon);
			renderer.setOpenIcon(openicon);
			    
			UIManager.put("Tree.leafIcon", file);
			UIManager.put("Tree.openIcon", openicon);
			UIManager.put("Tree.closedIcon", closeicon);
			UIManager.put("Tree.expandedIcon",  loadIcon("/resources/icons/treeMinus.gif"));
			UIManager.put("Tree.collapsedIcon", loadIcon("/resources/icons/treePlus.gif"));

			jTree_East = new JTree(addNodes(null, dir));
		}
		
		jTree_East.addTreeSelectionListener(new TreeSelectionListener() 
	    {
	        String parent="";
	        public void valueChanged(TreeSelectionEvent e) 
	        {
	        	DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
	        	String parentpath=node.getParent().toString();
	        	String file_path=parentpath+"\\"+node.toString();
	        	int w;
	        	if(node.isLeaf())
	        	{
	        	jB_Import.setEnabled(true);
	        	jMI_Import.setEnabled(true);
	        	jB_Generate.setEnabled(false);
	        	jMI_Generate.setEnabled(false);
	        	jB_Execute.setEnabled(false);
	        	jMI_Execute.setEnabled(false);
	        	
	        	jB_Close.setEnabled(true);
	        	jMI_Close.setEnabled(true);
	        	jB_Delete.setEnabled(true);
	        	jMI_Delete.setEnabled(true);
	        	
	        	if(jTabbedPane_Center.getTabCount()>0)
	        	{
	        		jB_CloseFile.setEnabled(true);
	        		jMI_CloseFile.setEnabled(true);
	        	}
	        	
	        	int parent_flag=0;
        		parent=node.getParent().toString();
        		
        		for(w=0;w<parent.length();w++)
        		{
        			if(parent.charAt(w)=='\\')
        			{
        				parent_flag++;
        				if(parent_flag==3)
        					break;
        				
        			}//end if
        		}//end for
        		parent=parent.substring(0, w);    	
	        	
        		if(last_path==null)
	        	{
        			
        			last_path=parent;
        		
        			jB_CloseFile.setEnabled(true);
	        		jMI_CloseFile.setEnabled(true);	
        			
        			filelines=BME.getInstance().open_file(file_path);
        			display_project_file(node);
	        		jScrollPane_West.setViewportView(getJTree_West(new File(parent)));
	        		
	        		
	        	//String full_path=node.getParent().toString();
	        	}// end if
        		else
        		{
        			if(last_path.equals(parent))
        			{
        				
        				String already_opened="The selected project is already opened.";
    	        		javax.swing.JOptionPane.showMessageDialog(null, already_opened);
        			}//end if
        			else
        			{
        				
        				String msg="Another project is already opened.If you proceed, the currently opened project will be closed. Do you wish to proceed?";
        	        	int mm = javax.swing.JOptionPane.showConfirmDialog(null,msg , "Confirm", 1);
        	        	
        	        	if(mm==0)
        	        	{
        	        		last_path=parent;
        	        		for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
        			    	{
        			    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
        			    		{
        			    			jTabbedPane_Center.remove(i);
        			    			i--;
        			    		}		
        			    	}//end for
        	
        	        		filelines=BME.getInstance().open_file(file_path);
        	        		display_project_file(node);
        	        		jB_CloseFile.setEnabled(true);
        	        		jMI_CloseFile.setEnabled(true);
        	        		
        	        		jScrollPane_West.setViewportView(getJTree_West(new File(parent)));
        	        	
        	        		
        	        	}//end if
        				
        			}//end else
        		}
	        	
	        	
	        }
	       
	        	
	        	if(last_path!=null){
	        	 String code_path=last_path+"\\Java Code";
	 			File cpath=new File(code_path);
	 			
	 			String code_package[]=cpath.list();
	 			
	 					
	 			
	 			if(code_package.length>1)
	 					{
	 						jB_Execute.setEnabled(true);
	 						jMI_Execute.setEnabled(true);
	 					}              
	        	}
	     }//end if
	        
	    }
	);
		
		
		return jTree_East;
	}


	/**
	 * This method initializes jTabbedPane_Center	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_Center() {
		if (jTabbedPane_Center == null) {
			jTabbedPane_Center = new JTabbedPane();
			jTabbedPane_Center.setBorder(border);
			//jTabbedPane_Center.addTab(null, null, getJScrollPane_Center(), null);

			jTabbedPane_Center.addMouseListener(new java.awt.event.MouseAdapter()
			{
				public void mouseClicked(java.awt.event.MouseEvent e)
				{
					if(jTabbedPane_Center.getTabCount()>0)
						tabClicked(e);
					// TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jTabbedPane_Center;
	}
	
	private JTabbedPane getJTabbedPane_Tree() throws Exception {
		if (jTabbedPane_Tree == null) {
			jTabbedPane_Tree = new JTabbedPane();
			jTabbedPane_Tree.setBorder(border);
			jTabbedPane_Tree.addTab("Tree", me_icon , getJScrollPane_Tree(), "Tree representation");
			
		}
		return jTabbedPane_Tree;
	}
	private JTabbedPane getJTabbedPane_Verilog() {
		if (jTabbedPane_Verilog == null) {
			jTabbedPane_Verilog = new JTabbedPane();
			jTabbedPane_Verilog.setBorder(border);
			jTabbedPane_Verilog.addTab("Verilog", me_icon , getJScrollPane_Verilog(), "Verilog representation");
			
		}
		return jTabbedPane_Verilog;
	}
	private JTabbedPane getJTabbedPane_C() {
		if (jTabbedPane_C == null) {
			jTabbedPane_C = new JTabbedPane();
			jTabbedPane_C.setBorder(border);
			jTabbedPane_C.addTab("C Language", me_icon , getJScrollPane_C(), "C Language representation");
			
		}
		return jTabbedPane_C;
	}
	private JTabbedPane getJTabbedPane_Uppaal() {
		if (jTabbedPane_Uppaal == null) {
			jTabbedPane_Uppaal = new JTabbedPane();
			jTabbedPane_Uppaal.setBorder(border);
			jTabbedPane_Uppaal.addTab("Uppaal", me_icon , getJScrollPane_Uppaal(), "Uppaal representation");
			
		}
		return jTabbedPane_Uppaal;
	}
	/**
	 * This method initializes jScrollPane_Center	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws Exception 
	 */
    // Create a split pane to hold the tree, buttons, and properties
 /*   JSplitPane rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, buttonPanel, propertiesScrollPane);
    rightSplitPane.setResizeWeight(0.7); // Adjust the resize weight
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(treeRepresentation), rightSplitPane);
	*/
	private JScrollPane getJScrollPane_Tree() throws Exception {
		    //XMLTree = build("\\C2Uppaal\\Start_VCVmode_.xml");
		     XMLTree = getJTree_Representation(DSMLTreeFile);
		    //XMLTree = build("Start_VCVmode_.xml"); 
		    //DSMLTreeFile
		    //XMLTree = build("E:\\Thesis\\GUIProjectWorkSpace\\dsmlTesting\\My.dsml");
		    XMLTree.setEditable(true);
			jScrollPane_Tree = new JScrollPane(XMLTree);
			//jScrollPane_Tree.setViewportView(getJTextArea_Tree());
		return jScrollPane_Tree;
	}
	private JScrollPane getJScrollPane_C() {
				jScrollPane_C = new JScrollPane();
				jScrollPane_C.setViewportView(getJTextArea_C());
			return jScrollPane_C;
		}
	private JScrollPane getJScrollPane_Uppaal() {
				jScrollPane_Uppaal = new JScrollPane();
				jScrollPane_Uppaal.setViewportView(getjTextArea_Uppaal());
			return jScrollPane_Uppaal;
		}
	private JScrollPane getJScrollPane_Verilog() {
				jScrollPane_Verilog = new JScrollPane();
				jScrollPane_Verilog.setViewportView(getjTextArea_Verilog());
			return jScrollPane_Verilog;
		}
	private JScrollPane getJScrollPane_Center() {
				jScrollPane_Center = new JScrollPane();
				jScrollPane_Center.setViewportView(getJTextArea_Center());
			return jScrollPane_Center;
		}

	/**
	 * This method initializes jTextArea_Center	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_Center() {
		//if (jTextArea_Center == null) {
			jTextArea_Center = new JTextArea();
			jTextArea_Center.setEditable(true);
			jTextArea_Center.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_Center.setForeground(Color.GREEN);
			
		//}
		return jTextArea_Center;
	}
	/**
	 * This method initializes jTextArea_Center	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	
	
	/*private JTextArea getJTextArea_Tree() {
		//if (jTextArea_Center == null) {
			jTextArea_Tree = new JTextArea();
			jTextArea_Tree.setEditable(true);
			jTextArea_Tree.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_Tree.setForeground(Color.GREEN);
		//}
		return jTextArea_Tree;
	}*/
	private JTextArea getJTextArea_C() {
		//if (jTextArea_Center == null) {
			jTextArea_C = new JTextArea();
			jTextArea_C.setEditable(true);
			jTextArea_C.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_C.setForeground(Color.BLACK);
			jTextArea_C.setText(BME.getInstance().open_file(CFilePath));
			jTextArea_C.select(0, 1); // or jTextArea_Uppaal.setCaretPosition(0);
			
					///////////////****************** CHAGE LANGUAGE CODE CODE END ***************************************************// 
			         //String ChangeLanguageFlag=""; // {TA, C, SV, TREE}
					jTextArea_C.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) { ChangeLanguageFlag="C"; }
					
					@Override
					public void removeUpdate(DocumentEvent e) { ChangeLanguageFlag="C"; }
					
					@Override
					public void changedUpdate(DocumentEvent e) { ChangeLanguageFlag="C"; }
					});
					///////////////****************** CHANGE LANGUAGE CODE CODE END ***************************************************//  				
		//}
		return jTextArea_C;
	}
	private JTextArea getjTextArea_Uppaal() {
		//if (jTextArea_Center == null) {
			jTextArea_Uppaal = new JTextArea();
			jTextArea_Uppaal.setEditable(true);
			jTextArea_Uppaal.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_Uppaal.setForeground(Color.BLACK);
			jTextArea_Uppaal.setText(BME.getInstance().open_file(UppaalFilePath));
			jTextArea_Uppaal.setCaretPosition(0);
			
///////////////****************** CHAGE LANGUAGE CODE CODE END ***************************************************// 
			         //String ChangeLanguageFlag=""; // {TA, C, SV, TREE}
			        jTextArea_Uppaal.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) { ChangeLanguageFlag="TA"; }
					
					@Override
					public void removeUpdate(DocumentEvent e) { ChangeLanguageFlag="TA"; }
					
					@Override
					public void changedUpdate(DocumentEvent e) { ChangeLanguageFlag="TA"; }
					});
					///////////////****************** CHANGE LANGUAGE CODE CODE END ***************************************************//  
			
		//}
		return jTextArea_Uppaal;
	}
	private JTextArea getjTextArea_Verilog() {
		//if (jTextArea_Center == null) {
			jTextArea_Verilog = new JTextArea();
			jTextArea_Verilog.setEditable(true);
			jTextArea_Verilog.setFont(new Font("Garamond", Font.PLAIN ,16));
			jTextArea_Verilog.setForeground(Color.BLACK);
			jTextArea_Verilog.setText(BME.getInstance().open_file(VerilogFilePath));
			jTextArea_Verilog.setCaretPosition(0);
			
			
///////////////****************** CHAGE LANGUAGE CODE CODE END ***************************************************// 
			         //String ChangeLanguageFlag=""; // {TA, C, SV, TREE}
			        jTextArea_Verilog.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) { ChangeLanguageFlag="SV"; }
					
					@Override
					public void removeUpdate(DocumentEvent e) { ChangeLanguageFlag="SV"; }
					
					@Override
					public void changedUpdate(DocumentEvent e) { ChangeLanguageFlag="SV"; }
					});
					///////////////****************** CHANGE LANGUAGE CODE CODE END ***************************************************//  
		//}
		return jTextArea_Verilog;
	}

	/**
	 * This method initializes jJToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJJToolBar() {
		if (jJToolBar == null) {
			jJToolBar = new JToolBar();
			//jJToolBar.add(getJB_New());
			//jJToolBar.add(getJB_Close());
			//jJToolBar.add(getJB_Delete());
			jJToolBar.add(getJB_Save());
			jJToolBar.addSeparator(new Dimension(120,20));
			//jJToolBar.add(getJB_Open());
			//jJToolBar.add(getJB_CloseFile());
			jJToolBar.addSeparator(new Dimension(120,20));
			//jJToolBar.add(getJB_Import());
			//jJToolBar.add(getJB_Generate());
			//jJToolBar.add(getJB_Execute());
			jJToolBar.addSeparator(new Dimension(530,20));
			//jJToolBar.add(getJB_AboutUs());
			//jJToolBar.add(getJB_Help());
			
		}
		return jJToolBar;
	}

	/**
	 * This method initializes jB_New	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_New() {
		if (jB_New == null) {
			jB_New = new JButton(loadIcon("/resources/icons/new.gif"));
			jB_New.setToolTipText("New Project");
			jB_New.setMnemonic('N');
			
			jB_New.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()");  TODO Auto-generated Event stub actionPerformed()
					//if((jTree_West==null)&&(!(jTree_West.isVisible())))
					
					if((jTree_West==null)||(jTree_West.isVisible()==false))
					  {
						new_project();
					  }
					 else
					 {
						 int value=javax.swing.JOptionPane.showConfirmDialog(null, "Creating a new project will close the currently opened project.Do you want to proceed? ");
						 if(value==0)
						 {
							 jTree_West.setVisible(false);
							 
							 for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
						    	{
						    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
						    			{
						    			   jTabbedPane_Center.remove(i);
						    			   i--;
						    			}
						    			
						    	}//end for
							 
							 
							 
							 new_project();
							
						 }//end if
					 }//end else
				}

			});
		}
		jB_New.setEnabled(false);
		return jB_New;
	}

	/**
	 * This method initializes jB_Open	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Open() {
		if (jB_Open == null) {
			jB_Open = new JButton(loadIcon("/resources/icons/open.gif"));
			jB_Open.setToolTipText("Open File");
			jB_Open.setMnemonic('O');
			
			jB_Open.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					file_open();
					
				}
			});
		}
		jB_Open.setEnabled(false);
		return jB_Open;
	}

	/**
	 * This method initializes jB_Close	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Close() {
		if (jB_Close == null) {
			jB_Close = new JButton(loadIcon("/resources/icons/close.gif"));
			jB_Close.setToolTipText("Close Currently Opened Project");
			jB_Close.setEnabled(false);
			jB_Close.setMnemonic('C');
			
			jB_Close.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					close_project();
					
				}
			});
		}
		return jB_Close;
	}

	/**
	 * This method initializes jB_Delete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJB_Delete() {
		if (jB_Delete == null) {
			jB_Delete = new JButton(loadIcon("/resources/icons/delete.gif"));
			jB_Delete.setToolTipText("Delete Currenty Opened Project");
			jB_Delete.setEnabled(false);
			jB_Delete.setMnemonic('L');
			jB_Delete.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					if((jTree_West!=null)&&(jTree_West.isVisible()))
					{
						int selected_option=javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the currently opened project?");
						if(selected_option==0)
						{
							File project_path=new File(last_path);
							boolean isDeleted=BME.getInstance().delete_project(project_path);
							last_path=null;
							jTree_West.setVisible(false);
							
							
							
							for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
					    	{
					    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
					    		{
 				    			 jTabbedPane_Center.remove(i);
 				    			 i--;
					    		}
					    			
					    			
					    	}//end for
							
							jTree_East=null;
							
							
							
							jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
							if(isDeleted)
							{
								clearConsole();
								jB_Import.setEnabled(false);
					        	jMI_Import.setEnabled(false);
					        	jB_Generate.setEnabled(false);
					        	jMI_Generate.setEnabled(false);
					        	jB_Execute.setEnabled(false);
					        	jMI_Execute.setEnabled(false);
					        	
								jB_Close.setEnabled(false);
						        jMI_Close.setEnabled(false);
						        jB_Delete.setEnabled(false);
						        jMI_Delete.setEnabled(false);
						       
						        if(jTabbedPane_Center.getTabCount()==0)
						        {
						        	jB_CloseFile.setEnabled(false);
						        	jMI_CloseFile.setEnabled(false);
						        }
								
								
								javax.swing.JOptionPane.showMessageDialog(null, "Project has been deleted successfully.");
							}
							else
								javax.swing.JOptionPane.showMessageDialog(null, "Sorry! The currently opened project cannot be deleted.");
						}//end if
					}//end if
					
				    
				}
			});
			
		}

		return jB_Delete;
	}*/

	/**
	 * This method initializes jB_Import	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJB_Import() {
		if (jB_Import == null) {
			jB_Import = new JButton(loadIcon("/resources/icons/import.gif"));
			jB_Import.setToolTipText("Import XMI File");
			jB_Import.setEnabled(false);
			jB_Import.setMnemonic('I');
			
				jB_Import.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					import_xmi_file();
					
				}
			});
		}
		return jB_Import;
	}*/

	/**
	 * This method initializes jB_Save	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Save() {
		if (jB_Save == null) {
			jB_Save = new JButton(loadIcon("/resources/icons/save.png")); //new JButton(new ImageIcon("icons/save.png")); 
			jB_Save.setToolTipText("Save Changes and Transform.");
			jB_Save.setEnabled(true);
			jB_Save.setMnemonic('S');
			
			
			jB_Save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				try {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				
					//ME.getInstance().generateCode(last_path);
					//jTree_East=null;
					//jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
					//jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
					
					//jB_Execute.setEnabled(true);
					//jMI_Execute.setEnabled(true);
					//System.out.println(jTextArea_Tree.getText()); 
					Boolean isWorkspaceSaved=BME.getInstance().saveWorkspace(ChangeLanguageFlag, jTextArea_C.getText(), jTextArea_Uppaal.getText(), jTextArea_Verilog.getText(), CFilePath, UppaalFilePath, VerilogFilePath, DSMLTreeFile);
					jTextArea_C.setText(BME.getInstance().open_file(CFilePath)); 
					jTextArea_Verilog.setText(BME.getInstance().open_file(VerilogFilePath));
					jTextArea_Uppaal.setText(BME.getInstance().open_file(UppaalFilePath));
					
					jTextArea_Uppaal.setCaretPosition(0);
					jTextArea_Verilog.setCaretPosition(0);
					jTextArea_C.setCaretPosition(0);
					
					
					/*DefaultTreeModel model = (DefaultTreeModel)XMLTree.getModel();
					DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
					model.reload(root);
					*/
					
					xmlFile = new File(DSMLTreeFile);
					try {
						reloadXMLFile(xmlFile);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						jTextArea_South.setText(" ERROR: \n\t  Exception in reading Tree file! " );
					}
					if(ChangeLanguageFlag.equals("C"))
						jTextArea_South.setText("Transformations Source: "+ChangeLanguageFlag+"Language\n     System Verilog Transformations Done.\n     Timed Automata(Uppaal) Transformations Done.\n     DSML Transformations Done.");
					if(ChangeLanguageFlag.equals("SV"))
						jTextArea_South.setText("Transformations Source: "+ChangeLanguageFlag+"Language\n     C Language Transformations Done.\n     Timed Automata(Uppaal) Transformations Done.\n     DSML Transformations Done.");
					if(ChangeLanguageFlag.equals("TA"))
						jTextArea_South.setText("Transformations Source: "+ChangeLanguageFlag+"Language\n     System Verilog Transformations Done.\n     C Language Transformations Done.\n     DSML Language Transformations Done.");
					if(ChangeLanguageFlag.equals("TREE"))
						jTextArea_South.setText("Transformations Source: "+ChangeLanguageFlag+"Language\n     System Verilog Transformations Done.\n     Timed Automata(Uppaal) Transformations Done.\n     C Language Transformations Done.");
					
				}
				catch (Exception ex) {
		            // Handle the exception
		            ex.printStackTrace(); // This will print the exception details to the console.
		            // You can also show a message dialog to the user
		            jTextArea_South.setText("   Error while transformation! \n\t Please see the syntax. " );
		            //javax.swing.JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        }
					
				}
			});
			
		}
		return jB_Save;
	}
	
	
	/**
	 * This method initializes jB_Generate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJB_Generate() {
		if (jB_Generate == null) {
			jB_Generate = new JButton(loadIcon("/resources/icons/code.gif"));//new JButton(new ImageIcon("icons/code.gif"));
			jB_Generate.setToolTipText("Generate Java Code");
			jB_Generate.setEnabled(false);
			jB_Generate.setMnemonic('G');
			
			
			jB_Generate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				
					//ME.getInstance().generateCode(last_path);
					jTree_East=null;
					jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
					jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
					
					jB_Execute.setEnabled(true);
					jMI_Execute.setEnabled(true);
					jTextArea_South.setText("   SUCCESS ! \n\tJava code has been generated" );
					
				}
			});
			
		}
		return jB_Generate;
	}*/

	/**
	 * This method initializes jB_Execute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Execute() {
		if (jB_Execute == null) {
			jB_Execute = new JButton(loadIcon("/resources/icons/execute.gif")); //new JButton(new ImageIcon("icons/execute.gif"));  
			jB_Execute.setToolTipText("Execute Model");
			jB_Execute.setEnabled(false);
			jB_Execute.setMnemonic('E');
			
			jB_Execute.addActionListener(new java.awt.event.ActionListener() {
			
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
			
			execute_model();
			System.out.println("\n\n\n*** WOW !!! MISSION ACCOMPLISHED ***");
			
			}
		});

	}
		return jB_Execute;
	}

	/**
	 * This method initializes jB_Help	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Help() {
		if (jB_Help == null) {
			jB_Help = new JButton(loadIcon("/resources/icons/help.gif")); //new JButton(new ImageIcon("icons/help.gif")); 
			jB_Help.setToolTipText("About BME Project");
			jB_Help.setMnemonic('M');
			jB_Help.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					About_BME am=new About_BME();
					am.setVisible(true);
				
				}
			});
	
		}
		jB_Help.setEnabled(false);
		return jB_Help;
	}

	/**
	 * This method initializes jMI_New	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_New() {
		if (jMI_New == null) {
			jMI_New = new JMenuItem();
			jMI_New.setText("New Project");
			jMI_New.setMnemonic('N');

			
			jMI_New.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					if((jTree_West==null)||(!(jTree_West.isVisible())))
					  {
						new_project();
					  }
					 else
					 {
						 int value=javax.swing.JOptionPane.showConfirmDialog(null, "Creating a new project will close the currently opened project.Do you want to proceed? ");
						 if(value==0)
						 {
							 last_path=null;
							 jTree_West.setVisible(false);
							 
							 for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
						    	{
						    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
						    			{
						    			   jTabbedPane_Center.remove(i);
						    			   i--;
						    			}
						    			
						    	}//end for
							 
							
							 new_project();
							
						 }//end if
					 }//end else
	}

			});
		}
		return jMI_New;
	}

	/**
	 * This method initializes jMI_Open	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_Open() {
		if (jMI_Open == null) {
			jMI_Open = new JMenuItem();
			jMI_Open.setText("Open File");
			jMI_Open.setMnemonic('O');
			jMI_Open.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					
					file_open();
					
				}
			});
		}
		return jMI_Open;
	}

	/**
	 * This method initializes jMI_Close	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_Close() {
		if (jMI_Close == null) {
			jMI_Close = new JMenuItem();
			jMI_Close.setText("Close Project");
			jMI_Close.setMnemonic('C');
			jMI_Close.setEnabled(false);
			
			jMI_Close.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					close_project();
					
				}
			});
		}
		return jMI_Close;
	}

	/**
	 * This method initializes jMI_Delete	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_Delete() {
		if (jMI_Delete == null) {
			jMI_Delete = new JMenuItem();
			jMI_Delete.setText("Delete Project");
			jMI_Delete.setEnabled(false);
			jMI_Delete.setMnemonic('L');

			jMI_Delete.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					if((jTree_West!=null)&&(jTree_West.isVisible()))
					{
						int selected_option=javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the currently opened project?");
						if(selected_option==0)
						{
							File project_path=new File(last_path);
							boolean isDeleted=BME.getInstance().delete_project(project_path);
							last_path=null;
							jTree_West.setVisible(false);
							
							for(int i=0;i<jTabbedPane_Center.getTabCount();i++)
					    	{
					    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
					    		{
					    			jTabbedPane_Center.remove(i);
					    			i--;
					    		}		
					    	}//end for
					    	
							jTree_East=null;
							
							jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
							if(isDeleted)
							{
								clearConsole();
								jB_Import.setEnabled(false);
					        	jMI_Import.setEnabled(false);
					        	jB_Generate.setEnabled(false);
					        	jMI_Generate.setEnabled(false);
					        	jB_Execute.setEnabled(false);
					        	jMI_Execute.setEnabled(false);
					        	
								jB_Close.setEnabled(false);
						        jMI_Close.setEnabled(false);
						        jB_Delete.setEnabled(false);
						        jMI_Delete.setEnabled(false);
						        
						        if(jTabbedPane_Center.getTabCount()==0)
						        {
						        	jB_CloseFile.setEnabled(false);
						        	jMI_CloseFile.setEnabled(false);
						        }
							
								javax.swing.JOptionPane.showMessageDialog(null, "Project has been successfully deleted.");
							}
								else
								javax.swing.JOptionPane.showMessageDialog(null, "Sorry! The currently opened project cannot be deleted.");
						}//end if
					}//end if
					
					
				}
			});
		}

		return jMI_Delete;
	}

	/**
	 * This method initializes jMI_Exit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_Exit() {
		if (jMI_Exit == null) {
			jMI_Exit = new JMenuItem();
			jMI_Exit.setText("Exit");
			jMI_Exit.setMnemonic('X');
			jMI_Exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					exit_operation();
						
				}
	
			});
		}
		return jMI_Exit;
	}

	/**
	 * This method initializes jMenu_Edit	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_Edit() {
		if (jMenu_Edit == null) {
			jMenu_Edit = new JMenu();
			jMenu_Edit.setText("Edit");
			jMenu_Edit.setMnemonic('D');
			//jMenu_Edit.add(getJMI_Import());
			jMenu_Edit.add(jsp_import);
			//jMenu_Edit.add(getJMI_Generate());
			jMenu_Edit.add(jsp_generate);
			//jMenu_Edit.add(getJMI_Execute());
		}
		return jMenu_Edit;
	}

	/**
	 * This method initializes jMI_Import	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
/*	private JMenuItem getJMI_Import() {
		if (jMI_Import == null) {
			jMI_Import = new JMenuItem();
			jMI_Import.setText("Import XMI File");
			jMI_Import.setMnemonic('I');
			jMI_Import.setEnabled(false);
			jMI_Import.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				//	System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					import_xmi_file();
					//ME.getInstance().parserStateMachine();
					
					
				
				}
			});
			
		}
		return jMI_Import;
	}*/

	/**
	 * This method initializes jMI_Generate	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	/*private JMenuItem getJMI_Generate() {
		if (jMI_Generate == null) {
			jMI_Generate = new JMenuItem();
			jMI_Generate.setText("Generate Code");
			jMI_Generate.setMnemonic('G');
			jMI_Generate.setEnabled(false);
			jMI_Generate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					
					
					//ME.getInstance().generateCode(last_path);
					jTree_East=null;
					jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
					jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
					
					jB_Execute.setEnabled(true);
					jMI_Execute.setEnabled(true);
					jTextArea_South.setText("   SUCCESS ! \n\tJava code has been generated" );
					
				}
			});
		}
		return jMI_Generate;
	}*/

	/**
	 * This method initializes jMI_Execute	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	/*private JMenuItem getJMI_Execute() {
		if (jMI_Execute == null) {
			jMI_Execute = new JMenuItem();
			jMI_Execute.setText("Execute Model");
			jMI_Execute.setMnemonic('E');
			jMI_Execute.setEnabled(false);
			jMI_Execute.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				execute_model();
				System.out.println("\n\n\n*** WOW !!! MISSION ACCOMPLISHED ***");
				
				}
			});
	
		}
		return jMI_Execute;
	}*/

	/**
	 * This method initializes jMenu_Help	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_Help() {
		if (jMenu_Help == null) {
			jMenu_Help = new JMenu();
			jMenu_Help.setText("Help");
			jMenu_Help.setMnemonic('H');
			jMenu_Help.add(getJMI_ME());
			jMenu_Help.add(jsp_ME);
			jMenu_Help.add(getJMI_Us());
		}
		return jMenu_Help;
	}

	/**
	 * This method initializes jMI_ME	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_ME() {
		if (jMI_ME == null) {
			jMI_ME = new JMenuItem();
			jMI_ME.setText("About BME Project");
			jMI_ME.setToolTipText("About BME Project");
			jMI_ME.setMnemonic('M');
			jMI_ME.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					About_BME am=new About_BME();
					am.setVisible(true);
				}
			});
		}
		return jMI_ME;
	}

	/**
	 * This method initializes jMI_Us	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_Us() {
		if (jMI_Us == null) {
			jMI_Us = new JMenuItem();
			jMI_Us.setText("About Us");
			jMI_Us.setToolTipText("About Us");
			jMI_Us.setMnemonic('A');
			jMI_Us.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()				
					
					About_Developers ad = new About_Developers();
					ad.setVisible(true);
				}
			});
			
		}
		return jMI_Us;
	}


	/**
	 * This method initializes jMI_CloseFile	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMI_CloseFile() {
		if (jMI_CloseFile == null) {
			jMI_CloseFile = new JMenuItem("Close File");
			jMI_CloseFile.setToolTipText("Close Currently Selected File");
			jMI_CloseFile.setMnemonic('S');
			jMI_CloseFile.setEnabled(false);
			jMI_CloseFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				//	System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					int current_index=jTabbedPane_Center.getSelectedIndex();
					jTabbedPane_Center.remove(current_index);
					
					if(jTabbedPane_Center.getTabCount()==0)
			        {
			        	jB_CloseFile.setEnabled(false);
			        	jMI_CloseFile.setEnabled(false);
			        }
				}
			});
		}
		return jMI_CloseFile;
	}

	/**
	 * This method initializes jB_CloseFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJB_CloseFile() {
		if (jB_CloseFile == null) {
			jB_CloseFile = new JButton(loadIcon("/resources/icons/close_file.gif"));//new JButton(new ImageIcon("icons/close_file.gif"));
			jB_CloseFile.setToolTipText("Close Currently Selected File");
			jB_CloseFile.setMnemonic('S');
			jB_CloseFile.setEnabled(false);
			jB_CloseFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				//	System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					int current_index=jTabbedPane_Center.getSelectedIndex();
					jTabbedPane_Center.remove(current_index);
					
					if(jTabbedPane_Center.getTabCount()==0)
			        {
			        	jB_CloseFile.setEnabled(false);
			        	jMI_CloseFile.setEnabled(false);
			        }
				}
			});
		}
		return jB_CloseFile;
	}*/

	/**
	 * This method initializes jB_AboutUs	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_AboutUs() {
		if (jB_AboutUs == null) {
			jB_AboutUs = new JButton(loadIcon("/resources/icons/us.gif"));//new JButton(new ImageIcon("icons/us.gif"));
			jB_AboutUs.setToolTipText("About Us");
			jB_AboutUs.setMnemonic('A');
			jB_AboutUs.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					About_Developers ad = new About_Developers();
					ad.setVisible(true);
					}
			});
		}
		jB_AboutUs.setEnabled(false);
		return jB_AboutUs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					thisClass = GUI_Handler.getInstance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				thisClass.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						exit_operation();
					}
				});			
				thisClass.setVisible(true);
				thisClass.setFocusable(true);
			}
		});
		
	     
	     

	}

	/**
	 * This is the default constructor
	 * @throws Exception 
	 */
	public GUI_Handler() throws Exception {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		this.setSize(1500, 800);
		this.setLocation(25, 5);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("MRED");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws Exception 
	 */
	private JPanel getJContentPane() throws Exception {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(05);
			borderLayout.setVgap(05);
			
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJSplitPane_Vertical(), BorderLayout.CENTER);
			jContentPane.add(getJJToolBar(), BorderLayout.NORTH);
			
			jPanel_Middle.setPreferredSize(new Dimension(-1, 600));
			//jSplitPane_VerticalTreeAndProperties.setPreferredSize(new Dimension(-1, 250));
			//jTabbedPane_Project.setPreferredSize(new Dimension(150 ,250));
			
			jTabbedPane_East.setPreferredSize(new Dimension(300 ,150));
			//jTabbedPane_West.setPreferredSize(new Dimension(250 ,-1));
			//jTabbedPane_Center.setPreferredSize(new Dimension(700,-1));
			jTabbedPane_Tree.setPreferredSize(new Dimension(300,350));	
			jTabbedPane_Uppaal.setPreferredSize(new Dimension(350,-1));
			jTabbedPane_C.setPreferredSize(new Dimension(350,-1));
			jTabbedPane_Verilog.setPreferredSize(new Dimension(350,-1));
			
			jSplitPane_Vertical.setDividerSize(10);
			jSplitPane_Vertical.setOneTouchExpandable(true);			
			
			///jSplitPane_Left.setDividerSize(7);
			jSplitPane_Right.setDividerSize(7);
			//jSplitPane_Center.setDividerSize(7);
			
		}
		return jContentPane;
	}
		
	DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) 
	  { 
		DefaultMutableTreeNode curDir=new DefaultMutableTreeNode("c:\\bme");
	    
		if(dir!=null)
		{
	    String curPath = dir.getPath();
	    
	     curDir = new DefaultMutableTreeNode(curPath);
	    if (curTop != null) 
	    { // should only be null at root
	      curTop.add(curDir);
	    }
	    Vector ol = new Vector();
	    String[] tmp = dir.list();
	   
	    for (int i = 0; i < tmp.length; i++)
	    {
	      ol.addElement(tmp[i]);}
	      Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
	      File f;
	      Vector files = new Vector();
	    
	      // Make two passes, one for Dirs and one for Files. This is #1.
	    for (int i = 0; i < ol.size(); i++) 
	    {
	      String thisObject = (String) ol.elementAt(i);
	      String newPath;
	      if (curPath.equals("C:\\BME"))
	        newPath = thisObject;
	      else
	        newPath = curPath + File.separator + thisObject;
	      if ((f = new File(newPath)).isDirectory())
	        addNodes(curDir, f);
	      else
	        files.addElement(thisObject);
	    }
	    // Pass two: for files.
	    for (int fnum = 0; fnum < files.size(); fnum++)
	    {
	      curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
	    
	    }
	    return curDir;
	  }
		return curDir;
	  }
	
	public void new_project()
	    {
			File dir=new File("C:\\BME");
			boolean flag=false;
			
			clearConsole();
			
		  
			String msg1="Please enter project name: ";
			String project_name=javax.swing.JOptionPane.showInputDialog(msg1);
			  
			String[] tmp = dir.list();
			
			
			if(project_name.length()!=0)
			 {
			    for (int i = 0; i < tmp.length; i++)
			    {
			    	if(tmp[i].equalsIgnoreCase(project_name))
			    	{
			    		if(!(new File(tmp[i]).isDirectory()))
			    		{
			    			flag=true;
							
			    		}//end if
			    		
			    	}//end if
			    }//end for
			    
			    
			    if(!flag)
			    {
			    		File fp=BME.getInstance().create_new_project(project_name);
		    			
		    			jB_Import.setEnabled(true);
			        	jMI_Import.setEnabled(true);
			        	jB_Generate.setEnabled(false);
			        	jMI_Generate.setEnabled(false);
			        	jB_Execute.setEnabled(false);
			        	jMI_Execute.setEnabled(false);
			        	
						jB_Close.setEnabled(true);
				        jMI_Close.setEnabled(true);
				        jB_Delete.setEnabled(true);
				        jMI_Delete.setEnabled(true);
		    			
				        jB_CloseFile.setEnabled(false);
				        jMI_CloseFile.setEnabled(false);
				        
				        
				        last_path=fp.toString();
		    			jTree_East=null;
						jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
						jScrollPane_West.setViewportView(getJTree_West(fp));
						
		       
		    			
			    }//end if
			    else
			    {
			    	javax.swing.JOptionPane.showMessageDialog(null, "Project with the entered name already exists. Please enter a different name", "Error", 1);
					new_project();
			    }// end else  
			    }//end else
		else
			 {
			    	javax.swing.JOptionPane.showMessageDialog(null, "Please enter project name: ");
			    	new_project();
			}//end else
	 }//end method new_project
	    
	 public void file_open()
	 {
		 
		 
		 Frame parent=new Frame();
		 FileDialog fd=new FileDialog(parent,"Please select a file: ",FileDialog.LOAD);
		 fd.setVisible(true);
		 String path=fd.getDirectory()+File.separator+fd.getFile();
		 boolean checker=false;
		 int i;
		 for (i=0;i<file_count;i++)
		 {
				
			 if(path.equalsIgnoreCase(opened_files[i]))
			 {
	           checker=true;
	           break;
			 }//end if

	 		
		 }//end for
		 
		 
		 if(checker)
		 {
				 for(int a=0;a<jTabbedPane_Center.getTabCount();a++)
				{
				String tab_title=jTabbedPane_Center.getTitleAt(a);
				
				if(tab_title.equals(fd.getFile()))
				{
					if(jTabbedPane_Center.getToolTipTextAt(a).equalsIgnoreCase(path))
					{
					jTabbedPane_Center.setSelectedIndex(a);
					break;
					}
					 
				}//end if
				
				}//end for			 
		 }//end if

			 
	else
	{
		 opened_files[file_count++]=path;
	
		 filelines=BME.getInstance().open_file(path);
		 
		 String str=filelines.substring(0, 5);
		 
		 
		 if(filelines.length()>5)
			   str=filelines.substring(0, 5);
			   
			 
			// System.out.println(str);
			   
			   if(str.equals("ERROR"))
				  jTextArea_South.setText("ERROR:\n\tEither no file has been selected \tOR \n\tThe selected file contains unsupported content\n\n\tPlease select ERROR FREE correct file.");
			
			   else
			   {
		 		 
		 
			for(i=path.length();i>=0;i--)
			{
				if(path.charAt(i-1)=='\\')
				{
					break;
				}//end if
				
			}//end for
			String file_name=path.substring(i, path.length());
			
			jTabbedPane_Center.addTab(file_name,me_icon, getJScrollPane_Center(), path);
			jTabbedPane_Center.setSelectedIndex(jTabbedPane_Center.getTabCount()-1);
			jTextArea_Center.setText(filelines);
			jMI_CloseFile.setEnabled(true);
			jB_CloseFile.setEnabled(true);
		}
		 
		 
		 
		 
	}//end else

		 
	 }//end method file_open
	 
	 public void close_project()
	 {  		
		 
		 
	     int i;
		
		 if((jTree_West!=null)&&(jTree_West.isVisible()))
			{
			    int aa=javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to close the currently opened project?");
			    if(aa==0)
			    {
			       jB_Close.setEnabled(false);
			       jMI_Close.setEnabled(false);
			       jB_Delete.setEnabled(false);
			       jMI_Delete.setEnabled(false);
			    
			    	last_path=null;
			    	
			    	for(i=0;i<jTabbedPane_Center.getTabCount();i++)
			    	{
			    		if(!(jTabbedPane_Center.getToolTipTextAt(i).contains("\\")))
			    			{
			    			   jTabbedPane_Center.remove(i);
			    			   i--;
			    			}
			    			
			    	}//end for
			    	
			    	
			    	
			    	jB_Import.setEnabled(false);
		        	jMI_Import.setEnabled(false);
		        	jB_Generate.setEnabled(false);
		        	jMI_Generate.setEnabled(false);
		        	jB_Execute.setEnabled(false);
		        	jMI_Execute.setEnabled(false);
		        	clearConsole();
			    	
			    	
		        	/*ClassCompiler.reset();
		   		 	SMCompiler.reset();
		   		 	ClassDiagramParser.reset();
		   		 	SMParser.reset();
		        	*/
		        	
		        	jTree_West.setVisible(false);
		        	
			    	jTree_West=null;
			    	
			    	
			    	
			    	if(jTabbedPane_Center.getTabCount()<=0)
			        {
			        	jB_CloseFile.setEnabled(false);
			        	jMI_CloseFile.setEnabled(false);
			        }
			    }//end if
			}//end if
		

	 }//end close_project method
	 
	 public void display_project_file(DefaultMutableTreeNode node)
	 {
		 String str="";
		 
		 if(filelines.length()>5)
		   str=filelines.substring(0, 5);
		   
		 
		// System.out.println(str);
		   
		   if(str.equals("ERROR"))
			  jTextArea_South.setText("ERROR:\n\n\tEither no file has been selected \tOR \n\tThe selected file contains unsupported content\n\n\tPlease select ERROR FREE correct file.");
		   
		   else
		   {
		   
			String panename=node.toString();
			boolean flag=true;
			String tab_title="";
			
			if(jTabbedPane_Center.getTabCount()>0)
			{
			
				for(int a=0;a<jTabbedPane_Center.getTabCount();a++)
				{
				tab_title=jTabbedPane_Center.getTitleAt(a);
				if(tab_title.equals(node.toString()))
				{
					flag=false;
					jTabbedPane_Center.setSelectedIndex(a);
					
				}//end if
				
				}//end for
			}//end if
			if(flag)
			{
				jTabbedPane_Center.addTab(panename,me_icon, getJScrollPane_Center(), panename);
	    			int index1=jTabbedPane_Center.getTabCount();
	    			jTabbedPane_Center.setSelectedIndex(index1-1);
	    		
	    			 jTextArea_Center.setText(filelines);
				
			}//end else

		   }
		

		
	 }//end display_project_file method
	 
/*	 public void import_xmi_file()
	 {
		 
		 clearConsole();
		 String file_name=null;
		 String filelines="";
		 Frame parent=new Frame();
		 FileDialog fd=new FileDialog(parent,"Please select a file: ",FileDialog.LOAD);
		 fd.setVisible(true);
		 String file_path=fd.getDirectory()+File.separator+fd.getFile();
		 boolean checker=false;
		 int i;
		 
		 
		 
		 if(file_path.contains("null"))// if no file has been selected
		 {
			 jTextArea_South.setText("EXCEPTION: \n\n\t\t"+filelines+"\n\n\t\tNo File Selected.");
		 }
		 
		 else
		 {
		 
		 for (i=0;i<file_count;i++)
		 {
				
			 if(file_path.equalsIgnoreCase(opened_files[i]))
			 {
	           checker=true;
	           break;
			 }//end if

	 		
		 }//end for
		 
		 
		 if(checker)
		 {
				 for(int a=0;a<jTabbedPane_Center.getTabCount();a++)
				{
				String tab_title=jTabbedPane_Center.getTitleAt(a);
				int is_save = 1;
				
				if(tab_title.equals(fd.getFile()))
				{
					if(jTabbedPane_Center.getToolTipTextAt(a).equalsIgnoreCase(file_path))
					{
					jTabbedPane_Center.setSelectedIndex(a);
					is_save = -1;
					}
					
					 
				//	 ClassCompiler.reset();
					// SMCompiler.reset();
					// ClassDiagramParser.reset();
					// SMParser.reset();
					 

					 
					 filelines=BME.getInstance().import_xmi_file(file_path);
					 
					 int y=99;
					 if(filelines.contains("java.lang"))
					 {
						 jTextArea_South.setText("EXCEPTION: \n\n\t\t"+filelines+"\n\n\t\tIncorrect File Selected.");
						 y=-99;
						 jB_Generate.setEnabled(false);
						 jMI_Generate.setEnabled(false);
					 }
					 
					 
					 else
					 {
					 String str=filelines.substring(0, 5);
					 
					 
					 if(filelines.length()>5)
						   str=filelines.substring(0, 5);
						   
						   if(str.equals("ERROR"))
							  jTextArea_South.setText("ERROR:\n\tEither no file has been selected \tOR \n\tThe selected file contains unsupported content\n\n\tPlease select ERROR FREE correct file.");
						
						   else
						   {
					 
						for(i=file_path.length();i>=0;i--)
						{
							if(file_path.charAt(i-1)=='\\')
							{
								break;
							}//end if
							
						}//end for
						file_name=file_path.substring(i, file_path.length());
						
						jTabbedPane_Center.addTab(file_name,me_icon, getJScrollPane_Center(), file_path);
						jTabbedPane_Center.setSelectedIndex(jTabbedPane_Center.getTabCount()-1);
						
						jTextArea_Center.setText(filelines);
						jB_Generate.setEnabled(true);
						jMI_Generate.setEnabled(true);
						jTextArea_South.setText("   SUCCESS ! \n\tParsing Complete" );
						
						// write file
						
						
						if(is_save!=-1)
					    {
					    File source_xmi=new File(last_path+"\\XMI");
						
						try
						{
						  
							BufferedWriter bw1=new BufferedWriter(new FileWriter(source_xmi+"\\"+file_name));
							bw1.write(filelines);
							bw1.close();
						}
						catch(Exception e)
						{System.out.println(e);}
					 
					 
						jTree_East=null;
						jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
						jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
						
							jB_Generate.setEnabled(true);
							jMI_Generate.setEnabled(true);
							jTextArea_South.setText("   SUCCESS ! \n\tParsing Complete" );
						}
						
					}//end else
					
				}//end else
					 
					break;
					
				}//end if
				
				}//end for			 
		 }//end if

			 
	else
	{
		 opened_files[file_count++]=file_path;
		 
		 
		///* ClassCompiler.reset();
		// SMCompiler.reset();
		// ClassDiagramParser.reset();
		// SMParser.reset();
		 

		 filelines=BME.getInstance().import_xmi_file(file_path);
		 
		 int y=99;
		 if(filelines.contains("java.lang"))
		 {
			 jTextArea_South.setText("EXCEPTION: \n\n\t\t"+filelines+"\n\n\t\tIncorrect File Selected.");
			 y=-99;
			 jB_Generate.setEnabled(false);
			 jMI_Generate.setEnabled(false);
		 }
		 
		 
		 else
		 {
		 String str=filelines.substring(0, 5);
		 
		 
		 if(filelines.length()>5)
			   str=filelines.substring(0, 5);
			   
			 
			 //System.out.println(str);
			   
			   if(str.equals("ERROR"))
				  jTextArea_South.setText("ERROR:\n\tEither no file has been selected \tOR \n\tThe selected file contains unsupported content\n\n\tPlease select ERROR FREE correct file.");
			
			   else
			   {
		 
			for(i=file_path.length();i>=0;i--)
			{
				if(file_path.charAt(i-1)=='\\')
				{
					break;
				}//end if
				
			}//end for
			file_name=file_path.substring(i, file_path.length());
			
			jTabbedPane_Center.addTab(file_name,me_icon, getJScrollPane_Center(), file_path);
			jTabbedPane_Center.setSelectedIndex(jTabbedPane_Center.getTabCount()-1);
			
			jTextArea_Center.setText(filelines);
		}//end else
		
		 
		 
		
	}//end else
		 
		    if(y!=-99)
		    {
		    File source_xmi=new File(last_path+"\\XMI");
			
			try
			{
			  
				BufferedWriter bw1=new BufferedWriter(new FileWriter(source_xmi+"\\"+file_name));
				bw1.write(filelines);
				bw1.close();
			}
			catch(Exception e)
			{System.out.println(e);}
		 
		 
			jTree_East=null;
			jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
			jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
			
				jB_Generate.setEnabled(true);
				jMI_Generate.setEnabled(true);
				jTextArea_South.setText("   SUCCESS ! \n\tParsing Complete" );
			}
			
			if(jTabbedPane_Center.getTabCount()>0)
			{
				jB_CloseFile.setEnabled(true);
				jMI_CloseFile.setEnabled(true);
			}
	}
		 }// end else(if no file selected) 

	 }//end import_xmi_file method	 
	 */
	 public void tabClicked(java.awt.event.MouseEvent e)
	 {
		      if (e.getButton() != java.awt.event.MouseEvent.BUTTON1 && e.getClickCount() == 1)
		      {   
		        JPopupMenu popupMenu = new JPopupMenu();
		        JMenuItem closeBtn = new JMenuItem("Close");
		        JMenuItem closeOthersBtn = new JMenuItem("Close Others");
		        JMenuItem closeAllBtn = new JMenuItem("Close All");
		        
		        
		        closeBtn.addActionListener(new java.awt.event.ActionListener()
		        {
		          public void actionPerformed(java.awt.event.ActionEvent e)
		          {
		            SwingUtilities.invokeLater(new Runnable()
		            {
		              public void run()
		              {
		                  closeSelectedTab();
		              }
		            });
		          }
		        });
		        
		        
		        
		        closeOthersBtn.addActionListener(new java.awt.event.ActionListener()
		        {
		          public void actionPerformed(java.awt.event.ActionEvent e)
		          {
		            SwingUtilities.invokeLater(new Runnable()
		            {
		              public void run()
		              {
		                  closeOthers();
		              }
		            });
		          }
		        });
		        
		        
		        closeAllBtn.addActionListener(new java.awt.event.ActionListener()
		        {
		          public void actionPerformed(java.awt.event.ActionEvent e)
		          {
		            SwingUtilities.invokeLater(new Runnable()
		            {
		              public void run()
		              {
		                  closeAll();
		              }
		            });
		          }
		        });
		        
		        
		        if(jTabbedPane_Center.getTabCount()>0)
		        {
		        	popupMenu.add(closeBtn);
		        	popupMenu.add(closeOthersBtn);
		        	popupMenu.add(closeAllBtn);
		        }
		        
		        if(jTabbedPane_Center.getTabCount()==1)
		        {
		        	closeOthersBtn.setEnabled(false);
		        	closeAllBtn.setEnabled(false);
		        }
		        
		        
		        popupMenu.show(e.getComponent(), e.getX(), e.getY());
		      }
		    }
		    
	 public void closeSelectedTab()
		    {
		    	int current_index=jTabbedPane_Center.getSelectedIndex();
				jTabbedPane_Center.remove(current_index);
				
				if(jTabbedPane_Center.getTabCount()==0)
				{
					jB_CloseFile.setEnabled(false);
			    	jMI_CloseFile.setEnabled(false);
				}
		    }
		       
     public void closeOthers()
		    {
		    	int current_index=jTabbedPane_Center.getSelectedIndex();
		    	
		    	for(int i=0; i<jTabbedPane_Center.getTabCount(); i++)
		    	{
		    		if(i!=current_index)
		    		{
		    			jTabbedPane_Center.remove(i);
		    			if(i<current_index)
		    				current_index--;
		    			i--;
		    		}
		    	}
				
		    	
		    }
		    	    
	 public void closeAll()
		    {
		       for(int i=0; i<jTabbedPane_Center.getTabCount(); i++)
		       {
		    	   jTabbedPane_Center.remove(i);
		    	   i--;
		    	   
		    	   jB_CloseFile.setEnabled(false);
		    	   jMI_CloseFile.setEnabled(false);
		       }
		    }
	    		
	 public void clearConsole()
			{
				jTextArea_South.setText("");
			}
		
	 public static void exit_operation()
			{
				int aa=javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to close BME application?");
				if(aa==0)
				{
				
					thisClass.dispose();
					//System.exit(0);
					Exit ex=new Exit();
					///ex.setVisible(true);
					///ex.setFocusable(true);
					
				}//end if
	
			}
				
	 public void execute_model()
		    {
		    	String main_files[]=new String[50];
				int no_of_main=0;
				
				String code_path=last_path+"\\Java Code";
				File cpath=new File(code_path);
				
				String code_package[]=cpath.list();
				
						code_path=code_path+"\\"+code_package[0].toString();
						File files_path=new File(code_path);
						
						String file_names[]=files_path.list();
						
						
						int total_java_files=0;
						String java_files[]=new String[50];
						
					
						for(int a=0; a<file_names.length; a++)
						{
							if(file_names[a].contains(".java"))
							{
								java_files[total_java_files++]=file_names[a];
							}
						}
						
						// only java files, not class files
					
						
						for(int a=0; a<total_java_files; a++)
						{
							// file reading
							try
							{
								FileReader input=new FileReader(code_path+"\\"+java_files[a]);
								BufferedReader bufRead=new BufferedReader(input);
								String line;
								line=bufRead.readLine();		
								filelines="";
								
								while(line!=null)
								{  				
									filelines+="   "+line+"\n";
									line=bufRead.readLine();									
								}//end while

								bufRead.close();

								if(filelines.contains("public static void main"))
									main_files[no_of_main++]=java_files[a];
									
							}//end try
					   	
							catch(Exception eb)
							{
								System.out.println(eb);
								
							}//end catch
							
							
							// file found with the main method
						}// end for
				
						Vector v=new Vector();
				
				if(no_of_main>0)
				{
				v=new Vector();
				
				for(int a=0; a<no_of_main; a++)
				{
					v.add(main_files[a]);
				}
				
				}
				
				
					Dialog_Main dm=new Dialog_Main(v, last_path, code_package[0], code_path);
					dm.setVisible(true);
		    }

	 public void setText(String my_file)
			{
				clearConsole();
				
				
				jTree_East=null;
				jScrollPane_East.setViewportView(getJTree_East(new File("c:\\BME")));
				jScrollPane_West.setViewportView(getJTree_West(new File(last_path)));
				
				
				jTextArea_South.setText(my_file);
				
			}		    
/*	 protected  JTree build(String pathToXml) throws Exception {
		        SAXReader reader = new SAXReader();
		        Document doc = reader.read(pathToXml);
		        return new JTree(build(doc.getRootElement()));
		   }

	 protected  DefaultMutableTreeNode build(Element e) {
		      DefaultMutableTreeNode result = new DefaultMutableTreeNode(e.getName()+": "+e.getText());
		      for(Object o : e.elements()) {
		         Element child = (Element) o;
		         result.add(build(child));
		      }

		      return result;         
		   }
			*/
	 
	///////////////****************** TREE REPRESENTATION CODE START ***************************************************// 
	 
	 
private JTree getJTree_Representation(String DSMLTreeFile)
{
	
	// Create a root node and an initially empty tree model
    rootNode = new DefaultMutableTreeNode("Root");
    treeModel = new DefaultTreeModel(rootNode);

    //xmlFile = new File("C:\\Users\\Dir ICT\\eclipse-workspace\\TreeEditor\\src\\TreeModel\\My.dsml");
    xmlFile = new File(DSMLTreeFile);
    try {
		reloadXMLFile(xmlFile);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    // Create the JTree with the tree model
    treeRepresentation = new JTree(treeModel);
    treeRepresentation.setEditable(true);

    treeRepresentation.setCellRenderer(new DefaultTreeCellRenderer() {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            // Retrieve the Element object associated with the tree node
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Element element = (Element) node.getUserObject();

            // Set the element name as the text for the tree node
            String nodeName = element.getName();
            String specificName = element.attributeValue("name", "");
            // Set the combined text for the tree node
            setText(nodeName + " " + specificName);
            
            // Set the element name as the text for the tree node
           // setText(element.getName());

            return this;
        }
    });

    // Create a panel for buttons
    buttonPanel = new JPanel(new FlowLayout());

    // Create a properties panel
    propertiesPanel = new JPanel(new GridLayout(11, 2)); // 10 pairs + labels
    
    // Add labels
    propertyLabel = new JLabel("Property");
    valueLabel = new JLabel("Value");
    propertiesPanel.add(propertyLabel);
    propertiesPanel.add(valueLabel);

    // Add JTextField pairs for properties and values
    for (int i = 0; i < 10; i++) {
        propertyFields[i] = new JTextField();
        propertyFields[i].setEditable(false);
        propertyFields[i].setBackground(Color.WHITE);
        valueFields[i] = new JTextField();
        valueFields[i].setBackground(Color.WHITE);
        propertiesPanel.add(propertyFields[i]);
        propertiesPanel.add(valueFields[i]);
    }

    propertiesScrollPane = new JScrollPane(propertiesPanel);
    propertiesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // Create a split pane to hold the tree, buttons, and properties
    //JSplitPane rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, buttonPanel, propertiesScrollPane);
    //rightSplitPane.setResizeWeight(0.7); // Adjust the resize weight
    //JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), rightSplitPane);
    //splitPane.setResizeWeight(0.5); // Adjust the resize weight
    //getContentPane().add(splitPane);

    // Add tree selection listener to update properties panel
    treeRepresentation.addTreeSelectionListener(new TreeSelectionListener() {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeRepresentation.getLastSelectedPathComponent();
            if (selectedNode != null) {
                currentNode = selectedNode;
                updatePropertiesPanel(selectedNode);
            }
        }
    });

    // Add mouse listener for the popup menu
    treeRepresentation.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
                int row = treeRepresentation.getClosestRowForLocation(evt.getX(), evt.getY());
                treeRepresentation.setSelectionRow(row);
                showPopupMenu(evt.getX(), evt.getY());
            }
        }
    });
    
    //ChangeLanguageFlag
    treeModel.addTreeModelListener((TreeModelListener) new TreeModelListener() {
        @Override
        public void treeNodesChanged(TreeModelEvent e) {
        	ChangeLanguageFlag="TREE";

            System.out.println("Nodes changed");
        }

        @Override
        public void treeNodesInserted(TreeModelEvent e) {
        	ChangeLanguageFlag="TREE";

            System.out.println("Nodes inserted");
        }

        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
        	ChangeLanguageFlag="TREE";

            System.out.println("Nodes removed");
        }

        @Override
        public void treeStructureChanged(TreeModelEvent e) {
        	ChangeLanguageFlag="TREE";

            System.out.println("Tree structure changed");
        }
    });

    
    return treeRepresentation;
		 
}// end getJTree_Representation
	 
	 
 private void showPopupMenu(int x, int y) {
     JPopupMenu popupMenu = new JPopupMenu();

     JMenuItem refreshItem = new JMenuItem("Refresh");
     refreshItem.addActionListener(e -> {
         try {
             reloadXMLFile(xmlFile);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
     });
     popupMenu.add(refreshItem);

     JMenuItem deleteItem = new JMenuItem("Delete Node");
     deleteItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Handle Delete Node action
             DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeRepresentation.getLastSelectedPathComponent();
             if (selectedNode != null) {
                 Object userObject = selectedNode.getUserObject();
                 if (userObject instanceof Element) {
                     Element element = (Element) userObject;
                     DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
                     if (parent != null) {
                         Element parentElement = (Element) parent.getUserObject();
                         parentElement.remove(element);
                         saveChangesToXML();
                         try {
                             reloadXMLFile(xmlFile);
                         } catch (Exception ex) {
                             ex.printStackTrace();
                         }
                     }
                 }
             }
         }
     });

     
     popupMenu.add(deleteItem);

     JMenuItem editItem = new JMenuItem("Edit Node");
     editItem.addActionListener(e -> {
         treeRepresentation.startEditingAtPath(treeRepresentation.getSelectionPath());
     });
     popupMenu.add(editItem);

     JMenuItem newChildItem = new JMenuItem("New Child");
     newChildItem.addActionListener(e -> {
         showAddElementMenu(true, x, y);
     });
     popupMenu.add(newChildItem);

     JMenuItem newSiblingItem = new JMenuItem("New Sibling");
     newSiblingItem.addActionListener(e -> {
         showAddElementMenu(false, x, y);
     });
     popupMenu.add(newSiblingItem);

     popupMenu.show(treeRepresentation, x, y);
 }

 private void showAddElementMenu(boolean isChild, int x, int y) {
     JPopupMenu addElementMenu = new JPopupMenu();

     JMenuItem componentItem = new JMenuItem("Component");
     componentItem.addActionListener(e -> addElement(isChild, "component"));
     addElementMenu.add(componentItem);

     JMenuItem statementItem = new JMenuItem("Statement");
     statementItem.addActionListener(e -> addElement(isChild, "statement"));
     addElementMenu.add(statementItem);

     JMenuItem conditionItem = new JMenuItem("Comment");
     conditionItem.addActionListener(e -> addElement(isChild, "comment"));
     addElementMenu.add(conditionItem);

     //JMenuItem expressionItem = new JMenuItem("Expression");
     //expressionItem.addActionListener(e -> addElement(isChild, "expression"));
     //addElementMenu.add(expressionItem);

     JMenuItem declarationItem = new JMenuItem("Declaration");
     declarationItem.addActionListener(e -> addElement(isChild, "declaration"));
     addElementMenu.add(declarationItem);

     //JMenuItem featureItem = new JMenuItem("Feature");
     //featureItem.addActionListener(e -> addElement(isChild, "feature"));
     //addElementMenu.add(featureItem);
     
     JMenuItem attributeItem = new JMenuItem("Attribute");
     attributeItem.addActionListener(e -> addElement(isChild, "attribute"));
     addElementMenu.add(attributeItem);
     
     JMenuItem parameterItem = new JMenuItem("Parameter");
     parameterItem.addActionListener(e -> addElement(isChild, "parameter"));
     addElementMenu.add(parameterItem);
     
     JMenuItem assignmentItem = new JMenuItem("Assignment");
     assignmentItem.addActionListener(e -> addElement(isChild, "assignment"));
     addElementMenu.add(assignmentItem);
     
     JMenuItem functionCallItem = new JMenuItem("FunctionCall");
     functionCallItem.addActionListener(e -> addElement(isChild, "functionCall"));
     addElementMenu.add(functionCallItem);
     
     JMenuItem printItem = new JMenuItem("Print");
     printItem.addActionListener(e -> addElement(isChild, "print"));
     addElementMenu.add(printItem);
     
     JMenuItem switchItem = new JMenuItem("Switch");
     switchItem.addActionListener(e -> addElement(isChild, "switch"));
     addElementMenu.add(switchItem);
     
     JMenuItem ifItem = new JMenuItem("If");
     ifItem.addActionListener(e -> addElement(isChild, "if"));
     addElementMenu.add(ifItem);
     
     JMenuItem switchCaseItem = new JMenuItem("SwitchCase");
     switchCaseItem.addActionListener(e -> addElement(isChild, "switchCase"));
     addElementMenu.add(switchCaseItem);
     
     JMenuItem functionPrototypeItem = new JMenuItem("FunctionPrototype");
     functionPrototypeItem.addActionListener(e -> addElement(isChild, "functionPrototype"));
     addElementMenu.add(functionPrototypeItem);

     addElementMenu.show(treeRepresentation, x, y);
 }

 private void addElement(boolean isChild, String elementType) {
     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeRepresentation.getLastSelectedPathComponent();
     if (selectedNode == null) return;

     Element parentElement = (Element) selectedNode.getUserObject();
     Element newElement = parentElement.addElement(elementType);

     // Add default attributes to new elements
     addDefaultAttributes(newElement);

     DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newElement);

     if (isChild) {
         selectedNode.add(newNode);
     } else {
         DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
         if (parentNode != null) {
             parentNode.add(newNode);
         }
     }

     treeModel.reload();
     treeRepresentation.expandPath(new TreePath(selectedNode.getPath()));
     treeRepresentation.setSelectionPath(new TreePath(newNode.getPath()));
     updatePropertiesPanel(newNode);
     saveChangesToXML();
 }

 private void addDefaultAttributes(Element element) {
     switch (element.getName()) {
     case "component":
         element.addAttribute("name", "");
         element.addAttribute("type", "");
         break;
     case "statement":
         element.addAttribute("name", "");
         break;
     case "condition":
         element.addAttribute("keyword", "");
         element.addAttribute("variable", "");
         element.addAttribute("operator", "");
         element.addAttribute("value", "");
         break;
     case "expression":
         element.addAttribute("operator", "");
         element.addAttribute("value", "");
         element.addAttribute("index", "");
         element.addAttribute("attribute", "");
         break;
     case "attribute":
         element.addAttribute("name", "");
         element.addAttribute("type", "");
         element.addAttribute("keyword", "");
         element.addAttribute("value", "");
         element.addAttribute("size", "");
         break;
     case "parameter":
         element.addAttribute("name", "");
         element.addAttribute("type", "");
         element.addAttribute("qualifier", "");
         element.addAttribute("pointer", "");
         break;
     }
 }

 private void updatePropertiesPanel(DefaultMutableTreeNode selectedNode) {
     if (isUpdatingProperties) return;
     isUpdatingProperties = true;

     Element element = (Element) selectedNode.getUserObject();
     List<Attribute> attributes = element.attributes();
     clearPropertiesPanel();

     for (int i = 0; i < 10; i++) {
         // Clear existing document listeners
         if (listenersMap.containsKey(valueFields[i])) {
             valueFields[i].getDocument().removeDocumentListener(listenersMap.get(valueFields[i]));
             listenersMap.remove(valueFields[i]);
         }
         if (i < attributes.size()) {
             Attribute attribute = attributes.get(i);
             propertyFields[i].setText(attribute.getName());
             valueFields[i].setText(attribute.getValue());
             DocumentListener listener = createDocumentListener(attribute, valueFields[i]);
             valueFields[i].getDocument().addDocumentListener(listener);
             listenersMap.put(valueFields[i], listener);
         } else {
             propertyFields[i].setText("");
             valueFields[i].setText("");
         }
     }

     isUpdatingProperties = false;
 }

 private void clearPropertiesPanel() {
     for (int i = 0; i < 10; i++) {
         propertyFields[i].setText("");
         valueFields[i].setText("");
     }
 }

 private DocumentListener createDocumentListener(Attribute attribute, JTextField valueField) {
     return new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
             if (!isUpdatingProperties) {   ChangeLanguageFlag="TREE";

                 updateXMLAttribute(attribute, valueField.getText());
             }
         }

         @Override
         public void removeUpdate(DocumentEvent e) {ChangeLanguageFlag="TREE";
             if (!isUpdatingProperties) {
                 updateXMLAttribute(attribute, valueField.getText());
             }
         }

         @Override
         public void changedUpdate(DocumentEvent e) {ChangeLanguageFlag="TREE";
             if (!isUpdatingProperties) {
                 updateXMLAttribute(attribute, valueField.getText());
             }
         }
     };
 }

 private void updateXMLAttribute(Attribute attribute, String newValue) {
     // Update the value of the XML attribute
     attribute.setValue(newValue);
     // Save the changes to the XML file
     saveChangesToXML();
 }

 /*private void saveChangesToXML() {
     try {
         // Create XMLWriter with pretty print format
         OutputFormat format = OutputFormat.createPrettyPrint();
         XMLWriter writer = new XMLWriter(new FileWriter(xmlFile), format);
         // Write the updated XML document to the file
         writer.write(xmlDocument);
         writer.flush();
         writer.close();
     } catch (Exception ex) {
         ex.printStackTrace();
         jTextArea_South.setText("   File loading failed! \n\t Please see the syntax. " );
     }
 }*/
 
 private void saveChangesToXML() {
	    try {
	        // Create custom format with 4-space indentation
	        OutputFormat format = new OutputFormat("    ", true);
	        format.setSuppressDeclaration(false);
	        format.setNewLineAfterDeclaration(true);
	        format.setLineSeparator("\n");
	        format.setExpandEmptyElements(false);

	        // Custom XMLWriter that forces all attributes to new lines
	        XMLWriter writer = new XMLWriter(new FileWriter(xmlFile), format) {
	            @Override
	            protected void writeAttributes(Element element) throws IOException {
	                // For root element, add newline after opening tag
	                if (element.isRootElement()) {
	                    writer.write("\n");
	                }
	                
	                // Write each attribute on its own line with proper indentation
	                for (Iterator<Attribute> it = element.attributeIterator(); it.hasNext();) {
	                    Attribute attribute = it.next();
	                    
	                    if (element.isRootElement()) {
	                        writer.write("    "); // 4 spaces for root attributes
	                    } else {
	                        writer.write("\n        "); // Newline + 8 spaces for nested
	                    }
	                    
	                    writer.write(attribute.getQualifiedName());
	                    writer.write("=\"");
	                    //writer.write(attribute.getValue());
	                    writer.write(escapeXml(attribute.getValue()));

	                    writer.write("\"");
	                    
	                    // Don't add newline after last attribute
	                    if (it.hasNext()) {
	                        writer.write("\n");
	                    }
	                }
	                
	                // For root element, add newline before content
	                if (element.isRootElement() && !element.content().isEmpty()) {
	                    writer.write("\n");
	                }
	            }
	        };

	        writer.write(xmlDocument);
	        writer.flush();
	        writer.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        jTextArea_South.setText("File saving failed! Please check the file.");
	    }
	}
 private String escapeXml(String input) {
	    if (input == null) return "";
	    return input.replace("&", "&amp;")
	                .replace("<", "&lt;")
	                //.replace(">", "&gt;")
	                //.replace("\"", "&quot;")
	                //.replace("'", "&apos;")
	                ;
	}



 
 private void reloadXMLFile(File xmlFile) throws Exception {
     SAXReader reader = new SAXReader();
     xmlDocument = reader.read(xmlFile);
     treeModel.setRoot(build(xmlDocument.getRootElement()));
     if (treeRepresentation != null && treeRepresentation.getSelectionPath() != null) {
         DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeRepresentation.getSelectionPath().getLastPathComponent();
         if (selectedNode != null) {
             updatePropertiesPanel(selectedNode); // Call the method to update the properties panel
         }
     }
 }

 protected DefaultMutableTreeNode build(Element e) {
     DefaultMutableTreeNode result = new DefaultMutableTreeNode(e);
     for (Object o : e.elements()) {
         Element child = (Element) o;
         result.add(build(child));
     }
     return result;
     
  
 }
	 
	///////////////****************** TREE REPRESENTATION CODE END ***************************************************// 
 
 private ImageIcon loadIcon(String path) {
     java.net.URL imgURL = getClass().getResource(path);
    // System.out.println("img url: "+imgURL);
     if (imgURL != null) {
         return new ImageIcon(imgURL);
     } else {
         System.err.println("Couldn't find file: " + path);
         return null;
     }
 }

 private void parseXml() {
     try {
         SAXReader reader = new SAXReader();
         Document document = reader.read(getClass().getResourceAsStream("/sample.xml"));
         Element root = document.getRootElement();
         System.out.println("Root element: " + root.getName());
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 private void loadTextFile(String path) {
     try (InputStream inputStream = getClass().getResourceAsStream(path);
          BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
         String line;
         while ((line = reader.readLine()) != null) {
             System.out.println(line);
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

public JTextArea getjTextArea_South() {
	return jTextArea_South;
}

public void setjTextArea_South(JTextArea jTextArea_South) {
	this.jTextArea_South = jTextArea_South;
}
	 
			
}
	 
	 
	 /*
	  // Hide left or top
pane.getLeftComponent().setMinimumSize(new Dimension());
pane.setDividerLocation(0.0d);

// Hide right or bottom
pane.getRightComponent().setMinimumSize(new Dimension());
pane.setDividerLocation(1.0d);
	  * */
	  

