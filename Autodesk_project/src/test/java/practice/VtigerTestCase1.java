package practice;

import static org.testng.Assert.fail;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VtigerTestCase1 
{
	
	@Test
	public void vtigerOrganisationName()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("enter the oorganisation name : ");
		String organisation_Name=sc.nextLine();
		// open the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// get the url
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		// enter the username
		driver.findElement(By.name("user_name")).sendKeys("admin");
		// enter the password
		driver.findElement(By.name("user_password")).sendKeys("admin");
		// click on login button
		driver.findElement(By.id("submitButton")).click();
		// click on organisations
		driver.findElement(By.linkText("Organizations")).click();
		// click on + symbol to create new oraganisation.
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// enter the organisation name
		driver.findElement(By.name("accountname")).sendKeys(organisation_Name);
		// click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// verify organsation is created or not
		String orgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(organisation_Name.equals(orgName))
		{
			System.out.println(orgName + "  organisation is created successfully");
		}
		else
		{
			Assert.fail();
		}
		
		 driver.quit();
	}

}
