package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MainFrame;
import view.StatusBar;

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
	
	public static void setDisplayAddDialogAction(MainFrame frame, JTabbedPane tab, JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tab.getSelectedIndex() == 0) 
					frame.getAddStudentDialog().setVisible(true);

				else if(tab.getSelectedIndex() == 1) 
					frame.getAddProfessorDialog().setVisible(true);
				
				else 
					frame.getAddSubjectDialog().setVisible(true);
			}
			
		});
	}	
	
	public static void setDisplayChangeDialogAction(MainFrame frame, JTabbedPane tab, JComponent comp) {
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tab.getSelectedIndex() == 0) 
					frame.getChangeStudentDialog().setVisible(true);
				
			}
			
		};
		
		if(comp instanceof JButton)
			((JButton)comp).addActionListener(listener);
		else if(comp instanceof JMenuItem) 
			((JMenuItem)comp).addActionListener(listener);
	}	
}
