package main;

import java.util.ArrayList;

import model.DatabaseReader;
import model.DatabaseWriter;
import model.Student;
import view.MainFrame;

public class MyApp {

	public static void main(String[] args) {

		MainFrame mf = MainFrame.getInstance();
		ArrayList<Student> students;
		try {
			//students = dr.readStudentDatabase();
			//DatabaseWriter wr = new DatabaseWriter();
			//wr.writeInStudentDatabase(students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
