package model;

public class Adress {
	private String street;
	private int number;
	private String town;
	private String country;
	public Adress(String street, int number, String town, String country) {
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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

	
}
