package com.insurance.ASTL_Practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataPropertyTest {

	public static void main(String[] args) throws Throwable 
	{
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://localhost:8888");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		
		FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\Writedata.properties");
		pro.store(fout, "write data");
		fout.close();

	}

}
