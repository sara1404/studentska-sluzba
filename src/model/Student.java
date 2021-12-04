package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

enum Status{
	B("BUDZET"), S("SAMOFINANSIRANJE");	
	String value;
	Status(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Status getStatusWithString(String status) {
		if(status.equals("BUDZET")) return Status.B;
		else return Status.S;
	}
};

public class Student {
	private String surname;
	private String name;
	private LocalDate dateOfBirth;
	private Address homeAdress;
	private String phone;
	private String email;
	private String index;
	private int startYear;
	private int currentYear;
	private Status status;
	private double averageGrade;
	private ArrayList<Grade> passedExams;
	private ArrayList<Grade> failedExams;

	public Student(String surname, String name, LocalDate dateOfBirth, Address homeAdress, String phone, String email,
			String index, int startYear, int currentYear, Status status, double averageGrade) {
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
		passedExams = new ArrayList<>();
		failedExams = new ArrayList<>();
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(Address homeAdress) {
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
	@Override
	public String toString() {
		return  surname +", "+ name +", "+ dateOfBirth + ", "+
				homeAdress +", "+ phone +", "+ email +", "+ index +", "+ startYear
				+", "+ currentYear +", "+ status +", "+ averageGrade;
	}
	
}