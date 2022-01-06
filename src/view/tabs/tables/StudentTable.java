package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import RowFilters.RowFilterStudent;
import model.ObserverNotifier;
import view.MainFrame;


public class StudentTable extends JTable {
	
	public StudentTable(MainFrame frame) {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelStudent atms = new AbstractTableModelStudent();
		this.setModel(atms);
		TableRowSorter<AbstractTableModelStudent> sorter = new TableRowSorter<>(atms);
		sorter.setRowFilter(new RowFilterStudent(frame));
		setRowSorter(sorter);

		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setStudentTable(this);
	}

}
