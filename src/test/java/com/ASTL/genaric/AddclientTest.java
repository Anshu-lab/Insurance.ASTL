package com.ASTL.genaric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.insurance.ASTL.GenericUtilities.ExcelfileUtility;
import com.insurance.ASTL.GenericUtilities.FileUtility;
import com.insurance.ASTL.GenericUtilities.WebDriverUtilities;

public class AddclientTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility flib=new FileUtility();
		ExcelfileUtility elib=new ExcelfileUtility();
		WebDriverUtilities wlib=new WebDriverUtilities();
		
		//creating driver object
		WebDriver driver=null;
		
		//fetching common data from properties file
		
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		
		//fetching test data from excel file
		int count=elib.getRowCount("addclient");
		System.out.println(count);
		
		//checking for the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Browser launch error");
		}
		
		//maximize the window
		wlib.maximizeBrowser(driver);
		
		//entering url from properties file
		driver.get(URL);
        wlib.implicitWait(driver, 10);
        
        //login to application using properties file
        driver.findElement(By.name("username")).sendKeys(USERNAME);
    	driver.findElement(By.name("password")).sendKeys(PASSWORD);
    	driver.findElement(By.xpath("//button[.='login']")).click();
    	
    	//navigate to add new client
    	driver.findElement(By.linkText("CLIENTS")).click();
    	driver.findElement(By.linkText("Add Client")).click();
		
    	//elib.getMultipleDataFromExcel("addclient", 0, 1, driver);
		
		//click on submit button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    	
        //validate
    	String str = driver.findElement(By.xpath("//div[@class='col-md-12' and text()='New Client ADDED']")).getText();
    	if(str.contains("New Client ADDED"))
    	{
    		System.out.println("Client added successfuly");
    	}
    	else
    	{
    		System.out.println("CLient not created");
    	}

	}

}
