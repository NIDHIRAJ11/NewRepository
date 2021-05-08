package practice;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtility;


public class Sample11 

{
	JavaUtility jutil=new JavaUtility();
	
	@Test(invocationCount = 7)
	public void num()
	{
		String value = jutil.getRandomData();
		System.out.println(value);
	}

}
