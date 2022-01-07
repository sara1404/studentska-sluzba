package RowFilters;

import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;

import view.MainFrame;

public class RowFilterSubject<AbstractTableModelSubject,String> extends RowFilter<AbstractTableModelSubject,String> {
    private MainFrame mainFrame;
    public RowFilterSubject(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    @Override
    public boolean include(Entry<? extends AbstractTableModelSubject, ? extends String> entry) {
        java.lang.String text = mainFrame.getToolbar().getSearchField().getText();
        java.lang.String key = (java.lang.String)entry.getValue(1);
        java.lang.String name = (java.lang.String)entry.getValue(0);
        java.lang.String[] splitted = text.split(",");
        if(splitted.length == 1) {
            return key.trim().toLowerCase().contains(splitted[0].trim().toLowerCase());
        }
        else if(splitted.length == 2){
            return (key.trim().toLowerCase().contains(splitted[0].trim().toLowerCase()) &&
                    name.trim().toLowerCase().contains(splitted[1].trim().toLowerCase()));
        }
        return false;
    }
}
