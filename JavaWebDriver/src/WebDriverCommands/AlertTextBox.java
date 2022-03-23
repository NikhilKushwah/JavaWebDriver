package WebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTextBox {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//this is webdriver interface chromedriver is a class and impleamnting WebDriver interface
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		// Alert with Textbox link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		
		//Alert with textbox button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/button")).click();
		
		driver.switchTo().alert().sendKeys("Nikhil");
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		String ExptText="Hello Nikhil How are you today";
		
	
		String ActText=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/p")).getText();
		
		if(ExptText.equals(ActText))
		{
			System.out.println("Test is Passed");
		}
		else
		{
			System.out.println("Test is Failed");
		}
	}
	

}
