package DownloadingFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DonloadFilewithChrome {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		//downloading text files
		driver.findElement(By.id("textbox")).sendKeys("Testing Text File");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
	    //downloading pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("Testing PDF File");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		
	//	driver.close();

	}

}
