package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterJavaStream {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Entering Rice in search text box
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> veggie=driver.findElements(By.xpath("//tr/td[1]"));
		
		//applying filter to it using stream and getting the text and storing it into list
		List<WebElement> filteredlist= veggie.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());

		// comparing it using assert both the size should be same
		Assert.assertEquals(veggie.size(), filteredlist.size());
		

	}

}
