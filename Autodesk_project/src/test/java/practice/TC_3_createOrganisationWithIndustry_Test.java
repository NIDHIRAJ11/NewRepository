package practice;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileLibUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;

public class TC_3_createOrganisationWithIndustry_Test  extends BaseClass
{
	WebdriverUtility wutil=new WebdriverUtility();
	JavaUtility javautil=new JavaUtility();
	FileLibUtility file=new FileLibUtility();
	ExcelUtility efile=new ExcelUtility();
	@Test
	public void createOrganisationWithIndustry() throws InterruptedException, IOException, InvalidFormatException
	{
		// navigating to Organisations page
		driver.findElement(By.linkText("Organizations")).click();
		// creating new organisation (+) symbol
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String value = efile.getExcelData("Creating New Organization", 1, 0);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value+javautil.getRandomData() );
		WebElement industry = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		wutil.selectOption(industry, 5);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
