package com.insurance.ASTL_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuaryTest {

	public static void main(String[] args) throws Throwable 
	{
		Connection con=null;
		try
		{
		
		Driver driver=new Driver();
		//register driver
		DriverManager.registerDriver(driver);
		
		//connect to data base
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		//create statement
		Statement stmt = con.createStatement();
		String quary="select * from Example;";
		
		//execute quary
		ResultSet result = stmt.executeQuery(quary);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
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
