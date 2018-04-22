package com.facebook.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebDriver.Options;
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
// import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
// import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;

import junit.framework.Assert;

public class FBTestHomePage {
	GlobalDataStore gds = new GlobalDataStore();
	String GecKoDriver;
	WebDriver driver = null;
	String HomePage;
	String ChromeDriver;
	// String SafariDriver;
	FaceBookHomePage FBPage;
	// static String

	@Parameters({ "BrowserName" })
	@BeforeClass
	// public void setUp() {
	public void setUp(String BrowserName) {
		// public void setUp(String BrowserName) {
		// @Optional only works with @Parameters, which can be specified in the XML file
		// String BrowserName = "Firefox";
		// String BrowserName = "Chrome";
		System.out.println("The Browser Name is: " + BrowserName);
		gds.initParameters();
		GecKoDriver = GlobalDataStore.GeckoDriver_MAC;
		HomePage = GlobalDataStore.FBHomePage;
		System.out.println("The HomePage is: " + HomePage);
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
	public void testFaceBookTitleOnPageLoad() {
		// String baseUrl = "http://facebook.com;
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";

		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		actualTitle = FBPage.getLoginTitle(driver);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(enabled = false)
	@Parameters({ "sUsername", "sPassword" })
	public void testUserLogin(String sUsername, String sPassword) {
		System.out.println("The userName is: " + sUsername);
		System.out.println("The password is: " + sPassword);
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);

		// Locators: id, xpath, css selector, name
		// driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(sUsername);
		driver.findElement(By.id("email")).sendKeys(sUsername);
		driver.findElement(By.id("pass")).sendKeys(sPassword);
		// driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
		// driver.findElement(By.name("email")).sendKeys(sUsername);
		// driver.findElement(By.name("pass")).sendKeys(sPassword);
		// driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
		// driver.findElement(By.id("loginbutton")).click();
	}

	@Test(enabled = false)
	public void verifyTextforSignUp() {
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		// driver.findElement(By.id("email")).
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement signUpElement = driver.findElement(By.xpath(("//h2[contains(text(), 'Sign Up')]")));
		// WebElement element1 = driver.findElement(By.xpath("//div[contains(text"))
		// div[contains(text(), 'What\'s your name?')]
		// System.out.println("The text " + element.getText());
		String expectedSignUpText = "Sign Up";
		String actualSignUpText = "";
		actualSignUpText = signUpElement.getText();
		System.out.println("The actualSignUpText is: " + actualSignUpText);
		Assert.assertEquals(actualSignUpText, expectedSignUpText);
	}

	@Test(enabled = false)
	public void verifyTextforCreateNewAccount() {
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement newAccountElement = driver.findElement(By.xpath(("//h2[contains(text(), 'Sign In')]")));
		System.out.println("The text " + newAccountElement.getText());
	}

	@Test(enabled = false)
	public void verifyConnectwithFriendsText() {
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		// WebElement connectFriendsElement =
		// driver.findElement(By.xpath(("//h2[contains(text(), 'Connect with
		// Friends')]")));
		WebElement connectFriendsElement = driver
				.findElement(By.xpath("//h2[contains(text(), 'Connect with friends')]"));
		System.out.println("The element is: " + connectFriendsElement.getText());
		// String expectedConnectFriendsText = "Sign Up";
		// String actualConnectFriendsText = "";
		// actualConnectFriendsText = connectFriendsElement.getText();
		// System.out.println("The actualSignUpText is: " + actualConnectFriendsText);
		// Assert.assertEquals(actualConnectFriendsText, expectedConnectFriendsText);
		Assert.assertTrue(connectFriendsElement.getText().contains("Connect with friends"));
		// boolean contains =
		// actualConnectFriendsText.contains(expectedConnectFriendsText);
		// System.out.println(contains);
	}

	@Test (enabled = false)
	public void verifyForgotAccountLink() {
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		WebElement link = driver.findElement(By.linkText("Forgot account?"));
		System.out.println("The link text is: " + link);
		// driver.findElement(By.linkText("Forgot account?")).click();
		link.click();
		String forgetAccountNewPageTitle = FBPage.getLoginTitle(driver);
		System.out.println("The title of the new page is: " + forgetAccountNewPageTitle);
		String newPageTitle = "Forgot Password | Can't Log In | Facebook";
		Assert.assertEquals(newPageTitle, forgetAccountNewPageTitle);
	}

	@Test // (enabled = false)
	@Parameters({ "firstName", "lastName", "email" })
	public void testNewAccountFields(String firstName, String lastName, String email) {
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		// driver.findElement(By.name("websubmit")).click(); - order of commands doesn't
		// really matter in this case
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("reg_email__")).sendKeys(email);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);

		// Trying to select Birthday from drop down menu:
		// driver.findElement(By.xpath("//div[contains(text(), 'Birthday')]"));		// not necessary
		// Select selectMonth = new Select(driver.findElement(By.xpath(".//*[@id = 'month']")));
		Select selectMonth = new Select(driver.findElement(By.id("month")));
		selectMonth.selectByVisibleText("Mar");
		// Select selectDay = new Select(driver.findElement(By.xpath(".//*[@id = 'day']")));
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByIndex(16);
		// Select selectYear = new Select(driver.findElement(By.xpath(".//*[@id = 'year']")));
		Select selectYear = new Select(driver.findElement(By.id("year")));
		selectYear.selectByValue("1994");

		// Different ways to select Gender - either by the text field or the radio button
		// (1)
		driver.findElement(By.xpath("//label[contains(text(), 'Male')]")).click();
		
		// (2) 
		// changing the wait time from default of 30 to 10
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Female')]")));
		// expected conditions are for some elements that need some time until something shows up
		element.click();
		
		// (3) 
		// clicking the radio button rather than the text for Male
		driver.findElement(By.xpath("//input[@type = 'radio' and @name = 'sex' and @value = '2']")).click();

		// driver.findElement(By.name("websubmit")).click();
		// better way to click the submit button
		WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create Account')]")));
		signUpButton.click();
	}

	@AfterClass
	public void afterClass() {
		// close Firefox browser window
		// driver.close();
	}

}
