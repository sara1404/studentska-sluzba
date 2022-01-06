package view.tabs.tabPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.DatabaseReader;
import model.ObserverNotifier;
import model.Student;
import utils.Utils;
import view.MainFrame;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;

public class SubjectsPassedStudent extends JPanel{
	JLabel averageGradeLabel;
	JLabel espbSumLabel;
	SubjectsPassedTable passed;
	SubjectsPassedStudent sps = this;
	public SubjectsPassedStudent() {
		
		JButton removeGrade = new JButton();
		removeGrade.setText("Ponisti ocenu");
		Utils.setCursor(removeGrade);
		add(removeGrade);
		removeGrade.addActionListener(new ActionListener() {
			int resp = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passed.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(sps, "Mora se selektovati predmet kojem se ponistava ocena! ");
				else {
					resp = JOptionPane.showConfirmDialog(sps, "Da li ste sigurni da zelite da ponistite ocenu?",
							"Ponistavanje ocene", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
						student.getPassedExams().remove(student.getPassedExams().get(passed.getSelectedRow()));
;						ObserverNotifier.getInstance().subjectsPassedDataChanged();
				}
				
			}
			}
		});
		passed = new SubjectsPassedTable();
		add(new JScrollPane(passed));

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
