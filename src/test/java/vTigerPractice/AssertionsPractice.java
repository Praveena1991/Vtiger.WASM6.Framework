package vTigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	  @Test
	  public void demoTest()
	  {
		  
		  SoftAssert sa = new SoftAssert();
		    
		  System.out.println("Step 1");
		  System.out.println("Step 2");
		  sa.assertEquals(10, 9);
		//  Assert.assertEquals(true, true);// if it is (true, false) it is fail everything below it will be failed
		  //Assert.assertEquals("A", "B");
		  System.out.println("Step 3");
		  sa.assertTrue(false);
		//  Assert.assertTrue(false);
		  System.out.println("Step 4");
		  
		 // sa.assertAll();
	  }
	  
	  @Test
	  public void demo()
	  {
		  SoftAssert sa = new SoftAssert();
		  System.out.println("Step 5");
		  System.out.println("Step 6");
		  Assert.assertTrue(false);// mandatory field
		   
		  System.out.println("Step 7 ");
		  sa.assertTrue(false);//non mandatory field
		  System.out.println("Step 8");
		  sa.assertAll();
	  }
	  
  
}
