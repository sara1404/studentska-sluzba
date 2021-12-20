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
import javax.swing.WindowConstants;

import model.CustomListModelForProfessors;

public class AssignProfessorToSubject extends JDialog {
	JList<String> professorList;
	JButton applyBtn;
	JButton cancelBtn;
	public AssignProfessorToSubject() {
		setModalityType(DEFAULT_MODALITY_TYPE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Odaberi profesora");
		BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(box);
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width * 1/4, height * 1/3);
		setLocationRelativeTo(null);
		
		
		professorList = new JList<>(new CustomListModelForProfessors());
		professorList.setPreferredSize(new Dimension(width * 1/10, height));
		professorList.setMaximumSize(new Dimension(width * 1/10, height));
		
		JButton applyBtn = new JButton();
		JButton cancelBtn = new JButton();
		applyBtn.setText("Potvrdi");
		cancelBtn.setText("Odustani");
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(professorList);
		professorList.setLayoutOrientation(JList.VERTICAL);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) professorList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(pane);
		add(createBtnPanel());
	}
	
	private JPanel createBtnPanel() {
		JPanel btnPanel = new JPanel();
		BoxLayout box = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(box);
		applyBtn = new JButton();
		cancelBtn = new JButton();
		applyBtn.setText("Potvrdi");
		cancelBtn.setText("Odustani");
		btnPanel.add(applyBtn);
		btnPanel.add(cancelBtn);
		
		return btnPanel;
	}
	
	public JList<String> getProfessorList() {
		return professorList;
	}

	public JButton getApplyBtn() {
		return applyBtn;
	}
	
	public JButton getCancelBtn() {
		return cancelBtn;
	}
}