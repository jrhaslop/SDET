package com.jonathanhaslop.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Layer {

	private final String SEARCH_BOX = "#search-key";
	private final String SEARCH_SUBMIT = "input.search-button";
	private final String NEXT_PAGE_LIST = ".next-pagination-list > button";
	private final String ITEMS_LIST = ".product-list li";
	private final String NEXT_PAGE = ".list-pagination .next-next";
	private String listItem;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void searchItem(WebDriver driver, String item) {
		handleOverlay(driver);
		typeSearchBox(item);
		searchSubmit();
	}

	public void setListItem() {
		listItem = "[algo-exp-id=\"" + getFirstListElementID() + "\"]";
	}

	public String getlistItem() {
		return listItem;
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
		turnOffImplicitWaits(driver);
		while (findElements(NEXT_PAGE).size() == 0) {
			scrollDown(driver);
		}
		try {
			if (findElements(".next-dialog-close").size() != 0)
				click(findElement(".next-dialog-close"));
		} catch (Exception e) {
			System.out.println("");
		}
		turnOnImplicitWaits(driver);
		setListItem();
		click(findElement(NEXT_PAGE));
	}

	public List<WebElement> getProductList() {
		return findElements(ITEMS_LIST);
	}

	public boolean hasAtLeastOneItem() {
		return getProductList().size() >= 1;
	}

	public String getFirstListElementID() {
		return getProductList().get(0).findElement(By.cssSelector("div")).getAttribute("algo-exp-id");
	}

	public void waitRelatedNextPage() {
		waitUntilElementIsNotVisible(findElement(listItem), 2);
	}

}
