package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

import org.mindrot.jbcrypt.BCrypt;

public class JDBC {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/filmenterprise?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";
	
	public static Connection conn = null;

	public void accessDB() throws Exception {
	try {
		 Class.forName(JDBC_DRIVER);
		 conn= DriverManager.getConnection(DB_URL,USER,PASS);
		 System.out.println("Connecting to database..");
	}catch(SQLException sqle) {sqle.printStackTrace();
	}catch(Exception e) {e.printStackTrace();}
  }
	
	public void createAccount(String first_name, String last_name, String email, String password, Date Date_of_Birth ) throws Exception{
	PreparedStatement stmt = null;
	String sqlInsert = "INSERT INTO account(Email,Password,First_name,Last_name,Date_of_Birth) VALUES (?,?,?,?,?);";
	try {
		
		stmt = conn.prepareStatement(sqlInsert);
		stmt.setString(1,email);
	    stmt.setString(2,password);
		stmt.setString(3,first_name);
		stmt.setString(4,last_name);
		stmt.setDate(5,Date_of_Birth  );
		stmt.executeUpdate();
		
		System.out.println("New user created...");
	}catch(SQLException sqle) {sqle.printStackTrace();
	}catch(Exception e) {e.printStackTrace();}
}
	
	public void createAddress(String city, String postcode,int houseNum,String Country,int phoneNum ) throws Exception{
		PreparedStatement stmt = null;
		String sqlInsert = "INSERT INTO address(House_Number,Postcode,PhoneNumber,City,Country) VALUES (?,?,?,?,?);";
		try {
			
			stmt = conn.prepareStatement(sqlInsert);
			stmt.setInt(1,houseNum);
		    stmt.setString(2,postcode);
			stmt.setInt(3,phoneNum);
			stmt.setString(4,city);
			stmt.setString(5,Country);
			stmt.executeUpdate();
			
			System.out.println("Address details add");
		}catch(SQLException sqle) {sqle.printStackTrace();
		}catch(Exception e) {e.printStackTrace();}
	}

	public boolean login(String email, String password, String hash) {
		PreparedStatement stmt = null;
		String psw = "";
		String sqlSelect = "SELECT Email, Password FROM account where Email =? AND Password =?;";
		try {
		stmt = conn.prepareStatement(sqlSelect);
		stmt.setString(1,email);
		ResultSet rs = stmt.executeQuery(sqlSelect);
		while (rs.next()) {
			email = rs.getString(1);
			psw = rs.getString(2);
			System.out.println(password);
		}
		rs.close();
		}catch(SQLException sqle) {sqle.printStackTrace();}
		if (BCrypt.checkpw(password, hash)) {
			String newHash = hash(password);
		}
		return true;
	}
	
	private String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
}