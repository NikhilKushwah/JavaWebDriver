package HandligWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromAndToDropdown {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//this is webdriver interface chromedriver is a class and impleamnting WebDriver interface
		WebDriver driver=new ChromeDriver();
		//Dynamic Dropdown
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();// mentioning 2 in index so it can choose from the TO dropdown boc

		// There is one more way to select the city name instead of using index in real time some ppl may not lyk indexes in ur code
		// So we can use Parent to Child relationship  traverse
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		
		//Selecting current Date in Calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
	}

}
