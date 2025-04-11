package GUIEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;


public class About_BME extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel_North = null;

	private JPanel jPanel_South = null;

	private JButton jB_ok = null;

	private JPanel jPanel_Center = null;

	private JTabbedPane jTabbedPane_Center = null;

	private JTextPane jTextPane_Glance = null;
	
	Icon me = new ImageIcon("bme.jpg");

	private JTextPane jTextPane_MEProject = null;

	private JScrollPane jScrollPane_MEProject = null;

	private JTextPane jTextPane_Points = null;

	private JTextPane jTextPane_User = null;

	private JTextPane jTextPane_Sequence = null;

	private JScrollPane jScrollPane_User = null;

	/**
	 * This is the default constructor
	 */
	public About_BME() {
		super();
		setResizable(false);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1000, 750);
		this.setLocation(145, 5);
		this.setContentPane(getJContentPane());
		this.setTitle("BME Help");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_North(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_South(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_Center(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_North	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_North() {
		if (jPanel_North == null) {
			jPanel_North = new JPanel();
			jPanel_North.setLayout(new GridBagLayout());
			jPanel_North.setLayout(new GridBagLayout());
			Icon i=new ImageIcon("me_title.jpg");
			JLabel label=new JLabel("", i, 0);
			jPanel_North.add(label);
			jPanel_North.setBackground(new Color(200, 221, 242));
			jPanel_North.setPreferredSize(new Dimension(80, 100));
		}
		return jPanel_North;
	}

	/**
	 * This method initializes jPanel_South	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_South() {
		if (jPanel_South == null) {
			jPanel_South = new JPanel();
			jPanel_South.setLayout(new GridBagLayout());
			jPanel_South.add(getJB_ok(), new GridBagConstraints());
			jPanel_South.setPreferredSize(new Dimension(80, 100));
			jPanel_South.setBackground(new Color(200, 221, 242));
		}
		return jPanel_South;
	}

	/**
	 * This method initializes jB_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_ok() {
		if (jB_ok == null) {
			jB_ok = new JButton(new ImageIcon("ok.jpg"));
			jB_ok.setBackground(new Color(200, 221, 242));
			jB_ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jB_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				dispose();
				}
			});
		}
		return jB_ok;
	}

	/**
	 * This method initializes jPanel_Center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Center() {
		if (jPanel_Center == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.weightx = 1.0;
			jPanel_Center = new JPanel();
			jPanel_Center.setLayout(new GridBagLayout());
			jPanel_Center.add(getJTabbedPane_Center(), gridBagConstraints);
		}
		return jPanel_Center;
	}

	/**
	 * This method initializes jTabbedPane_Center	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_Center() {
		if (jTabbedPane_Center == null) {
			jTabbedPane_Center = new JTabbedPane();
			jTabbedPane_Center.addTab("   Welcome", me, getJTextPane_Glance(), "Quick Review of BME Project");
			jTabbedPane_Center.addTab("   About BME Project", me, getJScrollPane_MEProject(), "About BME Project");
			jTabbedPane_Center.addTab("   User Guide", me, getJScrollPane_User(), "Help Content for BME Users");
			jTabbedPane_Center.addTab("   Working Sequence", me, getJTextPane_Sequence(), "A Possible Working Sequence");
			jTabbedPane_Center.addTab("   Important Points", me, getJTextPane_Points(), "Important Points");
		}
		return jTabbedPane_Center;
	}

	/**
	 * This method initializes jTextPane_Glance	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_Glance() {
		if (jTextPane_Glance == null) {
			jTextPane_Glance = new JTextPane();
			jTextPane_Glance.setEditable(false);
			jTextPane_Glance.setBackground(new Color(234, 234, 234));
			
			
			String str[]= {"BME APPLICATION AT A GLANCE", "Application Name:", "Blended Modeling Environment (BME)",
					"Version:", "1.0", "Release Date:", "April 01, 2024", "Developers:", " ",
					"Misbah Mehboob Awan" , " ", "", "Working:", 
					"This BME application is designed to provide a platform for providing a blended modeling environment for multiple concrete notations. It takes the input from one notation and "+
					"\n"+"   update all other notations accordingly. Ir provides a seamless runtime transformation from one concrete syntax to another. "+
					"\n"+ "   This facilitates shared understanding among all the stake-holders from diversed domains."};
			
			String styles[]={"caption", "headings", "text", "bullet"};
			
			StyledDocument doc = jTextPane_Glance.getStyledDocument();
	        addStylesToDocument(doc);
	        
	        int i=0;
	        
	        try
	        {
	        	doc.insertString(doc.getLength(), "\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[0]));
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t\t    ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\n\t         ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	doc.insertString(doc.getLength(), "       ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\t         ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	doc.insertString(doc.getLength(), "       ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t         ", null);
	        	doc.insertString(doc.getLength(), str[i], doc.getStyle(styles[2]));
	        }
	        
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
		
	        jTextPane_Glance.setCaretPosition(0);
		}
		return jTextPane_Glance;
	}

	
	/**
	 * This method initializes jTextPane_MEProject	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_MEProject() {
		if (jTextPane_MEProject == null) {
			jTextPane_MEProject = new JTextPane();
			jTextPane_MEProject.setEditable(false);
			jTextPane_MEProject.setBackground(new Color(234, 234, 234));
			
			
			String str[]={"ABOUT BME PROJECT", "Introduction:", "This Blended Modeling Environment (BME) application is developed by the MRED project as part of PhD research "+
					 " "+"\n"+ "  ", "This BME application is a positive step forward towards models transformation from one concrete sytax to another concrete syntax."//+
					 /*" execute UML state machines and "+"\n"+ "  display final output to the end user.", "Overview:", 
					 "Software developers use UML diagrams to generate code. Although this approach has improved the software development process, but at"+"\n"+
					 "  the same time, it has also prolonged the development process. Now designers have to write code based on these diagrams .This mapping between"+"\n"+
					 "  design and code has made the development process time consuming and error prone. This ME application will simplify this process for designers and"+"\n"+
					 "  developers. They do not have to perform this hard and time consuming task manually. Rather they will use ME to generate code from state machines.", 
					 " This application ensures the complete mapping of code onto state machine, reduces the gap between the design and implementation concepts and also "+"\n"+
					 "  eliminates the risk of creating code that is inconsistent with the model. It would also save the precious time of software developers and designers"+"\n"+
					 "  by reducing the coding time and effort.", 
					 "This ME application works by taking xml file as input. The xml file contains the information of state machines and class diagram. This information is "+"\n"+
					 "  used to generate equivalent java code. The java code is then executed and final output is displayed to the end user.", "Intended Users:", 
					 "The users of this ME application will be �Software Researchers� which include:", " " ,"Software Designers" , " " , "Software Developers"};*/};
			
			String styles[]={"caption", "headings", "text", "bullet"};
			
			StyledDocument doc = jTextPane_MEProject.getStyledDocument();
	        addStylesToDocument(doc);
	        
	        int i=0;
	        
	        try
	        {
	        	doc.insertString(doc.getLength(), "\t\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[0]));
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));	   
	        	doc.insertString(doc.getLength(), "\n\t              ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));	   
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));	   
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t                     ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	doc.insertString(doc.getLength(), "       ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	
	        	
	        	doc.insertString(doc.getLength(), "\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	doc.insertString(doc.getLength(), "       ", null);
	        	doc.insertString(doc.getLength(), str[i], doc.getStyle(styles[2]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\n", null);
	        }
	        
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
	        jTextPane_MEProject.setCaretPosition(0);
	        
	        
		}
		return jTextPane_MEProject;
	}

	/**
	 * This method initializes jScrollPane_MEProject	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_MEProject() {
		if (jScrollPane_MEProject == null) {
			jScrollPane_MEProject = new JScrollPane();
			jScrollPane_MEProject.setViewportView(getJTextPane_MEProject());
		}
		return jScrollPane_MEProject;
	}

	/**
	 * This method initializes jTextPane_Points	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_Points() {
		if (jTextPane_Points == null) {
			jTextPane_Points = new JTextPane();
			jTextPane_Points.setEditable(false);
			jTextPane_Points.setBackground(new Color(234, 234, 234));
			
			String str[]={"IMPORTANT POINTS", " ",
					"  Multiple projects can be created. All these projects are saved in C:\\BME folder.", " ", 

					"  Only one project can be opened at a time.", " ",

					"  A list of all projects is displayed in the right panel of the BME editor. Currently opened project is displayed in the left panel.", " ",

				/*	"  When user imports XML file, this file is automatically made a part of the currently opened project by saving the imported XMI file in the "+"\n\t"+"following folder: "+"\n\t"+"\t\t C:\\ME\\<Currently Opened Project Name>\\XMI", " ",

					"  The XMI file imported should be error-free, as importing an incorrect file may result in unexpected output.", " ",

					"  State machines taken as input may contain action language. ", " ",

					"  The only action language supported by this application is ASL (Action Specification Language). No other action language is currently"+"\n\t"+"supported.", " ",

					"  Picture formats are not supported by this BME application."*/};

			String styles[]={"caption", "text", "bullet"};
			
			StyledDocument doc = jTextPane_Points.getStyledDocument();
	        addStylesToDocument(doc);
	        
	        int i=0;
	        
	        try
	        {
	        	doc.insertString(doc.getLength(), "\t\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[0]));
	        	doc.insertString(doc.getLength(), "\n\n\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n           ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        }
	        
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
	        jTextPane_Points.setCaretPosition(0);
	        
		}
		return jTextPane_Points;
	}

	/**
	 * This method initializes jTextPane_User	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_User() {
		if (jTextPane_User == null) {
			jTextPane_User = new JTextPane();
			jTextPane_User.setEditable(false);
			jTextPane_User.setBackground(new Color(234, 234, 234));
			
			StyledDocument doc = jTextPane_User.getStyledDocument();
	        addStylesToDocument(doc);
	        
	        String str[]={"USER GUIDE", " The editor of BME application is divided in 5 sections.", 
	        		"1)  Currently Opened Project:", "The left panel of the BME editor displays the currently opened project. At a time, only one project can be opened "+"\n"+"         for working.", 
	        		"2)  All Existing BME Projects:", "The right panel of the editor displays a list of all existing ME projects. These projects are present in the"+"\n"+"         \"C:\\BME\" folder.",
	        		//"3)  Center Panel:", "The center panel of the editor is used for displaying files. Multiple files can be opened at the same time.", 
	        		//"4)  Console:", "The bottom panel of the editor is used as a console for displaying final output to the end-user. Moreover, error messages are also"+"\n"+"         displayed in this panel.", 
	        		//"5)  Menu Bar and Toolbar:", "The top of ME editor contains a Menu bar and a Toolbar. All options of the Menu Bar are also available in "+"\n"+"         the toolbar for ease of use and quick selection." ,
	        		//" ", "File Menu", "New Project:", 
	        		//"This option enables the user to create new project. This new project is created in C:\\ME folder and is displayed"+"\n\t\t\t      "+
	        		//"in the left panel. Project name is provided by the user. New project is created with the following structure:", " ", 
	        		/*"C:\\ ME\\ <Project Name> \\XMI \\ Source XMI", " ", *///"C: \\ ME \\<Project Name> \\ XMI \\", " ",
	        		/*"C:\\ ME\\ <Project Name> \\ Java Code" ," ","C: \\ ME \\ <Project Name> \\ Executables", 
	        		"If a project is already opened (i.e. displayed in the left panel), user will be asked to close the currently opened"+"\n\t\t\t     "+" project, as only one project can be opened at a time.", 
	        		"Close Project:", "This option allows the user to close the currently opened project.", 
	        		"Delete Project:", "Selecting this option will enable the user to delete the currently opened project.", 
	        		"Open File:", "A text file can be opened by selecting this option. Picture formats are not supported. The opened file is displayed"+"\n\t\t\t "+" in the center panel.",
	        		"Close File:", "This option permits the user to close the file which is currently in focus. The user can also close the file by "+"\n\t\t\t "+" making right-click on the tab and selecting the appropriate option.", 
	        		"Exit:", "This option is used to close the ME application.", 
	        		
	        		" ", "Edit Menu", "Import XMI File:", "This option facilitates the user to import XMI file containing information of state machine and class diagram."+"\n\t\t\t       "+"     The content of XMI file is displayed in the center panel. The imported XMI file is automatically made a part"+"\n\t\t\t       "+"     of the currently opened project. ",
	        		"Generate Code:", "This option is used to generate code corresponding to the state machine stored in the XMI file of the current"+"\n\t\t\t       "+"   project. The target language of the generated code is �Java�.",
	        		"Execute Model:", "This option is used to execute the java code, stored in the currently opened project�s folder. The output of this"+"\n\t\t\t       "+"   code is displayed on the bottom panel i.e. console.", 
	        		
	        		" ", "Help Menu", "About BME Project:", "This option opens the frame for displaying Help Content to the user.", 
	        		"About Us:", "This option allows the user to see information of the developers of ME application."*/};
	        
	        String styles[]={"caption", "headings", "sub-headings", "text", "sub-sub", "bullet", "sub-bullet"};
	        
	        int i=0;
	        
	        try
	        {
	        	doc.insertString(doc.getLength(), "\t\t\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[0]));
	        	doc.insertString(doc.getLength(), "\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t\t\t         ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t\t\t       ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t          ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	doc.insertString(doc.getLength(), "\n\t\t\t  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n       ", null);//bullet
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[5]));
	        	doc.insertString(doc.getLength(), "     ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));//heading
	        	doc.insertString(doc.getLength(), "\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading	        	
	        	doc.insertString(doc.getLength(), "\n\t\t\t       ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[6]));//sub-bullet
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[6]));//sub-bullet
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	/*doc.insertString(doc.getLength(), "\n\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[6]));//sub-bullet
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	*/
	        	doc.insertString(doc.getLength(), "\n\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[6]));//sub-bullet
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\t\t\t        ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t         ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t            ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	//open file
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t  ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text

	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t            ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	//Edit Menu
	        	doc.insertString(doc.getLength(), "\n\n       ", null);//bullet
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[5]));
	        	doc.insertString(doc.getLength(), "     ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));//heading
	        	doc.insertString(doc.getLength(), "\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading	        	
	        	doc.insertString(doc.getLength(), "\n\t\t\t                ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
//	        	Help Menu
	        	doc.insertString(doc.getLength(), "\n\n       ", null);//bullet
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[5]));
	        	doc.insertString(doc.getLength(), "     ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));//heading
	        	doc.insertString(doc.getLength(), "\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading	        	
	        	doc.insertString(doc.getLength(), "\n\t\t\t                   ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[4]));//sub-heading
	        	doc.insertString(doc.getLength(), "\n\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[3]));//text
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n\n", null);
	        	
	        }
	        
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
	        jTextPane_User.setCaretPosition(0);
		}
		return jTextPane_User;
	}

	/**
	 * This method initializes jTextPane_Sequence	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_Sequence() {
		if (jTextPane_Sequence == null) {
			jTextPane_Sequence = new JTextPane();
			jTextPane_Sequence.setEditable(false);
			jTextPane_Sequence.setBackground(new Color(234, 234, 234));
			
			StyledDocument doc = jTextPane_Sequence.getStyledDocument();
	        addStylesToDocument(doc);
			
			String str[]={"A Possible Working Sequence", " ",
					/*"Create a new project or select an already existing project from the right panel. When user clicks on any file of the project displayed in the"+"\n\t"+
					"right panel, the project gets selected and is displayed in the left panel.", " ", 
					"Select the option for importing XMI file. This XMI file is automatically stored in the �XMI� folder of the current project and is also"+"\n\t"+
					"displayed to the user. This XMI file is then parsed and converted to an instance of meta-model.", " ", 
					"Click the option for generating code. It produces the java code equivalent to the XMI file and stores this file of code in the �Java Code�"+"\n\t"+
					"folder of the currently opened project.", " ", 
					"Choose the option of executing model. This will execute the java code stored in the current project�s folder and displays output on the"+"\n\t"+
					"console of this ME application."*/};
			
			String styles[]={"caption", "text", "bullet"};
			
			int i=0;
			
			try
			{
				doc.insertString(doc.getLength(), "\t\t\t\t", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[0]));
	        	doc.insertString(doc.getLength(), "\n\n\n\n             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
	        	
	        	doc.insertString(doc.getLength(), "\n\n\n             ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[2]));
	        	doc.insertString(doc.getLength(), "      ", null);
	        	doc.insertString(doc.getLength(), str[i++], doc.getStyle(styles[1]));
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			jTextPane_Sequence.setCaretPosition(0);
		}
		return jTextPane_Sequence;
	}

	/**
	 * This method initializes jScrollPane_User	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_User() {
		if (jScrollPane_User == null) {
			jScrollPane_User = new JScrollPane();
			jScrollPane_User.setViewportView(getJTextPane_User());
		}
		return jScrollPane_User;
	}

	
	
	public void addStylesToDocument(StyledDocument doc)
	{
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style regular = doc.addStyle("text", def);
		StyleConstants.setFontSize(def, 16);
		StyleConstants.setFontFamily(def, "Garamond");
		StyleConstants.setForeground(def, Color.BLACK);
		
		Style s = doc.addStyle("headings", regular);
		StyleConstants.setFontSize(s, 18);
		StyleConstants.setFontFamily(s, "Times New Roman");
		StyleConstants.setBold(s, true);
		
		s = doc.addStyle("caption", regular);
		StyleConstants.setFontFamily(s, "Bookman Old Style");
		StyleConstants.setFontSize(s, 24);
		StyleConstants.setBold(s, true);
		
		s = doc.addStyle("sub-headings", regular);
		StyleConstants.setFontFamily(s, "Times New Roman");
		StyleConstants.setFontSize(s, 17);
		StyleConstants.setBold(s, true);
		StyleConstants.setUnderline(s, true);
		
		s = doc.addStyle("sub-sub", regular);
		StyleConstants.setFontFamily(s, "Times New Roman");
		StyleConstants.setFontSize(s, 16);
		StyleConstants.setBold(s, true);
		
		s = doc.addStyle("bullet", regular);
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_LEFT);
		Icon icon = new ImageIcon("bullet.gif");
		StyleConstants.setIcon(s, icon);

		s = doc.addStyle("sub-bullet", regular);
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_LEFT);
		Icon icon_bullet = new ImageIcon("sub-bullet.gif");
		StyleConstants.setIcon(s, icon_bullet);
	}

	
	
}
