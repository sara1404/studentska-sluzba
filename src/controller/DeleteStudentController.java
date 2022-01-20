package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.DatabaseReader;
import model.Student;
import model.Subject;

public class DeleteStudentController {
	private static DeleteStudentController instance = null;
	
	private DeleteStudentController() {};
	
	public void deleteStudent(String index) {
		try {
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			databaseReader.deleteStudent(index);
			Student student = DatabaseReader.getInstance().findStudent(index);
			ArrayList<Subject> subjects = databaseReader.getSubjects();
			for(int i  = 0; i < subjects.size(); i++){
				for(int j = 0; j < subjects.get(i).getStudentsPassed().size(); j++){
					if(subjects.get(i).getStudentsPassed().get(j).getIndex().equals(student.getIndex())){
						subjects.get(i).getStudentsPassed().remove(student);
					}
				}
			}
			for(int i  = 0; i < subjects.size(); i++){
				for(int j = 0; j < subjects.get(i).getStudentsFailed().size(); j++){
					if(subjects.get(i).getStudentsFailed().get(j).getIndex().equals(student.getIndex())){
						subjects.get(i).getStudentsFailed().remove(student);
					}
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska!", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static DeleteStudentController getInstance() {
		if(instance == null) {
			instance = new DeleteStudentController();
		}
		return instance;
	}
}
