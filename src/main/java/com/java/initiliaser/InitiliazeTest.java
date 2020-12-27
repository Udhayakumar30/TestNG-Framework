package com.java.initiliaser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitiliazeTest {
	public static WebDriver launchBrowser() {
		WebDriver driver=null;
		String browser = get_property("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static String get_property(String key) {
		String value="";
		try {
			FileReader fr = new FileReader(
					"C:\\Users\\lenovo pc\\eclipse-workspace\\TestNGPOM\\resource\\test.property");
			Properties prop=new Properties();
			prop.load(fr);
			value= prop.getProperty(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return value;

	}
}
