package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
public Logoutpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//div[text()='Tasks']")private WebElement task;
@FindBy(xpath="//input[@value=\"Discard Changes\"]")private WebElement discardchanges;
@FindBy(xpath="//div[text()='All Customers']")private WebElement allcustomers;
@FindBy(xpath="//div[@class=\"taskRowsTableContainer\"]/table/tbody/tr[1]/td[1]/div")private WebElement taskrow;
@FindBy(xpath="//div[@class=\"delete button\"]")private WebElement Delete;
@FindBy(xpath="//div[text()='You are about to delete a task']")private WebElement popup;
@FindBy(xpath="//a[text()='Logout']")private WebElement logout;
public void logout()
{
	task.click();
	discardchanges.click();
	allcustomers.click();
	taskrow.click();
	Delete.click();
	String msg = popup.getText();
	logout.click();
}
}
