package com.internetBankingAppAutomation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	String src = "./configurations/config.properties" ;
	
	public ReadConfig() {
		try {
			FileInputStream f = new FileInputStream(src);
			pro = new Properties();
			pro.load(f);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUserId() {
		String userId = pro.getProperty("userId");
		return userId;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromeDriverPath() {
		String chromeDriver = pro.getProperty("chromeDriver");
		return chromeDriver;
	}
	public String getGeckoDriverPath() {
		String geckoDriver = pro.getProperty("geckoDriver");
		return geckoDriver;
	}
}
