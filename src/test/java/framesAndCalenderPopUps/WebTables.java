package framesAndCalenderPopUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		
/*		//senario 1
		WebElement checkbox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selectall']"));
		checkbox.click();
*/
/*		//senario 2
		WebElement checkbox5 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]//input[@name='selected_id']"));
		checkbox5.click();
*/
/*		//senario 3 : //print in org name in console
		WebElement orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		System.out.println(orgName);
	
        //senario 4
		WebElement lastCheck = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[22]/td[1]/input[@name='selected_id']"));
		lastCheck.click();
		
	    //senario 5
		WebElement checkprint = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td[1]/input[@name='selected_id']"));
		checkprint.click();
		//print in org name in console
	    WebElement del = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td[8]/a[text()='del']"));
	    del.click();
*/	

	}

}
