package pack1;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import config.AppUtil2;

public class ThirdTestNgClass extends AppUtil2 {
@Test
public void clickAdmin()
 {
	driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
	Reporter.log("Executing Admin Test",true);
 }
@Test
public void clickPim()
 {
	driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	Reporter.log("Executing Pim Test",true);
 }
@Test
public void clickLeave()
 {
	driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
	Reporter.log("Executing Leave Test",true);
 }
}
