package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws Throwable {
          //step1:open document in readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\writeData.xlsx");
		
		//step2:create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: navigate to sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//Step4: navigate to row
		Row rw = sh.createRow(1);
		
		//Step5:navigate to cell
		Cell cl = rw.createCell(2);
		
		//step6:capture value
		cl.setCellValue("keerthi");
		
		//step7:create object for fileoutputstreem
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\writeData.xlsx");
		
		wb.write(fos);
		System.out.println("Filecreated");
			}

}
