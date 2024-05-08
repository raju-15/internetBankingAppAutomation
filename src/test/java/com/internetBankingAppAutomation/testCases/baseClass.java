package com.internetBankingAppAutomation.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetBankingAppAutomation.utilities.ReadConfig;


public class baseClass {
	ReadConfig read = new ReadConfig();
	public String baseURL = read.getApplicationURL();
	public String userId = read.getUserId();
	public String password = read.getPassword();
	public String chromeDriverPath = read.getChromeDriverPath();
	public String firefoxDriverPath = read.getGeckoDriverPath();
	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(baseClass.class);
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}else if(br.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot Taken");
	}
}
