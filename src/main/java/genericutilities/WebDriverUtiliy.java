package genericutilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of all generic methods related to web driver actions
 * @author user
 *
 */
public class WebDriverUtiliy {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	//dont declare webdriver globally it will be always null
	
	public void maximizeWindow(WebDriver driver)//driver should called here by parameterizing
	{
		driver.manage().window().maximize();//browser is launched and maximized
		
	}

	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will (implicit)wait for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait for a particular element to be visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will handel dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will handle dropdown by visibletext
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)//overload by interchanging the parameters
	{
		Select sel = new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * this method will perform mouseHover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
	    act.moveToElement(element).perform();
	}
	/**
	 * this method will move the cursor based on offset and click on webpage
	 * @param driver
	 */
	public void mouseAndClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
	/**
	 * this method will do right click
	 * @param driver
	 */
	public void rightclickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform doubleclick
	 * @param driver
	 */
	public void Action(WebDriver driver)
	{
     Actions act = new Actions(driver);
     act.doubleClick().perform();
	}
	/**
	 * this method will perform darg and drop operation
	 * @param driver
	 * @param Srcele
	 * @param dstEle
	 */
	public void dragAndDrop(WebDriver driver,WebElement Srcele,WebElement dstEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(Srcele, dstEle);
	}
	/**
	 * this method will handel frame by index
	 * @param driver
	 * @param Index
	 */
	public void swithtoFrames(WebDriver driver,int Index)
	{
		driver.switchTo().frame(Index);
	}
	/**
	 * this method will handel frame by name or id
	 * @param driver
	 * @param NameOrId
	 */
	public void swithtoFrames(WebDriver driver,String NameOrId)
	{
		driver.switchTo().frame(NameOrId);
	}
	/**
	 * this element will handle frame by web element
	 * @param driver
	 * @param element
	 */
	public void swithtoFrames(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to scroll down by 4000 units
	 * @param driver
	 */
	public void scrollByActionDown(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000)","");
	}
	/**
	 *  this method is used to scroll up by -4000 units
	 * @param driver
	 */
	public void scrollByActionup(WebDriver driver)//-y
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-4000)","");
	}
	/**
	 *  this method is used to scroll down height  by 4000 units
	 * @param driver
	 */
	public void scrollByActionDownHeight(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
    /**
     *  this method is used to scroll up height by -4000 units
     * @param driver
     */
	public void scrollByActionUpHeight(WebDriver driver)//-x
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	/**
	 *  this method is used to scroll right by 1000 units
	 * @param driver
	 */
	public void scrollByActionright(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(1000,0)");
	}
	/**
	 *  this method is used to scroll left by -1000 units
	 * @param driver
	 */
	public void scrollByActionLeft(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(-1000,0)");
	}
	/**
	 * this method is used accept the alert popups
	 * @param driver
	 */
	public void acceptalert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
       
	}
	/**
	 * this method is used cancel the alert popups
	 * @param driver
	 */
	public void cancelalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
       
	}
	/**
	 * this method is used featch the alert text and return to caller
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
       
	}
	/**
	 * this method is to switch window using title from main to child , child to main 
	 * @param driver
	 * @param PartialWinTitle
	 * @throws Throwable
	 */
	public void  switchTOWindow(WebDriver driver,String PartialWinTitle) throws Throwable
	{
		//step1: get all the window id

		Set<String> AllwinID = driver.getWindowHandles();
		
		//step2: navigate thru each window
		
		for (String Winid : AllwinID) //mainID and NewtabID
		{
			//step3: switch to each window and capture title
				
			String actTitle = driver.switchTo().window(Winid).getTitle();
			
			//step4:compare actual title with expected partial title
			
			if(actTitle.contains(PartialWinTitle))
			{
				break;
			}
		}	
	}
	/**
	 * this method will take screeshot and return the dst path
	 * @param driver
	 * @param screeshots
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screeshots) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);//Temporary location
	   File des = new File(".\\ScreenShots\\"+screeshots+".png");//screenshot is the folder \\used to tell file has to be saved inside it
	                                          //screenshots.png
	   Files.copy(src, des); // add dependency in pop.xml commons io  2.13.0
	 
	   return des.getAbsolutePath();//used for extent reports 
	
	}
}
