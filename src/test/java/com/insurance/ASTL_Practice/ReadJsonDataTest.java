package com.insurance.ASTL_Practice;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ReadJsonDataTest {

	public static void main(String[] args) throws Throwable
	{
		JSONParser pass = new JSONParser();
		FileReader in = new FileReader("./src\\test\\resources\\Jsondata.json");
		Object obj = pass.parse(in);
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));

	}

}
