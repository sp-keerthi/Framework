package Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario5 {

	public static void main(String[] args) throws Throwable {
	
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//driver.findElement(By.xpath("(//a[contains(text(),'Create ')])[2]")).click();
		
		WebElement create = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		 Actions act = new Actions(driver);
		act.moveToElement(create).click().perform();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("niharika");

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
