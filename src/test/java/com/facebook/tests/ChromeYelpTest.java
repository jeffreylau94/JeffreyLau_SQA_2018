package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.examples.config.GlobalDataStore;

public class ChromeYelpTest {

	public static void main(String[] args) {
		basicTest();
	}
	
	public static void basicTest() {
		GlobalDataStore gds = new GlobalDataStore();
		gds.initParameters();
		String ChromeDriver = GlobalDataStore.ChromeDriver_MAC;
		String yelpHomePage = GlobalDataStore.YelpHomePage;
		System.out.println("The HomePage is: " + yelpHomePage);
		System.out.println("The driver is: " + ChromeDriver);
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		
		WebDriver driver = new ChromeDriver();
		// String baseUrl = "http://facebook.com";
		String expectedTitle = "Restaurants, Dentists, Bars, Beauty Salons, Doctors - Yelp";
		String actualTitle = "";
		
		// launch Google Chrome and direct it to the Base URL
		driver.get(yelpHomePage);
		
		// get the actual value of the title
		actualTitle = driver.getTitle();
		String actualURL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + actualURL);
		actualTitle = actualTitle.trim();
		System.out.println("The actual title is: " + actualTitle);
		
		/*compare the actual title of the page with the expected one
		print the result as "Passed" or "Failed"*/
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
		
		// close Firefox
		// driver.close();
	}

}

