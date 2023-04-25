package apr21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTesting {
	WebDriver driver;
	@Parameters({"Browser"})
	 @BeforeTest
	  public void setUp(String brw) {
		 switch (brw) {
		case "chrome":
			System.out.println("Executing on chrome");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.out.println("Executing on firefox");
			driver = new FirefoxDriver();
		default:
			System.out.println("Browser value is not matching");
			break;
		}
		 
	  }
 @Test(dataProvider = "dp")
 public void verify_Login(String user,String pass) {
	  driver.get("http://orangehrm.qedgetech.com/");
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.name("txtUsername")).sendKeys(user);
	 driver.findElement(By.name("txtPassword")).sendKeys(pass); 
	 driver.findElement(By.name("Submit")).click();
	 String expected ="dashboard";
	 String actual = driver.getCurrentUrl();
	 if(actual.contains(expected))
	 {
		 Reporter.log("Login Success::"+expected+"      "+actual,true);
	 }
	 else
	 {
		 Reporter.log("Login Fail::"+expected+"      "+actual,true);
	 }
 }

 @DataProvider
 public Object[][] dp() {
  Object login [][]= new Object[4][2];
  login[0][0]="Admin";
  login[0][1]="Qedge123!@#";
  login[1][0]="Admin4";
  login[1][1]="Qedge123!@#";
  login[2][0]="Admin";
  login[2][1]="Qedge123!@#";
  login[3][0]="Admin7";
  login[3][1]="Qedge123!@#";
return login;
  
 }


 @AfterTest
 public void tearDown() {
	  driver.quit();
	  
 }
}
