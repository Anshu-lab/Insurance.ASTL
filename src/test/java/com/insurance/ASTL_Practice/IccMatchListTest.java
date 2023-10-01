package com.insurance.ASTL_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccMatchListTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> countrylist = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
        for(int i=0;i<countrylist.size();i++)
        {
        	String country = countrylist.get(i).getText();
        	
        	System.out.println(country);
        }
        List<WebElement> matchlist = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3]"));
        for(int i=0;i<matchlist.size();i++)
        {
        	String match = matchlist.get(i).getText();
        	
        	Integer intValue = Integer.valueOf(match);

        	if(intValue<40)
        	{
        	System.out.println(match);
        	}
        	}
	}

}
