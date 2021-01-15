import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class Q5
 */
@WebServlet("/q5")
public class q5 extends HttpServlet {
	final static long serialVersionUID=1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String fullName = request.getParameter("fullName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = initials(fullName);
		out.println(name);
		
	}
	private String initials(String fullName) {
		String[] name = fullName.trim().split("\s");
		for(String i:name)
			System.out.println(i);
		String initial = "" ;
		for(String i : name) {
//			initial += String.valueOf(i.charAt(0));
			initial += i.charAt(0);
		}		
		return initial.toUpperCase();
	}
}