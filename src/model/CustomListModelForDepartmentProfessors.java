package model;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomListModelForDepartmentProfessors extends AbstractListModel<String> {

    @Override
    public int getSize() {
        return DatabaseReader.getInstance().getProfessorsWithNoDepartment().size();
    }

    @Override
    public String getElementAt(int index) {
        Professor professor = DatabaseReader.getInstance().getProfessorsWithNoDepartment().get(index);
        return professor.getName() + " " + professor.getSurname();
    }
}
