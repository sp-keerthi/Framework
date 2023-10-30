package ContactsTestUsingBaseClass;


import org.testng.Assert;
import org.testng.annotations.Test;
import genericutilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateContactWithorgUsingbaseclassTest extends BaseClass
{
		@Test(groups="ReggressionSuite")
		public void createContactWithOrgTest() throws Throwable
		{							
				    String ORGNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2)+jUtil.getrandomNumber();			    
				    String LASTNAME = eUtil.readtheDatafromExcelsheet("Contacts", 1, 2);
						   
					  //step 5: click on Organization
				       HomePage hp = new HomePage(driver);
				       hp.clickonOrganiationLink();
				       
				      //step 6: click on create Organization look up image
				       OrganizationPage op = new OrganizationPage(driver);
				       op.clickOnOrganizationLookUpImg();
				       
				  //step 7:create new Organization with mandatory fields
				       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				       cnop.createNewOrganization(ORGNAME);
				      
				 //step 8:validate for organization
				       OrganizationInformationPage oip = new OrganizationInformationPage(driver);
				       String orgHeader = oip.getHeaderText();
				       
				       Assert.assertTrue(orgHeader.contains(ORGNAME));
				       System.out.println(orgHeader);
				      /* if(orgHeader.contains(ORGNAME))
				       {
				    	   System.out.println(orgHeader);
				    	   System.out.println("organization created");		    		   
				       }
				       else
				       {
				    	   System.out.println("fail");
				       }
				       */
				 //step 9:click on contacts link
				       hp.clickOnContactsLink();
				       
				 //step 10:click on create contact look up img
				       ContactsPage cp = new ContactsPage(driver);
				       cp.ClickOnCreatecontactsLookUpImg();
				     
				 //step 11: create contact with organization
				       CreateNewContactPage cncp = new CreateNewContactPage(driver);
				       cncp.createNewContact(driver, LASTNAME, ORGNAME);
		         
				 //step 12:validation 
				       ContactInfoPage cip = new ContactInfoPage(driver);
				        String contactHeader = cip.getHeaderText();
				        
				        Assert.assertTrue(contactHeader.contains(LASTNAME));
				        System.out.println(contactHeader);
				        /*
				        if(contactHeader.contains(LASTNAME))
				        {
				        	System.out.println(contactHeader);
				        	System.out.println("pass");
				        }
				        else
				        {
				        	System.out.println("fail");
				        }
				        */
	}	
}
