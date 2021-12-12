package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.AddStudentController;
import controller.ChangeStudentController;
import view.dialogs.AddStudentDialog;
import view.dialogs.ChangeStudentDialog;

public class StudentListener {
	
	public static ActionListener studentAddingListener(JButton clickedButton) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window = SwingUtilities.getWindowAncestor(clickedButton);
				
				if(window instanceof AddStudentDialog) {
					AddStudentDialog studentDialog = (AddStudentDialog) window;
					AddStudentController addStudentController = AddStudentController.getInstance();
					addStudentController.addStudent(studentDialog);
				}

			}
			
		};	
	}

}
