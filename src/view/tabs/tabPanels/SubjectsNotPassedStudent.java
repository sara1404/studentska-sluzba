package view.tabs.tabPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.GradeEntryController;
import model.CustomListModelForNotPassedSubjects;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Student;
import model.Subject;
import utils.Utils;
import utils.WindowComponentBuilder;
import view.MainFrame;
import view.dialogs.AssignSubjectToStudent;
import view.dialogs.GradeEntry;
import view.listeners.GradeEntryListener;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;

public class SubjectsNotPassedStudent extends JPanel{
	GradeEntry gradeEntry; 
	SubjectsNotPassedTable notPassed;
	SubjectsNotPassedStudent cxt = this;
	public SubjectsNotPassedStudent() {
		JPanel buttonPanel = new JPanel();
		BoxLayout box = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box);
		gradeEntry = new GradeEntry();
	   
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
				setGradeEntry();
				String index = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
				Student student = DatabaseReader.getInstance().findStudent(index);
				try {
					int id = MainFrame.getInstance().getChangeStudentDialog().getSubjectNotPassedStudent().getNotPassed().getSelectedRow();
					String key = student.getFailedExams().get(id).getSubjectKey();
					Subject subject = DatabaseReader.getInstance().findSubject(key);
					gradeEntry.fillingInfo(subject);
			
				gradeEntry.getApplyBtn().addActionListener(GradeEntryListener.enteringGradeListener(gradeEntry.getApplyBtn())); 
				
				
				gradeEntry.getCancelBtn().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						gradeEntry.dispose();					}
				});
				gradeEntry.setVisible(true);
				
				} catch (Exception ex){
					JOptionPane.showMessageDialog(notPassed, "Mora se selektovati predmet iz tabele pre unosa ocene!");
				}
				
			}
		});
		
		notPassed = new SubjectsNotPassedTable();
		add(new JScrollPane(notPassed));
	}
	public GradeEntry getGradeEntry() {
		return gradeEntry;
	}
	public SubjectsNotPassedTable getNotPassed() {
		return notPassed;
	}
	
	public void  setGradeEntry() {
		gradeEntry = new GradeEntry();
	}
	
	
	
}
