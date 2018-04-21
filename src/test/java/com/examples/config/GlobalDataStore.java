package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GlobalDataStore {

	private Properties configFile = new Properties();
	public static String FBHomePage;
	public static String YelpHomePage;
	public static String GoogleHomePage;
	public static String GeckoDriver_MAC;
	public static String GeckoDriver_WIN;
	public static String ChromeDriver_MAC;
	public static String ChromeDriver_WIN;
	public static String Guru99HomePage;
	public static String Guru99UserName;
	public static String Guru99Password;
	public static String LogCategory;
	public static Logger logger;

	public static void setLogCategory(String LogFile) {
		LogCategory = LogFile;
		logger = Logger.getLogger(LogCategory);
	}

	public void initParameters() {

		 logger.info("START: Global Data Store initParameters Method");

		String baseDir = System.getProperty("user.dir");
		String propFile = "selenium.properties";
		FileInputStream fis = null;

		try {
			// /Users/jeffreylau/eclipse-workspace/SQA_Selenium_Project_2018
			fis = new FileInputStream(baseDir + "/" + "src/test/resources/" + propFile);
			configFile.load(fis);

			GeckoDriver_MAC = configFile.getProperty("GECKO_DRIVER_MAC");
			ChromeDriver_MAC = configFile.getProperty("CHROME_DRIVER_MAC");
			System.out.println("GeckoDriver_MAC Value is: " + GeckoDriver_MAC);
			System.out.println("ChromeDriver_MAC Value is: " + ChromeDriver_MAC);
			/*GeckoDriver_WIN = configFile.getProperty("GECKO_DRIVER_WIN");
			System.out.println("GeckoDriver_WIN Value is: " + GeckoDriver_WIN);*/
			FBHomePage = configFile.getProperty("BASE_URL");
			YelpHomePage = configFile.getProperty("YELP_URL");
			Guru99HomePage = configFile.getProperty("GURU99_HOMEPAGE");
			GoogleHomePage = configFile.getProperty("GOOGLE_URL");
			/*Guru99UserName = configFile.getProperty("GURU99USERNAME");
			Guru99Password = configFile.getProperty("GURU99PASSWORD");*/
		} catch (FileNotFoundException e) {
			System.out.println("File not Found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
		}
		 logger.info("END:Global Data Store initParameters Method");
	}
}