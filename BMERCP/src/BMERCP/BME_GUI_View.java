package BMERCP;

import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;

//import jakarta.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import GUIEditor.GUI_Handler;

public class BME_GUI_View extends ViewPart {
	//public static final String ID = "BMERCP.view";

	//@Inject IWorkbench workbench;
	
	//private TableViewer viewer;
	
	
	@Override
	public void createPartControl(Composite parent) {
		 
		 //parent.getShell().setMinimized(true);
		 //parent.getShell().dispose();
		/*viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.getTable().setLinesVisible(true);

		TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
		column.setLabelProvider(new StringLabelProvider());

		viewer.getTable().getColumn(0).setWidth(200);
		
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		
		// Provide the input to the ContentProvider
		viewer.setInput(createInitialDataModel());
		*/	 
		
        // Create a Composite with the SWT.EMBEDDED style
        Composite composite = new Composite(parent, SWT.EMBEDDED);
        
        // Create an AWT Frame within the Composite
        Frame frame = SWT_AWT.new_Frame(composite);
        
        //frame.setSize(1800, 800);
        //frame.setLocation(0, 0);
		
		//setPartName("MRED");
		//setTitleImage();
        // Initialize your main Swing frame here
        SwingUtilities.invokeLater(() -> {
            // Assuming your main frame class is called MainFrame
        	GUI_Handler mainFrame = null;
			try {
				 mainFrame = new GUI_Handler();
				//GUI_Handler mainFrame = new GUI_Handler();
                //mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //mainFrame.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			frame.add(mainFrame.getJJMenuBar());
            frame.add(mainFrame.getContentPane());
            frame.pack();
            mainFrame.getContentPane();
            //mainFrame.setVisible(true);
            //frame.setVisible(false);
            //frame.dispose();
			//GUI_Handler.main(null);
        });
        //frame.setSize(2000, 1000);
        //parent.getShell().setSize(1800, 1000);
        //frame.setLocation(0, 0);
        parent.getShell().setMaximized(true);   
        
        
        ImageDescriptor descriptor = ImageDescriptor.createFromURL(getClass().getResource("/resources/icons/MRED.jpg"));
        System.out.println("im here in image icon in view descriptor: "+descriptor);
        Image image = descriptor.createImage();
        parent.getShell().setImage(image);
       
	}


	@Override
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
    
}