package view.tabs.tabPanels.tabels;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.ObserverNotifier;

public class SubjectsNotPassedTable extends JTable{
	public SubjectsNotPassedTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubjectsNotPassed());
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setSubjectsNotPassedTable(this);
	}
}
