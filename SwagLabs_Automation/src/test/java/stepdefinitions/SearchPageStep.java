package stepdefinitions;

import org.apache.commons.lang3.exception.ExceptionUtils;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import com.aventstack.extentreports.Status;
import com.cucumber.common.utils.Base;
import com.cucumber.common.utils.ExtentManager;
import com.cucumber.pages.actions.SearchPageAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchPageStep extends Base {

	SearchPageAction pageActionObject = new SearchPageAction();
	private static final Logger logger = LoggerFactory.getLogger(SearchPageStep.class);

	@Given("^user is on google page$")
	public void user_is_on_login_page() throws Throwable {
		logger.info("User is on Google Home Page");
		ExtentManager.extentTest.log(Status.PASS, "User is on Google Home Page");
	}

	@When("^user enter '(.*)' in search box$")
	public void user_enter_standard_user_and_secret_sauce(String value) throws Throwable {
		logger.info("User enter the " + value + " in searchbox");
		try {
			pageActionObject.searchBox(value);
			ExtentManager.extentTest.log(Status.PASS, "User enter the " + value + " in searchbox");
		} catch (Exception e) {
			ExtentManager.extentTest.log(Status.FAIL, "User enter the \" + value + \" in searchbox");
			ExtentManager.extentTest.log(Status.ERROR, ExceptionUtils.getStackTrace(e));
			throw (e);
			}
	}

	@When("^click on google search button$")
	public void click_on_google_search_button() throws Throwable {
		logger.info("User click on Google Search Button");
		try {
		pageActionObject.clickOnGoogleSearchBtn();
		ExtentManager.extentTest.log(Status.PASS, "User click on Google Search Button");
		}catch (Exception e) {
			ExtentManager.extentTest.log(Status.FAIL, "User click on Google Search Button");
			ExtentManager.extentTest.log(Status.ERROR, ExceptionUtils.getStackTrace(e));
			throw (e);
			}
	}

	@When("^user click on image result$")
	public void user_click_on_image_result() throws Throwable {
		logger.info("User click on Image Button present on search result page");
		try {
		pageActionObject.clickOnImageBtn();
		ExtentManager.extentTest.log(Status.PASS, "User click on Image Button present on search result page");
		}catch (Exception e) {
			ExtentManager.extentTest.log(Status.FAIL, "User click on Image Button present on search result page");
			ExtentManager.extentTest.log(Status.ERROR, ExceptionUtils.getStackTrace(e));
			throw (e);
			}
	}

	@When("^user scroll down till the bottom of result page$")
	public void user_scroll_down_till_the_bottom_of_result_page() throws Throwable {
		logger.info("User scroll down till the bottom of result page");
		try {
		pageActionObject.scrolltoBottom();
		ExtentManager.extentTest.log(Status.PASS, "User scroll down till the bottom of result page");
		}catch (Exception e) {
			ExtentManager.extentTest.log(Status.FAIL, "User scroll down till the bottom of result page");
			ExtentManager.extentTest.log(Status.ERROR, ExceptionUtils.getStackTrace(e));
			throw (e);
			}
	}

	@Then("^user click on the last image available$")
	public void user_click_on_the_last_image_available() throws Throwable {
		logger.info("User click on the last image available");
		boolean result = pageActionObject.relatedButtonIsDiaplayed();
		try {
			Assert.assertEquals(false, result);
			ExtentManager.extentTest.log(Status.PASS, "User click on the last image available");
		} catch (AssertionError e) {
			ExtentManager.extentTest.log(Status.FAIL, "User click on the last image available");
			ExtentManager.extentTest.log(Status.ERROR, ExceptionUtils.getStackTrace(e));
			throw (e);
		}
	}
}
