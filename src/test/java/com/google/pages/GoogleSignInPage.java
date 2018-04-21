package com.google.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.google.framework.GoogleWebDriverImpl;
import com.guru99.framework.Guru99WebDriverImpl;

public class GoogleSignInPageClick {
	GoogleWebDriverImpl driver;
	public static String LogCategory;
	public static Logger logger;
	By homePageSignIn = By.xpath("//a[@id='gb_70']");
	By strUserName = By.xpath("//input[@id='identifierId']");
	By strPassword = By.xpath("//input[@type='password']");

	/*public String signIntoGoogle(String strUserName, String strPassword) {
		logger.info("START: getGenerateAccessText");
		logger.info("END: getGenerateAccessText");
		strUserName = driver.FindElement(strUserName);
		return driver.FindElement(homePageUserName).getText();
	}*/

	public void setUserName(By strUserName) {
		driver.FindElement(strUserName);
		// driver.sendKeys(driver.FindElement(strUserName), strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		// driver.FindElement(password99Guru).sendKeys(GlobalDataStore.Password);
		driver.sendKeys(driver.FindElement(password99Guru), strPassword);
	}

	// Click on login button
	public void clickLogin() {
		// driver.FindElement(login).click();
		driver.enterElement(driver.FindElement(login));
	}

}
