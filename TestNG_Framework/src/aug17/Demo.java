package aug17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	@Test
	public void checkTitle()
	{
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://yahoo.com");
     String actual = driver.getTitle();
     String expected = "google";
     try {
     Assert.assertEquals(expected, actual,"Title is not matching");
     }
     catch(Throwable t)
     {
    	 Reporter.log(t.getMessage(),true);
     }
     driver.quit();
	}
}
