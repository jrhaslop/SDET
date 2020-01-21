package com.jonathanhaslop.util;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class Reporter {

	public static void afterScenarioFinish(WebDriver driver) {
		driver.quit();
		driver = null;
		end();
	}

	public static void tearDown(Scenario scenario, WebDriver driver) {
		try {
			if (scenario.isFailed()) {
				driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			}
		} catch (org.openqa.selenium.UnhandledAlertException e1) {
			Assert.assertEquals("Alert not handled", null, e1);
		} catch (Exception e) {
			Assert.assertEquals("Class exception was found: " + e.getClass()
					+ " when trying to take snapshot", null, e);
		}
	}

	private static void end() {
		try {
			String paramsReporter = Paths.get(".").toAbsolutePath().normalize().toString()
					+ "\\cucumber-reports\\index.js";
			String[] cmd = { "cmd.exe", "/c", "node.exe", paramsReporter };
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			System.out.println("Error al lanzar cmd");
			e.printStackTrace();
		}
	}

}
