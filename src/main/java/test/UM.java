package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UM extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try{
			   PrintWriter out=res.getWriter();
   		       res.setContentType("text/html");
			   String url="jdbc:mysql://localhost:3306/test";
			   String uname="root";
			   String pass="root123";
			   String query="select user_marks from `user` where `user_name`='"+req.getParameter("username")+"' and `sub_date`='"+req.getParameter("date")+"' and `sub`='"+req.getParameter("testname")+"'";
		       Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pass);
		       Statement st=con.createStatement();
		       ResultSet rs=st.executeQuery(query);
		       if(!rs.next()) {
		    	 out.println("<script>alert(\"Invalid data\");</script>");
		    	 RequestDispatcher rd=req.getRequestDispatcher("UserMark");
		    	 rd.include(req, res);
		       }
		       else {
		       int mark=0;
		      
		    	   mark=rs.getInt("user_marks");
		       
		       out.println("<h1 style=\"font-family:arial;\">Marks you obtained:"+mark+"</h1>");
		       out.println("<a href=\"Admin.html\" style=\"float:left;\r\n"
		       		+ " margin-top:50px;\r\n"
		       		+ " margin-left:25px;\r\n"
		       		+ " border:1px solid;\r\n"
		       		+ " background-color:#FFFFFF;\r\n"
		       		+ "\r\n"
		       		+ " padding-top:5px;\r\n"
		       		+ " padding-bottom:5px;\r\n"
		       		+ " padding-left:25px;\r\n"
		       		+ " padding-right:25px;\r\n"
		       		+ " text-decoration:none;\r\n"
		       		+ " color:#000000;\">Back to Admin Page</a>");
		       
		       
		   }}
		catch(Exception e) {}
	}
}
