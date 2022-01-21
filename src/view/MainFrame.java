package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import bundle.LanguageSupport;
import controller.ListenerController;
import model.DatabaseWriter;
import model.Student;
import view.dialogs.*;
import view.menuBar.MenuBar;
import view.statusBar.StatusBar;
import view.tabs.MainTab;
import view.tabs.tables.StudentTable;
import view.toolbar.ToolBar;

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	private ToolBar tb;
	AddStudentDialog addStudentDialog = new AddStudentDialog();
	AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
	AddSubjectDialog addSubjectDialog = new AddSubjectDialog();

	ChangeStudentDialog changeStudentDialog = new ChangeStudentDialog();
	ChangeProfessorDialog changeProfessorDialog = new ChangeProfessorDialog();
	ChangeSubjectDialog changeSubjectDialog = new ChangeSubjectDialog();

	DepartmentsDialog departmentsDialog = new DepartmentsDialog();
	AboutDialog aboutDialog = new AboutDialog();
	
	MainTab tab;
	MenuBar menu = new MenuBar();
	StatusBar status = new StatusBar();
	
	private MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();

		setTitle(LanguageSupport.getInstance().getResourceBundle().getString("mainFrameTitle"));
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3 / 4, height * 3 / 4);
		setLocationRelativeTo(null);

		Image img = kit.getImage("src/main_icon/icon.jpg");
		setIconImage(img);

		this.setJMenuBar(menu);

		tb = new ToolBar();
		getContentPane().add(tb, BorderLayout.NORTH);

		status.setPreferredSize(new Dimension(this.getWidth(), 30));
		add(status, BorderLayout.SOUTH);

		tab = new MainTab(this);
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
		ListenerController.setDisplayDepartmentDialog(this, menu.getDepartment());
		ListenerController.setDisplayHelpDialogAction(this, menu.gethHelp());
		ListenerController.setDisplayAboutSection(this, menu.getAbout());
		ListenerController.saveAllChanges(this, menu.getSave());
		
		//menu item listeners for tabs switch
		ListenerController.switchTabsfromMenu(this, tab, menu.getStudent(), 0);
		ListenerController.switchTabsfromMenu(this, tab, menu.getProfessor(), 1);
		ListenerController.switchTabsfromMenu(this, tab, menu.getSubject(), 2);
		
		setVisible(true);

		UIManager.put("OptionPane.yesButtonText", LanguageSupport.getInstance().getResourceBundle().getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText",  LanguageSupport.getInstance().getResourceBundle().getObject("noOption"));
		UIManager.put("OptionPane.okButtonText",  LanguageSupport.getInstance().getResourceBundle().getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText",  LanguageSupport.getInstance().getResourceBundle().getObject("cancelOption"));
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

	public DepartmentsDialog getDepartmentsDialog() { return departmentsDialog; }

	

	public AboutDialog getAboutDialog() {
		return aboutDialog;
	}

	public void setNewAddStudentDialog() {
		addStudentDialog = new AddStudentDialog();
		addStudentDialog.setVisible(true);
	}
	
	public void setNewHelpDialog() {
		HelpDialog helpDialog = new HelpDialog();
		helpDialog.setVisible(true);
	}
	
	public void setNewAddProfessorDialog() {
		addProfessorDialog = new AddProfessorDialog();
		addProfessorDialog.setVisible(true);
	}

	public void setNewAddSubjectDialog(){
		addSubjectDialog = new AddSubjectDialog();
		addSubjectDialog.setVisible(true);
	}

	public void setNewChangeStudentDialog() {
		changeStudentDialog = new ChangeStudentDialog();
	}

	public void setNewChangeProfessorDialog() {
		changeProfessorDialog = new ChangeProfessorDialog();
	}

	public void setNewChangeSubjectDialog() { changeSubjectDialog = new ChangeSubjectDialog(); }

	public void setNewAddDepartmentDirectorDialog(){
		departmentsDialog = new DepartmentsDialog();
	}
	

	public void setAboutSection() {
		aboutDialog = new AboutDialog();
		
	}

	public ToolBar getToolbar() { return tb; }
	public MainTab getTab() {
		return tab;
	}
	
	public void changeLanguage() {	
		
		
		ResourceBundle resourceBundle = LanguageSupport.getInstance().getResourceBundle();
		
		setTitle(resourceBundle.getString("mainFrameTitle"));
		menu.initComponents();
		status.initComponents();
		tab.initComponents();
		tb.initComponents();
		addStudentDialog.initComponents();
		changeStudentDialog.initComponents();
		addProfessorDialog.initComponents();
		changeProfessorDialog.initComponents();
		changeProfessorDialog.getInformationPanel().initComponents();
		changeStudentDialog.getInformationPanel().initComponents();
		addSubjectDialog.initComponents();
		departmentsDialog.initComponenets();
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}


	
}
