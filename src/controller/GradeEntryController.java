package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.DatabaseReader;
import model.Grade;
import model.Student;
import model.Subject;
import view.MainFrame;
import view.dialogs.GradeEntry;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class GradeEntryController {
	private static GradeEntryController instance = null;
	SubjectsNotPassedTable notPassed;
	private GradeEntryController() {}
	
	public static GradeEntryController getInstance() {
		if(instance == null) 
			instance = new GradeEntryController();
		return instance;
	}
	
	public void gradeEntry(GradeEntry ge) {
		//try {
			notPassed = new SubjectsNotPassedTable();
			//validateFields(ge.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Grade newGrade = generateGrade(ge);
			databaseReader.addNewGrade(newGrade);
			Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
			student.getFailedExams().remove(student.getFailedExams().get(notPassed.getSelectedRow()));
			
			
		/*} catch(Exception e) {
			JOptionPane.showMessageDialog(ge, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}*/
	}
	
	public Grade generateGrade(GradeEntry ge) {
		int mark = Integer.parseInt(ge.getComboInput().getSelectedItem().toString());
		LocalDate date = LocalDate.parse(ge.getDataInputs().get(2).getText());
		Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
		//Subject subject = DatabaseReader.getInstance().findSubject()
		
		Grade grade = new Grade(student, null, mark, date);
		return grade;
	}
	
}
