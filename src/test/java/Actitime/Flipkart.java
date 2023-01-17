package Actitime;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Flipkart {
	@Test
	public void FlipkartSort()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys("iphone x",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class=\"_1TmfNK\"][1]"));
		LinkedList<String> list= new LinkedList<String>();
		List<WebElement> s = driver.findElements(By.xpath("//div[@class=\"_3pLy-c row\"]/div[2]/div[1]/div[1]/div[1]"));
		 
		Iterator<WebElement> phoneprice = s.iterator();
		TreeSet<String> set= new TreeSet<String>();
		while(phoneprice.hasNext())
		{
			String s1=phoneprice.next().getText().split("₹")[1];
			String s2 = s1.split(",")[0];
			String s3 = s1.split(",")[1];
			String s5=s2+""+s3;
			
			set.add(s5);
			list.add(s5);
		}
		System.out.println(list);
		System.out.println(set);
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
	}

}
