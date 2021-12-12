package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.ObserverNotifier;




public class StudentTable extends JTable {
	
	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setStudentTable(this);
	}

}
