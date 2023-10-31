package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario2WithDDT {

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
			    String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
			
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
				
				driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
				
				//first time when we create we can use this path otherwise no need 
				//driver.findElement(By.xpath("//a[contains(text(),'Create an')]")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
				
				WebElement iname = driver.findElement(By.xpath("//select[@name='industry']"));
				Select inname = new Select(iname);
				inname.selectByVisibleText(" Apparel ");
				
				WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
				Select stype = new Select(type);
				stype.selectByIndex(2);
				
				WebElement checkbox = driver.findElement(By.xpath("//input[@name='emailoptout']"));
				checkbox.click();
		        
				driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
				

				WebElement mouse = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
				 Actions act = new Actions(driver);
				act.moveToElement(mouse).click().perform();
			
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				driver.quit();
				
	}

}
