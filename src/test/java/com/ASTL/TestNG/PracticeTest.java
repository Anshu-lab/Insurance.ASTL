package com.ASTL.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.insurance.ASTL.GenericUtilities.BaseClass;

public class PracticeTest extends BaseClass
{
	@Test()
	public void createTest()
	{
		Assert.fail();
		System.out.println("-------Data Created---------");
	}
	
	@Test(dependsOnMethods = "deleteTest")
	public void editTest()
	{
		System.out.println("--------Data Modification Done----------");
	}
	
	@Test(priority = 1)
	public void deleteTest()
	{
		System.out.println("----------Data Deleted-----------");
	}

}
