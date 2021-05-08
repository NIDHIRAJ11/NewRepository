package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils3
{
	Connection con=null;
	@Test
	public void getUpdateQuery() throws SQLException
	{
		try 
		{
			//Step 1: Register the database
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);

			//Step 2: establish Connection with database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");

			//Step 3: Issue create statement
			Statement stat=con.createStatement();

			//Step 4: Execute any query
			 int result = stat.executeUpdate("insert into student(student_name,student_id,student_place) values('raj',008,'kanakapura');");
			if(result==1)
			{
				System.out.println("data base updated , number of row affected is "+result);
			}
			else
			{
				System.out.println("data base not updated ");
			}
		}

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