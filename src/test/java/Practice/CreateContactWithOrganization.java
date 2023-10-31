package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {

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
	   
	   //step 4 : login to application --> using object Repository
	   
	    /*  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
	      
	      //using getters
	      LoginPage lp = new LoginPage(driver);
		/*    lp.getUserNameEdit().sendKeys(USERNAME);
		    lp.getPasswordEdit().sendKeys(PASSWORD);
		    lp.getLoginbtn().click();*/
		    
		    //using Business logic 
		    lp.loginToApp(USERNAME, PASSWORD);
		    
		//step3:navigate to Organizations link
			
			//driver.findElement(By.linkText("Organizations")).click();
			HomePage hp = new HomePage(driver);
		    hp.getOrglink().click();
		    
		//Step 4 : Click on Create Organization look Up Imge
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
		//Step 5: Create Organization with mandatory information
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
		//Step 6: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		//Step 7: Validate for org
			String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println(OrgHeader);
				System.out.println("Organization is created");
			}
			else
			{
				System.out.println("FAIL");
			}
		//step 8: navigate to contacts
			driver.findElement(By.linkText("Contacts")).click();
		
		//step 9: click on create contact look up img
			 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
		//step 10: identify mandatory fileds lastname
			
			 driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
		//step 11: click on organization look up img
			driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
			
		    wUtil.switchTOWindow(driver, "Accounts");
		    
		    driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		    
		    driver.findElement(By.name("search")).click();
		    
		    driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		    // REMOVE VISIBLE TEXT PUT ORGNAME  
		    //ORGNAME IS DYNAMIC
		    //EX FOR DYNAMIC XPATH - X PATH CHANGING DYNAMICALLY(X PATH GOING TO BE ALTERED)
	  
		    wUtil.switchTOWindow(driver, "Contacts");

		// Step 12: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 13: Validate for contacts
			String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(ContactHeader.contains(LASTNAME))
			{
				System.out.println(ContactHeader);
				System.out.println("Contats created succesfully");
			}
			else
			{
				System.out.println("FAIL");
			}
			
	  //Step 14: Logout of Application
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, ele);
			
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("logout successful");
	         driver.close();

	}

}
