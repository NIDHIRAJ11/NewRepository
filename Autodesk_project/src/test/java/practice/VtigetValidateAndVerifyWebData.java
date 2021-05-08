package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VtigetValidateAndVerifyWebData 
{
	
	@Test
	public void ValidateWebData()
	{
		// open the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String expectedData="cyntra";
		Boolean flag=false;
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
		List<WebElement> allWebData = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		
		for(WebElement data : allWebData)
		{
			String actualData = data.getText();
			if(actualData.contains(expectedData))
			{
				data.click();
				flag=true;
				
			}
		}
		
		if(flag)
		{
			System.out.println("web data is present in web page");
		}
		else
		{
			System.out.println("web data is not present");
		}
		
		driver.close();
	}

}
