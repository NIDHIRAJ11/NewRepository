package com.crm.vtiger.OrganizationsPagePomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	WebDriver driver;
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement OgrTitle;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement OrgNameEdit;

	@FindBy(xpath = "//span[@id=\"dtlview_Industry\"]")
	private WebElement industryNameEdit;
	
	@FindBy(id = "mouseArea_Type")
	private WebElement typeNameEdit;

	public WebElement getOgrTitle() {
		return OgrTitle;
	}

	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}

	public WebElement getIndustryNameEdit() {
		return industryNameEdit;
	}

	public WebElement getTypeNameEdit() {
		return typeNameEdit;
	}
	
	
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
