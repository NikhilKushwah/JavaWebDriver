package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingTables {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//first click to the header to get ascending order
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		
		//capture all the webElements into list
		List<WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all elements into new(Original) List using stream and storing into list by using collect
		List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the orginal list pf step 3 sorted list
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//compare orginal list with sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price; // This is local variable 
		// scan the column to get text of the Beans veggetable name and its price	
		//in .map getPriceVeggie is been created its not inbuilt
		// Paggination starts from here
		do // using do while loop why we r using do while loop bcoz we are doing the thing first n then looping till we dnt found the match 
		{
			// writing this again bcoz when it goes on next page it will collect the elements of that page 
		List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
		 price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
	
	//print the all price in the console window
		price.forEach(s->System.out.println(s));
        // Working with pagination
		if(price.size()<1) // less then 1 means from the list if we found one matching data 
		{
			// this will click on next button until n unless it dose not find the Apple in the list
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}
		while(price.size()<1); //Once it found the match it will stop looping 
		
	}

	// if it is object then make it into String
	private static String getPriceVeggie(WebElement s) 
	{
		// capture the price here
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
