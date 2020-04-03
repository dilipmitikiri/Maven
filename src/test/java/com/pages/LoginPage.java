package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(name = "txtuId")
	WebElement username;
	@FindBy(name = "txtPword")
	WebElement password;
	@FindBy(name = "login")
	WebElement loginButton;

	public void loginToPrimus(String usernameApplication, String passwordApplication) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		username.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginButton.click();
	}

}
