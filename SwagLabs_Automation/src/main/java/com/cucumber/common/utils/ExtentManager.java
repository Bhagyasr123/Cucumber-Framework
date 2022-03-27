package com.cucumber.common.utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.Scenario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

/**
 * This class implements extent report
 * 
 * @author bhagyameena
 *
 */
public class ExtentManager {
	private static WebDriver driver;

	public ExtentManager(WebDriver driver) {
		this.driver = Base.getdriver();
	}

	public static ExtentTest extentTest;
	public static ExtentReports extentReports;
	public static ExtentHtmlReporter extentHtmlReporter;
	private static final Logger logger = LoggerFactory.getLogger(ExtentManager.class);

	/**
	 * This method is to start reporting
	 */
	public static void startReport() {
		String classPath = System.getProperty("user.dir");
		extentHtmlReporter = new ExtentHtmlReporter(classPath + "\\target\\ExtentReport.html");
		extentHtmlReporter.config().setReportName("CucumberReport");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("User", "Bhagyashree");
	}

	/**
	 * This method is to create the test in extent report
	 * 
	 * @param testcase
	 */
	public static void createTest(String testcase) {
		extentTest = extentReports.createTest(testcase);

	}

	/**
	 * This method is to start the generating report by scenario status.
	 * 
	 * @param scenario
	 * @throws IOException
	 */
	public static void generateReport(Scenario scenario) throws IOException {

		if (scenario.getStatus().toString().equalsIgnoreCase("skiped")) {
			extentTest.log(Status.SKIP, scenario.getName());
			logger.info("Test Case is skipped");
		} else if (scenario.getStatus().toString().equalsIgnoreCase("failed")) {
			extentTest.addScreenCaptureFromPath(captureScreenShot(driver));
			logger.info("Screenshot attached");
		}
	}

	/**
	 * This method helps to capture the screenshot for failed scenario.
	 * 
	 * @param driver
	 * @param scenario
	 * @return screenshotPath
	 * @throws IOException
	 */
	private static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/target/Screenshots/" + fileName + ".png";
		File finalDestination = new File(screenshotPath);
		FileUtils.copyFile(source, finalDestination);
		return screenshotPath;
	}

	/**
	 * This method will close the report
	 */
	public static void closeTestReport() {
		extentReports.flush();
	}
}
