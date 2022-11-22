package vTigerPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviderPractice {
	
	@Test (dataProvider ="phone")
	public void addProductToCartTest( String name, String model, int price, int qty)
	{
		
		System.out.println("phone name: "+name+"  Model: "+ model+"  Price: "+price+ "Quantity : "+qty);
	}
	@DataProvider(name= "phone")
	public Object getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Samsung";
		data[0][1] = "AS10";
		data[0][2] = 2500;
		data[0][3] = 10;
		
		data[1][0] = "Iphone";
		data[1][1] = "11Pro";
		data[1][2] = 500;
		data[1][3] = 5;
		
		data[2][0] = "VIVO";
		data[2][1] = "Y2";
		data[2][2] = 10000;
		data[2][3] = "asd";
		
		return data;
		
		
		
		
	}
	
	

}
