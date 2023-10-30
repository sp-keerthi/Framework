package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHederText;
	
	public ContactInfoPage(WebDriver driver)//test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHederText() {
		return ContactHederText;
	}
	//business library

	public String getHeaderText()
	{
		return ContactHederText.getText();
	}
}
