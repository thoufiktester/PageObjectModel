package com.page.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.page.Base.Pager;





public class Utilities extends Pager {

	public static String ScreenshotPath;
	public static String ScreenshotName;

	public static void Capturescreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		ScreenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + ScreenshotName));

	}
       @DataProvider(name="getdata")
	public Object[][] getData(Method m)
	{
		
		String sheetName=m.getName();
		
		int rows=excel.getRowCount(sheetName);
		
		int cols =excel.getColumnCount(sheetName);
		 Object[][] data=new Object[rows-1][1];
			
			Hashtable<String,String>table;
			
			for(int rownum=2;rownum<=rows;rownum++)
			{
				table=new Hashtable<String,String>();
				
				for(int colnum=0;colnum<cols;colnum++)
				{
					table.put(excel.getCellData(sheetName, colnum, 1),excel.getCellData(sheetName, colnum, rownum));
					data[rownum-2][0]=table;
										
				}
				
			}
			
				
		    return data;
	}
		
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "RUNMODE", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}
