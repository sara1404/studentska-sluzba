package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		setTitle("Studentska služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/4, height *3/4);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		setVisible(true);
	}
}
