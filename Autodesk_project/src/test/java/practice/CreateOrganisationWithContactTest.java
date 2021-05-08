package practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganisationWithContactTest
{
	@Test
	public void CreateOrganisationWithContact() throws InterruptedException
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

		// navigate to contact page
		String mainWh = driver.getWindowHandle();
		String mainBrowserTitle = driver.getTitle();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("raj");
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();

		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			driver.switchTo().window(wh);
			String currentwh = driver.getWindowHandle();
			if(!(currentwh.equals(mainWh)))
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[.='infosys']")).click();

			}

		}
		driver.switchTo().window(mainWh);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//logout of the application
		driver.findElement(By.xpath("(//td[@valign=\"bottom\"])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();


		//close the browser
		driver.quit();

	}

}
