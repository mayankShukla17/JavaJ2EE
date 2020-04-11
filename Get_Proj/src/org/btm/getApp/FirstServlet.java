package org.btm.getApp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("i");
		//int id=Integer.parseInt(sid);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student1 where id=?";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			pstmt=con.prepareStatement(qry);

			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setInt(1,Integer.parseInt(sid));
			rs=pstmt.executeQuery();//PERSISTENCE LOGIC
			if (rs.next()) 
			{
				String name=rs.getString(2);
				String dept=rs.getString(3);
				double per=rs.getDouble(4);
				PrintWriter out=resp.getWriter();
				out.println("<html><body bgcolor='yellow'>"
						+"<h1>Student Details are "+name+" "+dept+" "+per+"</h1>"
						+"</body></html>");
				out.flush(); //PRESENTATION LOGIC
				out.close();
			}
			else 
			{
				PrintWriter out=resp.getWriter();
				out.println("<html><body bgcolor='red'>"
						+"<h1>No Data Found!!</h1>"
						+"</body></html>");
				out.flush(); //PRESENTATION LOGIC
				out.close();
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (rs!=null && pstmt!=null && con!=null) 
			{
				try 
				{
					rs.close();
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
