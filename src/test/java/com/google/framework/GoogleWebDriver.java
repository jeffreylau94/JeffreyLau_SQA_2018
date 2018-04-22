package com.google.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface GoogleWebDriver {

		void init(String Browser);
		
		Boolean navigateTo(final String relativeURL);
		
		void sendKeys(WebElement element, String name);
		void clickElement(WebElement element);
		
		String getElementText(By element);
		WebElement FindElement(By element);

		void quitDriver();
}
