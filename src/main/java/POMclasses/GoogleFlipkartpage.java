package POMclasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleFlipkartpage {
	public GoogleFlipkartpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")private WebElement Search;
	@FindBy(xpath="//div[@class=\"erkvQe\"]//ul/li//div[@class=\"wM6W7d\"]/span")private List<WebElement> Suggestion;
	@FindBy(xpath="//button[text()='✕']")private WebElement cancel;
	@FindBy(xpath="//div[@class=\"InyRMC _3Il5oO\"]")private WebElement list;
	@FindBy(xpath="//div[text()='Grocery']")private WebElement grocery;
	//@FindBy(xpath="//div[text()='Grocery']")private WebElement g;
	public void Google() throws InterruptedException
	{
		
	Search.sendKeys("virat");
	 List<WebElement> suggestion = Suggestion;
	 for(WebElement b:suggestion)
	 {
		 System.out.println(b.getText());
	 }
	}
	 public void Flipkart(WebDriver driver) throws IOException
	 {
		 cancel.click();
		 WebElement session = list;
		 File src1 = session.getScreenshotAs(OutputType.FILE);
			File trg1 = new File("./screen/flipkart1.png");
			FileUtils.copyFile(src1, trg1);
			WebElement session1 = grocery;
			File src2 = session1.getScreenshotAs(OutputType.FILE);
			File trg2 = new File("./screen/flipkart2.png");
			FileUtils.copyFile(src2, trg2);
			Actions act = new Actions(driver);
			act.moveToElement(grocery).click().build().perform();
		 
	 }

}

