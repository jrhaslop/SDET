package com.jonathanhaslop.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonDriver {

	private SingletonDriver() {
	}

	private static ChromeOptions options(WebDriver driver) {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("start-maximized");
		return options;
	}

	public static WebDriver getSingletonInstance(WebDriver driver) {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/WebDriver/chromedriver.exe");
			driver = new ChromeDriver(options(driver));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

}