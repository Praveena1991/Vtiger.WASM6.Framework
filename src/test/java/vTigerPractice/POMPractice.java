package vTigerPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) {

	//	WebDriverLibrary wLib = new  WebDriverLibrary();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888");
		
	LoginPage lp= new LoginPage(driver);
//	lp.getUserNameEdt().sendKeys("admin");
	
//	lp.getPasswordEdt().sendKeys("admin");
	
//	lp.getSubmitBtn().click();
		
	lp.loginToApp("admin", "admin");
	
	HomePage hp = new HomePage(driver);
//	hp.getOrganizationLnk().click();
	
//	wLib.mouseHoverOn(driver, hp.getAdministratorImg());
//	hp.getSignOutLnk().click();
	hp.clickOnOrganizationLink();
	hp.signOutOfApp(driver);
	
	
	
	
	
	
	}

}
