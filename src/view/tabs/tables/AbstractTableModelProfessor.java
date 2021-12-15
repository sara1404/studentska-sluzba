package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;

import model.DatabaseReader;

public class AbstractTableModelProfessor extends AbstractTableModel {
	private ArrayList<String> columnNames;
	public AbstractTableModelProfessor() {
		columnNames = new ArrayList<String>();
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Zvanje");
		columnNames.add("E-mail adresa");
		columnNames.add("hidden");
		
	}
	@Override
	public int getRowCount() {
		return DatabaseReader.getInstance().getProfessors().size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getProfessors().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

}
