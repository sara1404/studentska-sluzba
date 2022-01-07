package controller;

import model.DatabaseReader;
import model.Department;
import model.ObserverNotifier;
import model.Professor;
import view.dialogs.AddDepartmentDirectorDialog;
import view.dialogs.AssignProfessorToDepartmentDirectorDialog;
import view.dialogs.DepartmentsDialog;

public class SetDepartmentDirectorController {
    private static SetDepartmentDirectorController instance = null;

    private SetDepartmentDirectorController(){}

    public void addDepartmentDirectorController(DepartmentsDialog departmentsDialog, AssignProfessorToDepartmentDirectorDialog assignProfessorToDepartmentDirectorDialog, AddDepartmentDirectorDialog dialog){
        Department department = DatabaseReader.getInstance().getDepartments().get(departmentsDialog.getDepartmentTable().getSelectedRow());
        if(assignProfessorToDepartmentDirectorDialog.getProfessorList().getSelectedIndex() != -1){
            Professor professor = DatabaseReader.getInstance().filterProfessorsForDepartmentDirector().get(assignProfessorToDepartmentDirectorDialog.getProfessorList().getSelectedIndex());
            department.setHead(professor);
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

    public static SetDepartmentDirectorController getInstance(){
        if(instance == null)
            instance = new SetDepartmentDirectorController();
        return instance;
    }
}
