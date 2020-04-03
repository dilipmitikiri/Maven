package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelData;
import com.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelData excel;
	public ConfigDataProvider config;
	public static ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel= new ExcelData();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/PrimusBank_"+Helper.getCurrentDateTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be Started", true);
	}

	/*@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, "FireFox", "http://primusbank.qedgetech.com/");
	}*/
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser and Application is up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenShot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed", true);
	}

}
