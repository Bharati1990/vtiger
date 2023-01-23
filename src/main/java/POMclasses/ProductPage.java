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

public class ProductPage
{
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Products']")private WebElement products;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"productname\"]")private WebElement productname;
	@FindBy(xpath="//select[@name=\"productcategory\"]")private WebElement category;
	@FindBy(xpath="//td/form[@name=\"EditView\"]/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;
	@FindBy(xpath="//span[@id=\"dtlview_Product Name\"]")private WebElement verify;
	
	public void product() throws EncryptedDocumentException, IOException 
	{
		products.click();
		addicon.click();
		//FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		//Workbook book = WorkbookFactory.create(fis);
		//Sheet sh = book.getSheet("Sheet1");
		//DataFormatter format = new DataFormatter();
		//String value4 = format.formatCellValue(sh.getRow(5).getCell(0));
		ExcelUtilities excelUtilities = new ExcelUtilities();
		String value = excelUtilities.FetchDataFromExcel("Sheet1", 5, 0);
		JavaUtility javaUtility = new JavaUtility();
		int randomNumber = javaUtility.Random(1000);
		String value4 = value+randomNumber;
		productname.sendKeys(value4);
		
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		
		WebElement c = category;
		webdriverUtility.selectByVisibleText(c, "Hardware");
		//Select s = new Select(c);
	//	s.selectByVisibleText("Hardware");
		
		save.click();
		
		String name = verify.getText();
		System.out.println(name);
		Assert.assertEquals(value4,name,"Fail");
		
	}

}
