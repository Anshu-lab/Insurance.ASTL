package com.insurance.ASTL_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("astl");
        driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("anshu");
        WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
        
        Select sel = new Select(ele);
        sel.selectByVisibleText("Created");
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();
        
        
        Connection con=null;
		try
		{
		
		Driver driver1=new Driver();
		//register driver
		DriverManager.registerDriver(driver1);
		
		//connect to data base
		 con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//create statement
		Statement stmt = con.createStatement();
		String quary="select * from project where project_name='astl';";
		
		//execute quary
		ResultSet result = stmt.executeQuery(quary);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
		}
		}catch(Exception e)
		{
			
		}
		finally
		{
			con.close();
		}

        
	}

}
