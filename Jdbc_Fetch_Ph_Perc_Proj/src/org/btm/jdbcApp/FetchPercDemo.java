package org.btm.jdbcApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class FetchPercDemo {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where per=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter perc??");
		double perc=sc.nextDouble();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			pstmt=con.prepareStatement(qry);
//			SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setDouble(1, perc);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				System.out.println("Id "+id+" "+"Name "+name);
			}else {
				System.err.println("No data found for perc "+perc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null && pstmt!=null && con!=null) {
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
