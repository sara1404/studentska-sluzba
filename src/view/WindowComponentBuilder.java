package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowComponentBuilder {
	public static JTextField createTextField() {
		JTextField input = new JTextField();
		setContainerSize(input, 120, 30);
		return input;
	}
	
	public static JComboBox<String> createComboBoxField() {
		String[] fakePodaci = {"pod1", "pod2", "pod3"};
		JComboBox<String> combo = new JComboBox<String>(fakePodaci);
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
		btn1.setText("Potvrdi");
		btn2.setText("Odustani");
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
