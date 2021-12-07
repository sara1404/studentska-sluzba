package view.statusBar;

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
		JLabel currentTablbl = new JLabel("Studenti");
		JLabel timeLbl = new JLabel();
	public StatusBar() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(48, 51, 49));
		JLabel statusLabel = new JLabel("Studentska sluzba - ");

		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setForeground(Color.WHITE);
		currentTablbl.setHorizontalAlignment(SwingConstants.LEFT);
		currentTablbl.setForeground(Color.WHITE);
		add(Box.createHorizontalStrut(10));
		
		add(statusLabel);	//pored ovoga mora se dodati i naziv taba ali tek nakon sto se to implemetira, NE ZABORAVITI!
		add(currentTablbl);
		
		
		add(Box.createHorizontalGlue());
		
		add(timeLbl);

 	    timeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
 	    timeLbl.setForeground(Color.WHITE);
		
		getTime();
		
		
		add(Box.createHorizontalStrut(10));
		
		LocalDate date = LocalDate.now();
		JLabel dateLabel = new JLabel(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date));
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLabel.setForeground(Color.WHITE);
		
		
		
		add(dateLabel);
		
		add(Box.createHorizontalStrut(10));
	}
	
	public void setCurrentTab(String currentTab) {
		currentTablbl.setText(currentTab);
	}
	private void getTime() {
		Thread t1 = new Thread(){
	        public void run(){
	           while(true){
	               try {
	            	   LocalTime time = LocalTime.now();
		        	   int hours = time.getHour();
		        	   int minutes = time.getMinute();
		        	   int seconds = time.getSecond();
		        	   String hoursStr = hours < 10 ? "0" + hours : String.valueOf(hours);
		        	   String minutesStr = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
		        	   String secondsStr = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
		        	   timeLbl.setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
		        	   sleep(1000);
		            } catch (InterruptedException e) {
		                    e.printStackTrace();
		            }
	        }
	    }
	   };
	   t1.start();
	}
}