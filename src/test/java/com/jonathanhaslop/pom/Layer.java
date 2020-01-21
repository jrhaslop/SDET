package com.jonathanhaslop.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Layer {

	protected WebDriver driver;

	public Layer(WebDriver driver) {
		this.driver = driver;
	}

	public void waitElement(String selector, int seconds) {
		WebDriverWait wdWait = new WebDriverWait(driver, seconds);
		wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}

	public void waitElements(String selector, int seconds) {
		WebDriverWait wdWait = new WebDriverWait(driver, seconds);
		wdWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector)));
	}

	public WebElement findElement(String selector) {
		WebElement componente = null;
		try {
			componente = driver.findElement(By.cssSelector(selector));
		} catch (Exception e) {
			System.out.println("Unable to find element: " + e.getMessage());
		}
		return componente;
	}

	public WebElement findElement(String selector, int seconds) {
		WebElement componente = null;
		try {
			waitElement(selector, seconds);
			componente = driver.findElement(By.cssSelector(selector));
		} catch (Exception e) {
			System.out.println("Unable to find element: " + e.getMessage());
		}
		return componente;
	}

	public List<WebElement> findElements(String selector) {
		List<WebElement> componentes = null;
		try {
			componentes = driver.findElements(By.cssSelector(selector));
		} catch (Exception e) {
			System.out.println("Unable to find elements: " + e.getMessage());
		}
		return componentes;
	}

	public List<WebElement> findElements(String selector, int seconds) {
		List<WebElement> componentes = null;
		try {
			waitElements(selector, seconds);
			componentes = driver.findElements(By.cssSelector(selector));
		} catch (Exception e) {
			System.out.println("Unable to find element: " + e.getMessage());
		}
		return componentes;
	}

	public void type(String inputTxt, WebElement element) {
		element.sendKeys(inputTxt);
	}

	public void click(WebElement element) {
		element.click();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void visit(String url) {
		this.driver.get(url);
	}
}

