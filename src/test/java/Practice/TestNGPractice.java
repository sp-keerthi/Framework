package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	/*
	@Test(invocationCount = 2,priority = 1)
	public void createcustomer()
	{
		System.out.println("create");
	}
	
	@Test(priority = 1)
	public void createcustomer()
	{
		System.out.println("create");
	}
	
	
	@Test(enabled = true) //false:script will be disabled 
	public void createcustomer()
	{
		System.out.println("create");
	}
	*/
	@Test
	public void createcustomer()
	{
		Assert.fail(); // make the script fail forceabelly
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createcustomer") //depend on createcustomer
	public void modifycustomer()
	{
		System.out.println("modify");
	}
	
	@Test
	public void deletecustomer()
	{
		System.out.println("delete");
	}
}
