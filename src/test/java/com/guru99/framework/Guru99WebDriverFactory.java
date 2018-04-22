package com.guru99.framework;

import java.net.MalformedURLException;

public class Guru99WebDriverFactory {

	/**
	 * Get a Web Driver instance.
	 * 
	 * @return An instance of a web webDriver.
	 * @param BrowserName
	 * @throws MalformedURLException
	 */

	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {

		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
		webDriver.init(BrowserName);
		// webDriver.intSauceLabs(BrowserName);
		// webDriver.init(BrowserName);

		return webDriver;
	}

}
