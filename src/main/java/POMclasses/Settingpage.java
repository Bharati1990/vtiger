package POMclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Settingpage {
	public Settingpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class=\"popup_menu_button popup_menu_button_settings \"]")private WebElement Setttings;
	@FindBy(xpath="//div[text()='Manage system settings & configure actiTIME']")private WebElement generalsettings;
	@FindBy(xpath="//select[@id=\"firstHierarchyLevelCodeSelect\"]")private WebElement firstdropdown;
	@FindBy(xpath="//select[@id=\"secondHierarchyLevelCodeSelect\"]")private WebElement seconddropdown;
	public void Settings() {
		Setttings.click();
		generalsettings.click();
		WebElement dropdown = firstdropdown;
		Select s = new Select(dropdown);
		List<WebElement> alloptions = s.getOptions();
		for(WebElement s1:alloptions) {
			System.out.println(s1.getText());
		}
		s.selectByVisibleText("Product Line");
		WebElement d = seconddropdown;
		Select s2 = new Select(d);
		List<WebElement> all = s2.getOptions();
		for(WebElement a:all)
		{
			System.out.println(a.getText());
		}
		s2.selectByVisibleText("Product");
	}

}
