package model;

import java.util.ArrayList;

public class Department {
	private String key;
	private String name;
	private Professor head;
	ArrayList<Professor> professors;
	public Department(String key, String name, Professor head, ArrayList<Professor> professors) {
		super();
		this.key = key;
		this.name = name;
		this.head = head;
		this.professors = professors;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Professor getHead() {
		return head;
	}
	public void setHead(Professor head) {
		this.head = head;
	}
	public ArrayList<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}
	
	
	
	
}
