package pack1;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import config.AppUtil1;

public class SecondTestNgClass extends AppUtil1 {
	@Test(priority = 2,enabled = true,invocationCount=5)
	public void addition()
	{
		driver.findElement(By.name("display")).sendKeys("98765");
		driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
		driver.findElement(By.name("display")).sendKeys("8765");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		//capture result value
		String Addres = driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(Addres+"  "+"Executing Addtion Test",true);
		
	}
	@Test(enabled=false)
	public void multiplication()
	{
		driver.findElement(By.name("display")).sendKeys("67678");
		driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
		driver.findElement(By.name("display")).sendKeys("6546");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		//capture result value
		String mulres = driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(mulres+"  "+"Executing Multiplication Test",true);
		
	}
	@Test
	public void division()
	{
		driver.findElement(By.name("display")).sendKeys("4465654");
		driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
		driver.findElement(By.name("display")).sendKeys("78");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		//capture result value
		String divres = driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log(divres+"  "+"Executing Division Test",true);
		
	}
}
