package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;



public class POMPracticeForCreateContactTest extends BaseClass{
	
	@Test
	
	public void pomPracticeForCreateContactTest()  throws IOException {
		
			
		String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		
			
		//step 5:navigate to contacts link
		HomePage hp=new HomePage(driver);
		hp. clickOnContactsLink();
		
		//step 6:navigate create contact look up image
		ContactsPage cp =new ContactsPage(driver);
		cp.ClickOnCreateContactLookUpImg();
		
		
		//step 7:create contact with mandatory fields and save
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		
		//step 8:validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		

	}


}
