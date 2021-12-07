package view.tabs;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.tabs.tables.ProfessorTable;
import view.tabs.tables.StudentTable;
import view.tabs.tables.SubjectTable;

public class MainTab extends JTabbedPane {

	public MainTab() {
		super();
		String[][] data = { { "ra-76-2019", "Sara", "Sinjeri", "3", "B", "9.24" } };
		String[] columnNames = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };

		StudentTable studentTable = new StudentTable(data, columnNames);
		ProfessorTable professorTable = new ProfessorTable(data, columnNames);
		SubjectTable subjectTable = new SubjectTable(data, columnNames);
		add("Studenti", new JScrollPane(studentTable));
		add("Profesori", new JScrollPane(professorTable));
		add("Predmeti", new JScrollPane(subjectTable));
	}
	

}
