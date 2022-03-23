package WebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseAndQuit {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.firefox.marionette", "C://Users//NK//Downloads//geckodriver-v0.30.0-win64//geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		//driver.get("http://www.facebook.com/");
		
		driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[")).click();
		
		driver.close(); // will close only one window
		
		//driver.quit(); // will close multiple windows

	}

}
