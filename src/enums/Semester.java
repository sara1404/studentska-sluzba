package enums;

public enum Semester {
	LETNJI("LETNJI"), ZIMSKI("ZIMSKI");
	String value;
	Semester(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Semester getSemesterWithString(String semester) {
		if(semester.equals("LETNJI")) return Semester.LETNJI;
		else return Semester.ZIMSKI;
	}
}
