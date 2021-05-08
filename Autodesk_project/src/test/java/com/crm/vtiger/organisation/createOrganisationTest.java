package com.crm.vtiger.organisation;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.CreatingNewOrganizationPage;
import com.crm.vtiger.OrganizationsPage;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileLibUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;
import com.crm.vtiger.HomePagePomClass.HomePage;
import com.crm.vtiger.OrganizationsPagePomClass.OrganizationInformationPage;

public class createOrganisationTest extends BaseClass
{

	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganization() throws InterruptedException, IOException, InvalidFormatException
	{
		// navigating to Organisations page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();
		// creating new organisation (+) symbol
		OrganizationsPage OrgPage=new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrganisationSymbol();
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		createOrgPage.createOrganisation(OrgName);
		// verification
		OrganizationInformationPage OrgInf=new OrganizationInformationPage(driver);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
	}

	//----------------------------------------------------------------------------------------------------------------------------------------

	@Test(groups = "regressionTest" , enabled=true)
	public void createOrganisationWithIndustry() throws Throwable
	{
		// navigating to Organisations page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();
		// creating new organisation (+) symbol
		OrganizationsPage OrgPage=new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrganisationSymbol();
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		String industryName = efile.getExcelData("Creating New Organization", 1, 2);
		createOrgPage.createOrganisationWithIndustry(OrgName, industryName);
		// verification
		Thread.sleep(2000);
		OrganizationInformationPage OrgInf=new OrganizationInformationPage(driver);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
		String actIndustryName = OrgInf.getIndustryNameEdit().getText();
		Assert.assertEquals(actIndustryName, industryName);
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------	

	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganisationWithIndustryDropDownTest() throws Throwable
	{
		// navigating to Organisations page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();
		// creating new organisation (+) symbol
		OrganizationsPage OrgPage=new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrganisationSymbol();
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		createOrgPage.createOrganisationWithIndustryDropDownTest(OrgName);
		// verification
		OrganizationInformationPage OrgInf=new OrganizationInformationPage(driver);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
	}


	//-------------------------------------------------------------------------------------------------------------------

	@Test(groups = "regressionTest" , enabled=true)
	public void createOrganisationWithTypeTest() throws Throwable
	{
		// navigating to Organisations page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();
		// creating new organisation (+) symbol
		OrganizationsPage OrgPage=new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrganisationSymbol();
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		createOrgPage.createOrganisationWithTypeDropDownTest(OrgName);
		// verification
		OrganizationInformationPage OrgInf=new OrganizationInformationPage(driver);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
	}

	//-----------------------------------------------------------------------------------------------------------------------------------	
	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganisationWithType() throws InterruptedException, IOException, InvalidFormatException
	{
		// navigating to Organisations page
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganisationLink();
		// creating new organisation (+) symbol
		OrganizationsPage OrgPage=new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrganisationSymbol();
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		CreatingNewOrganizationPage createOrgPage=new CreatingNewOrganizationPage(driver);
		String TypeName = efile.getExcelData("Creating New Organization", 1, 1);
		createOrgPage.createOrganisationWithType(OrgName, TypeName);
		// verification
		OrganizationInformationPage OrgInf=new OrganizationInformationPage(driver);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
		String actTypeName = OrgInf.getTypeNameEdit().getText();
		Assert.assertEquals(actTypeName, TypeName);
		
	}

}
