package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ShowPassedExamsForStudentController;
import enums.Semester;
import enums.Status;
import enums.Title;

public class DatabaseReader {
	
	private static DatabaseReader instance = null;
	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private ArrayList<Grade> grades;
	private ArrayList<ProfessorTeachSubject> professorTeachSubjects;
	private ArrayList<Department> departments;

	private DatabaseReader() {
		try 
		{
			this.students = readStudentDatabase();
			this.professors = readProfessorDatabase();
			this.subjects = readSubjectDatabase();
			this.grades = readGradesForStudent();
			linkGradesToStudent();
			this.professorTeachSubjects = readSubjectsForProfessor();
			linkSubjectsToProfessor();
			this.departments = readDepartmentDatabase();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void linkGradesToStudent(){
		for(Student student : students){
			for(int i = 0; i < grades.size(); i++){
				if(student.getIndex().equals(grades.get(i).getStudent().getIndex())) {
					student.getPassedExams().add(grades.get(i));
				}
			}
		}
	}

	private void linkSubjectsToProfessor(){
		for(Professor professor : professors){
			for(int i = 0; i < professorTeachSubjects.size(); i++){
				if(professor.getId().equals(professorTeachSubjects.get(i).getProfessor().getId())){
					professor.getSubjectList().add(professorTeachSubjects.get(i).getSubject());
				}
			}
		}
	}

	public ArrayList<Subject> filterSubjectsForStudent(Student student){
		ArrayList<Subject> filteredSubjects = new ArrayList<>();
		for(Subject subject : subjects){
			if(!listContainsSubject(convertGradeListToSubjectList(student.getPassedExams()), subject)
			&& !listContainsSubject(student.getFailedExams(), subject)
			&& student.getCurrentYear() == subject.getYear()){
				filteredSubjects.add(subject);
			}
		}
		return filteredSubjects;
	}

	private ArrayList<Subject> convertGradeListToSubjectList(ArrayList<Grade> gradeList){
		ArrayList<Subject> subjectList = new ArrayList<>();
 		for(Grade grade : gradeList){
			subjectList.add(grade.getSubject());
		}
		 return subjectList;
	}

	private boolean listContainsSubject(ArrayList<Subject> list, Subject subject){
		for(Subject sub : list){
			if(sub.getSubjectKey().equals(subject.getSubjectKey()))
				return true;
		}
		return false;
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
        }  
        scanner.close();
		return students;
	}
	
	public ArrayList<Professor> readProfessorDatabase() throws Exception{
		File text = new File("src/database_resource/professors.txt");
		ArrayList<Professor> professors = new ArrayList<>();
        Scanner scanner;
		scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String professorInfo = scanner.nextLine();
            String[] professorData = trimData(professorInfo.split(","));
            professors.add(new Professor(professorData[0], professorData[1], LocalDate.parse(professorData[2]), 
            		stringToAddress(professorData[3]), professorData[4], professorData[5], 
            		stringToAddress(professorData[6]), professorData[7], Title.getTitleWithString(professorData[8]), 
            		Integer.parseInt(professorData[9] )));
        }  
        scanner.close();
		return professors;
	}
	
	    
	public ArrayList<Subject> readSubjectDatabase() throws Exception{
		File text = new File("src/database_resource/subjects.txt");
		ArrayList<Subject> subjects = new ArrayList<>();
        Scanner scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            String subjectInfo = scanner.nextLine();
            String[] subjectData = trimData(subjectInfo.split(","));
            
            subjects.add(new Subject(subjectData[0], subjectData[1], Semester.getSemesterWithString(subjectData[2]), Integer.parseInt(subjectData[3]), findProfessor(subjectData[4]), Integer.parseInt(subjectData[5])));
        }  
        scanner.close();
		return subjects;
	}

	public ArrayList<Department> readDepartmentDatabase() throws Exception{
		File text = new File("src/database_resource/departments.txt");
		ArrayList<Department> departments = new ArrayList<>();
		Scanner scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String departmentInfo = scanner.nextLine();
			String[] departmentData = trimData(departmentInfo.split(","));

			departments.add(new Department(departmentData[0], departmentData[1], findProfessor(departmentData[2])));
		}
		scanner.close();
		return departments;
	}

	private ArrayList<Grade> readGradesForStudent() throws Exception {
		File text = new File("src/database_resource/subjects_student_passed.txt");
		ArrayList<Grade> grades = new ArrayList<>();
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String gradeInfo = scanner.nextLine();
			String[] gradeData = trimData(gradeInfo.split(","));
			Grade grade = new Grade(findStudent(gradeData[0]), findSubject(gradeData[1]), Integer.parseInt(gradeData[2]), LocalDate.parse(gradeData[3]));
			grades.add(grade);
		}
		scanner.close();
		return grades;
	}

	private ArrayList<ProfessorTeachSubject> readSubjectsForProfessor() throws Exception {
		File text = new File("src/database_resource/professor_teach_subjects.txt");
		ArrayList<ProfessorTeachSubject> professorTeachSubjectsList = new ArrayList<>();
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String professorTeachSubjectsInfo = scanner.nextLine();
			String[] professorTeachSubjectData = trimData(professorTeachSubjectsInfo.split(","));
			ProfessorTeachSubject professorTeachSubjects = new ProfessorTeachSubject(findProfessor(professorTeachSubjectData[0]), findSubject(professorTeachSubjectData[1]));
			professorTeachSubjectsList.add(professorTeachSubjects);
		}
		scanner.close();
		return professorTeachSubjectsList;
	}

	public ArrayList<Subject> filterSubjectsForProfessor(Professor professor){
		ArrayList<Subject> filteredSubjects = new ArrayList<>();
		for(int i = 0; i < professorTeachSubjects.size(); i++){
			if(professorTeachSubjects.get(i).getProfessor().getId().equals(professor.getId())){
				filteredSubjects.add(professorTeachSubjects.get(i).getSubject());
			}
		}
		return filteredSubjects;
	}

	public ArrayList<Professor> filterProfessorsForDepartmentDirector(){
		ArrayList<Professor> filteredProfessors = new ArrayList<>();
		for(Professor professor : professors){
			if(professor.getServiceYears() >= 5 && (professor.getTitle() == Title.REDOVNI || professor.getTitle() == Title.VANREDNI)){
				filteredProfessors.add(professor);
			}
		}
		return filteredProfessors;
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
	
	public Student findStudent(String index) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getIndex().equals(index)) {
				return students.get(i);
			}
		}
		return null;
	}

	
	public Subject findSubject(String id) {
		for(int i = 0; i < subjects.size(); i++) {
			if (subjects.get(i).getSubjectKey().equals(id)) {
				return subjects.get(i);
			}
		}
		return null;
	}

	public Professor findProfessor(String id) {
		for(int i = 0; i < professors.size(); i++) {
			if(professors.get(i).getId().equals(id)) 
				return professors.get(i);
		}
		return null;
	}
	
	public void addNewStudent(Student newStudent) {
		students.add(newStudent);
		ObserverNotifier.getInstance().studentsDataChanged();
	}
	
	public void addNewProfessor(Professor newProfessor) {
		professors.add(newProfessor);
		ObserverNotifier.getInstance().professorDataChanged();
	}
	
	public void addNewSubject(Subject newSubject) {
		subjects.add(newSubject);
		ObserverNotifier.getInstance().subjectDataChanged();
	}
	
	public void deleteStudent(String index) {
		students.remove(findStudent(index));
		ObserverNotifier.getInstance().studentsDataChanged();
	}
	
	public void deleteProfessor(String index) {
		professors.remove(findProfessor(index));
		ObserverNotifier.getInstance().professorDataChanged();
	}
	
	public void deleteSubject(String index) {
		subjects.remove(findSubject(index));
		ObserverNotifier.getInstance().subjectDataChanged();
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

	public ArrayList<Department> getDepartments(){
		return departments;
	}

}
