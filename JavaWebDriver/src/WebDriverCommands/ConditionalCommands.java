package WebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.facebook.com/");
		
		//this is for email textbox
		WebElement email=driver.findElement(By.xpath("//*[@id=\"email\"]")); // Storing it as a variable in WebElement
		
		//this is for password textbox
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		
		if(email.isDisplayed() && email.isEnabled())
		{
			email.sendKeys("nicthakur@yahoo.com");
		}
		if(pass.isDisplayed() && pass.isEnabled())
		{
			pass.sendKeys("Nikhilkush@123");
		}
		
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		
		//this is for Female
		//System.out.println(driver.findElement(By.xpath("//*[@class='_8esa'][@value='2']")).isSelected()); // this will return false
		
		//this is for Male
		System.out.println(driver.findElement(By.cssSelector("//*[@value='2'][@name='sex']")).isSelected()); // this will return false

		//select female radio button
		if(driver.findElement(By.cssSelector("//*[@value='2'][@name='sex']")).isSelected()==false)
		{
			driver.findElement(By.cssSelector("//*[@value='2'][@name='sex']")).click();
		}
		
		driver.close(); 
	}

}
