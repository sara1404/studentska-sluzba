package controller;



import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

import enums.Semester;
import model.DatabaseReader;
import model.DatabaseWriter;
import model.ObserverNotifier;
import model.Professor;
import model.Subject;
import view.MainFrame;
import view.dialogs.ChangeSubjectDialog;

public class ChangeSubjectController {
	private static ChangeSubjectController instance = null;
	DatabaseWriter wr = new DatabaseWriter();
	
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
		wr.writeInSubjectDatabase(DatabaseReader.getInstance().getSubjects());
		ObserverNotifier.getInstance().subjectDataChanged();
	}

	public void validateFields(ArrayList<JTextField> fields) throws Exception {
		System.out.println("Validiramo");
		for(int i = 0; i < fields.size()-2; i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
			if(i == 0) {
				Subject subject = DatabaseReader.getInstance().findSubject(field.getText());
				if(subject != null && !field.getText().equals(DatabaseReader.getInstance().getSubjects().get(MainFrame.getInstance().getTab().getSelectedRowInSubjectTable()).getSubjectKey())) {
					field.setForeground(Color.RED);
					throw new Exception("Unet je predmet sa postojecom sifrom!");
				}
			}
		}
		JTextField field = fields.get(3);
		if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
	}
	
	private Subject generateSubjectFromDialogInputs(ChangeSubjectDialog changeSubjectDialog) {
		String id = changeSubjectDialog.getTextFieldAt(0).getText();
		String name = changeSubjectDialog.getTextFieldAt(1).getText();
		String semestar = changeSubjectDialog.getComboAt(0).getSelectedItem().toString();
		int year =  Integer.parseInt(changeSubjectDialog.getComboAt(1).getSelectedItem().toString());
		Professor professor;
		try {
			professor = DatabaseReader.getInstance().getProfessors().get(changeSubjectDialog.getProfessorList().getSelectedIndex());
			
		} catch (Exception e) {
			professor = null;
		}
		
		int espb = Integer.parseInt(changeSubjectDialog.getTextFieldAt(3).getText());
		
		Subject subject = new Subject(id, name, Semester.getSemesterWithString(semestar), year, professor, espb);
		if(professor != null)
			professor.getSubjectList().add(subject);
		return subject;
	}
	
	public static ChangeSubjectController getInstance() {
		if(instance == null) 
			instance = new ChangeSubjectController();
		return instance;
	}
}
