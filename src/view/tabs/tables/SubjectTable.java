package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import RowFilters.RowFilterProfessor;
import model.ObserverNotifier;
import view.MainFrame;

public class SubjectTable extends JTable {
	
	public SubjectTable(MainFrame frame) {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelSubject model = new AbstractTableModelSubject();
		this.setModel(model);
		TableRowSorter<AbstractTableModelSubject> sorter = new TableRowSorter<>((AbstractTableModelSubject) model);
		setAutoCreateRowSorter(true);
		sorter.setRowFilter(new RowFilterProfessor(frame));
		sorter.setSortsOnUpdates(true);
		setRowSorter(sorter);
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setSubjectTable(this);
		
	}
}
