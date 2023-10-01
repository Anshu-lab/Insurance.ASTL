package com.insurance.ASTL_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteClientTest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//entering url
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //login to application
        driver.findElement(By.name("username")).sendKeys("555");
    	driver.findElement(By.name("password")).sendKeys("666");
    	driver.findElement(By.xpath("//button[.='login']")).click();
    	
    	driver.findElement(By.linkText("CLIENTS")).click();
    	driver.findElement(By.xpath("//td[.='7777']/../td[8]/a")).click();
    	
    	driver.findElement(By.linkText("Delete Client")).click();
    	
    	String str=driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
    	if(str.contains("Client deleted"))
    	{
    		System.out.println("CLient deleted successfuly");
    	}
    	else
    	{
    		System.out.println("Client not added");
    	}
	}

}
