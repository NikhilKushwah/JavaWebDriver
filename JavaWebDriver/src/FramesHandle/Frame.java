package FramesHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/resizable/");
		//driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[1]/a")).click();
		
		
		
		

	}

}
