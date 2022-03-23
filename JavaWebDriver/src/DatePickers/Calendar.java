package DatePickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		//clicking on the date box
		driver.findElement(By.cssSelector("input[id='travel_date']")).click();
		
		//creating while loop and getting the xpath of the month And mentioning ! Negation means if it is true it will become False n if it is false then it will become true
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']  //th[@class='datepicker-switch']")).getText().contains("February 2023"))
		{ 
			//this is to click on next button arrow to go for next month
			driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='next']")).click();
		}
		
		//This is for Date. This Will be storing first all the Dates in WebElement List
		List<WebElement> date=driver.findElements(By.cssSelector("td[class='day']"));
		
		// getting the count of the dates 
		int countdates =driver.findElements(By.cssSelector("td[class='day']")).size();
		
		//will compare the date 17 with the other dates to get output using loops
		for(int i=0; i<countdates; i++)
		{
			//getting the text so from which loop can compare the date
			String text= driver.findElements(By.cssSelector("td[class='day']")).get(i).getText();
			if(text.equals("27"))
			{
				driver.findElements(By.cssSelector("td[class='day']")).get(i).click();
				break;
			}
		}
		
		

	}

}
