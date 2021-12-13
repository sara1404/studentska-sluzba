package controller;

public class AddProfessorController {

	private static AddProfessorController instance = null;
	
	private AddProfessorController() {};
	
	public static AddProfessorController getInstance() {
		if(instance == null) 
			instance = new AddProfessorController();
		return instance;
	}
}
