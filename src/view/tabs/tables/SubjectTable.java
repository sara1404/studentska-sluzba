package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.ObserverNotifier;

public class SubjectTable extends JTable {
	
	public SubjectTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubject());
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setSubjectTable(this);
		
	}
}
