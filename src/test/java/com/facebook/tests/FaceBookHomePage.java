package com.facebook.tests;

import org.openqa.selenium.WebDriver;

public class FaceBookHomePage {

	WebDriver driver;
	
	public FaceBookHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void launchHomePage(String HomePage){
		driver.get(HomePage);
		driver.manage().window().maximize();
	}

	// Get the title of the Logic Page
	public String getLoginTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
}
