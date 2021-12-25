package view.tabs.tabPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

import controller.ListenerController;
import model.Student;
import utils.Utils;
import utils.WindowComponentBuilder;

public class InformationStudent extends JPanel{
	
	ArrayList<JTextField> textFields;
	ArrayList<JComboBox> combos;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Ulica i broj*", "Grad*", "Drzava*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};
	ArrayList<JButton> buttonsInAddStudentForm;
	public InformationStudent() {
		
		textFields = new ArrayList<>();
		combos = new ArrayList<>();
		buttonsInAddStudentForm = new ArrayList<>();
		
		for(int i = 0; i < namesSerbian.length; i++) {

			if(i == 2){
				JPanel temp = new JPanel();
				temp.setBackground(Color.DARK_GRAY);
				temp.setPreferredSize(new Dimension(100, 20));
				JLabel addressFormat = new JLabel("yyyy-mm-dd");
				addressFormat.setForeground(Color.WHITE);
				temp.add(Box.createHorizontalStrut(190));
				temp.add(addressFormat);
				add(createPanel(namesSerbian[i], WindowComponentBuilder.createTextField()));
				add(temp);
			}

			else if(i == 10) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 11) {
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
		addComponentToArray(comp);
		panel.add(comp);
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		
		return panel;
	}
	
	
	private void addComponentToArray(JComponent comp) {
		if(comp instanceof JTextField) {
			textFields.add((JTextField)comp);
		}
		else if(comp instanceof JComboBox) {
			combos.add((JComboBox)comp);
		}
	}
	
	public void fillFormWithStudentInfo(Student student) {
		textFields.get(0).setText(student.getName());
		textFields.get(1).setText(student.getSurname());
		textFields.get(2).setText(student.getDateOfBirth().toString());
		textFields.get(3).setText(student.getHomeAdress().getStreet()+" "+student.getHomeAdress().getNumber());
		textFields.get(4).setText(student.getHomeAdress().getTown());
		textFields.get(5).setText(student.getHomeAdress().getCountry());
		textFields.get(6).setText(student.getPhone());
		textFields.get(7).setText(student.getEmail());
		textFields.get(8).setText(student.getIndex());
		textFields.get(9).setText(String.valueOf(student.getStartYear()));
		combos.get(0).setSelectedIndex(student.getCurrentYear() - 1);
		if(student.getStatus().getValue().equals("BUDZET"))
			combos.get(1).setSelectedIndex(0);
		else
			combos.get(1).setSelectedIndex(1);
	}

	public ArrayList<JButton> getButtonsInAddStudentForm() {
		return buttonsInAddStudentForm;
	}
	
	public JTextField getTextFieldAt(int index) {
		return textFields.get(index);
	}
	
	public JComboBox getComboAt(int index) {
		return combos.get(index);
	}

	public ArrayList<JTextField> getTextFields(){
		return textFields;
	}
}
