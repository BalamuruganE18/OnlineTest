package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserMark  extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		Cookie[] cookies=req.getCookies();
		boolean st=false;
		for(int i=0;i<cookies.length;i++) {
			   if((cookies[i].getName()).equals("username")) {
				   st=true;
			   }	   
	    }
		if(!st) {
		  RequestDispatcher rd=req.getRequestDispatcher("/Main.html");
		  rd.include(req, res);
		}
		else {
			PrintWriter out=res.getWriter();
			res.setContentType("text/html");
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<style text=\"text/css\">\r\n"
					+ " body{\r\n"
					+ " font-family:arial;}\r\n"
					+ "</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ " \r\n"
					+ "    \r\n"
					+ "       \r\n"
					+ "        \r\n"
					+ "    <form  autocomplete=\"off\" method=\"post\"  action=\"abc\">    \r\n"
					+ "        <label><b> User Mark</b></label><br>\r\n"
					+ "        <br><br>\r\n"
					+ "        <div id=\"time\"></div>\r\n"
					+ "           \r\n"
					+ "        <label> User Name:</label>    \r\n"
					+ "        <input type=\"text\" name=\"username\" required ><br>\r\n"
					+ "      \r\n"
					+ "        <label>Test Name:</label>    \r\n"
					+ "        <input type=\"text\" name=\"testname\"  required><br>\r\n"
					+ "       \r\n"
					+ "        <label>Submission Date:</label>    \r\n"
					+ "        <input type=\"date\" name=\"date\"  required>\r\n"
					+ "<br><br>  "
					+ "        <input type=\"submit\"   value=\"Submit\">       \r\n"
					+ "            \r\n"
					+ "            \r\n"
					+ "    </form>     \r\n"
					+ "  </div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}		
}
