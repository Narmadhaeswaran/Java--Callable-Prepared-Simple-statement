package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prepared_statement {

	

	public static void main(String[] args) {
		String url="jdbc:sqlserver://ec2-54-191-44-79.us-west-2.compute.amazonaws.com;databaseName=TrainingApril22";
		String user="narmadhae";
		String password="narmadhae@2026";
		Connection connection=null;
		ResultSet rs=null;
		try {
			
			connection = DriverManager.getConnection(url,user,password);
			Statement preparedStatement = connection.createStatement();
			ResultSet rs1=preparedStatement.executeQuery("select * from Employees WHERE FirstName='Robert'");
			while(rs1.next()) {
				System.out.println(rs1.getString("Title")+" "+rs1.getString("TitleOfCourtesy"));
			}
			rs1.close();
			preparedStatement.close();
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
		}

	}

}
