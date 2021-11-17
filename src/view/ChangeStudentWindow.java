package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class ChangeStudentWindow extends JDialog{
	public ChangeStudentWindow() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Izmena studenta");
		getContentPane().setBackground(Color.DARK_GRAY);

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height * 3/4);
		setLocationRelativeTo(null);
		
		JTabbedPane tab1 = new JTabbedPane();
		tab1.setBackground(Color.GRAY);
		
		InformationStudent info = new InformationStudent();
		BoxLayout box = new BoxLayout(info, BoxLayout.Y_AXIS);
		info.setLayout(box);
		info.setPreferredSize(new Dimension(200, 400));
		info.setBackground(Color.DARK_GRAY);
		tab1.addTab("Informacije", info);
		

		
		
		SubjectsPassedStudent subPassed = new SubjectsPassedStudent();
		subPassed.setPreferredSize(new Dimension(200, 200));
		subPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab("Polozeni", subPassed);
		
		
		
		SubjectsNotPassedStudent subNotPassed = new SubjectsNotPassedStudent();
		subNotPassed.setPreferredSize(new Dimension(200, 200));
		subNotPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab("Nepolozeni", subNotPassed);
		add(tab1);
		
		setVisible(true);
	}
}
