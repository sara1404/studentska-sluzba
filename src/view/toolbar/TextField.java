package view.toolbar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextField extends JTextField {
	
	public TextField() {
		JTextField tf = new JTextField();
		setPreferredSize(new Dimension(130, 30));
		setMaximumSize(new Dimension(130, 30));
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		
	}
}
