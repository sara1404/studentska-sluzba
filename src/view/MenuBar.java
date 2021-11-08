package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MenuBar extends JMenuBar{
	

	public MenuBar() {
		
		 
		//File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem fNew = new JMenuItem("New", KeyEvent.VK_N);
		fNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenu open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_O);
		JMenuItem student = new JMenuItem("Studenti", KeyEvent.VK_T);
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		JMenuItem profesor = new JMenuItem("Profesori", KeyEvent.VK_P);
		profesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		JMenuItem katedra = new JMenuItem("Katedre", KeyEvent.VK_K);
		katedra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.ALT_MASK));
		JMenuItem predmet = new JMenuItem("Predmeti", KeyEvent.VK_R);
		predmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		open.add(student);
		open.add(predmet);
		open.add(profesor);
		open.add(katedra);
		JMenuItem close = new JMenuItem("Close", KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	
		
		
		file.add(fNew);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(close);
		
		add(file);
		
		//Edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem eEdit = new JMenuItem("Edit", KeyEvent.VK_I);
		eEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem delete = new JMenuItem("Delete", KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
		
		edit.add(eEdit);
		edit.addSeparator();
		edit.add(delete);
		
		add(edit);
		
		//Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem hHelp = new JMenuItem("Help", KeyEvent.VK_L);
		hHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(hHelp);
		help.addSeparator();
		help.add(about);
		
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
		
		
	}

	
}
