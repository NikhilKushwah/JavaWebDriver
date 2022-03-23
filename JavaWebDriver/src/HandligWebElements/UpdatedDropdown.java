package HandligWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the test Framework in this we are using it only for Assertion in depth will see to it later

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException
	{
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   
	   driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	   driver.manage().window().maximize();
	   //With help of .size() we getting the count of checkbox
	   System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	   //With help of .isSelected() method we checking that checkbox is selected or unselected
	   //checking validation with assertion wether it is returning true or false
	   Assert.assertFalse(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_IndArm']")).isSelected());
	   //Clicking on the checkbox
	   driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_IndArm']")).click();
	   System.out.println(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_IndArm']")).isSelected());
	   Assert.assertTrue(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_IndArm']")).isSelected());
	   
	   //checking the calendar is enable or disabled before selecting Round Trip Radio button
	   System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	   // clicking on Round Trip Radio button 
	   driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	   //checking the calendar is enable or disabled after selecting Round Trip Radio Button
	   System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	   
	   //checking its validation is it enabled or not
	   if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
	   {
		   System.out.println("Its Enabled");
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   System.out.println("Its Disabled");
		   Assert.assertTrue(false);
	   }
	   
	   
	   
	   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	   driver.findElement(By.id("divpaxinfo")).click();
	   Thread.sleep(2000);
	 /*  int i=1; // creating Loop to add adults 5 times
	   while(i<5)
	   {
	   		   driver.findElement(By.id("hrefIncAdt")).click();
	   		   i++;
	   }*/
	   
	   for(int i=1; i<3; i++)
	   {
		   driver.findElement(By.id("hrefIncAdt")).click();
	   }
	   
	   driver.findElement(By.id("btnclosepaxoption")).click();
	   //AssetEquals it is used to check that output is equals to expetec result
	   Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
	   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	   
	 

	}

}
