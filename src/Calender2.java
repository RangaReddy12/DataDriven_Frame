import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender2 {

	public static void main(String[] args) {
		//Script to Select DateOfFly in Flights App using : sendKeys()
		//-------------------------------------------------------------------------------------
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
				WebDriver driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.get("http://flights.qedgetech.com/");
				driver.findElement(By.name("email")).sendKeys("pranga82@gmail.com");
				driver.findElement(By.name("password")).sendKeys("ranga123");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				driver.findElement(By.id("search-date")).sendKeys("8/15/2024");	

	}

}
