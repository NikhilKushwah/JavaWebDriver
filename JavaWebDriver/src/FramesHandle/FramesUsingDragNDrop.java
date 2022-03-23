package FramesHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesUsingDragNDrop {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		// getting size of the iframe
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//switching frame with index
		driver.switchTo().frame(0);
		
		// switching into Frame
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
	//	driver.findElement(By.id("draggable")).click();
		// creating Action object
		Actions act= new Actions(driver);
		//storing into webElement
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		//dragging the source and droping into the target
		act.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		

	}

}
