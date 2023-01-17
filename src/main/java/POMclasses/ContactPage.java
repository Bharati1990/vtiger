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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import DriverUtilities.ExcelUtilities;
import DriverUtilities.JavaUtility;
import DriverUtilities.WebdriverUtility;

public class ContactPage {
	
	public ContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")private WebElement contacts;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"lastname\"]")private WebElement lastname;
	@FindBy(xpath="//select[@name=\"leadsource\"]") private WebElement dropdown;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;
	@FindBy(xpath="//span[@id=\"dtlview_Last Name\"]")private WebElement verify;
	
	public void contact() throws EncryptedDocumentException, IOException
	{
		contacts.click();
		addicon.click();
	
		//	FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		//Workbook book = WorkbookFactory.create(fis);
		//Sheet sh = book.getSheet("Sheet1");
		//DataFormatter format = new DataFormatter();
		//String value1 = format.formatCellValue(sh.getRow(1).getCell(0));
		ExcelUtilities excelUtilities = new ExcelUtilities();
		String value = excelUtilities.FetchDataFromExcel("Sheet1", 1, 0);
		JavaUtility javaUtility = new JavaUtility();
		int randomNumber = javaUtility.Random(1000);
		String value1 = value+randomNumber;
		lastname.sendKeys(value1);
		
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		
		
		WebElement d = dropdown;
		webdriverUtility.selectByVisibleText(d, "Employee");
		//Select s = new Select(d);
		//s.selectByVisibleText("Employee");
		save.click();
		String lastName = verify.getText();
		System.out.println(lastName);
		Assert.assertEquals(value1,lastName,"Fail");
		}
	}


