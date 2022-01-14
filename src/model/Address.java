package model;

public class Address {
	private String street;
	private String number;
	private String town;
	private String country;
	public Address(String street, String number, String town, String country) {
		super();
		this.street = street;
		this.number = number;
		this.town = town;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return street +"#"+ number +"#"+ town +"#"+ country;
	}

	
	
}
