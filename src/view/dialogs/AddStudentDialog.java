package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;

import controller.ListenerController;
import utils.WindowComponentBuilder;
import view.listeners.StudentListener;





public class AddStudentDialog extends JDialog{

	

	private ArrayList<JTextField> dataInputs;
	private ArrayList<JComboBox> comboInputs;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Ulica i broj*", "Grad*", "Drzava*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};

	ArrayList<JButton> buttonsInAddStudentForm;

	public AddStudentDialog() {

		setModalityType(DEFAULT_MODALITY_TYPE);
		dataInputs = new ArrayList<>();
		comboInputs = new ArrayList<>();
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

			if(i == 2){
				JPanel temp = new JPanel();
				temp.setBackground(Color.DARK_GRAY);
				temp.setPreferredSize(new Dimension(100, 20));
				JLabel addressFormat = new JLabel("yy-mm-dd");
				addressFormat.setForeground(Color.WHITE);
				temp.add(Box.createHorizontalStrut(190));
				temp.add(addressFormat);
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createTextField()));
				getContentPane().add(temp);
			}

			else if(i == 10) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 11) {
				String[] data = {"B", "S"};
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else {
				getContentPane().add(createPanel(namesSerbian[i], WindowComponentBuilder.createTextField()));
				getContentPane().add(Box.createVerticalStrut(10));
			}
		}
		
		buttonsInAddStudentForm.add(new JButton());
		buttonsInAddStudentForm.add(new JButton());
		getContentPane().add(WindowComponentBuilder.createButtons(buttonsInAddStudentForm.get(0), buttonsInAddStudentForm.get(1)));
		buttonsInAddStudentForm.get(0).addActionListener(StudentListener.studentAddingListener(buttonsInAddStudentForm.get(0)));
		buttonsInAddStudentForm.get(0).setEnabled(false);
		ListenerController.closeWindowOnCancelListener(this, buttonsInAddStudentForm.get(1));
		
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
			dataInputs.add((JTextField)comp);
		}
		else if(comp instanceof JComboBox) {
			comboInputs.add((JComboBox)comp);
		}
	}

	public ArrayList<JTextField> getDataInputs() {
		return dataInputs;
	}
	
	public JTextField getTextFieldAt(int index) {
		return dataInputs.get(index);
	}
	
	public JComboBox getComboAt(int index) {
		return comboInputs.get(index);
	}

	public ArrayList<JButton> getButtonsInAddStudentForm() {
		return buttonsInAddStudentForm;
	}
}
