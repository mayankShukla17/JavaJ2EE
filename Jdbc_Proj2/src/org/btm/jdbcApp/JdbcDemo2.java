package org.btm.jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcDemo2 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered.");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			System.out.println("Connection established with DB server.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Closed all Costly Resources");
		}
	}
}
