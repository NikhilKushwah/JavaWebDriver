package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String password= getPassword(driver); // calling the other method into main method storing password into string variable
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Nikhil");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
	//	Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		driver.findElement(By.className("logout-btn")).click();

	}
	
	//Getting password dynamically creating another method
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		//storing this into string variable
		String PasswordText=driver.findElement(By.tagName("p")).getText();
		//tring to slipt these words:- Please use temporary password 'rahulshettyacademy' to Login
		String[] passwordArray= PasswordText.split("'"); //Please use temporary password '
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to Login
				
		String[] passwordArray2= passwordArray[1].split("'"); //rahulshettyacademy' to Login
		//0th index - rahulshettyacademy
		//1st index - ' tp Login
		String password= passwordArray[1].split("'")[0]; // so we are getting 0th index
		return password;
		
		
		
	}

}
