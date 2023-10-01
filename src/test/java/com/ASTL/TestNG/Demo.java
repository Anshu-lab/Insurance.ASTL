package com.ASTL.TestNG;

import org.testng.annotations.Test;

import com.insurance.ASTL.GenericUtilities.BaseClass;

public class Demo extends BaseClass{
	@Test(groups = {"smoke","regression"})
	public void demo()
	{
		System.out.println("--Demo class--");
	}

}
