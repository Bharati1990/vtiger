package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Actitimeloginpage {
	
	public Actitimeloginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username") private WebElement userName;
	@FindBy(name = "pwd") private WebElement password;
	@FindBy(xpath = "//input[@id=\"keepLoggedInCheckBox\"]") private WebElement checkBox;
	@FindBy(id = "loginButton") private WebElement LoginButton;
	
	public void loginActitime() {
		userName.sendKeys("admin");
		password.sendKeys("manager");
		checkBox.click();
		LoginButton.click();
	}
	

}
