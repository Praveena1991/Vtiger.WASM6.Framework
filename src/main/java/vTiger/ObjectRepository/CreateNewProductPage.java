package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//declaration
	@FindBy (name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	
	//initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

	//utlization
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	
	/**
	 * This method will create new product with product name
	 */
	public void createNewProduct(String productName)
	{
		ProductNameEdt.sendKeys(productName);
		SaveBtn.click();
	
	}
	
	

}
