package OrganizationTestUsingBaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import genericutilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrgWithInIndustryBASEClassTest extends BaseClass
{
		
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG,String INDUSTRYNAME) throws IOException, InterruptedException
	{	
		String ORGNAME = ORG+jUtil.getrandomNumber();
			
	  //step 5: click on Organization
	       HomePage hp = new HomePage(driver);
	       hp.clickonOrganiationLink();
	       
	  //step 6: click on create Organization look up image
	       OrganizationPage op = new OrganizationPage(driver);
	       op.clickOnOrganizationLookUpImg();
	       
	  //step 7:create new Organization with mandatory fields
	       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	       cnop.createNewOrganization(ORGNAME,INDUSTRYNAME);
	       wUtil.captureScreenShot(driver, ORGNAME);
	       
	 //step 8:validate for organization
	       OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	       String orgHeader = oip.getHeaderText();
	       
	       Assert.assertTrue(orgHeader.contains(ORGNAME));
	       System.out.println(orgHeader);
	           
	 		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException,IOException,Exception 
	{
		return eUtil.readMultipleData("MultipleOrganizations");
	}
}



