package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;
import model.DatabaseReader;

public class AbstractTableModelStudent extends AbstractTableModel {
	private ArrayList<String> columnNames;
	public AbstractTableModelStudent() {
		columnNames = new ArrayList<String>();
	}

	// broj redova
	@Override
	public int getRowCount() {
		return DatabaseReader.getInstance().getStudents().size();
	
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return 6;
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
//		return columnNames.get(column);
		return getColumnString(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getStudents().get(rowIndex).getValueAt(columnIndex);

	}
	
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("studentTableIndex");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("studentTableName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("studentTableSurname");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("studentTableCurrentYear");
		case 4:return LanguageSupport.getInstance().getResourceBundle().getString("studentTableStatus");
		case 5: return LanguageSupport.getInstance().getResourceBundle().getString("studentTableAverageGrade");
		default: return "";
		}
	}
}
