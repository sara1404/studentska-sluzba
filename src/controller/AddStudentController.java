package controller;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enums.Status;
import model.Address;
import model.DatabaseReader;
import model.Student;
import view.dialogs.AddStudentDialog;

public class AddStudentController {
	
	private static AddStudentController instance = null;
	
	private AddStudentController() {};
	
	public  void addStudent(AddStudentDialog studentDialog) {
		try {
			validateFields(studentDialog.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			Student newStudent = generateStudentFromDialogInputs(studentDialog);
			databaseReader.addNewStudent(newStudent);
			System.out.println(studentDialog);
			studentDialog.dispose();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(studentDialog, e.getMessage(), "Greska u poljima!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	public void validateFields(ArrayList<JTextField> fields) throws Exception {

		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
			if(i == 2)
				if(!validDateFormat(field.getText().trim())) throw new DateTimeException("Datum mora biti ispravno formatiran");
			if(i == 3 && !validAddressFormat(field.getText())) throw new NullPointerException("Adresa nije pravilno uneta!");
			if(i == 9 && !validateYear(field.getText())) throw new Exception("Godina mora biti broj!");
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

	private boolean validateYear(String data){
		try{
			Integer.parseInt(data);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	private boolean validAddressFormat(String address) {
		try {
			String[] data = address.split(" ");
			if(address == " ") {
				return false;
			}
			Integer.parseInt(data[data.length - 1]);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	private Student generateStudentFromDialogInputs(AddStudentDialog addStudentDialog) {
		String name = addStudentDialog.getTextFieldAt(0).getText().trim();
		String surname = addStudentDialog.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(addStudentDialog.getTextFieldAt(2).getText().trim());
		String street = addStudentDialog.getTextFieldAt(3).getText().trim();
		String town = addStudentDialog.getTextFieldAt(4).getText().trim();
		String country = addStudentDialog.getTextFieldAt(5).getText().trim();
		String phoneNumber = addStudentDialog.getTextFieldAt(6).getText().trim();
		String email = addStudentDialog.getTextFieldAt(7).getText().trim();
		String index = addStudentDialog.getTextFieldAt(8).getText().trim();
		int startYear = Integer.parseInt(addStudentDialog.getTextFieldAt(9).getText().trim());
		int currentYear = Integer.parseInt(addStudentDialog.getComboAt(0).getSelectedItem().toString());
		String status = addStudentDialog.getComboAt(1).getSelectedItem().toString();
		Address homeAddress = stringToAddress(street, town, country);
		Student student = new Student(surname, name, birthDate, homeAddress, phoneNumber, email,
				index, startYear, currentYear, Status.getStatusWithString(status), 0.0);
		return student;
	}
	
	private Address stringToAddress(String street, String town, String country) {
		String[] streetData = street.split(" ");
		String streetName = "";
		for(int i = 0; i < streetData.length - 1; i++){
			streetName += streetData[i];
		}

		Address address = new Address(streetName, Integer.parseInt(streetData[streetData.length - 1]), town, country);
		return address;
	} 
	
	public static AddStudentController getInstance() {
		if(instance == null) 
			instance = new AddStudentController();
		return instance;
	}
}
