package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of Generic methods to read data from 
 * Property files
 * @author user
 *
 */
public class PropertyFileUtility
{
	/**
	 * this method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
     public String readdatafromPropertyfile(String key) throws IOException
     {
    	 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
           Properties p = new Properties();
            p.load(fis);
           String value = p.getProperty(key);
            return value;
     }


	}

