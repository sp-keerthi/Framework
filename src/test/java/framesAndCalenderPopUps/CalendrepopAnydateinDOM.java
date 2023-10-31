package framesAndCalenderPopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendrepopAnydateinDOM {

	public static void main(String[] args) throws Throwable {
		
		// Launch the browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
       
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
        
        Actions act = new Actions(driver);
        act.moveByOffset(10, 10).click().perform();
   
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
       driver.findElement(By.xpath("//label[@for='departure']")).click();
       
       Thread.sleep(1000);
    // navigate to desired date in calender
       driver.findElement(By.xpath("//div[@aria-label='Wed Oct 18 2023']")).click();
        
	}

}
