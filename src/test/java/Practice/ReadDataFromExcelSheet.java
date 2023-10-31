package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		
		//Step2: create a work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		

		//Step4: navigate to required row
		Row rw = sh.getRow(1);
		
		//step5:navigate to required cell
		Cell cl = rw.getCell(2);
		
		//Step6: capture the value and print
         String value = cl.getStringCellValue();
		System.out.println(value);
		
	}

}
