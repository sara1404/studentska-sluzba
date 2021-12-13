package view.tabs;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.tabs.tables.AbstractTableModelStudent;
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
		add("Predmeti", new JScrollPane(professorTable));
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

	public int getSelectedRowInStudentTable() {
		return studentTable.getSelectedRow();
	}
}
