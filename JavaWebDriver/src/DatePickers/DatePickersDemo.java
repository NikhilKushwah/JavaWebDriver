package DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class DatePickersDemo {

	public static void main(String[] args) throws InterruptedException 
	{
		// this project has not been runed fully
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//creating variable
		String month= "February 2022";
		String date="20";
		
		driver.get("http://www.phptravels.net/");
		
		driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
		Thread.sleep(2000);
		
		while(true) // specifying this loop till the expected month returns 
		{
			String text=driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]")).getText();
		
			if(text.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
			
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td[contains(text(),"+date+")]")).click();
		}
	}

}
