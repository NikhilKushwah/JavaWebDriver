package RelativeLocators;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvkingWindows {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		//opening a new window tab using switchto() and .newWindow
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		//storing the window Id in set<String>
		Set<String> handles=driver.getWindowHandles();
		//using Iterator to get its Id
		Iterator<String> it=handles.iterator();
		//getting parent id n storing it into string
		String parentId=it.next(); // this will get the index 0 which conatin parent Id
		//getting child id n storing it into string
		String childId= it.next(); // this will move on to next tab which is child tab
		driver.switchTo().window(childId); // this will switch from parent ot child window
		driver.get("https://rahulshettyacademy.com");
		//getting the text of the  link using partial link not full link and storing it into string variable
	 	String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(5).getText();
	 	//getting back to parent window after opening child window
	 	driver.switchTo().window(parentId);
	 	
	 	//inserting this coursename in that textbox which is present in parent storing this into webelement
	 	WebElement name=driver.findElement(By.cssSelector("[name='name']"));
	 	name.sendKeys(courseName); // directly passing 
	 	
	 	//taking a screenshot of the webelemnt not the whole page
	 	File file=name.getScreenshotAs(OutputType.FILE);
	 	
	 	FileUtils.copyFile(file, new File("logo.png"));
	 	
	 	//getting height and width of webElement textbox
	 	 System.out.println(name.getRect().getDimension().getHeight());
	 	 System.out.println(name.getRect().getDimension().getWidth());
		
		

	}

}
