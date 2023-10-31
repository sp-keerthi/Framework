package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario1 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[id='submitButton']")).click();
	    
		driver.findElement(By.linkText("Contacts")).click();
		
		//driver.findElement(By.xpath("(//a[contains(text(),'Create ')])[2]")).click();
		WebElement create = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		 Actions act = new Actions(driver);
		act.moveToElement(create).click().perform();
		
		WebElement name = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		 Select fname = new Select(name);
		 fname.selectByVisibleText("Ms.");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("keerthi");
		
		driver.findElement(By.xpath("//select[@name='leadsource']"));
		driver.findElement(By.xpath("//option[@value='Employee']")).click();
		
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
//validation
		String valid = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(valid.contains("keerthi"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement mouse = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 Actions act1 = new Actions(driver);
		act1.moveToElement(mouse).click().perform();
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
