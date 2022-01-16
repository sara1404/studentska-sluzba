package view.tabs.tables;

import model.DatabaseReader;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;

import java.util.ArrayList;

public class AbstractTableModelDepartment extends AbstractTableModel {

    private ArrayList<String> columnNames;
    public AbstractTableModelDepartment() {}
    @Override
    public int getRowCount() {
        return DatabaseReader.getInstance().getDepartments().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return getColumnString(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DatabaseReader.getInstance().getDepartments().get(rowIndex).getValueAt(columnIndex);
    }
    
	
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("departmentCode");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("departmentName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("departmentDirector");
		default: return "";
		}
	}
}
