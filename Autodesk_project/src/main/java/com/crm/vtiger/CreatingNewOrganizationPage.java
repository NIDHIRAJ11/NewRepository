package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtility;
import com.crm.vtiger.OrganizationsPagePomClass.OrganizationInformationPage;
/**
 * 
 * @author Nidhiraj
 *
 */
public class CreatingNewOrganizationPage extends WebdriverUtility 
{
	WebDriver driver;
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement OrgNameTextField;
	
	@FindBy(xpath = "//select[@name=\"industry\"]")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//select[@name=\"accounttype\"]")
	private WebElement TypeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;

	public WebElement getOrgNameTextField() {
		return OrgNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to create an organisation
	 * @param OrgName
	 */
	public OrganizationInformationPage createOrganisation(String OrgName)
	{
		OrgNameTextField.sendKeys(OrgName);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	/**
	 * this method is used to check Type dropDown is working or not in Organaisation page
	 * @param OrgName
	 * @throws Throwable
	 */
	public OrganizationInformationPage createOrganisationWithTypeDropDownTest(String OrgName) throws Throwable
	{
		OrgNameTextField.sendKeys(OrgName);
		waitAndClick(TypeDropDown);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	/**
	 * this method create organisation with TYPE
	 * @param OrgName
	 * @param TypeName
	 */
	public OrganizationInformationPage createOrganisationWithType(String OrgName,String TypeName)
	{
		OrgNameTextField.sendKeys(OrgName);
		selectOption(TypeDropDown, TypeName);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	
	/**
	 * this method is used to create organisation with industry
	 * @param OrgName
	 * @param IndustryName
	 */
	public OrganizationInformationPage createOrganisationWithIndustry(String OrgName,String IndustryName)
	{
		OrgNameTextField.sendKeys(OrgName);
		selectOption(IndustryDropDown, IndustryName);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	/**
	 * this method is used to check Indystry DropDown is working or not 
	 * @param OrgName
	 * @throws Throwable
	 */
	public OrganizationInformationPage createOrganisationWithIndustryDropDownTest(String OrgName) throws Throwable
	{
		OrgNameTextField.sendKeys(OrgName);
		waitAndClick(IndustryDropDown);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	
	
}

