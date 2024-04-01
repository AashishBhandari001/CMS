package CourseManagementSystem;
import java.sql.DriverManager;
import java.sql.*;

public class Main{

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
			
			new login_page();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		//creating a query
		
	}

}
