package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		setTitle("Studentska slu�ba");

		getContentPane().setBackground(Color.DARK_GRAY);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/4, height *3/4);
		setLocationRelativeTo(null);
		
		ToolBar tb = new ToolBar();
		getContentPane().add(tb, BorderLayout.NORTH);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		setVisible(true);
	}
}
