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
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(apd, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
public void validateFields(ArrayList<JTextField> fields) throws Exception{
	
	for(int j = 0; j < fields.size(); j++) {
		fields.get(j).setForeground(Color.BLACK);
	}
		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) {
				throw new NullPointerException("Polja moraju biti popunjena!");
			}
			if(i == 2) 
				if(!validDateFormat(field.getText().trim())) {
					fields.get(i).setForeground(Color.RED);
					throw new DateTimeException("Datum mora biti ispravno formatiran!");
				}
			
			if(i == 11 && idExists(field.getText())) {
				fields.get(i).setForeground(Color.RED);
				throw new Exception("Vec postoji profesor sa unetim brojem licne karte!");
				
			}
			
			if((i == 12) && !validType(field.getText())) {
				fields.get(i).setForeground(Color.RED);
				throw new NumberFormatException("Godina staza mora biti ceo broj!");
			}
			
		}
		
		
	}
	

	private boolean idExists(String id) {
		Professor professor  = DatabaseReader.getInstance().findProfessor(id);
		if(professor == null) {
			return false;
		} else {
			return true;
		}
}

	private boolean validType(String text) {
		try {
			Integer.parseInt(text);
	        return true;
	    } catch (Exception e) {
	    	return false;
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

	
	private Professor generateProfessor(AddProfessorDialog apd) {
		String surname = apd.getTextFieldAt(0).getText().trim();
		String name = apd.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(apd.getTextFieldAt(2).getText().trim());
		String street = apd.getTextFieldAt(3).getText().trim();
		String town = apd.getTextFieldAt(4).getText().trim();
		String country = apd.getTextFieldAt(5).getText().trim();
		String phone = apd.getTextFieldAt(6).getText().trim();
		String email = apd.getTextFieldAt(7).getText().trim();
		String street1 = apd.getTextFieldAt(8).getText().trim();
		String town1 = apd.getTextFieldAt(9).getText().trim();
		String country1 = apd.getTextFieldAt(10).getText().trim();
		String id = apd.getTextFieldAt(11).getText().trim();
		String title = apd.getComboInput().getSelectedItem().toString();
		int serviceYears = Integer.parseInt(apd.getTextFieldAt(12).getText().trim());
		Address homeAddress = stringToAddress(street, town, country);
		Address officeAddress = stringToAddress(street1, town1, country1);
		Professor professor = new Professor(surname, name, birthDate, homeAddress, phone, email, officeAddress, id, Title.getTitleWithString(title), serviceYears,"NO_DATA");
		return professor;
	}
	
	private Address stringToAddress(String street, String town, String country) {
		String[] streetData = street.split(" ");
		Address address = new Address(streetData[0], streetData[1], town, country);
		return address;
	} 
	
	
}
