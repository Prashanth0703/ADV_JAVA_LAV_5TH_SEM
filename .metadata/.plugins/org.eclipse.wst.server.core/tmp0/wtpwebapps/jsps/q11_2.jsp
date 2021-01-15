<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ page import = "java.sql.* "  %>
	
	<form name = "retrieve" action = "q11_2.jsp" method = "POST">
		<input type = "text" name = "title" placeholder = "title">
		
		<input type = "submit" value = "retrieve" name = "retrieve">
		
	</form>
	
	<%
		if(request.getParameter("retrieve") != null){
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
				String title = request.getParameter("title");
				
				String query = "SELECT * FROM book WHERE title = ?";
				

				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, title);
				ResultSet rs = st.executeQuery();
				while(rs.next()){
					int bookno = rs.getInt(1);
					String author = rs.getString(3);
					String publication = rs.getString(4);
					int price = rs.getInt(5);
					out.println("<h1>");
					out.println("Bookno: " + bookno);
					out.println("<br>");
					out.println("title: " + title);
					out.println("<br>");
					out.println("author: " + author);
					out.println("<br>");
					out.println("publication: " + publication);
					out.println("<br>");
					out.println("price: " + price);
					out.println("</h1>");
				}
				st.close();
				con.close();
				
				
			} catch(Exception e){
				e.printStackTrace();
			}
						
		}
	
	%>


</body>
</html>