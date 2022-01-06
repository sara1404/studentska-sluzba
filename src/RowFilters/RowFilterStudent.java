package RowFilters;


import view.MainFrame;

import javax.swing.*;

public class RowFilterStudent<AbstractTableModelStudent,String> extends RowFilter<AbstractTableModelStudent,String> {
    private MainFrame mainFrame;
    public RowFilterStudent(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    @Override
    public boolean include(Entry<? extends AbstractTableModelStudent, ? extends String> entry) {
        java.lang.String text = mainFrame.getToolbar().getSearchField().getText();
        java.lang.String surname = (java.lang.String)entry.getValue(2);
        java.lang.String name = (java.lang.String)entry.getValue(1);
        java.lang.String index = (java.lang.String)entry.getValue(0);
        java.lang.String[] splitted = text.split(",");
        if(splitted.length == 1) {
            return surname.trim().toLowerCase().contains(splitted[0].trim().toLowerCase());
        }
        else if(splitted.length == 2){
            return (surname.trim().toLowerCase().contains(splitted[0].trim().toLowerCase()) &&
                    name.trim().toLowerCase().contains(splitted[1].trim().toLowerCase()));
        }
        else if(splitted.length == 3){
            return (index.trim().toLowerCase().contains(splitted[0]) &&
                    surname.trim().toLowerCase().contains(splitted[2].trim().toLowerCase()) &&
                    name.trim().toLowerCase().contains(splitted[1].trim().toLowerCase()));
        }
        return false;
    }
}
