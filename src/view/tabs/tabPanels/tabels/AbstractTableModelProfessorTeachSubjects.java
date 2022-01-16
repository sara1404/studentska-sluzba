package view.tabs.tabPanels.tabels;

import model.DatabaseReader;
import model.Professor;
import view.MainFrame;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;

import java.util.ArrayList;

public class AbstractTableModelProfessorTeachSubjects extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private Professor professor;

    public AbstractTableModelProfessorTeachSubjects(){
        columnNames = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
        int selectedIndex = MainFrame.getInstance().getTab().getSelectedRowInProfessorTable();
        this.professor = DatabaseReader.getInstance().getProfessors().get(selectedIndex);
        return professor.getSubjectList().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return professor.getSubjectList().get(rowIndex).getValueAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return getColumnString(column);
    }
    
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("subProfTableCode");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("subProfTableName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("subProfTableYear");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("subProfTableSemester");
		default: return "";
		}
	}
}
