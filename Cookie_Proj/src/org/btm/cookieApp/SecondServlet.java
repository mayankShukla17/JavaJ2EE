package org.btm.cookieApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{
		Cookie c[]=req.getCookies();
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
		+"<h1>Cookie Object Value "+c[0].getValue()+"</h1>"
		+"</body></html>");
		out.flush();
		out.close();
	}
}
