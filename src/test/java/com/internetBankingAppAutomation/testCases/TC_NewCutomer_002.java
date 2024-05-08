package com.internetBankingAppAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetBankingAppAutomation.pageObjects.LoginPage;
import com.internetBankingAppAutomation.pageObjects.NewCustomer;

public class TC_NewCutomer_002 extends baseClass {
	
	@Test
	public void createNewCutomer() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		NewCustomer nc = new NewCustomer(driver);
		
		lp.setUserName(userId);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver,"loginTest");
			Assert.assertFalse(true);
		}
		
		Thread.sleep(3000);
		nc.clickNewCutomer();
		Thread.sleep(3000);
		
		nc.setName();
		nc.setDate();
		nc.setAddress();
		nc.setCity();
		Thread.sleep(3000);
	}

}
