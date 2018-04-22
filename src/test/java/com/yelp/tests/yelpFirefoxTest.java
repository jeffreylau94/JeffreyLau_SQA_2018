package com.yelp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.examples.config.GlobalDataStore;

public class yelpFirefoxTest {

	public static void main(String[] args) {
		basicTest();
	}

	public static void basicTest() {
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameters();
		String GecKoDriver = GlobalDataStore.GeckoDriver_MAC;
		String HomePage = GlobalDataStore.YelpHomePage;
		System.out.println("The HomePage is: " + HomePage);
		System.out.println("The GeckoDriver is: " + GecKoDriver);
		System.setProperty("webdriver.gecko.driver", GecKoDriver);

		// System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		// String baseUrl = "https://www.yelp.com/";
		String expectedTitle = "Restaurants, Dentists, Bars, Beauty Salons, Doctors - Yelp";
		String actualTitle = "";

		// launch Firefox and direct it to the Base URL
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
