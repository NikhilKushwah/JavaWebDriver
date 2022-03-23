package WebDriverCommands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindowsFromParentsToChild {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		//This is Child window
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//storing the parentsID and ChildID
		Set <String> windows= driver.getWindowHandles(); // [ParentID, ChildID]
		//pulling the value from set collection by using Iterator
		Iterator <String> it= windows.iterator();
		
		//To go to the parent id use it.next() method
		String parentId= it.next(); // this get the [ParentID]
		
		//To go to child id use it.next() one more time
		String ChildId=it.next(); // This will get the [ChildID]
		
		// Switching to ChildWindow Pssinfg this ChildID into window methos
		driver.switchTo().window(ChildId);
		
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText()); 
		
		//spliting n triming the text
	    String emails=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	    
	    //Switching to parent window
	    driver.switchTo().window(parentId);
	    driver.findElement(By.id("username")).sendKeys(emails);// passing this emails variaavle which is stored in the String in tthe email textbox
		
		

	}

}
