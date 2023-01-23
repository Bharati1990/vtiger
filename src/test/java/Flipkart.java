

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Common.VtigerBaseclass;
import DriverUtilities.JavaUtility;
import DriverUtilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart extends VtigerBaseclass {
	
	@Test
	public void Flipkartdemo() throws IOException
	{
		
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		JavaUtility javaUtility= new JavaUtility();
		webdriverUtility.screenshotEntirePage(driver);
		String locator = "//div[@class=\"InyRMC _3Il5oO\"]";
		webdriverUtility.sessionScreenshot(driver, locator, javaUtility);
		String locator1 = "//div[@class=\"eFQ30H\"][1]";
		webdriverUtility.sessionWebelement(driver, locator1, javaUtility);
	}

}
