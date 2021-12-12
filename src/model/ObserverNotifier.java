package model;

import view.tabs.tables.AbstractTableModelStudent;
import view.tabs.tables.StudentTable;

public class ObserverNotifier {
	
	private StudentTable studentTable;
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

	
	public void studentsDataChanged() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) studentTable.getModel();
		model.fireTableDataChanged();
	}
	
}
