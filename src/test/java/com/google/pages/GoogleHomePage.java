package com.google.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.google.framework.GoogleWebDriverImpl;

public class GoogleHomePage {
	GoogleWebDriverImpl driver;
	By homePageTitle = By.xpath("//img[@id='hplogo']");
	By homePageSignIn = By.xpath("//a[@id='gb_70']");
	public static String LogCategory;
	public static Logger logger;

	public void setLogCategory(String LogFile) {
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);
	}

	public void setWebDriver(GoogleWebDriverImpl webDriver) {
		logger.info("START: Set webDriver");
		this.driver = webDriver;
		logger.info("END: Set webDriver");
	}

	public String getHomePageTitleText() {
		logger.info("START: getHomePageTitle");
		System.out.println("comming here");
		logger.info("END: getHomePageTitle");
		return driver.FindElement(homePageTitle).getText();
	}

	public String getHomePageSignInText() {
		logger.info("START: getHomePageSignInText");
		logger.info("END: getHomePageSignInText");
		return driver.getElementText(homePageSignIn);
	}

}
