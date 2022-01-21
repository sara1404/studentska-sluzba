package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bundle.LanguageSupport;

public class AboutDialog extends JDialog{
	
	public AboutDialog(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1/2, height * 2/4);
        setLocationRelativeTo(null);
        setTitle(LanguageSupport.getInstance().getResourceBundle().getString("about-us"));
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
        
		JPanel pan = new JPanel();
		pan.setBackground(Color.DARK_GRAY);
		JTextArea about = new JTextArea(30, 60);
		about.setLineWrap(true);
		about.setEditable(false);
		about.setText(LanguageSupport.getInstance().getResourceBundle().getString("about-text"));
		pan.add(new JScrollPane(about));
		add(pan);
			
	}

}
