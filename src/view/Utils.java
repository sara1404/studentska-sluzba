package view;

import javax.swing.JComponent;
import java.awt.Cursor;

public class Utils {
	
	public static void setCursor(JComponent component) {
		component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
