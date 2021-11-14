package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfessor extends JDialog{
	
	public AddProfessor(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Dodavanje profesora");
		getContentPane().setBackground(Color.GRAY);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height *3/4);
		setLocationRelativeTo(null);
		
		//setIconImage(null);
		
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
	    
		Dimension d = new Dimension(150,20);
		
		 //surname
        JPanel panSurname = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSurname = new JLabel("Prezime*");
        lblSurname.setPreferredSize(d);
        JTextField txtSurname = new JTextField();
        txtSurname.setPreferredSize(d);
        panSurname.add(lblSurname);
        panSurname.add(txtSurname);
        panCenter.add(panSurname);
        
		//name
		JPanel panName = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblName = new JLabel("Ime*");
        lblName.setPreferredSize(d);
        JTextField txtName = new JTextField();
        txtName.setPreferredSize(d);
        panName.add(lblName);
        panName.add(txtName);
        panCenter.add(panName);
        
        //date of birth
      	JPanel panDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDate = new JLabel("Datum rođenja*");
        lblDate.setPreferredSize(d);
        JTextField txtDate = new JTextField();
        txtDate.setPreferredSize(d);
        panDate.add(lblDate);
        panDate.add(txtDate);
        panCenter.add(panDate);
        
        //home adress
        JPanel panHome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblHome = new JLabel("Adresa stanovanja*");
        lblHome.setPreferredSize(d);
        JTextField txtHome = new JTextField();
        txtHome.setPreferredSize(d);
        panHome.add(lblHome);
        panHome.add(txtHome);
        panCenter.add(panHome);
        
        //phone
        JPanel panPhone = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPhone = new JLabel("Kontakt telefon*");
        lblPhone.setPreferredSize(d);
        JTextField txtPhone = new JTextField();
        txtPhone.setPreferredSize(d);
        panPhone.add(lblPhone);
        panPhone.add(txtPhone);
        panCenter.add(panPhone);
        
        //email
        JPanel panEmail= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblEmail = new JLabel("E-mail adresa*");
        lblEmail.setPreferredSize(d);
        JTextField txtEmail = new JTextField();
        txtEmail.setPreferredSize(d);
        panEmail.add(lblEmail);
        panEmail.add(txtEmail);
        panCenter.add(panEmail);
        
        //office adress
        JPanel panOffice= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblOffice = new JLabel("Adresa kancelarije*");
        lblOffice.setPreferredSize(d);
        JTextField txtOffice = new JTextField();
        txtOffice.setPreferredSize(d);
        panOffice.add(lblOffice);
        panOffice.add(txtOffice);
        panCenter.add(panOffice);
        
        //id
        JPanel panId= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblId = new JLabel("Broj lične karte*");
        lblId.setPreferredSize(d);
        JTextField txtId = new JTextField();
        txtId.setPreferredSize(d);
        panId.add(lblId);
        panId.add(txtId);
        panCenter.add(panId);
        
        //title
        JPanel panTitle= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitle = new JLabel("Zvanje*");
        lblTitle.setPreferredSize(d);
        JTextField txtTitle = new JTextField();
        txtTitle.setPreferredSize(d);
        panTitle.add(lblTitle);
        panTitle.add(txtTitle);
        panCenter.add(panTitle);
        
        //years od service
        JPanel panService= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblService = new JLabel("Godine staža*");
        lblService.setPreferredSize(d);
        JTextField txtService = new JTextField();
        txtService.setPreferredSize(d);
        panService.add(lblService);
        panService.add(txtService);
        panCenter.add(panService);
        
        //list of subjects
      
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
       
 
        JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(100,25));
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.setPreferredSize(new Dimension(100,25));
		
		panBottom.add(Box.createHorizontalStrut(70));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(50));
		

		add(panBottom,BorderLayout.SOUTH);
        pack();
		setVisible(true); 
		
	}

	
}
