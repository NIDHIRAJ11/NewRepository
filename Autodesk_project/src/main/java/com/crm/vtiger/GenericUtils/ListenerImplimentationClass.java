package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentationClass implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String failedTestName = result.getMethod().getMethodName();
		String currentSysDate = new Date().toString().replace(" ", "_").replace(":", "_");
		EventFiringWebDriver e=new EventFiringWebDriver(BaseClass.staticDriver);
		File sourceDestnation = e.getScreenshotAs(OutputType.FILE);
		File destinationPath= new File("./screenshot/"+failedTestName+"_"+currentSysDate+".png");
		try 
		{
			FileUtils.copyFile(sourceDestnation, destinationPath);
		} catch (IOException e1) 
		{
				
		}

	}

}
