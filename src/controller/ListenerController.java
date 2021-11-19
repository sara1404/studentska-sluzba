package controller;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
}
