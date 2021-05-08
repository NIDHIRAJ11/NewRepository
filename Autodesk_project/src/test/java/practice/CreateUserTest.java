package practice;

import org.testng.annotations.Test;

public class CreateUserTest 
{
	@Test
	public void userTest()
	{
		String NAME=System.getProperty("name");
		String COMPANY=System.getProperty("company");
		String MAILID=System.getProperty("mailid");
		String CONTACT=System.getProperty("contact");
		
		System.out.println(NAME);
		System.out.println(COMPANY);
		System.out.println(MAILID);
		System.out.println(CONTACT);
	}

}
