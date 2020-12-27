package com.java.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.initiliaser.InitiliazeTest;
import com.java.page.CityPopUpPage;

public class TestCase1 extends InitiliazeTest{
	WebDriver driver;
	CityPopUpPage citypage;

	@BeforeMethod
	public void launch() {
	//	System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\selenium\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver=InitiliazeTest.launchBrowser();
		driver.get("http://www.spicinemas.in");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		citypage = new CityPopUpPage(driver);
		
	}

	@AfterTest
	public void close() {
		driver.close();
	}

	@Test
	public void tc001() {
		citypage.chooseCity("chennai");
		citypage.clickRememberMe();
		citypage.clickOkButton();
	}
}
