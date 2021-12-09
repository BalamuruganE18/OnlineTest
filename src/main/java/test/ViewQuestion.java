package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewQuestion extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		try{
		       PrintWriter out=res.getWriter();
     		   res.setContentType("text/html");
			   String url="jdbc:mysql://localhost:3306/test";
			   String uname="root";
			   String pass="root123";
			   Cookie[] cookie=req.getCookies();
			   String tname="";
			   int id=0;
			   for(int i=0;i<cookie.length;i++) {
				   if((cookie[i].getName()).equals("testname")) {
					   tname=cookie[i].getValue();
				   }
				   if((cookie[i].getName()).equals("id")) {
					   id=Integer.parseInt(cookie[i].getValue());
				   }
			   }
			   String query="select * from `questions` where subl='"+tname+"'";
			   String query2="select test_min from `create_test` where name='"+tname+"'";
		       Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection(url,uname,pass);
		       Statement st=con.createStatement();
		       
		       ResultSet rs2=st.executeQuery(query2);
		       int timer=0;
		       while(rs2.next()) {
		    	   timer=rs2.getInt("test_min");
		       }
		       int n=1;
		       ResultSet rs=st.executeQuery(query);
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
		    			
		    			+ "   <div class=\"login\" >\r\n"
		    			+ "        \r\n"
		    			+ "        \r\n"
		    			
		    			+ "    <form style=\"margin-left:200px\" method=\"post\" name=\"test\" action=\"xyz\">    \r\n"
		    			+ "        <label><b> Questions</b></label><br>\r\n"
		    			+ "        <br><br>\r\n"
		    			+ "         <div id=\"time\" style=\"color:red;font-size:12px;\"></div>"
		    			+ "<br><br>"
		    			+ "<script type=\"text/javascript\"> \r\n"
		    			+ "		    	 let total="+timer*60+";\r\n"
		    			+ "		         let min=parseInt(total/60);\r\n"
		    			+ "		         let sec=parseInt(total%60);\r\n"
		    			+ "		         console.log(total);\r\n"
		    			+ "		         function add(){\r\n"
		    			+ "		        	 document.getElementById(\"time\").innerHTML='Timer-left:'+min+'minutes:'+sec+'seconds';\r\n"
		    			+ "		        	 if(total<=0){setTimeout('document.test.submit()',1);}\r\n"
		    			+ "		        	 else{\r\n"
		    			+ "		        		 total--;\r\n"
		    			+ "		        		 min=parseInt(total/60);\r\n"
		    			+ "				         sec=parseInt(total%60);\r\n"
		    			+ "				         setTimeout(add,1000);\r\n"
		    			+ "		        	 }\r\n"
		    			+ "		         }\r\n"
		    			+ "		         window.setTimeout(add,1000);\r\n"
		    			+ "	</script>");
		       
		       while(rs.next()) {
		    	   
		    	  String s="q"+String.valueOf(n);
		    			out.println("        <label>"+n+"."+rs.getString("question")+"</label><br>    \r\n"
		    			+ "        <input type=\"radio\" name="+s+"  value=\"1\" >"+rs.getString("choice1")+"<br>\r\n"
		    			+ "        <input type=\"radio\" name="+s+"  value=\"2\" >"+rs.getString("choice2")+"<br>\r\n"
		    			+ "        <input type=\"radio\" name="+s+"  value=\"3\" >"+rs.getString("choice3")+"<br>\r\n"
		    			+ "        <input type=\"radio\" name="+s+"  value=\"4\" >"+rs.getString("choice4")+"<br>    \r\n"
		    			+ "        <br><br>    \r\n");
		    			n++;
		      }
		       out.println("        \r\n"
   			+ "            \r\n"
   			+ "        <input type=\"submit\"   value=\"Submit\">       \r\n"
   			+ "            \r\n"
   			+ "            \r\n"
   			+ "    </form>     \r\n"
   			+ "  </div>\r\n"
   			+ "</body>\r\n"
   			+ "</html>");   
 
		       
		}catch(Exception e) {e.printStackTrace();} 
		       
	}
}