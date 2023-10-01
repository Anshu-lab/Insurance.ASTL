package com.ASTL.TestNG;

import org.testng.annotations.Test;

public class DPseperateclassTest 
{
//	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "tv")
//	public void getdata(String name,int price)
//	{
//		System.out.println(name+"--->"+price);
//	}
//	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "dataFromExcel")
	public void getexceldata(String name, String price)
	{
		System.out.println(name+"   "+price);
	}

}
