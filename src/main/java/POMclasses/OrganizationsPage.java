package POMclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

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

public class OrganizationsPage {
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[@align=\"center\"]/a[text()='Organizations']")private WebElement organization;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"accountname\"]")private WebElement organizationname;
	@FindBy(xpath="//select[@name=\"industry\"]")private WebElement industry;
	@FindBy(xpath="//select[@name=\"accounttype\"]")private WebElement type;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;
	@FindBy(xpath="//td/span[@id=\"dtlview_Organization Name\"]")private WebElement verify;
	
	public void organizations() throws EncryptedDocumentException, IOException
	{
		organization.click();
		addicon.click();
		JavaUtility javaUtility = new JavaUtility();
		 int number = javaUtility.Random(1000);
		//Random r = new Random();
		//int number = r.nextInt(1000);
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		ExcelUtilities excelUtilities = new ExcelUtilities();
		String value1 = excelUtilities.FetchDataFromExcel("Sheet1", 4, 0);
		//FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
	//	Workbook book = WorkbookFactory.create(fis);
		//Sheet sh = book.getSheet("Sheet1");
		//DataFormatter format = new DataFormatter();
		//String value1 = format.formatCellValue(sh.getRow(4).getCell(0));
		String orgname = value1+number;
		organizationname.sendKeys(orgname);
		
		WebElement i = industry;
		webdriverUtility.selectByVisibleText(i, "Government");
		//Select s = new Select(i);
		//s.selectByVisibleText("Government");
		
		WebElement t = type;
		webdriverUtility.selectByVisibleText(t, "Customer");
		//Select s1 = new Select(t);
		//s1.selectByVisibleText("Customer");
		
		save.click();
		
		String name = verify.getText();
		System.out.println(name);
		Assert.assertEquals(orgname,name,"Fail");
	}

}
