package controller;

public class ShowProfessorTeachSubjects {
    private static ShowProfessorTeachSubjects instance = null;

    private ShowProfessorTeachSubjects(){}



    public static ShowProfessorTeachSubjects getInstance(){
        if(instance == null)
            instance = new ShowProfessorTeachSubjects();
        return instance;
    }
}
