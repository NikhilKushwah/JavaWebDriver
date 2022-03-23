package DatePickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {

	public static void main(String[] args)
	{
		// this project has not been runed fully
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.expedia.ca/");
		
		driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		
		String month="February 2022";
		String exptdate="17";
		
		while(true) // looping until we get the expected month which is this February 2022
		{
		
			// this is the month text
			String text=driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/h2")).getText();
			
			
			if(text.equals(month)) // comparing the text value with month
			{
				break;
			}
			else
			{
				//this is right button click
				driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]")).click();
			}
			
			//Storing the dates in the List 
			List <WebElement> allDates=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr/td/button[1]"));
		
			for(WebElement ele:allDates) // this loop is to check the expected Date
			{
				String date_text=ele.getText(); // storing it in a string
				
				String date[]=date_text.split("\n"); // this is to split the date from month
				
				if(date[1].equals(exptdate)) 	
				{
					ele.click();
					break;
				}
			}
		}
		

	}

}
