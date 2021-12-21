package controller;

import javax.swing.JOptionPane;

import model.DatabaseReader;;

public class DeleteProfessorController {

private static DeleteProfessorController instance = null;
	
	private DeleteProfessorController() {};
	
	public static DeleteProfessorController getInstance() {
		if(instance == null) 
			instance = new DeleteProfessorController();
		return instance;
	}
	
	public void deleteProfessor(String index) {
		try {
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			databaseReader.deleteProfessor(index);
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska!", JOptionPane.WARNING_MESSAGE);
		}
	}
}
