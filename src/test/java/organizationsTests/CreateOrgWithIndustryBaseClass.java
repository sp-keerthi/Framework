package organizationsTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtiliy;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateOrgWithIndustryBaseClass extends BaseClass
{
	@Test
	public void createorgwithindustry(String ORG,String INDUSTRY) throws FileNotFoundException, IOException
	{
		
			 //   String ORGNAME = eUtil.readtheDatafromExcelsheet("organization", 1, 2)+jUtil.getrandomNumber();
		String ORGNAME = ORG+jUtil.getrandomNumber();	   
		
			  //step 5: click on Organization
			       HomePage hp = new HomePage(driver);
			       hp.clickonOrganiationLink();
			       
			  //step 6: click on create Organization look up image
			       OrganizationPage op = new OrganizationPage(driver);
			       op.clickOnOrganizationLookUpImg();
				
			     //step 7:create new Organization with mandatory fields
			     
			       CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			       cnop.createNewOrganization(ORGNAME, INDUSTRY);
			     
			     //step 8:validate for organization
			       OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			       String orgHeader = oip.getHeaderText();
			       
			       Assert.assertTrue(orgHeader.contains(ORGNAME));
			       System.out.println(orgHeader);
			       
		     
	}

}
