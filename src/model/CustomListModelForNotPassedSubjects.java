package model;

import javax.swing.*;
import java.util.ArrayList;

public class CustomListModelForNotPassedSubjects extends AbstractListModel<String> {
    private ArrayList<Subject> subjects;

    public CustomListModelForNotPassedSubjects(Student student) {
        subjects = DatabaseReader.getInstance().filterSubjectsForStudent(student);
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
