package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtiliy;

public class CreateNewOrganizationPage extends WebDriverUtiliy
{
	   @FindBy(name="accountname")
	   private WebElement OrgNameEdit;
	   
	   @FindBy(name="industry")
	   private WebElement industryDropDown;
	   
	   @FindBy(name="accounttype")
	   private WebElement TypeDropDown;
	   
	  
	   @FindBy(xpath="//input[@title='Save [Alt+S]']")
	   private WebElement saveOrgBtn;
	   
	
      public CreateNewOrganizationPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

	   public WebElement getOrgNameEdit() {
			return OrgNameEdit;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}

		public WebElement getTypeDropDown() {
			return TypeDropDown;
		}

		public WebElement getSaveOrgBtn() {
			return saveOrgBtn;
		}


//business lib
/**
 * this method will create new organization with mandatory fields
 * @param ORGNAME
 */
public void createNewOrganization(String ORGNAME)
{
	OrgNameEdit.sendKeys(ORGNAME);
	saveOrgBtn.click();
}
/**
 * this method will create new org with industry dropdown
 * @param ORGNAME
 * @param INDUSTRY
 */
public void createNewOrganization(String ORGNAME,String INDUSTRY)
{
	OrgNameEdit.sendKeys(ORGNAME);
	handleDropDown(industryDropDown,INDUSTRY);
	saveOrgBtn.click();
	
}
/**
 * this method will create new org with industry and type dropdown
 * @param ORGNAME
 * @param TYPE
 */
public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE)
{
	OrgNameEdit.sendKeys(ORGNAME);
	handleDropDown(industryDropDown,INDUSTRY);
	handleDropDown(TypeDropDown,TYPE);
	saveOrgBtn.click();
}


}