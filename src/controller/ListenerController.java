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

import bundle.LanguageSupport;
import model.*;
import view.MainFrame;
import view.statusBar.StatusBar;

public class ListenerController {
	public static void tabListener(JTabbedPane tab, StatusBar bar) {
		tab.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				switch (((JTabbedPane) e.getSource()).getSelectedIndex()) {
				case 0:
					bar.setCurrentTab(tab.getTitleAt(0));
					break;
				case 1:
					bar.setCurrentTab(tab.getTitleAt(1));
					break;
				case 2:
					bar.setCurrentTab(tab.getTitleAt(2));
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
					frame.setNewAddSubjectDialog();
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
					frame.setNewChangeSubjectDialog();
					Subject subject = DatabaseReader.getInstance().findSubject(index);
					frame.getChangeSubjectDialog().fillFormWithSubjectInfo(subject);
					frame.getChangeSubjectDialog().determineButtonActivity();
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
						JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("message1"));
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, LanguageSupport.getInstance().getResourceBundle().getString("question1"),
							LanguageSupport.getInstance().getResourceBundle().getString("title1"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						String index = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
						DeleteStudentController.getInstance().deleteStudent(index);
					}
				}
				
				else if (tab.getSelectedIndex() == 1 ) {
					
					if(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable() == -1) {
						JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("message2"));
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, LanguageSupport.getInstance().getResourceBundle().getString("question2"),
							LanguageSupport.getInstance().getResourceBundle().getString("title2"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(resp == 0) {
						String index = MainFrame.getInstance().getTab().getIdOfSelectedProfessor();
						DeleteProfessorController.getInstance().deleteProfessor(index);
					}
				}
				
				else {
					if(MainFrame.getInstance().getTab().getSelectedRowInSubjectTable() == -1) {
						JOptionPane.showMessageDialog(null, LanguageSupport.getInstance().getResourceBundle().getString("message3"));
						return;
					}
					resp = JOptionPane.showConfirmDialog(frame, LanguageSupport.getInstance().getResourceBundle().getString("question3"),
							LanguageSupport.getInstance().getResourceBundle().getString("title3"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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

	public static void setDisplayDepartmentDialog(MainFrame frame, JComponent comp){
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setNewAddDepartmentDirectorDialog();
				frame.getDepartmentsDialog().setVisible(true);
			}
		};
		if (comp instanceof JButton)
			((JButton) comp).addActionListener(listener);
		else if (comp instanceof JMenuItem)
			((JMenuItem) comp).addActionListener(listener);
	}
	
	public static void setDisplayAboutSection(MainFrame frame, JMenuItem itm) {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setAboutSection();
				frame.getAboutDialog().setVisible(true);
				
			}
			
		};
		itm.addActionListener(listener);
	}
}
