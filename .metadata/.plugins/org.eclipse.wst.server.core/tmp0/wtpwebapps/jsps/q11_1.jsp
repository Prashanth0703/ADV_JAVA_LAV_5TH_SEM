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
	
	<form name = "insert_data" action = "q11_1.jsp" method = "POST">
		<input type = "text" name = "bookno" placeholder = "bookno">
		<input type = "text" name = "title" placeholder = "title">
		<input type = "text" name = "author" placeholder = "author">
		<input type = "text" name = "publication" placeholder = "publication">
		<input type = "text" name = "price" placeholder = "price">
		
		<input type = "submit" value = "insert" name = "insert">
		
	</form>
	
	
	<%
		if(request.getParameter("insert") != null){
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
				int bookno = Integer.parseInt(request.getParameter("bookno"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String publication = request.getParameter("publication");
				int price = Integer.parseInt(request.getParameter("price"));
				
				String query = "INSERT INTO book VALUES (?, ?, ?, ?, ?)";
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,bookno );
				ps.setString(2, title);			
				ps.setString(3, author);			
				ps.setString(4, publication);			
				ps.setInt(5, price);
				int a = ps.executeUpdate();
				ps.close();
				if(a==1){
					out.println("Inserted book Successfully..");
					out.println("<a href="+"'"+"q11_2.jsp"+"'>"+"click here for getting the book details by entering title!</a>");
				}
					//response.wait();
				//response.sendRedirect("q11_2.jsp"); 
			} catch(Exception e){
				e.printStackTrace();
			}
						
		}
		
	%>
	


</body>
</html>