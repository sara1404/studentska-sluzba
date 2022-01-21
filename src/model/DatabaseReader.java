package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import enums.Semester;
import enums.Status;
import enums.Title;

public class DatabaseReader {
	
	private static DatabaseReader instance = null;
	DatabaseWriter wr = new DatabaseWriter();
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
			this.professorTeachSubjects = readProfessorTeachSubjects();
			linkSubjectsToProfessor();
			this.departments = readDepartmentDatabase();
			linkSubjectsFailedToStudent();
			fillDepartmentListsWithProfessors();
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
				if(professorTeachSubjects.get(i).getProfessor() == null) continue;
				if(professor.getId().equals(professorTeachSubjects.get(i).getProfessor().getId())){
					professor.getSubjectList().add(professorTeachSubjects.get(i).getSubject());
				}
			}
		}
	}

	
	public void setDepartmentToProfessor(String professorId, String departmentId) {
		for(Professor professor: professors) {
			if(professor.getId().equals(professorId)) {
				professor.setDepartment(departmentId);
			}
		}
	}
	
	private void linkSubjectsFailedToStudent() throws Exception {
		File text = new File("src/database_resource/subjects_student_not_passed.txt");
		Scanner scanner;
		scanner = new Scanner(text);
		while(scanner.hasNextLine()){
			String subj = scanner.nextLine();
			String[] subjData = trimData(subj.split(","));
			Student student = findStudent(subjData[0]);
			Subject s = findSubject(subjData[1]);
			student.getFailedExams().add(s);
		}
		scanner.close();
		
	}
	
	public ArrayList<Subject> filterSubjectsListForProfessor(Professor professor){
		ArrayList<Subject> filteredSubjects = new ArrayList<>();
		for(Subject subject : subjects) {
			if(!inSubjectList(professor.getSubjectList(), subject)) {
				filteredSubjects.add(subject);
			}
		}
		return filteredSubjects;
	}

	public void removeSubjectFromProfessor(String professorId, String subjectId) {
		Professor professor = findProfessor(professorId);
		for(Iterator<Subject> iterator = professor.getSubjectList().iterator(); iterator.hasNext();) {
			Subject subject = iterator.next();
			if(subject.getSubjectKey().equals(subjectId))
				iterator.remove();
		}
	}
	
	private boolean inSubjectList(ArrayList<Subject> list, Subject subject) {
		for(Subject sub : list){
			if(sub.getSubjectKey().equals(subject.getSubjectKey()))
				return true;
		}
		return false;
		
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
            		Integer.parseInt(professorData[9]), professorData[10]));
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
            subjects.add(new Subject(subjectData[0], subjectData[1], Semester.getSemesterWithString(subjectData[5]), Integer.parseInt(subjectData[2]), findProfessor(subjectData[4]), Integer.parseInt(subjectData[3])));
        }  
        scanner.close();
		return subjects;
	}
	
	public ArrayList<ProfessorTeachSubject> readProfessorTeachSubjects() throws Exception {
		ArrayList<ProfessorTeachSubject> profTeachSubj = new ArrayList<>();
		subjects = readSubjectDatabase();
		for(int i=0; i< subjects.size(); i++) {
			Subject subject = subjects.get(i);
			Professor professor = subjects.get(i).getProfessor();
			profTeachSubj.add(new ProfessorTeachSubject(professor, subject));
		}
		return profTeachSubj;
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
		ArrayList<Professor> removeProfessors = new ArrayList<>();
		for(Professor professor : filteredProfessors){
			for(int i = 0; i < departments.size(); i++){
				if(departments.get(i).getHead() != null){
					if(departments.get(i).getHead().getId().equals(professor.getId()))
						removeProfessors.add(professor);
				}
			}
		}
		filteredProfessors.removeAll(removeProfessors);
		return filteredProfessors;
	}

	private void fillDepartmentListsWithProfessors() {
		ArrayList<Department> departments = getDepartments();
		ArrayList<Professor> professors = getProfessors();
		for(Department department: departments) {
			ArrayList<Professor> departmentProfessors = new ArrayList<>();
			for(Professor professor: professors) {
				if(department.getKey().trim().equals(professor.getDepartment().trim())) {
					departmentProfessors.add(professor);
				}
			}
			department.setProfessors(departmentProfessors);

		}
	}

	public ArrayList<Professor> getProfessorsWithNoDepartment(){
		ArrayList<Professor> professors = getProfessors();
		ArrayList<Professor> tempList = new ArrayList<>();
		for(Professor professor : professors){
			if(professor.getDepartment().equals("NO_DATA")){
				tempList.add(professor);
			}
		}
		return tempList;
	}

	private Address stringToAddress(String text) {
		if(text.equals("null")) return null;
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], addressData[1], addressData[2], addressData[3]);
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

	public Department findDepartment(String id){
		for(int i = 0; i < departments.size(); i++){
			if(departments.get(i).getKey().equals(id)){
				return departments.get(i);
			}
		}
		return null;
	}
	
	public Grade findGrade(String key) {
		for(int i=0; i< grades.size(); i++){
			if(grades.get(i).getSubject().getSubjectKey().equals(key))
				return grades.get(i);
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
	
	public void addNewGrade(Grade newGrade, Subject subject) {
		grades.add(newGrade);
		ObserverNotifier.getInstance().subjectsPassedDataChanged();
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
		
		for(int i =0; i< subjects.size(); i++) {
			if(subjects.get(i).getProfessor() != null) {
				if(subjects.get(i).getProfessor().getId() == findProfessor(index).getId())
					subjects.get(i).setProfessor(null);
			}
			
		}
		professors.remove(findProfessor(index));
		ObserverNotifier.getInstance().professorDataChanged();
	}
	
	public void deleteSubject(String index) {
		
		for(int i =0; i< students.size(); i++) {
			students.get(i).getFailedExams().remove(findSubject(index));
			}
		for(int i =0; i< professors.size(); i++) {
			professors.get(i).getSubjectList().remove(findSubject(index));
		}
		for( int i = 0; i < students.size(); i++) {
			students.get(i).getPassedExams().remove(findGrade(index));
		}

		ObserverNotifier.getInstance().subjectDataChanged();
	}

	public void initiateWritingToFiles() {
		wr.writeInSubjectDatabase(subjects);
		wr.writeInProfessorDatabase(professors);
		wr.writeInStudentDatabase(students);
		wr.writeInDepartmentsDatabase(departments);
		wr.writeInGradesDatabase(grades);
		wr.writeInFailedSubjects(students);

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

	public ArrayList<ProfessorTeachSubject> getProfessorTeachSubjects() {
		return professorTeachSubjects;
	}

	

}
