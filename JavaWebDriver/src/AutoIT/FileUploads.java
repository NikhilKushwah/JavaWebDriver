package AutoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploads {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]/div[2]")).click(); 
		//this is stored in web element
	//	WebElement button=driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]/div[2]"));
		
		//Using Javascript we can us this if the button is not working
	/*	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);*/
		
		Runtime.getRuntime().exec("C://AutoIT Files//Fileupload.exe"+" "+"C:\\Users\\NK\\Downloads\\pic\\images(2).jpg");
		
		//2nd time uploading other image
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"section\"]/Adiv/div/div[3]/div[2]")).click();
		Runtime.getRuntime().exec("C://AutoIT Files//Fileupload.exe"+" "+"C:\\Users\\NK\\Downloads\\pic\\download(1).jpg");

		//3rd time uploading other image
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"section\"]/div/div/div[3]/div[2]")).click();
		Runtime.getRuntime().exec("C://AutoIT Files//Fileupload.exe"+" "+"C:\\Users\\NK\\Downloads\\pic\\images.jpg");
	}

}
