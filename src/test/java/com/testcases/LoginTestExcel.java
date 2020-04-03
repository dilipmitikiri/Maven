package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.Helper;


public class LoginTestExcel extends BaseClass {
	@Test
	public void loginApp() {
		
		logger=report.createTest("Login to PrimusBank");
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToPrimus(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		Helper.captureScreenShot(driver);
	}
}
