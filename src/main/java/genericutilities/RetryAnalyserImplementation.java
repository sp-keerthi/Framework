package genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class will provide implementation to the IretryAnalyzer interface of testNG
 * @author user
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count =0;
	int retryCount=3;

	public boolean retry(ITestResult result)
	{
	       	//0<3 1<3 2<3 (3<3 no)
		while(count<retryCount)
		{
			count++; //1 2 3
			return true; //retry retry retry
			
		}
			
		
		return false;//(stop retry because 3<3 )
	}

	
}
