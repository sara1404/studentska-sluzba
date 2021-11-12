package model;

import java.util.ArrayList;
import java.util.Date;

enum Status{B, S};

public class Student {
	private String surname;
	private String name;
	private Date dateOfBirth;
	private String homeAdress;
	private String phone;
	private String email;
	private String index;
	private int startYear;
	private int currentYear;
	private Status status;
	private double averageGrade;
	private ArrayList<Grade> passedExams;
	private ArrayList<Grade> failedExams;
	public Student(String surname, String name, Date dateOfBirth, String homeAdress, String phone, String email,
			String index, int startYear, int currentYear, Status status, double averageGrade,
			ArrayList<Grade> passedExams, ArrayList<Grade> failedExams) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.homeAdress = homeAdress;
		this.phone = phone;
		this.email = email;
		this.index = index;
		this.startYear = startYear;
		this.currentYear = currentYear;
		this.status = status;
		this.averageGrade = averageGrade;
		this.passedExams = passedExams;
		this.failedExams = failedExams;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public ArrayList<Grade> getPassedExams() {
		return passedExams;
	}
	public void setPassedExams(ArrayList<Grade> passedExams) {
		this.passedExams = passedExams;
	}
	public ArrayList<Grade> getFailedExams() {
		return failedExams;
	}
	public void setFailedExams(ArrayList<Grade> failedExams) {
		this.failedExams = failedExams;
	}
	
	
}