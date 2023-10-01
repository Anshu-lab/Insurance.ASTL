package com.insurance.ASTL_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalanderTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.goibibo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
        String month_year="September 2024";
        int date=3;
        String current="//div[text()='"+month_year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
        driver.findElement(By.xpath("//span[.='Departure']")).click();
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
        driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
