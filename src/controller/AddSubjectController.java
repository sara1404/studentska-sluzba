package controller;

import java.awt.*;
import java.time.DateTimeException;
import java.util.ArrayList;

import javax.swing.*;

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
	
	public void addSubject(AddSubjectDialog subjectDialog) {
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

	public void validateFields(ArrayList<JTextField> fields) throws Exception {

		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
			if(i == 0) {
				Subject subject = DatabaseReader.getInstance().findSubject(field.getText());
				if(subject != null) {
					field.setForeground(Color.RED);
					throw new Exception("Unet je predmet sa postojecom sifrom!");
				}
			}
		}
	}

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
