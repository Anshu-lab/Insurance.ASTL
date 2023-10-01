package com.insurance.ASTL_Practice;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class KayakPageTest {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver =new ChromeDriver();
		//WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/flights");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-origin']/descendant::input[@class='k_my-input']")).sendKeys("bengaluru");
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-destination']/descendant::input[@class='k_my-input']")).sendKeys("new delhi");

		
		Thread.sleep(3000);
	
		//driver.findElement(By.xpath("//div[text()='October 2023']/ancestor::div[@data-month='2023-10']/descendant::div[@aria-label='Thursday 7 September, 2023']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thursday 7 September, 2023']")).click();
		
	
		String next_month ="//button[@aria-label='Next month']";
		String return_date ="//div[text()='January 2024']/ancestor::div[@data-month='2024-01']/descendant::div[@aria-label='Saturday 6 January, 2024']";
	
		
		
		for(;;) {
			
			try {
				driver.findElement(By.xpath(return_date)).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath(next_month)).click();
				
			}
		}
		
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		
		Set<String> child = driver.getWindowHandles();
		for (String c : child) {
			driver.switchTo().window(c);
			
		}
		
		driver.findElement(By.xpath("//div[text()='Other sort']")).click();
		
		driver.findElement(By.xpath("//span[text()='Earliest take-off (BLR)']")).click();


	}

}
