package WebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertwithOkandCancel {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		//Alert with OK and Cancel Link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		
		//Alert with OK and Cancel Button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/button")).click();
		Thread.sleep(3000);
		
		// Created variable
		String ExpTextOK="You pressed Ok";
		
		//This will close alert box by clicking on OK button
		driver.switchTo().alert().accept();
		
		//Stored in variable 
		String ActText= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p")).getText();

		//checking validation
		if(ExpTextOK.equals(ActText))
		{
			System.out.println("Test is passed");
		}
		else 
		{
			System.out.println("Test is Failed");
		}
		
		//Alert with OK and Cancel Button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/button")).click();
		Thread.sleep(3000);
		
		// Created variable
		String ExpTextCancel="You Pressed Cancel";
		
		driver.switchTo().alert().dismiss(); // This will close the alert box by clicking on cancel button
		
		//Stored in variable 
	    ActText=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p")).getText();
		
	  //checking validation
		if(ExpTextCancel.equals(ActText))
		{
			System.out.println("Test is Passed");
		}
		else 
		{
			System.out.println("Test is Failed");
		}
	}

}
