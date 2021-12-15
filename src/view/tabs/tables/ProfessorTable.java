package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.ObserverNotifier;

public class ProfessorTable extends JTable {
	public ProfessorTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessor());
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setProfessorTable(this);
		this.getColumnModel().getColumn(4).setMinWidth(0);
		this.getColumnModel().getColumn(4).setMaxWidth(0);
	}

}
