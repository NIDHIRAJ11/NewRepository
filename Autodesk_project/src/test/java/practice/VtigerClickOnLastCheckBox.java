package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VtigerClickOnLastCheckBox 
{
	

	@Test
	public void clickLastBox() throws InterruptedException
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
		// select all the check box to select last boxe.
		List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int count = allBoxes.size();
		// click on last check box
		allBoxes.get(count-1).click();
		Thread.sleep(3000);
		// close the browser
		driver.close();

	}
}
