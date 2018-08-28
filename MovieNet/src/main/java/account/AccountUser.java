package account;


import java.sql.Date;

import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.mindrot.jbcrypt.BCrypt;

import database.JDBC;


@Path("/account")
public class AccountUser {
	
	
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("/newUser")
public void addUser(@FormParam("first_name") String first_name,
		            @FormParam("last_name") String last_name,
		            @FormParam("email") String email,
		            @FormParam("dateOfBirth") Date dateOfBirth,
		            @FormParam("password") String password) throws Exception{
	String pwHash = BCrypt.hashpw(password,BCrypt.gensalt(12));
	
	JDBC database = new JDBC();
		 database.accessDB();
	     database.createAccount(first_name, last_name, email, pwHash, dateOfBirth);
	     
	     JDBC.conn.close();
	     
	     System.out.print(first_name + last_name + email + pwHash + dateOfBirth );
	     
}

@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("/address")
public void addAddress(@FormParam("city") String city,
		               @FormParam("postcode") String postcode,
		               @FormParam("houseNum") int houseNum,
		               @FormParam("Country") String Country,
		               @FormParam("phoneNum") int phoneNum) throws Exception{
	JDBC database = new JDBC();
		 database.accessDB();
	     database.createAddress(city, postcode, houseNum, Country, phoneNum);
	     JDBC.conn.close();
	     
	     System.out.print(city + postcode + houseNum + Country + phoneNum );
	     
}

@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path ("/login")
public void accountLogin(@FormParam("email") String email,
		                 @FormParam("password") String password) throws Exception {
	String hash = BCrypt.hashpw(password.trim(), BCrypt.gensalt(12));
	JDBC database = new JDBC();
	     database.accessDB();
	     database.login(email, password, hash);
	     JDBC.conn.close();
	     
}
}