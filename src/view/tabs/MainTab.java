package view.tabs;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.AbstractTableModelSubject;
import view.tabs.tables.ProfessorTable;
import view.tabs.tables.StudentTable;
import view.tabs.tables.SubjectTable;

public class MainTab extends JTabbedPane {
	private StudentTable studentTable;
	private SubjectTable subjectTable;
	private ProfessorTable professorTable;
	
	public MainTab() {
		super();

		studentTable = new StudentTable();
		add("Studenti", new JScrollPane(studentTable));
		professorTable = new ProfessorTable();
		add("Profesori", new JScrollPane(professorTable));
		subjectTable = new SubjectTable();
		add("Predmeti", new JScrollPane(subjectTable));
		
	}
	
	public String getIndexOfSelectedStudent() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) studentTable.getModel();
		int row = studentTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati student iz tabele pre izmene!");
			return null;
		}
		String index = (String) model.getValueAt(row, 0);
		return index;
	}
	
<<<<<<< HEAD
	public String getIdOfSelectedSubject() {
		AbstractTableModelSubject model = (AbstractTableModelSubject) subjectTable.getModel();
		int row = subjectTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati predmet iz tabele pre izmene!");
			return null;
		}
		String index = (String) model.getValueAt(row, 0);
		return index;
=======
	public String getIdOfSelectedProfessor() {
		AbstractTableModelProfessor model = (AbstractTableModelProfessor) professorTable.getModel();
		int row = professorTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati profesor iz tabele pre izmene!");
			return null;
		}
		String id = (String) model.getValueAt(row, 4);;
		return id;
		
>>>>>>> 56f9a0458cee9d246fbe416eb4ef4928b0f88c48
	}

	public int getSelectedRowInStudentTable() {
		return studentTable.getSelectedRow();
	}
	
<<<<<<< HEAD
	public int getSelectedRowInSubjectTable() {
		return subjectTable.getSelectedRow();
=======
	public int getSelectedRowInProfessorTable() {
		return professorTable.getSelectedRow();
>>>>>>> 56f9a0458cee9d246fbe416eb4ef4928b0f88c48
	}
}
