package view.listeners;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class ToolbarListener extends AbstractAction{
	public ToolbarListener(String name, int event, String description, String path) {
		putValue(NAME, name);
		putValue(MNEMONIC_KEY, event);
		putValue(SHORT_DESCRIPTION, description);
		putValue(SMALL_ICON, new ImageIcon(path));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(event, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("registruje");
	}
}
