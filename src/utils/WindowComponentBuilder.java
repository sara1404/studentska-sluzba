package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bundle.LanguageSupport;
import controller.AddProfessorController;
import controller.AddStudentController;
import controller.AddSubjectController;
import controller.ChangeProfessorController;
import controller.ChangeStudentController;
import controller.ChangeSubjectController;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.dialogs.AddSubjectDialog;
import view.dialogs.ChangeProfessorDialog;
import view.dialogs.ChangeStudentDialog;
import view.dialogs.ChangeSubjectDialog;

public class WindowComponentBuilder {
	public static JTextField createTextField() {
		JTextField input = new JTextField();
		setContainerSize(input, 120, 30);
		input.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				Window window = SwingUtilities.getWindowAncestor(input);
				if(window instanceof AddStudentDialog) {
					try {
						AddStudentDialog dialog = (AddStudentDialog) window;
						AddStudentController.getInstance().validateFields(dialog.getDataInputs());
						dialog.getButtonsInAddStudentForm().get(0).setEnabled(true);
					} catch(Exception ex) {
						AddStudentDialog dialog = (AddStudentDialog) window;
						dialog.getButtonsInAddStudentForm().get(0).setEnabled(false);
					}
				} else if(window instanceof ChangeStudentDialog) {
					try {
						ChangeStudentDialog dialog = (ChangeStudentDialog) window;
						ChangeStudentController.getInstance().validateFields(dialog.getTextFields());
						dialog.getInformationPanel().getButtonsInAddStudentForm().get(0).setEnabled(true);
					} catch (Exception ex) {
						ChangeStudentDialog dialog = (ChangeStudentDialog) window;
						dialog.getInformationPanel().getButtonsInAddStudentForm().get(0).setEnabled(false);
					}
				}else if(window instanceof AddSubjectDialog) {
					try {
						AddSubjectDialog dialog = (AddSubjectDialog) window;
						AddSubjectController.getInstance().validateFields(dialog.getDataInputs());
						dialog.getButtonsInAddSubjectForm().get(0).setEnabled(true);
					} catch (Exception ex) {
						AddSubjectDialog dialog = (AddSubjectDialog) window;
						dialog.getButtonsInAddSubjectForm().get(0).setEnabled(false);
					}
				}else if(window instanceof ChangeSubjectDialog){
					try{
						ChangeSubjectDialog dialog = (ChangeSubjectDialog) window;
						ChangeSubjectController.getInstance().validateFields(dialog.getDataInputs());
						dialog.getButtonsInChangeSubjectForm().get(0).setEnabled(true);
					}catch (Exception ex){
						ChangeSubjectDialog dialog = (ChangeSubjectDialog) window;
						dialog.getButtonsInChangeSubjectForm().get(0).setEnabled(false);
					}
				}
				else if(window instanceof AddProfessorDialog){
					try{
						AddProfessorDialog dialog = (AddProfessorDialog) window;
						AddProfessorController.getInstance().validateFields(dialog.getDataInputs());
						dialog.getButtons().get(0).setEnabled(true);
					}catch (Exception ex){
						AddProfessorDialog dialog = (AddProfessorDialog) window;
						dialog.getButtons().get(0).setEnabled(false);
					}
				}
				else if(window instanceof ChangeProfessorDialog){
					try{
						ChangeProfessorDialog dialog = (ChangeProfessorDialog) window;
						ChangeProfessorController.getInstance().validateFields(dialog.getDataInputs());
						dialog.getInformationPanel().getButtons().get(0).setEnabled(true);
					}catch (Exception ex){
						ChangeProfessorDialog dialog = (ChangeProfessorDialog) window;
						dialog.getInformationPanel().getButtons().get(0).setEnabled(false);
					}
				}
			}
		});
		return input;
	}
	
	public static JComboBox<String> createComboBoxField(String[] data) {
		JComboBox<String> combo = new JComboBox<String>(data);
		combo.setSelectedIndex(0);
		setContainerSize(combo, 120, 30);
		return combo;
	}
	
	
	public static JLabel createLabel(String text) {
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setText(text);	
		setContainerSize(label, 140, 30);
		return label;
	}
	
	public static void setContainerSize(JComponent comp, int width, int height) {
		comp.setMinimumSize(new Dimension(width, height));
		comp.setMaximumSize(new Dimension(width, height));
		comp.setPreferredSize(new Dimension(width, height));
	}
	

	public static JPanel createButtons(JButton btn1, JButton btn2) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		//JButton apply = new JButton();
		WindowComponentBuilder.setContainerSize(btn1, 100, 30);
//		JButton cancel = new JButton();
		WindowComponentBuilder.setContainerSize(btn2, 100, 30);
		btn1.setText(LanguageSupport.getInstance().getResourceBundle().getString("editStudentBtn1"));
		btn2.setText(LanguageSupport.getInstance().getResourceBundle().getString("editStudentBtn2"));
		Utils.setCursor(btn1);
		Utils.setCursor(btn2);
		panel.add(btn1);
		panel.add(Box.createHorizontalStrut(40));
		panel.add(btn2);
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		
		return panel;
	}

}
