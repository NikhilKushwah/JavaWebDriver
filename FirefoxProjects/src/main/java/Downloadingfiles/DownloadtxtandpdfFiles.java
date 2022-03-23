package Downloadingfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadtxtandpdfFiles {

	public static void main(String[] args)
	{
		
		// Additional setting for Firefox browser if you dont want popup while downloading the file
		
		// Added FirefoxProfile class
		FirefoxProfile profile=new FirefoxProfile(); // creating FirefoxProfile object
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/pdf");// Mime type
		profile.setPreference("browser.download.manager.showWhenStarting", false);				
		profile.setPreference("pdfjs.disabled", true); // onlly for pdf file
				
		// Added FirefoxOption class
		FirefoxOptions option=new FirefoxOptions(); // creating FirefoxOption object
		option.setProfile(profile);
				
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\NK\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver(option);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		//downloading text file
		driver.findElement(By.id("textbox")).sendKeys("Testing");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		
		//downloading pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("Testing");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		
		

	}

}
