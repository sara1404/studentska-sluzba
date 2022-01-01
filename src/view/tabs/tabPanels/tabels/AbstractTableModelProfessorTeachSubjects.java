package view.tabs.tabPanels.tabels;

import model.DatabaseReader;
import model.Professor;
import view.MainFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AbstractTableModelProfessorTeachSubjects extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private Professor professor;

    public AbstractTableModelProfessorTeachSubjects(){
        columnNames = new ArrayList<>();
        columnNames.add("Sifra");
        columnNames.add("Naziv");
        columnNames.add("Godina studija");
        columnNames.add("Semestar");
    }
    @Override
    public int getRowCount() {
        int selectedIndex = MainFrame.getInstance().getTab().getSelectedRowInProfessorTable();
        this.professor = DatabaseReader.getInstance().getProfessors().get(selectedIndex);
        return professor.getSubjectList().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return professor.getSubjectList().get(rowIndex).getValueAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return columnNames.get(column);
    }
}
