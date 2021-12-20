package controller;

import java.awt.Color;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	
	public void addProfessor(AddProfessorDialog apd) {
		try {
			validateFields(apd.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Professor newProfessor = generateProfessor(apd);
			databaseReader.addNewProfessor(newProfessor);
			
		} catch(NullPointerException | DateTimeException e) {
			JOptionPane.showMessageDialog(apd, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
private void validateFields(ArrayList<JTextField> fields) throws NullPointerException, DateTimeException {
	
	for(int j = 0; j < fields.size(); j++) {
		fields.get(j).setForeground(Color.BLACK);
	}
		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) {
				fields.get(i).setForeground(Color.RED);
				throw new NullPointerException("Polja moraju biti popunjena!");
			}
			if(i == 2) 
				if(!validDateFormat(field.getText().trim())) {
					fields.get(i).setForeground(Color.RED);
					throw new DateTimeException("Datum mora biti ispravno formatiran!");
				}
			
			if((i == 3 || i == 6) && !validAddressFormat(field.getText())) {
				fields.get(i).setForeground(Color.RED);
				throw new NullPointerException("Adresa nije pravilno uneta!"); 
			}
			
		}
		
		
	}
	
	private boolean validDateFormat(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private boolean validAddressFormat(String address) {
		try {
			String[] data = address.split("#");
			if(data[0] == " " || data[1] == " " || data[2] == " " || data[3] == " ") {
				return false;
			}
			Integer.parseInt(data[1]);
		}catch(Exception e) {
			return false;
		}
		return true;
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
