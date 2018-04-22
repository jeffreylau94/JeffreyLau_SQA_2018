package com.examples.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.examples.config.GlobalDataStore;
import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99LoginPage {
	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	// By generateAccessText = By.xpath("//h4[@class='barone']");
	public static String LogCategory;
	public static Logger logger;
	By strUserName = By.xpath("//input[@type='text']");
	By strPassword = By.xpath("//input[@type='password']");
	By login = By.xpath("//input[@type='submit']");

public String loginToGuru99(By strUserName, By strPassword) {
		logger.info("START: getGenerateAccessText");
		logger.info("END: getGenerateAccessText");
		// strUserName = driver.FindElement(strUserName);
		return driver.FindElement(homePageUserName).getText();
	}

	public void setUserName(String Guru99UserName) {
		driver.sendKeys(driver.FindElement(strUserName), Guru99UserName);
	}

	// Set password in password textbox
	public void setPassword(String Guru99Password) {
		driver.sendKeys(driver.FindElement(strPassword), Guru99Password);
	}

	// Click on login button
	public void clickLogin() {
		driver.FindElement(login).click();
		// driver.clickElement(driver.FindElement(login));
	}

}
