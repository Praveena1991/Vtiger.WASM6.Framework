package vTiger.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * 
 * This is a generic class which consists of all basic configuration annotation
 * @author PRAVEENA
 */

public class BaseClass {

 public PropertyFileLibrary pLib = new PropertyFileLibrary();
 public ExcelFileLibrary eLib = new ExcelFileLibrary();
 public JavaLibrary jLib = new JavaLibrary();
 public WebDriverLibrary wLib = new WebDriverLibrary();
 public WebDriver driver = null;
 //to take screen shot
 public static WebDriver sDriver= null;
 

 @BeforeSuite (groups = {"smokeSuite", "regressionSuite"})//Connecting to database
 public void bsConfig() {
  System.out.println("--- Database connected successfully ---");
 }

 //@Parameters("browser")
 //@BeforeTest
 @BeforeClass (groups = {"smokeSuite", "regressionSuite"})//Launching the browser
 public void bcConfig() throws IOException {
 //public void bcConfig(String BROWSER) throws IOException {
  String BROWSER = pLib.readDataFromPropertyFile("browser");
  String URL = pLib.readDataFromPropertyFile("url");

  if (BROWSER.equalsIgnoreCase("chrome")) 
  {
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   System.out.println("--- Browser launched successfully -> " + BROWSER + " ---");
  } 
  
  else if (BROWSER.equalsIgnoreCase("firefox"))
  {
   WebDriverManager.firefoxdriver().setup();
   driver = new FirefoxDriver();
   System.out.println("--- Browser launched successfully -> " + BROWSER + " ---");
  } 
  
  else 
  {
   System.out.println("invalid browser name");
  }
  
  sDriver = driver;
  wLib.maximizeWindow(driver);
  wLib.waitForPageLoad(driver);
  driver.get(URL);

 }

 @BeforeMethod (groups = {"smokeSuite", "regressionSuite"})//Login to application
 public void bmConfig() throws IOException {
  String USERNAME = pLib.readDataFromPropertyFile("username");
  String PASSWORD = pLib.readDataFromPropertyFile("password");
  
  //Create an object of POM login page
  LoginPage lp = new LoginPage(driver);
  lp.loginToApp(USERNAME, PASSWORD);
  System.out.println(" --- Login is successfull ---");
 }

 @AfterMethod (groups ={"smokeSuite", "regressionSuite"})//Logout of application
 public void amConfig() {
  //Create an object of POM HomePage as logout button is in homepage
  HomePage hp = new HomePage(driver);
  hp.signOutOfApp(driver);
  System.out.println("--- Logout successfull ---");
 }

 @AfterTest
 //@AfterClass (groups = {"smokeSuite", "regressionSuite"})// Close the browser
 public void acConfig() {
  driver.quit();
  System.out.println("--- Browser closed successfully ---");
 }

 @AfterSuite(groups = {"smokeSuite", "regressionSuite"}) //Close the database
 public void asConfig() {
  System.out.println("--- Database closed successfully ---");
 }

}