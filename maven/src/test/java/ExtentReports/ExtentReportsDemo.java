package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo
{
	ExtentReports extent;
	
	@BeforeTest
	public void config() // creating extent configuration
	{
		// there are 2 classes ExtentReports and ExtentSparkReportesrs
		// cretaing Obj of these classes
		
		// To create a path dynamically through Java use the below synatx no matter in which system you r working
		String path= System.getProperty("user.dir")+ "\\reports\\index.html"; // creating a path in that one folder reports is there n under that 1 html file is there index.html
		
		//This except a path where your reports should be created
		ExtentSparkReporter reports=new ExtentSparkReporter(path);
		
		//Giving the name of the Report
		reports.config().setReportName("Web Automation Results");
		
		//Giving the name of the title of that report
		reports.config().setDocumentTitle("Test Results");
		
		//Now creating an Obj of other class ExtentReports which responsible to derive all the Reports. This is the main class
	    extent= new ExtentReports();
		extent.attachReporter(reports); // Attaching the reports which is been created
		extent.setSystemInfo("Tester", "Nikhil Kushwah"); // passing the system info
		
	}
	
	@Test
	public void initialDemo()
	{
		
		// calling the extent to create Test but for this you have to mention it globally means on the Top
		// Whenever you create createTest extentreports create an object
		ExtentTest test= extent.createTest("Initial demo");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NK\\Downloads\\chromedriver_win32 (98)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		//failing the test justt to check its output
		test.fail("Result do not match");
		
		extent.flush(); // Always mention this in the end of the Test case it will generate the reports. Once u r done creating the all testcase
	}

}
