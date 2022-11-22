package vTiger.ContactsTests;

//import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;


@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {

	
     @Test (groups ="smokeSuite")

	public void createContactTest() throws IOException {

 	    
 	    String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
 	       
 	    
 	    //Step 5: Navigate to Contacts Link
 	    HomePage hp =new HomePage(driver);
 	    hp.clickOnContactsLink();
 	     	 
 	    
 	    //Step 6: Navigate to create Contact Look up image
 	    ContactsPage cp = new ContactsPage(driver);
 	    cp.ClickOnCreateContactLookUpImg();
 	    
 	    //Step 7: create contact with mandatory details and save
 	    
 	    CreateNewContactPage cncp =new CreateNewContactPage(driver); 
 	    cncp.createNewContact(LASTNAME);
 	  // Assert.fail(); //----> to purposefully make the test script fail 	    
 	    
 	    //Step 8: Validate
 	    String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 	    System.out.println(contactHeader);
 	    Assert.assertTrue(contactHeader.contains(LASTNAME));
 	    	    
		  }

     @Test  (groups ={"smokeSuite","regressionSuite"})
     public void createContactDemoTest()
     {
    	 System.out.println("demo test");
     }
     
     
    @Test 
    public void createContactWithLeadSource()
    {
    	System.out.println("Contact created with lead source");
    }
     
    @Test
    public void createContactWithLeadSourceAndOrg()
    {
    	System.out.println("Contact With Lead Source and Organization ");
    }
     
	}


