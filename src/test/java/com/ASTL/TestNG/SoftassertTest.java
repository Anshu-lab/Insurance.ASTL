package com.ASTL.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertTest 
{
	@Test
	public void softAssertTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		String title=driver.getTitle();
		System.out.println(title);
		SoftAssert as=new SoftAssert();
		String expected="vtiger CRM 5 - Commercial Open Source CRM";
		as.assertNotEquals(title, expected);
		System.out.println("--Title mached--");
		System.out.println("--app launch successful--");
		as.assertAll();
	}

}
