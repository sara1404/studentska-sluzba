package view.dialogs;

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
import javax.swing.WindowConstants;

import controller.ListenerController;
import model.Student;
import model.Subject;
import utils.WindowComponentBuilder;
import view.toolbar.Button;

public class ChangeSubjectDialog extends JDialog{
	ArrayList<JTextField> dataInputs;
	ArrayList<JComboBox> comboInputs;
	private String[] labelText = {"Sifra predmeta*", "Naziv predmeta*", "Semestar*", "Godina studija*", "Predmetni profesor*", "Broj ESPB bodova*"};
	ArrayList<JButton> buttonsInChangeSubjectForm;
	
	public ChangeSubjectDialog() {
		setModalityType(DEFAULT_MODALITY_TYPE);
		dataInputs = new ArrayList<JTextField>();
		comboInputs = new ArrayList<JComboBox>();
		buttonsInChangeSubjectForm = new ArrayList<>();
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Izmena predmeta");
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
				getContentPane().add(createPanel(labelText[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 4) {
				JTextField field = WindowComponentBuilder.createTextField();
				field.setEditable(false);
				Button add = new Button("add professor", "src/menubar_imgs/new.png");
				add.setPreferredSize(new Dimension(30, 30));
				add.setMaximumSize(new Dimension(30, 30));
				Button remove = new Button("remove professor", "src/menubar_imgs/remove.png");
				remove.setPreferredSize(new Dimension(30, 30));
				remove.setMaximumSize(new Dimension(30, 30));
				
				getContentPane().add(createSpecialPanel(labelText[i], field, add, remove));
			}
			else {
				getContentPane().add(createPanel(labelText[i], WindowComponentBuilder.createTextField()));
			}
		}
		
		buttonsInChangeSubjectForm.add(new JButton());
		buttonsInChangeSubjectForm.add(new JButton());
		getContentPane().add(WindowComponentBuilder.createButtons(buttonsInChangeSubjectForm.get(0), buttonsInChangeSubjectForm.get(1)));
		
		ListenerController.closeWindowOnCancelListener(this, buttonsInChangeSubjectForm.get(1));
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
	
	private JPanel createSpecialPanel(String text, JComponent comp, Button add, Button remove) {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 200));
		panel.setBackground(Color.DARK_GRAY);
		panel.add(Box.createHorizontalStrut(70));
		panel.add(WindowComponentBuilder.createLabel(text));
		panel.add(Box.createHorizontalStrut(40));
		addComponentToArray(comp);
		panel.add(tempPanel(comp, add, remove));
//		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
//		panel.setLayout(box);
		
		return panel;
	}
	
	private JPanel tempPanel(JComponent comp, Button addBtn, Button removeBtn) {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(120, 200));
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		panel.setBackground(Color.DARK_GRAY);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		panel.add(comp);
		panel.add(buttonPanel);
		
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
	
	public void fillFormWithSubjectInfo(Subject subject) {
		dataInputs.get(0).setText(subject.getSubjectKey());
		dataInputs.get(1).setText(subject.getSubjectName());
		dataInputs.get(2).setText(String.valueOf(subject.getSemester()));
		dataInputs.get(3).setText(String.valueOf(subject.getYear()));
		dataInputs.get(4).setText(String.valueOf(subject.getProfessor()));
		dataInputs.get(5).setText(String.valueOf(subject.getESPB()));
	}

	public ArrayList<JButton> getButtonsInAddSubjectForm() {
		return buttonsInChangeSubjectForm;
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
}