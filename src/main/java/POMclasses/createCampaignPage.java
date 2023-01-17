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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DriverUtilities.ExcelUtilities;
import DriverUtilities.InstanceClass;

public class createCampaignPage  {

	public createCampaignPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='More']")private WebElement more;
	@FindBy(xpath="//a[text()='Campaigns']") private WebElement campaign;
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")private WebElement addicon;
	@FindBy(xpath="//input[@name=\"campaignname\"]")private WebElement campaignName;
	@FindBy(xpath="//div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")private WebElement save;
	@FindBy(xpath="//span[@id=\"dtlview_Campaign Name\"]")private WebElement verify;

	public void campaign(WebDriver driver) throws EncryptedDocumentException, IOException {
		Actions act = new Actions(driver);
		act.moveToElement(more).click().build().perform();
		campaign.click();
		addicon.click();
		ExcelUtilities excelUtilities= new ExcelUtilities();
		String value = excelUtilities.FetchDataFromExcel("Sheet1", 0, 0);
		campaignName.sendKeys(value);
		save.click();
		String campaignname = verify.getText();
		System.out.println(campaignname);
		Assert.assertEquals(value, campaignname,"Fail");
		}

}
