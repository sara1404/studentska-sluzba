package controller;

import view.MainFrame;
import view.tabs.MainTab;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class SearchController {

    private static SearchController instance = null;

    public SearchController() {}
    public static SearchController getInstance() {
        if(instance == null) {
            instance = new SearchController();
        }
        return instance;
    }

    public void search() {
        JTable table = null;
        MainTab tab = MainFrame.getInstance().getTab();
        if(tab.getSelectedIndex() == 0)
            table = tab.getStudentTable();
        else if(tab.getSelectedIndex() == 1)
            table = tab.getProfessorTable();
        else
            table = tab.getSubjectTable();

        AbstractTableModel model = (AbstractTableModel) table.getModel();
        model.fireTableDataChanged();
    }


}
