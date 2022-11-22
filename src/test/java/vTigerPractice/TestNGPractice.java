package vTigerPractice;

//import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	
	@Test( priority =1 )
	public void createCustomer()
	{
		System.out.println("Customer created");
	}
	
	@Test( priority =2)
	public void modifyCustomer()
	{
		System.out.println("Customer modified");
	}
	
 // 	@Ignore ------> to ignore running a test case
	@Test( invocationCount= 2, priority =3)
	public void deleteCustomer()
	{
		
		System.out.println("Customer deleted");
		
		
	}
	

}
