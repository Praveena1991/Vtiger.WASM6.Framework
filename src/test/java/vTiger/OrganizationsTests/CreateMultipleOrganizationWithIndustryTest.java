package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrganizationWithIndustryTest extends BaseClass{
	
	//All generic libraries are imported from BaseClass
	@Test(dataProvider = "MulipleOragnizations")
	
	public void createMultipleOrganizationWithIndustry(String orgName, String industryType)
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrganizationsLookUpImg();
		
		CreateNewOrganizationsPage cnop =new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganizations(orgName, industryType);
	}
	
	@DataProvider(name ="MultipleOrganizations")
	public Object [][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eLib.readMultipleData("MultipleOrganizations");
		return data;
	}
	

}
