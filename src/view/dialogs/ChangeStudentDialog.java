package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bundle.LanguageSupport;
import controller.ListenerController;
import controller.ShowPassedExamsForStudentController;
import model.ObserverNotifier;
import view.listeners.ChangeStudentListener;
import view.tabs.tabPanels.InformationStudent;
import view.tabs.tabPanels.SubjectsNotPassedStudent;
import view.tabs.tabPanels.SubjectsPassedStudent;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class ChangeStudentDialog extends JDialog implements WindowListener {
	private InformationStudent info;
	private SubjectsPassedStudent subPassed;
	private SubjectsNotPassedStudent subNotPassed;
	public ChangeStudentDialog() {
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("editStudDialogTitle"));
		getContentPane().setBackground(Color.DARK_GRAY);
		addWindowListener(this);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		tab1.addTab(LanguageSupport.getInstance().getResourceBundle().getString("studInfo"), info);
		

		ListenerController.closeWindowOnCancelListener(this, info.getButtonsInAddStudentForm().get(1));
		JButton confirmBtn = info.getButtonsInAddStudentForm().get(0);
		confirmBtn.addActionListener(ChangeStudentListener.studentChangingListener(confirmBtn));
		
		subPassed = new SubjectsPassedStudent();
		subPassed.setPreferredSize(new Dimension(200, 200));
		subPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab(LanguageSupport.getInstance().getResourceBundle().getString("passedSubs"), subPassed);
		
		
		
		subNotPassed = new SubjectsNotPassedStudent();
		subNotPassed.setPreferredSize(new Dimension(200, 200));
		subNotPassed.setBackground(Color.DARK_GRAY);
		tab1.addTab(LanguageSupport.getInstance().getResourceBundle().getString("failedSubs"), subNotPassed);
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

	public ArrayList<JTextField> getTextFields(){
		return info.getTextFields();
	}

	public SubjectsPassedStudent getSubjectPassedStudent(){
		return subPassed;
	}
	
	public SubjectsNotPassedStudent getSubjectNotPassedStudent(){
		return subNotPassed;
	}
	
	public void initComponents() {
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("editStudDialogTitle"));
		subNotPassed.initComponents();
		subPassed.initComponents();
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		ObserverNotifier.getInstance().studentsDataChanged();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
