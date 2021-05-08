package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileLibUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;
import com.mysql.cj.util.LogUtils;

public class TC_1_createOrganization_Test  extends BaseClass
{
	WebdriverUtility wutil=new WebdriverUtility();
	JavaUtility javautil=new JavaUtility();
	FileLibUtility file=new FileLibUtility();
	ExcelUtility efile=new ExcelUtility();
	@Test
	public void createOrganization() throws InterruptedException, IOException, InvalidFormatException
	{
		// navigating to Organisations page
		driver.findElement(By.linkText("Organizations")).click();
		// creating new organisation (+) symbol
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String value = efile.getExcelData("Creating New Organization", 1, 0);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value+javautil.getRandomData() );
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		 WebElement element1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		 wutil.waitForElementVisibility(driver, element1);
		 String actualResult=element1.getText();
		 System.out.println(actualResult);
		boolean res = value.contains(actualResult);
		System.out.println(res);
		/*if(value.contains(actualResult))
		{
			Reporter.log("organisation is created", true);
		}
		else
		{
			Assert.fail();
		}*/
		
	}

}
