package view.tabs.tabPanels.tabels;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.ObserverNotifier;

public class SubjectsPassedTable extends JTable {
	public SubjectsPassedTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjectsPassed());
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setSubjectsPassedTable(this);
	}
}
