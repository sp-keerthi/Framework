package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario2 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Create an')]")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Qspiders");
		
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
