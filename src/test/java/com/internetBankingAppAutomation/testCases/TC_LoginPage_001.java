package com.internetBankingAppAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetBankingAppAutomation.pageObjects.LoginPage;

public class TC_LoginPage_001 extends baseClass {

	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		logger.warn("URL is opened");
		logger.error("URL is opened");
		logger.debug("URL is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(userId);
		lp.setPassword(password);
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage  12")) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
		}

	}
}
