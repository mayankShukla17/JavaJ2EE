package org.btm.transactionApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;
public class JdbcTransaction 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		Savepoint sp=null;
		String stded="insert into btm.studentedu values(?,?,?,?)";
		String stdpr="insert into btm.studentper values(?,?,?)";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id??");
		int id=sc.nextInt();
		System.out.println("Enter name??");
		String name=sc.next();
		System.out.println("Enter dept??");
		String dept=sc.next();
		System.out.println("Enter perc??");
		double perc=sc.nextDouble();
		System.out.println("Enter place??");
		String place=sc.next();
		sc.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			//Disable Auto Commit Mode
			con.setAutoCommit(false);
			
			pstmt=con.prepareStatement(stded);
			//Set the value for placeholder before execution
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,dept);
			pstmt.setDouble(4,perc);
			pstmt.executeUpdate();
			System.out.println("Student educational details executed!!!");
			//1st DB Operation
			
			sp=con.setSavepoint();
			
			pstmt1=con.prepareStatement(stdpr);
			//Set the value for placeholder before execution
			pstmt1.setInt(1,id);
			pstmt1.setString(2,name);
			pstmt1.setString(3,place);
			pstmt1.executeUpdate();
			System.out.println("Student personal details executed!!!");
			//2nd DB Operation
			
			con.commit();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			try
			{
				//con.rollback();
				con.rollback(sp);
				con.commit();
				System.out.println("Operation Rolled Back");
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally 
		{
			if(pstmt1!=null && pstmt!=null && con!=null) 
			{

				try 
				{
					pstmt1.close();
					pstmt.close();
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
