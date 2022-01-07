package view.tabs;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import view.tabs.tabPanels.SubjectsNotPassedStudent;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;
import RowFilters.RowFilterStudent;
import model.DatabaseReader;
import view.MainFrame;
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
	private MainFrame frame;
	
	public MainTab(MainFrame mainFrame) {
		super();
		frame = mainFrame;


		studentTable = new StudentTable(frame);
		add("Studenti", new JScrollPane(studentTable));
		professorTable = new ProfessorTable(frame);
		add("Profesori", new JScrollPane(professorTable));
		subjectTable = new SubjectTable(frame);
		add("Predmeti", new JScrollPane(subjectTable));
		
	}

	
	public String getIndexOfSelectedStudent() {
		int row = studentTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati student iz tabele pre izmene!");
			return null;
		}
		String index = (String) studentTable.getValueAt(row, 0);
		return index;
	}
	

	

	public String getIdOfSelectedSubject() {
		AbstractTableModelSubject model = (AbstractTableModelSubject) subjectTable.getModel();
		int row = subjectTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati predmet iz tabele pre izmene!");
			return null;
		}
		String index = (String) model.getValueAt(row, 0);
		return index;
	}

	public String getIdOfSelectedProfessor() {
		AbstractTableModelProfessor model = (AbstractTableModelProfessor) professorTable.getModel();
		int row = professorTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null, "Mora se selektovati profesor iz tabele pre izmene!");
			return null;
		}
		String id = (String) model.getValueAt(row, 4);;
		return id;

	}

	public int getSelectedRowInStudentTable() {
		return studentTable.getSelectedRow();
	}

	public int getSelectedRowInSubjectTable() {
		return subjectTable.getSelectedRow();
	}

	public int getSelectedRowInProfessorTable() {
		return professorTable.getSelectedRow();
	}

	public StudentTable getStudentTable() {
		return studentTable;
	}

	public SubjectTable getSubjectTable() {
		return subjectTable;
	}

	public ProfessorTable getProfessorTable() {
		return professorTable;
	}
}
