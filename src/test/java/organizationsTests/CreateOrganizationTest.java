package organizationsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateOrganizationTest 
{
	@Test
	public void createOrganization() throws IOException, InterruptedException
	{
		//Step 1: create all required objects
		
				JavaUtilities jUtil = new JavaUtilities();
		        ExcelFileUtility eUtil = new ExcelFileUtility();
		        PropertyFileUtility pUtil = new PropertyFileUtility();
		        WebDriverUtiliy wUtil = new WebDriverUtiliy();
		        WebDriver driver=null;
		       
		        //step2: read the Required data
		        String BROWSER = pUtil.readdatafromPropertyfile("browser");
			    String URL = pUtil.readdatafromPropertyfile("url");
			    String USERNAME = pUtil.readdatafromPropertyfile("username");
			    String PASSWORD = pUtil.readdatafromPropertyfile("password");
			
			    String ORGNAME = eUtil.readtheDatafromExcelsheet("organization", 1, 2)+jUtil.getrandomNumber();
			
			//step2:launch the browser    
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
			   
			   //step 4 : login tdriverication
			      LoginPage lp = new LoginPage(driver);
			      lp.loginToApp(USERNAME, PASSWORD);
			   				    
				//step3:navigate to Organizations link
					
			      HomePage hp = new HomePage(driver);
			      hp.clickonOrganiationLink();
					
				//Step 4 : Click on Create Organization look Up Imge
			     OrganizationPage op = new OrganizationPage(driver);
			     op.clickOnOrganizationLookUpImg();
			     					
				//Step 5: Create Organization with mandatory information
			     
			     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			     cnop.createNewOrganization(ORGNAME);
					//save is already in new org page so no need to create new business utility
			    
			     //Step 7: Validate
			     OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			     String OrgHeader=oip.getHeaderText();
			     
					if(OrgHeader.contains(ORGNAME))
					{
						System.out.println(OrgHeader);
						System.out.println("PASS");
					}
					else
					{
						System.out.println("FAIL");
					}
					
				//Step 8: Logout of Application
					hp.logoutApp(driver);
			
	}

}
