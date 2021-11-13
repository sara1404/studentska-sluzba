package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
}
