package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ListenerController;
import view.tabs.tabPanels.InformationProfessor;
import view.tabs.tabPanels.InformationStudent;
import view.tabs.tabPanels.SubjectsListProfessor;

public class ChangeProfessorDialog extends JDialog{
	
	private InformationProfessor info;
	
	public ChangeProfessorDialog() {
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Izmena profesora");
		getContentPane().setBackground(Color.DARK_GRAY);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height * 3/4);
		setLocationRelativeTo(null);
		
		JTabbedPane tab = new JTabbedPane();
		info = new InformationProfessor();
		SubjectsListProfessor subj = new SubjectsListProfessor(); 
		ListenerController.closeWindowOnCancelListener(this, info.getButtons().get(1));
		tab.addTab("Info", info);
		info.setBackground(Color.DARK_GRAY);
		tab.addTab("Predmeti", subj);
		subj.setBackground(Color.DARK_GRAY);
		add(tab);
		
	}
	
	public ArrayList<JTextField> getDataInputs() {
		return info.getDataInputs();
	}
	
	public JComboBox getCombo() {
		return info.getCombo();
	}
	
	public JTextField getTextField(int index) {
		return info.getTextField(index);
	}
	
	public InformationProfessor getInformationPanel() {
		return info;
	}
}
