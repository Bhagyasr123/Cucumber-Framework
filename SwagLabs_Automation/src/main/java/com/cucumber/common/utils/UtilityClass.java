package com.cucumber.common.utils;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains all the common frequently used methods.
 * 
 * @author bhagyameena
 *
 */
public class UtilityClass {

	public static final int WAIT = 10;
	private static final Logger logger = LoggerFactory.getLogger(UtilityClass.class);

	/**
	 * This method is to send keys on web page.
	 * 
	 * @param driver
	 * @param element the element path where we send the value
	 * @param value   the value which we want to send
	 */
	public static void sendKeys(WebDriver driver, WebElement element, String value) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, WAIT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		} catch (Exception e) {
			logger.error("Some error has been found by sending keys", e);
			fail();
		}
	}

	/**
	 * This method is to click on the element.
	 * 
	 * @param driver
	 * @param element the element path to click on it.
	 */
	public static void clickOnElement(WebDriver driver, WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, WAIT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			logger.error("Some error has been found by clicking the element", e);
			fail();
		}
	}

	/**
	 * This method is to scroll down at the bottom of the page.
	 * 
	 * @param driver
	 */
	public static void scrollDown(WebDriver driver) {
		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			logger.error("Some error has been found by scrolling down", e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is to scroll down the page util the element gets found.
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollDownTillTheElementFound(WebDriver driver, WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, WAIT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			logger.error("Some error has been found by scrolling down till the element found", e);
			fail();
		}
	}
}
