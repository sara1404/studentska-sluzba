package enums;

public enum Status {
	B("BUDZET"), S("SAMOFINANSIRANJE");	
	String value;
	Status(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Status getStatusWithString(String status) {
		if(status.equals("BUDZET")) return Status.B;
		else return Status.S;
	}
}
