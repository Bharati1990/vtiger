package POMclasses;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Createcustomerpage {
	
	public Createcustomerpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='Tasks']") private WebElement tasks;
	@FindBy(xpath="//div[text()='Add New']") private WebElement addnew;
	@FindBy(xpath="//div[@class=\"item createNewCustomer\"]") private WebElement createnewcustomer;
	@FindBy(xpath="//input[contains(@class,'newNameField')]") private WebElement newnamefield;
	@FindBy(xpath="//textarea[@placeholder=\"Enter Customer Description\"]") WebElement customerdescription;
	@FindBy(xpath="//div[text()='Create Customer']") private WebElement createcustomer;
	@FindBy(xpath="//div[@class=\"titleEditButtonContainer\"]") private WebElement editbutton;
	public void Newcustomer() throws InterruptedException
	{
		tasks.click();
		addnew.click();
		createnewcustomer.click();
		Random r = new Random();
		int i = r.nextInt(1000);
		String name ="Ram"+i;
		newnamefield.sendKeys(name);
		customerdescription.sendKeys("Engineer");
		createcustomer.click();
		Thread.sleep(5000);
		String str1 = editbutton.getText();
		Assert.assertEquals(name, str1, "Not same");
	}

}
