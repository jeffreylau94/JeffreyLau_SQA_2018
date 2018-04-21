package com.yelp.tests;

import org.openqa.selenium.WebDriver;

public class YelpHomePage {

	WebDriver driver;

	public YelpHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void launchHomePage(String HomePage) {
		driver.get(HomePage);
		driver.manage().window().maximize();
	}

	// Get the title of the Logic Page
	public String getLoginTitle(WebDriver driver) {
		return driver.getTitle();
	}

}
