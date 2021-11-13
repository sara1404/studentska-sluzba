package model;

import java.util.Date;




public class Grade {
	private Student student;
	private Subject subject;
	private int grade;
	private Date examDate;
	public Grade(Student student, Subject subject, int grade, Date examDate) {
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
	
	public Date getExamDate() {
		return examDate;
	}
	
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	public void gradeError(int grade) throws Exception {
		if(!(grade < 5 || grade > 10)) {
			this.grade = grade;
			return;
		}
		throw new Exception("Ocena je van ranga!");
	}
}	
