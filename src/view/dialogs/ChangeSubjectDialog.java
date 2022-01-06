package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ListenerController;
import model.Subject;
import utils.WindowComponentBuilder;
import view.listeners.ChangeSubjectListener;
import view.tabs.tabPanels.SubjectsNotPassedStudent;

public class ChangeSubjectDialog extends JDialog{
	ArrayList<JTextField> dataInputs;
	ArrayList<JComboBox> comboInputs;
	private String[] labelText = {"Sifra predmeta*", "Naziv predmeta*", "Semestar*", "Godina studija*", "Predmetni profesor*", "Broj ESPB bodova*"};
	ArrayList<JButton> buttonsInChangeSubjectForm;
	
	AssignProfessorToSubject assignProfessorToSubject =  new AssignProfessorToSubject();
	SubjectsNotPassedStudent snps = new SubjectsNotPassedStudent();
	
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
			else if(i == 3) {
				String[] data = {"1", "2", "3", "4", "5", "6"};
				getContentPane().add(createPanel(labelText[i], WindowComponentBuilder.createComboBoxField(data)));
			}
			else if(i == 4) {
				JTextField field = WindowComponentBuilder.createTextField();
				field.setEditable(false);
				JButton add = new JButton();
				add.setPreferredSize(new Dimension(30, 30));
				add.setMaximumSize(new Dimension(30, 30));
				JButton remove = new JButton();
				remove.setPreferredSize(new Dimension(30, 30));
				remove.setMaximumSize(new Dimension(30, 30));
				
				getContentPane().add(createSpecialPanel(labelText[i], field, add, remove));
				
				add.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						assignProfessorToSubject.getApplyBtn().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								dataInputs.get(2).setText(assignProfessorToSubject.getProfessorList().getSelectedValue());
								assignProfessorToSubject.dispose();
							}
							
						});
						
						assignProfessorToSubject.getCancelBtn().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								assignProfessorToSubject.dispose();
							}
							
						});
						assignProfessorToSubject.setVisible(true);
					}
					
				});
				
			}
			else {
				getContentPane().add(createPanel(labelText[i], WindowComponentBuilder.createTextField()));
			}
		}
		
		buttonsInChangeSubjectForm.add(new JButton());
		buttonsInChangeSubjectForm.add(new JButton());
		getContentPane().add(WindowComponentBuilder.createButtons(buttonsInChangeSubjectForm.get(0), buttonsInChangeSubjectForm.get(1)));
		
		
		
		ListenerController.closeWindowOnCancelListener(this, buttonsInChangeSubjectForm.get(1));
		buttonsInChangeSubjectForm.get(0).addActionListener(ChangeSubjectListener.subjectChangingListener(buttonsInChangeSubjectForm.get(0)));
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
	
	private JPanel createSpecialPanel(String text, JComponent comp, JButton add, JButton remove) {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 200));
		panel.setBackground(Color.DARK_GRAY);
		panel.add(Box.createHorizontalStrut(70));
		panel.add(WindowComponentBuilder.createLabel(text));
		panel.add(Box.createHorizontalStrut(40));
		addComponentToArray(comp);
		panel.add(tempPanel(comp, add, remove));

		return panel;
	}
	
	private JPanel tempPanel(JComponent comp, JButton addBtn, JButton removeBtn) {
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
	
	public ArrayList<JButton> getButtonsInChangeSubjectForm() {
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
	
	public JList<String> getProfessorList(){
		return assignProfessorToSubject.getProfessorList();
	}
	
	
	
	public SubjectsNotPassedStudent getSnps() {
		return snps;
	}

	public void fillFormWithSubjectInfo(Subject subject) {
		dataInputs.get(0).setText(subject.getSubjectKey());
		dataInputs.get(1).setText(subject.getSubjectName());
		if(subject.getSemester().getValue().equals("LETNJI")) {
			comboInputs.get(0).setSelectedIndex(0);
		}
		else
			comboInputs.get(0).setSelectedIndex(1);
		for(int i = 1; i <= 6; i++) {
			if(subject.getYear() == i)
				comboInputs.get(1).setSelectedIndex(i);
		}
		comboInputs.get(0).setSelectedItem(subject.getSemester());
		comboInputs.get(1).setSelectedItem(subject.getYear());
		dataInputs.get(2).setText(String.valueOf(subject.getProfessor()));
		dataInputs.get(3).setText(String.valueOf(subject.getESPB()));
	}
}
