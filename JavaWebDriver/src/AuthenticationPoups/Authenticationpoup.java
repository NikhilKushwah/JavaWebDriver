package AuthenticationPoups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authenticationpoup {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// use username and password before the url 
		//http://username:password@url.com/
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//String Text= driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();
		
		//Or can use CSS Selector also
		String Text=driver.findElement(By.cssSelector("p")).getText();
		
		System.out.println(Text);

	}

}
