package org.btm.chainApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		String pname=req.getParameter("pn");
		String pqty=req.getParameter("pq");
		
		req.setAttribute("prdnm",pname);
		req.setAttribute("prdqty",pqty);
		
		RequestDispatcher rd=req.getRequestDispatcher("ss");
		rd.include(req,resp);
		
		double totalsum=(double)req.getAttribute("tsum");

		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+"<h1>Product Details are "+pname+" "+totalsum+"</h1>"
				+"</body></html>"); //PRESENTATION LOGIC
		out.flush();
		out.close();
	}
}
