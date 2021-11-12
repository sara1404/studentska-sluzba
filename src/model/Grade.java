package model;

import java.util.Date;

enum VrednostOcene {
	SEST(6), SEDAM(7), OSAM(8), DEVET(9), DESET(10);
	int vrOcene;
		VrednostOcene(int i) { this.vrOcene = i; }  
	public int getValue() {
		return vrOcene;
	}
};


public class Grade {
	private Student student;
	private Subject subject;
	private VrednostOcene grade;
	private Date examDate;
	public Grade(Student student, Subject subject, VrednostOcene grade, Date examDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.grade = grade;
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
	public VrednostOcene getGrade() {
		return grade;
	}
	public void setGrade(VrednostOcene grade) {
		this.grade = grade;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	
	
	
	
}	
