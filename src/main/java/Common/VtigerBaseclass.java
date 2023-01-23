package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import DriverUtilities.InstanceClass;
import POMclasses.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerBaseclass extends InstanceClass{
	
	public VtigerLoginPage vtigerLoginPage;
	@BeforeClass
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@BeforeMethod
	public void login() throws IOException {
//		FileInputStream fis= new FileInputStream("./src/test/resources/Commondata.properties");
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		String Url = pobj.getProperty("url");
//		driver.get(Url);
//		String user = pobj.getProperty("username");
//		String pwrd = pobj.getProperty("password");
//		vtigerLoginPage = new VtigerLoginPage(driver);
//		vtigerLoginPage.login(user, pwrd);

	}
	
	@AfterMethod
	public void logout()
	{
	//	vtigerLoginPage.logout(driver);
	}
@AfterClass
public void close()
	{
		driver.close();
	}

}
