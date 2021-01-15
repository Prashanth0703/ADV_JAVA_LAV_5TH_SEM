import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class q6
 */
@WebServlet("/q6")
public class q6 extends HttpServlet {
	final static long serialVersionUID=1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		Connection conn;
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String n = request.getParameter("n");
			String ad = request.getParameter("addr");
			String dob = request.getParameter("dob");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			PreparedStatement p=conn.prepareStatement("insert into emp values (?,?,?,?)");
			p.setInt(1,id);
			p.setString(2, n);
			p.setString(3, ad);
			p.setString(4, dob);
			p.executeUpdate();
			PrintWriter out = response.getWriter();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from emp");
			out.println("<table border=1>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>");
				out.println("</tr>");
			}
			out.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
