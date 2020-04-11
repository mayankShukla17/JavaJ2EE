package org.btm.jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class MulInsertDemo {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded & Registered.");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			System.out.println("Connection established with DB server.");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform created");
//			SET THE VALUES FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Nidhi");
			pstmt.setDouble(3, 76.86);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Anku");
			pstmt.setDouble(3, 66.45);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3);
			pstmt.setString(2, "MKS");
			pstmt.setDouble(3, 74.6);
			pstmt.executeUpdate();
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null && con!=null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Closed all Costly Resources");
		}
	}
}
