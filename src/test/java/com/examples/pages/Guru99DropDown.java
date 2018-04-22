package com.examples.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.guru99.framework.Guru99WebDriverImpl;

public class Guru99DropDown {

		Guru99WebDriverImpl driver;
		By navBar = By.xpath("//ul[@class='nav navbar-nav']");
		By seleniumTextBox = By.xpath("//html//ul[@class='nav navbar-nav']/li[1]/a[1]");
		By dragdropTextBox = By.xpath("//a[@href='../../test/drag_drop.html']");
		public static String LogCategory;
		public static Logger logger;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
