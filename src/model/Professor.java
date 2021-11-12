package model;

import java.util.ArrayList;
import java.util.Date;

public class Professor {
	private String surname;
	private String name;
	private Date dateOfBirth;
	private String homeAdress;
	private String phone;
	private String email;
	private String officeAdress;
	private String id;
	private String title;
	private int yearsOfService;
	private ArrayList<Subject> subjectList;
	public Professor(String surname, String name, Date dateOfBirth, String homeAdress, String phone, String email,
			String officeAdress, String id, String title, int yearsOfService, ArrayList<Subject> subjectList) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.homeAdress = homeAdress;
		this.phone = phone;
		this.email = email;
		this.officeAdress = officeAdress;
		this.id = id;
		this.title = title;
		this.yearsOfService = yearsOfService;
		this.subjectList = subjectList;
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
	public String getOfficeAdress() {
		return officeAdress;
	}
	public void setOfficeAdress(String officeAdress) {
		this.officeAdress = officeAdress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearsOfService() {
		return yearsOfService;
	}
	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
}
