package com.insurance.ASTL_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllDataFromExcelTest {

	public static void main(String[] args) throws Throwable
	{
FileInputStream fis =new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("test");
		
		int row = sh.getLastRowNum();
		int cell = sh.getRow(1).getLastCellNum();
		
		for(int i=1;i<=row;i++) //row
		{
			
			for(int j=0;j<cell;j++) //cell
			{
				
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value +"    ");
			}
			
			System.out.println();
			
		}

	}

}
