package model;

import enums.Semester;

import java.time.LocalDate;

public class Grade {
	private Student student;
	private Subject subject;
	private int grade;
	private LocalDate examDate;
	public Grade(Student student, Subject subject, int grade, LocalDate examDate) {
		super();
		this.student = student;
		this.subject = subject;
		try {
			gradeError(grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.examDate = examDate;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		try {
			gradeError(grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LocalDate getExamDate() {
		return examDate;
	}
	
	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}
	
	public void gradeError(int grade) throws Exception {
		if(!(grade < 5 || grade > 10)) {
			this.grade = grade;
			return;
		}
		throw new Exception("Ocena je van ranga!");
	}

	public String getValueAt(int columnIndex) {
		switch (columnIndex){
			case 0: return subject.getSubjectKey();
			case 1: return subject.getSubjectName();
			case 2: return String.valueOf(subject.getESPB());
			case 3: return String.valueOf(grade);
			case 4: return examDate.toString();
			default: return " ";
		}
	}

	@Override
	public String toString() {
		return student.getIndex() + ", " + subject.getSubjectKey() + ", " + grade + ", " + examDate;
	}
	
	
}	
