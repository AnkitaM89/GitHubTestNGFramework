package pack1;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import config.AppUtil;

public class FirstTestNgClass extends AppUtil {
	@Test
	public void pBanking()
	{
      driver.findElement(By.xpath("(//img)[4]")).click();
      Reporter.log("Executing pBanking Test",true);
	}
	@Test
	public void iBanking()
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing iBanking Test",true);
	}
	@Test
	public void cBanking()
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing cBanking Test",true);
	}
}
