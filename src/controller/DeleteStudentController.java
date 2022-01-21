package controller;

import java.util.ArrayList;
import java.util.Iterator;

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
			ArrayList<Subject> subjects = databaseReader.getSubjects();


			for(Subject subject: subjects) {
				for(Iterator<Student> studentIterator = subject.getStudentsPassed().iterator(); studentIterator.hasNext();) {
					Student tempStudent  = studentIterator.next();
					if(index.equals(tempStudent.getIndex())) {
						studentIterator.remove();;
					}
				}
			}
			for(Subject subject: subjects) {
				for(Iterator<Student> studentIterator = subject.getStudentsFailed().iterator(); studentIterator.hasNext();) {
					Student tempStudent  = studentIterator.next();
					if(index.equals(tempStudent.getIndex())) {
						studentIterator.remove();;
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
