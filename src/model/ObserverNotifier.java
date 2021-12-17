package model;

import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsNotPassed;
import view.tabs.tabPanels.tabels.AbstractTableModelSubjectsPassed;
import view.tabs.tabPanels.tabels.SubjectsNotPassedTable;
import view.tabs.tabPanels.tabels.SubjectsPassedTable;
import view.tabs.tables.AbstractTableModelProfessor;
import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.AbstractTableModelSubject;
import view.tabs.tables.ProfessorTable;
import view.tabs.tables.StudentTable;
import view.tabs.tables.SubjectTable;

public class ObserverNotifier {
	
	private StudentTable studentTable;
	private SubjectTable subjectTable;
	private ProfessorTable professorTable;
	
	private SubjectsPassedTable subjectsPassedTable;
	private SubjectsNotPassedTable subjectsNotPassedTable;
	
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

	public void setSubjectsPassedTable(SubjectsPassedTable table) {
		subjectsPassedTable = table;
	}
	
	public void setSubjectsNotPassedTable(SubjectsNotPassedTable table) {
		subjectsNotPassedTable = table;
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
		AbstractTableModelSubject model = (AbstractTableModelSubject) subjectTable.getModel();
		model.fireTableDataChanged();
	}
	
	public void subjectsPassedDataChanged() {
		AbstractTableModelSubjectsPassed model = (AbstractTableModelSubjectsPassed) subjectsPassedTable.getModel();
		model.fireTableDataChanged();
	}
	
	public void subjectsNotPassedDataChanged() {
		AbstractTableModelSubjectsNotPassed model = (AbstractTableModelSubjectsNotPassed) subjectsNotPassedTable.getModel();
		model.fireTableDataChanged();
	}
}
