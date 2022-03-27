package com.cucumber.common.utils;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;

public class Base {

	public static WebDriver driver = null;
	public static LoadProperties load = LoadProperties.getReadProp();
	private static Properties prop = load.loadProp();
	public static String URL;

	public static void intialize() throws IOException {
		load.loadProp();
		ReadProperties prop = ReadProperties.getReadProp();
		URL = prop.getProperty("url");
		DriverFactory factory = DriverFactory.getInstance();
		factory.getBrowser();
		driver = factory.getDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public static Properties getProp() {
		return prop;
	}

	/**
	 * This method is to return the intialized driver.
	 * @return driver
	 */
	public static WebDriver getdriver() {
		return driver;
	}

	public static void quit() {
		driver.quit();
		driver = null;
	}

	public static void close() {
		driver.close();
		driver = null;
	}

}
