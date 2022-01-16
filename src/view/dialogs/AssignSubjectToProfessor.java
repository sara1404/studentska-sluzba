package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import model.CustomListModelForSubjectListProfessor;
import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import utils.WindowComponentBuilder;
import view.MainFrame;

public class AssignSubjectToProfessor extends JDialog {
	 private JList<String> subjectList; 
	 private JButton applyBtn;
	 private JButton cancelBtn;
	 private AssignSubjectToProfessor astp = this;
	 
	 public AssignSubjectToProfessor() {
		 setModalityType(DEFAULT_MODALITY_TYPE);
	     Toolkit kit = Toolkit.getDefaultToolkit();
	     setTitle("Dodaj predmet");
	     BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
	     setLayout(box);
	     getContentPane().setBackground(Color.DARK_GRAY);
	     
	     Dimension dim = kit.getScreenSize();
	     int width = dim.width;
	     int height = dim.height;
	     setSize(width * 1/4, height * 1/3);
	     setLocationRelativeTo(null);

	     applyBtn = new JButton();
	     cancelBtn = new JButton();
	     
	     Professor professor = DatabaseReader.getInstance().getProfessors().get(MainFrame.getInstance().getTab().getSelectedRowInProfessorTable());
	     CustomListModelForSubjectListProfessor customListModelForSubjectListProfessor = new CustomListModelForSubjectListProfessor(professor);
	     subjectList = new JList<>(customListModelForSubjectListProfessor);
	     subjectList.setPreferredSize(new Dimension(width * 1/10, height));
	     subjectList.setMaximumSize(new Dimension(width * 1/10, height));
	     
	     add(WindowComponentBuilder.createLabel("Predmeti:"));
	     applyBtn.setText("Potvrdi");
	     cancelBtn.setText("Odustani");
	     JScrollPane pane = new JScrollPane();
	     pane.setViewportView(subjectList);
	     subjectList.setLayoutOrientation(JList.VERTICAL);
	     DefaultListCellRenderer renderer = (DefaultListCellRenderer) subjectList.getCellRenderer();
	     renderer.setHorizontalAlignment(SwingConstants.CENTER);
	     add(pane);
	     JPanel btnPanel = new JPanel();
	     BoxLayout bl = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
	     btnPanel.setLayout(bl);
	     applyBtn.setText("Potvrdi");
	     cancelBtn.setText("Odustani");
	     btnPanel.add(applyBtn);
	     btnPanel.add(cancelBtn);
	     add(btnPanel);
	     
	     applyBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(subjectList.getSelectedIndex() == -1) {
	                    System.out.println("nije selektovan element");
	                    astp.dispose();
	                    return;
	                }
	                professor.getSubjectList().add(customListModelForSubjectListProfessor.getSubjectElement(subjectList.getSelectedIndex()));
	                ObserverNotifier.getInstance().professorTeachSubjectsDataChanged();
	                astp.dispose();
	            }
	        });
	     
	     cancelBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                astp.dispose();
	            }
	        });
	 }
	 
}
