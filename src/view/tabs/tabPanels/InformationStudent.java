package view.tabs.tabPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ListenerController;
import model.Student;
import utils.Utils;
import utils.WindowComponentBuilder;

public class InformationStudent extends JPanel{
	
	ArrayList<JTextField> dataInputs;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};
	ArrayList<JButton> buttonsInAddStudentForm;
	public InformationStudent() {
		
		dataInputs = new ArrayList<>();
		buttonsInAddStudentForm = new ArrayList<>();
		
		for(int i = 0; i < namesSerbian.length; i++) {

			if(i == 8) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 9) {
				String[] data = {"B", "S"};
				add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else {
				add(createPanel(namesSerbian[i], WindowComponentBuilder.createTextField()));
				add(Box.createVerticalStrut(10));
			}
		}
		
		buttonsInAddStudentForm.add(new JButton());
		buttonsInAddStudentForm.add(new JButton());
		add(WindowComponentBuilder.createButtons(buttonsInAddStudentForm.get(0), buttonsInAddStudentForm.get(1)));
		
		
	}
	
	private JPanel createPanel(String text, JComponent comp) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.add(WindowComponentBuilder.createLabel(text));		
		panel.add(Box.createHorizontalStrut(50));
		addToArrayIfTextField(comp);
		panel.add(comp);
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		
		return panel;
	}
	
	
	
	private void addToArrayIfTextField(JComponent comp) {
		if(comp instanceof JTextField) {
			dataInputs.add((JTextField)comp);
		}
	}
	
	public void fillFormWithStudentInfo(Student student) {
		dataInputs.get(0).setText(student.getName());
		dataInputs.get(1).setText(student.getSurname());
		dataInputs.get(2).setText(Utils.DateToString(student.getDateOfBirth()));
		dataInputs.get(3).setText(student.getHomeAdress().toString());
		dataInputs.get(4).setText(student.getPhone());
		dataInputs.get(5).setText(student.getEmail());
		dataInputs.get(6).setText(student.getIndex());
		dataInputs.get(7).setText(String.valueOf(student.getStartYear()));
		
	}

	public ArrayList<JButton> getButtonsInAddStudentForm() {
		return buttonsInAddStudentForm;
	}
	
}
