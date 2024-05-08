package com.internetBankingAppAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver pdriver;
	
	public NewCustomer(WebDriver driver) {
		pdriver = driver;
		PageFactory.initElements(pdriver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using ="New Customer")
	WebElement newCustomer;
	
	@FindBy(name="name") 
	WebElement nameText;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(how = How.NAME, using="addr")
	WebElement address;
	
	@FindBy(how=How.XPATH, using="//input[@name='city']")
	WebElement city;
	
	public void setName() {
		nameText.sendKeys("abc");
	}
	
	public void setDate() {
		dob.sendKeys("04-25-2024");
	}
	
	public void setAddress() {
		address.sendKeys("Abc Street");
	}
	
	public void setCity() {
		city.sendKeys("ABC");
	}
	
	public void clickNewCutomer() {
		newCustomer.click();
	}
}
