package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	
	public Button( String toolTipText, String directory) {
		//setPreferredSize(new Dimension(width, height));
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(directory));
		
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(true);
		Utils.setCursor(this);
	}
}
