package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
   @FindBy(xpath="//img[@alt='Create Organization...']")
   private WebElement OrgImgbtn;

   public OrganizationPage(WebDriver driver)
   {
   	PageFactory.initElements(driver, this);
   }
      
   public WebElement getOrgImgbtn() {
	return OrgImgbtn;
}
   //business library
   /**
    * this method will click on create org look up img
    */
   public void clickOnOrganizationLookUpImg()
   {
	   OrgImgbtn.click();
   }

   
   
   
}
