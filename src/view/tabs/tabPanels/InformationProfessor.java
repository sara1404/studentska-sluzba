package view.tabs.tabPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ListenerController;
import utils.Utils;
import utils.WindowComponentBuilder;

public class InformationProfessor extends JPanel{
	
	BoxLayout boxCenter = new BoxLayout(this, BoxLayout.Y_AXIS);
	ArrayList<JButton> buttons;

	
	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.add(WindowComponentBuilder.createLabel(str));
        pan.setBackground(Color.DARK_GRAY);
        
        switch (field) {
        	case 0:
        		pan.add(WindowComponentBuilder.createTextField());
        		break;
        	case 1:
        		String[] data = {"ASISTENT", "DOCENT", "REDOVNI", "VANREDNI"};
        		pan.add(WindowComponentBuilder.createComboBoxField(data));
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
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(50));
		

		add(panBottom,BorderLayout.SOUTH);
	}
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
}
