package com.google.framework;

import java.net.MalformedURLException;


public class GoogleWebDriverFactory {

		/**
		 * Get a Web Driver instance.
		 * 
		 * @return An instance of a web webDriver.
		 * @param BrowserName
		 * @throws MalformedURLException
		 */

		public static GoogleWebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {

			GoogleWebDriverImpl webDriver = new GoogleWebDriverImpl();
			webDriver.init(BrowserName);
			// webDriver.intSauceLabs(BrowserName);
			// webDriver.init(BrowserName);

			return webDriver;
		}
}
