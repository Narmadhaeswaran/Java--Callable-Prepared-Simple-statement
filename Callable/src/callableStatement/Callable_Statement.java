package callableStatement;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Callable_Statement {

	public static void main(String[] args) {
		
		String url="jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22";
		String user="narmadhae";
		String password="narmadhae@2026";
		ResultSet rs=null;
		
		try {
			Connection con=DriverManager.getConnection(url,user,password);
			CallableStatement cs=con.prepareCall("{call [Ten Most Expensive Products]()}");
			
			
			rs=cs.executeQuery();
			
			while(rs.next()) {
				System.out.println("UnitPrice is:"+" "+rs.getString("UnitPrice"));
			}
		}
		
			catch (Exception e) {
				System.out.println("catch block");
				e.printStackTrace();
			}
		
		
		}

}
