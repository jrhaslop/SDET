package com.jonathanhaslop.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Layer {

	private final String SEARCH_BOX = "#search-key";
	private final String SEARCH_SUBMIT = "input.search-button";
	private final String NEXT_PAGE_LIST = ".next-pagination-list > button";
	private final String ITEMS_LIST = ".product-list li";
	private final String NEXT_PAGE = ".list-pagination .next-next";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void searchItem(WebDriver driver, String item) {
		handleOverlay(driver);
		typeSearchBox(item);
		searchSubmit();
	}

	public void typeSearchBox(String item) {
		type(item, findElement(SEARCH_BOX));
	}

	public void searchSubmit() {
		click(findElement(SEARCH_SUBMIT));
	}

	public List<WebElement> getNextPageList() {
		return findElements(NEXT_PAGE_LIST);
	}

	public void NextPage(WebDriver driver) {
		click(findElement(NEXT_PAGE));
	}

	public List<WebElement> getProductList() {
		return findElements(ITEMS_LIST);
	}

	public boolean hasAtLeastOneItem() {
		return getProductList().size() >= 1;
	}

}
