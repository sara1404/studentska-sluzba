package view.tabs.tables;

import model.ObserverNotifier;

import javax.swing.*;

public class DepartmentTable extends JTable{
    public DepartmentTable() {
        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        AbstractTableModelDepartment atmd = new AbstractTableModelDepartment();
        this.setModel(atmd);
        ObserverNotifier on = ObserverNotifier.getInstance();
        on.setDepartmentTable(this);
    }
}
