package com.insurance.ASTL_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateQuaryTest {

	public static void main(String[] args) throws Throwable 
	{
		Connection con=null;
		try 
		{
		    int result=0; 
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Statement stat = con.createStatement();
			String quary="insert into Example values('Anil','erp',40);";
		    result = stat.executeUpdate(quary);
			if(result>0)
			{
				System.out.println("Data is updated");
			}
			else
			{
				System.out.println("Updation fail");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			con.close();
		}

	}

}
