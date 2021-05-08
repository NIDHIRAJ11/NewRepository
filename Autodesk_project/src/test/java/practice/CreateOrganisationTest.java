package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganisationTest 
{
	@Test
	public void createOrganisation() throws InterruptedException
	{
		// launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// get url
		driver.get("http://localhost:8888/");
		
		// login to vtiger application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// navigate to organisation page
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("TechSoft5");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(6000);
		
		//logout of the application
		driver.findElement(By.xpath("(//td[@valign=\"bottom\"])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		//close the browser
		driver.quit();
		
	}
	

}
