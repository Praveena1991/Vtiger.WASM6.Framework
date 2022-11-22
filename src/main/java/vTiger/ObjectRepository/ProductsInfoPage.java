package vTiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	
	@FindBy (xpath = "//span[@class ='lvtHeaderText']")
	private WebElement ProductHeaderText;
	
	public void ProductInfoPage(WebElement driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeaderText() {
		return ProductHeaderText;
	}
	
	//Business Library
	/**
	 * This method will get the header text and return it to caller
	 */
	public String getProductHeader()
	{
		return ProductHeaderText.getText();
	}

}
