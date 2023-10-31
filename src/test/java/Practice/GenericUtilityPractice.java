package Practice;

import java.io.IOException;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtilities;
import genericutilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException
	{
		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.readdatafromPropertyfile("browser");
        System.out.println(URL);
        
        ExcelFileUtility eutil = new ExcelFileUtility();
        String value = eutil.readtheDatafromExcelsheet("Organization",4,3);
        System.out.println(value);
        
        JavaUtilities jUtil = new JavaUtilities();
	    int r = jUtil.getrandomNumber();
	    System.out.println(r);
	    
	    String date = jUtil.getSystemDate();
	System.out.println(date);
	}

}
