package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.*;

import bundle.LanguageSupport;
import controller.ListenerController;
import utils.WindowComponentBuilder;
import view.listeners.StudentListener;





public class AddStudentDialog extends JDialog{

	

	private ArrayList<JTextField> dataInputs;
	private ArrayList<JComboBox> comboInputs;
	String[] namesSerbian = { "Ime*", "Prezime*", "Datum rodjenja*", "Ulica i broj*", "Grad*", "Drzava*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*"};

	ArrayList<JButton> buttonsInAddStudentForm;
	ArrayList<JLabel> labels;

	public AddStudentDialog() {

		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dataInputs = new ArrayList<>();
		comboInputs = new ArrayList<>();
		labels = new ArrayList<>();
		buttonsInAddStudentForm = new ArrayList<>();
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addStudDialogTitle"));
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		getContentPane().setBackground(Color.DARK_GRAY);

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
				JLabel addressFormat = new JLabel("yyyy-mm-dd");
				addressFormat.setForeground(Color.WHITE);
				temp.add(Box.createHorizontalStrut(190));
				temp.add(addressFormat);
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createTextField()));
				getContentPane().add(temp);
			}

			else if(i == 10) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 11) {
				String[] data = {"B", "S"};
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else {
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createTextField()));
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

	public void initComponents() {
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addStudDialogTitle"));
		for(int i = 0; i < labels.size(); i++) {
			JLabel label = labels.get(i);
			label.setText(getTextForLabel(i));
		}
		buttonsInAddStudentForm.get(0).setText(LanguageSupport.getInstance().getResourceBundle().getString("addStudentBtn1"));
		buttonsInAddStudentForm.get(1).setText(LanguageSupport.getInstance().getResourceBundle().getString("addStudentBtn2"));
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
