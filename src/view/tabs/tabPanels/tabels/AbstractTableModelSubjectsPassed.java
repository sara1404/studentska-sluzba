package view.tabs.tabPanels.tabels;

import model.DatabaseReader;
import model.Student;
import view.MainFrame;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelSubjectsPassed extends AbstractTableModel{


	private ArrayList<String> columnNames;
	private Student student;
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
		int selectedIndex = MainFrame.getInstance().getTab().getSelectedRowInStudentTable();
		this.student = DatabaseReader.getInstance().getStudents().get(selectedIndex);
		return student.getPassedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return student.getPassedExams().get(rowIndex).getValueAt(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
}
