package Practice;

import java.io.IOException;

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

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		
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
	   
	   //step 4 : login to application
	   
	      driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		    
		//step3:navigate to Organizations link
			
			driver.findElement(By.linkText("Organizations")).click();
			
		//Step 4 : Click on Create Organization look Up Imge
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
		//Step 5: Create Organization with mandatory information
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
		//Step 6: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	    //Step 7: Validate
			String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
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
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, ele);
			
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("logout successful");
	
	}

}
