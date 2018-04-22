package com.yelp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.examples.config.GlobalDataStore;

public class yelpChromeTest {

	public static void main(String[] args) {
		basicTest();
	}

	public static void basicTest() {
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameters();
		String ChromeDriver = GlobalDataStore.ChromeDriver_MAC;
		String HomePage = GlobalDataStore.HomePage;
		System.out.println("The HomePage is: " + HomePage);
		System.out.println("The driver is: " + ChromeDriver);
		System.setProperty("webdriver.chrome.driver", ChromeDriver);

		WebDriver driver = new ChromeDriver();
		// String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";

		// launch Google Chrome and direct it to the Base URL
		driver.get(HomePage);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		String actualURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + actualURL);
		actualTitle = actualTitle.trim();
		System.out.println("The actual title is: " + actualTitle);

		/*
		 * compare the actual title of the page with the expected one print the result
		 * as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// close Firefox
		// driver.close();
	}

}
