package model;

import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.ProfessorTable;
import view.tabs.tables.StudentTable;
import view.tabs.tables.SubjectTable;

public class ObserverNotifier {
	
	private StudentTable studentTable;
	private SubjectTable subjectTable;
	private ProfessorTable professorTable;
	private static ObserverNotifier instance;
	
	private ObserverNotifier() {}
	
	public static ObserverNotifier getInstance() {
		if(instance == null)
			instance = new ObserverNotifier();
		return instance;
	}
	
	
	public void setStudentTable(StudentTable table) {
		studentTable = table;
	}
	
	public void setProfessorTable(ProfessorTable table) {
		professorTable = table;
	}
	public void setSubjectTable(SubjectTable table) {
		subjectTable = table;
	}

	
	public void studentsDataChanged() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) studentTable.getModel();
		model.fireTableDataChanged();
	}
	
	public void professorDataChanged() {
		AbstractTableModelProfessor model = (AbstractTableModelProfessor) professorTable.getModel();
		model.fireTableDataChanged();
	}
	
	public void subjectDataChanged() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) subjectTable.getModel();
		model.fireTableDataChanged();
	}
	
}
