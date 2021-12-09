package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class QuestionIns extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try{
			   String url="jdbc:mysql://localhost:3306/test";
			   String uname="root";
			   String pass="root123";
			   String query="insert into `questions`(`question`,`choice1`,`choice2`,`choice3`,`choice4`,`crt_option`,`subl`) values('"+req.getParameter("question")+"','"+req.getParameter("choice1")+"','"+req.getParameter("choice2")+"','"+req.getParameter("choice3")+"','"+req.getParameter("choice4")+"','"+Integer.parseInt(req.getParameter("crt"))+"','"+req.getParameter("Testname")+"')";
		       Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pass);
		       Statement st=con.createStatement();
		       st.executeUpdate(query);
		       String totals="";
		       String counts="";
			   Cookie[] cookies=req.getCookies();
			   for(int i=0;i<cookies.length;i++) {
					   if((cookies[i].getName()).equals("total")) {
						   totals=cookies[i].getValue();
					   }
					   if((cookies[i].getName()).equals("count")) {
						   counts=cookies[i].getValue();
					   }
	    	   }
			   int total=Integer.parseInt(totals);
			   int count=Integer.parseInt(counts);
			   count++;
			   for(int i=0;i<cookies.length;i++) {
				   if((cookies[i].getName()).equals("count")) {
					   cookies[i].setValue(String.valueOf(count));
					   res.addCookie(cookies[i]);
				   }
    	       }
			   PrintWriter out=res.getWriter();
				 res.setContentType("text/html");
			   if(count!=total) {
			 
			 
		       req.setAttribute("Testname", req.getParameter("Testname"));
			   RequestDispatcher rd=req.getRequestDispatcher("Question");
			   rd.include(req,res);
			   }
			   else {
				   for(int i=0;i<cookies.length;i++) {
					   if((cookies[i].getName()).equals("count")||(cookies[i].getName()).equals("total")) {
						   cookies[i].setMaxAge(0);
						   res.addCookie(cookies[i]);
						   
					   }}
				   out.println("<script>alert(\"Test is added\");</script>");
				   RequestDispatcher rd=req.getRequestDispatcher("/Admin.html");
				   rd.include(req,res);   
			   }
			
		 }
		 catch(Exception e) {e.printStackTrace();}
	}

}
