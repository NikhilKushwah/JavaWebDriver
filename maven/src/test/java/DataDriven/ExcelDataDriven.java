package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException //created another method
	{
		//Creating an Array List to store the values from that rows
				ArrayList<String> array=new ArrayList<String>();
				
				// Using Fileinputstream to get tha data 
				// Now to get the access of that particular file you new to give path of that file in this XSSFWorkbook() method for that purpose we will be using FileinputStream
				FileInputStream fis=new FileInputStream("C:\\Users\\NK\\Desktop\\Demodata.xlsx"); 
				
				// creating an object of a class XSSFWorkBook this will get the access of excel file.
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				
				// getting access to the sheet
				int sheets= workbook.getNumberOfSheets(); // this return type is int
				//applying for loop to get the desired sheet name from the multiple sheet
				for(int i=0; i<sheets; i++)
				{
					// applying conditions to check its name
					if(workbook.getSheetName(i).equalsIgnoreCase("Datademo"))
					{
						XSSFSheet sheet=workbook.getSheetAt(i);
						
						//Now identify the testcases column by scaning the entire 1st row
						//using Iterator
						 Iterator<Row> rows= sheet.rowIterator();// sheet is a collection of rows
						 Row firstrow=  rows.next(); // this will move to the 1st row
						 // Now will get the cell Row is nothing but collection of cells
						 Iterator<Cell> ce=firstrow.cellIterator();
						 
						 int k=0;
						 int column=0;
						 //using while loop to read all the data in cell
						 //This one is to get the Rows
						 while(ce.hasNext())// this will check that the next cell is having data or not but this will not move to the next cell
						 {
							Cell value=ce.next();// this will move to the next row and we are storing the data of that cell in value
							//applying condition
							if(value.getStringCellValue().equalsIgnoreCase("Testcases"));
							{
								column=k;
								
							}
							k++; // this will increase by one
						 }
						 System.out.println(column);
						 
						 //Once column is idenfited then scan entire testcase column and identify the purchase in testcase row
						 //using while loop
						 //This one is to get the column of that Row
						 while(rows.hasNext())
						 {
							 Row r= rows.next();// this will move to the next cloumn in that row
							 if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))// passing testcaseName making it generic instead of hardcoding 
							 {
								 //After grabbing purchase tetcase row. Pull all the data of that row and feed into test
								 //using Iterator
								  Iterator<Cell> cr=r.cellIterator();
								  //This loop is to get data of puchase row in Testcases column
								  while(cr.hasNext())
								  {
									  Cell c=cr.next(); // this will move to next
									  //array.add(cr.next().getStringCellValue()); // this will get the value of that row n adding those value in arrayList
								     if(c.getCellType()==CellType.STRING) //This will get the type of the cell wether it is int or string
								     {
								    	 array.add(c.getStringCellValue()); // if it is string then add in arraylist
								     }
								     else if(c.getCellType()== CellType.NUMERIC)
										{
											System.out.println(c.getNumericCellValue());
										}
								     else
								     {
								    	 array.add(NumberToTextConverter.toText(c.getNumericCellValue())); // else it is int then it will convert into string and add into arraylist
								     }
								     
								  
								  }
								  
							 }
						 }
					}
					
				}
				return array; // returning the array list

			}
	
	
	public static void main(String[] args) throws IOException
	{
		
		}
	}
	
