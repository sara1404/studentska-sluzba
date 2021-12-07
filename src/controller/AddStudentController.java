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
	
	
	public static void addStudent(AddStudentDialog studentDialog) {
		try {
			validateFields(studentDialog.getDataInputs());
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			ArrayList<Student> students = databaseReader.getStudents();
			String name = studentDialog.getTextFieldAt(0).getText();
			String currentYear = studentDialog.getComboAt(0).getSelectedItem().toString();
			students.add(generateStudentFromDialogInputs(studentDialog));
		} catch(NullPointerException | DateTimeException e) {
			JOptionPane.showMessageDialog(studentDialog, e.getMessage(), "Greska u poljima!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	private static void validateFields(ArrayList<JTextField> fields) throws NullPointerException, DateTimeException {
		
		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")) throw new NullPointerException("Polja moraju biti popunjena!");
			if(i == 2) 
				if(!validDateFormat(field.getText().trim())) throw new DateTimeException("Datum mora biti ispravno formatiran");  
			if(i == 3 && !validAddressFormat(field.getText())) throw new NullPointerException("Adresa nije pravilno uneta!"); 
		}
	}
	
	private static boolean validDateFormat(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean validAddressFormat(String address) {
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
	
	private static Student generateStudentFromDialogInputs(AddStudentDialog addStudentDialog) {
		String name = addStudentDialog.getTextFieldAt(0).getText().trim();
		String surname = addStudentDialog.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(addStudentDialog.getTextFieldAt(2).getText().trim());
		Address homeAddress = stringToAddress(addStudentDialog.getTextFieldAt(3).getText().trim());
		String phoneNumber = addStudentDialog.getTextFieldAt(4).getText().trim();
		String email = addStudentDialog.getTextFieldAt(5).getText().trim();
		String index = addStudentDialog.getTextFieldAt(6).getText().trim();
		int startYear = Integer.parseInt(addStudentDialog.getTextFieldAt(7).getText().trim());
		int currentYear = Integer.parseInt(addStudentDialog.getComboAt(0).getSelectedItem().toString());
		String status = addStudentDialog.getComboAt(1).getSelectedItem().toString();
		Student student = new Student(name, surname, birthDate, homeAddress, phoneNumber, email,
				index, startYear, currentYear, Status.getStatusWithString(status), 0.0);
		return student;
	}
	
	private static Address stringToAddress(String text) {
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
		return address;
	} 
}
