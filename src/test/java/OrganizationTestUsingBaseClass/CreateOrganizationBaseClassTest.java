package OrganizationTestUsingBaseClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationBaseClassTest extends BaseClass
{
    @Test
	public void createorg() throws FileNotFoundException, IOException
	{
    	 String ORGNAME = eUtil.readtheDatafromExcelsheet("organization", 1, 2)+jUtil.getrandomNumber();
    	
    	 //step3:navigate to Organizations link
			
    	 HomePage hp = new HomePage(driver);
	       hp.clickonOrganiationLink();
			
		//Step 4 : Click on Create Organization look Up Imge
	       OrganizationPage op = new OrganizationPage(driver);
	       op.clickOnOrganizationLookUpImg();
	       
		//Step 5: Create Organization with mandatory information
	       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	       cnop.createNewOrganization(ORGNAME);
	       
			 //Step 7: Validate
	       OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	       String OrgHeader = oip.getHeaderText();
	       
	       Assert.assertTrue(OrgHeader.contains(ORGNAME));
	       System.out.println(OrgHeader);
				
			
	}
}
