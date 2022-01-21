package controller;

import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import enums.Status;
import model.Address;
import model.DatabaseReader;
import model.DatabaseWriter;
import model.ObserverNotifier;
import model.Student;
import view.MainFrame;
import view.dialogs.ChangeStudentDialog;

import javax.swing.*;

public class ChangeStudentController {
	private static ChangeStudentController instance = null;
	DatabaseWriter wr = new DatabaseWriter();
	private ChangeStudentController() {};
	
	public void changeStudent(ChangeStudentDialog changeStudentDialog) {
		try {
			validateFields(changeStudentDialog.getTextFields());
			swapStudent(changeStudentDialog);
			changeStudentDialog.dispose();
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(changeStudentDialog, e.getMessage(), "Greska u poljima!", JOptionPane.WARNING_MESSAGE);

		}
			
	}
	
	public void swapStudent(ChangeStudentDialog changeStudentDialog) {
		Student newStudent = generateStudentFromDialogInputs(changeStudentDialog);
		DatabaseReader.getInstance().getStudents().set(MainFrame.getInstance().getTab().getSelectedRowInStudentTable(), newStudent);
		wr.writeInStudentDatabase(DatabaseReader.getInstance().getStudents());
		ObserverNotifier.getInstance().studentsDataChanged();
	}
	
	
	
	private Student generateStudentFromDialogInputs(ChangeStudentDialog changeStudentDialog) {
		String name = changeStudentDialog.getTextFieldAt(0).getText().trim();
		String surname = changeStudentDialog.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(changeStudentDialog.getTextFieldAt(2).getText().trim());
		String street = changeStudentDialog.getTextFieldAt(3).getText().trim();
		String town = changeStudentDialog.getTextFieldAt(4).getText().trim();
		String country = changeStudentDialog.getTextFieldAt(5).getText().trim();
		String phoneNumber = changeStudentDialog.getTextFieldAt(6).getText().trim();
		String email = changeStudentDialog.getTextFieldAt(7).getText().trim();
		String index = changeStudentDialog.getTextFieldAt(8).getText().trim();
		int startYear = Integer.parseInt(changeStudentDialog.getTextFieldAt(9).getText().trim());
		int currentYear = Integer.parseInt(changeStudentDialog.getComboAt(0).getSelectedItem().toString());
		String status = changeStudentDialog.getComboAt(1).getSelectedItem().toString();
		Address homeAddress = stringToAddress(street, town, country);
		Student student = new Student(surname, name, birthDate, homeAddress, phoneNumber, email,
				index, startYear, currentYear, Status.getStatusWithString(status), 0.0);
		return student;
	}

	public void validateFields(ArrayList<JTextField> fields) throws Exception {

		for(int i = 0; i < fields.size(); i++) {
			JTextField field = fields.get(i);
			if(field.getText().trim().equals("")){
				field.setForeground(Color.RED);
				throw new NullPointerException("Polja moraju biti popunjena!");
			}
			if(i == 2)
				if(!validDateFormat(field.getText().trim())){
					field.setForeground(Color.RED);
					throw new DateTimeException("Datum mora biti ispravno formatiran");
				}
			if(i == 3 && !validAddressFormat(field.getText())){
				field.setForeground(Color.RED);
				throw new NullPointerException("Adresa nije pravilno uneta!");
			}
			if(i == 8) {
				Student student = DatabaseReader.getInstance().findStudent(field.getText());
				if(student != null && !field.getText().equals(DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable()).getIndex())) {
					field.setForeground(Color.RED);
					throw new Exception("Unet je vec postojeci broj indeksa!");
				}
			}
			if(i == 9 && !validateYear(field.getText())){
				field.setForeground(Color.RED);
				throw new Exception("Godina mora biti broj!");
			}
			field.setForeground(Color.black);
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
			String[] data = address.split(" ");
			if(address == " ") {
				return false;
			}
			//Integer.parseInt(data[data.length - 1]);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	private Address stringToAddress(String street, String town, String country) {
		String[] streetData = street.split(" ");
		String streetName = "";
		for(int i = 0; i < streetData.length - 1; i++){
			streetName += streetData[i];
		}

		Address address = new Address(streetName, streetData[streetData.length - 1], town, country);
		return address;
	}

	public static ChangeStudentController getInstance() {
		if(instance == null)
			instance = new ChangeStudentController();
		return instance;
	}
}
