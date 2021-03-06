package controller;

import com.sun.tools.javac.Main;
import model.DatabaseReader;
import model.Department;
import model.ObserverNotifier;
import model.Professor;
import view.MainFrame;
import view.dialogs.AddDepartmentDirectorDialog;
import view.dialogs.AddProfessorToDepartmentDialog;
import view.dialogs.AssignProfessorToDepartmentDirectorDialog;
import view.dialogs.DepartmentsDialog;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class SetDepartmentDirectorController {
    private static SetDepartmentDirectorController instance = null;

    private SetDepartmentDirectorController(){}

    public void addDepartmentDirectorController(DepartmentsDialog departmentsDialog, AssignProfessorToDepartmentDirectorDialog assignProfessorToDepartmentDirectorDialog, AddDepartmentDirectorDialog dialog){
        Department department = DatabaseReader.getInstance().getDepartments().get(departmentsDialog.getDepartmentTable().getSelectedRow());
        if(assignProfessorToDepartmentDirectorDialog.getProfessorList().getSelectedIndex() != -1){
            Professor professor = DatabaseReader.getInstance().filterProfessorsForDepartmentDirector().get(assignProfessorToDepartmentDirectorDialog.getProfessorList().getSelectedIndex());
            department.setHead(professor);
            //department.getProfessors().add(professor);
            ObserverNotifier.getInstance().departmentDataChanged();
        }
        else{
            if(dialog.getDepartmentDirectorField().getText().equals("")){
                department.setHead(null);
                ObserverNotifier.getInstance().departmentDataChanged();
            }
        }
        assignProfessorToDepartmentDirectorDialog.dispose();
    }

    public void addProfessorToDepartment(AddProfessorToDepartmentDialog dialog){
        ArrayList<Professor> professors = DatabaseReader.getInstance().getProfessorsWithNoDepartment();
        Department department = DatabaseReader.getInstance().getDepartments().get(MainFrame.getInstance().getDepartmentsDialog().getDepartmentTable().getSelectedRow());
        int row = dialog.getList().getSelectedIndex();
        Professor professor = professors.get(row);
        DatabaseReader.getInstance().setDepartmentToProfessor(professor.getId(), department.getKey());
    }

    public static SetDepartmentDirectorController getInstance(){
        if(instance == null)
            instance = new SetDepartmentDirectorController();
        return instance;
    }
}
