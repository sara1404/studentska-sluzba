package model;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import enums.Semester;
import enums.Status;

public class DatabaseReader {
	
	private static DatabaseReader instance = null;
	
	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private DatabaseReader() {
		try 
		{
			this.students = readStudentDatabase();
			this.professors = null;
			this.subjects = readSubjectDatabase();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Student> readStudentDatabase() throws Exception{
		File text = new File("src/database_resource/students.txt");
		ArrayList<Student> students = new ArrayList<>();
        Scanner scanner;
		scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String studentInfo = scanner.nextLine();
            String[] studentData = trimData(studentInfo.split(","));
            
            students.add(new Student(studentData[0], studentData[1], LocalDate.parse(studentData[2]), stringToAddress(studentData[3]), studentData[4], studentData[5], 
            		studentData[6], Integer.parseInt(studentData[7]), Integer.parseInt(studentData[8]), Status.getStatusWithString(studentData[9]), Double.parseDouble(studentData[10])));
            System.out.println(students.get(students.size() - 1));
        }  
        scanner.close();
		return students;
	}
	    
	public ArrayList<Subject> readSubjectDatabase() throws Exception{
		File text = new File("src/database_resource/subjects.txt");
		ArrayList<Subject> subjects = new ArrayList<>();
        Scanner scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String subjectInfo = scanner.nextLine();
            String[] subjectData = trimData(subjectInfo.split(","));
            
            subjects.add(new Subject(subjectData[0], subjectData[1], Semester.getSemesterWithString(subjectData[2]), Integer.parseInt(subjectData[3]), findProfessor(subjectData[4]), Integer.parseInt(subjectData[5])));
            System.out.println(subjects.get(subjects.size() - 1));
        }  
        scanner.close();
		return subjects;
	}
	
	private Address stringToAddress(String text) {
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
		return address;
	} 
	
	private String[] trimData(String[] text) {
		for(int i = 0; i < text.length; i++) {
			text[i] = text[i].trim();
		}
		return text;
	}
	
	private Professor findProfessor(String id) {
		for(int i = 0; i < professors.size(); i++) {
			if(professors.get(i).getId().equals(id)) return professors.get(i);
		}
		return null;
	}
	
	public static DatabaseReader getInstance() {
		if(instance == null){
			instance = new DatabaseReader();
		}
		return instance;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Professor> getProfessors() {
		return professors;
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
}
