package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice 
{
   	@Test(retryAnalyzer = genericutilities.RetryAnalyserImplementation.class)
	public void analyzer() 
   	{
   		Assert.fail();
		System.out.println("Hi");
	}
}
