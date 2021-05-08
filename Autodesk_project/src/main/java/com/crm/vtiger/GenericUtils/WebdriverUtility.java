package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility
{
	/**
	 * This method waits the driver for 10 seconds to load the webpage
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method waits for given time duration
	 * @param seconds
	 * @throws InterruptedException
	 */
	public void sleep(int seconds ) throws InterruptedException
	{
		Thread.sleep(seconds);
	}

	/**
	 * This method will till web element is visible for 10 sec
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/**
	 * This method waits to click on particular web element
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<100)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				count++;
				Thread.sleep(1500);
			}
		}
	}

	/**
	 * this method enables user to handle dropdown listbox using index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);

	}


	/**
	 * this method enables user to handle dropdown listbox using visible text
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);

	}


	/**
	 * this method will do the mouse over action.
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method will swith the control to another window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		while(it.hasNext())
		{
			String windowId = it.next();
			String title = driver.switchTo().window(windowId).getTitle();
			if(title.contains(partialWindowTitle))
			{
				break;

			}
		}
	}

	/**
	 * accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * Cancel alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}

	/**
	 * this method performs the right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * this method is used for scroll option in webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}

	/**
	 * swith to frame using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * swith to frame using webelement
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * swith to frame using id Or Name of frame
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String idOrName )
	{
		driver.switchTo().frame(idOrName);
	}

	/**
	 * this method is used to take the screen shot
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		 TakesScreenshot ts= (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File target=new File("./screenShot/"+screenShotName+".PNG");
		 Files.copy(source, target); 
	}
	/**
	 * press on enter key
	 * @throws AWTException
	 */
	public void pressKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}




}
