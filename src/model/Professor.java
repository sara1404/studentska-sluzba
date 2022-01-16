package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import enums.Title;


public class Professor {
	private String surname;
	private String name;
	private LocalDate birthDate;
	private Address homeAdress;
	private String phone;
	private String email;
	private Address officeAdress;
	private String id;
	private Title title;
	private int serviceYears;
	private ArrayList<Subject> subjectList;
	public Professor(String surname, String name, LocalDate birthDate, Address homeAdress, String phone, String email,
			Address officeAdress, String id, Title title, int serviceYears) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
		this.phone = phone;
		this.email = email;
		this.officeAdress = officeAdress;
		this.id = id;
		this.title = title;
		this.serviceYears = serviceYears;
		subjectList = new ArrayList<>();
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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
	public Address getOfficeAdress() {
		return officeAdress;
	}
	public void setOfficeAdress(Address officeAdress) {
		this.officeAdress = officeAdress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public int getServiceYears() {
		return serviceYears;
	}
	public void setServiceYears(int serviceYears) {
		this.serviceYears = serviceYears;
	}
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	public String getValueAt(int columnIndex) {
		switch(columnIndex) {
		case 0: return name;
		case 1: return surname;
		case 2: return title.getValue();
		case 3: return email;
		case 4: return id;
		default: return "";
		}
	}
	@Override
	public String toString() {
		return surname + ", " + name + ", " + birthDate + ", "
				+ homeAdress + ", " + phone + ", " + email + ", " + officeAdress + ", " + id
				+ ", " + title + ", " + serviceYears;
	}
	
	
	
	
}
