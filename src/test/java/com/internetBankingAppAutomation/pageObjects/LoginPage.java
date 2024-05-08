package com.internetBankingAppAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver pdriver;
	
	public LoginPage(WebDriver rdriver){
		pdriver = rdriver;
		PageFactory.initElements(pdriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	WebElement logOut;
	
	
	public void setUserName(String username) {
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	public void clickLogOut() {
		logOut.click();
	}

}
