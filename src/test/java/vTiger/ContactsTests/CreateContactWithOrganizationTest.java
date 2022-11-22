package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;


public class CreateContactWithOrganizationTest extends BaseClass{

@Test

	public void createContactWithOrganizationTest() throws EncryptedDocumentException, IOException {

		   
		    String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2) + jLib.getRandomNumber();
		    String ORGNAME = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getRandomNumber();

		     
		    
		    //Step 5: Navigate to Organizations link
		  HomePage hp = new HomePage(driver);
		  hp.clickOnOrganizationLink();
		  Reporter.log("Organizations link clicked", true);
		    
		    //Step 6: Navigate to create Organizations look up image
		   OrganizationsPage op = new OrganizationsPage(driver);
		    op.clickOnCreateOrganizationsLookUpImg();
		    Reporter.log("Organizations look up image link clicked", true);
		    
		   CreateNewOrganizationsPage cnog = new CreateNewOrganizationsPage(driver);
		   cnog.CreateNewOrganizations(ORGNAME);
		    
		    //Step 8: Validate for Organization
		   OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver); 
		   	   
		   String orgHeader = orgInfo.getOrgHeader();
		    Assert.assertTrue(orgHeader.contains(ORGNAME),"Organization created");
		    Reporter.log("Organization created successfully", true);
		    
		    //Step 9: Navigate to contacts link
		    hp.clickOnContactsLink();
		    Reporter.log("Contacts link clicked", true);

		    // Step 10: Navigate to create Contact Look up image
		   ContactsPage cp =new ContactsPage(driver);
		   cp.ClickOnCreateContactLookUpImg();
		   Reporter.log("Create Contacts look up image link clicked", true);
		    
		 // Step 11: create contact with mandatory details
		    CreateNewContactPage cncp = new CreateNewContactPage(driver);
		    cncp.createNewContact(LASTNAME,ORGNAME,driver);
		    
		        
		        //Step 13: Validate for Contact
		    ContactInfoPage cInfo = new ContactInfoPage(driver);
		    
		    String contactHeader = cInfo.getContactHeader();
		   Assert.assertTrue(contactHeader.contains(LASTNAME),"Contact created succesfully");
		   Reporter.log("Contact Created ", true);
		      
		  		    
		  }

	}

