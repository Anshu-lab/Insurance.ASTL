package com.ASTL.TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardassertTest 
{
	@Test
	public void hardAssertTest()
	{
		System.out.println("--Statement 1--");
		System.out.println("--Statement 2--");
	    assertEquals("A", "B");
		System.out.println("--Statement 3--");
		System.out.println("--Statement 4--");
	}
	
	@Test
	public void hardAssertTest2()
	{
		System.out.println("--Statement 5--");
		System.out.println("--Statement 6--");
		assertNotEquals("A", "A");
		System.out.println("--Statement 7--");
		System.out.println("--Statement 8--");
	}

}
