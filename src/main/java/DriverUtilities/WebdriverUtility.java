package DriverUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility{
	
	public void selectByValue(WebElement webelement , String value)
	{
		Select s = new Select(webelement);
		s.selectByValue(value);
	}
	public void selectByVisibleText(WebElement webelement , String text)
	{
	Select s = new Select(webelement);
	s.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement webelement , Integer index)
	{
		Select s = new Select(webelement);
		s.selectByIndex(index);
		
	}
	public void screenshotEntirePage(WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./screenshot/vtiger.png");
		FileUtils.copyFile(src, trg);
	}
	public void sessionScreenshot(WebDriver driver,String locator,JavaUtility javaUtility) throws IOException
	{
		WebElement session = driver.findElement(By.xpath(locator));
		File src = session.getScreenshotAs(OutputType.FILE);
		File trg = new File("./screenshot/vtiger1.png"+javaUtility.Random(1000));
		FileUtils.copyFile(src, trg);
	}
	public void sessionWebelement(WebDriver driver,String locator, JavaUtility javaUtility) throws IOException
	{
		WebElement session = driver.findElement(By.xpath(locator));
		File src = session.getScreenshotAs(OutputType.FILE);
		File trg = new File("./screenshot/vtiger2.png"+javaUtility.Random(1000));
		FileUtils.copyFile(src, trg);
		
	}

}
