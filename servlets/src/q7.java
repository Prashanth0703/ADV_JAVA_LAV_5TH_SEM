import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q7
 */
@WebServlet("/q7")
public class q7 extends HttpServlet {
	final static long serialVersionUID=1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		sub_id sub_name, fac_id
		response.setContentType("text/html");
		String sub_id = (request.getParameter("sub_id"));
		String sub_name = request.getParameter("sub_name");
		String fac_id = (request.getParameter("fac_id"));
		
		System.out.println(sub_id + " " + sub_name + " " + fac_id);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			String query1 = "UPDATE subject SET `s_id`= ? ,`s_name` = ? WHERE f_id = ? ";
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setString(1, sub_id);
			ps.setString(2, sub_name);
			ps.setString(3, fac_id);
			int a = ps.executeUpdate();
			System.out.println(a+" rows updated");
			String query2 = "select * from subject";
			ResultSet rs = ps.executeQuery(query2);
			PrintWriter out = response.getWriter();
			while(rs.next()) {
				sub_id = rs.getString(1);
				sub_name = rs.getString(2);
				fac_id = rs.getString(3);
				String fin = "<h2>sub_id, sub_name, fac_id: " + sub_id + ", " + sub_name + ", " + fac_id + "</h2><br>";
				out.println(fin);
			}
			rs.close();
			out.println("<a href="+"'"+"empdet.html"+"'"+">Click</a>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}