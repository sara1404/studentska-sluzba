package controller;

import java.awt.Color;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enums.Title;
import model.Address;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import view.MainFrame;
import view.dialogs.ChangeProfessorDialog;
import view.tabs.tabPanels.InformationProfessor;

public class ChangeProfessorController {
	private static ChangeProfessorController instance = null;
	private ChangeProfessorController() {};
	
	public static ChangeProfessorController getInstance() {
		if(instance == null)
			instance = new ChangeProfessorController();
		return instance;
	}
	
	public void changeProfessor(ChangeProfessorDialog cpd) {
		try {
			validateFields(cpd.getDataInputs());
			Professor newProfessor = generateProfessor(cpd);
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			databaseReader.getProfessors().set(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable(), newProfessor);
			ObserverNotifier.getInstance().professorDataChanged();
			cpd.dispose();
		} catch(NullPointerException | DateTimeException e) {
			JOptionPane.showMessageDialog(cpd, e.getMessage(), "Neispravan unos podataka!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void validateFields(ArrayList<JTextField> fields) {
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
				
				if((i == 3 || i == 6) && !validAddressFormat(field.getText())) {
					fields.get(i).setForeground(Color.RED);
					throw new NullPointerException("Adresa nije pravilno uneta!"); 
				}
				
				if((i == 8) && !validType(field.getText())) {
					fields.get(i).setForeground(Color.RED);
					throw new NumberFormatException("Godina staza mora biti ceo broj!");
				}
				
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

	private Professor generateProfessor(ChangeProfessorDialog cpd) {
		String surname = cpd.getTextField(0).getText().trim();
		String name = cpd.getTextField(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(cpd.getTextField(2).getText().trim());
		Address homeAddress = stringToAddress(cpd.getTextField(3).getText().trim());
		String phone = cpd.getTextField(4).getText().trim();
		String email = cpd.getTextField(5).getText().trim();
		Address officeAddress = stringToAddress(cpd.getTextField(6).getText().trim());
		String id = cpd.getTextField(7).getText().trim();
		String title = cpd.getCombo().getSelectedItem().toString();
		int serviceYears = Integer.parseInt(cpd.getTextField(8).getText().trim());
		Professor professor = new Professor(surname, name, birthDate, homeAddress, phone, email, officeAddress, id, Title.getTitleWithString(title), serviceYears);
		return professor;
	}
	
	private Address stringToAddress(String text) {
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
		return address;
	} 
	
	
	
	
}
