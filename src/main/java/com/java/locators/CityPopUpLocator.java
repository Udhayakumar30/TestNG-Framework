package com.java.locators;

public class CityPopUpLocator {
	protected String citydropdown_xpath, rememberme_id, okbutton_id;

	public CityPopUpLocator() {
		
		citydropdown_xpath="//b[@class='dropdown-arrow']";
		rememberme_id="persist";
		okbutton_id="selectCity";
	}
}
