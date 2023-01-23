package POMclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DriverUtilities.ExcelUtilities;
import DriverUtilities.WebdriverUtility;

public class DocumentPage {
	
	public DocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Documents']")private WebElement documents;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"notes_title\"]")private WebElement title;
	@FindBy(xpath="//iframe[@title=\"Rich text editor, notecontent, press ALT 0 for help.\"]")private WebElement description;
	@FindBy(xpath = "//body[@class=\"cke_show_borders\"]") private WebElement descText;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/div[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;
	@FindBy(xpath="//span[@id=\"dtlview_Title\"]")private WebElement verifytitle;
	@FindBy(xpath="//td/p")private WebElement verifydescription;
	
	public void document(WebDriver driver ) throws EncryptedDocumentException, IOException
	{
		documents.click();
		addicon.click();
	//	FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		//Workbook book = WorkbookFactory.create(fis);
	//	Sheet sh = book.getSheet("Sheet1");
	//	DataFormatter format = new DataFormatter();
		//String value2 = format.formatCellValue(sh.getRow(2).getCell(0));
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		ExcelUtilities excelUtilities = new ExcelUtilities();
		String value2 = excelUtilities.FetchDataFromExcel("Sheet1", 2, 0);
		title.sendKeys(value2);
		driver.switchTo().frame(description);
	//	String value3 = format.formatCellValue(sh.getRow(3).getCell(0));
		String value3 = excelUtilities.FetchDataFromExcel("Sheet1", 3, 0);
		descText.sendKeys(value3);
		driver.switchTo().parentFrame();
		save.click();
		String title = verifytitle.getText();
		System.out.println(title);
		Assert.assertEquals(value2,title,"Fail");
	String msg = verifydescription.getText();
	System.out.println(msg);
		
	
	}

}
////body[@class="cke_show_borders"]