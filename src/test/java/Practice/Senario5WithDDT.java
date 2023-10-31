package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario5WithDDT {

	public static void main(String[] args) throws Throwable {
	//Step1: Read all the necessary data
		
		/*read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*read data from excel -test data*/
	    FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fise);
	    String LASTNAME = wb.getSheet("CONTACTS").getRow(1).getCell(2).getStringCellValue();
	
	    //Step2: Launch the browser //Run time polymorphism - driver
	    
	    WebDriver driver=null;
	    
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
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
driver.findElement(By.linkText("Contacts")).click();

//driver.findElement(By.xpath("(//a[contains(text(),'Create ')])[2]")).click();

WebElement create = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
 Actions act = new Actions(driver);
act.moveToElement(create).click().perform();

driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);

driver.findElement(By.xpath("//img[@title='Select']")).click();
 
Thread.sleep(1000);
 String mainid = driver.getWindowHandle();
 System.out.println(mainid);
 
 Set<String> newtab = driver.getWindowHandles();
 System.out.println(newtab);
 
 for(String id : newtab)
 {
	 if(!mainid.equals(id))
	 {
		 driver.switchTo().window(id);
		 Thread.sleep(1000);
		// driver.findElement(By.xpath("//a[.='TCS']")).click();
		 driver.findElement(By.linkText("Qspiders")).click();
	 }
 }
 Thread.sleep(1000);
 driver.switchTo().window(mainid);
 driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	
driver.findElement(By.xpath("(//td[@class='small' and @valign='bottom'])[1]")).click();

Thread.sleep(1000);
driver.findElement(By.xpath("//a[.='Sign Out']")).click();

driver.quit();


	}

}
