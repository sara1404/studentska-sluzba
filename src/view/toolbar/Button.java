package view.toolbar;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.Utils;
import view.listeners.ToolbarListener;

public class Button extends JButton{
	
	public Button( String toolTipText, String directory, ToolbarListener tl) {
		//setPreferredSize(new Dimension(width, height));
		super(tl);
		setToolTipText(toolTipText);
		setIcon(new ImageIcon(directory));
		
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(true);
		Utils.setCursor(this);
	}
}
