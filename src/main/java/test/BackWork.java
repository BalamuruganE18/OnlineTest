package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;


public class BackWork extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try{
			   PrintWriter out=res.getWriter();
     		   res.setContentType("text/html");
     		   String url="jdbc:mysql://localhost:3306/test";
			   String uname="root";
			   String pass="root123";
			   Cookie[] cookie=req.getCookies();
			   String tname="";
			   String urname="";
			   int id=0;
			   for(int i=0;i<cookie.length;i++) {
				   if((cookie[i].getName()).equals("testname")) {
					   tname=cookie[i].getValue();
				   }
				   if((cookie[i].getName()).equals("Uname")) {
					   urname=cookie[i].getValue();
				   }
				   if((cookie[i].getName()).equals("id")) {
					   id=Integer.parseInt(cookie[i].getValue());
				   }
			   }
			   
			   String query="select crt_option from `questions` where subl='"+tname+"'";
			   
		       Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pass);
		       Statement st=con.createStatement();
		       ResultSet rs=st.executeQuery(query);
		       Enumeration paramNames=req.getParameterNames();
		       String[] paramValues;
		       String paramName="";
		       String crt2="";
		       int count=0;
		       while(rs.next()&& paramNames.hasMoreElements()) {
		    	   String crt=String.valueOf(rs.getInt("crt_option"));
		    	   paramName=(String)paramNames.nextElement();
		    	   paramValues=req.getParameterValues(paramName);
		    	   for(int i=0;i<paramValues.length;i++) {
		    		    crt2=paramValues[i];
		    	   }
		    	   if(crt.equals(crt2)) {
		    		   count++;
		    	   }
		       }
		       java.util.Date dt=new java.util.Date();
		       java.sql.Date date=new java.sql.Date(dt.getTime());
		       String query2="update `user` set `user_marks`="+count+" ,`sub_date`='"+date+"' where `user_id`="+id+"; ";
		       st.executeUpdate(query2);
		       for(int i=0;i<cookie.length;i++) {
				   cookie[i].setMaxAge(0);
				   res.addCookie(cookie[i]);
			   }		       
		       out.println("<div style=\"margin-top:200px;\"><h2 style=\"text-align:center;   font-family:arial;\">Congratulations!</h1></br><p style=\"text-align:center; color:green; font:15px; font-family:arial;\">You scored:"+count+"</p></div>");
		       out.println("<a href=\"Main.html\" style=\"text-decoration:none;border:1px solid black;padding:5px 10px; text-align:center; margin-left:650px\">Ok</a>");
		}catch(Exception e) {e.printStackTrace();} 
	}
}
