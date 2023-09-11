package aug17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
	@Test
	public void checkTitle()
	{
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://google.com");
     String actual = driver.getTitle();
     String expected = "Yahoo";
     try {
     Assert.assertTrue(expected.equalsIgnoreCase(actual),"Title is not matching");
     }
     catch(Throwable t)
     {
    	 Reporter.log(t.getMessage(),true);
     }
     driver.quit();
	}
}
