package Actitime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import POMclasses.Actitimeloginpage;
import POMclasses.Createcustomerpage;
import POMclasses.GoogleFlipkartpage;
import POMclasses.Logoutpage;
import POMclasses.Settingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeTest
{
	@Test
	public void actitime() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String userName = pobj.getProperty("username");
		String passWord = pobj.getProperty("password");

		String Url = pobj.getProperty("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);

		Actitimeloginpage actitimeloginpage= new Actitimeloginpage(driver);
		actitimeloginpage.loginActitime();

		Createcustomerpage createcustomerpage= new Createcustomerpage(driver);
		createcustomerpage.Newcustomer();

		Settingpage setting= new Settingpage(driver);
		setting.Settings();

		Logoutpage logout = new Logoutpage(driver);
		logout.logout();
		
		GoogleFlipkartpage gf =new GoogleFlipkartpage(driver);
		String Url1 = pobj.getProperty("url1");
		driver.get(Url1);
		gf.Google();

		String Url2 = pobj.getProperty("url2");
		driver.get(Url2);
		gf.Flipkart(driver);




	}


}








//hiii






