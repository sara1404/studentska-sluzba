package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.AddSubjectController;
import controller.ChangeStudentController;
import model.DatabaseReader;
import model.Student;
import view.MainFrame;
import view.dialogs.AddSubjectDialog;
import view.dialogs.ChangeStudentDialog;

public class ChangeStudentListener {
	public static ActionListener studentChangingListener(JButton clickedButton) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window = SwingUtilities.getWindowAncestor(clickedButton);
				
				if(window instanceof ChangeStudentDialog) {

					ChangeStudentDialog studentDialog = (ChangeStudentDialog) window;
					ChangeStudentController changeStudentController = ChangeStudentController.getInstance();
					changeStudentController.changeStudent(studentDialog);

				}
			}
			
		};	
	}
}
