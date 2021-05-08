package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtil2
{
	Connection con=null;
	@Test
	public void getExecuteQuery() throws SQLException
	{
		try 
		{
			Scanner sc=new Scanner(System.in);
			System.out.print("enter the string : ");
			String s1=sc.nextLine();
			//Step 1: Register the database
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);

			//Step 2: establish Connection with database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");

			//Step 3: Issue create statement
			Statement stat=con.createStatement();

			//Step 4: Execute any query
			ResultSet result = stat.executeQuery("select * from customers;");
			while(result.next())
			{
				if(result.getString(1).equals(s1))
				{
					System.out.println(s1 +" is present is database ");
				}
			}
		}
			// handling the exception.
		catch(Exception e)
		{

		}
		
		finally
		{

			//Step 5: Close database connection
			con.close();
		}
	}


}
