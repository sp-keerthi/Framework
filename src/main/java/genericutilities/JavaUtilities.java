package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class consist of generic method related to java
 * @author user
 *
 */
public class JavaUtilities 
{
	/**
	 * this method will generate a random number for every run
	 * and return it to caller
	 * @return
	 */
    public int getrandomNumber()
    {
    	Random ran = new Random();
    	int r = ran.nextInt(1000);
    	return r;
    }
    /**
     * This method will capture the current system date in required format
     * @return
     */
    public String getSystemDate()
    {
    	 Date d = new Date();
    	  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
           String date = formatter.format(d);
           return date;
    }
}
