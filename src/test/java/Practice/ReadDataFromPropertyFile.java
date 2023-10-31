package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//Step1:open document in java readable format
	 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
	//Step2:create object of properties for jav.util package
	
		Properties p = new Properties();
	 
	//step3:load file input stream into properties
	  
		p.load(fis);	
	
		//step4:provide key and read values
	
		String value = p.getProperty("browser");
	System.out.println(value);
	}

}
