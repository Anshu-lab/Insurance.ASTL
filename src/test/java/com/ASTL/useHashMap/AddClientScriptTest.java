package com.ASTL.useHashMap;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddClientScriptTest {

	public static void main(String[] args) throws Throwable 
	{
		//creating driver object
		WebDriver driver=null;
		
		//fetching common data from properties file
		FileInputStream fin=new FileInputStream(".\\src\\test\\resources\\common_data.properties");
		Properties pro=new Properties();
		pro.load(fin);
		
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//fetching test data from excel file
		FileInputStream in=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(in);
		Sheet sh=wb.getSheet("addclient");
		int count = sh.getLastRowNum();
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
        driver.manage().window().maximize();
		
		//entering url from properties file
		driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //login to application using properties file
        driver.findElement(By.name("username")).sendKeys(USERNAME);
    	driver.findElement(By.name("password")).sendKeys(PASSWORD);
    	driver.findElement(By.xpath("//button[.='login']")).click();
    	
    	//navigate to add new client
    	driver.findElement(By.linkText("CLIENTS")).click();
    	driver.findElement(By.linkText("Add Client")).click();
		
    	//empty hash map
		HashMap<String, String> map = new HashMap<String, String>();
		
		//store all data in hash map from excel
		for(int i=1;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
        
		//access data from hash map
		for(Entry<String, String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
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
