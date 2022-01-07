package model;

import view.tabs.tabPanels.tabels.*;
import view.tabs.tables.*;

public class ObserverNotifier {
	
	private StudentTable studentTable;
	private SubjectTable subjectTable;
	private ProfessorTable professorTable;
	private DepartmentTable departmentTable;
	
	private SubjectsPassedTable subjectsPassedTable;
	private SubjectsNotPassedTable subjectsNotPassedTable;

	private ProfessorTeachSubjectsTable professorTeachSubjectsTable;
	
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

	public void setProfessorTeachSubjectsTable(ProfessorTeachSubjectsTable table) {professorTeachSubjectsTable = table;}

	public void setDepartmentTable(DepartmentTable table){
		departmentTable = table;
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

	public void departmentDataChanged(){
		AbstractTableModelDepartment model = (AbstractTableModelDepartment) departmentTable.getModel();
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

	public void professorTeachSubjectsDataChanged(){
		AbstractTableModelProfessorTeachSubjects model = (AbstractTableModelProfessorTeachSubjects)  professorTeachSubjectsTable.getModel();
		model.fireTableDataChanged();
	}
}
