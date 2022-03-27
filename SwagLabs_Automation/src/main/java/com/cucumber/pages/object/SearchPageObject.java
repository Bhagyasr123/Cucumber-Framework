package com.cucumber.pages.object;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/** 
 * Elements related to google page screen
 * @author bhagyameena
 *
 */
public class SearchPageObject {
	
	private static SearchPageObject obj;
	
	private SearchPageObject() {}

	public static SearchPageObject getInstance() {
		obj = new SearchPageObject();
		return obj;
	}
	
	@FindBy(xpath = "//input[@title='Search']")
	public WebElement googleSearchBox;
	
	@FindBy(name = "btnK")
	public WebElement googleSearchBtn;
	
	@FindBy(xpath = "//a[text()='Images']")
	public WebElement imageSearchResult;

	@FindBy(xpath = "//img[@class='rg_i Q4LuWd']")
	public WebElement images;

	@FindBy(xpath = "//input[@value='Show more results']")
	public WebElement showMoreResultBtn;
	
	@FindBy(xpath = "//div[@class='OuJzKb Yu2Dnd']")
	public WebElement endOFTheSearchResult;
	
	@FindBy(xpath = "//div[@jsaction='dtRDof:s370ud;v03O1c:cJhY7b;']")
	public List<WebElement> listOfImageResult;
	
	@FindBy(xpath = "//h2[normalize-space()='Related images']")
	public WebElement relatedImages;
}
