package com.insurance.ASTL_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNomineeTest {

	public static void main(String[] args) 
	{
		//opening the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				//entering url
				driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        //login to application
		        driver.findElement(By.name("username")).sendKeys("555");
		    	driver.findElement(By.name("password")).sendKeys("666");
		    	driver.findElement(By.xpath("//button[.='login']")).click();
		    	
		    	driver.findElement(By.linkText("NOMINEE")).click();
		    	driver.findElement(By.linkText("Add Nominee")).click();
		    	
		    	driver.findElement(By.name("client_id")).sendKeys("1694070182");
		    	driver.findElement(By.name("name")).sendKeys("kumkum");
		    	driver.findElement(By.name("sex")).sendKeys("female");
		    	driver.findElement(By.name("birth_date")).sendKeys("5-6-2000");
		    	driver.findElement(By.name("nid")).sendKeys("5821456+98745");
		    	driver.findElement(By.name("relationship")).sendKeys("sister");
		    	driver.findElement(By.name("priority")).sendKeys("50%");
		    	driver.findElement(By.name("phone")).sendKeys("8965214587");
		    	
		    	driver.findElement(By.xpath("//input[@type='submit']")).click();
		    	
		    	String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		    	if(str.contains("New Nominee ADDED"))
		    	{
		    		System.out.println("Nominee added successfully");
		    	}
		    	else
		    	{
		    		System.out.println("Nominee not added");
		    	}

	}

}
