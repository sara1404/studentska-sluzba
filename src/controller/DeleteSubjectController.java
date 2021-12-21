package controller;

import javax.swing.JOptionPane;

import model.DatabaseReader;

public class DeleteSubjectController {
	
private static DeleteSubjectController instance = null;
	
	private DeleteSubjectController() {};
	
	public static DeleteSubjectController getInstance() {
		if(instance == null) 
			instance = new DeleteSubjectController();
		return instance;
	}
	
	public void deleteSubject(String index) {
		try {
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			databaseReader.deleteSubject(index);
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska!", JOptionPane.WARNING_MESSAGE);
		}
	}
}
