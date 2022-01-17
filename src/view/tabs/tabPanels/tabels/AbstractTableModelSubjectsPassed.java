package view.tabs.tabPanels.tabels;

import model.DatabaseReader;
import model.Student;
import view.MainFrame;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;

public class AbstractTableModelSubjectsPassed extends AbstractTableModel{
	private Student student;
	public AbstractTableModelSubjectsPassed() {}
	@Override
	public int getRowCount() {
		int selectedIndex = MainFrame.getInstance().getTab().getStudentTable().getSelectedRow();
		this.student = DatabaseReader.getInstance().getStudents().get(selectedIndex);
		return student.getPassedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return student.getPassedExams().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return getColumnString(column);
	}
	
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("subPassTableCode");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("subPassTableName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("subPassTableEspb");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("subPassTableGrade");
		case 4:return LanguageSupport.getInstance().getResourceBundle().getString("subPassTableDate");
		default: return "";
		}
	}
}
