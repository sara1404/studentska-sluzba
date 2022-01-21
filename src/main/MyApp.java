package main;
import model.DatabaseReader;
import model.DatabaseWriter;
import view.MainFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyApp {

	public static void main(String[] args) {
		
		MainFrame mf = MainFrame.getInstance();
		mf.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				DatabaseReader.getInstance().initiateWritingToFiles();
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
	}
	}
