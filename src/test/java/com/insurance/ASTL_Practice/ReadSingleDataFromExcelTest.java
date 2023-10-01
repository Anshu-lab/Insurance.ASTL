package com.insurance.ASTL_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSingleDataFromExcelTest {

	public static void main(String[] args) throws Throwable  
	{

		FileInputStream fis =new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		
		Workbook wb =WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("test");
		String value = sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(value);
		wb.close();

	}

}
