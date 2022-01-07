package view.tabs.tables;

import model.DatabaseReader;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AbstractTableModelDepartment extends AbstractTableModel {

    private ArrayList<String> columnNames;
    public AbstractTableModelDepartment() {
        columnNames = new ArrayList<String>();
        columnNames.add("Sifra katedre");
        columnNames.add("Naziv katedre");
        columnNames.add("Sef katedre");
    }
    @Override
    public int getRowCount() {
        return DatabaseReader.getInstance().getDepartments().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DatabaseReader.getInstance().getDepartments().get(rowIndex).getValueAt(columnIndex);
    }
}
