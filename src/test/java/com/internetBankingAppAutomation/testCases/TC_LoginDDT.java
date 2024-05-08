package com.internetBankingAppAutomation.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetBankingAppAutomation.pageObjects.LoginPage;
import com.internetBankingAppAutomation.utilities.XLUtility;

public class TC_LoginDDT extends baseClass{
	@Test (dataProvider="LoginData")
	public void loginDDT(String username,String password) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(1000);
		lp.setUserName(username);
		lp.setPassword(password);
		Thread.sleep(1000);
		lp.clickSubmit();
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}

	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+ "/src/test/java/com/internetBankingAppAutomation/testData/DDTData.xlsx";
		int rowNum = XLUtility.getRowCount(path, "Sheet1");
		System.out.println(rowNum);
		int colNum = XLUtility.getCellCount(path, "Sheet1", 1);
		System.out.println(colNum);

		String[][] loginData = new String[rowNum][colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				loginData[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
