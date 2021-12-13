package controller;

import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import enums.Title;
import model.Address;
import model.DatabaseReader;
import model.Professor;
import view.dialogs.AddProfessorDialog;

public class AddProfessorController {

	private static AddProfessorController instance = null;
	
	private AddProfessorController() {};
	
	public static AddProfessorController getInstance() {
		if(instance == null) 
			instance = new AddProfessorController();
		return instance;
	}
	
	public void addProfessor(AddProfessorDialog pd) {
		try {
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Professor newProfessor = generateProfessor(pd);
			databaseReader.addNewProfessor(newProfessor);
			
		} catch(NullPointerException | DateTimeException e) {
			JOptionPane.showMessageDialog(pd, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private Professor generateProfessor(AddProfessorDialog apd) {
		String surname = apd.getTextFieldAt(0).getText().trim();
		String name = apd.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(apd.getTextFieldAt(2).getText().trim());
		Address homeAddress = stringToAddress(apd.getTextFieldAt(3).getText().trim());
		String phone = apd.getTextFieldAt(4).getText().trim();
		String email = apd.getTextFieldAt(5).getText().trim();
		Address officeAddress = stringToAddress(apd.getTextFieldAt(6).getText().trim());
		String id = apd.getTextFieldAt(7).getText().trim();
		String title = apd.getComboInput().getSelectedItem().toString();
		int serviceYears = Integer.parseInt(apd.getTextFieldAt(8).getText().trim());
		Professor professor = new Professor(surname, name, birthDate, homeAddress, phone, email, officeAddress, id, Title.getTitleWithString(title), serviceYears);
		return professor;
	}
	
	private Address stringToAddress(String text) {
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
		return address;
	} 
}
