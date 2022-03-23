package Miscelleanous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeletingCookies {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize(); //This will maximize the window
		//before hitting the URL it will delete all the cookies
		driver.manage().deleteAllCookies(); // This will delete all the cookies
		
		//This will delete particular cookie from the site
		//driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("http://google.com");
		
		//This will take a screenshot copy it and save it into your local system
	    File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\NK\\ScreenShot.png"));
		
		

	}

}
