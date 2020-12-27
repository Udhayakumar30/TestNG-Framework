package com.java.extentreport;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.initiliaser.InitiliazeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTesting {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void launch() {
		driver = InitiliazeTest.launchBrowser();
		reports=new ExtentReports(System.getProperty("user.dir")+"//Extentreport.html",false);
		//test=reports.startTest("testingtitle");
	}

	@AfterTest
	public void close() {
		driver.close();
		reports.flush();
		
	}

	@Test
	public void tc002() {
		test=reports.startTest("tc002");
		driver.get("https:\\www.bing.com");
		if (driver.getTitle().equalsIgnoreCase("google")) {
			System.out.println("failed bing title match");
			test.log(LogStatus.PASS,"expected to be bing");
		} else {
			System.out.println("bing title failed");
			//test.log(LogStatus.FAIL,"failed successfully");
			File fl=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des=new File(System.getProperty("user.dir")+"//errimg//fail.jpeg");
			
				try {
					FileHandler.copy(fl,des);
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			
			String path=des.getAbsolutePath();
			System.out.println(path);
			test.log(LogStatus.FAIL, test.addScreenCapture(path));
			
		}
		reports.endTest(test);
	}
}
