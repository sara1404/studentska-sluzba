package controller;

import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import model.Subject;
import view.tabs.tabPanels.SubjectsListProfessor;

import javax.swing.*;

public class ShowProfessorTeachSubjectsController {
    private static ShowProfessorTeachSubjectsController instance = null;

    private ShowProfessorTeachSubjectsController(){}

    public void removeSubjectFromProfessor(JTable table, Professor professor, SubjectsListProfessor dialog){
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(dialog, "Morate selektovati predmet iz tabele pre uklanjanja!");
        }
        else{
            Subject subject = DatabaseReader.getInstance().getSubjects().get(table.getSelectedRow());
            int resp = 0;
            resp = JOptionPane.showConfirmDialog(dialog, "Da li zelite da izbrisete predmet sa profesora?",
                    "Ukloni predmet", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp == 0) {
                professor.getSubjectList().remove(subject);
                ObserverNotifier.getInstance().professorTeachSubjectsDataChanged();
            }
        }
    }


    public static ShowProfessorTeachSubjectsController getInstance(){
        if(instance == null)
            instance = new ShowProfessorTeachSubjectsController();
        return instance;
    }
}
