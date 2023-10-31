package organizationsTests;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class createorgwithIndustryTesTT 
{
	@Test
	@Parameters({"ORG","INDUSTRYNAME"})
	public void createOrgWithIndustry(String ORG,String INDUSTRYNAME) throws IOException, InterruptedException
	{
		JavaUtilities jUtil = new JavaUtilities();
		WebDriverUtiliy wUtil = new WebDriverUtiliy();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriver driver = null;
		
		String BROWSER = pUtil.readdatafromPropertyfile("browser");
	    String URL = pUtil.readdatafromPropertyfile("url");
	    String USERNAME = pUtil.readdatafromPropertyfile("username");
	    String PASSWORD = pUtil.readdatafromPropertyfile("password");
	
		String ORGNAME = ORG+jUtil.getrandomNumber();
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
	      
//step 3: load url
	      
	      driver.get(URL);

	  //step 4 : login to application
	      LoginPage lp = new LoginPage(driver);
	       lp.loginToApp(USERNAME, PASSWORD);
	       
	  //step 5: click on Organization
	       HomePage hp = new HomePage(driver);
	       hp.clickonOrganiationLink();
	       
	  //step 6: click on create Organization look up image
	       OrganizationPage op = new OrganizationPage(driver);
	       op.clickOnOrganizationLookUpImg();
	       
	       //step 7:create new Organization with mandatory fields
	       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	       cnop.createNewOrganization(ORGNAME,INDUSTRYNAME);
	       wUtil.captureScreenShot(driver, ORGNAME);
	       
	 //step 8:validate for organization
	       OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	       String orgHeader = oip.getHeaderText();
	       if(orgHeader.contains(ORGNAME))
	       {
	    	   System.out.println(orgHeader);
	    	   System.out.println("organization created");		    		   
	       }
	       else
	       {
	    	   System.out.println("fail");
	       }
	 
	        
	 //step 9:logout
	        hp.logoutApp(driver);
	}

}
