package com.insurance.ASTL_Practice;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakemytripCalanderTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String month_year="May 2024";
        int date=3;
        Actions a=new Actions(driver);
        a.moveToLocation(0, 1);
        a.click();
        a.perform();
       Thread.sleep(6000);
       a.moveToLocation(0, 1);
       a.click();
       a.perform();
       driver.findElement(By.xpath("//span[text()='Departure']")).click();
       
       String current="//div[text()='"+month_year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
     
       String next="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
       for(;;)
       {
       	try
       	{
       	driver.findElement(By.xpath(current)).click();
       	break;
       	}
       	catch(Exception e)
       	{
       		driver.findElement(By.xpath(next)).click();
       	}
       }

	}

}
