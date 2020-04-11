package org.btm.uiApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/jaya")
public class FirstServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1> Dabba Fellow "+fname+" "+lname+"</h1>"
				+"</body></html>"); //PRESENTATION LOGIC
		out.flush();
		out.close();
	}
}
