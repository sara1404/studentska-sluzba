package model;

import java.util.ArrayList;

enum Semester {
	SUMMER("summer"), WINTER("winter");
	String value;
	Semester(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Semester getSemesterWithString(String semester) {
		if(semester.equals("summer")) return Semester.SUMMER;
		else return Semester.WINTER;
	}
};

public class Subject {
	private String subjectKey;
	private String subjectName;
	private Semester semester;
	private int year;
	private Professor professor;
	private int ESPB;
	private ArrayList<Student> studentsPassed;
	private ArrayList<Student> studentsFailed;
	public Subject(String subjectKey, String subjectName, Semester semester, int year, Professor professor, int eSPB) {
		super();
		this.subjectKey = subjectKey;
		this.subjectName = subjectName;
		this.semester = semester;
		this.year = year;
		this.professor = professor;
		ESPB = eSPB;
		studentsPassed = new ArrayList<>();
		studentsFailed = new ArrayList<>();
	}
	public String getSubjectKey() {
		return subjectKey;
	}
	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getESPB() {
		return ESPB;
	}
	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}
	public ArrayList<Student> getStudentsPassed() {
		return studentsPassed;
	}
	public void setStudentsPassed(ArrayList<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}
	public ArrayList<Student> getStudentsFailed() {
		return studentsFailed;
	}
	public void setStudentsFailed(ArrayList<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}
	@Override
	public String toString() {
		return subjectKey +", "+ subjectName + ", " + semester + ", "
				+ year + ", " + professor +", " + ESPB ;
	}
	
	
	
	
}
