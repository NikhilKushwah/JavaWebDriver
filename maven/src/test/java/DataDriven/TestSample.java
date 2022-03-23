package DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException 
	{
		ExcelDataDriven d=new ExcelDataDriven(); // creating an object of ExcelDataDriven class to acess its all the code
	   	ArrayList data= d.getData("purchase"); // storing it into arralList coz we have add all the data in the array in ExcelDataDriven class

	   	System.out.println(data.get(0));
	   	System.out.println(data.get(1));
	   	System.out.println(data.get(2));
	   	
	}

}
