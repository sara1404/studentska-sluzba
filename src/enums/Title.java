package enums;

public enum Title {
	ASISTENT("ASISTENT"), DOCENT("DOCENT"), VANREDNI("VANREDNI"), REDOVNI("REDOVNI");
	String value;
	Title(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Title getStatusWithString(String status) {
		if(status.equals("ASISTENT")) return Title.ASISTENT;
		else if(status.equals("DOCENT")) return Title.DOCENT;
		else if(status.equals("VANREDNI")) return Title.VANREDNI;
		else return Title.REDOVNI;
	}
}
