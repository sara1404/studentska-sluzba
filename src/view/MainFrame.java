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
import view.dialogs.ChangeProfessorDialog;
import view.dialogs.ChangeStudentDialog;
import view.dialogs.ChangeSubjectDialog;
import view.menuBar.MenuBar;
import view.statusBar.StatusBar;
import view.tabs.MainTab;
import view.tabs.tables.StudentTable;
import view.toolbar.ToolBar;

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;

	AddStudentDialog addStudentDialog = new AddStudentDialog();
	AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
	AddSubjectDialog addSubjectDialog = new AddSubjectDialog();

	ChangeStudentDialog changeStudentDialog = new ChangeStudentDialog();
	ChangeProfessorDialog changeProfessorDialog = new ChangeProfessorDialog();
	ChangeSubjectDialog changeSubjectDialog = new ChangeSubjectDialog();
	
	MainTab tab;
	MenuBar menu = new MenuBar();

	private MainFrame() {
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

		tab = new MainTab();
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
		
		//menu item listeners for tabs switch
		ListenerController.switchTabsfromMenu(this, tab, menu.getStudent(), 0);
		ListenerController.switchTabsfromMenu(this, tab, menu.getProfessor(), 1);
		ListenerController.switchTabsfromMenu(this, tab, menu.getSubject(), 2);
		
		setVisible(true);

	}
	
	public static MainFrame getInstance() {
		if(instance == null)
			instance = new MainFrame();
		return instance;
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

	public ChangeStudentDialog getChangeStudentDialog() {
		return changeStudentDialog;
	}
	
	public ChangeProfessorDialog getChangeProfessorDialog() {
		return changeProfessorDialog;
	}

	public ChangeSubjectDialog getChangeSubjectDialog() {
		return changeSubjectDialog;
	}

	public void setNewAddStudentDialog() {
		addStudentDialog = new AddStudentDialog();
		addStudentDialog.setVisible(true);
	}
	
	public void setNewAddProfessorDialog() {
		addProfessorDialog = new AddProfessorDialog();
		addProfessorDialog.setVisible(true);
	}

	public void setNewChangeStudentDialog() {
		changeStudentDialog = new ChangeStudentDialog();
	}

	public void setNewChangeProfessorDialog() {
		changeProfessorDialog = new ChangeProfessorDialog();
	}

	public MainTab getTab() {
		return tab;
	}
	
	
}
