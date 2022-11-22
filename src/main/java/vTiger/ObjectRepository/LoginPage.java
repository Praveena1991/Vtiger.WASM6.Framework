package vTiger.ObjectRepository;

 import org.openqa.selenium.WebDriver;

// import java.util.List; //if using private List<WebElement> UserNameEdt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1: Create java class page wise
	
	// identify all type web elements in the page using @FindBy, @FindAll, @FindBys
	
	@FindBy(name ="user_name") //identify username text field using @FindBy 
	private WebElement UserNameEdt;
//	private List<WebElement> UsernameEdt;
	
	@FindBy(name = "user_password") //identify password text field using @FindBy
	private WebElement PasswordEdt;
	
	@FindBy (id = "submitButton") // identify login button using @FindBy
	private WebElement SubmitBtn;
	
	
// initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


//utilization
	
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}


	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}  


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
// Business Library to login to application
	
	/**
	 * This method will login to application
	 * @param userName
	 * @param password
	 */
	
	public void loginToApp(String userName, String password)
	{
		UserNameEdt.sendKeys(userName);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}

	 
	
	
	

}
