import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Police
 */
@WebServlet("/q4")
public class q4 extends HttpServlet {
	static final long serialVersionUID=1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int n = Integer.parseInt(request.getParameter("n"));
		String s = request.getParameter("ap");
//		System.out.println(n + " " + s);
		//String driver="com.mysql.jdbc.Driver";
		Connection conn = null;
		try {
			//Class.forName(driver).newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
			
			Statement st = conn.createStatement();
			ResultSet rs = null;
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			if(n == 1) {//area
				String query = "select phno from police where area = \"" + s + "\"";
				rs = st.executeQuery(query);
				while(rs.next()) {
					out.print("Area : " + s + ", Phone No: " + rs.getInt(1));
				}
			} else { //phone
				String query = "select area from police where phno = "+ s ;
				rs = st.executeQuery(query);
				while(rs.next()) {
					out.print("Area : " + rs.getString(1) + ", Phone No: " + s);
				}
			
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}