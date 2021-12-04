package view.tabs.tabPanels;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Utils;

public class SubjectsPassedStudent extends JPanel{
	public SubjectsPassedStudent() {
		JButton removeGrade = new JButton();
		removeGrade.setText("Ponisti ocenu");
		Utils.setCursor(removeGrade);
		add(removeGrade);
	}
}
