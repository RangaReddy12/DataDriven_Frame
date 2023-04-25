import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender1 {
//Script to Select DOB while Registering a New User in Flights App using : sendKeys()
public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("http://flights.qedgetech.com/");
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.name("dob")).sendKeys("15-10-1980");
}
}
