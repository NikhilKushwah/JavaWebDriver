package CartEcommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArraysToCart  {  // This is the Base Class

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//this is webdriver interface chromedriver is a class and impleamnting WebDriver interface
		WebDriver driver=new ChromeDriver();
		
		// introducing Implicit wait it will apply entire code
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//introducing Explicit wait Globally but it will not apply to entire code it will apply only on specific  lines
		
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));// Creating an OBJECT of WebDriverWait Class
		
		String [] itemList= {"Cauliflower","Cucumber","Brocolli", "Nuts Mixture"}; // Creating array to store multiple items in it
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		additems(driver,itemList); // calling another method into main method if you don't provide static in another method you won't be able to call it
		
		// OR you can call another method by creating an OBJECT of the CLASS but STATIC is the main thing to call another method
		
		/*ArraysToCart a=new ArraysToCart();
		ArraysToCart.additems(driver, itemList);*/
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Explicit Wait it will wait for 5 seconds
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// Explicit wait it will wait for 5 seconds
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	   
	}
	
	
	//creating another method
	public static void additems(WebDriver driver, String[] itemList )
	{
		int j=0;
		// storing all the options into List <WebEelement>
				List<WebElement> options=driver.findElements(By.xpath("//h4[@class='product-name']"));
				
				for(int i=0; i<options.size(); i++) // getting all the options in Loops with the help of .size() method
				{
					//slipting Brocollli -1 kg by using .split() method
					// have to store it into array
				String[] name=options.get(i).getText().split("-");// getting text name so we can compare it from the options which we want to select
				// this will create Brocolli index [0] is stored in 0 index and 1 kg in index [1]
				// removing space with help of .trin() method
				String formatedNmae=name[0].trim(); // creating a variable and storing into that variable
				
				//format is to get the actual vegetable name
				//converting array into array list 	
				// checking whether name you extracted into array list or not
				List items = Arrays.asList(itemList);
				
				if(items.contains(formatedNmae)) // comparing the items with array list
				{
					
					//clicking on the add to cart button by getting the value which is stored in i and then clicking on it
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					j++;// it will increment by 1 to compare other items
					
					if(j==itemList.length) // comparing the array items number here
					{
						break;
					}
		  }
				
		}
	}

}
