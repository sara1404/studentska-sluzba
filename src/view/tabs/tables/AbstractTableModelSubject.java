package view.tabs.tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;
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
		return 6;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return DatabaseReader.getInstance().getSubjects().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return getColumnString(column);
	}
	
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableCode");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableYear");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableSemester");
		case 4:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableEspb");
		case 5:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableProfessor");
		default: return "";
		}
	}

}
