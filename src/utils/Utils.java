package utils;

import javax.swing.JComponent;
import java.awt.Cursor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public static void setCursor(JComponent component) {
		component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public static String DateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return date.format(formatter);
	}
}
