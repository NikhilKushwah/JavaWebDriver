package HandligWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEndTest {

	public static void main(String[] args) throws InterruptedException 
	{
		//Flight booking code and drop down box code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//this is webdriver interface chromedriver is a class and impleamnting WebDriver interface
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Selecting One Way Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//clicking on From dropdown box 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();// mentioning 2 in index so it can choose from the TO dropdown boc

		// There is one more way to select the city name instead of using index in real time some ppl my not lyk indexes in ur code
		// So we can use Parent to Child relationship not traverse
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		
		//Selecting current Date in Calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//This condition is for the 2nd calendar
		  if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		   {
			   System.out.println("Its Disabled");
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   System.out.println("Its Enabled");
			   Assert.assertTrue(false);
		   }
		   // Selecting checkbox Indian Armed Force
		  driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_IndArm']")).click();
		  
		  //clicking on Adding Adult dropdown box
		  driver.findElement(By.id("divpaxinfo")).click();
		   Thread.sleep(2000);
		  //Adding Adults from Dropdown list
		  for(int i=1; i<3; i++)
		   {
			   driver.findElement(By.id("hrefIncAdt")).click();
		   }
		   
		   driver.findElement(By.id("btnclosepaxoption")).click();
		   //AssetEquals it is used to check that output is equals to expetec result
		   Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		   
		  //clicking on search button
		   driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
