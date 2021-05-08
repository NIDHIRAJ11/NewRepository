package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VtigerClickAllBoxes
{
	
	@Test
	public void clickAllBoxes() throws InterruptedException
	{
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
		// click on select all check box to select all boxes.
		// driver.findElement(By.id("selectCurrentPageRec")).click();
		
		List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=1;i<allBoxes.size();i++)
		{
			allBoxes.get(i).click();
			Thread.sleep(1000);
		}
		
		
		driver.quit();
	}

}
