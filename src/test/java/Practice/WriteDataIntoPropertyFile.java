package Practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		p.setProperty("username", "admin");
		p.setProperty("password", "admin");
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\WriteData.properties.txt");
        p.store(file,"this is my file");
        System.out.println("file created");
	}

}
