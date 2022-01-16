package model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class CustomListModelForSubjectListProfessor extends AbstractListModel<String> {
	private ArrayList<Subject> subjects;

    public CustomListModelForSubjectListProfessor(Professor professor) {
        subjects = DatabaseReader.getInstance().filterSubjectsListForProfessor(professor);
    }

    public Subject getSubjectElement(int index) {
        return subjects.get(index);
    }

    @Override
    public int getSize() {
        return subjects.size();
    }

    @Override
    public String getElementAt(int index) { return subjects.get(index).getSubjectName(); }

    public ArrayList<Subject> getSubjects(){ return subjects; }
}
