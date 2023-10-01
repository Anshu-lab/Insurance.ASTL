package com.ASTL.TestNG;

import org.testng.annotations.Test;

import com.insurance.ASTL.GenericUtilities.BaseClass;

public class Sample extends BaseClass{
	@Test(groups = "regression")
	public void sample()
	{
		System.out.println("--Sample class--");
	}

}
