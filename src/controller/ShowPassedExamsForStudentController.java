package controller;

import model.DatabaseReader;
import model.Grade;
import model.ObserverNotifier;
import model.Student;
import view.MainFrame;
import view.tabs.tabPanels.SubjectsPassedStudent;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Observer;

public class ShowPassedExamsForStudentController {

    private static ShowPassedExamsForStudentController instance = null;

    private ShowPassedExamsForStudentController(){}

    public void setAverageGrade(SubjectsPassedStudent subjectsPassedStudent){
        String studentIndex = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
        Student student = DatabaseReader.getInstance().findStudent(studentIndex);
        ArrayList<Grade> passedSubs = student.getPassedExams();
        double grades = 0;
        for(int i = 0; i < passedSubs.size(); i++){
            grades += passedSubs.get(i).getGrade();
        }
        if(passedSubs.isEmpty()) {
        	subjectsPassedStudent.getAverageGradeLabel().setText("0");
        	student.setAverageGrade(0);
        }
        else {
        	subjectsPassedStudent.getAverageGradeLabel().setText(String.valueOf(grades/passedSubs.size()));
        	student.setAverageGrade(grades/passedSubs.size());
        }
    }

    public void setEspbPoints(SubjectsPassedStudent subjectsPassedStudent){
        String studentIndex = MainFrame.getInstance().getTab().getIndexOfSelectedStudent();
        Student student = DatabaseReader.getInstance().findStudent(studentIndex);
        ArrayList<Grade> passedSubs = student.getPassedExams();
        int espbPoints = 0;
        for(int i = 0; i < passedSubs.size(); i++){
            espbPoints += passedSubs.get(i).getSubject().getESPB();
        }
        if(passedSubs.isEmpty())
            subjectsPassedStudent.getEspbSumLabel().setText("0");
        else
            subjectsPassedStudent.getEspbSumLabel().setText(String.valueOf(espbPoints));
        //ObserverNotifier.getInstance().studentsDataChanged();
    }

    public static ShowPassedExamsForStudentController getInstance(){
        if(instance == null)
            instance = new ShowPassedExamsForStudentController();
        return instance;
    }
}
