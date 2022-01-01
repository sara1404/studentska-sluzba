package view.tabs.tabPanels.tabels;

import model.ObserverNotifier;

import javax.swing.*;

public class ProfessorTeachSubjectsTable extends JTable{
    public ProfessorTeachSubjectsTable(){
        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractTableModelProfessorTeachSubjects());
        ObserverNotifier on = ObserverNotifier.getInstance();
        on.setProfessorTeachSubjectsTable(this);
    }
}
