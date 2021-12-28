package view.tabs.tabPanels;

import javax.swing.*;

import utils.Utils;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;

import java.awt.*;

public class SubjectsPassedStudent extends JPanel{
	JLabel averageGradeLabel;
	JLabel espbSumLabel;
	public SubjectsPassedStudent() {
		JButton removeGrade = new JButton();
		removeGrade.setText("Ponisti ocenu");
		Utils.setCursor(removeGrade);
		add(removeGrade);
		SubjectsPassedTable subjectsPassedTable = new SubjectsPassedTable();
		add(new JScrollPane(subjectsPassedTable));

		JPanel wrapper = new JPanel();
		BoxLayout box2 = new BoxLayout(wrapper, BoxLayout.Y_AXIS);
		wrapper.setLayout(box2);
		JPanel grade = new JPanel();
		grade.setBackground(Color.DARK_GRAY);
		BoxLayout box = new BoxLayout(grade, BoxLayout.X_AXIS);
		grade.setLayout(box);
		JPanel espb = new JPanel();
		espb.setBackground(Color.DARK_GRAY);
		BoxLayout box1 = new BoxLayout(espb, BoxLayout.X_AXIS);
		espb.setLayout(box1);
		JLabel averageGrade = new JLabel("Prosecna ocena: ");
		averageGrade.setForeground(Color.WHITE);
		averageGradeLabel = new JLabel();
		averageGradeLabel.setForeground(Color.WHITE);
		JLabel espbSum = new JLabel("Ukupno ESPB: ");
		espbSum.setForeground(Color.WHITE);
		espbSumLabel = new JLabel();
		espbSumLabel.setForeground(Color.WHITE);
		grade.add(averageGrade);
		grade.add(averageGradeLabel);
		espb.add(espbSum);
		espb.add(espbSumLabel);
		wrapper.add(grade);
		wrapper.add(espb);
		wrapper.setBackground(Color.DARK_GRAY);
		add(wrapper);
	}

	public JLabel getAverageGradeLabel(){return averageGradeLabel;}

	public JLabel getEspbSumLabel(){return espbSumLabel;}
}
