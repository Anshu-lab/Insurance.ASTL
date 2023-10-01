package com.insurance.ASTL_Practice;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinkTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//to get all links
		List<WebElement> linklist = driver.findElements(By.xpath("//a"));
		System.out.println(linklist.size());
		
		//create empty arraylist to add links
		ArrayList<String> list=new ArrayList<String>();
		
		
		for(int i=0;i<linklist.size();i++)
		{
			String eachlink=linklist.get(i).getAttribute("href"); //get individual link
			
			URL url=null;
			int statuscode=0;
			
			try
			{
				url=new URL(eachlink);
				HttpURLConnection httpcon=(HttpURLConnection) url.openConnection();
				statuscode=httpcon.getResponseCode();
				
				if(statuscode>400)
				{
					list.add(eachlink);
				System.out.println(eachlink);
				}
			}
			catch(Exception e)
			{
				list.add(eachlink);
			}
			
			
		}
	}

}
