import java.sql.*;



public class q2 {
	public static void main (String args[]) {
		//String dbName = "Department";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			String query1 = "SELECT * FROM `student` WHERE cgpa < 9";
			String query3 = "Select * from student";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			while(rs.next()) {
				String name = rs.getString(2);
				double cgpa = rs.getDouble(1);
				System.out.println("NAME, CGPA : "+ name + ", " + cgpa);
			}
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query3);
			System.out.println("Updated");
			while(rs.next()) {
				if(rs.getString(2).equals("John")){
					rs.updateDouble("cgpa", 8.9);
					rs.updateRow();
				}
				//int usn = rs.getInt(1);
				String name = rs.getString(2);
				double cgpa = rs.getDouble(1);
				System.out.println("NAME, CGPA : " + name + ", " + cgpa);
				
			}
			
			
			
			
//			rs = st.executeQuery(query3);
//			System.out.println("After update: ");
//			while(rs.next()) {
//				int usn = rs.getInt(1);
//				String name = rs.getString(2);
//				double cgpa = rs.getDouble(3);
//				System.out.println("USN, NAME, CGPA : " + usn + ", " + name + ", " + cgpa);
//			}
//			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}