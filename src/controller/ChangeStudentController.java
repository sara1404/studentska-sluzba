package controller;

import java.time.DateTimeException;
import java.time.LocalDate;

import enums.Status;
import model.Address;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Student;
import view.MainFrame;
import view.dialogs.ChangeStudentDialog;

public class ChangeStudentController {
	private static ChangeStudentController instance = null;
	
	private ChangeStudentController() {};
	
	public void changeStudent(ChangeStudentDialog changeStudentDialog) {
		try {
			swapStudent(changeStudentDialog);
			changeStudentDialog.dispose();
			
		} catch(NullPointerException | DateTimeException e) {
			e.printStackTrace();
		}
			
	}
	
	public void swapStudent(ChangeStudentDialog changeStudentDialog) {
		Student newStudent = generateStudentFromDialogInputs(changeStudentDialog);
		DatabaseReader.getInstance().getStudents().set(MainFrame.getInstance().getTab().getSelectedRowInStudentTable(), newStudent);
		ObserverNotifier.getInstance().studentsDataChanged();
	}
	
	
	
	private Student generateStudentFromDialogInputs(ChangeStudentDialog changeStudentDialog) {
		String name = changeStudentDialog.getTextFieldAt(0).getText().trim();
		String surname = changeStudentDialog.getTextFieldAt(1).getText().trim();
		LocalDate birthDate = LocalDate.parse(changeStudentDialog.getTextFieldAt(2).getText().trim());
		Address homeAddress = stringToAddress(changeStudentDialog.getTextFieldAt(3).getText().trim());
		String phoneNumber = changeStudentDialog.getTextFieldAt(4).getText().trim();
		String email = changeStudentDialog.getTextFieldAt(5).getText().trim();
		String index = changeStudentDialog.getTextFieldAt(6).getText().trim();
		int startYear = Integer.parseInt(changeStudentDialog.getTextFieldAt(7).getText().trim());
		int currentYear = Integer.parseInt(changeStudentDialog.getComboAt(0).getSelectedItem().toString());
		String status = changeStudentDialog.getComboAt(1).getSelectedItem().toString();
		Student student = new Student(surname, name, birthDate, homeAddress, phoneNumber, email,
				index, startYear, currentYear, Status.getStatusWithString(status), 0.0);
		return student;
	}
	
	private Address stringToAddress(String text) {
		String[] addressData = text.split("#");
		Address address = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
		return address;
	} 

	public static ChangeStudentController getInstance() {
		if(instance == null)
			instance = new ChangeStudentController();
		return instance;
	}
}
