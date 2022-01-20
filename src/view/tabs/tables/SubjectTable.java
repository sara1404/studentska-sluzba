package view.tabs.tables;

import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import RowFilters.RowFilterSubject;
import model.ObserverNotifier;
import view.MainFrame;

public class SubjectTable extends JTable {
	public SubjectTable(MainFrame frame) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelSubject model = new AbstractTableModelSubject();
		this.setModel(model);
		TableRowSorter<AbstractTableModelSubject> sorter = new TableRowSorter<AbstractTableModelSubject>(model);
		sorter.setComparator(0, (Comparator<?>) new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	int int1 = Integer.parseInt(name1.replaceAll("[^0-9]", "")) ;
		    	int int2 = Integer.parseInt(name2.replaceAll("[^0-9]", "")) ;
		    	if (int1 < int2) {
               	 return -1;
               } 
               else if (int1 > int2) {
               	return 1;
               }
               else {
               	return 0;
               }   
		    	}
		    
		});
		
		sorter.setComparator(4, (Comparator<?>) new Comparator<String>() {
			 
		    @Override
		    public int compare(String name1, String name2) {
		    	int int1 = Integer.parseInt(name1) ;
		    	int int2 = Integer.parseInt(name2) ;
		    	if (int1 < int2) {
               	 return -1;
               } 
               else if (int1 > int2) {
               	return 1;
               }
               else {
               	return 0;
               }   
		    }
		});
		sorter.setRowFilter(new RowFilterSubject(frame));
		sorter.setSortsOnUpdates(true);
		setRowSorter(sorter);
		ObserverNotifier on = ObserverNotifier.getInstance();
		on.setSubjectTable(this);
		
	}
}
