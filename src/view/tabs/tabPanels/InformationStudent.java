package view.tabs.tabPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;

import bundle.LanguageSupport;
import controller.ListenerController;
import model.Student;
import utils.Utils;
import utils.WindowComponentBuilder;

public class InformationStudent extends JPanel{
	
	ArrayList<JTextField> textFields;
	ArrayList<JComboBox> combos;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Ulica i broj*", "Grad*", "Drzava*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};
	ArrayList<JButton> buttonsInChangeStudentForm;
	private ArrayList<JLabel> labels;
	public InformationStudent() {
		
		textFields = new ArrayList<>();
		combos = new ArrayList<>();
		buttonsInChangeStudentForm = new ArrayList<>();
		labels = new ArrayList<>();
		
		for(int i = 0; i < namesSerbian.length; i++) {

			if(i == 2){
				JPanel temp = new JPanel();
				temp.setBackground(Color.DARK_GRAY);
				temp.setPreferredSize(new Dimension(100, 20));
				JLabel addressFormat = new JLabel("yyyy-mm-dd");
				addressFormat.setForeground(Color.WHITE);
				temp.add(Box.createHorizontalStrut(190));
				temp.add(addressFormat);
				add(createPanel(getTextForLabel(i), WindowComponentBuilder.createTextField()));
				add(temp);
			}

			else if(i == 10) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 11) {
				String[] data = {"B", "S"};
				add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else {
				add(createPanel(getTextForLabel(i), WindowComponentBuilder.createTextField()));
				add(Box.createVerticalStrut(10));
			}
		}
		
		buttonsInChangeStudentForm.add(new JButton());
		buttonsInChangeStudentForm.add(new JButton());
		add(WindowComponentBuilder.createButtons(buttonsInChangeStudentForm.get(0), buttonsInChangeStudentForm.get(1)));
		
		
	}
	
	private JPanel createPanel(String text, JComponent comp) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		JLabel lbl = WindowComponentBuilder.createLabel(text);
		labels.add(lbl);
		panel.add(lbl);	
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
		if(student.getHomeAdress() == null) {
			textFields.get(3).setText("");
			textFields.get(4).setText("");
			textFields.get(5).setText("");
		} else {
			textFields.get(3).setText(student.getHomeAdress().getStreet()+" "+student.getHomeAdress().getNumber());
			textFields.get(4).setText(student.getHomeAdress().getTown());
			textFields.get(5).setText(student.getHomeAdress().getCountry());
		}
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
		return buttonsInChangeStudentForm;
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
	
	public void initComponents() {
		for(int i = 0; i < labels.size(); i++) {
			JLabel label = labels.get(i);
			label.setText(getTextForLabel(i));
		}
		buttonsInChangeStudentForm.get(0).setText(LanguageSupport.getInstance().getResourceBundle().getString("editStudentBtn1"));
		buttonsInChangeStudentForm.get(1).setText(LanguageSupport.getInstance().getResourceBundle().getString("editStudentBtn2"));
	}
	
	private String getTextForLabel(int i ) {
		ResourceBundle bundle = LanguageSupport.getInstance().getResourceBundle();
		switch(i) {
		case 0:  return bundle.getString("addStud0");
		case 1: return bundle.getString("addStud1");
		case 2:  return bundle.getString("addStud2");
		case 3: return bundle.getString("addStud3");
		case 4:  return bundle.getString("addStud4");
		case 5: return bundle.getString("addStud5");
		case 6:  return bundle.getString("addStud6");
		case 7: return bundle.getString("addStud7");
		case 8:  return bundle.getString("addStud8");
		case 9: return bundle.getString("addStud9");
		case 10:  return bundle.getString("addStud10");
		case 11: return bundle.getString("addStud11");
		default: return "";
		}
	}
}
