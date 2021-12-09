package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RS extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try{	
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		 String url="jdbc:mysql://localhost:3306/test";
		   String uname="root";
		   String pass="root123";
		   String query="select * from `user` where sub='"+req.getParameter("testname")+"' and user_marks>="+req.getParameter("min")+"";
		   
	       Class.forName("com.mysql.jdbc.Driver");
	       Connection con=DriverManager.getConnection(url,uname,pass);
	       Statement st=con.createStatement();
	       
	       ResultSet rs=st.executeQuery(query);
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<style text=\"text/css\">\r\n"
				+ ".g{"
				+ "margin-right:25px;"
				+ "}"
				+ " body{\r\n"
				+ " font-family:arial;}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ " \r\n"
				+ "    \r\n"
				+ "       \r\n"
				+ "        \r\n"
				+ "   <label>Users List based on given condition</label><br><br>    \r\n"
				+ "        \r\n"
				+ "           \r\n");
		      int n=1;
		      while(rs.next()) {
				out.println("        <label class=\"g\">"+n+".Name:"+rs.getString("user_name")+"   </label>    \r\n"
				+ "        \r\n"
				+ "      \r\n"
				+ "        <label class=\"g\">Marks:"+rs.getInt("user_marks")+"     </label>    \r\n"
						+ "          <label class=\"g\">Subject:"+rs.getString("sub")+"    </label>"
				+ "         <label class=\"g\">Submitted date:"+rs.getDate("sub_date")+"     </label>"
				
				+ "        <br>       \r\n");}
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
				out.println("            \r\n"
				+ "            \r\n"
				+ "       \r\n"
				+ "  </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		}catch(Exception e) {}	
	}

}
