package genericutilities;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * this class consist of all basic configuration of testNG
 * @author user
 *
 */
public class BaseClass
{
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtilities jUtil = new JavaUtilities();
	public WebDriverUtiliy wUtil = new WebDriverUtiliy();
	public WebDriver driver = null;
	
	//created small driver used in listener class
	//because we dont want to extend or create a object 
	//we cant give access to entire base class every where there are chancess of base class getting carapted
	public static WebDriver sdriver;
	
   @BeforeSuite(groups={"SmokeSuite","ReggressionSuite"})
   public void bsCongig()
   {
	System.out.println("----DB Connection Successfull---");   
   }
   
   //@Parameters("browser")
  // @BeforeTest   // used for Distributed parallel execution insted of before class
  @BeforeClass(alwaysRun = true)  
   public void bcCongig(/*String BROWSER*/) throws IOException
   {
	  /* uncoment to run cross browser*/
/*//*/   String BROWSER = pUtil.readdatafromPropertyfile("browser");
	    String URL = pUtil.readdatafromPropertyfile("url");
	    
	    
	    if(BROWSER.equalsIgnoreCase("Chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver= new ChromeDriver();
	    	System.out.println(BROWSER+"launched");		
	    }
	    else  
		    if(BROWSER.equalsIgnoreCase("Edge"))
		    {
		    	WebDriverManager.edgedriver().setup();
		    	driver= new EdgeDriver();
		    	System.out.println(BROWSER+"launched");		
		    }
		    else
		    	 if(BROWSER.equalsIgnoreCase("Firefox"))
			    {
		    		 WebDriverManager.firefoxdriver().setup();
			    	driver= new FirefoxDriver();
			    	System.out.println(BROWSER+"launched");		
			    }
		    	 else
		    	 {
		    		 System.out.println("Invalid Browser name");
		    	 }
	      wUtil.maximizeWindow(driver);
	      wUtil.waitForPageLoad(driver);
	      
	      sdriver=driver;
	      // both are same ie sdriver is also a driver where it is static used in listenerclass
	      	      
	      driver.get(URL);
   }
   @BeforeMethod(alwaysRun = true)
   public void bmCongig() throws IOException
   {
	   String USERNAME = pUtil.readdatafromPropertyfile("username");
	    String PASSWORD = pUtil.readdatafromPropertyfile("password");
	    
	   LoginPage lp = new LoginPage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	   System.out.println("---Login succefull---");
			   
   }
   
   @AfterMethod(alwaysRun = true)
   public void AmCongig() throws InterruptedException
   {
	   HomePage hp = new HomePage(driver);
	   hp.logoutApp(driver);
	   
	   System.out.println("---logout succesfull");
	   
   }
   
  // @AfterTest // used for Distributed parallel execution insted of Afterclass
   @AfterClass(alwaysRun = true)
   public void AcCongig()
   {
	   driver.close();
	   System.out.println("Browser closed");
   }
   @AfterSuite(alwaysRun = true)
   public void AsCongig()
   {
	   System.out.println("---DB connection closed----");
   }
   
}
