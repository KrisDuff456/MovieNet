package database;

public class Address{
	private int addressID,houseNum,phoneNum;
	private String postCode,city,street,country;

public Address(int addressId,int houseNumber, String postCode, String city, String street, String country,int phoneNumber ) {
		
	    this.addressID=addressId;
	    this.houseNum=houseNumber;
	    this.postCode=postCode;
	    this.phoneNum=phoneNumber;
	    this.city=city;
	    this.street=street;
	    this.country=country;
	}

	public int getAddressID() {
		return addressID;
	}
	
	public void setAddressID(int addressId) {
		this.addressID=addressId;
	}
	
	public int getHouseNum() {
		return houseNum;
	}
	
	public void setHouseNum(int houseNumber) {
		this.houseNum=houseNumber;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode=postCode;
	}
	public int getPhoneNumber() {
		return phoneNum;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNum=phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street=street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country=country;
	}
	
}
