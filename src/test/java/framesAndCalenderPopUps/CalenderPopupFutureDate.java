package framesAndCalenderPopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupFutureDate {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
         driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
        
         Thread.sleep(1000);
         
         WebElement frc = driver.findElement(By.id("fromCity"));
         frc.sendKeys("mumbai");
        driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
       
        Thread.sleep(1000);
        
        WebElement toc = driver.findElement(By.id("toCity"));
        toc.sendKeys("bangalore");
        driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
        
        //Thread.sleep(1000);
        
        //driver.findElement(By.xpath("//input[@id='departure']")).click();
        
        Thread.sleep(2000);
        
     // navigate to any future Date date in calendar
        
        for(;;)//1 2 3 4 5
        	
        try
        {  //not visible - exception - visible - click()
        driver.findElement(By.xpath("//div[@aria-label='Thu Dec 14 2023']")).click();
                  // No such element exception
         break;
        }
        catch(Exception e)
        {
        	//click on next month
        	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
        	Thread.sleep(1000);
        }
	}

}
