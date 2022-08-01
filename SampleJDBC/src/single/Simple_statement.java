package single;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Simple_statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22";
		String user="narmadhae";
		String password="narmadhae@2026";
		Connection connection=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22;integratedSecurity=false;encrypt=false;trustServiceCertificate=false","narmadhae","narmadhae@2026");
			Statement simpleStatement = connection.createStatement();
			ResultSet resultSet= simpleStatement.executeQuery("select top 10 * from Employees");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("FirstName")+" "+resultSet.getString("LastName"));
			}
			resultSet.close();
			simpleStatement.close();
			connection.close();
		}
		catch (Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
		}

	}

}
