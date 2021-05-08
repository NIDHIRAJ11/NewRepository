package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility 
{
	/**
	 * this method is used to read the data from the excel sheet
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public String getExcelData(String sheet,int row, int column) throws InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("./Data/testData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return value;
	}

	/**
	 * this method is used to set the data back to excel sheet
	 * @param sheet
	 * @param row
	 * @param column
	 * @param data
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void setExcelData(String sheet, int row, int column, String data) throws InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("./Data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(column).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/testData.xlsx");
		wb.write(fos);
		fos.close();
	}
	
	
	/**
	 * this method will give the value present in excel sheet cell if we mention tc_id and header name
	 * @param sheet
	 * @param TC_ID
	 * @param sheetHeader
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheet, String TC_ID, String sheetHeader) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.TestDataExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheetName = workbook.getSheet(sheet);
		int lastRow = sheetName.getLastRowNum();
		int expectedRow=0;
		for(int i=0;i<lastRow;i++)
		{
			String testCaseID = sheetName.getRow(i).getCell(0).getStringCellValue();
			if(testCaseID.equalsIgnoreCase(TC_ID))
			{
				expectedRow=i;
				break;
			}
			
		}
		
		expectedRow--;
		int lastCellNum = sheetName.getRow(expectedRow).getLastCellNum();
		int expectedCellNum=0;
		for(int j=0;j<lastCellNum;j++)
		{
			String header = sheetName.getRow(expectedRow).getCell(j).getStringCellValue();
			if(header.equalsIgnoreCase(sheetHeader))
			{
				expectedCellNum=j;
				break;	
			}
		}
		
		String value = sheetName.getRow(expectedRow+1).getCell(expectedCellNum).getStringCellValue();
		return value;	
	}


	
	/**
	 * this method will give all data present in the excel sheet
	 * @param sheetName
	 * @return all the data present in sheet it will return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.TestDataExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object data[][]= new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow; i++)
		{
			for(int j=0; j<lastCell;j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			}	
		}
		
		return data;
	}
	
	
	
	
	
}
