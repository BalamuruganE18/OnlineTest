package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Question extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String name=(String)req.getAttribute("Testname");
		boolean st=false;
		int total=0;
		Cookie[] cookies=req.getCookies();
		for(int i=0;i<cookies.length;i++) {
			   if((cookies[i].getName()).equals("count")) {
				   total=Integer.parseInt(cookies[i].getValue());
				   st=true;
			   }
		}
		total++;
		
    //    if(st) {
		out.println("<!DOCTYPE html>\r\n"
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
				+ "     margin:100px 100px 10px 300px;\r\n"
				+ "     padding:30px 45px 10px 40px;\r\n"
				+ "     border:1px solid black;\r\n"
				+ "     font-family:arial; \r\n"
				+ "     font-size:16px;\r\n"
				+ "   }\r\n"
				+ "   #butt{\r\n"
				+ "      text-decoration:none;border:1px solid black;padding:5px 10px;}"   
				+ "   #button{\r\n"
				+ "     margin-left:100px;\r\n"
				+ "     \r\n"
				+ "   }\r\n"
				+ "   .box{\r\n"
				+ "      width:700px;\r\n"
				+ "      height:30px;\r\n"
				+ "    }</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "   <div class=\"login\" >\r\n"
				+ "        \r\n"
				+ "        \r\n");
		
				out.println("<form  autocomplete=\"off\" method=\"post\" action=\"Questionsub\">    \r\n"
				+ "        <label><b>Testname     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" name=\"Testname\"  value=\""+name+"\" readonly>    \r\n"
				+ "        <br><br>    \r\n"
				+ "        <label><b>Question  "+total+"   \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" class=\"box\" name=\"question\" required>    \r\n"
				+ "        <br><br>\r\n"
				+ "        <label><b>Choice 1     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" class=\"box\" name=\"choice1\" required>    \r\n"
				+ "        <br><br>\r\n"
				+ "        <label><b>Choice 2     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" class=\"box\" name=\"choice2\"required>    \r\n"
				+ "        <br><br>\r\n"
				+ "        <label><b>Choice 3     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" class=\"box\" name=\"choice3\"required>    \r\n"
				+ "        <br><br>\r\n"
				+ "        <label><b>Choice 4     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\" class=\"box\" name=\"choice4\"required>    \r\n"
				+ "        <br><br>\r\n"
				+ "        <label><b>Correct Option     \r\n"
				+ "        </b>    \r\n"
				+ "        </label>    \r\n"
				+ "        <input type=\"text\"  name=\"crt\">    \r\n"
				+ "        <br><br>    \r\n"
				+ "        <input id=\"button\"type=\"submit\"   value=\"Save\">       \r\n"
				  
				+ "            \r\n"
				+ "    </form>     \r\n"
				+ "  </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
        /*else {
        	RequestDispatcher rd=req.getRequestDispatcher("/Admin.html");
			rd.include(req,res);
        }*/
		
	}
	
}
