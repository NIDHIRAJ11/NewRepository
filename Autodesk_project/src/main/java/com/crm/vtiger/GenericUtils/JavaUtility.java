package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/**
	 * This method generates the random data
	 * @return
	 */
	public String getRandomData()
	{
		Random random=new Random();
		int ran = random.nextInt(1000000);
		return ""+ran;
	}
	
	/**
	 * This method returns current system date
	 * @return
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate = date.toString();
		return currentDate;
		
	}

}
