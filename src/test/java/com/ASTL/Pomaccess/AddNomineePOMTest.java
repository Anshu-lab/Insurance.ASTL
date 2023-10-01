package com.ASTL.Pomaccess;


import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ASTL.ObjectRepo.AddNomineePage;
import com.ASTL.ObjectRepo.HomePage;
import com.ASTL.ObjectRepo.NomineeInfoPage;
import com.insurance.ASTL.GenericUtilities.BaseClass;


public class AddNomineePOMTest extends BaseClass{

	@Test(groups = "smoke")
	public void addnewNominee() throws Throwable
	{
		
		//fetching test data from excel file
		int count=elib.getRowCount("addnominee");
		System.out.println(count);
        
        HomePage home=new HomePage(driver);
        home.clickOnNominee();
        
        NomineeInfoPage nominee=new NomineeInfoPage(driver);
        nominee.clickOnAddNomineeButton();
        
        
      //Adding new client details
    	AddNomineePage addnominee=new AddNomineePage(driver);
    	addnominee.getDataForClient(elib.getMultipleDataFromExcel("addnominee", 0, 1), driver);
		
		addnominee.clickOnNomineeSubmit();
		    	
		    	String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		    	if(str.contains("New Nominee ADDED"))
		    	{
		    		System.out.println("Nominee added successfully");
		    	}
		    	else
		    	{
		    		System.out.println("Nominee not added");
		    	}


		
		
		

	}

}
