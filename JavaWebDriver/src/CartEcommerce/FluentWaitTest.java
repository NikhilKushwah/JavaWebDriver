package CartEcommerce;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args)
	{
		//This code is not fully completed
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//this is webdriver interface chromedriver is a class and impleamnting WebDriver interface
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
			
			driver.findElement(By.cssSelector("div[id='start'] button")).click();
			
			//creating wait interface here FluentWait is a class an implementing Wait interface
			// Here it is mentioning 3secs of interval of 30 secs means it will keep on checking 10 times utnil its get the desired output
			Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			
			WebElement foo = wait.until(new Function<WebDriver, WebElement>()

			{

			public WebElement apply(WebDriver driver)

			{
				//driver.findElement(By.cssSelector("div[id='finish'] h4"));
			     return driver.findElement(By.cssSelector("div[id='finish'] h4"));

			}

			});

	}

}
