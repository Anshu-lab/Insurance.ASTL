package com.insurance.ASTL_Practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class KsrtcCalanderTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.ksrtc.in/oprs-web/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.id("txtJourneyDate")).click();
        int date=1;
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date+"']")).click();
        
	    
        
	
	}

}
