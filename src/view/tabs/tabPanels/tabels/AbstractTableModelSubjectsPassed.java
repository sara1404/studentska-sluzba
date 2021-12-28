package view.tabs.tabPanels.tabels;

import model.DatabaseReader;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelSubjectsPassed extends AbstractTableModel{


	private ArrayList<String> columnNames;
	public AbstractTableModelSubjectsPassed() {
		columnNames = new ArrayList<String>();
		
		
		columnNames.add("Sifra predmeta");
		columnNames.add("Naziv predmeta");
		columnNames.add("ESPB");
		columnNames.add("Ocena");
		columnNames.add("Datum");
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return DatabaseReader.getInstance().getSubjectsPassedForStudent().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getSubjectsPassedForStudent().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
}
