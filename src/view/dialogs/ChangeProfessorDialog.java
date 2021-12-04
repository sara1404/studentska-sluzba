package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import view.tabs.tabPanels.InformationProfessor;
import view.tabs.tabPanels.SubjectsListProfessor;

public class ChangeProfessorDialog extends JDialog{
	
	public ChangeProfessorDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Izmena profesora");
		getContentPane().setBackground(Color.DARK_GRAY);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height * 3/4);
		setLocationRelativeTo(null);
		
		JTabbedPane tab = new JTabbedPane();
		InformationProfessor info = new InformationProfessor();
		SubjectsListProfessor subj = new SubjectsListProfessor(); 
		tab.addTab("Informacije", info);
		info.setBackground(Color.DARK_GRAY);
		tab.addTab("Spisak predmeta", subj);
		subj.setBackground(Color.DARK_GRAY);
		add(tab);
		
		setVisible(true);
	}

}
