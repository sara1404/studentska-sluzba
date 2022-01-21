package model;

public class ProfessorTeachSubject {
    private Professor professor;
    private Subject subject;

    public ProfessorTeachSubject(Professor professor, Subject subject){
        this.professor = professor;
        this.subject = subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

	@Override
	public String toString() {
		return professor.getId() + ", " + subject.getSubjectKey();
	}
    
    
}
