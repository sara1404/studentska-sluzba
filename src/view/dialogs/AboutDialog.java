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

public class AboutDialog extends JDialog{
	JPanel panCenter = new JPanel();
	BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	
	public AboutDialog(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension dim = kit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width * 1/2, height * 3/4);
        setLocationRelativeTo(null);
        setTitle("O nama");
        panCenter.setLayout(boxCenter);
		panCenter.setBackground(Color.DARK_GRAY);
		
        
        File text = new File("src/database_resource/about.txt");
        Scanner scanner;
		try {
			
			scanner = new Scanner(text);
			
			while(scanner.hasNextLine()){
				JPanel pan = new JPanel();
				pan.setBackground(Color.DARK_GRAY);
				String about = scanner.nextLine();
				JLabel label = new JLabel();
				label.setForeground(Color.WHITE);
				label.setText(about);
				
				pan.add(label);
				
				panCenter.add(pan);
				
			}
		    add(panCenter,BorderLayout.CENTER);
		    
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	
	}

}
