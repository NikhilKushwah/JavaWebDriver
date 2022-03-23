package WebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.facebook.com/"); // will open the url
	    System.out.println(driver.getTitle());
	    
	    driver.navigate().to("http://gmail.com/");// will navigate to other website
	    System.out.println(driver.getTitle());
	    
	    driver.navigate().back(); // will come back to the previous website
	    System.out.println(driver.getTitle());
	    
	    driver.navigate().forward(); // will navigate again to the other website which is already opened
	    System.out.println(driver.getTitle());
	    
	    driver.navigate().refresh();
	    
	    driver.close(); // both the website was opened in same window it will close only one window
		
		

	}

}
