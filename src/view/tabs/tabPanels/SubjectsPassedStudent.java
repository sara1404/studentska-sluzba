package view.tabs.tabPanels;

import javax.swing.*;

import utils.Utils;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;

import java.awt.*;

public class SubjectsPassedStudent extends JPanel{
	JLabel averageGradeData;
	JLabel espbSumData;
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
		BoxLayout box = new BoxLayout(grade, BoxLayout.X_AXIS);
		grade.setLayout(box);
		JPanel espb = new JPanel();
		BoxLayout box1 = new BoxLayout(espb, BoxLayout.X_AXIS);
		espb.setLayout(box1);
		JLabel averageGrade = new JLabel("Prosecna ocena: ");
		averageGradeData = new JLabel();
		JLabel espbSum = new JLabel("Ukupno ESPB: ");
		espbSumData = new JLabel();
		grade.add(averageGrade);
		grade.add(averageGradeData);
		espb.add(espbSum);
		espb.add(espbSumData);
		wrapper.add(grade);
		wrapper.add(espb);
		add(wrapper);
	}

	public JLabel getAverageGradeData(){return averageGradeData;}

	public JLabel getEspbSumData(){return espbSumData;}
}
