package WebDriverCommands;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a/button")).click();
		
		//check how many windows and its Id are opened by using Set class which stores multiple things in it 
		
		// <String> its a cascading string type
		Set <String> s=driver.getWindowHandles();
		
		// use for loop to get how many windows are opened
		
		for(String i:s)
		{
			// Get the ID of the Window
			System.out.println(i);
			// OR u can get the Title name of the windows also
			String t=driver.switchTo().window(i).getTitle();
			System.out.println(t);
			
			if(t.contains("Selenium"))
			{
				driver.close();
			}
		}
		

	}

}
