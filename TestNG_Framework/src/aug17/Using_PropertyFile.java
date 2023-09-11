package aug17;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Using_PropertyFile {
	Properties conpro;
	WebDriver driver;
	@Test
	public void startTest()throws Throwable
	{
		conpro = new Properties();
		//load file
		conpro.load(new FileInputStream("Login.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("objUser"))).sendKeys(conpro.getProperty("enterUser"));
		driver.findElement(By.xpath(conpro.getProperty("objPass"))).sendKeys(conpro.getProperty("enterPass"));
		driver.findElement(By.xpath(conpro.getProperty("objLogin"))).click();
		String expected ="dashboard";
		String actual = driver.getCurrentUrl();
		try {
		Assert.assertFalse(actual.contains(expected),"Login Succesful");
		Assert.assertTrue(actual.contains(expected),"Login Failed");
		}
		catch(Throwable t)
		{
			Reporter.log(t.getMessage(),true);
		}
		driver.quit();
	}
}
