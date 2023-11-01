package ContactsTestUsingBaseClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericutilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

//using listeners implementation class (listeners in class level)
@Listeners(genericutilities.ListenersImplementationClass.class)
public class CreateContactBaseClassTest extends BaseClass
{

	@Test(groups = {"SmokeSuite","ReggressionSuite"})
	public void createconntact() throws Throwable
	{
    	
       String LASTNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();		
		
	//step3:navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
	//this is low level Reporting : print only in reports
		Reporter.log("clicked on contacts link");
		
	//step4:click on create contact look up img 
		
		ContactsPage cp = new ContactsPage(driver);
	       cp.ClickOnCreatecontactsLookUpImg();
		Reporter.log("create contact look up img");
		
   //Step 5: create conatact
	       CreateNewContactPage cncp = new CreateNewContactPage(driver);
	       cncp.createNewContact(LASTNAME);
           Reporter.log("Header captured");
	       
   // step 7 :validation
	       ContactInfoPage cip = new ContactInfoPage(driver);
	        String contactHeader = cip.getHeaderText();
	        Reporter.log("Hedder Captured");
	      
	      //  Assert.fail();// forcefully fail the script to get screenshot
	        Assert.assertTrue(contactHeader.contains(LASTNAME));
	     
	        Reporter.log("Hedder valiated");
	        //this statment will not be printed in message in report because of assert fail
	        
	        System.out.println(contactHeader);
}
	@Test
	public void demo()
	{
		System.out.println("demo");
		//System.out.println("demo executed");
	}
}