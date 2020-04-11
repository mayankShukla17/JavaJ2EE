package org.btm.loginApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class LoginValidation {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select username from btm.user where name=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name??");
		String name=sc.next();
		System.out.println("Enter Password??");
		String pwd=sc.next();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			pstmt=con.prepareStatement(qry);
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String uname=rs.getString(1);
				System.out.println("Welcome "+uname);
			}else {
				System.err.println("Invalid Name/Password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs!=null && pstmt!=null && con!=null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
