package aug21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReportsDemo {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;

	@BeforeTest
	public void generateReport()
	{
	  //Define path of html report
      report = new ExtentReports("./Reports/Demo.html");
	}
	@BeforeMethod
	public void setUp()
	{
		driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	@Test
	public void passTest()
	{
		logger = report.startTest("My Test Pass");
		logger.assignAuthor("Ankita");
		logger.assignCategory("Functional Testing");
		String expected = "Google";
		String actual = driver.getTitle();
		if(actual.equalsIgnoreCase(expected))
		{
			logger.log(LogStatus.PASS, " Title is matching \t"+expected+"\t"+actual);
		}
		else
		{
			logger.log(LogStatus.FAIL, " Title is not matching \t"+expected+"\t"+actual);
		}
	}
	@Test
	public void failTest()
	{
		logger = report.startTest("My Test Fail");
		logger.assignAuthor("Ankita");
		logger.assignCategory("Functional Testing");
		String expected = "Yahoo";
		String actual = driver.getTitle();
		if(actual.equalsIgnoreCase(expected))
		{
			logger.log(LogStatus.PASS, " Title is matching \t"+expected+"\t"+actual);
		}
		else
		{
			logger.log(LogStatus.FAIL, " Title is not matching \t"+expected+"\t"+actual);
		}
	}
	@AfterMethod
	public void tearDown()
	{
		//end logging reports to html
		report.endTest(logger);
		report.flush();
		driver.close();
	}

}


