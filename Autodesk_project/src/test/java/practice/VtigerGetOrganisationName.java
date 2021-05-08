package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VtigerGetOrganisationName
{
	
	@Test
	public void readOrganisationNames()
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

		List<WebElement> allOrgNames = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[3]"));

		for(WebElement names:allOrgNames)
		{
			String orgName = names.getText();
			if(!(orgName.equals("Organization Name")))
			{
				System.out.println(orgName);
			}
		}

	}

}
