import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calender3 {

	public static void main(String[] args) {
		//Selecting a Date From Calendar by operating the Calendar
		
				WebDriver driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.get("http://flights.qedgetech.com/");
				driver.findElement(By.linkText("Register")).click();
				driver.findElement(By.name("dob")).click();
				
				String dob = "10-Dec-1990";
				String[] temp =  dob.split("-");
				String dt = temp[0];
				String month = temp[1];
				String year = temp[2];
				
				Select ylist = new Select(driver.findElement(By.className("ui-datepicker-year")));
				ylist.selectByVisibleText(year);
				
				Select mlist = new Select(driver.findElement(By.className("ui-datepicker-month")));
				mlist.selectByVisibleText(month);
				
				WebElement cal = driver.findElement(By.className("ui-datepicker-calendar"));
				
				List<WebElement> rows,cols;
				
				rows = cal.findElements(By.tagName("tr"));
				System.out.println(rows.size());
				for(int i=1;i<rows.size();i++)
				{
					cols = rows.get(i).findElements(By.tagName("td"));
					for(int j=0;j<cols.size();j++)
					{
						if(cols.get(j).getText().equals(dt))
						{
							cols.get(j).click();
							break;
						}
					}
					
				}

	}

}
