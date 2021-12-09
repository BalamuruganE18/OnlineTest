package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ALogin extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		String username="Bala";
		String password="root123";
		if(username.equals(req.getParameter("Uname"))&& password.equals(req.getParameter("Pass"))) {
		  Cookie cookie=new Cookie("username",username);
		  res.addCookie(cookie);
		  RequestDispatcher rd=req.getRequestDispatcher("/Admin.html");
		  rd.include(req, res);
		}
		else {
			PrintWriter out=res.getWriter();
			 res.setContentType("text/html");
			 out.println(" <p style=\"text-align:center;font-family:arial; color:red;padding-top:10px;\">Invalid Password/username!</p>"); 
			RequestDispatcher rd=req.getRequestDispatcher("/ALogin.html");
			 rd.include(req, res);
			 out.close();
			 
		}
	}

}
