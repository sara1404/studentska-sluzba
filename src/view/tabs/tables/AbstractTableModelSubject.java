package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.DatabaseReader;

public class AbstractTableModelSubject extends AbstractTableModel {
	private ArrayList<String> columnNames;
	public AbstractTableModelSubject() {
		columnNames = new ArrayList<String>();
		columnNames.add("Sifra");
		columnNames.add("Naziv");
		columnNames.add("Godina");
		columnNames.add("Semestar");
		columnNames.add("ESPB");
		columnNames.add("Profesor");
	}
	@Override
	public int getRowCount() {
		return DatabaseReader.getInstance().getSubjects().size();
	}
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getSubjects().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
}
