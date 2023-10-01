package com.ASTL.Pomaccess;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ASTL.ObjectRepo.AddclientPage;
import com.ASTL.ObjectRepo.ClientInfoPage;
import com.ASTL.ObjectRepo.HomePage;

import com.insurance.ASTL.GenericUtilities.BaseClass;


public class AddnewClientPOMTest extends BaseClass{

	@Test(groups = "regression")
	public void addCLient() throws Throwable
	{
		//fetching test data from excel file
	
		int count=elib.getRowCount("addclient");
		System.out.println(count);
		//navigate to add new client
    	HomePage homepage=new HomePage(driver);
    	homepage.clickOnClient();
    	Assert.fail();
    	
    	ClientInfoPage clientifo=new ClientInfoPage(driver);
    	clientifo.clickOnAddClientButton();
    	
		
    	//Adding new client details
    	AddclientPage addclient=new AddclientPage(driver);
    	addclient.getDataForClient(elib.getMultipleDataFromExcel("addclient", 0, 1), driver);
		
		//click on submit button
        addclient.clickOnsubmitButton();
        String expected="New Client ADDED";
    	
        //validate
    	String str = driver.findElement(By.xpath("//div[@class='col-md-12' and text()='New Client ADDED']")).getText();
    	Assert.assertEquals(expected, str);
    	System.out.println("Client added");
//    	if(str.contains("New Client ADDED"))
//    	{
//    		System.out.println("Client added successfuly");
//    	}
//    	else
//    	{
//    		System.out.println("CLient not created");
//    	}


	}

}
