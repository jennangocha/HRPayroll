package app.domain;

/**
 * @author luungochabui
 * 
 */

public class Address {
	
	private String street;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	
	public Address() {
		this.street = "N.4th Street";
		this.city = "Fairfield";
		this.zipcode = "12345";
		this.state = "IA";
		this.country = "US";
	}
	
	public Address(String street, String city, String zipcode, String state, String country) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
