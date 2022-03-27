package com.cucumber.common.utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
/** 
 * This Singletone DriverFactory class is to intialize the driver and WebDriver manager.
 * @author bhagyameena
 *
 */
public class DriverFactory {
	private static DriverFactory factory = null;
	private static WebDriver driver;
	public static String BROWSER;
	public static String URL;

	private DriverFactory() {
	}

	public static DriverFactory getInstance() {
		if (factory == null) {
			factory = new DriverFactory();
		}
		return factory;
	}

	/**
	 * This method is to intialize the WebDriver manager.
	 */
	public void getBrowser() {
		ReadProperties prop = ReadProperties.getReadProp();
		BROWSER = prop.getProperty("browserName");
		if (driver == null) {
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("FF")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("--chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				driver = new ChromeDriver(options);
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
	}

	/** 
	 * This method is to get driver from DriverFactory Class
	 * @return driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

}
