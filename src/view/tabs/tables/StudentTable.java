package view.tabs.tables;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JTable {
	
	public StudentTable(String[][] students, String[] columns) {
		super();
		DefaultTableModel tableModel = new DefaultTableModel(students, columns);
		tableModel.setColumnIdentifiers(columns);
		setModel(tableModel);
		setAutoCreateRowSorter(true);
	}

}
