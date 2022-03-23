package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		Actions a=new Actions(driver);
		//using keyDown() method and doubleclick() method this will click in the searchbox enter the name and double click that name
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("protien").doubleClick().build().perform();
		
		WebElement move=driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		//here mouseOver on account List and rightclicking on it
		a.moveToElement(move).contextClick().build().perform();
		

	}

}
