package com.java.page;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.locators.CityPopUpLocator;

public class CityPopUpPage extends CityPopUpLocator {
	WebDriver driver;

	public CityPopUpPage(WebDriver driver) {
		this.driver = driver;

	}

	public void chooseCity(String s) {
		WebElement dropdown = driver.findElement(By.xpath(citydropdown_xpath));
		dropdown.click();
		List<WebElement> allList = driver.findElements(By.xpath("//div[@class='selectric-scroll']/ul/li"));
		System.out.println(allList.size());

		Iterator<WebElement> itr = allList.iterator();
		while (itr.hasNext()) {
			WebElement city = (WebElement) itr.next();
			System.out.println(" " + city.getText());
			if (city.getText().trim().equalsIgnoreCase(s)) {
				city.click();
			break;
			}
			
		}
		//dropdown.sendKeys(Keys.ESCAPE);
		

	}

	public void clickRememberMe() {
		WebElement checkbox = driver.findElement(By.id(rememberme_id));
		checkbox.click();
	}

	public void clickOkButton() {
		WebElement button = driver.findElement(By.id(okbutton_id));
		button.click();

	}
}
