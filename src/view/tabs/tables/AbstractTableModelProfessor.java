package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;

import bundle.LanguageSupport;
import model.DatabaseReader;

public class AbstractTableModelProfessor extends AbstractTableModel {
	private ArrayList<String> columnNames;
	public AbstractTableModelProfessor() {
		columnNames = new ArrayList<String>();

		
	}
	@Override
	public int getRowCount() {
		return DatabaseReader.getInstance().getProfessors().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getProfessors().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return getColumnString(column);
	}
	
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("professorTableName");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("professorTableSurname");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("professorTableTitle");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("professorTableEmail");
		default: return "";
		}
	}

}
