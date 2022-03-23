package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingAssignment {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.cleartrip.com/");
		
		//driver.findElement(By.cssSelector(".flex.flex-middle.p-relative.homeCalender")).click();
	//	driver.findElement(By.xpath("//div[@aria-label='Fri Dec 31 2021']")).click();
		
		WebElement options=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select"));
		
		Select dropdown=new Select(options);
		dropdown.selectByIndex(3);

		
		WebElement options2=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[3]/select"));
		
		Select dropdwon2=new Select(options2);
		dropdwon2.selectByIndex(1);
		
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[5]/div/div/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[7]/div[2]/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[6]/div/div[3]/div/div/div/input")).sendKeys("indigo");
		
		driver.findElement(By.xpath("//p[contains(text(),'IndiGo (6E)')]")).click();
	}

}
