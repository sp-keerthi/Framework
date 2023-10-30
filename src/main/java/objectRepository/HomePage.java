package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtiliy;

public class HomePage extends WebDriverUtiliy
{
    @FindBy(linkText="Organizations")
    private WebElement orglink;
    
    @FindBy(linkText="Contacts")
    private WebElement Contactslink;
    
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement administratorImg;
    
	@FindBy(linkText="Sign Out")
    private WebElement signOutlink; 
    
    public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}
	public WebElement getSignOutlink() {
		return signOutlink;
	}
    //business llib
	/**
	 * this method will click on orgnization link
	 */
	public void clickonOrganiationLink()
	{
		orglink.click();
	}
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		Contactslink.click();
	}
	/**
	 * this method will log out of application
	 * @throws Throwable 
	 */
	public void logoutApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutlink.click();
	}
}
