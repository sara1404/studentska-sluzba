package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseWriter {
	
	//private static DatabaseWriter instance = null;
	//private DatabaseWriter() {}
	
	public void writeInStudentDatabase(ArrayList<Student> students) {
		 FileWriter writer;
		try {
			writer = new FileWriter("src/database_resource/students.txt");
			BufferedWriter buffer = new BufferedWriter(writer);  
			for(int i = 0; i < students.size(); i++) {
				buffer.write(students.get(i).toString());
				if(i != students.size() - 1) buffer.newLine();
			} 
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void writeInProfessorDatabase(ArrayList<Professor> professors) {
			 FileWriter writer;
			try {
				writer = new FileWriter("src/database_resource/professors.txt");
				BufferedWriter buffer = new BufferedWriter(writer);  
				for(int i = 0; i < professors.size(); i++) {
					buffer.write(professors.get(i).toString());
					if(i != professors.size() - 1) buffer.newLine();
				} 
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void writeInSubjectDatabase(ArrayList<Subject> subjects) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/database_resource/subjects.txt");
			BufferedWriter buffer = new BufferedWriter(writer);  
			for(int i = 0; i < subjects.size(); i++) {
				buffer.write(subjects.get(i).toString());
				if(i != subjects.size() - 1) buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void writeInGradesDatabase(ArrayList<Grade> grades) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/database_resource/subjects_student_passed.txt");
			BufferedWriter buffer = new BufferedWriter(writer); 
			for(int i =0; i< grades.size(); i++) {
				buffer.write(grades.get(i).toString());
				if(i != grades.size() - 1) buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void writeInDepartmentsDatabase(ArrayList<Department> departments) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/database_resource/departments.txt");
			BufferedWriter buffer = new BufferedWriter(writer); 
			for(int i =0; i< departments.size(); i++) {
				buffer.write(departments.get(i).toString());
				if(i != departments.size() - 1) buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	public void writeInFailedSubjects(ArrayList<Student> students) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/database_resource/subjects_student_not_passed.txt");
			BufferedWriter buffer = new BufferedWriter(writer); 
			for(int i =0; i< students.size(); i++) {
				for(int j=0; j < students.get(i).getFailedExams().size(); j++) {
					buffer.write(students.get(i).getIndex() + " , "+ students.get(i).getFailedExams().get(j).getSubjectKey());
					if(i != students.get(i).getFailedExams().size() - 1) buffer.newLine();
				}
				
			}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	
}
