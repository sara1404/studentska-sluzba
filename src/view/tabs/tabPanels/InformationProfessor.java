package view.tabs.tabPanels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import utils.WindowComponentBuilder;

public class InformationProfessor extends JPanel{
	
	//JPanel panCenter = new JPanel();
	BoxLayout boxCenter = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	
	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.add(WindowComponentBuilder.createLabel(str));
        pan.setBackground(Color.DARK_GRAY);
        
        switch (field) {
        	case 0:
        		pan.add(WindowComponentBuilder.createTextField());
        		break;
        	case 1:
        		String[] data = {""};
        		
        		pan.add(WindowComponentBuilder.createComboBoxField(data));
        		break;
        }
        add(pan);
        setLayout(boxCenter);
	}

	public InformationProfessor() {
		
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
        
        //add(Box.createVerticalStrut(25));  
        //add(this,BorderLayout.CENTER);
	}
}
