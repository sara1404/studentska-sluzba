package view.tabs.tabPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.DatabaseReader;
import model.ObserverNotifier;
import model.Student;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.MainFrame;
import view.dialogs.AssignSubjectToStudent;
import view.dialogs.GradeEntry;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class SubjectsNotPassedStudent extends JPanel{
	
	GradeEntry gradeEntry = new GradeEntry();
	SubjectsNotPassedTable notPassed;
	SubjectsNotPassedStudent cxt = this;
	public SubjectsNotPassedStudent() {
		JPanel buttonPanel = new JPanel();
		BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box);
		
		JButton addBtn = new JButton();
		JButton removeBtn = new JButton();
		JButton passBtn = new JButton();
		
		addBtn.setText("Dodaj");
		removeBtn.setText("Obrisi");
		passBtn.setText("Polaganje");
		
		WindowComponentBuilder.setContainerSize(addBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(removeBtn, 100, 30);
		WindowComponentBuilder.setContainerSize(passBtn, 100, 30);
		
		Utils.setCursor(addBtn);
		Utils.setCursor(removeBtn);
		Utils.setCursor(passBtn);
		
		buttonPanel.add(addBtn);
		buttonPanel.add(removeBtn);
		buttonPanel.add(passBtn);
		
		add(buttonPanel);

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AssignSubjectToStudent dialog = new AssignSubjectToStudent();
				dialog.setVisible(true);
			}
		});

		removeBtn.addActionListener(new ActionListener() {
			int resp = 0;
			@Override

			public void actionPerformed(ActionEvent e) {
				if(notPassed.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(cxt, "Morate selektovati predmet iz tabele pre brisanja!");
				else{
					resp = JOptionPane.showConfirmDialog(cxt, "Da li zelite da izbrisete predmet za studenta?",
							"Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						Student student = DatabaseReader.getInstance().getStudents().get(MainFrame.getInstance().getTab().getSelectedRowInStudentTable());
						student.getFailedExams().remove(student.getFailedExams().get(notPassed.getSelectedRow()));
						ObserverNotifier.getInstance().subjectsNotPassedDataChanged();
					}
				}


			}
		});

		passBtn.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gradeEntry.getApplyBtn().addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gradeEntry.dispose();
					}
				});
				
				gradeEntry.getCancelBtn().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gradeEntry.dispose();					}
				});
				gradeEntry.setVisible(true);
			}
		});
		
		notPassed = new SubjectsNotPassedTable();
		add(new JScrollPane(notPassed));
	}
	
	
}
