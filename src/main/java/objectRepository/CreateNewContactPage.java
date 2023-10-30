package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtiliy;

public class CreateNewContactPage  extends WebDriverUtiliy
{
	@FindBy(name="lastname")
	private WebElement lastnameEdit;
	
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement ContactOrganizatioImg;
		
	
    @FindBy(name="search_text")
	private WebElement searchOrgEdit;
	
    @FindBy(name="search")
    private WebElement OrgsearchBtn;
    
    @FindBy(xpath="//a[text()='\"+ORGNAME+\"']")
    private WebElement orgnameEdit;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveContactslink;
    
    public CreateNewContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getContactOrganizatioImg() {
		return ContactOrganizatioImg;
	}

	public WebElement getSearchOrgEdit() {
		return searchOrgEdit;
	}

	public WebElement getOrgSearchBtn() {
		return OrgsearchBtn;
	}

	public WebElement getOrgnameEdit() {
		return orgnameEdit;
	}

	public WebElement getSaveContactslink() {
		return saveContactslink;
	}
    
    //business Library
	/**
	 * this method to create contact with mandatory fields and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastnameEdit.sendKeys(LASTNAME);
		saveContactslink.click();
	}
	/**
	 * this method will create contact with organization 
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 * @throws Throwable
	 */
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME) throws Throwable
	{
		lastnameEdit.sendKeys(LASTNAME);
		ContactOrganizatioImg.click();
		switchTOWindow(driver, "Accounts");
		searchOrgEdit.sendKeys(ORGNAME);
		OrgsearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchTOWindow(driver, "Contacts");
		saveContactslink.click();
		
	}
}
