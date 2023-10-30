package genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of generic method to read data
 * from excel sheet
 * @author user
 *
 */
public class ExcelFileUtility
{
	/**
	 * this method will read the data from excel sheet and return the value to caller
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public String readtheDatafromExcelsheet(String SheetName,int rowno,int cellno) throws FileNotFoundException ,IOException  
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
		
	}
	/**
	 * this method will read multiple data form excel sheet at time
	 * used for data provider
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public Object[][] readMultipleData(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();				
			}
		}
		return data;
	}
}
