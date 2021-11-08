package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StatusBar extends JPanel {
	public StatusBar() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(48, 51, 49));
		JLabel statusLabel = new JLabel("Studentska sluzba");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setForeground(Color.WHITE);
		
		add(Box.createHorizontalStrut(10));
		
		add(statusLabel);	//pored ovoga mora se dodati i naziv taba ali tek nakon sto se to implemetira, NE ZABORAVITI!
		
		
		add(Box.createHorizontalGlue());
		
		LocalTime time = LocalTime.now();
		JLabel timeLabel = new JLabel(DateTimeFormatter.ofPattern("HH:mm").format(time));
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setForeground(Color.WHITE);
		
		add(timeLabel);
		
		add(Box.createHorizontalStrut(10));
		
		LocalDate date = LocalDate.now();
		JLabel dateLabel = new JLabel(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date));
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setForeground(Color.WHITE);
		
		
		
		add(dateLabel);
		
		add(Box.createHorizontalStrut(10));
	}
}
