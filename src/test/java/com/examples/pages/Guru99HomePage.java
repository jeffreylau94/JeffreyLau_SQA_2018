package com.examples.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99HomePage {

	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By generateAccessText = By.xpath("//h4[@class='barone']");
	By seleniumDropDown = By.xpath("//html//ul[@class='nav navbar-nav']/li[1]/a[1]");
	public static String LogCategory;
	public static Logger logger;

	public void setLogCategory(String LogFile) {
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);
	}

	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		logger.info("START: Set webDriver");
		this.driver = webDriver;
		logger.info("END: Set webDriver");
	}

	public String getHomePageDashboardUserName() {
		logger.info("START: getHomePageDashboardUserName");
		System.out.println("comming here");
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		logger.info("END: getHomePageDashboardUserName");
		return driver.FindElement(homePageUserName).getText();
		// return driver.getElementText(homePageUserName);
	}

	public String getGenerateAccessText() {
		logger.info("START: getGenerateAccessText");
		logger.info("END: getGenerateAccessText");
		return driver.getElementText(generateAccessText);
	}

	public String clickSeleniumDropDownOnPage() {
		logger.info("START: clickSeleniumDropDownOnPage");
		// WebElement element = driver.FindElement(seleniumDropDown);
		driver.clickElement(element);
		logger.info("END: clickSeleniumDropDownOnPage");

	}

	public int getCountofAllLinks() {
		WebElement element = driver.FindElement(checkSeleniumDropDown);
		driver.clickElement(element);
		List<WebElement> elements = driver.findElements(checkSiblings);
		System.out.println("The elements size: " + elements.size());
		return elements.size();
	}

	public void clickSeleniumSelectElementFromDropDownOnPage(String Text) {
		String Path = "//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()," + "'" + Text + "'" + ")]";
		By checkText = By.xpath(Path);
		WebElement element = driver.FindElement(checkText);
		driver.clickElement(element);
	}

}
