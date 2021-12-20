package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.DatabaseReader;
import model.Student;

public class DeleteStudentController {
	private static DeleteStudentController instance = null;
	
	private DeleteStudentController() {};
	
	public void deleteStudent(String index) {
		try {
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			System.out.println(databaseReader.getStudents().size());
			databaseReader.deleteStudent(index);
			System.out.println(databaseReader.getStudents().size());
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
