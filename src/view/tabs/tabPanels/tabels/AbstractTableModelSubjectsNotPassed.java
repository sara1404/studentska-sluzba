package view.tabs.tabPanels.tabels;

import javax.swing.table.AbstractTableModel;

import bundle.LanguageSupport;
import model.DatabaseReader;
import model.Student;
import view.MainFrame;

public class AbstractTableModelSubjectsNotPassed extends AbstractTableModel{
	private Student student;
	public AbstractTableModelSubjectsNotPassed() {}
	@Override
	public int getRowCount() {
		int selectedIndex = MainFrame.getInstance().getTab().getStudentTable().getSelectedRow();
		this.student = DatabaseReader.getInstance().getStudents().get(selectedIndex);
		return student.getFailedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selectedIndex = MainFrame.getInstance().getTab().getSelectedRowInStudentTable();
		this.student = DatabaseReader.getInstance().getStudents().get(selectedIndex);
		return student.getFailedExams().get(rowIndex).getValueAtFailed(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return getColumnString(column);
	}
	
	public String getColumnString(int colIndex) {
		switch(colIndex) {
		case 0:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableCode");
		case 1:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableName");
		case 2:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableYear");
		case 3:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableEspb");
		case 4:return LanguageSupport.getInstance().getResourceBundle().getString("subjectTableSemester");
		default: return "";
		}
	}

}

