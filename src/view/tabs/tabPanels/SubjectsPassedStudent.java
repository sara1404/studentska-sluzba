package view.tabs.tabPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.Utils;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;

public class SubjectsPassedStudent extends JPanel{
	public SubjectsPassedStudent() {
		JButton removeGrade = new JButton();
		removeGrade.setText("Ponisti ocenu");
		Utils.setCursor(removeGrade);
		add(removeGrade);
		SubjectsPassedTable subjectsPassedTable = new SubjectsPassedTable();
		add(new JScrollPane(subjectsPassedTable));
	}
}
