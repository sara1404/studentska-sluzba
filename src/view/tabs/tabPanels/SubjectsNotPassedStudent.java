package view.tabs.tabPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import bundle.LanguageSupport;
import model.CustomListModelForNotPassedSubjects;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Student;
import model.Subject;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.MainFrame;
import view.dialogs.AssignSubjectToStudent;
import view.dialogs.GradeEntry;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class SubjectsNotPassedStudent extends JPanel{
	private JList<String> subjectList;
	GradeEntry gradeEntry; 
	SubjectsNotPassedTable notPassed;
	JButton addBtn;
	JButton removeBtn;
	JButton passBtn;
	SubjectsNotPassedStudent cxt = this;
	AssignSubjectToStudent dialog;
	public SubjectsNotPassedStudent() {
		JPanel buttonPanel = new JPanel();
		BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box);
		gradeEntry = new GradeEntry();
	   
		addBtn = new JButton();
		removeBtn = new JButton();
		passBtn = new JButton();
		
		addBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("addBtn"));
		removeBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeBtn"));
		passBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("passBtn"));
		
		WindowComponentBuilder.setContainerSize(addBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(removeBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(passBtn, 100, 30);
		
		Utils.setCursor(addBtn);
		Utils.setCursor(removeBtn);
		Utils.setCursor(passBtn);
		
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.add(passBtn);
		
		add(buttonPanel);

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new AssignSubjectToStudent();
				dialog.setVisible(true);
			}
		});

		removeBtn.addActionListener(new ActionListener() {
			int resp = 0;
			@Override

			public void actionPerformed(ActionEvent e) {
				if(notPassed.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(cxt, LanguageSupport.getInstance().getResourceBundle().getString("editStudentMessage2"));
				else{
					resp = JOptionPane.showConfirmDialog(cxt, LanguageSupport.getInstance().getResourceBundle().getString("editStudentQuestion2"),
							 LanguageSupport.getInstance().getResourceBundle().getString("editStudentTitle2"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
						student.getFailedExams().remove(student.getFailedExams().get(notPassed.getSelectedRow()));
						ObserverNotifier.getInstance().subjectsNotPassedDataChanged();
					}
				}


			}
		});

		passBtn.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setGradeEntry();
				String index = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
				Student student = DatabaseReader.getInstance().findStudent(index);
				try {
					int id = MainFrame.getInstance().getChangeStudentDialog().getSubjectNotPassedStudent().getNotPassed().getSelectedRow();
					String key = student.getFailedExams().get(id).getSubjectKey();
					Subject subject = DatabaseReader.getInstance().findSubject(key);
					gradeEntry.fillingInfo(subject);
				gradeEntry.getApplyBtn().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gradeEntry.dispose();
					}
				});
				
				gradeEntry.getCancelBtn().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gradeEntry.dispose();					}
				});
				gradeEntry.setVisible(true);
				
				} catch (Exception ex){
					JOptionPane.showMessageDialog(notPassed, LanguageSupport.getInstance().getResourceBundle().getString("editStudentMessage3"));;
				}
				
			}
		});
		
		notPassed = new SubjectsNotPassedTable();
		add(new JScrollPane(notPassed));
	}
	public GradeEntry getGradeEntry() {
		return gradeEntry;
	}
	public SubjectsNotPassedTable getNotPassed() {
		return notPassed;
	}
	
	public void  setGradeEntry() {
		gradeEntry = new GradeEntry();
	}
	
	private void setTableColumnNames() {
		AbstractTableModelSubjectsNotPassed model = (AbstractTableModelSubjectsNotPassed) notPassed.getModel();
		
		for(int i = 0; i < notPassed.getColumnCount();i++) {
			notPassed.getColumnModel().getColumn(i).setHeaderValue(model.getColumnString(i));
		}
	}
	
	
	public void initComponents() {
		ResourceBundle resourceBundle = LanguageSupport.getInstance().getResourceBundle();
		addBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("addBtn"));
		removeBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeBtn"));
		passBtn.setText(LanguageSupport.getInstance().getResourceBundle().getString("passBtn"));
		setTableColumnNames();
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}
	
}
