package controller;

import model.DatabaseReader;
import model.ObserverNotifier;
import model.Professor;
import model.Subject;
import view.tabs.tabPanels.SubjectsListProfessor;

import javax.swing.*;

import bundle.LanguageSupport;

public class ShowProfessorTeachSubjectsController {
    private static ShowProfessorTeachSubjectsController instance = null;

    private ShowProfessorTeachSubjectsController(){}

    public void removeSubjectFromProfessor(JTable table, Professor professor, SubjectsListProfessor dialog){
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(dialog, LanguageSupport.getInstance().getResourceBundle().getString("message"));
        }
        else{
            Subject subject = professor.getSubjectList().get(table.getSelectedRow());
            int resp = JOptionPane.showConfirmDialog(dialog, LanguageSupport.getInstance().getResourceBundle().getString("question"),
            		LanguageSupport.getInstance().getResourceBundle().getString("title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp == 0) {
                DatabaseReader.getInstance().removeSubjectFromProfessor(professor.getId(), subject.getSubjectKey());
                DatabaseReader.getInstance().findSubject(subject.getSubjectKey()).setProfessor(null);
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
