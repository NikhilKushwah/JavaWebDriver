package Headless;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHtmlUnitDriver {

	public static void main(String[] args) 
	{
		// This is By Default a headless Browser
				HtmlUnitDriver driver=new HtmlUnitDriver(); 
				
				driver.get("http://demo.nopcommerce.com/");
				
				System.out.println("Title of the page:" +driver.getTitle());
				System.out.println("The current Url of the page:" +driver.getCurrentUrl());

	}

}
