package controller;



import enums.Semester;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import model.Subject;
import view.MainFrame;
import view.dialogs.ChangeSubjectDialog;

import javax.swing.*;
import java.time.DateTimeException;
import java.util.ArrayList;

public class ChangeSubjectController {
	private static ChangeSubjectController instance = null;
	
	private ChangeSubjectController() {}
	
	public void changeSubject(ChangeSubjectDialog changeSubjectDialog) {
		try {
			swapSubjects(changeSubjectDialog);
			changeSubjectDialog.dispose();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void swapSubjects(ChangeSubjectDialog changeSubjectDialog) {
		Subject newSubject = generateSubjectFromDialogInputs(changeSubjectDialog);
		DatabaseReader.getInstance().getSubjects().set(MainFrame.getInstance().getTab().getSelectedRowInSubjectTable(), newSubject);
		ObserverNotifier.getInstance().subjectDataChanged();
	}

	public void validateFields(ArrayList<JTextField> fields) throws NullPointerException, DateTimeException {

		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
		}
	}
	
	private Subject generateSubjectFromDialogInputs(ChangeSubjectDialog changeSubjectDialog) {
		String id = changeSubjectDialog.getTextFieldAt(0).getText();
		String name = changeSubjectDialog.getTextFieldAt(1).getText();
		String semestar = changeSubjectDialog.getComboAt(0).getSelectedItem().toString();
		int year =  Integer.parseInt(changeSubjectDialog.getComboAt(1).getSelectedItem().toString());
		Professor professor = DatabaseReader.getInstance().getProfessors().get(changeSubjectDialog.getProfessorList().getSelectedIndex());
		int espb = Integer.parseInt(changeSubjectDialog.getTextFieldAt(3).getText());
		
		Subject subject = new Subject(id, name, Semester.getSemesterWithString(semestar), year, professor, espb);
		professor.getSubjectList().add(subject);
		return subject;
	}
	
	public static ChangeSubjectController getInstance() {
		if(instance == null) 
			instance = new ChangeSubjectController();
		return instance;
	}
}
