package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage
{

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHedderTxt;
	
	public OrganizationInformationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getOrgHedderTxt() {
		return OrgHedderTxt;
	}
	
	//business library
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHedderTxt.getText();
	}
}
