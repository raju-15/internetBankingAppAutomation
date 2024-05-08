package com.internetBankingAppAutomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listener extends TestListenerAdapter {
	public ExtentSparkReporter htmlReporter ;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
		String repName = "Test-Report."+timeStamp+".html";
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment","QA");
		
		htmlReporter.config().setDocumentTitle("Internet Banking");
		htmlReporter.config().setReportName("Functional Test Automation Report");
	}
	
	public void onTestSuccess(ITestResult I) {
		test = extent.createTest(I.getName()); //create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(I.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult I) {
		test = extent.createTest(I.getName()); //create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(I.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"/screenshots/"+I.getName()+".png";
		
		File f= new File(screenshotPath);
		if(f.exists()) {
			try {
			test.fail("screenshot is below : " + test.addScreenCaptureFromPath(screenshotPath));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
