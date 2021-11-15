package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AddProfessorDialog extends JDialog implements ActionListener{
	
	JPanel panCenter = new JPanel();
	BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	
	private void setPanel(JPanel pan) {
		pan.setBackground(Color.DARK_GRAY);
		pan.add(Box.createHorizontalStrut(200));
       
	}
	

	public AddProfessorDialog(){
		
		setModalityType(DEFAULT_MODALITY_TYPE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		setTitle("Dodavanje profesora");
		
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 3/8, height *3/4);
		setLocationRelativeTo(null);
		
		//setIconImage(null);
		
		
		panCenter.setLayout(boxCenter);
		panCenter.setBackground(Color.DARK_GRAY);
		
		 //surname
        
		JPanel panSurname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setPanel(panSurname);
		panSurname.add(WindowComponentBuilder.createLabel("Prezime*"));
        panSurname.add(WindowComponentBuilder.createTextField());
        panCenter.add(panSurname);
        
		//name
		JPanel panName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setPanel(panName);
		panName.add(WindowComponentBuilder.createLabel("Ime*"));
        panName.add(WindowComponentBuilder.createTextField());
        panCenter.add(panName);
        
        //date of birth
      	JPanel panDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
      	setPanel(panDate);
      	panDate.add(WindowComponentBuilder.createLabel("Datum rodjenja*"));
        panDate.add(WindowComponentBuilder.createTextField());
        panCenter.add(panDate);
        
       //home adress
        JPanel panHome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panHome);
        panHome.add(WindowComponentBuilder.createLabel("Adresa stanovanja*"));
        panHome.add(WindowComponentBuilder.createTextField());
        panCenter.add(panHome);
        
        //phone
        JPanel panPhone = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panPhone);
        panPhone.add(WindowComponentBuilder.createLabel("Kontakt telefon*"));
        panPhone.add(WindowComponentBuilder.createTextField());
        panCenter.add(panPhone);
        
        //email
        JPanel panEmail= new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panEmail);
        panEmail.add(WindowComponentBuilder.createLabel("E-mail*"));
        panEmail.add(WindowComponentBuilder.createTextField());
        panCenter.add(panEmail);
        
        //office adress
        JPanel panOffice= new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panOffice);
        panOffice.add(WindowComponentBuilder.createLabel("Adresa kancelarije*"));
        panOffice.add(WindowComponentBuilder.createTextField());
        panCenter.add(panOffice);
        
        //id
        JPanel panId= new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panId);
        panId.add(WindowComponentBuilder.createLabel("Broj licne karte*"));
        panId.add(WindowComponentBuilder.createTextField());
        panCenter.add(panId);
        
        //title
        JPanel panTitle= new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panTitle);
        panTitle.add(WindowComponentBuilder.createLabel("Zvanje*"));
        panTitle.add(WindowComponentBuilder.createTextField());
        panCenter.add(panTitle);
        
        //years od service
        JPanel panService= new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panService);
        panService.add(WindowComponentBuilder.createLabel("Godine staza*"));
        panService.add(WindowComponentBuilder.createTextField());
        panCenter.add(panService);
        
        //list of subjects
        JPanel panSubjects = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setPanel(panSubjects);
        panSubjects.add(WindowComponentBuilder.createLabel("Spisak predmeta*"));
        panSubjects.add(WindowComponentBuilder.createMultipleSelectionList());
        panCenter.add(panSubjects);
        
      
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
       
 
        JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		panBottom.setBackground(Color.DARK_GRAY);
		
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(100,25));
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.setPreferredSize(new Dimension(100,25));
		btnCancel.addActionListener(this);
		
		panBottom.add(Box.createHorizontalStrut(200));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(100));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(50));
		

		add(panBottom,BorderLayout.SOUTH);
        //pack();
		setVisible(true); 
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}

	
}
