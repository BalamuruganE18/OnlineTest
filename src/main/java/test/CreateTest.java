package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CreateTest extends HttpServlet{
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
			out.println(" <!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<style text=\"text/css\">\r\n"
					+ "body{\r\n"
					+ "   background-color:#D3D3D3;\r\n"
					+ "  }\r\n"
					+ "  .login{\r\n"
					+ "     background-color:#FFFFFF;\r\n"
					+ "     margin:100px 450px 10px 450px;\r\n"
					+ "     padding:30px 45px 10px 40px;\r\n"
					+ "     border:1px solid black;\r\n"
					+ "     font-family:arial; \r\n"
					+ "     font-size:16px;\r\n"
					+ "   }\r\n"
					+ "   #button{\r\n"
					+ "     margin-left:100px;\r\n"
					+ "     \r\n"
					+ "   }</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "   <div class=\"login\" >\r\n"
					+ "        \r\n"
					+ "        \r\n"
					+ "    <form autocomplete=\"off\" method=\"post\" action=\"ct\">    \r\n"
					+ "        <label><b>Testname     \r\n"
					+ "        </b>    \r\n"
					+ "        </label>    \r\n"
					+ "        <input type=\"text\" name=\"Testname\"  required>    \r\n"
					+ "        <br><br>    \r\n"
					+ "        <label><b>Password     \r\n"
					+ "        </b>    \r\n"
					+ "        </label>    \r\n"
					+ "        <input type=\"Password\" name=\"Pass\" required>    \r\n"
					+ "        <br><br>    \r\n"
					+ "        <label><b>Questions     \r\n"
					+ "        </b>    \r\n"
					+ "        </label>    \r\n"
					+ "        <input type=\"text\" name=\"total\"  required>    \r\n"
					+ "        <br><br>    \r\n"
					+ "        <label><b>Time     \r\n"
					+ "        </b>    \r\n"
					+ "        </label>    \r\n"
					+ "        <input type=\"text\" style=\"margin-left:35px\" name=\"Time\"  required>    \r\n"
					+ "        <br><br>    \r\n"
					+ "        <input id=\"button\"type=\"submit\"   value=\"Submit\">       \r\n"
					+ "        <br><br>    \r\n"
					+ "            \r\n"
					+ "    </form>     \r\n"
					+ "  </div>\r\n"
					+ "</body>\r\n"
					+ "</html>"); 
			
			out.close();
			 
		}
	} 

}
