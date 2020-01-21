package com.jonathanhaslop.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	public void waitUntilElementIsNotVisible(WebElement element, int seconds) {
		WebDriverWait wdWait = new WebDriverWait(driver, seconds);
		wdWait.until(ExpectedConditions.invisibilityOf(element));
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
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handleOverlay(WebDriver driver) {
		try {
			sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return document.querySelector('div.ui-mask').remove();");
			js.executeScript("return document.querySelector('.ui-newuser-layer-dialog').remove();");
		} catch (Exception e) {
			System.out.println("");
		}
	}
	
	public void turnOffImplicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public void turnOnImplicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
}

