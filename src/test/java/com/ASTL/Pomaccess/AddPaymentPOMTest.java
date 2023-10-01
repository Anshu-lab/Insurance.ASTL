package com.ASTL.Pomaccess;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ASTL.ObjectRepo.AddNomineePage;
import com.ASTL.ObjectRepo.AddPaymentPage;
import com.ASTL.ObjectRepo.ClientInfoPage;
import com.ASTL.ObjectRepo.ClientStatusPage;
import com.ASTL.ObjectRepo.HomePage;
import com.insurance.ASTL.GenericUtilities.BaseClass;


public class AddPaymentPOMTest extends BaseClass{

	@Test
	public void addPayment() throws Throwable 
	{
		
		//fetching test data from excel file
		int count=elib.getRowCount("addnominee");
		System.out.println(count);
        
        
        HomePage home=new HomePage(driver);
        home.clickOnClient();
        
        ClientInfoPage clientinfo=new ClientInfoPage(driver);
        clientinfo.clickOnSelectedCLient();
        
        ClientStatusPage clientstatus=new ClientStatusPage(driver);
        clientstatus.clickOnAddPayemnt();
        
        
      //Adding new client details
    	AddNomineePage addnominee=new AddNomineePage(driver);
    	addnominee.getDataForClient(elib.getMultipleDataFromExcel("addpayment", 0, 1), driver);
    	
    	AddPaymentPage submitpayment=new AddPaymentPage(driver);
    	submitpayment.clickOnPaymentSubmitButton();
		
    	String str=driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();

    	if(str.contains("New Payment ADDED"))
    	{
    		System.out.println("payment added successfuly");
    	}
    	else
    	{
    		System.out.println("Payment not added");
    	}


	}

}
