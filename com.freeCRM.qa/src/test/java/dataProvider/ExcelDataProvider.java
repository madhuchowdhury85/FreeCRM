package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		try 
		{
			wb= new XSSFWorkbook(new FileInputStream(new File("./TestData/CRMTestData.xlsx")));
		
		} 
		catch (Exception e) 
		{
			System.out.println("File not found or not loaded properly "+e.getMessage());
		}
		 
	}
	
	public String getstringdata(String sheetName, int row, int column )
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public int getnumericintdata(String sheetName, int row, int column )
	{
		return (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
