package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerController;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.listeners.ProfessorListener;

public class AddProfessorDialog extends JDialog {
	
	JPanel panCenter = new JPanel();
	BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	private ArrayList<JTextField> textInputs;
	private JComboBox comboInput;

	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.add(WindowComponentBuilder.createLabel(str));
        pan.setBackground(Color.DARK_GRAY);
        
        switch (field) {
        	case 0:
        		JComponent comp0 = WindowComponentBuilder.createTextField();
        		pan.add(comp0);
        		textInputs.add((JTextField)comp0);
        		break;
        	case 1:
        		String[] data = {"ASISTENT", "DOCENT", "VANREDNI", "REDOVNI"};
        		JComponent comp1 = WindowComponentBuilder.createComboBoxField(data);
        		pan.add(comp1);
        		comboInput = (JComboBox)comp1;
        		
        		break;
        }
        panCenter.add(pan);

       
	}
	

	public AddProfessorDialog(){
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Dodavanje profesora");
		
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height *3/4);
		setLocationRelativeTo(null);
		
		panCenter.setLayout(boxCenter);
		panCenter.setBackground(Color.DARK_GRAY);

		textInputs = new ArrayList<>();
		
		
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
        
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
       
 
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
		
		//ListenerController.closeWindowOnCancelListener(this, btnOk);
		btnOk.addActionListener(ProfessorListener.addingProfessorListener(btnOk));
		ListenerController.closeWindowOnCancelListener(this, btnCancel);
		
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(50));
		

		add(panBottom,BorderLayout.SOUTH);
		
	}
	
	public JTextField getTextFieldAt(int index) {
		return textInputs.get(index);
	}


	public JComboBox getComboInput() {
		return comboInput;
	}

}
