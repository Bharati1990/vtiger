package POMclasses;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverUtilities.ExcelUtilities;
import DriverUtilities.JavaUtility;

public class WindowpopupPage
{
	public WindowpopupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//a[@href=\"index.php?module=Accounts&action=index\"]")private WebElement organization;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"accountname\"]")private WebElement organizationname;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;

	@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")private WebElement contacts;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon1;
	@FindBy(xpath="//input[@name=\"lastname\"]")private WebElement lastname;
	@FindBy(xpath="//td[text()='Organization Name 			']/following-sibling::td[1]/img")private WebElement icon;
	@FindBy(xpath="//input[@id=\"search_txt\"]")private WebElement searchbar;
	@FindBy(xpath="//input[@name=\"search\"]")private WebElement searchnow;
	@FindBy(xpath="//a[@id=\"1\"]")private WebElement list;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save1;
	@FindBy(xpath="//span[@id=\"dtlview_Last Name\"]")private WebElement verifylastname;
	@FindBy(xpath="//td[text()='Organization Name']/following-sibling::td[1]/a")private WebElement verifyorganisationname;




	public void windowpopup(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		organization.click();
		addicon.click();
	//	FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.xlsx");
		//Workbook book = WorkbookFactory.create(fis);
	//	Sheet sh = book.getSheet("Sheet1");
	//	DataFormatter format = new DataFormatter();
		JavaUtility javaUtility = new JavaUtility();
	int number = javaUtility.Random(1000);
		//Random r = new Random();
		//int number = r.nextInt(1000);
		//String value1 = format.formatCellValue(sh.getRow(4).getCell(0));
		ExcelUtilities excelUtilities = new ExcelUtilities();
		String value1 = excelUtilities.FetchDataFromExcel("Sheet1", 4, 0);
		
		String orgname = value1+number;
		organizationname.sendKeys(orgname);
		save.click();

		Thread.sleep(5000);

		contacts.click();
//		//Explicit wait
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class=\"moduleName\"]/a[text()='Contacts']")));
		addicon1.click();
		//Random r1 = new Random();
		//int no = r1.nextInt(1000);
		String value = excelUtilities.FetchDataFromExcel("Sheet1", 1, 0);
		//String value = format.formatCellValue(sh.getRow(1).getCell(0));
		String cname = value+number;
		lastname.sendKeys(value);
		icon.click();
		String pid = driver.getWindowHandle();
		Set<String> cid = driver.getWindowHandles();
		for(String i:cid) {
			if(!i.equals(pid)) {
				driver.switchTo().window(i);
			}
		}
		searchbar.sendKeys(orgname);
		searchnow.click();
		Thread.sleep(10000);
		list.click();
		driver.switchTo().window(pid);
		save1.click();
		String lname = verifylastname.getText();
		System.out.println(lname);
		Assert.assertEquals(value, lname, "Fail");
		

		String onam = verifyorganisationname.getText();
		System.out.println(onam);
		Assert.assertEquals(orgname, onam, "Fail");
		

	}


}
