package factory;

import dataProvider.ExcelDataProvider;

public class DataProviderFactory 
{

	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel= new ExcelDataProvider();
		return excel;
	}
}
