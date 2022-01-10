package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseWriter {
	
	public DatabaseWriter() {}
	
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
			buffer.write("Kraj");
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
