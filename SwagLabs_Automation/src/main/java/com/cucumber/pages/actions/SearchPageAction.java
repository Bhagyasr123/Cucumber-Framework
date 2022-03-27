package com.cucumber.pages.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.common.utils.Base;
import com.cucumber.common.utils.UtilityClass;
import com.cucumber.pages.object.SearchPageObject;
import com.google.common.collect.Lists;
/** 
 * This Page action class contains actions to be performed on google page - page actions
 * always has to be singleton
 * @author bhagyameena
 *
 */
public class SearchPageAction extends Base{
	SearchPageObject searchObj = SearchPageObject.getInstance();

	public SearchPageAction() {
		PageFactory.initElements(getdriver(), searchObj);
	}

	public void searchBox(String value) throws InterruptedException {
		UtilityClass.sendKeys(getdriver(), searchObj.googleSearchBox, value);
		Thread.sleep(3000);
	}

	public void clickOnGoogleSearchBtn() throws InterruptedException {
		UtilityClass.clickOnElement(getdriver(), searchObj.googleSearchBtn);
		Thread.sleep(3000);
	}

	public void clickOnImageBtn() throws InterruptedException {
		UtilityClass.clickOnElement(getdriver(), searchObj.imageSearchResult);
		Thread.sleep(3000);
	}
	public void scrolltoBottom() throws InterruptedException {
		UtilityClass.scrollDown(Base.getdriver());
		UtilityClass.clickOnElement(Base.getdriver(), searchObj.showMoreResultBtn);
		UtilityClass.scrollDown(Base.getdriver());
		List<WebElement> allImages= searchObj.listOfImageResult;
		WebElement lastImage= Lists.reverse(allImages).get(0);
		UtilityClass.clickOnElement(getdriver(), lastImage);
		Thread.sleep(3000);
	}

	public boolean relatedButtonIsDiaplayed() {
		boolean result = searchObj.relatedImages.isDisplayed();
		return result;
	}
}
