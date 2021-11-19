package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import controller.ListenerController;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Studentska služba");
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/4, height *3/4);
		setLocationRelativeTo(null);
		
		Image img = kit.getImage("src/main_icon/icon.jpg");
		setIconImage(img);
		
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar tb = new ToolBar();
		getContentPane().add(tb, BorderLayout.NORTH);

		StatusBar status = new StatusBar();
		status.setPreferredSize(new Dimension(this.getWidth(), 30));
		add(status, BorderLayout.SOUTH);
		
		JTabbedPane tab = new JTabbedPane();
		StudentPanel studentPanel = new StudentPanel();
		ProfessorPanel professorPanel = new ProfessorPanel();
		SubjectPanel subjectPanel = new SubjectPanel();
		tab.addTab("Studenti", studentPanel);
		tab.addTab("Profesori", professorPanel);
		tab.addTab("Predmeti", subjectPanel);
		add(tab);
		
		ListenerController.tabListener(tab, status);

		setVisible(true);
		
	}
}
