package view.tabs.tabPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bundle.LanguageSupport;
import model.Professor;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.listeners.ChangeProfessorListener;

public class InformationProfessor extends JPanel{
	
	ArrayList<JButton> buttons;
	ArrayList<JTextField> textFields;
	JComboBox combo;
	
	private void setPanel(String str, int field) {
		JPanel pan = new JPanel();
		pan.setBackground(Color.DARK_GRAY);
		pan.add(WindowComponentBuilder.createLabel(str));
		pan.add(Box.createHorizontalStrut(50));
        
        switch (field) {
        	case 0:
        		JComponent comp0 = WindowComponentBuilder.createTextField();
        		pan.add(comp0);
        		textFields.add((JTextField)comp0);
        		break;
        	case 1:
        		String[] data = {"ASISTENT", "DOCENT", "REDOVNI", "VANREDNI"};
        		JComponent comp1 = WindowComponentBuilder.createComboBoxField(data);
        		pan.add(comp1);
        		combo =(JComboBox)comp1;
        		break;
        }
        BoxLayout box = new BoxLayout(pan, BoxLayout.X_AXIS);
		pan.setLayout(box);
		add(pan);
		add(Box.createVerticalStrut(10));
	}

	public InformationProfessor() {
		
		buttons= new ArrayList<>();
		setBackground(Color.DARK_GRAY);
	
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);
		textFields = new ArrayList<>();
		setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf0"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf1"), 0);
        JLabel format = new JLabel("    Format: yyyy-MM-dd");
        format.setForeground(Color.GRAY);
        add(format);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf2"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf3"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf4"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf5"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf6"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf7"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf8"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf9"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf10"),0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf11"), 0);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf12"), 1);
        setPanel(LanguageSupport.getInstance().getResourceBundle().getString("editProf13"), 0);
        
		
		JButton btnOk=new JButton(LanguageSupport.getInstance().getResourceBundle().getString("editProfBtn1"));
		
		JButton btnCancel=new JButton(LanguageSupport.getInstance().getResourceBundle().getString("editProfBtn2"));
		buttons.add(btnOk);
		buttons.add(btnCancel);
		add(WindowComponentBuilder.createButtons(btnOk, btnCancel));
		
		btnOk.setEnabled(false);
		btnOk.addActionListener(ChangeProfessorListener.changingProfessorListener(btnOk));
		
	}
	
	public void fillingInfo(Professor professor) {
		textFields.get(0).setText(professor.getSurname());
		textFields.get(1).setText(professor.getName());
		textFields.get(2).setText(professor.getBirthDate().toString());
		textFields.get(3).setText(professor.getHomeAdress().getStreet()+" "+professor.getHomeAdress().getNumber());
		textFields.get(4).setText(professor.getHomeAdress().getTown());
		textFields.get(5).setText(professor.getHomeAdress().getCountry());
		textFields.get(6).setText(professor.getPhone());
		textFields.get(7).setText(professor.getEmail());
		textFields.get(8).setText(professor.getHomeAdress().getStreet()+" "+professor.getHomeAdress().getNumber());
		textFields.get(9).setText(professor.getHomeAdress().getTown());
		textFields.get(10).setText(professor.getHomeAdress().getCountry());
		textFields.get(11).setText(professor.getId());
		switch(professor.getTitle().getValue()) {
		case "ASISTENT":
			combo.setSelectedIndex(0);
			break;
		case "DOCENT":
			combo.setSelectedIndex(1);
			break;
		case "VANREDNI":
			combo.setSelectedIndex(2);
			break;
		default:
			combo.setSelectedIndex(3);
			break;
			
		}
		
		textFields.get(12).setText(String.valueOf(professor.getServiceYears()));
		
	}
	
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	public ArrayList<JTextField> getDataInputs() {
		return textFields;
	}
	
	public JTextField getTextField(int index) {
		return textFields.get(index);
	}


	public JComboBox getCombo() {
		return combo;
	}
	
	public void initComponents() {
		buttons.get(0).setText(LanguageSupport.getInstance().getResourceBundle().getString("editProfBtn1"));
		buttons.get(1).setText(LanguageSupport.getInstance().getResourceBundle().getString("editProfBtn2"));
	}
	
}
