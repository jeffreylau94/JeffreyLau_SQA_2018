package com.guru99.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class Test99GuruLoginPage {

	final static Logger logger = Logger.getLogger("GURU99_TESTS");
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	Boolean HomePageLaunch = false;
	Guru99HomePage objHomePage;
	Guru99HomePage objLoginPage;
	
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
	
	@Parameters({ "UserName", "Password" })
	@Test
	public void testGuru99Login (String UserName, String Password) {
		logger.info("In Test Login Method");
		driver.navigateTo(BankHomePage);
		objLoginPage.loginToGuru99(UserName, Password);
		
	}
	
}
