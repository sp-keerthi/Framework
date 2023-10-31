package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		//hard assert after fail it will stop next lines will not print
		
		//Assert.assertEquals(0, 1);//(1,1) pass1==1 
		
		//soft assert will continue the execution at last it will give fail report
		 
		SoftAssert sa = new SoftAssert();
		 sa.assertEquals(0, 1);
		
		 System.out.println("step 3");
		System.out.println("step 4");
		/*if(1==1)// if else is not the corret way of validation
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		*/
		
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step 1");
		sa.assertEquals(1,2);
		
		System.out.println("step 2");


		//soft assert will continue the execution at last it will give fail report
		 
		
		 sa.assertEquals(false,true);
		
		 System.out.println("step 3");
		System.out.println("step 4");
		
		sa.assertAll();//if not written then all failuer are ignored it will not display in the console
	    // all the failue will loged at the end
		sa.assertEquals("A","B");
	 }
	
	@Test
	public void practice2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step 1");
		
		Assert.assertEquals(1,1);//pass
		
		//after this nothing will run
		
		
		System.out.println("step 2");


		//soft assert will continue the execution at last it will give fail report
		 
		
		 sa.assertEquals(false,true);//failed
		
		 System.out.println("step 3");
		System.out.println("step 4");
		

		Assert.assertEquals(0,1);//fail
		
		sa.assertEquals("A","A");//passed
		
		sa.assertAll();
	 }
}
