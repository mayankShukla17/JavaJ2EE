package org.btm.lifecycleApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/fs",loadOnStartup = 5)
public class FirstServlet extends GenericServlet
{
	public FirstServlet() 
	{
		System.out.println("Servlet Object Created");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet Object is Initialized");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
		+ "<h1>Student Details are "+name+" "+place+"</h1>"
		+ "</body></html>"); // PRESENTATION LOGIC
		out.flush();
		out.close();
		System.out.println("service() is executed!!!");
	}
	
	@Override
	public void destroy() 
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Closed All Costly Resources");
	}
}
