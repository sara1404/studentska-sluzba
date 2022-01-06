package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.DatabaseReader;
import model.Professor;
import model.Student;
import model.Subject;
import view.MainFrame;
import view.statusBar.StatusBar;
import view.menuBar.MenuBar;

public class ListenerController {
	public static void tabListener(JTabbedPane tab, StatusBar bar) {
		tab.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				switch (((JTabbedPane) e.getSource()).getSelectedIndex()) {
				case 0:
					bar.setCurrentTab("Studenti");
					break;
				case 1:
					bar.setCurrentTab("Profesori");
					break;
				case 2:
					bar.setCurrentTab("Predmeti");
					break;
				}
			}

		});
	}

	public static void closeWindowOnCancelListener(JDialog dialog, JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(false);
			}
		});
	}
	
	public static void closeApplication(JMenuItem itm) {
		itm.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
	}
	

	public static void setDisplayAddDialogAction(MainFrame frame, JTabbedPane tab, JComponent comp) {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (tab.getSelectedIndex() == 0)
					frame.setNewAddStudentDialog();
				else if (tab.getSelectedIndex() == 1)
					frame.setNewAddProfessorDialog();

				else
					frame.getAddSubjectDialog().setVisible(true);
			}
		};

		if (comp instanceof JButton)
			((JButton) comp).addActionListener(listener);
		else if (comp instanceof JMenuItem)
			((JMenuItem) comp).addActionListener(listener);
	}
	
	public static void switchTabsfromMenu(MainFrame frame, JTabbedPane tab, JMenuItem itm, int index) {
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tab.setSelectedIndex(index);
				
			}
		};
		itm.addActionListener(listener);
	}

	public static void setDisplayChangeDialogAction(MainFrame frame, JTabbedPane tab, JComponent comp) {

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (tab.getSelectedIndex() == 0) {
					String index = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
					if(index == null) return;
					frame.setNewChangeStudentDialog();
					Student student = DatabaseReader.getInstance().findStudent(index);
					
					
					frame.getChangeStudentDialog().getInformationPanel().fillFormWithStudentInfo(student);
					ShowPassedExamsForStudentController.getInstance().setAverageGrade(frame.getChangeStudentDialog().getSubjectPassedStudent());
					ShowPassedExamsForStudentController.getInstance().setEspbPoints(frame.getChangeStudentDialog().getSubjectPassedStudent());
					frame.getChangeStudentDialog().setVisible(true);
					
					

				}
				else if (tab.getSelectedIndex() == 1) {

					String id = MainFrame.getInstance().getTab().getIdOfSelectedProfessor();
					if(id == null) return;
					Professor professor = DatabaseReader.getInstance().findProfessor(id);
					frame.setNewChangeProfessorDialog();
					frame.getChangeProfessorDialog().getInformationPanel().fillingInfo(professor);
					frame.getChangeProfessorDialog().setVisible(true);
					

				}
				else {
					String index = MainFrame.getInstance().getTab().getIdOfSelectedSubject();
					if(index == null) return;
					Subject subject = DatabaseReader.getInstance().findSubject(index);
					frame.getChangeSubjectDialog().fillFormWithSubjectInfo(subject);
					frame.getChangeSubjectDialog().setVisible(true);
				}
					

			}

		};

		if (comp instanceof JButton)
			((JButton) comp).addActionListener(listener);
		else if (comp instanceof JMenuItem)
			((JMenuItem) comp).addActionListener(listener);
	}

	public static void setDisplayDeleteDialogAction(MainFrame frame, JTabbedPane tab, JComponent comp) {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resp;
			
				// TODO Auto-generated method stub
				if (tab.getSelectedIndex() == 0) {
					
					if(MainFrame.getInstance().getTab().getSelectedRowInStudentTable() == -1) {
						JOptionPane.showMessageDialog(null, "Mora se selektovati student iz tabele pre brisanja!");
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this entity?",
							"Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						String index = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
						DeleteStudentController.getInstance().deleteStudent(index);
					}
				}
				
				else if (tab.getSelectedIndex() == 1 ) {
					
					if(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable() == -1) {
						JOptionPane.showMessageDialog(null, "Mora se selektovati professor iz tabele pre brisanja!");
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this entity?",
							"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						String index = MainFrame.getInstance().getTab().getIdOfSelectedProfessor();
						DeleteProfessorController.getInstance().deleteProfessor(index);
					}
				}
				
				else {
					if(MainFrame.getInstance().getTab().getSelectedRowInSubjectTable() == -1) {
						JOptionPane.showMessageDialog(null, "Mora se selektovati predmet iz tabele pre brisanja!");
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this entity?",
							"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						String index = MainFrame.getInstance().getTab().getIdOfSelectedSubject();
						DeleteSubjectController.getInstance().deleteSubject(index);
					}
				}
			}

		};

		if (comp instanceof JButton)
			((JButton) comp).addActionListener(listener);
		else if (comp instanceof JMenuItem)
			((JMenuItem) comp).addActionListener(listener);
	}
}
