package com.guru99.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class Test99GuruHomePage {

	final static Logger logger = Logger.getLogger("GURU99_TESTS");

	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	
	// Guru99LoginPage objLogin;
	Boolean HomePageLaunch = false;
	Guru99HomePage objHomePage;

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName, String UserName, String Password) throws MalformedURLException {
		logger.info("START: In set-up Method");
		GlobalDataStore.setLogCategory("GURU99_TESTS");
		gds.initParameters();
		// calls the init Method in getWebDriverInstance and gets the WebDriverImpl
		// Object driver..
		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		BankHomePage = GlobalDataStore.Guru99HomePage;
		HomePageLaunch = driver.navigateTo(BankHomePage);
		// objHomePage= new Guru99HomePage(driver);
		// driver.get("http://demo.guru99.com/V4/");
		objHomePage = new Guru99HomePage();
		objHomePage.setLogCategory("GURU99_TESTS");
		objHomePage.setWebDriver(driver);
		logger.info("END: In set-up Method");
	}

	/*
	 * 
	 * This Test verifies the DashBoard Page... It confirms that Page is launched
	 * successfully.
	 */

	@Test // (enabled = false)
	public void test_Home_Page_DashBoard_UserName() {

		logger.info("START: test_Home_Page_DashBoard_UserName");
		// objHomePage.setLogCategory("GURU99_TESTS");

		if (HomePageLaunch == true) {
			String loginPageTitle = objHomePage.getHomePageDashboardUserName();
			logger.info(" The login Title " + loginPageTitle);
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		}
		logger.info("END: test_Home_Page_DashBoard_UserName");
		// Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger
		// id : mgr123"));
	}

	@Test // (enabled = false)
	// verify that it says "Guru99 Bank"
	public void testGenerateAccessText() {

		/*WebElement generateAccessText = driver.FindElement(By.xpath("//span[@style='font-size:18px;font-weight: 700;']"));
		String expectedText = "Steps To Generate Access";
		String actualText = "";
		actualText = generateAccessText.getText();

		logger.info("START: testGenerateAccessText");
		if (HomePageLaunch == true) {
			Assert.assertEquals(actualText, expectedText);
		}
		logger.info("END: testGenerateAccessText");*/
		
		logger.info("START: testGenerateAccessText");

		if (HomePageLaunch == true) {
			String generateAccessTitle = objHomePage.getGenerateAccessText();
			logger.info(" The login Title " + generateAccessTitle);
			Assert.assertTrue(generateAccessTitle.toLowerCase().contains("steps to generate access"));
		}
		logger.info("END: test_Home_Page_DashBoard_UserName");
	}
	
	@AfterClass
	public void teardown() {
		this.driver.quitDriver();
	}
	

}
