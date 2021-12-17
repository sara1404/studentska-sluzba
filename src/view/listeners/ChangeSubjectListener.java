package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.ChangeSubjectController;
import view.dialogs.ChangeSubjectDialog;

public class ChangeSubjectListener {
	public static ActionListener subjectChangingListener(JButton clickedButton) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window = SwingUtilities.getWindowAncestor(clickedButton);
				
				if(window instanceof ChangeSubjectDialog) {

					ChangeSubjectDialog subjectDialog = (ChangeSubjectDialog) window;
					ChangeSubjectController changeSubjectController = ChangeSubjectController.getInstance();
					changeSubjectController.changeSubject(subjectDialog);

				}
			}
			
		};	
	}
}
