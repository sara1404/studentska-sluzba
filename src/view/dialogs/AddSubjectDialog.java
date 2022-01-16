package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bundle.LanguageSupport;
import controller.ListenerController;
import utils.WindowComponentBuilder;
import view.listeners.SubjectListener;
import view.toolbar.Button;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddSubjectDialog extends JDialog {
	
	ArrayList<JTextField> dataInputs;
	ArrayList<JComboBox> comboInputs;
	private String[] labelText = {"Sifra predmeta*", "Naziv predmeta*", "Semestar*", "Godina studija*", "Broj ESPB bodova*"};
	ArrayList<JButton> buttonsInAddSubjectForm;
	private ArrayList<JLabel> labels;
	
	public AddSubjectDialog() {
		setModalityType(DEFAULT_MODALITY_TYPE);
		dataInputs = new ArrayList<JTextField>();
		comboInputs = new ArrayList<JComboBox>();
		buttonsInAddSubjectForm = new ArrayList<>();
		labels = new ArrayList<>();
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addSubDialogTitle"));
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height * 3/4);
		setLocationRelativeTo(null);
		
		for(int i = 0; i < labelText.length; i++) {
			if(i == 2) {
				String[] data = {"LETNJI", "ZIMSKI"};
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 3) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createComboBoxField(data)));
			}
			else {
				getContentPane().add(createPanel(getTextForLabel(i), WindowComponentBuilder.createTextField()));
			}
		}
		
		buttonsInAddSubjectForm.add(new JButton());
		buttonsInAddSubjectForm.add(new JButton());
		getContentPane().add(WindowComponentBuilder.createButtons(buttonsInAddSubjectForm.get(0), buttonsInAddSubjectForm.get(1)));
		
		ListenerController.closeWindowOnCancelListener(this, buttonsInAddSubjectForm.get(1));
		buttonsInAddSubjectForm.get(0).addActionListener(SubjectListener.subjectAddingListener(buttonsInAddSubjectForm.get(0)));
		buttonsInAddSubjectForm.get(0).setEnabled(false);
		
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

	public ArrayList<JButton> getButtonsInAddSubjectForm() {
		return buttonsInAddSubjectForm;
	}
	
	public void initComponents() {
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addSubDialogTitle"));
		for(int i = 0; i < labels.size(); i++) {
			JLabel label = labels.get(i);
			label.setText(getTextForLabel(i));
		}
		buttonsInAddSubjectForm.get(0).setText(LanguageSupport.getInstance().getResourceBundle().getString("addSubjectBtn1"));
		buttonsInAddSubjectForm.get(1).setText(LanguageSupport.getInstance().getResourceBundle().getString("addSubjectBtn2"));
	}
	
	private String getTextForLabel(int i ) {
		ResourceBundle bundle = LanguageSupport.getInstance().getResourceBundle();
		switch(i) {
		case 0:  return bundle.getString("addSub0");
		case 1: return bundle.getString("addSub1");
		case 2:  return bundle.getString("addSub2");
		case 3: return bundle.getString("addSub3");
		case 4:  return bundle.getString("addSub4");
		default: return "";
		}
	}
}
