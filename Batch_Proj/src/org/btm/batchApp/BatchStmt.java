package org.btm.batchApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class BatchStmt {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into btm.student values(6,'Trilok',54.66)";
		String upqry="update btm.user set password='Karthik' where name='Deepika'";
		String delqry="delete from btm.student where per=54.66";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			stmt=con.createStatement();
			//ADD ALL DML QUERIES INTO BATCH
			stmt.addBatch(inqry);
			stmt.addBatch(delqry);
			stmt.addBatch(upqry);
			//EXECUTE BATCH
			int arr[]=stmt.executeBatch();
			for (int i : arr) {
				System.out.print(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null && con!=null) {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
