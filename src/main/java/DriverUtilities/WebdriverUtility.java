package DriverUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	
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

}
