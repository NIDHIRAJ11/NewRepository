package com.crm.vtiger.organisation;



import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileLibUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;

@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentationClass.class)
public class searchOrganizationTest extends BaseClass
{
	WebdriverUtility wutil=new WebdriverUtility();
	JavaUtility javautil=new JavaUtility();
	FileLibUtility file=new FileLibUtility();
	ExcelUtility efile=new ExcelUtility();
	
	
	@Test(groups = "smokeTest")
	public void filterTheOrganizationByProspectAccounts() throws Throwable
	{
		String prospectAccount=efile.getExcelData("org", "TC_26", "Filter");
		

		//Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Navigate to organization",true);

		//FilterOrganizationByProspectAccounts
		WebElement filter = driver.findElement(By.xpath("//select[@name='viewname']"));
		Reporter.log("Click on Filters",true);
		wutil.mouseOver(driver, filter);
		Reporter.log("Performing mouse over operation",true);


		//driver.findElement(By.xpath("//option[.='Prospect Accounts']")).click();
		driver.findElement(By.xpath("//select[@name='viewname']")).sendKeys(prospectAccount);
		Reporter.log("Click on Prospect Accounts",true);

		//verification
		String expData=driver.findElement(By.xpath("//option[.='Prospect Accounts']")).getText();
		Assert.assertTrue(expData.contains(prospectAccount));
		Reporter.log("Validation passed",true);
	}
	
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	@Test(groups = "smokeTest")
	public void searchTheOrganizationByOrganizationName() throws Throwable
	{
		String orgname = efile.getExcelData("org","TC_27", "organization");
		String organizationname = efile.getExcelData("org", "TC_27", "organizationname");

		//Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Organization found",true);

		//Search the organization by OrganizationName
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		Reporter.log("Click on serach organization",true);
		WebElement search = driver.findElement(By.xpath("//td/div/select[@name='search_field']"));
		Reporter.log("Click on search",true);
		wutil.mouseOver(driver, search);
		Reporter.log("mouse over operation performed",true);	
		//	driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']/option[@label='Organization Name']")).click();
		driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']")).sendKeys(organizationname);
		Reporter.log("click on industry type",true);

		//Validation
		String expData=driver.findElement(By.xpath("//select[@id='bas_searchfield']")).getText();
		Assert.assertTrue(expData.contains(organizationname));
		Reporter.log("Validation2 passed",true);
		//Step5:Click on search
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Reporter.log("Click on submit button",true);
	}
	

//--------------------------------------------------------------------------------------------------------------------------------------------------	
	
	@Test(groups = "regressionTest")
	public void searchTheOrganizationByPhone() throws Throwable
	{
		String orgname = efile.getExcelData("org", "TC_28", "organization");
		String phone = efile.getExcelData("org", "TC_28", "organizationphone");
		//Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Organization found",true);

		//Step4:Search the organization by Phone
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		Reporter.log("search the orgname",true);
		WebElement search = driver.findElement(By.xpath("//td/div/select[@name='search_field']"));
		Reporter.log("Click on in field",true);
		wutil.mouseOver(driver, search);
		Reporter.log("performed mousehover action",true);
		//driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']/option[@label='Phone']")).click();
		driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']")).sendKeys(phone);
		Reporter.log("Search the organization by phone",true);

		//Step5:Click on search
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Reporter.log("Click on submit",true);

		//Validations
		String expData=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")).getText();
		Assert.assertTrue(expData.contains(phone));
		Reporter.log("Validation passed",true);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	@Test(groups = "regressionTest")
	public void searchTheOrganizationByWebsite() throws Throwable
	{
		String orgname = efile.getExcelData("org", "TC_29", "organization");
		String website = efile.getExcelData("org", "TC_29", "organizatonname");
		//Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Organization found",true);

		//Search the organization by Website
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		Reporter.log("serach for organization",true);
		WebElement search = driver.findElement(By.xpath("//td/div/select[@name='search_field']"));
		wutil.mouseOver(driver, search);
		Reporter.log("Mouseover opertaion perform",true);
		//driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']/option[@label='Website']")).click();
		driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']")).sendKeys(website);
		Reporter.log("Click on website",true);

		//Click on search
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Reporter.log("Click on submit",true);

		//Validation
		String expData=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")).getText();
		Assert.assertTrue(expData.contains(website));
		Reporter.log("Validation passed",true);
	}
	
	
}


