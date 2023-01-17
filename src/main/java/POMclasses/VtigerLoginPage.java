package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	
	public VtigerLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name=\"user_name\"]") private WebElement username;
	@FindBy(xpath = "//input[@name=\"user_password\"]")private WebElement password;
	@FindBy(id = "submitButton")private WebElement submit;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement Icon;
	@FindBy(xpath="//a[text()='Sign Out']")private WebElement signout;

	public void login(String userName , String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		submit.click();
		
	}
	public void logout(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(Icon).click().build().perform();
		signout.click();
	}

}
