package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Nidhiraj
 *
 */
public class OrganizationsPage 
{
	WebDriver driver;
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement createOrganisationSymbol;

	public WebElement getCreateOrganisationSymbol() {
		return createOrganisationSymbol;
	}
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used to click on + symbol to create new organisation
	 */
	public CreatingNewOrganizationPage clickOnCreateOrganisationSymbol()
	{
		createOrganisationSymbol.click();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		return createOrgPage;
	}
}
