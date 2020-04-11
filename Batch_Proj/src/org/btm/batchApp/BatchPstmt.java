package org.btm.batchApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BatchPstmt 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		String upqry="update btm.student set id=4 where name='Trilok'";
		String delqry="delete from btm.student where name='Aman'";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			//ADD DML QUERY INTO BATCH
			pstmt=con.prepareStatement(upqry);
			pstmt.addBatch();
			//EXECUTE BATCH
			int arr[]=pstmt.executeBatch();
			for (int i : arr) 
			{
				System.out.println(i);
			}
			
			//ADD DML QUERY INTO BATCH
			pstmt1=con.prepareStatement(delqry);
			pstmt1.addBatch();
			//EXECUTE BATCH
			int arr1[]=pstmt1.executeBatch();
			for (int j : arr1) 
			{
				System.out.println(j);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (pstmt1!=null && pstmt!=null && con!=null)
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
