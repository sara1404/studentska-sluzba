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
	
	private static AddSubjectController instance = null;
	
	private AddSubjectController() {};
	
	public void addStudent(AddSubjectDialog subjectDialog) {
		try {
			//validateFields(subjectDialog.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Subject newSubject = generateSubjectFromDialogInputs(subjectDialog);
			databaseReader.addNewSubject(newSubject);
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
	
	private Subject generateSubjectFromDialogInputs(AddSubjectDialog subjectDialog) {
		String id = subjectDialog.getTextFieldAt(0).getText();
		String name = subjectDialog.getTextFieldAt(1).getText();
		String semester = subjectDialog.getComboAt(0).getSelectedItem().toString();
		int year = Integer.parseInt(subjectDialog.getComboAt(1).getSelectedItem().toString());
		Professor professor = null; //nema profesora kad se tek kreira predmet, tek pri izmeni moze se dodati prof
		int espb = Integer.parseInt(subjectDialog.getTextFieldAt(2).getText());
		
		Subject subject = new Subject(id, name, Semester.getSemesterWithString(semester), year, professor, espb);
		return subject;
	}
	
	public static AddSubjectController getInstance() {
		if(instance == null)
			instance = new AddSubjectController();
		return instance;
	}
}
