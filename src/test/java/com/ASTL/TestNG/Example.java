package com.ASTL.TestNG;

import org.testng.annotations.Test;

import com.insurance.ASTL.GenericUtilities.BaseClass;

public class Example extends BaseClass{
	@Test(groups = "smoke")
	public void example()
	{
		System.out.println("--Example CLass--");
	}

}
