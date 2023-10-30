package genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation to ItestLesteners interface of testNG  
 * @author user
 *
 */
public class ListenersImplementationClass implements ITestListener {

	ExtentReports report;
	 ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"--test execution started--");
	
		//3. create a test script- recognise each @Test
		 test = report.createTest(testScriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"--passed--");
		
		//3. log the success
		test.log(Status.PASS, testScriptName+"==PASS==");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
		//screenshot
		// wUtil.captureScreenShot(driver, ORGNAME);

    	 String testScriptName = result.getMethod().getMethodName();
	   	System.out.println(testScriptName+"--failed--");

		//exception for failure
		System.out.println(result.getThrowable());

		//log for failure
		test.log(Status.FAIL, testScriptName+"==FAIL==");
		test.log(Status.INFO, result.getThrowable());
		
		//screenshot
		//it will display testscriptname with today date and time 
		String screenShotName=testScriptName+new JavaUtilities().getSystemDate();
		
		WebDriverUtiliy w = new WebDriverUtiliy();		
		
		//w.captureScreenShot(BaseClass.sdriver, screenShotName);
		//it will give suggestion surrounded by try catch just click it
		
		try 
		{
		String path = w.captureScreenShot(BaseClass.sdriver, screenShotName);
		test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"--skipped--");
		
		//exception for failure
		System.out.println(result.getThrowable());
		
		
		//log for skip
		test.log(Status.SKIP, testScriptName+"==SKIP==");
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("--suite execution started--");
		
	//1.Basic report configuration //Reports-17-10-2023-20-04-20.html
		
		ExtentSparkReporter html= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtilities().getSystemDate()+".html");
	    html.config().setTheme(Theme.DARK);
	    html.config().setDocumentTitle("Execution Report");
	    html.config().setReportName("Vtiger execution Report");
	    
	    report = new ExtentReports();
	    report.attachReporter(html);
	    report.setSystemInfo("Base Browser", "edge");
	    report.setSystemInfo("Base Platform", "windows");
        report.setSystemInfo("base envirornment", "Testing");	
        report.setSystemInfo("Reporter name", "keerthi");
	
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println("---Suite execution Finished--");
		
		// 2. report generation
		
		report.flush();
	}

}
