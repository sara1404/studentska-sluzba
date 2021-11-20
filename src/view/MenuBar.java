package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MenuBar extends JMenuBar{
	
	JMenuItem student;
	JMenuItem professor;
	JMenuItem department;
	JMenuItem subject;
	JMenuItem fNew;
	JMenuItem close;
	JMenuItem open;
	JMenuItem save;
	JMenuItem eEdit;
	JMenuItem delete;
	JMenuItem hHelp;
	JMenuItem about;
	
	
	public MenuBar() {
		
		 
		//File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		fNew = new JMenuItem("New", KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		save = new JMenuItem("Save", KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_O);
		student = new JMenuItem("Students", KeyEvent.VK_T);
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		professor = new JMenuItem("Professors", KeyEvent.VK_P);
		professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		department = new JMenuItem("Departments", KeyEvent.VK_R);
		department.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		subject = new JMenuItem("Subjects", KeyEvent.VK_B);
		subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		open.add(student);
		Utils.setCursor(student);
		open.add(subject);
		Utils.setCursor(subject);
		open.add(professor);
		Utils.setCursor(professor);
		open.add(department);
		Utils.setCursor(department);
		close = new JMenuItem("Close", KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		
		file.add(fNew);
		Utils.setCursor(fNew);
		file.addSeparator();
		file.add(save);
		Utils.setCursor(save);
		file.addSeparator();
		file.add(open);
		Utils.setCursor(open);
		file.addSeparator();
		file.add(close);
		Utils.setCursor(close);
		
		add(file);
		
		//Edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		eEdit = new JMenuItem("Edit", KeyEvent.VK_I);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		delete = new JMenuItem("Delete", KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
		
		edit.add(eEdit);
		Utils.setCursor(eEdit);
		edit.addSeparator();
		edit.add(delete);
		Utils.setCursor(delete);
		
		add(edit);
		
		//Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		hHelp = new JMenuItem("Help", KeyEvent.VK_L);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		about = new JMenuItem("About", KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(hHelp);
		Utils.setCursor(hHelp);
		help.addSeparator();
		help.add(about);
		Utils.setCursor(about);
		
		add(help);
		
		//setting icons
		fNew.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/new.png")));
		save.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/save.png")));
		open.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/open.png")));
		close.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/close.png")));
		eEdit.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/edit.png")));
		delete.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/del.png")));
		hHelp.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/help.png")));
		about.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/about.png")));
		student.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/student.png")));
		professor.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/professor.png")));
		subject.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/subject.png")));
		department.setIcon(new ImageIcon(getClass().getResource("/menubar_imgs/department.png")));
		
		
		
	}


	public JMenuItem getStudent() {
		return student;
	}


	public JMenuItem getProfessor() {
		return professor;
	}


	public JMenuItem getDepartment() {
		return department;
	}


	public JMenuItem getSubject() {
		return subject;
	}


	public JMenuItem getfNew() {
		return fNew;
	}


	public JMenuItem getClose() {
		return close;
	}


	public JMenuItem getOpen() {
		return open;
	}


	public JMenuItem getSave() {
		return save;
	}


	public JMenuItem geteEdit() {
		return eEdit;
	}


	public JMenuItem getDelete() {
		return delete;
	}


	public JMenuItem gethHelp() {
		return hHelp;
	}


	public JMenuItem getAbout() {
		return about;
	}

	

}
