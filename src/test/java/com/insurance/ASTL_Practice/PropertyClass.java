package com.insurance.ASTL_Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {

	public static void main(String[] args) throws Throwable 
	{
FileInputStream fis =new FileInputStream("./src\\test\\resources\\common_data.properties");
		
		Properties pObj =new Properties();
		
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);


	}

}
