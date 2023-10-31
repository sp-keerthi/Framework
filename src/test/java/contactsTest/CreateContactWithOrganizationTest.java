package contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest {

	@Test
	public void createContactWithOrgTest() throws Throwable
	
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
			
			    String ORGNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();
			    
			    String LASTNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();
			
			    //getrandomnumber  --> orgname or lastname is reapeated it will not accept
			    //               so by using randomnumber from javautils generic file 
			    //               it will add a random number and print it in webpage
			    
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
			       cnop.createNewOrganization(ORGNAME);
			      
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
			 //step 9:click on contacts link
			       hp.clickOnContactsLink();
			       
			 //step 10:click on create contact look up img
			       ContactsPage cp = new ContactsPage(driver);
			       cp.ClickOnCreatecontactsLookUpImg();
			     
			 //step 11: create contact with organization
			       CreateNewContactPage cncp = new CreateNewContactPage(driver);
			       cncp.createNewContact(driver, LASTNAME, ORGNAME);
	         
			 //step 12:validation 
			       ContactInfoPage cip = new ContactInfoPage(driver);
			        String contactHeader = cip.getHeaderText();
			        if(contactHeader.contains(LASTNAME))
			        {
			        	System.out.println(contactHeader);
			        	System.out.println("pass");
			        }
			        else
			        {
			        	System.out.println("fail");
			        }
			        
			 //step 13:logout
			        hp.logoutApp(driver);
			        
			 //step 14: close the browser
			        driver.quit();
	}

}
