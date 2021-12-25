package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.AddProfessorController;
import controller.ListenerController;
import view.dialogs.AddProfessorDialog;

public class ProfessorListener {

	public static ActionListener  addingProfessorListener(JButton btn) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.getWindowAncestor(btn);
				
				
				if(window instanceof AddProfessorDialog) {
					AddProfessorDialog pd = (AddProfessorDialog) window;
					AddProfessorController apc = AddProfessorController.getInstance();
					apc.addProfessor(pd);
					pd.dispose();
				}
			}
		};
	}
}
