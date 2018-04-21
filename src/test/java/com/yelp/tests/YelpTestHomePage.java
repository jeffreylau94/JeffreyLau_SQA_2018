package com.yelp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;

import junit.framework.Assert;

public class YelpTestHomePage {
	GlobalDataStore gds = new GlobalDataStore();
	String GecKoDriver;
	WebDriver driver = null;
	String ChromeDriver;
	// String SafariDriver;
	String YelpHomePage;
	YelpHomePage yPage;
	WebElement element;

	@Parameters({ "BrowserName" })
	@BeforeClass
	// public void setUp() {
	public void yelpSetUp(@Optional("Chrome") String BrowserName) {
		// public void setUp(String BrowserName) {
		// @Optional only works with @Parameters, which can be specified in the XML file
		// String BrowserName = "Firefox";
		// String BrowserName = "Chrome";
		System.out.println("The Browser Name is: " + BrowserName);
		gds.initParameters();
		GecKoDriver = GlobalDataStore.GeckoDriver_MAC;
		YelpHomePage = GlobalDataStore.YelpHomePage;
		System.out.println("The HomePage is: " + YelpHomePage);
		System.out.println("The GecKoDriver is: " + GecKoDriver);

		if (BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", GecKoDriver);
			// driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver(options);
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			System.out.println("The chrome driver " + GlobalDataStore.ChromeDriver_MAC);
			System.setProperty("webdriver.chrome.driver", GlobalDataStore.ChromeDriver_MAC);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (BrowserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			// driver.navigate().to(HomePage);
		}
	}

	@Test (enabled = false)
	public void testYelpTitleOnPageLoad() {
		// String baseUrl = https://www.yelp.com/;
		String expectedTitle = "Restaurants, Dentists, Bars, Beauty Salons, Doctors - Yelp";
		String actualTitle = "";

		yPage = new YelpHomePage(driver);
		yPage.launchHomePage(YelpHomePage);
		actualTitle = yPage.getLoginTitle(driver);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test (enabled = false)
	@Parameters({ "sUsername", "sPassword" })
	public void testYelpUserLogin(String sUsername, String sPassword) {
		System.out.println("The userName is: " + sUsername);
		System.out.println("The password is: " + sPassword);
		yPage = new YelpHomePage(driver);
		yPage.launchHomePage(YelpHomePage);

		// Locators: id, xpath, css selector, name
		// driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(sUsername);
		// driver.findElement(By.id("email")).sendKeys(sUsername);
		//driver.findElement(By.id("pass")).sendKeys(sPassword);
		// driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
		// driver.findElement(By.name("email")).sendKeys(sUsername);
		// driver.findElement(By.name("pass")).sendKeys(sPassword);
		// driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
		// driver.findElement(By.id("log-in")).click();
		driver.findElement(By.xpath("//a[@class='header-nav_link header-nav_link--log-in js-analytics-click']")).click();
		// driver.findElement(By.id("email")).sendKeys(sUsername);
		driver.findElement(By.xpath("//form[@id='ajax-login']//input[@id='email']")).sendKeys(sUsername);
		// driver.findElement(By.id("password")).sendKeys(sPassword);
		driver.findElement(By.xpath("//form[@id='ajax-login']//input[@id='password']")).sendKeys(sPassword);
	}
	
	@Test
	@Parameters({ "FirstName", "LastName", "Email", "ZipCode" })
	public void testYelpSignUp(String FirstName, String LastName, String Email, Integer ZipCode) {
		System.out.println("The firstName is: " + FirstName);
		System.out.println("The lastName is: " + LastName);
		System.out.println("The email is: " + Email);
		System.out.println("The zipCode is: " + ZipCode);
		yPage = new YelpHomePage(driver);
		yPage.launchHomePage(YelpHomePage);

		driver.findElement(By.xpath("//a[@href='/signup']")).click();
		WebElement element =  driver.findElement(By.id("first_name"));
		element.sendKeys(FirstName);
		// driver.findElement(By.id("first_name")).sendKeys(FirstName);
		driver.findElement(By.id("last_name")).sendKeys(LastName);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("zip")).sendKeys(String.valueOf(ZipCode));
		element.clear();
		element.sendKeys(LastName);
		
		
		// Select selectMonth = new Select(driver.findElement(By.id("month")));
		Select selectMonth = new Select(driver.findElement(By.xpath("//html//div[@class='flow-start signup-visible']//li[1]/select[1]")));
		selectMonth.selectByVisibleText("Mar");
		// Select selectDay = new Select(driver.findElement(By.xpath(".//*[@id = 'day']")));
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByIndex(16);
		// Select selectYear = new Select(driver.findElement(By.xpath(".//*[@id = 'year']")));
		Select selectYear = new Select(driver.findElement(By.id("year")));
		selectYear.selectByValue("1994");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='signup-button']")));
		signUpButton.click();
		
		// driver.findElement(By.id("email")).sendKeys(sUsername);
		// driver.findElement(By.xpath("//form[@id='ajax-login']//input[@id='email']")).sendKeys(sUsername);
		// driver.findElement(By.id("password")).sendKeys(sPassword);
		// driver.findElement(By.xpath("//form[@id='ajax-login']//input[@id='password']")).sendKeys(sPassword);
	}

	@AfterClass
	public void afterClass() {
		// close Firefox browser window
		// driver.close();
	}
}
