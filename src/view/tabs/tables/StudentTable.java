package view.tabs.tables;

import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import RowFilters.RowFilterStudent;
import model.ObserverNotifier;
import view.MainFrame;


public class StudentTable extends JTable {
	
	public StudentTable(MainFrame frame) {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setColumnSelectionAllowed(false);
		AbstractTableModelStudent atms = new AbstractTableModelStudent();
		this.setModel(atms);
		//TableRowSorter<AbstractTableModelStudent> sorter = new TableRowSorter<>(atms);
		TableRowSorter<AbstractTableModelStudent> sorter = new TableRowSorter<AbstractTableModelStudent>(atms);
        sorter.setComparator(0, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                int info1 = Integer.parseInt("0" + o1.replaceAll("[^0-9]", ""));
                int info2 = Integer.parseInt("0" + o2.replaceAll("[^0-9]", ""));
                if (info1 < info2) {
                	 return -1;
                } 
                else if (info1 == info2) {
                	return 0;
                }
                else {
                	return 1;
                }   
           }

        });
		sorter.setRowFilter(new RowFilterStudent(frame));
		sorter.setSortsOnUpdates(true);
		setRowSorter(sorter);

		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setStudentTable(this);
	}

}
