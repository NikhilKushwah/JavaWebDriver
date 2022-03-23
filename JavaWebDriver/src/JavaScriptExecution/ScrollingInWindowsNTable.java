package JavaScriptExecution;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingInWindowsNTable {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//writing java script and writing driver outside so that driver can execute javascript
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)"); // this one scrolling only windows
		Thread.sleep(2000);
		
		//This one will scroll into the table vertically
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Storing the 4th column data into List<WebElement>
		List<WebElement> table=driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		// intializing the sum to add the amount which are present in the table
		int sum=0;
		
		//getting the values 
		for(int i=0; i<table.size(); i++)
		{
			//getting text of the values but it is in string so have to convert it into integers
			   System.out.println(Integer.parseInt(table.get(i).getText()));
			   //adding up all the values
			sum=sum + Integer.parseInt(table.get(i).getText());
		}
		
		System.out.println(sum);
		// getting the text of tht amount and converting it into integer
	int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
		

	}

}
