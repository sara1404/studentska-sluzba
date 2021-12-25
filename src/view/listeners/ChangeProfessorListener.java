package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.ChangeProfessorController;
import view.dialogs.ChangeProfessorDialog;


public class ChangeProfessorListener {
	public static ActionListener changingProfessorListener(JButton btn) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window = SwingUtilities.getWindowAncestor(btn);
				
				if(window instanceof ChangeProfessorDialog) {

					ChangeProfessorDialog professorDialog = (ChangeProfessorDialog) window;
					ChangeProfessorController changeProfessorController = ChangeProfessorController.getInstance();
					changeProfessorController.changeProfessor(professorDialog);
					professorDialog.dispose();
				}
			}
			
		};	
	}
}
