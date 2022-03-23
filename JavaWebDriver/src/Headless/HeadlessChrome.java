package Headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.setHeadless(true);             // This method will our chrome browser headless
		
		WebDriver driver=new ChromeDriver(options); // passing option as a parameter here
		
		driver.get("http://demo.nopcommerce.com/");

		System.out.println("Title of the page:"+driver.getTitle()); // This will get the Title of the page
	}

}
