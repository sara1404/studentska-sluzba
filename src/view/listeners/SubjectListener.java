package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.AddSubjectController;
import view.dialogs.AddSubjectDialog;

public class SubjectListener {
	public static ActionListener subjectAddingListener(JButton clickedButton) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window = SwingUtilities.getWindowAncestor(clickedButton);
				System.out.println("Opalilo 1");
				if(window instanceof AddSubjectDialog) {
					System.out.println("Opalilo 2");
					AddSubjectDialog subjectDialog = (AddSubjectDialog) window;
					AddSubjectController addSubjectController = AddSubjectController.getInstance();
					addSubjectController.addStudent(subjectDialog);
				}
			}
			
		};	
	}
}
