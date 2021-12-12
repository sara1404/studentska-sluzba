package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.DatabaseReader;

public class AbstractTableModelStudent extends AbstractTableModel {
	private ArrayList<String> columnNames;
	public AbstractTableModelStudent() {
		columnNames = new ArrayList<String>();
		columnNames.add("Broj Indeksa");
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Godina studija");
		columnNames.add("Status");
		columnNames.add("Prosecna ocena");
	}

	// broj redova
	@Override
	public int getRowCount() {
		return DatabaseReader.getInstance().getStudents().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getStudents().get(rowIndex).getValueAt(columnIndex);
	}

}
