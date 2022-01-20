package view.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import controller.GradeEntryController;
import model.ObserverNotifier;
import view.MainFrame;
import view.dialogs.GradeEntry;

public class GradeEntryListener {
	
	public static ActionListener  enteringGradeListener(JButton btn) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.getWindowAncestor(btn);
				
				
				if(window instanceof GradeEntry) {
					GradeEntry ge = (GradeEntry) window;
					GradeEntryController gec = GradeEntryController.getInstance();
					gec.gradeEntry(ge);
					
					ge.dispose();
				}
			}
		};
	}

}
