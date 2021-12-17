package controller;

import java.time.DateTimeException;
import java.time.LocalDate;

import enums.Title;
import model.Address;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import view.MainFrame;
import view.dialogs.ChangeProfessorDialog;

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
			Professor newProfessor = generateProfessor(cpd);
			DatabaseReader databaseReader = DatabaseReader.getInstance();
			databaseReader.getProfessors().set(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable(), newProfessor);
			ObserverNotifier.getInstance().professorDataChanged();
			cpd.dispose();
		} catch(NullPointerException | DateTimeException e) {
			e.printStackTrace();
		}
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
