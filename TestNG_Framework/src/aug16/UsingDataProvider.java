package aug16;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class UsingDataProvider {
	WebDriver driver;
	@BeforeTest
	public void setUp() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Running pre condition",true);
	}
	@Test(dataProvider = "dp")
	public void verify_Login(String user, String pass) {
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys(user);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(pass);
		driver.findElement(By.cssSelector("#btnLogin")).click();
		String Expected ="dashboard";
		String Actual = driver.getCurrentUrl();
		/*
		 * if(Actual.contains(Expected)) {
		 * Reporter.log("Login success::"+Expected+"     "+Actual,true); } else {
		 * Reporter.log("Login Fail::"+Expected+"     "+Actual,true); }
		 */
		try {
			Assert.assertFalse(Actual.contains(Expected),"Login Successful");
		}
		catch(Throwable t)
		{
			Reporter.log(t.getMessage(),true);
		}
		try {
			Assert.assertTrue(Actual.contains(Expected),"Login Fail");
		}
		catch(Throwable t)
		{
			Reporter.log(t.getMessage(),true);
		}
	}

	@DataProvider
	public Object[][] dp() {
		Object login [][]= new Object[5][2];//five rows and 2 cells
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin";
		login[1][1]="qedge123!@#";
		login[2][0]="test";
		login[2][1]="Qedge123!@#";
		login[3][0]="admin";
		login[3][1]="Qedge123!@#";
		login[4][0]="Admin";
		login[4][1]="Qedge123!@#";//Check emailablereport.html
		return login;
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
		Reporter.log("Running post condition",true);
	}

}
