package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/ScreenShots/PrimusBank_"+getCurrentDateTime() +".png";

		try {
//			FileHandler.copy(src, new File("./ScreenShots/Login.png"));
//			FileHandler.copy(src, new File("./ScreenShots/PrimusBank_"+ getCurrentDateTime()+".png"));
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture Screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	public static String getCurrentDateTime() {
		DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customFormat.format(currentDate);
	}

}
