package RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Locators {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		//Using above() to capture the text which is above the textbox
		//getting tthe textbox location first and storing it into webelement
		WebElement nameEditbox= driver.findElement(By.cssSelector("[name='name']"));
		
		//so before mentioning the new locators import its package elipse dosent allow static package
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		
		//using below() and store it into webElement
		WebElement dateOfbirth= driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfbirth)).click(); // this will go to the next input tag bcoz below dateofbirth tag is a flex tag which doest support
		
	//using tolefOf()
		WebElement iceCreamText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamText)).click();
		
		//Using torightOf()
		WebElement rightsideOfRadiobutton= driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rightsideOfRadiobutton)).getText());
		
		

	}

}
