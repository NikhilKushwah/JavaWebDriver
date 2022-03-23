package GlobalParameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException 
	{
		Properties pros=new Properties(); // This will help to scan or Extract any dot properties file
		
		// This is to fetch the value from data.proprties file by giving the path of data.propertie file
		FileInputStream file=new FileInputStream("E:\\Users\\Administrator\\eclipse-workspace\\JavaWebDriver\\JavaWebDriver\\src\\data.properties");

		//This way properties Object can detect from file object where is the File
		pros.load(file);
		System.out.println(pros.getProperty("browser"));
		System.out.println(pros.getProperty("url"));
		pros.setProperty("browser", "firefox"); // this is to set the property at run time
		System.out.println(pros.getProperty("browser"));
		//This will update in data.properties file
		FileOutputStream rewrite=new FileOutputStream("E:\\Users\\Administrator\\eclipse-workspace\\JavaWebDriver\\JavaWebDriver\\src\\data.properties");
		pros.store(rewrite, null);
		
	}

}
