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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bundle.LanguageSupport;
import controller.ListenerController;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.listeners.ProfessorListener;

public class AddProfessorDialog extends JDialog {
	
	
	private ArrayList<JTextField> textInputs;
	private JComboBox comboInput;
	ArrayList<JButton> buttons;
	
	public AddProfessorDialog(){
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addProfDialogTitle"));
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height *3/4);
		setLocationRelativeTo(null);
		
		textInputs = new ArrayList<>();
		buttons= new ArrayList<>();
		
		
		setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf0"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf1"), 0);
        JLabel format = new JLabel("    Format: yyyy-MM-dd");
        format.setForeground(Color.GRAY);
        add(format);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf2"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf3"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf4"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf5"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf6"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf7"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf8"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf9"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf10"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf11"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf12"), 1);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("addProf13"), 0);
		
		JButton btnOk=new JButton(LanguageSupport.getInstance().getResourceBundle().getString("addProfessorBtn1"));
		buttons.add(btnOk);
		JButton btnCancel=new JButton(LanguageSupport.getInstance().getResourceBundle().getString("addProfessorBtn2"));
		buttons.add(btnCancel);
		getContentPane().add(WindowComponentBuilder.createButtons(btnOk, btnCancel));
		
		
		btnOk.setEnabled(false);
		btnOk.addActionListener(ProfessorListener.addingProfessorListener(btnOk));
		ListenerController.closeWindowOnCancelListener(this, btnCancel);
		
		
	}
	
	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.add(WindowComponentBuilder.createLabel(str));
        pan.setBackground(Color.DARK_GRAY);
        pan.add(Box.createHorizontalStrut(50));
        
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
        BoxLayout box = new BoxLayout(pan, BoxLayout.X_AXIS);
		pan.setLayout(box);
		getContentPane().add(pan);
		getContentPane().add(Box.createVerticalStrut(10));
	}
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	public ArrayList<JTextField> getDataInputs() {
		return textInputs;
	}
	
	public JTextField getTextFieldAt(int index) {
		return textInputs.get(index);
	}


	public JComboBox getComboInput() {
		return comboInput;
	}
	
	public void initComponents() {
		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("addProfDialogTitle"));
		buttons.get(0).setText(LanguageSupport.getInstance().getResourceBundle().getString("addProfessorBtn1"));
		buttons.get(1).setText(LanguageSupport.getInstance().getResourceBundle().getString("addProfessorBtn2"));
	}

}
