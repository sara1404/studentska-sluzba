package model;

import java.util.ArrayList;

public class Department {
	private String departmentKey;
	private String departmentName;
	private Professor departmentHead;
	ArrayList<Professor> departmentProfessors;
	public Department(String departmentKey, String departmentName, Professor departmentHead,
			ArrayList<Professor> departmentProfessors) {
		super();
		this.departmentKey = departmentKey;
		this.departmentName = departmentName;
		this.departmentHead = departmentHead;
		this.departmentProfessors = departmentProfessors;
	}
	public String getDepartmentKey() {
		return departmentKey;
	}
	public void setDepartmentKey(String departmentKey) {
		this.departmentKey = departmentKey;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Professor getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(Professor departmentHead) {
		this.departmentHead = departmentHead;
	}
	public ArrayList<Professor> getDepartmentProfessors() {
		return departmentProfessors;
	}
	public void setDepartmentProfessors(ArrayList<Professor> departmentProfessors) {
		this.departmentProfessors = departmentProfessors;
	}
	
	
	
	
}
