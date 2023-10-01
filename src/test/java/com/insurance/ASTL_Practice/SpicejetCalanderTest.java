package com.insurance.ASTL_Practice;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SpicejetCalanderTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa' and .='round trip']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		
		String airportname="Sardar Vallabhbhai Patel International Airport";
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-tceitz r-u8s1d r-1wrvin1']/following-sibling::div[@class='css-1dbjc4n r-b5h31w r-95jzfe']/descendant::div[.='"+airportname+"']")).click();		
        
		
		int d_date=13;
		String d_monthclass="undefined-month-September-2023";
		
		String departure_current="//div[@data-testid='"+d_monthclass+"']/descendant::div[.='"+d_date+"'][3]";
		String next="//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']";
		
		int r_date=13;
		String r_monthclass="undefined-month-November-2023";
		String return_current="//div[@data-testid='"+r_monthclass+"']/descendant::div[.='"+r_date+"'][3]";
		
		for(;;)
        {
        	try
        	{
        	driver.findElement(By.xpath(departure_current)).click();
        	break;
        	}
        	catch(Exception e)
        	{
        		driver.findElement(By.xpath(next)).click();
        	}
        }
		
		
		for(;;)
        {
        	try
        	{
        	driver.findElement(By.xpath(return_current)).click();
        	break;
        	}
        	catch(Exception e)
        	{
        		driver.findElement(By.xpath(next)).click();
        	}
        }
		
		
		
        driver.findElement(By.xpath("//div[.='Passengers']")).click();
        
      //increment passenger count
        
        
        
        int count=5;
        for(;;)
        {
        try {
        	WebElement list = driver.findElement(By.xpath("//div[.='Adult']/../following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz']/child::div[2]/child::div[.='"+count+"']"));
        	String value = list.getText();
        	Integer intValue = Integer.valueOf(value);
        	if(intValue==count)
        	{
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();		
             break;
        	}
        }catch(Exception e)
        	{
        		
        		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']/*[@data-testid='svg-img']")).click();
                       	
        		
        	}
        }
        
        		
	
        //click currency tab
driver.findElement(By.xpath("//div[.='Passengers']/../../../following-sibling::div/descendant::div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")).click();

//currency type
String currency="USD";
driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-tceitz r-u8s1d r-1wrvin1']/following-sibling::div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']/descendant::div[.='USD']/child::div[.='"+currency+"']")).click();


//driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti']/descendant::div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79']")).click();
        
	}

}
