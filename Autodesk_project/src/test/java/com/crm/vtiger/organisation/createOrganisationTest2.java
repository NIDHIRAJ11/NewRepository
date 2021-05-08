package com.crm.vtiger.organisation;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class createOrganisationTest2 extends BaseClass
{

	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganization() throws InterruptedException, IOException, InvalidFormatException
	{
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		HomePage homePage=new HomePage(driver);
		OrganizationInformationPage OrgInf = homePage.clickOnOrganisationLink().clickOnCreateOrganisationSymbol().createOrganisation(OrgName);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);

	}

	//----------------------------------------------------------------------------------------------------------------------------------------

	@Test(groups = "regressionTest" , enabled=true)
	public void createOrganisationWithIndustry() throws Throwable
	{
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		HomePage homePage=new HomePage(driver);
		OrganizationInformationPage OrgInf = homePage.clickOnOrganisationLink().clickOnCreateOrganisationSymbol().createOrganisationWithIndustry(OrgName, "Finance");
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
		String actIndustryName = OrgInf.getIndustryNameEdit().getText();
		Assert.assertEquals(actIndustryName, "Finance");
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------	
	
	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganisationWithIndustryDropDownTest() throws Throwable
	{
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		HomePage homePage=new HomePage(driver);
		OrganizationInformationPage OrgInf = homePage.clickOnOrganisationLink().clickOnCreateOrganisationSymbol().createOrganisationWithIndustryDropDownTest(OrgName);
		Reporter.log("industry dropdown is displayed , test is pass ",true);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
	}


	//-------------------------------------------------------------------------------------------------------------------
	
	@Test(groups = "regressionTest" , enabled=true)
	public void createOrganisationWithTypeTest() throws Throwable
	{
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		HomePage homePage=new HomePage(driver);
		OrganizationInformationPage OrgInf = homePage.clickOnOrganisationLink().clickOnCreateOrganisationSymbol().createOrganisationWithTypeDropDownTest(OrgName);
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
	}

	//-----------------------------------------------------------------------------------------------------------------------------------	
	@Test(groups = "smokeTest" , enabled=true)
	public void createOrganisationWithType() throws InterruptedException, IOException, InvalidFormatException
	{
		String OrgName = efile.getExcelData("Creating New Organization", 1, 0)+"_"+javautil.getRandomData();
		HomePage homePage=new HomePage(driver);
		OrganizationInformationPage OrgInf = homePage.clickOnOrganisationLink().clickOnCreateOrganisationSymbol().createOrganisationWithType(OrgName, "Other");
		String actOrgNameTitle = OrgInf.getOgrTitle().getText();
		Assert.assertTrue(actOrgNameTitle.contains(OrgName));
		String actOrgName = OrgInf.getOrgNameEdit().getText();
		Assert.assertEquals(actOrgName, OrgName);
		String actTypeName = OrgInf.getTypeNameEdit().getText();
		Assert.assertEquals(actTypeName, "Other");
	}

}
