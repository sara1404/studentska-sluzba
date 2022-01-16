package view.tabs.tabPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import utils.Utils;
import view.MainFrame;
import view.tabs.tabPanels.tabels.AbstractTableModelProfessorTeachSubjects;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;

public class SubjectsPassedStudent extends JPanel{
	JLabel averageGradeLabel;
	JLabel espbSumLabel;
	private JList<String> subjectList;
	SubjectsPassedTable passed;
	SubjectsNotPassedTable notPassed;
	JButton removeGrade;
	JLabel averageGrade;
	JLabel espbSum;
	SubjectsPassedStudent sps = this;
	public SubjectsPassedStudent() {
		
		removeGrade = new JButton();
		removeGrade.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeGradeBtn"));
		Utils.setCursor(removeGrade);
		add(removeGrade);
		removeGrade.addActionListener(new ActionListener() {
			int resp = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passed.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(sps, LanguageSupport.getInstance().getResourceBundle().getString("editStudentMessage1"));
				else {
					resp = JOptionPane.showConfirmDialog(sps, LanguageSupport.getInstance().getResourceBundle().getString("editStudentQuestion1"),
							LanguageSupport.getInstance().getResourceBundle().getString("editStudentTitle1"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
						student.getPassedExams().remove(student.getPassedExams().get(passed.getSelectedRow()));
						//student.getFailedExams().add();
						ObserverNotifier.getInstance().subjectsPassedDataChanged();
						ObserverNotifier.getInstance().subjectsNotPassedDataChanged();

				}
				
			}
			}
		});
		passed = new SubjectsPassedTable();
		add(new JScrollPane(passed));
		
		notPassed = new SubjectsNotPassedTable();
		
		JPanel wrapper = new JPanel();
		BoxLayout box2 = new BoxLayout(wrapper, BoxLayout.Y_AXIS);
		wrapper.setLayout(box2);
		JPanel grade = new JPanel();
		grade.setBackground(Color.DARK_GRAY);
		BoxLayout box = new BoxLayout(grade, BoxLayout.X_AXIS);
		grade.setLayout(box);
		JPanel espb = new JPanel();
		espb.setBackground(Color.DARK_GRAY);
		BoxLayout box1 = new BoxLayout(espb, BoxLayout.X_AXIS);
		espb.setLayout(box1);
		averageGrade = new JLabel(LanguageSupport.getInstance().getResourceBundle().getString("averageGradeLbl"));
		averageGrade.setForeground(Color.WHITE);
		averageGradeLabel = new JLabel();
		averageGradeLabel.setForeground(Color.WHITE);
		espbSum = new JLabel(LanguageSupport.getInstance().getResourceBundle().getString("espbSumLbl"));
		espbSum.setForeground(Color.WHITE);
		espbSumLabel = new JLabel();
		espbSumLabel.setForeground(Color.WHITE);
		grade.add(averageGrade);
		grade.add(averageGradeLabel);
		espb.add(espbSum);
		espb.add(espbSumLabel);
		wrapper.add(grade);
		wrapper.add(espb);
		wrapper.setBackground(Color.DARK_GRAY);
		add(wrapper);
		
	}

	public JLabel getAverageGradeLabel(){return averageGradeLabel;}

	public JLabel getEspbSumLabel(){return espbSumLabel;}
	
	private void setTableColumnNames() {
		AbstractTableModelSubjectsPassed modelPass = (AbstractTableModelSubjectsPassed) passed.getModel();
		
		for(int i = 0; i < passed.getColumnCount();i++) {
			passed.getColumnModel().getColumn(i).setHeaderValue(modelPass.getColumnString(i));
		}
	}
	
	
	public void initComponents() {
		ResourceBundle resourceBundle = LanguageSupport.getInstance().getResourceBundle();
		removeGrade.setText(LanguageSupport.getInstance().getResourceBundle().getString("removeGradeBtn"));
		averageGrade.setText(LanguageSupport.getInstance().getResourceBundle().getString("averageGradeLbl"));
		espbSum.setText(LanguageSupport.getInstance().getResourceBundle().getString("espbSumLbl"));
		setTableColumnNames();
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}
}
