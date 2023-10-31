package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactOraganization {

	public static void main(String[] args) throws Throwable {
		
		JavaUtilities jUtil = new JavaUtilities();
		WebDriverUtiliy wUtil = new WebDriverUtiliy();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriver driver = null;
		
		String BROWSER = pUtil.readdatafromPropertyfile("browser");
		String URL = pUtil.readdatafromPropertyfile("url");
		String USERNAME = pUtil.readdatafromPropertyfile("username");
		String PASSWORD = pUtil.readdatafromPropertyfile("password");
		
	    String ORGNAME = eUtil.readtheDatafromExcelsheet("Organization", 1, 2)+jUtil.getrandomNumber();
	    
	    String LASTNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	System.out.println("browser launched");
	    }
	    else
	    	if(BROWSER.equalsIgnoreCase("edge"))
	    	{
	    		WebDriverManager.edgedriver().setup();
	    		driver = new EdgeDriver();
	    		System.out.println("Browser launched ");
	    	}
	    	
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForPageLoad(driver);
	    
	    driver.get(URL);
	  
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
	    
	    
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	     String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	    
	    if(OrgHeader.contains(ORGNAME))
	    {
	    	System.out.println(OrgHeader);
	    	System.out.println("organization created");
	    }
	    	else
	    	{
	    		System.out.println("fail");
	    }
	    
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	    driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	   wUtil.switchTOWindow(driver, "Accounts");
	   driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	   driver.findElement(By.name("search")).click();
	   driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	   wUtil.switchTOWindow(driver, "Contacts");
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if(ContactHeader.contains(LASTNAME))
	   {
		   System.out.println(LASTNAME);
		   System.out.println("Contact created");
	   }
	   else
	   {
		   System.out.println("fail");
	   }
	   WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  wUtil.mouseHoverAction(driver, ele);
	  driver.findElement(By.linkText("Sign Out")).click();
	  System.out.println("logout");
	  driver.quit();
	 }

}
