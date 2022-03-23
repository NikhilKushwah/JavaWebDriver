package WebDriverCommands;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountingLinks {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		//introducing implicity wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// GETTING THE COUNT OF LINK ON ENTIRE PAGE
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting WebDriver Scope
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		
		//getting count of the link which are present on footer
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//getting count of the link of 1st column
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		
		//Open all the Links which are present in the 1st column in seprate tab without going back 
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			// This will open the link sepratley without going back which are present 
			String clickonLinkTab=Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			//this will get the link from the for loop and calling the above variable to click
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
			
		}
		
		//using WindowHandles
		Set <String> abc=driver.getWindowHandles();
		
		//Using Iterator to get the Id's of the links
		Iterator<String> it=abc.iterator();
		
		//Using While loop to fetch all the links
		while(it.hasNext()) //.hasNext means it will check wether there is another link present or not
		{
			driver.switchTo().window(it.next()); // This will go to the next window
			System.out.println(driver.getTitle()); // This will get the title of all the links which are opened
			
		}
		
		
	}

}
