package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest 
{
	@Test
	public void testCreateCustomer(XmlTest xml)
	{
		System.out.println("test create user");
		String URL = xml.getParameter("url");
		String USERNAME = xml.getParameter("username");
		String PASSWORD = xml.getParameter("password");
		String BROWSER = xml.getParameter("browser");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(BROWSER);
	}

}
