package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class POMCreateContactWithOrganization extends BaseClass  {
	
	@Test
	public  void pomCreateContactWithOrganization() throws EncryptedDocumentException, IOException {
	
	    String LASTNAME = eLib.readDataFromExcel("Contact", 4, 2) + jLib.getRandomNumber();
	    String ORGNAME = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getRandomNumber();
 
	 
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationLink();
  
	    OrganizationsPage op = new OrganizationsPage(driver);
	    op.clickOnCreateOrganizationsLookUpImg();
	    
	    //Step 7: Create new organization and save
	    CreateNewOrganizationsPage cnop = new  CreateNewOrganizationsPage(driver);
	    cnop.CreateNewOrganizations(ORGNAME);
	    
	    //Step 8: Validate for Organization
	    
	    OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver);
	    orgInfo.getOrgHeader();
	    String orgHeader =orgInfo.getOrgHeader();
	   
	    System.out.println(orgHeader);
	    if(orgHeader.contains(ORGNAME))
	    {
	      System.out.println("Organization created");
	    }
	    else
	    {
	      System.out.println("Organization creation failed");
	      wLib.takeScreenShot(driver, "CreateContactWithOrganization");
	    }
	    
	    //Step 9: Navigate to contacts link
	    hp.clickOnContactsLink();

	    // Step 10: Navigate to create Contact Look up image
	   ContactsPage cp = new ContactsPage(driver);
	   cp.ClickOnCreateContactLookUpImg();
	    
	 // Step 11: create contact with mandatory details
	   
	   CreateNewContactPage cncp = new  CreateNewContactPage(driver);
	 	    //Step 12: Select the Organization created in org window
	   cncp.createNewContact(LASTNAME, ORGNAME, driver);
	   
	        
	        //Step 13: Validate for Contact
	   
	   ContactInfoPage cInfo = new ContactInfoPage(driver);
	        String contactHeader = cInfo.getContactHeader(); 
	   
	        
	    System.out.println(contactHeader);
	    if(contactHeader.contains(LASTNAME))
	    {
	      System.out.println("PASS");
	    }
	    else
	    {
	      System.out.println("FAIL");
	      wLib.takeScreenShot(driver, "CreateContactWithOrganization");
	    }
	    
	    
	    
	    
	  }
	

}
