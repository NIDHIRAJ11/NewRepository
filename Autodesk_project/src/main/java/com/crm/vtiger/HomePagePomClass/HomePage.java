package com.crm.vtiger.HomePagePomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.OrganizationsPage;
import com.crm.vtiger.GenericUtils.WebdriverUtility;

/**
 * 
 * @author Nidhiraj
 *
 */
public class HomePage extends WebdriverUtility
{
	WebDriver driver;
	
	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath = "//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement administaratorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutLink;

	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getAdministaratorIcon() {
		return administaratorIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used to click on oraganisation link in home page of vtiger
	 */
	public OrganizationsPage clickOnOrganisationLink()
	{
		organisationLink.click();
		OrganizationsPage ogrPage=new OrganizationsPage(driver);
		return ogrPage;
	}
	
	/**
	 * this methid is sed to logout of vtiger application
	 */
	public void logout()
	{
		mouseOver(driver, administaratorIcon);
		logoutLink.click();
	}

}
