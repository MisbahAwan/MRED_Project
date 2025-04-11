package GUIEditor;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import javax.swing.*;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.*;
import javax.swing.JButton;




public class About_Developers extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel_North = null;

	private JPanel jPanel_Center = null;

	private JTextPane jTextPane_Center = null;

	
	String str[]={"Developers", "Misbah Mehboob Awan", "PhD Software Engineering", 
					"", "", "MRED PROJECT",
					"Supervisor", "________________", 
					"Institution", "____________________________"};
	String[] styles = { "caption", "bold", "regular",
						"bold", "regular", "italic", 
						"caption", "bold", "caption", "bold"};

	private JPanel jPanel_South = null;

	private JButton jB_ok = null;

	/**
	 * This is the default constructor
	 */
	public About_Developers() {
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
		this.setSize(580, 570);
		this.setLocation(370, 60);
		this.setContentPane(getJContentPane());
		this.setTitle("About BME Developers");
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
			jContentPane.add(getJPanel_Center(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_South(), BorderLayout.SOUTH);
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
			Icon i=new ImageIcon("me_title.jpg");
			JLabel label=new JLabel("", i, 0);
			jPanel_North.add(label);
			jPanel_North.setBackground(new Color(200, 221, 242));
			
		}
		return jPanel_North;
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
			jPanel_Center.add(getJTextPane_Center(), gridBagConstraints);
		}
		return jPanel_Center;
	}

	/**
	 * This method initializes jTextPane_Center	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_Center() {
		if (jTextPane_Center == null) {
			jTextPane_Center = new JTextPane();
			jTextPane_Center.setEditable(false);
			jTextPane_Center.setBackground(new Color(200, 221, 242));
			
			StyledDocument doc = jTextPane_Center.getStyledDocument();
	        addStylesToDocument(doc);
	       
	        
			try
			{
				
				 doc.insertString(doc.getLength(), "\n", null);
				for(int i=0; i<str.length; i++)
				{
					doc.insertString(doc.getLength(), "\n           ", null);
					
					if(i!=0&&i!=6&&i!=8)
						doc.insertString(doc.getLength(), "\t\t", null);
					
					doc.insertString(doc.getLength(), str[i], doc.getStyle(styles[i]));
					
					if(i==2||i==4)
						doc.insertString(doc.getLength(), "\n", doc.getStyle(styles[i]));
					
					if(i==5||i==7)
						doc.insertString(doc.getLength(), "\n\n", doc.getStyle(styles[i]));
				}
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		return jTextPane_Center;
	}

	
	
	public void addStylesToDocument(StyledDocument doc)
	{
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style regular = doc.addStyle("regular", def);
        StyleConstants.setFontSize(def, 16);
        StyleConstants.setFontFamily(def, "Times New Roman");
        StyleConstants.setForeground(def, Color.BLACK);

        Style s = doc.addStyle("caption", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setFontSize(s, 18);
        StyleConstants.setFontFamily(s, "Times New Roman");
        StyleConstants.setSpaceAbove(s, 14);
        StyleConstants.setSpaceBelow(s, 14);
        
        s = doc.addStyle("bold", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setFontFamily(def, "Garamond");
        
        s = doc.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);
        StyleConstants.setBold(s, true);
        StyleConstants.setFontFamily(s, "Times New Roman");
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
			jPanel_South.setPreferredSize(new Dimension(100, 100));
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
	
	
	
	
}
