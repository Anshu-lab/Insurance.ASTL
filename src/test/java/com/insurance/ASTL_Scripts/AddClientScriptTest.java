package com.insurance.ASTL_Scripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AddClientScriptTest {

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
    	
    	driver.findElement(By.linkText("CLIENTS")).click();
    	driver.findElement(By.linkText("Add Client")).click();
    	
    	driver.findElement(By.name("client_password")).sendKeys("123789");
    	driver.findElement(By.name("name")).sendKeys("Kumari");
    	WebElement img = driver.findElement(By.name("fileToUpload"));
    	img.sendKeys("C:\\Users\\User\\Downloads\\anshu.jpeg");
    	driver.findElement(By.name("sex")).sendKeys("male");
    	driver.findElement(By.name("birth_date")).sendKeys("5-6-1993");
    	driver.findElement(By.name("maritial_status")).sendKeys("married");
    	driver.findElement(By.name("nid")).sendKeys("123698745125");
    	driver.findElement(By.name("phone")).sendKeys("7896325874");
    	driver.findElement(By.name("address")).sendKeys("bangalore");
    	driver.findElement(By.name("policy_id")).sendKeys("1");
    	
    	
    	driver.findElement(By.name("nominee_name")).sendKeys("aahana");
    	driver.findElement(By.name("nominee_sex")).sendKeys("female");
    	driver.findElement(By.name("nominee_birth_date")).sendKeys("8-5-2010");
    	driver.findElement(By.name("nominee_nid")).sendKeys("852147896325");
    	driver.findElement(By.name("nominee_relationship")).sendKeys("daughter");
    	driver.findElement(By.name("priority")).sendKeys("100%");
    	driver.findElement(By.name("nominee_phone")).sendKeys("7896541233");
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    	
    	String str = driver.findElement(By.xpath("//div[@class='col-md-12' and text()='New Client ADDED']")).getText();
    	if(str.contains("New Client ADDED"))
    	{
    		System.out.println("Client added successfuly");
    	}
    	else
    	{
    		System.out.println("CLient not created");
    	}
    	
    
	
	}

}
