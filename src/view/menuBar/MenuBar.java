package view.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import bundle.LanguageSupport;
import controller.ListenerController;
import utils.Utils;
import view.MainFrame;


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
	
	JMenu file;
	JMenu edit;
	JMenu help;
	
	JMenu languages;
	JMenuItem serbian;
	JMenuItem english;
	
	public MenuBar() {
		
		 
		//File
		file = new JMenu(LanguageSupport.getInstance().getResourceBundle().getString("file"));
		file.setMnemonic(KeyEvent.VK_F);
		fNew = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("fNew"), KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		save = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("save"), KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		open = new JMenu(LanguageSupport.getInstance().getResourceBundle().getString("open"));
		open.setMnemonic(KeyEvent.VK_O);

		student = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("student"), KeyEvent.VK_T);
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		professor = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("professor"), KeyEvent.VK_P);
		professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		department = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("department"), KeyEvent.VK_R);
		department.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		subject = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("subject"), KeyEvent.VK_B);
		subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		
		open.add(student);
		Utils.setCursor(student);
		open.add(subject);
		Utils.setCursor(subject);
		open.add(professor);
		Utils.setCursor(professor);
		open.add(department);
		Utils.setCursor(department);

		close = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("close"), KeyEvent.VK_C);

		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		ListenerController.closeApplication(close);
		
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
		edit = new JMenu(LanguageSupport.getInstance().getResourceBundle().getString("edit"));
		edit.setMnemonic(KeyEvent.VK_E);
		eEdit = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("eEdit"), KeyEvent.VK_I);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		delete = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("delete"), KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
		
		edit.add(eEdit);
		Utils.setCursor(eEdit);
		edit.addSeparator();
		edit.add(delete);
		Utils.setCursor(delete);
		
		add(edit);
		
		//Help
		help = new JMenu(LanguageSupport.getInstance().getResourceBundle().getString("help"));
		hHelp = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("hHelp"), KeyEvent.VK_L);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		about = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("about"), KeyEvent.VK_A);
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

		languages = new JMenu(LanguageSupport.getInstance().getResourceBundle().getString("languages"));
		serbian = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("serbian"));
		english = new JMenuItem(LanguageSupport.getInstance().getResourceBundle().getString("english"));
		languages.add(serbian);
		languages.add(english);
		add(languages);	
		
		serbian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("sr", "RS"));
				LanguageSupport.getInstance().changeLanguage();
				MainFrame.getInstance().changeLanguage();
			}
		
		});
		
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("en", "US"));
				LanguageSupport.getInstance().changeLanguage();
				MainFrame.getInstance().changeLanguage();
			}
		
		});
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

	public void initComponents() {
		file.setText(LanguageSupport.getInstance().getResourceBundle().getString("file"));
		fNew.setText(LanguageSupport.getInstance().getResourceBundle().getString("fNew"));
		save.setText(LanguageSupport.getInstance().getResourceBundle().getString("save"));
		open.setText(LanguageSupport.getInstance().getResourceBundle().getString("open"));
		student.setText(LanguageSupport.getInstance().getResourceBundle().getString("student"));
		professor.setText(LanguageSupport.getInstance().getResourceBundle().getString("professor"));
		subject.setText(LanguageSupport.getInstance().getResourceBundle().getString("subject"));
		department.setText(LanguageSupport.getInstance().getResourceBundle().getString("department"));
		close.setText(LanguageSupport.getInstance().getResourceBundle().getString("close"));
		edit.setText(LanguageSupport.getInstance().getResourceBundle().getString("edit"));
		eEdit.setText(LanguageSupport.getInstance().getResourceBundle().getString("eEdit"));
		delete.setText(LanguageSupport.getInstance().getResourceBundle().getString("delete"));
		hHelp.setText(LanguageSupport.getInstance().getResourceBundle().getString("hHelp"));
		about.setText(LanguageSupport.getInstance().getResourceBundle().getString("about"));
		help.setText(LanguageSupport.getInstance().getResourceBundle().getString("help"));
		languages.setText(LanguageSupport.getInstance().getResourceBundle().getString("languages"));
		serbian.setText(LanguageSupport.getInstance().getResourceBundle().getString("serbian"));
		english.setText(LanguageSupport.getInstance().getResourceBundle().getString("english"));
		

//		DateFormat df = DateFormat.getDateInstance();
//		String datum = df.format(new Date());
//		statusBarMenuDescription.setText(datum);

	}
	

}
