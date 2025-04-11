package GUIEditor;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class Exit extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel_North = null;

	private JLabel jLabel_Center = null;

	private JButton jButton_South = null;

	private JPanel jPanel_North = null;

	private JPanel jPanel_Center = null;

	private JPanel jPanel_South = null;

	/**
	 * This is the default constructor
	 */
	public Exit() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(340, 170);
		this.setLocation(470, 220);
		this.setContentPane(getJContentPane());
		//this.setBackground(new Color(200, 221, 242));
		this.setTitle("System is closing.");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Icon i=new ImageIcon("");
			jLabel_Center = new JLabel("", i, 0);
			//jLabel_Center.setText("JLabel");
			jLabel_North = new JLabel();
			jLabel_North.setText("System is closing.");
			jLabel_North.setFont(new Font("Dialog",Font.BOLD,16));
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_North(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_Center(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_South(), BorderLayout.SOUTH);
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton_South	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_South() {
		if (jButton_South == null) {
			jButton_South = new JButton();
			jButton_South.setText("  OK  ");
			jButton_South.setVerticalAlignment(SwingConstants.CENTER);
			jButton_South.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jButton_South.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				
					System.exit(0);
				}
			});
		}
		return jButton_South;
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
			jPanel_North.add(jLabel_North, new GridBagConstraints());
			jPanel_North.setBackground(new Color(200, 221, 242));
			jPanel_North.setPreferredSize(new Dimension(-1, 60));
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
			jPanel_Center = new JPanel();
			jPanel_Center.setLayout(new GridBagLayout());
			jPanel_Center.add(jLabel_Center, new GridBagConstraints());
			jPanel_Center.setBackground(new Color(200, 221, 242));
			jPanel_Center.setPreferredSize(new Dimension(-1, 150));
		}
		return jPanel_Center;
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
			jPanel_South.add(getJButton_South(), new GridBagConstraints());
			jPanel_South.setBackground(new Color(200, 221, 242));
			jPanel_South.setPreferredSize(new Dimension(-1, 100));
		}
		return jPanel_South;
	}

}
