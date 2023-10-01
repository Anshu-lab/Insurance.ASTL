package com.insurance.ASTL_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReaddatafromCmdTest 
{
@Test
public void cmdTest()
{
	String Browser=System.getProperty("browser");
	String Url = System.getProperty("url");
	String Un = System.getProperty("username");
	String Pw = System.getProperty("password");
	
	//launch browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get(Url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.name("username")).sendKeys(Un);
	driver.findElement(By.name("password")).sendKeys(Pw);
	driver.findElement(By.xpath("//button[.='login']")).click();
}
}
