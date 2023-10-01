package com.insurance.ASTL_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccPage1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> countrylist = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]"));
        System.out.println(countrylist);
        
	}

}
