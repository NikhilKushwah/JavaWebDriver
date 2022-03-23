package HttpsCertification;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class InsecureAndSSLCertification {

	public static void main(String[] args) 
	{
		//SSL Certification
		//Create instance of ChromeOptions Class
				ChromeOptions handlingSSL = new ChromeOptions();
		 
				//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
				handlingSSL.setAcceptInsecureCerts(true);
				handlingSSL.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
						
				//Creating instance of Chrome driver by passing reference of ChromeOptions object
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver(handlingSSL);
				
				//Launching the URL
				
				
				driver.get("https://expired.badssl.com/");
				System.out.println("The page title is : " +driver.getTitle());
			//	driver.quit();
		
	}

}
