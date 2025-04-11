package GUIEditor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("My Swing Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");
        panel.add(button);
        getContentPane().add(panel);
    }
}

