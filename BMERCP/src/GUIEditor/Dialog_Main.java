package GUIEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.*;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Dialog_Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel_Center = null;

	private JLabel jLabel_Text = null;

	private JComboBox jComboBox_main = null;

	private JPanel jPanel_South = null;  //  @jve:decl-index=0:visual-constraint="155,312"

	private JButton jB_OK = null;
	
	
	public String s_main=null;  //  @jve:decl-index=0:
	public String last_path=null;  //  @jve:decl-index=0:
	public String code_package=null;  //  @jve:decl-index=0:
	public String code_path=null;  //  @jve:decl-index=0:

	private JLabel jLabel_Blank = null;

	private JLabel jLabel_Blank2 = null;

	private JLabel jLabel_Blank3 = null;

	private JLabel jLabel_Blank4 = null;

	private JLabel jLabel_Blank5 = null;

	private JButton jB_Import = null;

	/**
	 * This is the default constructor
	 */
	public Dialog_Main(Vector v, String lp, String cp, String cpath) {
		super();
		initialize(v, lp, cp, cpath);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize(Vector v, String lp, String cp, String cpath) {
		this.setSize(330, 300);
		this.setLocation(450, 230);
		this.setContentPane(getJContentPane(v));
		this.setResizable(false);
		this.setTitle("Select main...");
		s_main=v.get(0).toString();
		
		last_path=lp;
		code_package=cp;
		code_path=cpath;
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane(Vector v) {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_Center(v), BorderLayout.CENTER);
			jContentPane.add(getJPanel_South(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	


	/**
	 * This method initializes jPanel_Center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Center(Vector v) {
		if (jPanel_Center == null) {
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 5;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 5;
			jLabel_Blank5 = new JLabel();
			jLabel_Blank5.setText("    User Defined Main");
			//jLabel_Blank5.setForeground(new Color(200, 221, 242));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 4;
			jLabel_Blank4 = new JLabel();
			jLabel_Blank4.setText("JLabel4");
			jLabel_Blank4.setForeground(new Color(200, 221, 242));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 3;
			jLabel_Blank3 = new JLabel();
			jLabel_Blank3.setText("JLabel3");
			jLabel_Blank3.setForeground(new Color(200, 221, 242));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 2;
			jLabel_Blank2 = new JLabel();
			jLabel_Blank2.setText("JLabel2");
			jLabel_Blank2.setForeground(new Color(200, 221, 242));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			jLabel_Blank = new JLabel();
			jLabel_Blank.setText("JLabel");
			jLabel_Blank.setForeground(new Color(200, 221, 242));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jLabel_Text = new JLabel();
			jLabel_Text.setText("     Select main");
			jPanel_Center = new JPanel();
			jPanel_Center.setLayout(new GridBagLayout());
			jPanel_Center.add(jLabel_Text, gridBagConstraints);
			jPanel_Center.add(getJComboBox_main(v), gridBagConstraints1);
			jPanel_Center.setBackground(new Color(200, 221, 242));
			jPanel_Center.add(jLabel_Blank, gridBagConstraints2);
			jPanel_Center.add(jLabel_Blank2, gridBagConstraints3);
			jPanel_Center.add(jLabel_Blank3, gridBagConstraints4);
			jPanel_Center.add(jLabel_Blank4, gridBagConstraints5);
			jPanel_Center.add(jLabel_Blank5, gridBagConstraints8);
			jPanel_Center.add(getJB_Import(), gridBagConstraints9);
	;
		}
		return jPanel_Center;
	}

	/**
	 * This method initializes jComboBox_main	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_main(Vector v) {
		if (jComboBox_main == null) {
			jComboBox_main = new JComboBox(v);
		}
		return jComboBox_main;
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
			jPanel_South.add(getJB_OK(), new GridBagConstraints());
			jPanel_South.setPreferredSize(new Dimension(60, 100));
			jPanel_South.setBackground(new Color(200, 221, 242));;
		}
		return jPanel_South;
	}

	/**
	 * This method initializes jB_OK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_OK() {
		if (jB_OK == null) {
			jB_OK = new JButton("  OK  ");
			jB_OK.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			jB_OK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				//	System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				s_main=jComboBox_main.getSelectedItem().toString();
				
				dispose();
				BME.getInstance().execute(last_path, code_package, code_path, s_main);

				}
			});
		}
		return jB_OK;
	}

	/**
	 * This method initializes jB_Import	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJB_Import() {
		if (jB_Import == null) {
			jB_Import = new JButton();
			jB_Import.setText("  Browse main  ");
			jB_Import.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
				
					dispose();
					Frame parent = new Frame();
					FileDialog fd = new FileDialog(parent, "Please select a file:", FileDialog.LOAD);
					fd.setVisible(true);
					String path=fd.getDirectory()+File.separator+fd.getFile();
					
					String filelines=BME.getInstance().import_xmi_file(path);
					
			
					int i=0;
					for(i=path.length();i>=0;i--)
					{
						if(path.charAt(i-1)=='\\')
						{
							break;
						}//end if
						
					}//end for
					
					String file_name=path.substring(i, path.length());
					
					try
					{
					  
						BufferedWriter bw1=new BufferedWriter(new FileWriter(code_path+"\\"+file_name));
						bw1.write(filelines);
						bw1.close();
					}
					catch(Exception ee)
					{System.out.println(ee);}
					
					s_main=file_name;
					//Execute ex=new Execute();
					BME.getInstance().execute(last_path, code_package, code_path, s_main);
					//ex.execute(last_path, code_package, code_path, s_main);
					
					//System.out.println("after execute class");
				
					//GUI_Handler.getInstance().setText();
				
				}
			});
		}
		return jB_Import;
	}	
	
}
