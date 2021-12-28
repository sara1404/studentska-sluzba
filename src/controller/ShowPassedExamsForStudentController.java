package controller;

import model.DatabaseReader;
import model.Grade;
import view.tabs.tabPanels.SubjectsPassedStudent;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class ShowPassedExamsForStudentController {

    private static ShowPassedExamsForStudentController instance = null;

    private ShowPassedExamsForStudentController(){
        System.out.println("Napravljen objekat kontrolera");
    }

    public void addSubjectToPassedSubjects(SubjectsPassedStudent subjectsPassedStudent){
        DatabaseReader db = DatabaseReader.getInstance();
        setAverageGrade(subjectsPassedStudent);
    }

    public void setAverageGrade(SubjectsPassedStudent subjectsPassedStudent){
        System.out.println("Instanca u setAverageGrade " + DatabaseReader.getInstance());
        System.out.println(DatabaseReader.getInstance());
        //ArrayList<Grade> gradesForStud  = DatabaseReader.getInstance().getStudents().get(0).getPassedExams();
//        for(int i = 0; i < gradesForStud.size(); i++) {
//            averageGrade += gradesForStud.get(i).getGrade();
//        }
//        System.out.println(averageGrade/(double)gradesForStud.size());
        int espbPoints = 0;
//        for(int i = 0; i < DatabaseReader.getInstance().getSubjectsPassedForStudent().size(); i++){
//            espbPoints += DatabaseReader.getInstance().getSubjectsPassedForStudent().get(i).getESPB();
//        }
//        //subjectsPassedStudent.getEspbSumData().setText(String.valueOf(espbPoints));
    }

    public static ShowPassedExamsForStudentController getInstance(){
        if(instance == null)
            instance = new ShowPassedExamsForStudentController();
        return instance;
    }
}
