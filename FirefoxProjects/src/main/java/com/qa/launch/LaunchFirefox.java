package com.qa.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchFirefox {
	static WebDriver driver;


	public static void main(String[] args)
	{
		
		if(Constant.browsername.equals("chrome"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(Constant.browsername.equals("firefox"));
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\NK\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get("http://www.facebook.com");
		
		String title=driver.getTitle();
		System.out.println("Page Title is: "+title);
		
		
		driver.close();

	}

}
