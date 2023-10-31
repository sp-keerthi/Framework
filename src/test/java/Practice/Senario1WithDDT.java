package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario1WithDDT {

	public static void main(String[] args) throws IOException, Throwable {
		
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
	    String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
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
	//Step1: launching browser
	    WebDriverUtiliy gen = new WebDriverUtiliy(); //calling generic utilities
      //  driver.manage().window().maximize();
	 	 
	    gen.maximizeWindow(driver);
	  
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		gen.waitForPageLoad(driver);
	  
		driver.get(URL);
	
	//step2: login to application	
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	    
	//step3:navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
	//step4:click on create contact look up img 
		
		//1. here action class is used
		
		//driver.findElement(By.xpath("(//a[contains(text(),'Create ')])[2]")).click();
		
		WebElement create = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		
		//Actions act = new Actions(driver);
		//act.moveToElement(create).click().perform();
		gen.mouseHoverAction(driver, create);
		
		/* 2.just by using xpath 
		 * driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 */
	//extra item added	
		WebElement name = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		 Select fname = new Select(name);
		 fname.selectByVisibleText("Ms.");
	
   //Step 5: create conatact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//select[@name='leadsource']"));
		driver.findElement(By.xpath("//option[@value='Employee']")).click();
   //step 6: save	
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
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
	//Step 8: logout using action class
		WebElement mouse = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
	//	 Actions act1 = new Actions(driver);
	//   act1.moveToElement(mouse).click().perform();
		gen.mouseHoverAction(driver, mouse);
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("SignOut successful");
		driver.quit();
	}

	}


