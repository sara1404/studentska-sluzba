package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import RowFilters.RowFilterProfessor;
import model.ObserverNotifier;
import view.MainFrame;

public class ProfessorTable extends JTable {
	public ProfessorTable(MainFrame frame) {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelProfessor atmp = new AbstractTableModelProfessor();
		this.setModel(atmp);
		TableRowSorter<AbstractTableModelProfessor> sorter = new TableRowSorter<>(atmp);
		sorter.setRowFilter(new RowFilterProfessor(frame));
		setRowSorter(sorter);
		this.getColumnModel().getColumn(4).setMinWidth(0);
		this.getColumnModel().getColumn(4).setMaxWidth(0);
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setProfessorTable(this);
	}

}
