package model;

import javax.swing.*;

public class CustomListModelForDepartmentDirector extends AbstractListModel<String> {
    @Override
    public int getSize() {
        return DatabaseReader.getInstance().filterProfessorsForDepartmentDirector().size();
    }

    @Override
    public String getElementAt(int index) {
        Professor professor =  DatabaseReader.getInstance().filterProfessorsForDepartmentDirector().get(index);
        return professor.getName() + " " + professor.getSurname();
    }
}
