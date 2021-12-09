package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CT extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		 try{
			   String url="jdbc:mysql://localhost:3306/test";
			   String uname="root";
			   String pass="root123";
			   int time=Integer.parseInt(req.getParameter("Time"));
			   Cookie count=new Cookie("count","0");
			   Cookie total=new Cookie("total",req.getParameter("total"));
			   res.addCookie(total);
			   res.addCookie(count);
			   String query="insert into `create_test`(`name`,`password`,`test_min`,`total_questions`) values('"+req.getParameter("Testname")+"','"+req.getParameter("Pass")+"','"+time+"','"+Integer.parseInt(req.getParameter("total"))+"')";
		       Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pass);
		       Statement st=con.createStatement();
		       st.executeUpdate(query);
			   PrintWriter out=res.getWriter();
			   res.setContentType("text/html");
			   req.setAttribute("Testname", req.getParameter("Testname"));
			   RequestDispatcher rd=req.getRequestDispatcher("Question");
			   rd.forward(req,res);
			   out.close();
			   
		 }
		 catch(Exception e) {e.printStackTrace();}
		
	}

}

