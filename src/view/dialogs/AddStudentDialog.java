package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;



import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ListenerController;
import utils.WindowComponentBuilder;





public class AddStudentDialog extends JDialog{

	

	ArrayList<JTextField> dataInputs;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};

	ArrayList<JButton> buttonsInAddStudentForm;

	public AddStudentDialog() {

		dataInputs = new ArrayList<>();
		buttonsInAddStudentForm = new ArrayList<>();
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Dodavanje studenta");
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		getContentPane().setBackground(Color.DARK_GRAY);

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height * 3/4);
		setLocationRelativeTo(null);
		
		for(int i = 0; i < namesSerbian.length; i++) {

			if(i > namesSerbian.length - 3) 
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField()));
			else {
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createTextField()));
				getContentPane().add(Box.createVerticalStrut(10));
			}
		}
		
		buttonsInAddStudentForm.add(new JButton());
		buttonsInAddStudentForm.add(new JButton());
		getContentPane().add(WindowComponentBuilder.createButtons(buttonsInAddStudentForm.get(0), buttonsInAddStudentForm.get(1)));
		
		ListenerController.closeWindowOnCancelListener(this, buttonsInAddStudentForm.get(1));
		
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
	
	
}
