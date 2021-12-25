package view.tabs.tabPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Professor;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.listeners.ChangeProfessorListener;

public class InformationProfessor extends JPanel{
	
	BoxLayout boxCenter = new BoxLayout(this, BoxLayout.Y_AXIS);
	ArrayList<JButton> buttons;
	ArrayList<JTextField> textFields;
	JComboBox combo;
	
	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.add(WindowComponentBuilder.createLabel(str));
        pan.setBackground(Color.DARK_GRAY);
        
        switch (field) {
        	case 0:
        		JComponent comp0 = WindowComponentBuilder.createTextField();
        		pan.add(comp0);
        		textFields.add((JTextField)comp0);
        		break;
        	case 1:
        		String[] data = {"ASISTENT", "DOCENT", "REDOVNI", "VANREDNI"};
        		JComponent comp1 = WindowComponentBuilder.createComboBoxField(data);
        		pan.add(comp1);
        		combo =(JComboBox)comp1;
        		break;
        }
        add(pan);
        setLayout(boxCenter);
	}

	public InformationProfessor() {
		
		setLayout(boxCenter);
		setBackground(Color.DARK_GRAY);
		buttons= new ArrayList<>();
		setLayout(boxCenter);
		setBackground(Color.DARK_GRAY);
	
		textFields = new ArrayList<>();
		setPanel("Prezime*", 0);
        setPanel("Ime*", 0);
        setPanel("Datum rodjenja*", 0);
        setPanel("Adresa stanovanja*", 0);
        setPanel("Kontakt telefon", 0);
        setPanel("E-mail*", 0);
        setPanel("Adresa kancelarije*", 0);
        setPanel("Broj licne karte*", 0);
        setPanel("Zvanje*", 1);
        setPanel("Godine staza*", 0);
        
        add(Box.createVerticalStrut(25));  
        
        JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		panBottom.setBackground(Color.DARK_GRAY);
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(100,25));
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.setPreferredSize(new Dimension(100,25));
		
		panBottom.add(Box.createHorizontalStrut(200));
		panBottom.add(btnOk);
		Utils.setCursor(btnOk);
		panBottom.add(Box.createHorizontalStrut(100));
		panBottom.add(btnCancel);
		Utils.setCursor(btnCancel);
		buttons.add(btnOk);
		buttons.add(btnCancel);
		btnOk.setEnabled(false);
		btnOk.addActionListener(ChangeProfessorListener.changingProfessorListener(btnOk));
		
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(50));
		

		add(panBottom,BorderLayout.SOUTH);
	}
	
	public void fillingInfo(Professor professor) {
		textFields.get(0).setText(professor.getSurname());
		textFields.get(1).setText(professor.getName());
		textFields.get(2).setText(professor.getBirthDate().toString());
		textFields.get(3).setText(professor.getHomeAdress().toString());
		textFields.get(4).setText(professor.getPhone());
		textFields.get(5).setText(professor.getEmail());
		textFields.get(6).setText(professor.getOfficeAdress().toString());
		textFields.get(7).setText(professor.getId());
		switch(professor.getTitle().getValue()) {
		case "ASISTENT":
			combo.setSelectedIndex(0);
			break;
		case "DOCENT":
			combo.setSelectedIndex(1);
			break;
		case "VANREDNI":
			combo.setSelectedIndex(2);
			break;
		default:
			combo.setSelectedIndex(3);
			break;
			
		}
		
		textFields.get(8).setText(String.valueOf(professor.getServiceYears()));
		
	}
	
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	public ArrayList<JTextField> getDataInputs() {
		return textFields;
	}
	
	public JTextField getTextField(int index) {
		return textFields.get(index);
	}


	public JComboBox getCombo() {
		return combo;
	}
	
}
