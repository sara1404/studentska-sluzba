package controller;

import java.time.LocalDate;
import java.util.Observer;

import javax.swing.JOptionPane;

import model.DatabaseReader;
import model.Grade;
import model.ObserverNotifier;
import model.Student;
import model.Subject;
import view.MainFrame;
import view.dialogs.GradeEntry;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class GradeEntryController {
	private static GradeEntryController instance = null;
	private GradeEntryController() {}
	
	public static GradeEntryController getInstance() {
		if(instance == null) 
			instance = new GradeEntryController();
		return instance;
	}
	
	public void gradeEntry(GradeEntry ge) {
		try {
			Grade newGrade = generateGrade(ge);
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Student student = databaseReader.getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
			Subject subject = student.getFailedExams().get(MainFrame.getInstance().getChangeStudentDialog().getSubjectNotPassedStudent().getNotPassed().getSelectedRow());
			
			student.getFailedExams().remove(subject);
			student.getPassedExams().add(newGrade);
			ObserverNotifier.getInstance().subjectsNotPassedDataChanged();
			databaseReader.addNewGrade(newGrade, subject);
			
			ShowPassedExamsForStudentController.getInstance().setAverageGrade(MainFrame.getInstance().getChangeStudentDialog().getSubjectPassedStudent());
			ShowPassedExamsForStudentController.getInstance().setEspbPoints(MainFrame.getInstance().getChangeStudentDialog().getSubjectPassedStudent());
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ge, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public Grade generateGrade(GradeEntry ge) {
		int mark = Integer.parseInt(ge.getComboInput().getSelectedItem().toString());
		LocalDate date = LocalDate.parse(ge.getDataInputs().get(2).getText());
		Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
		Subject subject = DatabaseReader.getInstance().findSubject(ge.getDataInputs().get(0).getText());
		
		Grade grade = new Grade(student, subject, mark, date);
		return grade;
	}
	
}
