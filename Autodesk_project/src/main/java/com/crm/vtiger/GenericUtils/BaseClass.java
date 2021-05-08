package com.crm.vtiger.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.crm.vtiger.GenericPOM.LoginPage;
import com.crm.vtiger.HomePagePomClass.HomePage;
/**
 * 
 * @author Nidhiraj
 *
 */
public class BaseClass 
{
	public WebdriverUtility wutil=new WebdriverUtility();
	public JavaUtility javautil=new JavaUtility();
	public FileLibUtility file=new FileLibUtility();
	public ExcelUtility efile=new ExcelUtility();

	public  WebDriver driver=null;
	public static WebDriver staticDriver;
	//@Parameters("browser")
	@BeforeTest(groups = { "smokeTest","regressionTest"})
	public void OpenBrowser()
	{
		// Launch the browser
		 driver=new ChromeDriver();


/*
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		*/
		staticDriver=driver;
		driver.manage().window().maximize();
		wutil.waitUntilPageLoad(driver);
	}


	@BeforeMethod(groups = { "smokeTest","regressionTest"})
	public void loginToApplication() throws Throwable
	{
		// Get the URL
		String url = file.getPropertyData("url");
		driver.get(url);
		// Login to  Vtiger application
		String username = file.getPropertyData("username");
		wutil.waitForElementVisibility(driver, driver.findElement(By.name("user_name")));
		String password = file.getPropertyData("password");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.Login(username, password);

	}



	@AfterMethod(groups = { "smokeTest","regressionTest"})
	public void logoutOfApplication() throws InterruptedException
	{
		//logout of the application
		wutil.sleep(2000);
		// WebElement logout = driver.findElement(By.xpath("(//td[@valign=\"bottom\"])[2]"));
		//wutil.waitForElementVisibility(driver, logout);
		//logout.click();
		//WebElement clickLogout = driver.findElement(By.xpath("//a[.='Sign Out']"));
		//wutil.waitForElementVisibility(driver, clickLogout);
		//clickLogout.click();
		
		HomePage homepage=new HomePage(driver);
		homepage.logout();
	}

	@AfterTest(groups = { "smokeTest","regressionTest"})
	public void closeBrowser()
	{
		// close the browser
		driver.close();
	}



}
