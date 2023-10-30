package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
    //rule1
	
	//rule2 - declaration
	@FindBy(name="user_name")
	private WebElement userNameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginbtn;
	
	// rule3: intialization
       public LoginPage(WebDriver driver)
       {
    	   PageFactory.initElements(driver, this);
       }
//rule 4 : utilisation : right click source 
       // generate getter and setter  
       //->select all-> getsetter -> generate
       
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
       
	//BUsiness Library -->generic method according to the need of project
	/**
	 * this method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
       userNameEdit.sendKeys(USERNAME);
       passwordEdit.sendKeys(PASSWORD);
       loginbtn.click();
	}
}
