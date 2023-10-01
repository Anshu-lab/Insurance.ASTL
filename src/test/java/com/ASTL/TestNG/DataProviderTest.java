package com.ASTL.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.insurance.ASTL.GenericUtilities.ExcelfileUtility;


public class DataProviderTest 
{
//	@Test(dataProvider = "tv")
//	public void getData(String name,int price)
//	{
//		System.out.println(name+"--->"+price);
//	}
	
	@DataProvider
	public Object[][] tv()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="mi";
		obj[0][1]=34000;
		
		obj[1][0]="sony";
		obj[1][1]=50000;
		return obj;
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable
	{
		ExcelfileUtility elib=new ExcelfileUtility();
		Object[][] obj = elib.getMultipleDataFromExcel("db");
	return obj;
	}
	

}
