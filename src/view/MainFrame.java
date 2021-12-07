package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import controller.ListenerController;
import view.dialogs.AddProfessorDialog;
import view.dialogs.AddStudentDialog;
import view.dialogs.AddSubjectDialog;
import view.dialogs.ChangeStudentWindow;
import view.dialogs.ChangeSubjectDialog;
import view.menuBar.MenuBar;
import view.statusBar.StatusBar;
import view.tabs.MainTab;
import view.tabs.tables.StudentTable;
import view.toolbar.ToolBar;

public class MainFrame extends JFrame {

	AddStudentDialog addStudentDialog = new AddStudentDialog();
	AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
	AddSubjectDialog addSubjectDialog = new AddSubjectDialog();

	ChangeStudentWindow changeStudentDialog = new ChangeStudentWindow();
	ChangeSubjectDialog changeSubjectDialog = new ChangeSubjectDialog();
	
	
	MenuBar menu = new MenuBar();

	public MainFrame() {

		Toolkit kit = Toolkit.getDefaultToolkit();

		setTitle("Studentska služba");
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3 / 4, height * 3 / 4);
		setLocationRelativeTo(null);

		Image img = kit.getImage("src/main_icon/icon.jpg");
		setIconImage(img);

		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);

		ToolBar tb = new ToolBar();
		getContentPane().add(tb, BorderLayout.NORTH);

		StatusBar status = new StatusBar();
		status.setPreferredSize(new Dimension(this.getWidth(), 30));
		add(status, BorderLayout.SOUTH);

//		JTabbedPane tab = new JTabbedPane();
//		String[][] data = {
//	            { "ra-76-2019", "Sara", "Sinjeri", "3", "B", "9.24" }
//	        };
//		String[] columnNames = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
//		//JTable studentTable = new JTable(data, columnNames);
//		StudentTable studentTable = new StudentTable(data, columnNames);
		
		
//		tab.addTab("Studenti", new JScrollPane(studentTable));
//		tab.addTab("Profesori", professorPanel);
	//	tab.addTab("Predmeti", subjectPanel);
		MainTab tab = new MainTab();
		add(tab);
		
		ListenerController.tabListener(tab, status);


		add(tab);
		ListenerController.tabListener(tab, status);
		//toolbar listener
		ListenerController.setDisplayAddDialogAction(this, tab, tb.getCreateEntityBtn());
		ListenerController.setDisplayChangeDialogAction(this, tab, tb.getChangeEntityBtn());
		ListenerController.setDisplayDeleteDialogAction(this, tab, tb.getRemoveEntityBtn());
		
		//menubar listener
		ListenerController.setDisplayAddDialogAction(this, tab, menu.getfNew());
		ListenerController.setDisplayChangeDialogAction(this, tab, menu.geteEdit());
		ListenerController.setDisplayDeleteDialogAction(this, tab, menu.getDelete());
		
		setVisible(true);

	}

	public AddStudentDialog getAddStudentDialog() {
		return addStudentDialog;
	}

	public AddProfessorDialog getAddProfessorDialog() {
		return addProfessorDialog;
	}

	public AddSubjectDialog getAddSubjectDialog() {
		return addSubjectDialog;
	}

	public ChangeStudentWindow getChangeStudentDialog() {
		return changeStudentDialog;
	}

	public ChangeSubjectDialog getChangeSubjectDialog() {
		return changeSubjectDialog;
	}
	
}
