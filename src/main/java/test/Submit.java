package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Submit extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		Cookie[] cookies=req.getCookies();
		for(int i=0;i<cookies.length;i++) {
		   if((cookies[i].getName()).equals("username"))  {
			   cookies[i].setMaxAge(0);
			   res.addCookie(cookies[i]);
			   
		   }
        }
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		out.println("<script>alert(\"You are logged out\");</script>");
		
		RequestDispatcher rd=req.getRequestDispatcher("/Main.html");
		rd.include(req,res);
	}	

}
