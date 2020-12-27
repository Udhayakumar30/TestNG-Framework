package com.java.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.initiliaser.InitiliazeTest;

public class TestNGExample {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		driver = InitiliazeTest.launchBrowser();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void tearDown() {
		// driver.close();
	}

	@Test
	public void gmailUser1() throws InterruptedException {
	

		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("udhay022@gmail.com"+Keys.ENTER);

		
		

		

		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();

		WebElement to = driver.findElement(By.xpath("//textarea[@name='to']"));

		to.sendKeys("udhay033@gmail.com");

		WebElement sub = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		sub.sendKeys("Hello");

		WebElement txt = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
		txt.sendKeys("Hello Friends");
		txt.sendKeys("This is my first autmoated test mail.");
		Thread.sleep(500);

		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();

		Thread.sleep(2000);
		driver.close();

	}
}
