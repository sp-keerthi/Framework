package framesAndCalenderPopUps;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupCurrentDate {

	public static void main(String[] args) throws Throwable
	{
		 Date d = new Date();
		String[] dArr = d.toString().split(" ");// formating the current date
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];// Wed Oct 04 2023 in this form
		System.out.println(currentDate);
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		
		Actions act1 = new Actions(driver);
	       act1.moveByOffset(10, 20).click().perform();
	       Thread.sleep(1000);
	       
 
	    // driver.findElement(By.xpath("//a[@class='close']")).click();

			Thread.sleep(1000);
			//driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
			driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']")).click();
			
			// Navigate to From and To Elements
			WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
			WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));

			src.sendKeys("mumbai");
			driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();

			Thread.sleep(2000);

			dst.sendKeys("Del");
			driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

			Thread.sleep(2000);

			// navigate to departure
			// driver.findElement(By.xpath("//label[@for='departure']")).click();

			// navigate to desired date in calender
			Thread.sleep(1000);                      
			
			//dynamic xpath
			
			//String currentDate = null;                     //dynamic xpath
			driver.findElement(By.xpath("//div[@aria-label='"+ currentDate +"']")).click();
			                           
			                             //div[@aria-label='Sat Jul 08 2023']
			                             //div[@aria-label='Sat Jul 09 2023']
			                             //div[@aria-label='Sat Jul 18 2023']
			
			
			
		}

}
