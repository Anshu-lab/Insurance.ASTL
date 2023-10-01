package com.insurance.ASTL_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentConfirmHomePageTest {

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
    	
    	String tot_count_before = driver.findElement(By.xpath("//div[@class='main-box mb-dull']/descendant::h5")).getText();
        System.out.println("Before adding payment = "+tot_count_before);
    	
    	driver.findElement(By.linkText("CLIENTS")).click();
    	
    	
    	driver.findElement(By.linkText("PAYMENTS")).click();
    	driver.findElement(By.linkText("Add Payment")).click();
    	driver.findElement(By.name("client_id")).sendKeys("1694070182");
    	driver.findElement(By.name("month")).sendKeys("June");
    	driver.findElement(By.name("amount")).sendKeys("3000");
    	driver.findElement(By.name("due")).sendKeys("15000");
    	driver.findElement(By.name("fine")).sendKeys("00");
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    	
    	String str=driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();

    	if(str.contains("New Payment ADDED"))
    	{
    		System.out.println("payment added successfuly");
    	}
    	else
    	{
    		System.out.println("Payment not added");
    	}
    	
    	driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
    	String tot_count_after = driver.findElement(By.xpath("//div[@class='main-box mb-dull']/descendant::h5")).getText();
        System.out.println("After adding payment = "+tot_count_after);
	}

}
