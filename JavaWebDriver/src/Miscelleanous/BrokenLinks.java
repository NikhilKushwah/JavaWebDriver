package Miscelleanous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// 1st get all the URL's which are tied up with links java method will call URL's & get the status code
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Getting all the stored in WebElement List
		 List <WebElement> Links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		 // Introducing Soft Assertion crewating an object of SoftAssert. This will help to report all the failure and keep on continuing the execution
		 	SoftAssert a= new SoftAssert();
		 
		 //running for loop to get single link at a time it is called enhanced for loop
		 for(WebElement link:Links)
		 {
			// Getting the links
				String url= link.getAttribute("href");
				
				//Creating an object of HttpURLConnection  .openConnection return type is HttpURLConnection
				//URL is a class and .openConnection is a method
				HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
				conn.setRequestMethod("HEAD"); // This will snd the request without clicking
				conn.connect(); // This will connect to the url
				int respCode= conn.getResponseCode(); // This will recieve the response like 200, 201 , 401, 404
				System.out.println(respCode);
				a.assertTrue(respCode<400, "The link with Text" + link.getText()+ "is broken with code" +respCode);
				
			 
		 }
		a.assertAll(); // This will report all the Failure
		
		
		

	}

}
