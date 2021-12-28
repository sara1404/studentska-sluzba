package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import utils.WindowComponentBuilder;

public class GradeEntry extends JDialog{
	
	JPanel panCenter = new JPanel();
	BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	JButton applyBtn;
	JButton cancelBtn;
	
	public GradeEntry() {
		setModalityType(DEFAULT_MODALITY_TYPE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Unos ocene");
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 1/4, height * 1/3);
		setLocationRelativeTo(null);
		
		panCenter.setLayout(boxCenter);
		panCenter.setBackground(Color.DARK_GRAY);
		
		JPanel keyPan = new JPanel();
		keyPan.add(WindowComponentBuilder.createLabel("Sifra*"));
		keyPan.setBackground(Color.DARK_GRAY);
		JComponent keyComp = WindowComponentBuilder.createTextField();
		keyComp.setEnabled(false);
		keyComp.setBackground(Color.GRAY);
		keyPan.add(keyComp);
		panCenter.add(keyPan);
		
		JPanel namePan = new JPanel();
		namePan.add(WindowComponentBuilder.createLabel("Naziv*"));
		namePan.setBackground(Color.DARK_GRAY);
		JComponent nameComp = WindowComponentBuilder.createTextField();
		nameComp.setEnabled(false);
		nameComp.setBackground(Color.GRAY);
		namePan.add(nameComp);
		panCenter.add(namePan);
		
		JPanel gradePan = new JPanel();
		gradePan.add(WindowComponentBuilder.createLabel("Ocena*"));
		gradePan.setBackground(Color.DARK_GRAY);
		String[] data = {"6", "7", "8", "9", "10"};
		JComponent gradeComp = WindowComponentBuilder.createComboBoxField(data);
		gradePan.add(gradeComp);
		panCenter.add(gradePan);
		
		JPanel datePan = new JPanel();
		datePan.add(WindowComponentBuilder.createLabel("Datum*"));
		datePan.setBackground(Color.DARK_GRAY);
		JComponent dateComp = WindowComponentBuilder.createTextField();
		datePan.add(dateComp);
		panCenter.add(datePan);
		
	
		
		JPanel btnPanel = new JPanel();
		BoxLayout btnBox = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(btnBox);
		btnPanel.setBackground(Color.DARK_GRAY);
		applyBtn = new JButton();
		cancelBtn = new JButton();
		applyBtn.setText("Potvrdi");
		cancelBtn.setText("Odustani");
		btnPanel.add(applyBtn);
		btnPanel.add(cancelBtn);
		panCenter.add(btnPanel);
		
		add(panCenter,BorderLayout.CENTER);
		
	}
	
	public JButton getApplyBtn() {
		return applyBtn;
	}
	
	public JButton getCancelBtn() {
		return cancelBtn;
	}
}
