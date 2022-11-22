


package vTigerPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyPractice {

	
	
	@Test(dataProvider="Stationary Items")
	public void addProductToStore(String name, String type, int pages, int price)
	{
		System.out.println("Book Name = "+ name+ "Type of book ; "+ type+ "Number of pages: "+ pages+ "Price :"+price);
		
	}
	@DataProvider(name ="Stationary Items")
	public Object getData1()
	{
		Object [] [] data= new Object [2][4];
		
		data[0][0] = "Note Book1";
		data[0][1] ="long - ruled";
		data[0][2] = 100;
		data[0][3] = 80;
		
		data[1][0] = "Note book2";
		data[1][1] = "long - unruled";
		data[1][2] = 100;
		data[1][3] = 70;

		
		
		return data;

		
		
	}
	
	
	@Test (dataProvider ="getData")
	public void addRentToRecord(String house, int rent)
	{
		System.out.println("House details of "+house+ " Added with rent "+ rent);
	}
	
	@DataProvider()
	public Object getData()
	{
		
		Object [] [] rentData =new Object[2][2];
		
		rentData[0][0] = "House 1";
		rentData[0][1] = 8000;
		
		rentData[1][0] = "House 2";
		rentData[1][1] = 10000;
		
						
		return rentData;
			}
	
	
}
