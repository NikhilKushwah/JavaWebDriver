package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
		
		//WebElement source=driver.findElement(By.id("box4"));
		WebElement source=driver.findElement(By.id("node1"));
		
		//WebElement target=driver.findElement(By.id("box103"));
		WebElement target=driver.findElement(By.id("box1"));
		Actions act=new Actions(driver);
		
		act.clickAndHold(source).moveToElement(target).release().build().perform();

	}

}
