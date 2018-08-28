package database;

public class Account {
private int accountID;
private String email,password,first_name,last_name,dateOfBirth;

public Account(int AccountID,String Email, String Password, String first_name, String last_name, String DateOfBirth ) {
	
	this.accountID = AccountID;
	this.email = Email;
	this.password = Password;
	this.first_name = first_name;
	this.last_name = last_name;
	this.dateOfBirth = DateOfBirth;
}

public int getAccountID() {
	return accountID;
}
public void setAccountID(int AccountID) {
	this.accountID = AccountID;
}
public String getEmail() {
	return email;
}
public void setEmail( String Email) {
	this.email = Email;
}
public String getPassword() {
	return password;
}
public void setPassword(String Password) {
	this.password = Password;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String DateOfBirth) {
	this.dateOfBirth = DateOfBirth;
}
}
