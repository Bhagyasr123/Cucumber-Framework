package stepdefinitions;

import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.common.utils.Base;
import com.cucumber.common.utils.ExtentManager;

import cucumber.api.Scenario;
import cucumber.runtime.CucumberException;
import cucumber.runtime.StepDefinitionMatch;
import gherkin.ast.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {
	public static String reportLocation;
	public static ExtentTest extentTest;
	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
	private int currentStepDefIndex = 0;
    String  currentStepDescr = null;


	@Before(order = 1)
	public void setUp() throws IOException {
		Base.intialize();
		
	}

	@Before(order = 2)
	public static void startTest(Scenario scenario) {
		ExtentManager.startReport();
		ExtentManager.createTest(scenario.getName());
	}


 @AfterStep
	/*
	 * public void testcase(Scenario scenario){
	 * 
	 * for (Step a : scenario.getTestSteps()) {
	 * System.out.println("scenario step = " + a.getText()); } }
	 */
    
	@Test
	public void test() {
		logger.info("Browser is opened");
	}
	
	@After(order = 2)
	public static void endTest(Scenario scenario) throws IOException {
		ExtentManager extent = new ExtentManager(Base.getdriver());
		ExtentManager.generateReport(scenario);
		ExtentManager.closeTestReport();
	}

	@After(order = 1)
	public void tearDown() {
		logger.info("Browser closed");
		Base.quit();
	}
}
