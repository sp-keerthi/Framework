package contactsTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
    @Test
	public void createconntact() throws Throwable
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
			
       String LASTNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();
	    
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
	
	//step4: login to application	
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		
	//step3:navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
	//step4:click on create contact look up img 
		
		ContactsPage cp = new ContactsPage(driver);
	       cp.ClickOnCreatecontactsLookUpImg();
		
   //Step 5: create conatact
	       CreateNewContactPage cncp = new CreateNewContactPage(driver);
	       cncp.createNewContact(LASTNAME);
     
   // step 7 :validation
		String valid = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(valid.contains(LASTNAME))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
  //step 8:logout
        hp.logoutApp(driver);
        
 //step 9: close the browser
        driver.quit();
		
	}

}
