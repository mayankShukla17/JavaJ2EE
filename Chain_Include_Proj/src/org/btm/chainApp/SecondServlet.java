package org.btm.chainApp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{
		//FETCH REQUEST(req) OBJECT BACK FROM SCOPE
		String pname=(String)req.getAttribute("prdnm");
		String pqty=(String)req.getAttribute("prdqty");
		int qty=Integer.parseInt(pqty);
		double price=40000.00;
		double totalsum=(price*qty); //BUSINESS LOGIC
		
		req.setAttribute("tsum",totalsum);
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.product values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Root@123&autoReconnect=true&useSSL=false");
			pstmt=con.prepareStatement(qry);
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setString(1,pname);
			pstmt.setInt(2,qty);
			pstmt.setDouble(3,totalsum);
			pstmt.executeUpdate();  //PERSISTANCE LOGIC
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null && con!=null) {
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
