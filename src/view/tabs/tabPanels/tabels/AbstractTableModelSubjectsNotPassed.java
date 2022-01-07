package view.tabs.tabPanels.tabels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.DatabaseReader;
import model.Student;
import view.MainFrame;

public class AbstractTableModelSubjectsNotPassed extends AbstractTableModel{
	private ArrayList<String> columnNames;
	private Student student;
	public AbstractTableModelSubjectsNotPassed() {
		columnNames = new ArrayList<String>();

		columnNames.add("Sifra predmeta");
		columnNames.add("Naziv predmeta");
		columnNames.add("ESPB");
		columnNames.add("Godina studija");
		columnNames.add("Semestar");
	}
	@Override
	public int getRowCount() {
		int selectedIndex = MainFrame.getInstance().getTab().getSelectedRowInStudentTable();
		this.student = DatabaseReader.getInstance().getStudents().get(selectedIndex);
		return student.getFailedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return student.getFailedExams().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
}

