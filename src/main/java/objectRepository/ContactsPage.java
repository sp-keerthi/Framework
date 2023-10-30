package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
   @FindBy(xpath="//img[@title='Create Contact...']")
   private WebElement contactImg;
   
   public ContactsPage(WebDriver driver)
   {
   	PageFactory.initElements(driver, this);
   }

    public WebElement getContactImg()
    {
	  return contactImg;
    }
   
    //business library
    /**
     * this method will click on create contact look up img
     */
    public void ClickOnCreatecontactsLookUpImg()
    {
    	contactImg.click();
    }
   
   
}
