package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestJDBC{
	
	public final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://127.0.0.1:3306/filmenterprise?useSSL=false";
	public final String USER = "root";
	public final String PASS = "password";
	public Connection conn = null;
	
	@Test
	public void testConncetion(){
	    new JDBC();
		assertNull("conncetion not found",JDBC.conn);
}
	@Test
	public void testAccess() {
		new JDBC();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			assertEquals("unable to access database password or user incorrect",conn,"Have access to database");
		} catch (SQLException t) {t.printStackTrace();}
		
		
}
	@Test
	public void testInsert() {
		new JDBC();
		PreparedStatement stmt = null;
		try {
			String sqlInsert = "INSERT INTO account(Email,Password,First_name,Last_name,Date_of_Birth) VALUES (?,?,?,?,?);";
			stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1,"John@email.com");
		    stmt.setString(2,"password");
			stmt.setString(3,"John");
			stmt.setString(4,"Doe");
			stmt.setDate(5, new Date(1995));
			stmt.executeUpdate();
			assertEquals("No data was inserted into the database",sqlInsert,"Data was inserted into database");
			conn.close();
		} catch (Exception t) {t.printStackTrace();}
	}
	
	@Test
	public void testFind() {
		new JDBC();
		PreparedStatement stmt = null;
		try {
		String sqlSelect = "SELECT Email FROM account where Email = 'John@email.com';";
		ResultSet rs = stmt.executeQuery(sqlSelect);
		while (rs.next()) {
			 String email = rs.getString("Email");
		}
		assertEquals("No Results found",sqlSelect,"Result found");
		rs.close();
		conn.close();
			} catch (SQLException e) {e.printStackTrace();}
}
}