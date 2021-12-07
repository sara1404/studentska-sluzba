package controller;

import java.time.DateTimeException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import enums.Semester;
import model.DatabaseReader;
import model.Professor;
import model.Student;
import model.Subject;
import view.dialogs.AddStudentDialog;
import view.dialogs.AddSubjectDialog;

public class AddSubjectController {
	public static void addStudent(AddSubjectDialog subjectDialog) {
		try {
			//validateFields(subjectDialog.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			ArrayList<Subject> subjects = databaseReader.getSubjects();
			String name = subjectDialog.getTextFieldAt(0).getText();
			String currentYear = subjectDialog.getComboAt(0).getSelectedItem().toString();
			subjects.add(generateSubjectFromDialogInputs(subjectDialog));
		} catch(NullPointerException | DateTimeException e) {
			JOptionPane.showMessageDialog(subjectDialog, e.getMessage(), "Greska u poljima!", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private static boolean validateFields() {
//		
//	}
	
	private static Subject generateSubjectFromDialogInputs(AddSubjectDialog subjectDialog) {
		String id = subjectDialog.getTextFieldAt(0).getText();
		String name = subjectDialog.getTextFieldAt(1).getText();
		String semester = subjectDialog.getComboAt(2).getSelectedItem().toString();
		int year = Integer.parseInt(subjectDialog.getComboAt(3).getSelectedItem().toString());
		Professor professor = null; //nema profesora kad se tek kreira predmet, tek pri izmeni moze se dodati prof
		int espb = Integer.parseInt(subjectDialog.getTextFieldAt(5).getText());
		
		Subject subject = new Subject(id, name, Semester.getSemesterWithString(semester), year, professor, espb);
		return subject;
	}
	
	
}
