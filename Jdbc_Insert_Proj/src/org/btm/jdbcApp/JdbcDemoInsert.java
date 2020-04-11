package org.btm.jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcDemoInsert {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm.student values(3,'Mks',36.55)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered.");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			System.out.println("Connection established with DB server.");
			stmt=con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry);
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
