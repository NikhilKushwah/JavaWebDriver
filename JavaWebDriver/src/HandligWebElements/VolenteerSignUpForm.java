package HandligWebElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VolenteerSignUpForm {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://fs12.formsite.com/oP7bwD/mmenefs8w2/index.html?1639304140629");
		
		//Entering Name, city, phone no, email these ID's are all Web Element
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("Nikhil");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("Kushwah");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("Mumbai");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("123045679");
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("nicthakur93@gmail.com");
		
		//Id of Drop Down Box Storing Web Elements which are present in dropdown in Web Element class
		WebElement Dropdown=driver.findElement(By.id("RESULT_RadioButton-5"));
		
		//Select class is used to select option from the dropdown which has been captured in it
	    Select drop=new Select(Dropdown); // passing dropdown variable to Select object
	    
	   // drop.selectByIndex(2); // this will select by index
	   // drop.selectByValue("Radio-13"); // this will select the radio under the dropdown list
	    // Always prefer to use visibleText 
	    drop.selectByVisibleText("Hawaii"); // this will select the visible element present in the dropdown box list
	    
		System.out.println(drop.getOptions().size());// this will return number of items present in the dropdown box
		
		// Radio button selection
		System.out.println(driver.findElement(By.xpath("/html/body/form/div[2]/div[16]/table/tbody/tr/td[3]")).isSelected());// this will return false cozz it should be unselected
		driver.findElement(By.xpath("/html/body/form/div[2]/div[16]/table/tbody/tr/td[3]")).click();
		
		driver.findElement(By.xpath("/html/body/form/div[2]/div[17]/table/tbody/tr/td[2]")).click();
		
		//Checkbox selection
		
		//driver.findElement(By.id("Id name")).click();
		
		// Bigger textbox/ Text area
		driver.findElement(By.id("RESULT_TextArea-11")).sendKeys("Testing");
		
		//Link
		/*if (driver.findElement(By.linkText("Link name")).isDisplayed()==true)
		{
			driver.findElement(By.linkText("link name")).click(); // this will click on the link
			driver.navigate().back(); // this will return to the previous page
		}*/
		
			driver.findElement(By.id("FSsubmit")).click(); // this will click on submit button
		
			// this is to get the confirmation page text
			
			System.out.println(driver.getTitle());
	
		

	}

}
