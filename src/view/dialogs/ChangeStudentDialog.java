package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ListenerController;
import view.listeners.ChangeStudentListener;
import view.tabs.tabPanels.InformationStudent;
import view.tabs.tabPanels.SubjectsNotPassedStudent;
import view.tabs.tabPanels.SubjectsPassedStudent;

public class ChangeStudentDialog extends JDialog{
	private InformationStudent info;
	public ChangeStudentDialog() {
		setModalityType(DEFAULT_MODALITY_TYPE);
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
		
		info = new InformationStudent();
		BoxLayout box = new BoxLayout(info, BoxLayout.Y_AXIS);
		info.setLayout(box);
		info.setPreferredSize(new Dimension(200, 400));
		info.setBackground(Color.DARK_GRAY);
		tab1.addTab("Informacije", info);
		

		ListenerController.closeWindowOnCancelListener(this, info.getButtonsInAddStudentForm().get(1));
		JButton confirmBtn = info.getButtonsInAddStudentForm().get(0);
		confirmBtn.addActionListener(ChangeStudentListener.studentChangingListener(confirmBtn));
		
		SubjectsPassedStudent subPassed = new SubjectsPassedStudent();
		subPassed.setPreferredSize(new Dimension(200, 200));
		subPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab("Polozeni", subPassed);
		
		
		
		SubjectsNotPassedStudent subNotPassed = new SubjectsNotPassedStudent();
		subNotPassed.setPreferredSize(new Dimension(200, 200));
		subNotPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab("Nepolozeni", subNotPassed);
		add(tab1);
		
	}
	
	public JTextField getTextFieldAt(int index) {
		return info.getTextFieldAt(index);
	}
	
	public JComboBox getComboAt(int index) {
		return info.getComboAt(index);
	}
	
	public InformationStudent getInformationPanel() {
		return info;
	}
}
