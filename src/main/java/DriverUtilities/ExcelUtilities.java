package DriverUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	public String FetchDataFromExcel(String Sheetname, int row, int coloumn) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(sh.getRow(row).getCell(coloumn));
	}

}
