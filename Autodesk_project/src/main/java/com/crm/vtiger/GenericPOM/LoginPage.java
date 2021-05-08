package com.crm.vtiger.GenericPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.HomePagePomClass.HomePage;

public class LoginPage 
{
	public WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement userNameTbx;
	
	@FindBy(name="user_password")
	private WebElement passwordTbx;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	

	public WebElement getUserNameTbx() {
		return userNameTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to login into vtiger application
	 * @param username
	 * @param password
	 */
	public HomePage Login(String username,String password)
	{
		userNameTbx.sendKeys(username);
		passwordTbx.sendKeys(password);
		loginButton.click();
		HomePage homepage=new HomePage(driver);
		return homepage;
		
	}

}
